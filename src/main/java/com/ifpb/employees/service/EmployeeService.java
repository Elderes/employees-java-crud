package com.ifpb.employees.service;

import com.ifpb.employees.model.Employee;
import com.ifpb.employees.repository.EmployeeRepositoryInterface;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements EmployeeServiceInterface {

    private final EmployeeRepositoryInterface repository;

    public EmployeeService(EmployeeRepositoryInterface repository) { // Polimorfismo. É passado como argumento a classe com a implementação concreta da interface
        this.repository = repository;
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        repository.insert(employee);
    }
    
    @Override
    public void deleteEmployee(int id) throws SQLException {
        repository.delete(id);
    }
    
    @Override
    public void updateEmployee(Employee employee, int id) throws SQLException {
        repository.update(employee, id);
    }
    
    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        return repository.findAll();
    }

}
