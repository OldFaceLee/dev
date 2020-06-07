package com.ai.dev.dao;

import com.ai.dev.common.pageHelper.PageInfo;
import com.ai.dev.mapper.vo.TpGis;

/**
 * @author: lixuejun
 * @date: Create in 2020/6/8
 * @description:
 */
public interface ITpGisDao {

    PageInfo<TpGis> query(Integer pageNO, Integer PageSize);
}
