package org.example.service;

import org.example.repository.LimitRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * LimitService 测试类
 *
 * @author huangdu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LimitServiceTest {
    @Autowired
    private LimitService limitService;
    @Autowired
    private LimitRepository limitRepository;

    private static final long TEST_USER_ID = 1L;
    private static final long TEST_LIMIT_TYPE = 1L;

    @Test
    public void test() {
        Assert.assertTrue(limitService.initialize(TEST_USER_ID, TEST_LIMIT_TYPE, 0.0));
        Assert.assertEquals((Double)0.0, limitService.inquire(TEST_USER_ID, TEST_LIMIT_TYPE));
        Assert.assertTrue(limitService.increase(TEST_USER_ID, TEST_LIMIT_TYPE, 10.0));
        Assert.assertEquals((Double)10.0, limitService.inquire(TEST_USER_ID, TEST_LIMIT_TYPE));
        Assert.assertTrue(limitService.decrease(TEST_USER_ID, TEST_LIMIT_TYPE, 10.0));
        Assert.assertEquals((Double)0.0, limitService.inquire(TEST_USER_ID, TEST_LIMIT_TYPE));
        Assert.assertTrue(limitRepository.delete(TEST_USER_ID, TEST_LIMIT_TYPE));
    }
}
