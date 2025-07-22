public class Main {

    private float calculaBonus(Cargo cargo) {
        if (cargo == Cargo.Diretor) {
            return 5000;
        } else if (cargo == Cargo.Engenheiro) {
            return 3000;
        } else if (cargo == Cargo.Analista) {
            return 2000;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        // Instância - criação de objeto:
        Pessoa pessoa = new Pessoa("Willian");
        Pessoa pessoa2 = new Pessoa("Willian", 18);
        System.out.println(pessoa2.getNome());
        System.out.println(pessoa2.getIdade());

        pessoa.setEndereco(new Endereco());

        // Estado:
        //pessoa.nome = "Willian";
        //pessoa.idade = 18;
        //
        ContaCorrente contaCorrente = new ContaCorrente();
        System.out.println("Seu saldo e: " + contaCorrente.getSaldo());
        contaCorrente.setSaldo(10000000);
        //
        new Main().calculaBonus(Cargo.Analista);
        // ou
        Prioridade prioridade = Prioridade.Alta;
        // ou
        int id = Prioridade.Alta.getId();

        // Variáveis e métodos estáticos:
        System.out.println(Estatico.id);
        System.out.println(Estatico.bonus());
    }
}
