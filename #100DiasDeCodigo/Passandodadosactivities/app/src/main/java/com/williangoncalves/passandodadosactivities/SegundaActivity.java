package com.williangoncalves.passandodadosactivities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaActivity extends AppCompatActivity {

    private TextView textViewNome, textViewIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewNome = findViewById(R.id.textViewNome);
        textViewIdade = findViewById(R.id.textViewIdade);

        // Recuperar dados enviados:
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");
        Usuario usuario = (Usuario) dados.getSerializable("objeto");

        // Configurar valores recuperados:
        textViewNome.setText(usuario.getEmail());
        textViewIdade.setText(String.valueOf(idade));
    }
}