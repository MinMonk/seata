package com.monk.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author monk
 */
@Data
public class BasePo {
    private Boolean validFlag = true;
    private Long createUserId;
    private Date createTime;
    private Long updateUserId;
    private Date updateTime;

    public void initCreate(){
        LoginUser user = new LoginUser(1L, "admin");
        this.updateTime = new Date();
        this.updateUserId = user.getUserId();
        this.createTime = new Date();
        this.createUserId = user.getUserId();
    }

    public void initUpdate(){
        LoginUser user = new LoginUser(1L, "admin");
        this.updateTime = new Date();
        this.updateUserId = user.getUserId();
    }

    public void initCreate(LoginUser user){
        this.updateTime = new Date();
        this.updateUserId = user.getUserId();
        this.createTime = new Date();
        this.createUserId = user.getUserId();
    }

    public void initUpdate(LoginUser user){
        this.updateTime = new Date();
        this.updateUserId = user.getUserId();
    }
}
