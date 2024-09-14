package com.ifpb.employees;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class TableManager {
    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS empregados ("
                + "id INTEGER PRIMARY KEY, "
                + "nome TEXT NOT NULL, "
                + "email TEXT NOT NULL, "
                + "ingresso DATE NOT NULL, "
                + "cargo TEXT NOT NULL, "
                + "salario DOUBLE NOT NULL);";
        
        try (Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'empregados' criada ou já existe.");
        }
        catch (SQLException e) {
            System.out.println("Erro criando a tabela: " + e.getMessage());
        }
    }

    public static void migrateOldData(String path) throws SQLException {
        // Usado para acumular as linhas de uma instrução SQL até encontrar o final (;).
        StringBuilder sqlBuilder = new StringBuilder();

        // Lê o arquivo linha por linha.
        try (BufferedReader br = new BufferedReader(new FileReader(path));
            Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement()) {
            
            String line;
            while ((line = br.readLine()) != null) {
                // Adicionar cada linha ao StringBuilder
                sqlBuilder.append(line);

                // Verifica se chegou ao final de uma instrução de INSERT
                if (line.trim().endsWith(";")) {
                    // Executa a instrução SQL
                    stmt.execute(sqlBuilder.toString());

                    // Limpa o StringBuilder para a próxima instrução
                    sqlBuilder.setLength(0);
                }
            }
            System.out.println("Dados migrados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo SQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao executar instrução SQL: " + e.getMessage());
            throw e; // Repassa a exceção para que o método avise que o chamou.
        }
    }
}
