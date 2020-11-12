package com.bjpowernode.deptSys.bean;

/**
 * @ProjectName: deptSys
 * @Package: com.bjpowernode.deptSys.bean
 * @Description: java类作用描述
 * @Author: Andy
 * @CreateDate: 2020/10/27 14:30
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class Dept {

    private String deptno;
    private String dname;
    private String loc;

    @Override
    public String toString() {
        return "Dept{" +
                "deptno='" + deptno + '\'' +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}