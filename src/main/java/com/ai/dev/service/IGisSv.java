package com.ai.dev.service;

import com.ai.dev.common.controller.response.Response;
import com.ai.dev.common.pageHelper.PageInfo;
import com.ai.dev.mapper.vo.TpGis;

/**
 * @author: lixuejun
 * @date: Create in 2020/6/8
 * @description:
 */
public interface IGisSv {

    PageInfo<TpGis> compareLocation(Integer pageNo, Integer PageSize);
}
