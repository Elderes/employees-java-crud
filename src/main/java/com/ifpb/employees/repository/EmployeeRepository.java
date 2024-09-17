package com.ifpb.employees.repository;

import com.ifpb.employees.DatabaseConnection;
import com.ifpb.employees.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements EmployeeRepositoryInterface {

    @Override
    public void insert(Employee employee) throws SQLException {
        String sql = "INSERT INTO empregados(nome, email, ingresso, cargo, salario) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setString(3, employee.getEntrance());
            pstmt.setString(4, employee.getRole());
            pstmt.setDouble(5, employee.getSalary());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    employee.setId(generatedKeys.getInt(1));  // Definir o ID gerado
                }
            }
        }
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        String sql = "SELECT * FROM empregados";
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Employee employee = new Employee(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("ingresso"),
                    rs.getString("cargo"),
                    rs.getDouble("salario")
                );
                employees.add(employee);
            }
        }
        return employees;
    }


    @Override
    public void update(Employee employee, int id) throws SQLException {
        String sql = "UPDATE empregados SET nome = ?, email = ?, ingresso = ?, cargo = ?, salario = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setString(3, employee.getEntrance());
            pstmt.setString(4, employee.getRole());
            pstmt.setDouble(5, employee.getSalary());
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM empregados WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
