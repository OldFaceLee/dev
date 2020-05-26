package com.ai.dev.mapper.customized.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/24
 * @description:
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VueTestRequest implements Serializable {
    private static final long serialVersionUID = -7405692456071456195L;

    String name;
    Integer id;
    Date date;
}
