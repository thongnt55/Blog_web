package com.ntt55.blog_web.repository;

import com.ntt55.blog_web.Model.Post;
import com.ntt55.blog_web.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByUserOrderByCreateDateDesc(User user, Pageable pageable);

    Page<Post> findAllByOrderByCreateDateDesc(Pageable pageable);

    Optional<Post> findById(Long id);
}
