package com.ntt55.blog_web.Repository;


import com.ntt55.blog_web.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Integer> {

    User findUserByUserName(String username);

    @Query(value = "select account_id from  vaccine_management.account where user_name = ?1", nativeQuery = true)
    Integer findIdUserByUserName(String username);

    @Query(value = "SELECT user_name from  vaccine_management.account where user_name = ?1", nativeQuery = true)
    String existsByUserName(String username);

    @Query(value = "SELECT email FROM account where email= ?1", nativeQuery = true)
    String existsByEmail(String email);

    @Modifying
    @Query(value = "insert into account(user_name,encrypt_pw,is_enabled,verification_code,email) values (?1,?2,?3,?4,?5)", nativeQuery = true)
    void addNew(String username, String password, Boolean isActive,String email);

    @Query(value = "select * from account where verification_code =?1",nativeQuery = true)
    User findUserByVerificationCode(String verifyCode);

    @Modifying
    @Query(value ="update account set verification_code=?1 where user_name =?2",nativeQuery = true)
    void addVerificationCode(String code,String username);

    @Query(value = "select * from account", nativeQuery = true)
    List<User> getAllUser();

    @Modifying
    @Query(value = "insert into account(user_name,encrypt_pw) values (?1,?2)", nativeQuery = true)
    void addNewUser(String username, String password);

    @Modifying
    @Query(value = "update account set encrypt_pw =?1,verification_code=null where verification_code=?2 ",nativeQuery = true)
    void saveNewPassword(String password, String code);
}
