package com.qianxue.window.dao;

import com.qianxue.window.vo.WinUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface WinUserDao {

    @Select("select * from  win_user where id = 1")
    @Results({
            @Result(property = "userSex",  column = "user_sex"),
            @Result(property = "userName", column = "user_nam"),
            @Result(property = "userAge", column = "user_age")
    })
    WinUser getUser(@Param("id") Long id);

    @Select("select * from  win_user where id = #{id}")
    WinUser getUserById(@Param("id") Long id);
}
