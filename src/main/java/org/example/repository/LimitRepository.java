package org.example.repository;

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


}
