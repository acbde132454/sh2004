package com.bjpowernode.deptSys.mapper;

import com.bjpowernode.deptSys.bean.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    List<Dept> deptList(@Param("dname") String dname);

    void addDept(Dept dept);

    Dept queryDeptById(@Param("deptno") String deptno);

    void editDept(Dept dept);

    void deleteBatch(String[] ids);
}
