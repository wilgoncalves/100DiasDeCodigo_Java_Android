package com.williangoncalves.cardview.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.williangoncalves.cardview.R;
import com.williangoncalves.cardview.adapter.PostagemAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;

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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager(layoutManager);

        // Define adapter:
        PostagemAdapter postagemAdapter = new PostagemAdapter();
        recyclerPostagem.setAdapter(postagemAdapter);
    }
}