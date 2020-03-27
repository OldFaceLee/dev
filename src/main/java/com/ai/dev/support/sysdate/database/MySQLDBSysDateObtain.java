package com.ai.dev.support.sysdate.database;

import javax.sql.DataSource;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/27 上午11:18
 * @description:
 */
public class MySQLDBSysDateObtain extends AbstractDBSysDateObtain {

    public MySQLDBSysDateObtain(DataSource dataSource){
        super(dataSource);
    }
    @Override
    protected String getDBDateQuery() {
        return "select now()";
    }
}
