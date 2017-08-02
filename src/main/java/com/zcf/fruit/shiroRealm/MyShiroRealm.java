package com.zcf.fruit.shiroRealm;

import com.zcf.fruit.common.utils.Servlets;
import java.util.Set;
import com.zcf.fruit.entity.sys.User;
import com.zcf.fruit.service.SystemService;
import com.zcf.fruit.service.authuser.AuthUserService;
import com.zcf.fruit.util.LogUtils;
import com.zcf.fruit.util.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * 登录验证
 * Created by zjj-ideapad on 2015/3/26.
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private AuthUserService authUserService;
    @Autowired
    private SystemService systemService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("--- MyShiroRealm doGetAuthorizationInfo 鉴权---");
        String username = (String)principals.getPrimaryPrincipal();
        logger.info(username+">>>>>>>>>>>>>>>>>");

        //处理session
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表

        if (sessions.size() > 0){
            // 如果是登录进来的，则踢出已在线用户
            if (UserUtils.getSubject().isAuthenticated()){
                for (Session session : sessions){
                    //清除该用户以前登录时保存的session
                    if(username.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) {
                        sessionManager.getSessionDAO().delete(session);
                    }
                }
            }else{
                // 记住我进来的，并且当前用户已登录，则退出当前用户提示信息。
                UserUtils.getSubject().logout();
                throw new AuthenticationException("msg:账号已在其它地方登录，请重新登录。");
            }
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles=authUserService.findRoles(username);
        Set<String> permissions=authUserService.findPermissions(username);
        logger.debug(roles.toString());
        logger.debug(permissions.toString());
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        User user =authUserService.findByUsername(username);
        // 更新登录IP和时间
        systemService.updateUserLoginInfo(user);
        // 记录登录日志
        LogUtils.saveLog(Servlets.getRequest(), "系统登录");

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("--- MyShiroRealm doGetAuthenticationInfo 登录---");
        String username = (String) token.getPrincipal();
        if (logger.isDebugEnabled()){
            logger.debug("login submit, active session size: {}, username: {}", username);
        }


        User user = authUserService.findByUsername(username);
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
     * 获取权限授权信息，如果缓存中存在，则直接从缓存中获取，否则就重新获取， 登录成功后调用
     */
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            return null;
        }

        AuthorizationInfo info = (AuthorizationInfo) UserUtils.getCache(UserUtils.CACHE_AUTH_INFO);;

        System.out.print(info == null);
        if (info == null) {
            info = doGetAuthorizationInfo(principals);
            if (info != null) {
                UserUtils.putCache(UserUtils.CACHE_AUTH_INFO, info);
            }
        }

        return info;
    }


    /**
     * 授权用户信息
     */
//    public static class Principal implements Serializable {
//
//        private static final long serialVersionUID = 1L;
//
//        private long id; // 编号
//        private String username; // 登录名
//        private String realName; // 姓名
//
////		private Map<String, Object> cacheMap;
//
//        public Principal(User sys) {
//            this.id = sys.getId();
//            this.username = sys.getUsername();
//            this.realName = sys.getRealName();
//        }
//
//        public long getId() {
//            return id;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public String getRealName() {
//            return realName;
//        }
//
//        /**
//         * 获取SESSIONID
//         */
//        public String getSessionid() {
//            try{
//                return (String) UserUtils.getSession().getId();
//            }catch (Exception e) {
//                return "";
//            }
//        }
//
//    }
}
