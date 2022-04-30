package com.monk.common.entity;

import lombok.Data;

@Data
public class LoginUser {

    private Long userId;
    private String userName;

    public LoginUser(Long userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }
}
