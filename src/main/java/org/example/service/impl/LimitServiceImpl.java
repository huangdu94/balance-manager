package org.example.service.impl;

import org.example.repository.LimitRepository;
import org.example.service.LimitService;
import org.example.validation.ParameterValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * LimitService 实现类
 *
 * @author yiyun (huangdu.hd@alibaba-inc.com)
 */
@Service
public class LimitServiceImpl implements LimitService {
    @Autowired
    private LimitRepository limitRepository;
    @Autowired
    private ParameterValidation parameterValidation;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean initialize(Long userId, Long limitTypeId, Double amount) {
        parameterValidation.check(userId, limitTypeId, amount);
        parameterValidation.check(limitRepository.count(userId, limitTypeId) == 0, "limit already exist.");
        return limitRepository.insert(userId, limitTypeId, amount);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean increase(Long userId, Long limitTypeId, Double amount) {
        parameterValidation.check(userId, limitTypeId, amount);
        parameterValidation.check(limitRepository.count(userId, limitTypeId) > 0, "limit is not exist.");
        Double origin = limitRepository.select(userId, limitTypeId);
        return limitRepository.update(userId, limitTypeId, origin, origin + amount);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean decrease(Long userId, Long limitTypeId, Double amount) {
        parameterValidation.check(userId, limitTypeId, amount);
        parameterValidation.check(limitRepository.count(userId, limitTypeId) > 0, "limit is not exist.");
        Double origin = limitRepository.select(userId, limitTypeId);
        parameterValidation.checkAmount(origin - amount);
        return limitRepository.update(userId, limitTypeId, origin, origin - amount);
    }

    @Override
    public Double inquire(Long userId, Long limitTypeId) {
        parameterValidation.check(userId, limitTypeId);
        parameterValidation.check(limitRepository.count(userId, limitTypeId) > 0, "limit is not exist.");
        return limitRepository.select(userId, limitTypeId);
    }
}
