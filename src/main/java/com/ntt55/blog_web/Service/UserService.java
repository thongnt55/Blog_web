package com.ntt55.blog_web.Service;

import com.ntt55.blog_web.Model.Action;
import com.ntt55.blog_web.Model.Role;
import com.ntt55.blog_web.Model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoletoUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

    Action saveAction(Action action);
    User findUserByUserName(String username);


}
