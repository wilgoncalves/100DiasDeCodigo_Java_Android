package com.devmasterteam.tasks.service.listener;

public interface TaskListener {

    /**
     * Click para edição
     */
    void onListClick(int id);

    /**
     * Remoção
     */
    void onDeleteClick(int id);

    /**
     * Completa tarefa
     */
    void onCompleteClick(int id);

    /**
     * Desfaz tarefa
     */
    void onUndoClick(int id);

}