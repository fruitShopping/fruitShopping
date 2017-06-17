package com.zcf.fruit.service.sys;

import com.zcf.fruit.dao.mysqlDao.user.UserDao;
import com.zcf.fruit.entity.IfPage;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.user.User;
import com.zcf.fruit.common.utils.PasswordHelper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by zjj-ideapad on 2015/3/26.
 */
@Service
public class UserService {

    public IfPage<User> getUsersList(Page page,String username){
        IfPage<User> moTableIfPage = new IfPage<User>();
        moTableIfPage.setPageNum(page.getCurrentPage());
        List<User> usersList = null;
        if(page.getCurrentPage() == 1){
            page.setBegin(0);
        }

        usersList = userDao.getUsersList(page,username);
        moTableIfPage.setDates(usersList);

        //数据总数
        int total = userDao.getUsersListTotal(username);
        int totalPage = total/page.getSize();
        totalPage += total%page.getSize() > 0 ? 1:0;
        moTableIfPage.setPageTotal(totalPage);
        return  moTableIfPage;

    }

    public Boolean doLocked(Long userId,int num){
        boolean flag = false;
        try{
            userDao.doLocked(userId,num);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public Boolean userDel(Long userId){
        boolean flag = false;
        try{
            userDao.userDel(userId);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public User editUser(Long userId){
        User user = userDao.findByUserId(userId);
        return user;
    }

    public Boolean doEditUser(User user,String backupPassword,Long userId){
        boolean flag = false;
        String password = user.getPassword();
        user.setId(userId);
        try {
            if (password.equals(backupPassword)) {
                userDao.update(user);
            } else {
                PasswordHelper passwordHelper = new PasswordHelper();
                //加密密码
                passwordHelper.encryptPassword(user);
                userDao.update(user);
            }
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public int findUserByUserName(String username,String password)
    {
        return userDao.findUserByUserName(username,password);
    }
    @Inject
    private UserDao userDao;
}
