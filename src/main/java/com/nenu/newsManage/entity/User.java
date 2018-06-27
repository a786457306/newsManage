package com.nenu.newsManage.entity;

import javax.persistence.*;
import javax.persistence.Column;

/**
 * User
 *
 * @author Daydreamer
 * @date 2018/6/24 10:26
 */

@Table(name = "t_user")
@Entity
public class User {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "user_state")
    private Integer userState;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }
}
