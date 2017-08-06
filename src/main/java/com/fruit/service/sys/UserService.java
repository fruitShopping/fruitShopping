package com.fruit.service.sys;


import com.fruit.dao.sys.RelationShipDao;
import com.fruit.dao.sys.UserDao;
import com.fruit.entity.IfPage;
import com.fruit.entity.Page;
import com.fruit.entity.sys.User;
import com.fruit.common.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * 用户信息
 * Created by zjj-ideapad on 2015/3/26.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RelationShipDao relationShipDao;

    /**
     * 用户信息分页查询
     * @param page 分页
     * @param username 用户名
     * @param mobile 手机号码
     * @return
     */
    public IfPage<User> getUsersList(Page page,String username,String mobile){
        IfPage<User> userListIfPage = new IfPage<User>();
        userListIfPage.setPageNum(page.getCurrentPage());
        if(page.getCurrentPage() == 1){
            page.setBegin(0);
        }

        List<User> usersList = userDao.queryList(page,username,mobile);
        userListIfPage.setDates(usersList);

        //数据总数
        int total = userDao.queryListTotal(username,mobile);
        int totalPage = total/page.getSize();
        totalPage += total%page.getSize() > 0 ? 1:0;
        userListIfPage.setPageTotal(totalPage);
        return  userListIfPage;

    }

    public Boolean doLocked(Integer userId,int num){
        boolean flag = false;
        try{
            userDao.doLocked(userId,num);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public User findUserById(Integer userId){
        return userDao.findUserById(userId);
    }
    /**
     * 查询用户是否存在
     * @param username 用户名
     * @return 返回值
     */
    public User findUserByName(String username){
        return userDao.findUserByName(username);
    }

    public void save(User user){
        PasswordHelper passwordHelper = new PasswordHelper();
        //加密密码
        passwordHelper.encryptPassword(user);
        user.preInsert();
        userDao.insert(user);
        User user2 = userDao.findUserByName(user.getUsername());
        long userId = user2.getId();
        //添加角色关系
        String roleIds = user.getRoleIdsStr();
        String[] roleIdArr = roleIds.split(",");
        for(String  roleId : roleIdArr){
          //  roleDao.insertRoleAndUser(userId,Integer.parseInt(roleId));
        }
    }
    public Boolean updateUser(User user){
        boolean flag = false;
        String password = user.getPassword();
        String oldPassword = user.getOldPassword();
        try {
            if (password.equals(oldPassword)) {
                userDao.update(user);
            } else {
                PasswordHelper passwordHelper = new PasswordHelper();
                //加密密码
                passwordHelper.encryptPassword(user);
                userDao.update(user);
            }
            //更新用户角色关系
            long userId = user.getId();
            //删除用户与角色关系
            //roleDao.deleteUserAndRole(userId);
            //添加用户与角色关系
            String roleIds = user.getRoleIdsStr();
            String[] roleIdArr = roleIds.split(",");
            for(String  roleId : roleIdArr){
                //roleDao.insertRoleAndUser(userId,Integer.parseInt(roleId));
            }

            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public boolean deleteByIds(String ids){
        userDao.deleteByIds(ids);
        return true;
    }
}
