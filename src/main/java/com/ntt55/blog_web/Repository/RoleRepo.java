package com.ntt55.blog_web.Repository;

import com.ntt55.blog_web.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRole(String roleName);
}
