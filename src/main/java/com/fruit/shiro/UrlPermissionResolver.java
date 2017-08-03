package com.fruit.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zyming on 2017/8/1.
 * 在 Shiro 中，权限被转化为一种字符串描述（字符串分级表示，称之为 WildcardPermission），
 * 从而将权限转化为类似于对象 equals 的操作（Shiro 中的 implies 方法）
 * Shiro 的 Session 是独立的，其目的是做到环境无关
 * 权限传递结构为：Permission -> Role -> User
 */
public class UrlPermissionResolver implements PermissionResolver {
    private static final Logger logger = LoggerFactory.getLogger(UrlPermissionResolver.class);

    /**
     * subject.isPermitted(url) 中传入的字符串
     * 和自定义 Realm 中传入的权限字符串集合都要经过这个 resolver
     * @param url
     * @return Permission
     */
    @Override
    public Permission resolvePermission(String url) {
        logger.debug("url => " +url);

        if(url.startsWith("/")){
            return new UrlPermission(url);//资源权限
        }
        return new WildcardPermission(url);//细粒度权限
    }
}
