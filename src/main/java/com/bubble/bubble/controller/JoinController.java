package com.bubble.bubble.controller;

import com.bubble.bubble.entity.AppTable;
import com.bubble.bubble.entity.Join;
import com.bubble.bubble.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/app/{userId}/join/")
public class JoinController {
    @Autowired
    private JoinService joinService;
  @PostMapping("{appId}/")
    public ResponseEntity<Join> createJoin(@PathVariable(value = "userId")long userId,@PathVariable(value = "appId")long appId,@RequestBody Join join){
       return new ResponseEntity<>(joinService.CreateJoin(userId,appId,join), HttpStatus.CREATED);
   }
}
