package org.example.validation;

import org.example.cache.LimitTypeCache;
import org.example.cache.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 参数合法性校验
 *
 * @author yiyun (huangdu.hd@alibaba-inc.com)
 */
@Component
public class ParameterValidation {
    @Autowired
    private UserCache userCache;
    @Autowired
    private LimitTypeCache limitTypeCache;

    public void checkUserId(Long userId) {
        check(userCache.getIdNameMap().containsKey(userId), "user is not exist.");
    }

    public void checkLimitTypeId(Long limitTypeId) {
        check(limitTypeCache.getIdNameMap().containsKey(limitTypeId), "limit type is not exist.");
    }

    private void check(boolean flag, String message) {
        if (!flag) {throw new RuntimeException(message);}
    }
}
