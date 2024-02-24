package org.example.entity;

import java.util.Date;

import lombok.Data;

/**
 * 额度类型
 *
 * @author huangdu
 */
@Data
public class LimitType {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private String name;
}
