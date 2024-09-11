package src.main.java.com.ifpb.employees;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class TableManager {
    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS empregados ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT NOT NULL"
                + "email TEXT NOT NULL"
                + "ingresso DATE NOT NULL"
                + "salario DOUBLE NOT NULL);";
        
        try (Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'empregados' criada ou já existe.");
        }
        catch (SQLException e) {
            System.out.println("Erro cirando a tabela: " + e.getMessage());
        }
    }
}
