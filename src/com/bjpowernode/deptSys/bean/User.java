package com.bjpowernode.deptSys.bean;

/**
 * @ProjectName: deptSys
 * @Package: com.bjpowernode.deptSys.bean
 * @Description: java类作用描述
 * @Author: Andy
 * @CreateDate: 2020/10/27 14:10
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class User {

    private String id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}