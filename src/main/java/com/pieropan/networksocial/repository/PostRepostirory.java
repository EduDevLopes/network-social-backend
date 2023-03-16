package com.pieropan.networksocial.repository;

import com.pieropan.networksocial.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepostirory extends JpaRepository<Post, Long> {
}