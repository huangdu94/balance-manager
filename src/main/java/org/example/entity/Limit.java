package org.example.entity;

import java.util.Date;

import lombok.Data;

/**
 * 额度
 *
 * @author huangdu
 */
@Data
public class Limit {
    private Long id;
    private Date createTime;
    private Date updateTime;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 额度类型
     */
    private Long limitTypeId;
    private Double amount;
}
