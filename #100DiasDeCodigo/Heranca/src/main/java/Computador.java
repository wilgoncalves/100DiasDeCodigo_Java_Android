public class Computador extends Eletronico {
    // classe filha - especialização

    public void instalarSoftware() {
        // super: palavra reservada para referenciar a classe que está sendo herdada.
        super.ligar();
        // lógica
        super.desligar();
    }
}
