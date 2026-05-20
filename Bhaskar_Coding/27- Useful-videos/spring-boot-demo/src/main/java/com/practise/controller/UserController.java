package com.practise.controller;

import com.practise.config.PropertiesConfig;
import com.practise.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PropertiesConfig properties;

    @PostMapping("/create")
    public ResponseEntity<String> createuser(@Valid @RequestBody User user){
        return  new ResponseEntity<>("User Register successfully", HttpStatus.CREATED);
    }

    @GetMapping("/dbConfig")
    public ResponseEntity<String> getDbConfig(){
        String dbData=properties.getServerName()+" \n "+ properties.getUserName()+" \n "+properties.getPassword()+
                " \n "+properties.getServerPort();
        return new ResponseEntity<>(dbData,HttpStatus.OK);
    }
}
