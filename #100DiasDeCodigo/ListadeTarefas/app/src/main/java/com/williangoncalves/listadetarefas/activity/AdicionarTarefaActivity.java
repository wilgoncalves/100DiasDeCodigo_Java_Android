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
    private Tarefa tarefaAtual;

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

        // Recuperar tarefa, caso seja edição:
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        // Configurar tarefa na caixa de texto:
        if (tarefaAtual != null) {
            textTarefa.setText(tarefaAtual.getNomeTarefa());
        }
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

            if (tarefaAtual != null) { // edição

                String nomeTarefa = textTarefa.getText().toString();
                if (!nomeTarefa.isEmpty()) {

                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(nomeTarefa);
                    tarefa.setId(tarefaAtual.getId());

                    // Atualizar no banco de dados:
                    if (tarefaDAO.atualizar(tarefa)) {
                        finish();
                        Toast.makeText(getApplicationContext(),
                                "Sucesso ao atualizar tarefa!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Erro ao atualizar tarefa!",
                                Toast.LENGTH_SHORT).show();
                    }
                }

            } else { // salvar

                String nomeTarefa = textTarefa.getText().toString();
                if (!nomeTarefa.isEmpty()) {

                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(nomeTarefa);

                    if (tarefaDAO.salvar(tarefa)) {

                        finish();
                        Toast.makeText(getApplicationContext(),
                                "Sucesso ao salvar tarefa!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Erro ao salvar tarefa!",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

        return super.onOptionsItemSelected(item);
    }
}