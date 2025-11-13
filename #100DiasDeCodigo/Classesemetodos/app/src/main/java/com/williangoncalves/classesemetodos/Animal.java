package com.williangoncalves.classesemetodos;

class Animal {

    int tamanho;
    String cor;
    double peso;

    // Getter e setter
    void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    int getTamanho() {
        return this.tamanho;
    }

    void setCor(String cor) {
        this.cor = cor;
    }

    String getCor() {
        return this.cor;
    }

    void setPeso(double peso) {
        this.peso = peso;
    }

    double getPeso() {
        return this.peso;
    }

    void dormir() {
        System.out.println("Dormir como um animal!");
    }

    void correr() {
        System.out.println("Correr como um ");
    }
}
