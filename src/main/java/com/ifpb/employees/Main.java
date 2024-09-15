package com.ifpb.employees;

import java.sql.SQLException;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EmployeeGUI().setVisible(true);
            }
        });
        
        // Cria a tabela
        // TableManager.createTable();
        
        // Adicionar funcionários
        // EmployeeCRUD.insertEmployee("Fábio", "fabio@meueamil.com", "14/09/2024", "Desenvolvedor", 2234.47);

        // Migrar dados gerados (Especificar o caminho)
        // TableManager.migrateOldData("data.sql");

        // Consultar funcionários
        // EmployeeCRUD.selectAllEmployees();
    }
}
