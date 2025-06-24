package com.pernoalsyudy4db.dbms_study.controller;

import com.pernoalsyudy4db.dbms_study.dto.AddUserReqDto;
import com.pernoalsyudy4db.dbms_study.dto.EditUserReqDto;
import com.pernoalsyudy4db.dbms_study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> adduser(@RequestBody AddUserReqDto addUserReqDto) {
        return ResponseEntity.ok(userService.addUser(addUserReqDto));
    }

    @GetMapping("/get/list")
    public ResponseEntity<?> getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<?> getUserByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editUser(@RequestBody EditUserReqDto editUserReqDto) {
        return ResponseEntity.ok(userService.editUser(editUserReqDto));
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeUser(@RequestParam Integer userId) {
        return ResponseEntity.ok(userService.removeUser(userId));
    }
}
