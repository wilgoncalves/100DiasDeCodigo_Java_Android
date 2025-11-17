package com.williangoncalves.classesemetodos;

public class ContaBancaria {

    private int numeroConta;
    private double saldo;

    /*
    public ContaBancaria() {
        System.out.println("Construtor chamado!");
    }
     */

    public ContaBancaria(int numeroConta) {
        this.numeroConta = numeroConta;
        System.out.println("Construtor chamado! " + numeroConta);
    }
}
