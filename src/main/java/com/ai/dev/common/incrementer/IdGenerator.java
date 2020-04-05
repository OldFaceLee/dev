package com.ai.dev.common.incrementer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/**
 * @Author: [djh]杜佳恒
 * @Date: Created at 12:30 on 2019/01/16
 * @Description: 序列生成器。应用中序列枚举类需要实现接口 Sequence
 */
@Service
public final class IdGenerator {

    @Autowired
    private DataSource dataSource;

    public long nextLongVal(Sequence sequence) {
        return this.incrementer(sequence.getName()).nextLongValue();
    }

    public int nextIntVal(Sequence sequence) {
        return this.incrementer(sequence.getName()).nextIntValue();
    }

    public String nextStringVal(Sequence sequence) {
        return this.incrementer(sequence.getName()).nextStringValue();
    }

    private DataFieldMaxValueIncrementer incrementer(String sequenceName) {
        Assert.hasText(sequenceName, "sequenceName is required");
        return new OracleSequenceMaxValueIncrementer(dataSource, sequenceName);
    }

}