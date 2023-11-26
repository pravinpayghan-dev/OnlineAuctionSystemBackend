package com.project.OnlineAuctionSystemBackend.controller;

import com.project.OnlineAuctionSystemBackend.dto.UserDto;
import com.project.OnlineAuctionSystemBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userManagement")
@CrossOrigin
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    private String saveNewUser(@RequestBody UserDto userDto) {
        return userService.saveNewUser(userDto);
    }

    @PostMapping("/verifyUser")
    private String verifyUser(@RequestBody UserDto userDto) {
        return userService.verifyUser(userDto);
    }
}
