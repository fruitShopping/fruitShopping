package com.fruit.filter;

import com.fruit.service.sys.PermissionsService;
import com.fruit.util.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private PermissionsService permissionsService;
    @Autowired
    private HttpSession httpSession;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, permissionsService.findByUsername(username));
        httpSession.setAttribute(Constants.CURRENT_USER, permissionsService.findByUsername(username));
        return true;
    }

}
