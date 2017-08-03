package com.fruit.service.sys;

import com.fruit.dao.sys.RegisterDao;
import com.fruit.entity.sys.User;
import com.fruit.common.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class RegisterService {
    @Autowired
    private RegisterDao registerDao;

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
}
