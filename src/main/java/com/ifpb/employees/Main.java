package com.ifpb.employees;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Cria a tabela
        TableManager.createTable();

        EmployeeCRUD.insertUser("Abraão Borges", "abraao.borges@academico.ifpb.edu.br", "15/10/2024", 2500.50);
    }
}
