package com.ai.dev.support.sysdate.database;

import com.ai.dev.support.sysdate.local.ISysDateObtain;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/27 上午11:07
 * @description:
 */
public abstract class AbstractDBSysDateObtain implements ISysDateObtain , InitializingBean {

    private DataSource dataSource;

    public AbstractDBSysDateObtain(DataSource dataSource){
        Assert.notNull(dataSource,"DataSource must not be null");
        this.dataSource = dataSource;
    }
    public DataSource getDataSource(){
        return dataSource;
    }


    @Override
    public void afterPropertiesSet() {
        if (this.dataSource == null) {
            throw new IllegalArgumentException("Property 'dataSource' is required");
        }
    }


    @Override
    public Timestamp getSysdate() {
        Connection con = DataSourceUtils.getConnection(getDataSource());
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            DataSourceUtils.applyTransactionTimeout(stmt, getDataSource());
            stmt.executeQuery(getDBDateQuery());
            if (rs.next()) {
                return rs.getTimestamp(1);
            } else {
                throw new DataAccessResourceFailureException("DB Date query did not return a result");
            }
        }catch (SQLException ex){
            throw new DataAccessResourceFailureException("Could not obtain DataBase Date value",ex);
        }finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(stmt);
            DataSourceUtils.releaseConnection(con,getDataSource());
        }
    }

    /**
     * 获取一个数据库时间的查询语句
     *
     * @return
     */
    protected abstract String getDBDateQuery();
}
