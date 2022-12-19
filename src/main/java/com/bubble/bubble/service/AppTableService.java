package com.bubble.bubble.service;

import com.bubble.bubble.entity.App;
import com.bubble.bubble.entity.AppTable;

import java.util.List;

public interface AppTableService {
    AppTable createAppTable(AppTable appTable,long userId,long appId);
    List<AppTable> getAppTableByAppID(long appId);
    List<AppTable> deleteAppById(long appId,long tableId);
    AppTable editTable(AppTable table,long userId);
}
