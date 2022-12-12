package com.bubble.bubble.service.impl;

import com.bubble.bubble.entity.AppTable;
import com.bubble.bubble.entity.Column;
import com.bubble.bubble.repository.AppTableRepository;
import com.bubble.bubble.service.AppTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AppTableServiceImpl implements AppTableService {
    @Autowired
    private AppTableRepository appTableRepository;
    @Override
    public AppTable createAppTable(AppTable appTable) {
        Set<Column> column = appTable.getColumn();
        for( Column c:column){
            c.setAppTable(appTable);
        }

        AppTable newAppTable = appTableRepository.save(appTable);
        return newAppTable;
    }
}
