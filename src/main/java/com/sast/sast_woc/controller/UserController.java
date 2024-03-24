package com.sast.sast_woc.controller;
import com.sast.sast_woc.pojo.data.User;
import com.sast.sast_woc.pojo.response.Response;
import com.sast.sast_woc.service.impl.UserServiceimpl;
import com.sast.sast_woc.util.LoginJwt;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Resource
    private UserServiceimpl userServiceimpl;

    @PostMapping("/login")
    Response login(@RequestBody User user){
        List<User> users = userServiceimpl.query();
        for(User user1 : users){
            if (user1.getUsername().equals(user.getUsername())&&user1.getPassword().equals(user.getPassword())){
                Map<String,Object> claims = new HashMap<>();
                claims.put("username",user1.getUsername());
                claims.put("role",user1.getRole());
                claims.put("password",user1.getPassword());
                String jwt = LoginJwt.creatJwt(claims);
                return Response.success(jwt);
            }
        }
        return Response.error();
    }
}
