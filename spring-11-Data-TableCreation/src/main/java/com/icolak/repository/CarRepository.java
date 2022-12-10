package com.icolak.repository;

import com.icolak.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //After certain version it is not mandatory
public interface CarRepository extends JpaRepository<Car, Long> {
}
