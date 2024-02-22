package org.example.cache;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserCache
 * LimitTypeCache 测试类
 *
 * @author yiyun (huangdu.hd@alibaba-inc.com)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {
    @Autowired
    private UserCache userCache;
    @Autowired
    private LimitTypeCache limitTypeCache;

    @Test
    public void test() {
        check(userCache);
        check(limitTypeCache);
    }

    private void check(BaseCache cache) {
        Assert.assertNotNull(cache.getIdNameMap());
        Assert.assertNotNull(cache.getNameIdMap());
        Assert.assertTrue(cache.getIdNameMap().size() > 0);
        Assert.assertTrue(cache.getNameIdMap().size() > 0);
        Assert.assertEquals(cache.getIdNameMap().size(), cache.getIdNameMap().size());
        System.out.println(cache.getIdNameMap());
        System.out.println(cache.getIdNameMap());
    }
}
