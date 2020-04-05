package com.ai.dev.support.context;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * 最终验证结果
 * 按照优先级展示业务验证信息
 *
 * @author zhangchao
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidateResult {

    /**
     * 错误级别. alert,confirm,error
     *
     * @see ValidateLevel
     */
    int level;

    /**
     * 提示消息
     */
    List<String> messages;
}
