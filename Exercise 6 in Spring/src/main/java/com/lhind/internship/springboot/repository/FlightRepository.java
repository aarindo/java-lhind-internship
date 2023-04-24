package com.lhind.internship.springboot.repository;

import com.lhind.internship.springboot.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository <Flight, Integer> {

}
