package com.williangoncalves.listadetarefas.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.williangoncalves.listadetarefas.R;
import com.williangoncalves.listadetarefas.helper.DbHelper;
import com.williangoncalves.listadetarefas.helper.RecyclerItemClickListener;
import com.williangoncalves.listadetarefas.adapter.AdapterTarefas;
import com.williangoncalves.listadetarefas.databinding.ActivityMainBinding;
import com.williangoncalves.listadetarefas.helper.TarefaDAO;
import com.williangoncalves.listadetarefas.model.Tarefa;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLista;
    private ActivityMainBinding binding;
    private AdapterTarefas adapterTarefas;
    private List<Tarefa> listaTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });

        // Configurando Recycler:
        recyclerViewLista = findViewById(R.id.recyclerViewLista);

        // Adicionando evento de clique:
        recyclerViewLista.addOnItemTouchListener(new RecyclerItemClickListener(
            getApplicationContext(),
            recyclerViewLista,
            new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Log.i("clique", "onItemClick");
                }

                @Override
                public void onLongItemClick(View view, int position) {
                    Log.i("clique", "onLongItemClick");
                }

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            }
        ));
    }

    public void carregarListaDeTarefas() {

        // Listar tarefas:
        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        listaTarefas = tarefaDAO.listar();

        // Configurar adapter:
        adapterTarefas = new AdapterTarefas(listaTarefas);

        // Configurar RecyclerView:
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewLista.setLayoutManager(layoutManager);
        recyclerViewLista.setHasFixedSize(true);
        recyclerViewLista.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerViewLista.setAdapter(adapterTarefas);

    }

    @Override
    protected void onStart() {
        carregarListaDeTarefas();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}