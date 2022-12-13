package com.bubble.bubble.controller;

import com.bubble.bubble.entity.App;
import com.bubble.bubble.entity.AppTable;
import com.bubble.bubble.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/app/")
public class AppController {
    @Autowired
    private AppService appService;
    @PostMapping("{userId}/")
    public ResponseEntity<App> createApp(@RequestBody App app ,@PathVariable(value = "userId")long userId){
        return new ResponseEntity<>(appService.createApp(app,userId), HttpStatus.CREATED);
    }
    @GetMapping("{userId}/")
    public List<App> getAppsByUserId(@PathVariable(value = "userId")Long userId){
       List<App> app= appService.getAppByUserID(userId);
        System.out.println("call returned");
        return app;
    }
}
