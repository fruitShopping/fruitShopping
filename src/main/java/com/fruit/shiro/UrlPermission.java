package com.fruit.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by you on 17-8-3.
 */
// WildcardPermission 是 Shiro 的精妙之处，我们可以将权限表示成字符串，这样对权限的控制可以不拘泥于物理存储，
// 比如对 messagge 类具有修改和删除权限可以标识为：message:update,delete:*，其中‘ * ’表示所有；第一级分隔符为‘ : ’；第二级分隔符为‘ , ’，
// 而对于权限字符串的解释完全可以由应用自己来定。
// 如果要比较权限字符串，可以使用 permission1.implies(permission2)，它分别比较对应位置的字符串，在如下情况中，结果会返回 true：
//  permission1 中的子串有 * 或 permission1 子串 ==permission2 子串；
//  permission1 无子串，permission2 有；
//  permission1 有子串，permission2 无，permission1 的所有子串都是 *。

class UrlPermission implements Permission {
    private static final Logger logger = LoggerFactory.getLogger(UrlPermission.class);
    // 在 Realm 的授权方法中,由数据库查询出来的权限字符串
    private String url;

    public UrlPermission(String url){
        this.url = url;
    }

    /**
     * 一个很重要的方法,用户判断 Realm 中设置的权限和从数据库或者配置文件中传递进来的权限信息是否匹配
     * 如果 Realm 的授权方法中，一个认证主体有多个权限，会进行遍历，直到匹配成功为止
     * this.url 是在遍历状态中变化的
     *
     * urlPermission.url 是从 subject.isPermitted(url)
     * 传递到 UrlPermissionResolver 中传递过来的,就一个固定值
     *
     * @param permission
     * @return
     */
    @Override
    public boolean implies(Permission permission) {//p=匹配用户权限
        if(!(permission instanceof UrlPermission)){
            return false;
        }
        //
        UrlPermission urlPermission = (UrlPermission)permission;
        PatternMatcher patternMatcher = new AntPathMatcher();

        logger.debug("数据库中存放的通配符=> " + this.url);
        logger.debug("浏览器正在访问的资源=> " +  urlPermission.url);
        boolean matches = patternMatcher.matches(this.url,urlPermission.url);
        if(matches){
            logger.debug("验证通过");
        }else{
            logger.debug("验证未通过");
        }
        return matches;
    }
}