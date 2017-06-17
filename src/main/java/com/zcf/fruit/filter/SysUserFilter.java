package com.zcf.fruit.filter;

import com.zcf.fruit.common.utils.SpringContextHolder;
import com.zcf.fruit.service.authuser.AuthUserService;
import com.zcf.fruit.util.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private AuthUserService authUserService;
    @Autowired
    private HttpSession httpSession;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, authUserService.findByUsername(username));
        httpSession.setAttribute(Constants.CURRENT_USER, authUserService.findByUsername(username));
        return true;
    }

}
