package com.ifpb.employees.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmployeeActionHandler {
    private EmployeeController controller;
    private DefaultTableModel tableModel;

    public EmployeeActionHandler(EmployeeController controller, DefaultTableModel tableModel) {
        this.controller = controller;
        this.tableModel = tableModel;
    }

    public void handleInsert(JTextField nameField, JTextField emailField, JTextField entranceField, JTextField roleField, JTextField salaryField) {
        try {
            controller.addEmployee(
                nameField.getText(),
                emailField.getText(),
                entranceField.getText(),
                roleField.getText(),
                Double.parseDouble(salaryField.getText())
            );
            refreshTable();
            JOptionPane.showMessageDialog(null, "Empregado adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void handleDelete(JTextField idField) {
        try {
            controller.deleteEmployee(
                Integer.parseInt(idField.getText())
                );
                refreshTable();
                JOptionPane.showMessageDialog(null, "Empregado deletado com sucesso.");
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public void handleUpdate(JTextField idField, JTextField nameField, JTextField emailField, JTextField entranceField, JTextField roleField, JTextField salaryField) {
        try {
            controller.updateEmployee(
                Integer.parseInt(idField.getText()),
                nameField.getText(),
                emailField.getText(),
                entranceField.getText(),
                roleField.getText(),
                Double.parseDouble(salaryField.getText())
                );
                refreshTable();
                JOptionPane.showMessageDialog(null, "Empregado atualizado com sucesso.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        public void handleSearch(DefaultTableModel tableModel) {
            try {
                tableModel.setRowCount(0);
                controller.populateTable(tableModel);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        private void refreshTable() {
            tableModel.setRowCount(0);
            try {
                controller.populateTable(tableModel);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao consultar empregados." + e.getMessage());
            }
        }
    }
    