package src.main.java.com.ifpb.employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:employees_crud_java.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Conexão falhou: " + e.getMessage());
            return null;
        }
    } 
}
