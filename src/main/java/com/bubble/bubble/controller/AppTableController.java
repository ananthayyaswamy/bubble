package com.bubble.bubble.controller;

import com.bubble.bubble.entity.AppTable;
import com.bubble.bubble.service.AppTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/app-table/")
public class AppTableController {
    @Autowired
    private AppTableService appTableService;
    @PostMapping
    public ResponseEntity<AppTable> createAppTable(@RequestBody AppTable appTable){
        return new ResponseEntity<>(appTableService.createAppTable(appTable), HttpStatus.CREATED);
    }
}
