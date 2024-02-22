package org.example.cache;

import javax.annotation.PostConstruct;

import org.example.sql.Sql;
import org.springframework.stereotype.Component;

/**
 * 用户缓存
 *
 * @author yiyun (huangdu.hd@alibaba-inc.com)
 */
@Component
public class UserCache extends BaseCache {
    @PostConstruct
    public void init() {
        super.init(Sql.USERS_SELECT);
    }
}
