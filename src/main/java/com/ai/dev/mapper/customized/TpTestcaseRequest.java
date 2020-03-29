package com.ai.dev.mapper.customized;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/29 下午8:36
 * @description:
 */
@Setter
@Getter
@NoArgsConstructor
public class TpTestcaseRequest implements Serializable {


    private static final long serialVersionUID = -6798912180138230974L;


    private Integer id;

    private String caseId;

    private String requestType;

    private String caseName;

    private String caseDesc;

    private String caseGroups;

    private String uri;

    private String header;

    private String param;

    private Date updateDate;

    private Date createDate;

    private String createOwner;

    private Integer isValid;

    @NotNull(message = "每页查询记录数不能为空")
    @Min(value = 1,message = "每页查询数据至少为1")
    private Integer pageSize;

    @NotNull(message = "当前页码不能为空")
    @Min(value = 1,message = "当前页码至少为1")
    private Integer pageNo;

}
