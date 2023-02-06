package org.example.services;

import org.example.models.Employee;
import org.example.repositories.EmployeesRepositories;
import org.example.util.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeesRepositories employeesRepositories;

    @Autowired
    public EmployeeService(EmployeesRepositories employeesRepositories) {
        this.employeesRepositories = employeesRepositories;
    }

    public List<Employee> findAll(){
        return employeesRepositories.findAll();
    }

    public Employee findOne(int id){
        Optional<Employee> foundEmployee = employeesRepositories.findById(id);
        return foundEmployee.orElseThrow(EmployeeNotFoundException::new);
    }

    @Transactional
    public void save(Employee employee){
        employeesRepositories.save(employee);
    }

    @Transactional
    public void update(int id, Employee updateEmployee){
        updateEmployee.setId(id);
        employeesRepositories.save(updateEmployee);
    }

    @Transactional
    public void delete(int id){
        employeesRepositories.deleteById(id);
    }
}
