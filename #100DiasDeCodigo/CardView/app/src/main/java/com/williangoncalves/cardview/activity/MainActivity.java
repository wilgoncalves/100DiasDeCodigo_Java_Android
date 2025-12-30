package com.williangoncalves.cardview.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.williangoncalves.cardview.R;
import com.williangoncalves.cardview.adapter.PostagemAdapter;
import com.williangoncalves.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

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

        recyclerPostagem = findViewById(R.id.recyclerView);

        // Define layout:
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayout.VERTICAL);
        // Layout em grades:
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerPostagem.setLayoutManager(layoutManager);

        // Define adapter:
        this.prepararPostagem();
        PostagemAdapter postagemAdapter = new PostagemAdapter(postagens);
        recyclerPostagem.setAdapter(postagemAdapter);
    }

    public void prepararPostagem() {

        Postagem postagem = new Postagem("Willian Gonçalves",
                "#tbt Viagem legal!",
                R.drawable.imagem1);
        this.postagens.add(postagem);

        postagem = new Postagem("Hotel JM",
                "Viaje, aproveite nossos descontos!",
                R.drawable.imagem2);
        this.postagens.add(postagem);

        postagem = new Postagem("Maria Luiza",
                "#Paris!!",
                R.drawable.imagem3);
        this.postagens.add(postagem);

        postagem = new Postagem("Marcos Paulo",
                "Que foto linda!",
                R.drawable.imagem4);
        this.postagens.add(postagem);

    }
}