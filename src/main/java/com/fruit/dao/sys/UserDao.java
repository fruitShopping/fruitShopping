package com.fruit.dao.sys;

import com.fruit.common.annotation.MyBatisDao;
import com.fruit.entity.Page;
import com.fruit.entity.sys.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zyming 20170806
 */
@MyBatisDao
@Repository
public interface UserDao{
    //根据用户id查用户
    public User findUserById(@Param("userId") Integer userId);
    //根据用户名查用户
    public User findUserByName(@Param("username") String username);
    //根据用户名和密码查询用
    public User findUser(@Param("username") String username,@Param("password") String password);
    //根据用户名查询用户个数【校验用户是否存在】
    public int findCountByUserName(@Param("username") String username);

    //根据用户id查用户权限
    public List<Map<String,String>> findPermsByUserId(@Param("userId") Integer userId);
    //根据用户id查用户角色
    public List<Map<String,String>> findRolesByUserId(@Param("userId") Integer userId);

    //查询总记录数
    public int queryListTotal(@Param("username") String username,@Param("mobile") String mobile);
    public List<User> queryList(@Param("page") Page page,@Param("username") String username,@Param("mobile") String mobile);

    //锁住用户
    public void doLocked(@Param("userId") Integer userId,@Param("num") int num);

    //修改用户登录信息
    public void updateLoginInfo(@Param("userId") Integer userId,@Param("loginIp") String loginIp,
                                @Param("loginDate") String loginDate);

    //物理删除
    public void doDelete(@Param("userId") Integer userId);

    //修改密码
    public void updatePassWord(@Param("userId") Integer userId,@Param("password") String password,
                               @Param("salt") String salt);

    public void delete(User user);

    public void update(User user);

    public long insert(User user);

    public void deleteByIds(@Param("ids") String ids);
}
