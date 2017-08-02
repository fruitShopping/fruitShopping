package com.zcf.fruit.service.sys;

import com.zcf.fruit.dao.mysqlDao.sys.RoleDao;
import com.zcf.fruit.dao.mysqlDao.sys.UserDao;
import com.zcf.fruit.entity.IfPage;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.sys.User;
import com.zcf.fruit.common.utils.PasswordHelper;
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

        List<User> usersList = userDao.getUsersList(page,username,mobile);
        userListIfPage.setDates(usersList);

        //数据总数
        int total = userDao.getUsersListTotal(username,mobile);
        int totalPage = total/page.getSize();
        totalPage += total%page.getSize() > 0 ? 1:0;
        userListIfPage.setPageTotal(totalPage);
        return  userListIfPage;

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

    public Boolean userDel(String userIds){
        boolean flag = false;
        try{
            userIds = userIds.substring(0,userIds.length()-1);
            String[] userIdArr = userIds.split(",");
            for(String userId : userIdArr){
                userDao.userDel(Long.parseLong(userId));
                //删除用户与角色关系
                roleDao.deleteUserAndRole(Long.parseLong(userId));
            }

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

    public void save(User user){
        PasswordHelper passwordHelper = new PasswordHelper();
        //加密密码
        passwordHelper.encryptPassword(user);
        user.preInsert();
        userDao.insert(user);
        User user2 = userDao.findByUsername(user.getUsername());
        long userId = user2.getId();
        //添加角色关系
        String roleIds = user.getRoleIdsStr();
        String[] roleIdArr = roleIds.split(",");
        for(String  roleId : roleIdArr){
            roleDao.insertRoleAndUser(userId,Integer.parseInt(roleId));
        }
    }
    public Boolean doEditUser(User user){
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
            roleDao.deleteUserAndRole(userId);
            //添加用户与角色关系
            String roleIds = user.getRoleIdsStr();
            String[] roleIdArr = roleIds.split(",");
            for(String  roleId : roleIdArr){
                roleDao.insertRoleAndUser(userId,Integer.parseInt(roleId));
            }

            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 查询用户是否存在
     * @param username 用户名
     * @return 返回值
     */
    public User findUserByUsername(String username){
        return userDao.findByUsername(username);
    }

    /**
     * 用户信息修改时查询用户名是否存在(不包含现在的用户)
     * @param username 新用户名
     * @param loginName 登录用户名
     * @return 返回值
     */
    public User findUserBus(String username,String loginName){
        return userDao.findUserBus(username,loginName);
    }
    public int findUserByUserName(String username,String password)
    {
        return userDao.findUserByUserName(username,password);
    }
    @Inject
    private UserDao userDao;

    @Inject
    private RoleDao roleDao;
}
