package org.example.cache;

import javax.annotation.PostConstruct;

import org.example.sql.Sql;
import org.springframework.stereotype.Component;

/**
 * 额度类型缓存
 *
 * @author yiyun (huangdu.hd@alibaba-inc.com)
 */
@Component
public class LimitTypeCache extends BaseCache {
    @PostConstruct
    public void init() {
        super.init(Sql.LIMIT_TYPES_SELECT);
    }
}
