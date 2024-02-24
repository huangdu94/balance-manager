package org.example.service;

/**
 * 额度 service 接口
 *
 * @author huangdu
 */
public interface LimitService {
    /**
     * 额度初始化
     *
     * @param userId      用户ID
     * @param limitTypeId 额度类型ID
     * @param amount      额度
     * @return 是否初始化成功
     */
    boolean initialize(Long userId, Long limitTypeId, Double amount);

    /**
     * 额度增加
     *
     * @param userId      用户ID
     * @param limitTypeId 额度类型ID
     * @param amount      额度
     * @return 是否增加成功
     */
    boolean increase(Long userId, Long limitTypeId, Double amount);

    /**
     * 额度扣减
     *
     * @param userId      用户ID
     * @param limitTypeId 额度类型ID
     * @param amount      额度
     * @return 是否扣减成功
     */
    boolean decrease(Long userId, Long limitTypeId, Double amount);

    /**
     * 额度查询
     *
     * @param userId      用户ID
     * @param limitTypeId 额度类型ID
     * @return 额度
     */
    Double inquire(Long userId, Long limitTypeId);
}
