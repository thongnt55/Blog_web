package com.ntt55.blog_web;

import com.ntt55.blog_web.Model.Role;
import com.ntt55.blog_web.Model.User;
import com.ntt55.blog_web.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class BlogWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogWebApplication.class, args);
    }

    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role( null, "ROLE_USER"));
            userService.saveRole(new Role( null, "ROLE_ADMIN"));
            userService.saveRole(new Role( null, "ROLE_ANONYMOUS"));
            userService.saveRole(new Role( null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"thong","thong","thong", new ArrayList<User>()));
            userService.saveUser(new User(null,"thong","thong2","thong2", new ArrayList<User>()));
            userService.saveUser(new User(null,"thong","thong3","thong3", new ArrayList<User>()));
            userService.saveUser(new User(null,"thong","thong1","thong1", new ArrayList<User>()));

            userService.addRoletoUser("thong","ROLE_ADMIN");
            userService.addRoletoUser("thong1","ROLE_USER");
            userService.addRoletoUser("thong2","ROLE_ANONYMOUS");
            userService.addRoletoUser("thong3","ROLE_ANONYMOUS");
        };

    }

}


//package com.ntt55.blog_web.Controller;
//
//        import com.ntt55.blog_web.Model.Role;
//        import com.ntt55.blog_web.Model.User;
//        import com.ntt55.blog_web.Service.UserService;
//        import lombok.RequiredArgsConstructor;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.web.bind.annotation.PostMapping;
//        import org.springframework.web.bind.annotation.RequestBody;
//        import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequiredArgsConstructor
//public class RoleController {
//    private final UserService userService;
//
//
//    @PostMapping("/role")
//    public ResponseEntity<Role> saveRole(@RequestBody Role role){
//
//        return ResponseEntity.ok().body(userService.saveRole(role));
//    }
//
//}
