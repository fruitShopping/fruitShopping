package com.fruit.dao.mobileLocation;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by zcf on 2015/8/22.
 */
@MapperScan
public interface MobileLocationDao {

    @Select("SELECT company FROM sys_area_section where section_no = #{sectionNo}")
    public String findMobileLocation(@Param("sectionNo") String sectionNo);
}
