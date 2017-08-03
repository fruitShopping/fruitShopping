package com.fruit.service.sys;

import com.fruit.dao.sys.AuthorityDao;
import com.fruit.entity.sys.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class AuthorityService {
    @Autowired
    private AuthorityDao authorityDao;

    public Authority findOne(int authorityId) {
        return authorityDao.findOne(authorityId);
    }

    public Set<String> findPermissions(List<Integer> authorityIds) {
        Set<String> permissions = new HashSet<String>();
        for(int authorityId : authorityIds) {
            Authority authority = findOne(authorityId);
            if(authority != null && !StringUtils.isEmpty(authority.getPermission())) {
                permissions.add(authority.getUrl());
            }
        }
        return permissions;
    }
}
