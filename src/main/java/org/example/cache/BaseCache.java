package org.example.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 抽象缓存
 *
 * @author yiyun (huangdu.hd@alibaba-inc.com)
 */
public abstract class BaseCache {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Map<Long, String> idNameMap;
    private Map<String, Long> nameIdMap;

    public void init(String sql) {
        List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
        idNameMap = new HashMap<>(records.size());
        nameIdMap = new HashMap<>(records.size());
        for (Map<String, Object> record : records) {
            idNameMap.put(Long.valueOf((Integer)record.get("id")), (String)record.get("name"));
            nameIdMap.put((String)record.get("name"), Long.valueOf((Integer)record.get("id")));
        }
    }

    public Map<Long, String> getIdNameMap() {
        return idNameMap;
    }

    public Map<String, Long> getNameIdMap() {
        return nameIdMap;
    }
}
