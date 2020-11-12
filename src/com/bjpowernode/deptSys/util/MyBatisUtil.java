package com.bjpowernode.deptSys.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @ProjectName: mybatis
 * @Package: util
 * @Description: java类作用描述
 * @Author: Andy
 * @CreateDate: 2020/10/26 9:26
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class MyBatisUtil {

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try{
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //生成sqlSession,调用sqlSessionAPI
            //参数:true:默认提交事务 false:不提交事务
            sqlSession = sqlSessionFactory.openSession(true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSession;
    }
}