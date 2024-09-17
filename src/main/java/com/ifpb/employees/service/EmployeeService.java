package com.ifpb.employees.service;

import com.ifpb.employees.model.Employee;
import com.ifpb.employees.repository.EmployeeRepositoryInterface;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private final EmployeeRepositoryInterface repository;

    public EmployeeService(EmployeeRepositoryInterface repository) {
        this.repository = repository;
    }

    public void addEmployee(Employee employee) throws SQLException {
        repository.insert(employee);
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return repository.findAll();
    }

    public void updateEmployee(Employee employee, int id) throws SQLException {
        repository.update(employee, id);
    }

    public void deleteEmployee(int id) throws SQLException {
        repository.delete(id);
    }
}
