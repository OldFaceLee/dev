package com.ai.dev.mapper.customized;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/30 下午11:16
 * @description:
 */
@Getter
@Setter
@NoArgsConstructor
public class TpTestsuiteRequest implements Serializable {

    private static final long serialVersionUID = -5968081921653661805L;

    @NotNull
    boolean isParallelByMethod;

    Integer testngThreadCount;

    @NotBlank(message = "测试组名不能为空，多组情况可用逗号隔开")
    String groups;
}
