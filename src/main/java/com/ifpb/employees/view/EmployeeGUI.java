package com.ifpb.employees.view;

import com.ifpb.employees.controller.EmployeeActionHandler;
import com.ifpb.employees.controller.EmployeeController;
import com.ifpb.employees.repository.EmployeeRepository;
import com.ifpb.employees.repository.EmployeeRepositoryInterface;
import com.ifpb.employees.service.EmployeeService;
import com.ifpb.employees.service.EmployeeServiceInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EmployeeGUI extends JFrame {

    private JTextField nameField, emailField, entranceField, roleField, salaryField, idField;
    private JTable resultTable;
    private JLabel idLabel, nameLabel, emailLabel, entranceLabel, roleLabel, salaryLabel;
    private DefaultTableModel tableModel;
    private EmployeeActionHandler actionHandler;

    public EmployeeGUI() {
        EmployeeRepositoryInterface repository = new EmployeeRepository();
        EmployeeServiceInterface service = new EmployeeService(repository);
        EmployeeController controller = new EmployeeController(service);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Email", "Ingresso", "Cargo", "Salário"}, 0);
        actionHandler = new EmployeeActionHandler(controller, tableModel);

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

        // Campos de texto
        idField = new JTextField(); 
        nameField = new JTextField(); 
        emailField = new JTextField(); 
        entranceField = new JTextField(); 
        roleField = new JTextField(); 
        salaryField = new JTextField();

        // Rótulos dos campos de texto
        idLabel = new JLabel("ID: ");
        nameLabel = new JLabel("Nome: ");
        emailLabel = new JLabel("Email: ");
        entranceLabel = new JLabel("Ingresso: ");
        roleLabel = new JLabel("Cargo: ");
        salaryLabel = new JLabel("Salário: ");

        // Adicionando rótulo e campo de texto no painel
        formPanel.add(idLabel); formPanel.add(idField);
        formPanel.add(nameLabel); formPanel.add(nameField);
        formPanel.add(emailLabel); formPanel.add(emailField);
        formPanel.add(entranceLabel); formPanel.add(entranceField);
        formPanel.add(roleLabel); formPanel.add(roleField);
        formPanel.add(salaryLabel); formPanel.add(salaryField);

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

        // Utiliza os métodos da classe EmployeeActionHandler. Encapsula os comandos da interface para desacoplar da lógica de negócios
        insertButton.addActionListener(e -> actionHandler.handleInsert(nameField, emailField, entranceField, roleField, salaryField));
        deleteButton.addActionListener(e -> actionHandler.handleDelete(idField));
        updateButton.addActionListener(e -> actionHandler.handleUpdate(idField, nameField, emailField, entranceField, roleField, salaryField));
        searchButton.addActionListener(e -> actionHandler.handleSearch(tableModel));
    
        return buttonPanel;
    }
    
    public JScrollPane createTableScroll() {
        resultTable = new JTable();
        resultTable.setModel(tableModel);
        return new JScrollPane(resultTable);
    }

}