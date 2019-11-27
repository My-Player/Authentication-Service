package com.java.authentication.service.dao;

import com.java.authentication.service.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserData,String> {
    @Query(value = "SELECT * FROM user_schema.user_data where user_email = :userId", nativeQuery = true)
    UserData findUserByUserEmail(@Param("userId") String userEmail);
}
