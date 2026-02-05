package com.williangoncalves.listadetarefas.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.williangoncalves.listadetarefas.R;
import com.williangoncalves.listadetarefas.adapter.AdapterTarefas;
import com.williangoncalves.listadetarefas.databinding.ActivityMainBinding;
import com.williangoncalves.listadetarefas.model.Tarefa;

import android.view.Menu;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLista;
    private ActivityMainBinding binding;
    private List<Tarefa> listaTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurando Recycler:
        recyclerViewLista = findViewById(R.id.recyclerViewLista);

        // Configurando Adapter:
        AdapterTarefas adapterTarefas = new AdapterTarefas(listaTarefas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewLista.setLayoutManager(layoutManager);
        recyclerViewLista.setHasFixedSize(true);
        recyclerViewLista.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewLista.setAdapter(adapterTarefas);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}