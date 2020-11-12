package com.bjpowernode.deptSys.controller;

import com.bjpowernode.deptSys.bean.Dept;
import com.bjpowernode.deptSys.proxy.ServiceProxy;
import com.bjpowernode.deptSys.service.DeptService;
import com.bjpowernode.deptSys.service.impl.DeptServiceImpl;
import com.bjpowernode.deptSys.util.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: deptSys
 * @Package: com.bjpowernode.deptSys.controller
 * @Description: java类作用描述
 * @Author: Andy
 * @CreateDate: 2020/10/27 14:06
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 * ctrl+alt+左右方向键
 */
@WebServlet("/DeptController")
public class DeptController extends HttpServlet {


    private DeptService deptService;
    //每页记录数
    private int pageSize = 3;


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        deptService =
                (DeptService) new ServiceProxy(new DeptServiceImpl()).getProxy();
        if("deptList".equals(type)){
           //部门列表查询
            deptList(request,response);
        }else if("toAddView".equals(type)){
            //跳转到添加页面
            toAddView(request,response);
        }else if("addDept".equals(type)){
            //添加部门
            addDept(request,response);
        }else if("toEditView".equals(type)){
            //跳转到修改页面
            toEditView(request,response);
        }else if("editDept".equals(type)){
            //修改
            editDept(request,response);
        }else if("deleteBatch".equals(type)){
            //批量删除
            deleteBatch(request,response);
        }
    }



    //单删和批量删除
    private void deleteBatch(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
        //获取前台勾中的所有记录的主键
        String deptnos = request.getParameter("deptnos");

        //参数放在service层处理
        deptService.deleteBatch(deptnos);
        deptList(request,response);
    }

    //修改部门
    private void editDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取表单数据
        Dept dept = BeanUtil.formToBean(Dept.class, request.getParameterMap());
        try{
            deptService.editDept(dept);
            //查询列表，是否更新成功
            deptList(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //跳转到修改页面
    private void toEditView(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //获取部门的主键，根据主键查询部门信息，再跳转到修改页面
        String deptno = request.getParameter("deptno");
        Dept dept = deptService.queryDeptById(deptno);
        //转发到修改页面
        request.setAttribute("dept",dept);
        request.getRequestDispatcher("/editDept.jsp").forward(request,response);
    }


    //添加部门
    private void addDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取表单信息
        Dept dept = BeanUtil.formToBean(Dept.class, request.getParameterMap());

        deptService.addDept(dept);

        deptList(request,response);
    }

    //跳转到添加页面
    private void toAddView(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{

        response.sendRedirect("/deptSys/addDept.jsp");
    }

    /*
    *   前台获取的参数什么时候是null，什么时候是""
    *   null:就是前台发送请求但是没有name或者name不匹配
    *   "":有name属性并且一致，但是没有给数据
    * */

    //部门列表查询、分页、模糊查询
    private void deptList(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        //获取模糊查询的条件     ?
        String dname = request.getParameter("dname");


        int page = request.getParameter("page")==null ? 1
                : Integer.parseInt(request.getParameter("page"));

        //参数1:页码 参数2:每页记录数limit a,b
        PageHelper.startPage(page,pageSize);

        List<Dept> deptList = deptService.deptList(dname);

        PageInfo<Dept> pageInfo = new PageInfo<>(deptList);


        //因为点击查询按钮再次回到页面会出现查询条件丢失，需要将上一次的查询条件回显 request session servletContext pageContext
        request.setAttribute("dname",dname);
        //获取总页数
        request.setAttribute("pages",pageInfo.getPages());
        //查询出来数据，转发到index.jsp
        request.setAttribute("deptList",pageInfo.getList());
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}