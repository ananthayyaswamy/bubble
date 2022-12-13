package com.bubble.bubble.service.impl;

import com.bubble.bubble.entity.App;
import com.bubble.bubble.entity.User;
import com.bubble.bubble.repository.AppRepository;
import com.bubble.bubble.repository.UserRepository;
import com.bubble.bubble.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppRepository appRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public App createApp(App app,long userId) {
        System.out.println(app.toString());
        User user =userRepository.findById(userId);
        app.setUserTable(user);

      App app1= appRepository.save(app);
      return app1;
    }

    @Override
    public List<App> getAppByUserID(long userId) {
       List<App> apps =appRepository.findByUserTableId(userId);
       for(App a:apps){
           System.out.println(a.toString());
       }
       return apps;
    }
}
