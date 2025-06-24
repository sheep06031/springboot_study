package com.pernoalsyudy4db.dbms_study.dto;

import com.pernoalsyudy4db.dbms_study.entity.JpaPost;
import com.pernoalsyudy4db.dbms_study.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class WritePostReqDto {
    private String title;
    private String content;
    private Integer userId;

    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .userId(this.userId)
                .build();
    }

    public JpaPost toJpaEntity() {
        return JpaPost.builder()
                .title(this.title)
                .content(this.content)
                .userId(this.userId)
                .creatDt(LocalDateTime.now())
                .build();
    }
}
