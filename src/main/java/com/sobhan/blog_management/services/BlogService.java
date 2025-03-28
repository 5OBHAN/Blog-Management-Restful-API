package com.sobhan.blog_management.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sobhan.blog_management.dto.BlogDTO;

public interface BlogService {
    BlogDTO createBlog(BlogDTO blogDTO);
    Page<BlogDTO> getAllBlogs(Pageable pageable);
    BlogDTO getBlogById(Long id);
    BlogDTO updateBlog(Long id, BlogDTO blogUpdate);
    void deleteBlog(Long id);
}
