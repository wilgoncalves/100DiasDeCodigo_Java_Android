package com.williangoncalves.listadetarefas.model;

public class Tarefa {

    private String tarefa;

    public Tarefa() {

    }

    public Tarefa(String tarefa) {
        this.tarefa = tarefa;
    }


    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
}
