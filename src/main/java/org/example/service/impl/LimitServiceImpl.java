package org.example.service.impl;

import org.example.repository.LimitRepository;
import org.example.service.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LimitService 实现类
 *
 * @author yiyun (huangdu.hd@alibaba-inc.com)
 */
@Service
public class LimitServiceImpl implements LimitService {
    @Autowired
    private LimitRepository limitRepository;

    @Override
    public boolean initialize(Long userId, Long limitTypeId, Double amount) {
        return false;
    }

    @Override
    public boolean increase(Long userId, Long limitTypeId, Double amount) {
        return false;
    }

    @Override
    public boolean decrease(Long userId, Long limitTypeId, Double amount) {
        return false;
    }

    @Override
    public Double inquire(Long userId, Long limitTypeId) {
        return null;
    }
}
