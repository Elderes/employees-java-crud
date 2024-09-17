package com.ifpb.employees.view;

import com.ifpb.employees.controller.EmployeeController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class EmployeeGUI extends JFrame {

    private JTextField nameField, emailField, entranceField, roleField, salaryField, idField;
    private JTable resultTable;
    private JButton insertButton, deleteButton, updateButton, searchButton;
    private DefaultTableModel tableModel;
    private EmployeeController controller;

    public EmployeeGUI() {
        controller = new EmployeeController();
        setTitle("Sistema de Gerenciamento de Empregados");
        setSize(600, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(6, 2));
        mainPanel.add(new JLabel("ID: ")); idField = new JTextField(); mainPanel.add(idField);
        mainPanel.add(new JLabel("Nome: ")); nameField = new JTextField(); mainPanel.add(nameField);
        mainPanel.add(new JLabel("Email: ")); emailField = new JTextField(); mainPanel.add(emailField);
        mainPanel.add(new JLabel("Ingresso: ")); entranceField = new JTextField(); mainPanel.add(entranceField);
        mainPanel.add(new JLabel("Cargo: ")); roleField = new JTextField(); mainPanel.add(roleField);
        mainPanel.add(new JLabel("Salário: ")); salaryField = new JTextField(); mainPanel.add(salaryField);

        JPanel buttonPanel = new JPanel();
        insertButton = new JButton("Inserir"); deleteButton = new JButton("Deletar");
        updateButton = new JButton("Atualizar"); searchButton = new JButton("Buscar");

        buttonPanel.add(insertButton); buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton); buttonPanel.add(searchButton);

        insertButton.addActionListener(e -> {
            try {
                controller.addEmployee(
                    nameField.getText(), 
                    emailField.getText(), 
                    entranceField.getText(), 
                    roleField.getText(), 
                    Double.parseDouble(salaryField.getText())
                );
                JOptionPane.showMessageDialog(null, "Empregado adicionado com sucesso!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        

        deleteButton.addActionListener(e -> {
            try {
                controller.deleteEmployee(Integer.parseInt(idField.getText()));
                JOptionPane.showMessageDialog(null, "Empregado deletado com sucesso!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        updateButton.addActionListener(e -> {
            try {
                controller.updateEmployee(Integer.parseInt(idField.getText()), nameField.getText(), emailField.getText(), entranceField.getText(), roleField.getText(), Double.parseDouble(salaryField.getText()));
                JOptionPane.showMessageDialog(null, "Empregado atualizado com sucesso!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        resultTable = new JTable();
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Email", "Ingresso", "Cargo", "Salário"}, 0);
        resultTable.setModel(tableModel);
        JScrollPane tableScroll = new JScrollPane(resultTable);

        searchButton.addActionListener(e -> {
            try {
                tableModel.setRowCount(0); // Limpar a tabela
                controller.populateTable(tableModel);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        getContentPane().add(mainPanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(tableScroll, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmployeeGUI().setVisible(true);
        });
    }   
}