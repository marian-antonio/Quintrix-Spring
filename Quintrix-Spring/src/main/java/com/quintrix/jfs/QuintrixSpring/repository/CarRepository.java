package com.quintrix.jfs.QuintrixSpring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quintrix.jfs.QuintrixSpring.models.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

}
