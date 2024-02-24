package org.example.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 抽象缓存
 *
 * @author huangdu
 */
public abstract class BaseCache {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Map<Long, String> idNameMap;
    private Map<String, Long> nameIdMap;
    private List<Long> ids;

    public void init(String sql) {
        List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
        idNameMap = new HashMap<>(records.size());
        nameIdMap = new HashMap<>(records.size());
        ids = new ArrayList<>(records.size());
        for (Map<String, Object> record : records) {
            Long id = Long.valueOf((Integer)record.get("id"));
            String name = (String)record.get("name");
            idNameMap.put(id, name);
            nameIdMap.put(name, id);
            ids.add(id);
        }
    }

    public Map<Long, String> getIdNameMap() {
        return idNameMap;
    }

    public Map<String, Long> getNameIdMap() {
        return nameIdMap;
    }

    public List<Long> getIds() {
        return ids;
    }
}
