public class Pessoa {

    private String nome;
    private Integer idade;
    private Endereco endereco;

    // Construtor
    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, Integer idade) {
        this(nome);
        this.idade = idade;
    }

    // boilerplate
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void falar() {
        System.out.println("Olá!");
    }
}
