package com.bubble.bubble.service;

import com.bubble.bubble.entity.Join;

public interface JoinService {
    Join CreateJoin(long userId, long appId, Join join);
}
