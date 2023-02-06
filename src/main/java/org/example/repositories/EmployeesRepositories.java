package org.example.repositories;

import org.example.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepositories extends JpaRepository<Employee, Integer> {
}
