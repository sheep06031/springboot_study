package com.pernoalsyudy4db.dbms_study.repository;


import com.pernoalsyudy4db.dbms_study.entity.Post;
import com.pernoalsyudy4db.dbms_study.entity.User;
import com.pernoalsyudy4db.dbms_study.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {

    @Autowired
    PostMapper postMapper;

    public int writePost(Post post) {return postMapper.write(post);}
    public Optional<Post> getPostByPostId(Integer postId) {
        return postMapper.getPostByPostId(postId);
    }
    public int editPost(Post post) {return postMapper.editPost(post);}
    public List<Post> getPostList() {return postMapper.getPostList();}
    public int removePost(Integer postId) {
        return postMapper.removePost(postId);
    }
}
