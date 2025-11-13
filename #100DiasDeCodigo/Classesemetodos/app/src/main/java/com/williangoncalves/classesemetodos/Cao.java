package com.williangoncalves.classesemetodos;

class Cao extends Animal {

    void latir() {
        System.out.println("Latir como um cachorro!");
    }

    // Sobrescrita de método da classe pai.
    void correr() {
        super.correr();
        System.out.println("cachorro!");
    }

}
