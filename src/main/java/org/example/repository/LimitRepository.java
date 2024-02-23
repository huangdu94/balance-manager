package org.example.repository;

import org.example.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 额度管理 Repository
 *
 * @author yiyun (huangdu.hd@alibaba-inc.com)
 */
@Repository
public class LimitRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long count(long userId, long limitTypeId) {
        return jdbcTemplate.queryForObject(Sql.LIMITS_COUNT, Long.class, userId, limitTypeId);
    }

    public Double select(long userId, long limitTypeId) {
        return jdbcTemplate.queryForObject(Sql.LIMITS_SELECT, Double.class, userId, limitTypeId);
    }

    public boolean insert(long userId, long limitTypeId, double amount) {
        return jdbcTemplate.update(Sql.LIMITS_INSERT, userId, limitTypeId, amount) > 0;
    }

    public boolean update(long userId, long limitTypeId, double amount) {
        return jdbcTemplate.update(Sql.LIMITS_UPDATE, amount, userId, limitTypeId) > 0;
    }

    /**
     * 该方法用于清理测试数据
     */
    public void clear() {
        jdbcTemplate.update(Sql.LIMITS_DELETE_ALL);
    }
}
