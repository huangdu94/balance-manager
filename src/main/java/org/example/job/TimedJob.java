package org.example.job;

import java.util.List;
import java.util.Random;

import org.example.cache.LimitTypeCache;
import org.example.cache.UserCache;
import org.example.service.LimitService;
import org.example.util.LimitServiceLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 模拟多用户操作的定时任务
 *
 * @author huangdu
 */
@Component
public class TimedJob {
    @Autowired
    private UserCache userCache;
    @Autowired
    private LimitTypeCache limitTypeCache;
    @Autowired
    private LimitService limitService;
    @Autowired
    private LimitServiceLogUtil logUtil;
    private static final String[] OPTS = {"initialize", "increase", "decrease", "inquire"};

    @Scheduled(fixedRate = 1000)
    public void executeEverySecond() {
        Random random = new Random();
        List<Long> userIdList = userCache.getIds(), limitTypeIdList = limitTypeCache.getIds();
        Long userId = userIdList.get(random.nextInt(userIdList.size())), limitTypeId = limitTypeIdList.get(random.nextInt(limitTypeIdList.size()));
        Double amount = random.nextDouble() * 10000 - 10;
        String opt = OPTS[random.nextInt(OPTS.length)];
        execute(opt, userId, limitTypeId, amount);
    }

    private void execute(String opt, Long userId, Long limitTypeId, Double amount) {
        try {
            switch (opt) {
                case "initialize":
                    logUtil.initialize(userId, limitTypeId, amount);
                    logUtil.result(limitService.initialize(userId, limitTypeId, amount));
                    return;
                case "increase":
                    logUtil.increase(userId, limitTypeId, amount);
                    logUtil.result(limitService.increase(userId, limitTypeId, amount));
                    return;
                case "decrease":
                    logUtil.decrease(userId, limitTypeId, amount);
                    logUtil.result(limitService.decrease(userId, limitTypeId, amount));
                    return;
                default:
                case "inquire":
                    logUtil.inquire(userId, limitTypeId);
                    logUtil.result(limitService.inquire(userId, limitTypeId));
            }
        } catch (Exception e) {
            logUtil.error(e);
        }
    }
}
