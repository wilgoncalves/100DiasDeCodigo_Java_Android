package com.williangoncalves.classesemetodos;

public class Willian extends Cidadao implements Presidente {
    @Override
    public void ganharEleicao() {
        System.out.println("Ganhar eleição no Brasil.");
    }
}
