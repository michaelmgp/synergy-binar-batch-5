package com.example.challenge_5.repositories.security;


import com.example.challenge_5.model.security.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query("FROM User u WHERE LOWER(u.email) = LOWER(?1)")
    User findOneByEmail(String username);

    @Query("FROM User u WHERE u.otp = ?1")
    User findOneByOTP(String otp);

    @Query("FROM User u WHERE LOWER(u.email) = LOWER(:username)")
    User checkExistingEmail(String username);
}

