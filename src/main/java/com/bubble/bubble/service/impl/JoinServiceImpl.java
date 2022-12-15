package com.bubble.bubble.service.impl;

import com.bubble.bubble.entity.App;
import com.bubble.bubble.entity.Join;
import com.bubble.bubble.exception.ResourceNotFoundException;
import com.bubble.bubble.repository.AppRepository;
import com.bubble.bubble.repository.JoinRepository;
import com.bubble.bubble.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceImpl implements JoinService {
    @Autowired
    private AppRepository appRepository;
    @Autowired
    private JoinRepository joinRepository;
    @Override
    public Join CreateJoin(long userId, long appId, Join join) {
        App app= appRepository.findById(appId).orElseThrow(() -> new ResourceNotFoundException("APP", "id", appId));
join.setApp(app);
Join joinCreated=joinRepository.save(join);
return joinCreated;
    }
}
