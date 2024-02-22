package org.example.sql;

/**
 * 项目中用到的SQL
 *
 * @author yiyun (huangdu.hd@alibaba-inc.com)
 */
public interface Sql {
    String USERS_SELECT = "SELECT id, name FROM users";
    String LIMIT_TYPES_SELECT = "SELECT id, name FROM limit_types";
}
