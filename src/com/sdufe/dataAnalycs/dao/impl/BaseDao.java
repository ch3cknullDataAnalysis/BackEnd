package com.sdufe.dataAnalycs.dao.impl;

import com.sdufe.dataAnalycs.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 用来执行insert,update,delete操作
     * @return
     */
    public int update(String sql, Object...args){
        Connection conn = JdbcUtils.getConnnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     *查询返回一个JavaBean的语句
     * @param type 返回的对象类型
     * @param sql 执行的SQL语句
     * @param args sql语句需要的参数
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T>T queryForOne(Class<T> type, String sql, Object...args){
        Connection conn = JdbcUtils.getConnnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     *查询返回多个javabean的SQL语句
     * @param type 返回的对象类型
     *  @param sql 执行的SQL语句
     *  @param args sql语句需要的参数
     *  @param <T> 返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql,Object...args){
        Connection conn = JdbcUtils.getConnnection();
        try {
           return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * 返回一个对象数组
     * @param sql
     * @return
     */
    public List<Object[]> queryForList(String sql){
        Connection conn = JdbcUtils.getConnnection();
        try {
            return queryRunner.query(conn, sql, new ArrayListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 执行一行一列的sql语句
     * @param sql 要执行的sql语句
     * @param args sql语句需要的参数
     * @return
     */

    public Object queryForSingleValue(String sql,Object...args){
        Connection conn = JdbcUtils.getConnnection();
        try {
           return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
