package com.ntt55.blog_web.Repository;


import com.ntt55.blog_web.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Integer> {

    User findUserByUserName(String username);
}

