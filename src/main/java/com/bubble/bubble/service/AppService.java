package com.bubble.bubble.service;

import com.bubble.bubble.entity.App;

import java.util.List;

public interface AppService {
    App createApp(App app,long userId);
    List<App> getAppByUserID(long userId);
    List<App> deleteApp(long userID,long appId);
    App editApp(App app,long userId);
}
