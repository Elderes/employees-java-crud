package com.ifpb.employees;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Cria a tabela
        // TableManager.createTable();
        // EmployeeCRUD.selectAllEmployees();
        // EmployeeCRUD.insertEmployee("Jef", "ramon@academico.ifpb.edu.br", "10/12/2024", 1400.70);
        // EmployeeCRUD.insertEmployee("askfksaf", "ramon@academico.ifpb.edu.br", "10/12/2024", 1400.70);
        // EmployeeCRUD.insertEmployee("pppqoqo", "ramon@academico.ifpb.edu.br", "10/12/2024", 1400.70);
        // EmployeeCRUD.insertEmployee("zzzzz", "ramon@academico.ifpb.edu.br", "10/12/2024", 1400.70);
        // EmployeeCRUD.deleteEployee(1);
        EmployeeCRUD.selectAllEmployees();
    }
}
