package com.sdufe.dataAnalycs.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接与释放（正常提交事务释放和回滚事务并释放）
 * 方法全部为类方法
 */
public class JdbcUtils {

    // 数据库连接池
    private static DruidDataSource dataSource;
    // 线程局部变量，保证线程用同一个Connection
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
    // 数据库连接池初始化
    static {
        try {
            Properties properties = new Properties();
            // 读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  从数据库连接池中获得连接
     * @return 如果返回null，表示获得连接失败
     */
    public static Connection getConnnection(){
        Connection conn = conns.get();
        if (conn==null){
            try {
                conn = dataSource.getConnection();// 从数据库连接池中获取连接
                conns.set(conn);// 保存到ThreadLocal对象中,供后面的Jdbc操作使用
                conn.setAutoCommit(false);// 设置手动提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务并关闭连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection!=null){
            try {
                connection.commit();// 提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close(); // 将连接放回数据库连接池
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove(); // 因为Tomcat底层使用了线程池技术，所以一定要进行remove操作，否则会出错
    }

    /**
     * 回滚事务并关闭连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if (connection!=null){
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();// 将连接放回数据库连接池中
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }
}
