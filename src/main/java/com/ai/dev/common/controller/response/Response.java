package com.ai.dev.common.controller.response;

import com.ai.dev.common.controller.em.ResuldCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


/**
 * @author: lixuejun
 * @date: Create in 2020/3/12 下午6:11
 * @description:
 */
@Getter
@Setter@FieldDefaults(level = AccessLevel.PRIVATE)

public class Response<T> extends CommonResponse {
    private static final long serialVersionUID = -2635111722380521009L;

    T data;

    public Response(){
        super(ResuldCode.OK.getValue(),ResuldCode.OK.getDesc());
    }

    public Response(T t){
        super(ResuldCode.OK.getValue(),ResuldCode.OK.getDesc());
        this.data = t;
    }

}
