package com.zcf.fruit.dao.mysqlDao.user;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.entity.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by zjj-ideapad on 2015/3/29.
 */
@MyBatisDao
public interface RegisterDao {

    @Insert("insert into sys_user(username, password,real_name,identity_card_num,telephone,addTime, salt, locked) " +
            "values(#{user.username},#{user.password},#{user.real_name},#{user.identity_card_num}," +
            "#{user.telephone},now(),#{user.salt},#{user.locked})")
    public int createUser(@Param("user") User user);
//    @Options(useGeneratedKeys = true, keyProperty = "id")


    @Select("SELECT COUNT(*) AS total FROM sys_user WHERE username = #{username}")
    public int checkUsername(@Param("username") String username);
}
