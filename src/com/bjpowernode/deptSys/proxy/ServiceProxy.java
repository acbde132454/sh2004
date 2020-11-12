package com.bjpowernode.deptSys.proxy;

import com.bjpowernode.deptSys.bean.User;
import com.bjpowernode.deptSys.service.impl.DeptServiceImpl;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: deptSys
 * @Package: com.bjpowernode.deptSys.proxy
 * @Description: java类作用描述
 * @Author: Andy
 * @CreateDate: 2020/11/5 8:48
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class ServiceProxy implements InvocationHandler, ServletRequestListener {

    private Object target;

    private HttpServletRequest request;

    private HttpServletResponse response;

    public ServiceProxy(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces()
        ,this);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        this.request = request;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //登录切面管理
        //获取session中有没有登录信息
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            //response.sendRedirect("/deptSys/login.jsp");
        }else{
            method.invoke(target,args);
        }
        return null;
    }
}