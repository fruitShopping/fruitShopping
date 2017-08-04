package com.fruit.shiro;

import com.fruit.common.utils.Servlets;

import java.util.Set;
import com.fruit.entity.sys.User;
import com.fruit.service.sys.SystemService;

import com.fruit.service.sys.PermissionsService;
import com.fruit.util.LogUtils;
import com.fruit.util.UserUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 登录验证
 * Created by zyming on 2017/08/04
 */
public class ShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private PermissionsService permissionsService;
    @Autowired
    private SystemService systemService;

    /**
     * 在认证时使用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("--- MyShiroRealm doGetAuthenticationInfo 登录---");
        String username = (String) token.getPrincipal();
        if (logger.isDebugEnabled()) {
            logger.debug("login submit, active session size: {}, username: {}", username);
        }


        User user = permissionsService.findByUsername(username);
        if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if (Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //auth name
        );
        return authenticationInfo;
    }

    /**
     * 获取权限授权信息，如果缓存中存在，则直接从缓存中获取，否则就重新获取， doGetAuthenticationInfo成功后调用
     * 在认证后使用
     */
    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        logger.info("--- MyShiroRealm getAuthorizationInfo 获取权限授权信息---");
        if (principals == null) {
            logger.debug("principals为空..");
            return null;
        }
        try {//从缓存总获取身份信息
            AuthorizationInfo info = (AuthorizationInfo) UserUtils.getCache(UserUtils.CACHE_AUTH_INFO);
            if (info == null) {
                logger.debug("info为空..");
                info = doGetAuthorizationInfo(principals);
                if (info != null) {
                    UserUtils.putCache(UserUtils.CACHE_AUTH_INFO, info);
                }
            }
            return info;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在鉴别权限的时候使用
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //验证用户是否被记忆，user有两种含义：Subject subject = SecurityUtils.getSubject();
        //1) 一种是成功登录的（subject.isAuthenticated() 结果为true）；
       // 2) 另外一种是被记忆的（subject.isRemembered()结果为true）。

        logger.info("--- MyShiroRealm doGetAuthorizationInfo 鉴权---");
        String username = (String) principals.getPrimaryPrincipal();
        logger.info("principals.getPrimaryPrincipal:"+username);
        SimpleAuthorizationInfo authorizationInfo =null;
        try {//从缓存总获取身份信息
            authorizationInfo = (SimpleAuthorizationInfo) UserUtils.getCache(UserUtils.CACHE_AUTH_INFO);
            if (authorizationInfo == null) {
                logger.debug("authorizationInfo为空..");
                authorizationInfo = new SimpleAuthorizationInfo();
                Set<String> roles = permissionsService.findRoles(username);
                Set<String> permissions = permissionsService.findPermissions(username);
                permissions.add("/back/**");
                logger.debug("roles=" + roles.toString());
                logger.debug("permissions=" + permissions.toString());

                authorizationInfo.setRoles(roles);
                authorizationInfo.setStringPermissions(permissions);

                UserUtils.putCache(UserUtils.CACHE_AUTH_INFO, authorizationInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = permissionsService.findByUsername(username);
        // 更新登录IP和时间
        systemService.updateUserLoginInfo(user);
        // 记录登录日志
        LogUtils.saveLog(Servlets.getRequest(), "系统登录");

        return authorizationInfo;
    }
}