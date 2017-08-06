package com.fruit.dao.sys;

import com.fruit.common.annotation.MyBatisDao;
import com.fruit.entity.sys.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by zjj-ideapad on 2015/3/29.
 */
@MyBatisDao
@Repository
public interface RegisterDao {

    @Insert("insert into sys_user(username, password,real_name,identity_card_num,telephone,addTime, salt, locked) " +
            "values(#{sys.username},#{sys.password},#{sys.real_name},#{sys.identity_card_num}," +
            "#{sys.telephone},now(),#{sys.salt},#{sys.locked})")
    public int createUser(@Param("sys") User user);
//    @Options(useGeneratedKeys = true, keyProperty = "id")


    @Select("SELECT COUNT(*) AS total FROM sys_user WHERE username = #{username}")
    public int checkUsername(@Param("username") String username);
}
