package com.ifpb.employees;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeGUI extends JFrame {
    
    // Compontentes.
    private JTextField nameField, emailField, entranceField, roleField, salaryField, idField;
    private JTable resultTable;
    private JButton insertButton, deleteButton, updateButton, searchButton;
    private DefaultTableModel tableModel;

    public EmployeeGUI() {
        setTitle("Sistema de Gerenciamento de Empregados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel de campos de texto.
        JPanel mainPanel = new JPanel(new GridLayout(6, 2));

        mainPanel.add(new JLabel("ID: "));
        idField = new JTextField();
        mainPanel.add(idField);
    
        mainPanel.add(new JLabel("Nome: "));
        nameField = new JTextField();
        mainPanel.add(nameField);
    
        mainPanel.add(new JLabel("Email: "));
        emailField = new JTextField();
        mainPanel.add(emailField);
    
    
        mainPanel.add(new JLabel("Ingresso: "));
        entranceField = new JTextField();
        mainPanel.add(entranceField);
    
    
        mainPanel.add(new JLabel("Cargo: "));
        roleField = new JTextField();
        mainPanel.add(roleField);
    
    
        mainPanel.add(new JLabel("Salário: "));
        salaryField = new JTextField();
        mainPanel.add(salaryField);

        // Painel de botões.    
        JPanel buttonPanel = new JPanel();

        insertButton = new JButton("Inserir");
        updateButton = new JButton("Atualizar");
        deleteButton = new JButton("Deletar");
        searchButton = new JButton("Consultar");

        buttonPanel.add(insertButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);

        // Painel para resultado da consulta.
        String[] columnNames = {"ID", "Nome", "Email", "Data de Ingresso", "Cargo", "Salário"};
        tableModel = new DefaultTableModel(columnNames, 0);
        resultTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(resultTable);

        // Adicionar os painéis ao JFrame.
        add(mainPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Adicionar eventos para os botões.
        addListeners();
    }

    private void addListeners() {
        // Inserir empregado.
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String entrance = entranceField.getText();
                String role = roleField.getText();
                Double salary = Double.parseDouble(salaryField.getText());

                EmployeeCRUD.insertEmployee(name, email, entrance, role, salary);
                JOptionPane.showMessageDialog(null, "Empregado adicionado com sucesso.");
            }
        });

        // Atualizar empregado.
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String email = emailField.getText();
                String entrance = entranceField.getText();
                String role = roleField.getText();
                Double salary = Double.parseDouble(salaryField.getText());

                EmployeeCRUD.updateEmployee(id, name, email, entrance, role, salary);
                JOptionPane.showMessageDialog(null, "Empregado atualizado com sucesso.");
            }
        });

        // Deletar empregado.
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());

                EmployeeCRUD.deleteEployee(id);
                JOptionPane.showMessageDialog(null, "Empregado deletado com sucesso.");
            }
        });

        // Listar todos os empregados.
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0); // Limpa o campo de resultados
                EmployeeCRUD.selectAllEmployees(tableModel);
            }
        });
    }
}
