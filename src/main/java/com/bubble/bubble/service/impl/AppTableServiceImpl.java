package com.bubble.bubble.service.impl;

import com.bubble.bubble.entity.App;
import com.bubble.bubble.entity.AppTable;
import com.bubble.bubble.entity.Column;
import com.bubble.bubble.exception.ResourceNotFoundException;
import com.bubble.bubble.repository.AppRepository;
import com.bubble.bubble.repository.AppTableRepository;
import com.bubble.bubble.service.AppTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AppTableServiceImpl implements AppTableService {
    @Autowired
    private AppTableRepository appTableRepository;
    @Autowired
    private AppRepository appRepository;
    @Override
    public AppTable createAppTable(AppTable appTable,long userId,long appId) {
        App app= appRepository.findById(appId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", appId));
        appTable.setApp(app);
        Set<Column> column = appTable.getColumn();
        for( Column c:column){
            c.setAppTable(appTable);
        }

        AppTable newAppTable = appTableRepository.save(appTable);
        return newAppTable;
    }

    @Override
    public List<AppTable> getAppTableByAppID(long appId) {
    List<AppTable> appTables= appTableRepository.findByAppId(appId);
    return appTables;
    }
}
