package com.bjpowernode.deptSys.controller;

import com.bjpowernode.deptSys.bean.User;
import com.bjpowernode.deptSys.service.UserService;
import com.bjpowernode.deptSys.service.impl.UserServiceImpl;
import com.bjpowernode.deptSys.util.BeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ProjectName: deptSys
 * @Package: com.bjpowernode.deptSys.controller
 * @Description: java类作用描述
 * @Author: Andy
 * @CreateDate: 2020/10/27 14:08
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        //用户登录
        if("login".equals(type)){
            login(request,response);
        }else if("loginOut".equals(type)){
            //登出功能
            loginOut(request,response);
        }

    }

    //登出功能
    private void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将对象从session中移除即可
        request.getSession().removeAttribute("user");
        //转发或者重定向到登录页面
        response.sendRedirect("/deptSys/login.jsp");
    }

    //用户登录
    private void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //将用户登录信息封装
        User user = BeanUtil.formToBean(User.class, request.getParameterMap());

        user = userService.login(user);
        HttpSession session = request.getSession();
        if(user != null){
            //将用户信息放入到session中
            session.setAttribute("user",user);
            //跳转到查询部门列表请求
            request.getRequestDispatcher("/DeptController?type=deptList").forward(request,response);
        }
    }
}