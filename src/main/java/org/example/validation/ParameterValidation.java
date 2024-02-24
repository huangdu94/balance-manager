package org.example.validation;

import java.util.Objects;

import org.example.cache.LimitTypeCache;
import org.example.cache.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 参数合法性校验
 *
 * @author huangdu
 */
@Component
public class ParameterValidation {
    @Autowired
    private UserCache userCache;
    @Autowired
    private LimitTypeCache limitTypeCache;

    public void check(Long userId, Long limitTypeId) {
        checkUserId(userId);
        checkLimitTypeId(limitTypeId);
    }

    public void check(Long userId, Long limitTypeId, Double amount) {
        check(userId, limitTypeId);
        checkAmount(amount);
    }

    private void checkUserId(Long userId) {
        check(Objects.nonNull(userId), "user is null.");
        check(userCache.getIdNameMap().containsKey(userId), "user is not exist.");
    }

    private void checkLimitTypeId(Long limitTypeId) {
        check(Objects.nonNull(limitTypeId), "limit type is null.");
        check(limitTypeCache.getIdNameMap().containsKey(limitTypeId), "limit type is not exist.");
    }

    public void checkAmount(Double amount) {
        check(Objects.nonNull(amount), "amount is null.");
        check(amount >= 0, "amount must be greater than or equal to zero.");
    }

    public void check(boolean flag, String message) {
        if (!flag) {throw new RuntimeException(message);}
    }
}
