package com.quintrix.jfs.QuintrixSpring;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.quintrix.jfs.QuintrixSpring.entity.Employee;
import com.quintrix.jfs.QuintrixSpring.repository.EmployeeRepository;

@SpringBootApplication
public class QuintrixSpringApplication implements CommandLineRunner {
  @Autowired
  EmployeeRepository employeeRepository;

  public static void main(String[] args) {
    SpringApplication.run(QuintrixSpringApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Optional<Employee> employee = employeeRepository.findById(1);
    System.out.println(employee);
    long countOfRecords = employeeRepository.count();
    System.out.println(countOfRecords);

  }

}
