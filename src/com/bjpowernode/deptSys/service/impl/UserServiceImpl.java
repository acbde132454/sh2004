package com.bjpowernode.deptSys.service.impl;

import com.bjpowernode.deptSys.bean.User;
import com.bjpowernode.deptSys.mapper.UserMapper;
import com.bjpowernode.deptSys.service.UserService;
import com.bjpowernode.deptSys.util.MyBatisUtil;

/**
 * @ProjectName: deptSys
 * @Package: com.bjpowernode.deptSys.service.impl
 * @Description: java类作用描述
 * @Author: Andy
 * @CreateDate: 2020/10/27 14:11
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class UserServiceImpl implements UserService {

    private  UserMapper userMapper = MyBatisUtil.getSqlSession().getMapper(UserMapper.class);


    @Override
    public User login(User user) {

        return userMapper.login(user);
    }
}