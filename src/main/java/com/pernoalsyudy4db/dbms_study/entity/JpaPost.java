package com.pernoalsyudy4db.dbms_study.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_tb")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JpaPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer postId;
    private String title;
    private String content;
    private int userId;
    private LocalDateTime creatDt;
    private LocalDateTime updateDt;

}
