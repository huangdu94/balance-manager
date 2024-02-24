package org.example.cache;

import javax.annotation.PostConstruct;

import org.example.sql.Sql;
import org.springframework.stereotype.Component;

/**
 * 用户缓存
 *
 * @author huangdu
 */
@Component
public class UserCache extends BaseCache {
    @PostConstruct
    public void init() {
        super.init(Sql.USERS_SELECT);
    }
}
