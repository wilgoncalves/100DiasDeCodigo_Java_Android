package com.williangoncalves.minhasanotaes;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import androidx.navigation.ui.AppBarConfiguration;
import com.williangoncalves.minhasanotaes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AnotacaoPreferencias preferencias;
    private EditText editTextAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editTextAnotacao = findViewById(R.id.editTextAnotacao);

        preferencias = new AnotacaoPreferencias(getApplicationContext());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Validar se algo foi digitado:
                String textoRecuperado = editTextAnotacao.getText().toString();
                if (textoRecuperado.equals("")) {
                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();
                } else {
                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        // Recuperar a anotação:
        String anotacao = preferencias.recuperarAnotacao();
        if (!anotacao.equals("")) {
            editTextAnotacao.setText(anotacao);
        }
    }
}