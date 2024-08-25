public class Funcionario {
    private String nome;
    private String cargo;
    private int tempoNaEmpresa; // em anos
    private double salario;

    // Construtor
    public Funcionario(String nome, String cargo, int tempoNaEmpresa, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.tempoNaEmpresa = tempoNaEmpresa;
        this.salario = salario;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getTempoNaEmpresa() {
        return tempoNaEmpresa;
    }

    public void setTempoNaEmpresa(int tempoNaEmpresa) {
        this.tempoNaEmpresa = tempoNaEmpresa;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", tempoNaEmpresa=" + tempoNaEmpresa +
                ", salario=" + salario +
                '}';
    }
}
