package com.sobhan.blog_management.mapper;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.sobhan.blog_management.dto.BlogDTO;
import com.sobhan.blog_management.model.Blog;

@Component
public class BlogMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Blog toEntity(BlogDTO blogDTO) {
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setAuthor(blogDTO.getAuthor());
        return blog;
    }

    public BlogDTO toDTO(Blog blog) {
        return BlogDTO.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .author(blog.getAuthor())
                .createdAt(blog.getCreatedAt().format(FORMATTER))
                .build();
    }

}
