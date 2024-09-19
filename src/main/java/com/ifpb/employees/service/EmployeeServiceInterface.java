package com.ifpb.employees.service;

import java.sql.SQLException;
import java.util.List;

import com.ifpb.employees.model.Employee;

public interface EmployeeServiceInterface {
    void addEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
    void updateEmployee(Employee employee, int id) throws SQLException;
    List<Employee> getAllEmployees() throws SQLException;
}
