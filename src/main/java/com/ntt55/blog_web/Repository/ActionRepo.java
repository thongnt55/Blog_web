package com.ntt55.blog_web.Repository;

import com.ntt55.blog_web.Model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepo extends JpaRepository<Action,Long> {
    Action findByAction(String actionName);
}
