package com.zcf.fruit.service.authuser;

import com.zcf.fruit.dao.mysqlDao.sys.AuthorityDao;
import com.zcf.fruit.entity.sys.Authority;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zjj-ideapad on 2015/3/26.
 */
@Service
public class AuthorityService {

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

    @Inject
    private AuthorityDao authorityDao;
}
