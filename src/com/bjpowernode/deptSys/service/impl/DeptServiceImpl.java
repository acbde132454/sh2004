package com.bjpowernode.deptSys.service.impl;

import com.bjpowernode.deptSys.bean.Dept;
import com.bjpowernode.deptSys.mapper.DeptMapper;
import com.bjpowernode.deptSys.service.DeptService;
import com.bjpowernode.deptSys.util.MyBatisUtil;

import java.util.List;

/**
 * @ProjectName: deptSys
 * @Package: com.bjpowernode.deptSys.service.impl
 * @Description: java类作用描述
 * @Author: Andy
 * @CreateDate: 2020/10/27 14:30
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class DeptServiceImpl implements DeptService {

    private  DeptMapper deptMapper = MyBatisUtil.getSqlSession().getMapper(DeptMapper.class);

    @Override
    public List<Dept> deptList(String dname) {
        return deptMapper.deptList(dname);
    }

    @Override
    public void addDept(Dept dept) {
        deptMapper.addDept(dept);
    }

    @Override
    public Dept queryDeptById(String deptno) {
        return deptMapper.queryDeptById(deptno);
    }

    @Override
    public void editDept(Dept dept) {
        deptMapper.editDept(dept);
    }


    //Mybatis的动态sql中的forEach删除
    @Override
    public void deleteBatch(String deptnos) {
        String[] ids = deptnos.split(",");
        /*for (String id : ids) {
            //每次删除一条
        }*/
        deptMapper.deleteBatch(ids);
    }
}