package com.java.authentication.service.controller;

import com.java.authentication.service.dto.UserDataDto;
import com.java.authentication.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/getAllUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserDetail(){
        return new ResponseEntity(userService.getUserData(),HttpStatus.OK);
    }

    @GetMapping(value = "/profile",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAuthenticatedUser(@RequestParam String userId){
        return new ResponseEntity(userService.getUserDetail(userId),HttpStatus.OK);
    }

    @PutMapping(value = "/editProfile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editProfile(@RequestParam String userId, @RequestBody UserDataDto userDataDto){
        return new ResponseEntity(userService.editUserDetail(userId,userDataDto),HttpStatus.OK);
    }

}
