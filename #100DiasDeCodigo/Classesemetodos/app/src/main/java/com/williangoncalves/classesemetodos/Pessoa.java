package com.williangoncalves.classesemetodos;

public class Pessoa {

    private String nome;
    private int idade;

    // Sobrecarga de métodos:
    public void exibirDados(String nome) {
        System.out.println("Nome: " + nome);
    }

    public void exibirDados(String nome, int idade) {
        System.out.println("Nome: " + nome + ". Idade: " + idade);
    }
}
