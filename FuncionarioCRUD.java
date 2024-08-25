import java.util.ArrayList;
import java.util.List;

public class FuncionarioCRUD {
    private List<Funcionario> funcionarios = new ArrayList<>();

    // Método para adicionar um funcionário
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    // Método para listar todos os funcionários
    public void listarFuncionarios() {
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
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                f.setNome(novoFuncionario.getNome());
                f.setCargo(novoFuncionario.getCargo());
                f.setTempoNaEmpresa(novoFuncionario.getTempoNaEmpresa());
                f.setSalario(novoFuncionario.getSalario());
                System.out.println("Funcionário atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    // Método para remover um funcionário pelo nome
    public void removerFuncionario(String nome) {
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
        System.out.println("Funcionário removido com sucesso!");
    }
}
