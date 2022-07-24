package com.ntt55.blog_web.service;
import com.ntt55.blog_web.Model.Post;
import com.ntt55.blog_web.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PostService {
    Optional<Post> findForId(Long id);

    Post save(Post post);

    /**
     * Finds a {@link Page) of {@link Post} of provided user ordered by date
     */
    Page<Post> findByUserOrderedByDatePageable(User user, int page);

    /**
     * Finds a {@link Page) of all {@link Post} ordered by date
     */
    Page<Post> findAllOrderedByDatePageable(int page);

    void delete(Post post);
}
