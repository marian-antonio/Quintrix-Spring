package com.quintrix.jfs.QuintrixSpring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quintrix.jfs.QuintrixSpring.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
