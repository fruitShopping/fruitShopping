package com.fruit.filter;

import com.fruit.entity.sys.User;
import com.fruit.service.sys.PermsService;
import com.fruit.util.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private PermsService permsService;
    @Autowired
    private HttpSession httpSession;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        User user=permsService.findUserByName(username);
        request.setAttribute(Constants.CURRENT_USER,user);
        httpSession.setAttribute(Constants.CURRENT_USER,user);
        return true;
    }

}
