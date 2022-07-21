package com.ntt55.blog_web.Service.impl;

import com.ntt55.blog_web.Model.Action;
import com.ntt55.blog_web.Model.Role;
import com.ntt55.blog_web.Model.User;
import com.ntt55.blog_web.Repository.ActionRepo;
import com.ntt55.blog_web.Repository.RoleRepo;
import com.ntt55.blog_web.Repository.UserRepo;
import com.ntt55.blog_web.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final ActionRepo actionRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepo.findUserByUserName(username);
        if(user==null){
            log.error("user not found int the db");
            throw new UsernameNotFoundException("user not found in the db");
        }else {
            log.info("user found in the db: {}",username);

        }
        Collection<SimpleGrantedAuthority> authorrities= new ArrayList<>();
        user.getRoles().forEach(role -> {authorrities.add(new SimpleGrantedAuthority(role.getRole()));});
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorrities);
    }
    @Override
    public User saveUser(User user) {
        log.info("saving user{} to db",user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role{} to db",role.getRole());
        return roleRepo.save(role);
    }
    @Override
    public Action saveAction(Action action) {
        log.info("saving role{} to db",action.getAction());
        return actionRepo.save(action);
    }

    @Override
    public User findUserByUserName(String username) {
        return null;
    }

    @Override
    public void addRoletoUser(String username, String roleName) {
        log.info("adding role{} to user{}",roleName,username);
        User user= userRepo.findUserByUserName(username);
        Role role = roleRepo.findByRole(roleName);
        user.getRoles().add(role);

    }

    @Override
    public User getUser(String username) {
        return userRepo.findUserByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

}
