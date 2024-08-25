public class Main {
    public static void main(String[] args) {
        FuncionarioCRUD crud = new FuncionarioCRUD();

        // Adicionar funcionários
        Funcionario f1 = new Funcionario("João", "Desenvolvedor", 2, 3000.00);
        Funcionario f2 = new Funcionario("Maria", "Designer", 3, 3500.00);

        crud.adicionarFuncionario(f1);
        crud.adicionarFuncionario(f2);

        // Listar funcionários
        crud.listarFuncionarios();

        // Atualizar funcionário
        Funcionario f3 = new Funcionario("João", "Desenvolvedor Sênior", 3, 5000.00);
        crud.atualizarFuncionario("João", f3);

        // Listar funcionários após atualização
        crud.listarFuncionarios();

        // Remover funcionário
        crud.removerFuncionario("Maria");

        // Listar funcionários após remoção
        crud.listarFuncionarios();
    }
}
