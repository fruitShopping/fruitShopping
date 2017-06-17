package com.zcf.fruit.service.sys;

import com.zcf.fruit.dao.mysqlDao.user.RegisterDao;
import com.zcf.fruit.entity.user.User;
import com.zcf.fruit.common.utils.PasswordHelper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by zjj-ideapad on 2015/3/29.
 */
@Service
public class RegisterService {

    public User createUser(User user){
        PasswordHelper passwordHelper = new PasswordHelper();
        //加密密码
        passwordHelper.encryptPassword(user);
        registerDao.createUser(user);
        return user;
    }

    public Boolean checkUsername(String username){
        boolean flag = false;
        int num = registerDao.checkUsername(username);
        if(num==0){
            flag = true;
        }
        return flag;
    }

    @Inject
    private RegisterDao registerDao;
}
