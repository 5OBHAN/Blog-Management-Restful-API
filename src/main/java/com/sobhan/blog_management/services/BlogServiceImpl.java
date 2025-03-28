package com.sobhan.blog_management.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sobhan.blog_management.dto.BlogDTO;
import com.sobhan.blog_management.mapper.BlogMapper;
import com.sobhan.blog_management.model.Blog;
import com.sobhan.blog_management.repository.BlogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    @Override
    public BlogDTO createBlog(BlogDTO blogDTO) {
        Blog blog = blogMapper.toEntity(blogDTO);
        Blog savedBlog = blogRepository.save(blog);
        return blogMapper.toDTO(savedBlog);
    }

    @Override
    public Page<BlogDTO> getAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable).map(blogMapper::toDTO);
    }

    @Override
    public BlogDTO getBlogById(Long id) {
        return blogRepository.findById(id).map(blogMapper::toDTO).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found with id: " + id));
    }

    @Override
    public BlogDTO updateBlog(Long id, BlogDTO blogUpdate) {
        Blog existingBlog = blogRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found with id: " + id));
        existingBlog.setTitle(blogUpdate.getTitle());
        existingBlog.setContent(blogUpdate.getContent());
        existingBlog.setAuthor(blogUpdate.getAuthor());
        Blog updatedBlog = blogRepository.save(existingBlog);
        return blogMapper.toDTO(updatedBlog);
    }

    @Override
    public void deleteBlog(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found with id: " + id));
        blogRepository.delete(blog);
    }

}
