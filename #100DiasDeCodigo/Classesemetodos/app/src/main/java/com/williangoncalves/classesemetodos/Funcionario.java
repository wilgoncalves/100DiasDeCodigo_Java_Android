package com.williangoncalves.classesemetodos;

class Funcionario {

    // propriedades
    String nome;
    double salario;

    // métodos
    double recuperarSalario() {
        this.salario = this.salario - (this.salario * 0.1);
        return this.salario;
        //System.out.println(this.salario);
    }

    // Sobrecarga:
    double recuperarSalario( double bonus) {
        this.salario = recuperarSalario() + bonus;
        return this.salario;
    }
}
