package com.ai.dev.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: lixuejun
 * @date: Create in 2020/6/7
 * @description:
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GisResponse implements Serializable {
    private static final long serialVersionUID = -4489728552453259443L;

    String sourceAddr;
    String sourceLocation;
    String actualAddr;
    String compareResult;
    Date compareDate;
}
