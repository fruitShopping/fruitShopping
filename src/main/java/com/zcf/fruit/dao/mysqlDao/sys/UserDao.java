package com.zcf.fruit.dao.mysqlDao.sys;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.sys.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zjj-ideapad on 2015/3/26.
 */
@MyBatisDao
@Repository
public interface UserDao{

    public User findByUsername(@Param("username") String username);

    public User findUserBus(@Param("username") String username,
                            @Param("loginName") String loginName);

    public List<Map<String,String>> findByRoleIds(@Param("username") String username);

    public List<User> getUsersList(@Param("page") Page page,@Param("username") String username,@Param("mobile") String mobile);

    public int getUsersListTotal(@Param("username") String username,@Param("mobile") String mobile);

    public void doLocked(@Param("userId") Long userId,@Param("num") int num);

    public void userDel(@Param("userId") Long userId);

    public User findByUserId(@Param("userId") Long userId);

    public int findUserByUserName(@Param("username") String username,
                                   @Param("password") String password);

    public void update(User user);

    public long insert(User user);

    public void updateBusi(User user);
}
