package com.ifpb.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeCRUD {

    public static void insertEmployee(String name, String email, String date, Double currency) {
        String sql = "INSERT INTO empregados(nome, email, ingresso, salario) values (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, date);
            pstmt.setDouble(4, currency);
            pstmt.executeUpdate();
            System.out.println("Empregado adicionado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro na adesão: " + e.getMessage());
        }
    }

    public static void selectAllEmployees() {
        String sql = "SELECT * FROM empregados";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                                        rs.getString("nome") + "\t" +
                                        rs.getString("email") + "\t" +
                                        rs.getString("ingresso") + "\t" +
                                        rs.getDouble("salario") + "\t");
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        }
    }

    public static void updateEmployee(int id, String name, String email, String date, Double currency) {
        String sql = "UPDATE empregados SET nome = ?, email = ?, ingresso = ?, salario = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, date);
                pstmt.setDouble(4, currency);
                pstmt.setInt(5, id);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro na modificação: " + e.getMessage());
        }        
    }

    public static void deleteEployee(int id) {
        String sql = "DELETE FROM empregados WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                System.out.println("Empregado deletado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}
