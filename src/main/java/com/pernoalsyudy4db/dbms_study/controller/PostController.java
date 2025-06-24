package com.pernoalsyudy4db.dbms_study.controller;

import com.pernoalsyudy4db.dbms_study.dto.EditPostReqDto;
import com.pernoalsyudy4db.dbms_study.dto.WritePostReqDto;
import com.pernoalsyudy4db.dbms_study.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/write")
    public ResponseEntity<?> writePost(@RequestBody WritePostReqDto writePostReqDto) {
        return ResponseEntity.ok(postService.writePost(writePostReqDto));
    }

    @PostMapping("search/{postId}")
    public ResponseEntity<?> getPostByPostId(@PathVariable Integer postId) {
        return ResponseEntity.ok(postService.getPostByPostId(postId));
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editPost(@RequestBody EditPostReqDto editPostReqDto) {
        return ResponseEntity.ok(postService.editPost(editPostReqDto));
    }

    @GetMapping("/get/list")
    public ResponseEntity<?> getPostList() {
        return ResponseEntity.ok(postService.getPostList());
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removePost(@RequestParam Integer postId) {
        return ResponseEntity.ok(postService.removePost(postId));
    }


}
