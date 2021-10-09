package com.sdufe.dataAnalycs.filter;

import com.sdufe.dataAnalycs.utils.JdbcUtils;
import javax.servlet.*;
import java.io.IOException;

/**
 * 所有访问的过滤器
 * 实现的效果是给所有访问加上try-catch块，没有异常进行提交事务，有异常就进行回滚事务并抛出异常给tomcat服务器，使其处理这个异常
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose(); // 提交事务并关闭连接
       } catch (Exception e) {
            JdbcUtils.rollbackAndClose();// 回滚事务并关闭连接
            e.printStackTrace();
            throw new RuntimeException(e);// 将异常抛给tomcat服务器，使用tomcat服务器对异常进行友好的页面显示
        }

    }

    @Override
    public void destroy() {

    }
}
