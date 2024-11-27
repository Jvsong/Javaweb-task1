package com.song.mapper;

import com.song.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    // 根据用户名和密码查询用户
    User select(@Param("username") String username, @Param("password") String password);

    // 验证用户是否存在
    boolean validateUser(@Param("username") String username, @Param("password") String password);

    // 验证用户名是否存在
    User selectByUsername(String username);

    // 插入新用户
    void insertUser(User user);
}
