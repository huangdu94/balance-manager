package org.example.sql;

/**
 * 项目中用到的SQL
 *
 * @author huangdu
 */
public interface Sql {
    String USERS_SELECT = "SELECT id, name FROM users;";
    String LIMIT_TYPES_SELECT = "SELECT id, name FROM limit_types;";
    String LIMITS_COUNT = "SELECT COUNT(*) FROM limits WHERE user_id = ? AND limit_type_id = ?;";
    String LIMITS_SELECT = "SELECT amount FROM limits WHERE user_id = ? AND limit_type_id = ?;";
    String LIMITS_INSERT = "INSERT INTO limits (user_id, limit_type_id, amount) VALUES (?, ?, ?);";
    String LIMITS_UPDATE = "UPDATE limits SET amount = ? WHERE user_id = ? AND limit_type_id = ? AND amount = ?;";
    String LIMITS_DELETE = "DELETE FROM limits WHERE user_id = ? AND limit_type_id = ?;";
}
