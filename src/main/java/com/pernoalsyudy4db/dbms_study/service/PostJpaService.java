package com.pernoalsyudy4db.dbms_study.service;

import com.pernoalsyudy4db.dbms_study.dto.ApiRespDto;
import com.pernoalsyudy4db.dbms_study.dto.WritePostReqDto;
import com.pernoalsyudy4db.dbms_study.entity.JpaPost;
import com.pernoalsyudy4db.dbms_study.repository.PostJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostJpaService {
    @Autowired
    private PostJpaRepository postJpaRepository;

    public JpaPost addPost(WritePostReqDto writePostReqDto) {
        return postJpaRepository.save(writePostReqDto.toJpaEntity());
    }

    public List<JpaPost> getPostList() {
        return postJpaRepository.findAll();
    }

    public ApiRespDto<?> removePost(Integer postId) {
        Optional<JpaPost> optional = postJpaRepository.findById(postId);
        if(optional.isEmpty()) {
            return new ApiRespDto<>("해당 게시물이 존재하지 않습니다", null);
        }
        try {
            postJpaRepository.deleteById(postId);
        } catch (Exception e) {
            return new ApiRespDto<>("문제가 발생했습니다", e.getMessage());
        }
        return new ApiRespDto<>("삭제 성공", null);
    }
}
