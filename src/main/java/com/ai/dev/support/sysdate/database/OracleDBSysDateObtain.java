package com.ai.dev.support.sysdate.database;

import javax.sql.DataSource;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/27 上午11:20
 * @description:
 */
public class OracleDBSysDateObtain extends AbstractDBSysDateObtain {

    public OracleDBSysDateObtain(DataSource dataSource){
        super(dataSource);
    }

    @Override
    protected String getDBDateQuery() {
        return "select sysdate from dual";
    }
}
