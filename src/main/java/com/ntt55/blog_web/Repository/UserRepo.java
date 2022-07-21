package com.ntt55.blog_web.Repository;

import com.ntt55.blog_web.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername (String username);
    User findByEmail (String email);
}
