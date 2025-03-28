package com.sobhan.blog_management.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sobhan.blog_management.dto.BlogDTO;
import com.sobhan.blog_management.services.BlogService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    // Create a new blog
    // Request body should contain title, content, and author
    // Example: { "title": "My First Blog", "content": "This is the content of my first blog.", "author": "John Doe" }
    @PostMapping
    public ResponseEntity<BlogDTO> createBlog(@Valid @RequestBody BlogDTO blogDTO) {
        BlogDTO createdBlog = blogService.createBlog(blogDTO);
        return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
    }

    // Get all blogs with pagination and sorting
    // Default page size is 5, page number is 0, sorted by createdAt in descending order
    // You can change the default values by passing query parameters like ?page=1&size=10&sort=title,asc
    @GetMapping
    public ResponseEntity<Page<BlogDTO>> getAllBlogs(
        @PageableDefault(size = 5, page = 0, sort = "createdAt", direction = Sort.Direction.DESC)
        Pageable pageable
    ) {
        return ResponseEntity.ok(blogService.getAllBlogs(pageable));
    }

    // Get the blog by ID
    // Example: /api/v1/blogs/1
    // Response: { "id": 1, "title": "First Blog", "content": "This is the content of my first blog.", "author": "John Doe", "createdAt": "2023-10-01 12:00:00" }
    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlogByID(@PathVariable("id") Long blogID) {
        return ResponseEntity.ok(blogService.getBlogById(blogID));
    }

    // Update the blog by ID
    // Request body should contain title, content, and author
    // Example: { "title": "Updated Blog Title", "content": "Updated content.", "author": "Jane Doe" }
    @PutMapping("/{id}")
    public ResponseEntity<BlogDTO> updateBlogByID(@PathVariable("id") Long blogID, @Valid @RequestBody BlogDTO blogUpdate) {
        return ResponseEntity.ok(blogService.updateBlog(blogID, blogUpdate));
    }

    // Delete the blog by ID
    // Example: /api/v1/blogs/1
    // Response: { "id": 1, "title": "First Blog", "content": "This is the content of my first blog.", "author": "John Doe", "createdAt": "2023-10-01 12:00:00" }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogByID(@PathVariable("id") Long blogID) {
        blogService.deleteBlog(blogID);
        return ResponseEntity.noContent().build();
    }

}
