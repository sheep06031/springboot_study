package com.pernoalsyudy4db.dbms_study.service;

import com.pernoalsyudy4db.dbms_study.dto.*;
import com.pernoalsyudy4db.dbms_study.entity.Post;
import com.pernoalsyudy4db.dbms_study.entity.User;
import com.pernoalsyudy4db.dbms_study.mapper.PostMapper;
import com.pernoalsyudy4db.dbms_study.repository.PostRepository;
import com.pernoalsyudy4db.dbms_study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Map<String, String> writePost(WritePostReqDto writePostReqDto) {
        Map<String, String> response = new HashMap<>();
        Optional<User> user = userRepository.getUserByUserId(writePostReqDto.getUserId());
        if (user.isEmpty()) {
            response.put("status", "failed");
            response.put("message", "해당 유저가 존재하지 않습니다");
            return response;
        }
        int result = postRepository.writePost(writePostReqDto.toEntity());
        if (result == 1) {
            response.put("status", "success");
            response.put("message", "추가 성공");
            return response;
        }
        response.put("status", "failed");
        response.put("message", "추가 실패");
        return response;
    }

    public ApiRespDto<Post> getPostByPostId(Integer postId) {
        Optional<Post> post = postRepository.getPostByPostId(postId);
        if (post.isEmpty()) {
            return new ApiRespDto<>("포스트를 찾을 수 없습니다", null);
        }
        return new ApiRespDto<>("Post", post.get());
    }

    public ApiRespDto<Post> editPost(EditPostReqDto editPostReqDto) {
        Optional<Post> post = postRepository.getPostByPostId(editPostReqDto.getPostId());
        if(post.isEmpty()) return new ApiRespDto<>("해당 포스트가 존재하지 않습니다", null);
        int result = postRepository.editPost(editPostReqDto.toEntity());
        if (result == 0) return new ApiRespDto<>("문제가 발생했습니다", null);

        return new ApiRespDto<>("포스트가 수정 되었습니다", null);
    }

    public List<Post> getPostList() {
        return postRepository.getPostList();
    }

    public ApiRespDto<Integer> removePost(Integer postId) {
        Optional<Post> post = postRepository.getPostByPostId(postId);
        if(post.isEmpty()) {return new ApiRespDto<>("해당 포스트가 존재하지 않습니다", null);}
        int result = userRepository.removeUser(postId);
        if(result == 0) return new ApiRespDto<>("문제가 발생했습니다", result);
        return new ApiRespDto<>("성공적으로 삭제 되었습니다", result);
    }
}
