package com.bjpowernode.deptSys.service;

import com.bjpowernode.deptSys.bean.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> deptList(String dname);

    void addDept(Dept dept);

    Dept queryDeptById(String deptno);

    void editDept(Dept dept);

    void deleteBatch(String deptnos);
}
