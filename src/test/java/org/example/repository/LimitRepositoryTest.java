package org.example.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * LimitRepository 测试类
 *
 * @author huangdu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LimitRepositoryTest {
    @Autowired
    private LimitRepository limitRepository;
    private static final long TEST_USER_ID = 0L;
    private static final long TEST_LIMIT_TYPE = 0L;

    @Test
    public void test() {
        Assert.assertTrue(limitRepository.insert(TEST_USER_ID, TEST_LIMIT_TYPE, 100.0));
        Assert.assertEquals((Long)1L, limitRepository.count(TEST_USER_ID, TEST_LIMIT_TYPE));
        Assert.assertEquals((Double)100.0, limitRepository.select(TEST_USER_ID, TEST_LIMIT_TYPE));
        Assert.assertFalse(limitRepository.update(TEST_USER_ID, TEST_LIMIT_TYPE, 110.0, 100.0));
        Assert.assertTrue(limitRepository.update(TEST_USER_ID, TEST_LIMIT_TYPE, 100.0, 110.0));
        Assert.assertEquals((Double)110.0, limitRepository.select(TEST_USER_ID, TEST_LIMIT_TYPE));
        Assert.assertTrue(limitRepository.delete(TEST_USER_ID, TEST_LIMIT_TYPE));
        Assert.assertEquals((Long)0L, limitRepository.count(TEST_USER_ID, TEST_LIMIT_TYPE));
    }
}
