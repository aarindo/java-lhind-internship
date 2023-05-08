package com.lhind.internship.springboot.repository;

import com.lhind.internship.springboot.model.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository <UserDetail, Integer> {

}
