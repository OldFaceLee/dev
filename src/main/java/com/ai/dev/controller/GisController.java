package com.ai.dev.controller;

import com.ai.dev.common.controller.response.Response;
import com.ai.dev.common.pageHelper.PageInfo;
import com.ai.dev.mapper.vo.TpGis;
import com.ai.dev.service.IGisSv;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lixuejun
 * @date: Create in 2020/6/8
 * @description:
 */

@RestController
@CrossOrigin(origins="*")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class GisController {

    @Autowired
    IGisSv gisSv;

    @GetMapping(value = "/gis/compare/{pageNo}/{pageSize}")
    public Response<PageInfo<TpGis>> gitCompare(@PathVariable int pageNo,
                                                @PathVariable int pageSize){

        return new Response<>(gisSv.compareLocation(pageNo,pageSize));
    }
}
