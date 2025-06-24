package com.pernoalsyudy4db.dbms_study.repository;

import com.pernoalsyudy4db.dbms_study.entity.JpaPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostJpaRepository extends JpaRepository<JpaPost, Integer> {

}
