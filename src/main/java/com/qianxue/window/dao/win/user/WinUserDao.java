package com.qianxue.window.dao.win.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianxue.window.vo.WinUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface WinUserDao extends BaseMapper<WinUser> {

    @Select("select * from  win_user where id = 1")
//    @Results({
//            @Result(property = "userSex",  column = "user_sex"),
//            @Result(property = "userName", column = "user_name"),
//            @Result(property = "userAge", column = "user_age")
//    })
    WinUser getUser(@Param("id") Long id);

    @Select("select * from  win_user where id = #{id}")
    WinUser getUserById(@Param("id") Long id);
}
