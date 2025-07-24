package eletronico;

public class Microfone implements Eletronico {

    // classe filha - especialização
    float maximoDecibeis;

    @Override
    public void ligar() {
        System.out.println("Ajusta os decibeis");
    }

    private void gravar() {

    }
}

