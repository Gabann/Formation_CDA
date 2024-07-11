package com.example.rest.ex_03.repository;

import com.example.rest.ex_03.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
}
