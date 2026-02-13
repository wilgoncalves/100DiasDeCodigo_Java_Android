package com.williangoncalves.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.williangoncalves.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TarefaDAO implements ITarefaDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public TarefaDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        escreve = dbHelper.getWritableDatabase();
        le = dbHelper.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", tarefa.getNomeTarefa());

        try {
            escreve.insert(DbHelper.TABELA_TAREFAS, null, contentValues);
            Log.i("INFO", "Tarefa salva com sucesso!");
        } catch (Exception e) {
            Log.e("INFO", "Erro ao salvar tarefa " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";
        Cursor cursor = le.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            Tarefa tarefa = new Tarefa();

            Long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
            String nomeTarefa = cursor.getString(cursor.getColumnIndexOrThrow("nome"));

            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);

            tarefas.add(tarefa);
        }

        return tarefas;
    }
}
