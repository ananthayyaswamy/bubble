package com.bubble.bubble.controller;

import ch.qos.logback.core.boolex.EvaluationException;
import com.bubble.bubble.entity.App;
import com.bubble.bubble.entity.AppTable;
import com.bubble.bubble.service.AppTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/app/{userId}/app-table/")
public class AppTableController {
    @Autowired
    private AppTableService appTableService;
    @PostMapping("{appId}/")
    public ResponseEntity<AppTable> createAppTable(@RequestBody AppTable appTable, @PathVariable(value = "userId")Long userId,@PathVariable(value = "appId")Long appId){
        return new ResponseEntity<>(appTableService.createAppTable(appTable,userId,appId), HttpStatus.CREATED);
    }
    @GetMapping("{appId}/")
    public List<AppTable> getAppTableByAppId(@PathVariable(value = "appId")Long appId){
        return appTableService.getAppTableByAppID(appId);
    }
    @DeleteMapping("{appId}/delete/{tableId}/")
    public List<AppTable> deleteApp(@PathVariable(value = "tableId")Long tableId,@PathVariable(value = "appId")Long appId){
        System.out.println("b4 in impl");
        return appTableService.deleteAppById(appId,tableId);
    }
    @PutMapping("{tableId}/")
    public ResponseEntity<AppTable> editTable(@PathVariable(value = "userId")Long userID,@RequestBody AppTable table){
       AppTable appTable =appTableService.editTable(table,userID);
       return new ResponseEntity<>(appTable,HttpStatus.OK);

    }
}
