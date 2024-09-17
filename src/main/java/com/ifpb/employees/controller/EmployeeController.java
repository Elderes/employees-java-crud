package com.ifpb.employees.controller;

import com.ifpb.employees.model.Employee;
import com.ifpb.employees.service.EmployeeService;
import com.ifpb.employees.repository.EmployeeRepository;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController() {
        this.service = new EmployeeService(new EmployeeRepository());
    }

    public void addEmployee(String name, String email, String entrance, String role, double salary) throws SQLException {
        Employee employee = new Employee(name, email, entrance, role, salary);
        service.addEmployee(employee);
    }

    public void populateTable(DefaultTableModel tableModel) throws SQLException {
        List<Employee> employees = service.getAllEmployees();
        for (Employee employee : employees) {
            tableModel.addRow(new Object[]{employee.getId(), employee.getName(), employee.getEmail(), employee.getEntrance(), employee.getRole(), employee.getSalary()});
        }
    }

    public void updateEmployee(int id, String name, String email, String entrance, String role, double salary) throws SQLException {
        Employee employee = new Employee(name, email, entrance, role, salary);
        service.updateEmployee(employee, id);
    }

    public void deleteEmployee(int id) throws SQLException {
        service.deleteEmployee(id);
    }
}
