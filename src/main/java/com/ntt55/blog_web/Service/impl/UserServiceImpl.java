package com.ntt55.blog_web.Service.impl;

import com.ntt55.blog_web.Model.Role;
import com.ntt55.blog_web.Model.User;
import com.ntt55.blog_web.Repository.RoleRepo;
import com.ntt55.blog_web.Repository.UserRepo;
import com.ntt55.blog_web.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public User saveUser(User user) {
        log.info("saving user{} to db",user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role{} to db",role.getRole());
        return roleRepo.save(role);
    }

    @Override
    public void addRoletoUser(String username, String roleName) {
        log.info("adding role{} to user{}",roleName,username);
        User user= userRepo.findByUsername(username);
        Role role = roleRepo.findByRole(roleName);
        user.getRoles().add(role);

    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
