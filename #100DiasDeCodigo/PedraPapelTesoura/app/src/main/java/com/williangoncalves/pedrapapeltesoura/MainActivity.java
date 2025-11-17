package com.williangoncalves.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.williangoncalves.pedrapapeltesoura.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Pedra, Papel e Tesoura");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imagemResultado = findViewById(R.id.imagemResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        TextView retornoMensagem = findViewById(R.id.retornoMensagem);

        if ((opcaoApp == "Tesoura" && opcaoSelecionada == "Papel")
            || (opcaoApp == "Papel" && opcaoSelecionada == "Pedra")
            || (opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura")) {

            retornoMensagem.setText("Você perdeu!");

        } else if ((opcaoSelecionada == "Tesoura" && opcaoApp == "Papel")
                    || (opcaoSelecionada == "Papel" && opcaoApp == "Pedra")
                    || (opcaoSelecionada == "Pedra" && opcaoApp == "Tesoura")) {

            retornoMensagem.setText("Você ganhou!");

        } else {
            retornoMensagem.setText("Empate!!!");
        }

        System.out.println("Item: " + opcaoApp);
    }
}