package com.example.demo.Repository;

import com.example.demo.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<employee, Long> {
}