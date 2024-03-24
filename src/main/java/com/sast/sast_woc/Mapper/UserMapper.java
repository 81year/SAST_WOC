package com.sast.sast_woc.Mapper;

import com.sast.sast_woc.pojo.data.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select username,password,role from test.sast_pancake_user")
    List<User> query();

}
