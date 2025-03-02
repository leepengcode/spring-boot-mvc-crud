package com.example.thymeleafdemo.repository;

import com.example.thymeleafdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();

}
