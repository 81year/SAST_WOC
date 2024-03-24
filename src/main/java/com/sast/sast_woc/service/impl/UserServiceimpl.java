package com.sast.sast_woc.service.impl;

import com.sast.sast_woc.Mapper.UserMapper;
import com.sast.sast_woc.pojo.data.User;
import com.sast.sast_woc.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> query() {
        return userMapper.query();
    }
}
