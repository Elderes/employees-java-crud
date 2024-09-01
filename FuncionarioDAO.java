import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private Connection connection;

    // Construtor para estabelecer a conexão com o banco de dados
    public FuncionarioDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:funcionarios.db");
            criarTabelaSeNaoExistir();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para criar a tabela de funcionários se ela não existir
    private void criarTabelaSeNaoExistir() {
        String sql = "CREATE TABLE IF NOT EXISTS funcionario (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "cargo TEXT NOT NULL," +
                "tempo_na_empresa INTEGER NOT NULL," +
                "salario REAL NOT NULL" +
                ");";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para adicionar um funcionário
    public void adicionarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario(nome, cargo, tempo_na_empresa, salario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getCargo());
            pstmt.setInt(3, funcionario.getTempoNaEmpresa());
            pstmt.setDouble(4, funcionario.getSalario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os funcionários
    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getInt("tempo_na_empresa"),
                        rs.getDouble("salario")
                );
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    // Método para atualizar um funcionário
    public void atualizarFuncionario(String nome, Funcionario novoFuncionario) {
        String sql = "UPDATE funcionario SET nome = ?, cargo = ?, tempo_na_empresa = ?, salario = ? WHERE nome = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, novoFuncionario.getNome());
            pstmt.setString(2, novoFuncionario.getCargo());
            pstmt.setInt(3, novoFuncionario.getTempoNaEmpresa());
            pstmt.setDouble(4, novoFuncionario.getSalario());
            pstmt.setString(5, nome);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para remover um funcionário
    public void removerFuncionario(String nome) {
        String sql = "DELETE FROM funcionario WHERE nome = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
