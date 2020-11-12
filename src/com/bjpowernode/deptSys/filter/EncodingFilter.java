package com.bjpowernode.deptSys.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ProjectName: deptSys
 * @Package: com.bjpowernode.deptSys.filter
 * @Description: java类作用描述
 * @Author: Andy
 * @CreateDate: 2020/10/27 14:57
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}