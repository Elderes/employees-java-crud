package com.ifpb.employees;

import com.ifpb.employees.repository.TableManager;
import com.ifpb.employees.view.EmployeeGUI;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Cria a tabela se não existir
            TableManager.createTable();
            
            // Migrar dados antigos (descomente e especifique o caminho do arquivo SQL se necessário)
            // TableManager.migrateOldData("data.sql");

            // Inicia a GUI
            javax.swing.SwingUtilities.invokeLater(() -> new EmployeeGUI().setVisible(true));

        } catch (SQLException e) {
            System.out.println("Erro ao inicializar o banco de dados: " + e.getMessage());
        }
    }
}
