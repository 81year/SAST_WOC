package com.sast.sast_woc.pojo.data;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer role;
}
