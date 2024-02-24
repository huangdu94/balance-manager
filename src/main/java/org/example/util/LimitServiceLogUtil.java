package org.example.util;

import lombok.extern.slf4j.Slf4j;
import org.example.cache.LimitTypeCache;
import org.example.cache.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * LimitService打印日志
 *
 * @author yiyun (huangdu.hd@alibaba-inc.com)
 */
@Slf4j
@Component
public class LimitServiceLogUtil {
    @Autowired
    private UserCache userCache;
    @Autowired
    private LimitTypeCache limitTypeCache;

    public void initialize(Long userId, Long limitTypeId, Double amount) {
        error("initialize", userId, limitTypeId, amount);
    }

    public void increase(Long userId, Long limitTypeId, Double amount) {
        error("increase", userId, limitTypeId, amount);
    }

    public void decrease(Long userId, Long limitTypeId, Double amount) {
        error("decrease", userId, limitTypeId, amount);
    }

    public void inquire(Long userId, Long limitTypeId) {
        error("inquire", userId, limitTypeId);
    }

    public void error(Exception e) {
        log.info("[error] {}.", e.getMessage());
    }

    public void result(Object result) {
        log.info("[result] {}.", result);
    }

    private void error(String opt, Long userId, Long limitTypeId) {
        log.info("[{}] user:{}, limit type:{}.", opt, userCache.getIdNameMap().get(userId), limitTypeCache.getIdNameMap().get(limitTypeId));
    }

    private void error(String opt, Long userId, Long limitTypeId, Double amount) {
        log.info("[{}] user:{}, limit type:{}, amount: {}.", opt, userCache.getIdNameMap().get(userId), limitTypeCache.getIdNameMap().get(limitTypeId), amount);
    }
}
