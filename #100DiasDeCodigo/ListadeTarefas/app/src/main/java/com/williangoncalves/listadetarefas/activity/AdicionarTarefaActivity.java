package com.williangoncalves.listadetarefas.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.williangoncalves.listadetarefas.R;
import com.williangoncalves.listadetarefas.helper.TarefaDAO;
import com.williangoncalves.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText textTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adicionar_tarefa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textTarefa = findViewById(R.id.textTarefa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.itemSalvar) {
            TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

            String nomeTarefa = textTarefa.getText().toString();
            if (!nomeTarefa.isEmpty()) {

                Tarefa tarefa = new Tarefa();
                tarefa.setNomeTarefa(nomeTarefa);
                tarefaDAO.salvar(tarefa);
                finish();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}