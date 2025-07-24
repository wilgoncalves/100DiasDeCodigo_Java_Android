package eletronico;

public class Computador implements Eletronico {
    // classe filha - especialização

    // sobrescrita
    @Override
    public void ligar() {
        System.out.println("Carregar drivers");
        System.out.println("Carregar SO");
    }

    @Override
    public void desligar() {

    }

    public void instalarSoftware() {
        // super: palavra reservada para referenciar a classe que está sendo herdada (superclasse).
        //super.desligar();
    }
}
