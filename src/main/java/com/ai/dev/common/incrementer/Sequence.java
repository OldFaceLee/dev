package com.ai.dev.common.incrementer;

/**
 * @Author: [djh]杜佳恒
 * @Date: Created at 12:30 on 2019/01/16
 * @Description: 序列定义接口
 */
public interface Sequence {

    /**
     * 获取SEQ名称
     *
     * @return
     */
    String getName();

    /**
     * 获取SEQ功能的描述
     *
     * @return
     */
    String getDesc();
}
