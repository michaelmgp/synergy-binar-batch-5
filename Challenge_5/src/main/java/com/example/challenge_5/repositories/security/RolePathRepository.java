package com.example.challenge_5.repositories.security;

import com.example.challenge_5.model.security.RolePath;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface RolePathRepository extends PagingAndSortingRepository<RolePath, Long> {
    RolePath findOneByName(String rolePathName);

    @Query(value = "SELECT p.* FROM oauth_role_path p " +
            "JOIN oauth_role r ON r.id = p.role_id " +
            "JOIN oauth_user_role ur ON ur.role_id = r.id " +
            "WHERE ur.user_id = ?1", nativeQuery = true)
//    @Query(value = "SELECT p FROM RolePath p " +
//            "JOIN Role r ON r.id=p.role.id " +
//            "JOIN RolePath  ur ON ur.role.id = r.id " +
//            "WHERE ur.user.id = ?1 ")
    <T extends UserDetails> List<RolePath> findByUser(T user);
}