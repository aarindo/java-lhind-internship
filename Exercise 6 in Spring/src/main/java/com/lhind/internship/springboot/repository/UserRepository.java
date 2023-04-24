package com.lhind.internship.springboot.repository;

import com.lhind.internship.springboot.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE first_name = :firstName", nativeQuery = true)
    List<User> findByFirstName(String firstName);

}
