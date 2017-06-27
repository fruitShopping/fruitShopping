package com.zcf.fruit.dao.mysqlDao.sys;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.entity.sys.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zjj-ideapad on 2015/3/29.
 */
@MyBatisDao
public interface RegisterDao {

    @Insert("insert into sys_user(username, password,real_name,identity_card_num,telephone,addTime, salt, locked) " +
            "values(#{sys.username},#{sys.password},#{sys.real_name},#{sys.identity_card_num}," +
            "#{sys.telephone},now(),#{sys.salt},#{sys.locked})")
    public int createUser(@Param("sys") User user);
//    @Options(useGeneratedKeys = true, keyProperty = "id")


    @Select("SELECT COUNT(*) AS total FROM sys_user WHERE username = #{username}")
    public int checkUsername(@Param("username") String username);
}
