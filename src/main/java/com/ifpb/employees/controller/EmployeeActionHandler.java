package com.ifpb.employees.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmployeeActionHandler {
    private EmployeeController controller;

    public EmployeeActionHandler(EmployeeController controller) {
        this.controller = controller;
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
}
