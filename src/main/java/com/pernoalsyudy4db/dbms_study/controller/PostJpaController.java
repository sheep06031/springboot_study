package com.pernoalsyudy4db.dbms_study.controller;

import com.pernoalsyudy4db.dbms_study.dto.WritePostReqDto;
import com.pernoalsyudy4db.dbms_study.service.PostJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa/post")
public class PostJpaController {

    @Autowired
    private PostJpaService postJpaService;

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody WritePostReqDto writePostReqDto) {
        return ResponseEntity.ok(postJpaService.addPost(writePostReqDto));
    }

    @PostMapping("/get/list")
    public ResponseEntity<?> getPostList() {
        return ResponseEntity.ok(postJpaService.getPostList());
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removePost(Integer postId) {
        return ResponseEntity.ok(postJpaService.removePost(postId));
    }
 }
