package com.ai.dev.mapper.customized.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/25
 * @description:
 */
@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VueTestSubmitRequest {

    String pass;
    String checkPass;

    @Min(value = 18,message = "年龄必须大于18")
    @Max(value = 60,message = "年龄不能超过60")
    Integer age;
}
