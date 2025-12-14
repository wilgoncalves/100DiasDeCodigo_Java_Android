package com.williangoncalves.recyclerview.activity.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.williangoncalves.recyclerview.R;
import com.williangoncalves.recyclerview.activity.adapter.Adapter;
import com.williangoncalves.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

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

        recyclerView = findViewById(R.id.recyclerView);

        // Listagem de filmes
        this.criarFilmes();

        // Configurar adapter
        Adapter adapter = new Adapter(listaFilmes);

        // Configurar RecyclerVIew
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public void criarFilmes() {

        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Capitão América - Guerra Civil", "Aventura/Ficção", "2016");
        this.listaFilmes.add(filme);

        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Pica-pau: O Filme", "Comédia/Animação", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Múmia", "Terror", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Meu malvado favorito 3", "Comédia", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Carros 3", "Comédia", "2017");
        this.listaFilmes.add(filme);
    }
}