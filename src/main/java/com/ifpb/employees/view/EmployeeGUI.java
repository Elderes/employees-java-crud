package com.ifpb.employees.view;

import com.ifpb.employees.controller.EmployeeActionHandler;
import com.ifpb.employees.controller.EmployeeController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class EmployeeGUI extends JFrame {

    private JTextField nameField, emailField, entranceField, roleField, salaryField, idField;
    private JTable resultTable;
    private DefaultTableModel tableModel;
    private EmployeeActionHandler actionHandler;

    public EmployeeGUI() {
        EmployeeController controller = new EmployeeController();
        actionHandler = new EmployeeActionHandler(controller);

        setTitle("Sistema de Gerenciamento de Empregados");
        setSize(600, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }
    
    private void initUI() {
        JPanel formPanel = createFormPanel();
        JPanel buttonPanel = createButtonPanel();
        JScrollPane tableScroll = createTableScroll();

        getContentPane().add(formPanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(tableScroll, BorderLayout.SOUTH);
    }   
        
    public JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridLayout(6, 2));

        idField = new JTextField(); 
        nameField = new JTextField(); 
        emailField = new JTextField(); 
        entranceField = new JTextField(); 
        roleField = new JTextField(); 
        salaryField = new JTextField(); 
        
        formPanel.add(idField);
        formPanel.add(nameField);
        formPanel.add(emailField);
        formPanel.add(entranceField);
        formPanel.add(roleField);
        formPanel.add(salaryField);

        return formPanel;

    }
    
    public JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();

        JButton insertButton = new JButton("Inserir");
        JButton deleteButton = new JButton("Deletar");
        JButton updateButton = new JButton("Atualizar");
        JButton searchButton = new JButton("Buscar");

        buttonPanel.add(insertButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(searchButton);

        insertButton.addActionListener(e -> actionHandler.handleInsert(nameField, emailField, entranceField, roleField, salaryField));
        deleteButton.addActionListener(e -> actionHandler.handleDelete(idField));
        updateButton.addActionListener(e -> actionHandler.handleUpdate(idField, nameField, emailField, entranceField, roleField, salaryField));
        searchButton.addActionListener(e -> actionHandler.handleSearch(tableModel));
    
        return buttonPanel;
    }
    
    public JScrollPane createTableScroll() {
        resultTable = new JTable();
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Email", "Ingresso", "Cargo", "Salário"}, 0);
        resultTable.setModel(tableModel);
        return new JScrollPane(resultTable);
    }

}