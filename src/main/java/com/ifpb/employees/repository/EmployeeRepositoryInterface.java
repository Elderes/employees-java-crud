package com.ifpb.employees.repository;

import com.ifpb.employees.model.Employee;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepositoryInterface {
    void insert(Employee employee) throws SQLException;
    List<Employee> findAll() throws SQLException;
    void update(Employee employee, int id) throws SQLException;
    void delete(int id) throws SQLException;
}
