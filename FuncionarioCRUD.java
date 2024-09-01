import java.util.List;

public class FuncionarioCRUD {
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    // Método para adicionar um funcionário
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarioDAO.adicionarFuncionario(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    // Método para listar todos os funcionários
    public void listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioDAO.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : funcionarios) {
                System.out.println(f);
            }
        }
    }

    // Método para atualizar um funcionário pelo nome
    public void atualizarFuncionario(String nome, Funcionario novoFuncionario) {
        funcionarioDAO.atualizarFuncionario(nome, novoFuncionario);
        System.out.println("Funcionário atualizado com sucesso!");
    }

    // Método para remover um funcionário pelo nome
    public void removerFuncionario(String nome) {
        funcionarioDAO.removerFuncionario(nome);
        System.out.println("Funcionário removido com sucesso!");
    }
}
