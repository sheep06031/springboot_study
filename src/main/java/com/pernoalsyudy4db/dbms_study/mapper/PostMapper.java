package com.pernoalsyudy4db.dbms_study.mapper;

import com.pernoalsyudy4db.dbms_study.entity.Post;
import com.pernoalsyudy4db.dbms_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    int write(Post post);
    int editPost(Post post);
    Optional<Post> getPostByPostId(Integer postId);
    List<Post> getPostList();
    int removePost(Integer post);
}
