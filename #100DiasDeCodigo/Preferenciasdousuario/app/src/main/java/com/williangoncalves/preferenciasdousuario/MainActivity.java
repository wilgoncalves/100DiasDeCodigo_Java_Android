package com.williangoncalves.preferenciasdousuario;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editTextNome;
    private Button buttonSalvar;
    private TextView textViewResultado;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextNome = findViewById(R.id.editTextNome);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

                // Validar o nome:
                if (editTextNome.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_LONG).show();
                } else {
                    String nome = editTextNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    textViewResultado.setText("Olá, " + nome);
                }
            }
        });

        // Recuperar dados salvos:
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        // Valida se temos o nome em preferencias:
        if (preferences.contains("nome")) {
            String nome = preferences.getString("nome", "Usuário não definido");
            textViewResultado.setText("Olá, " + nome);
        } else {
            textViewResultado.setText("Olá, usuário não definido");
        }
    }
}