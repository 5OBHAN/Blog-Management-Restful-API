package com.sobhan.blog_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sobhan.blog_management.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
