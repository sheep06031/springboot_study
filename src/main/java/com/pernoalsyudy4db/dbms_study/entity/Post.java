package com.pernoalsyudy4db.dbms_study.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
public class Post {
    private Integer postId;
    private String title;
    private String content;
    private int userId;
    private LocalDateTime creatDt;
    private LocalDateTime updateDt;

}
