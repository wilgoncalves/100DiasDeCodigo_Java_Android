package com.williangoncalves.retrofitexemplo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        PostService service = RetrofitClient.getInstance().create(PostService.class);
        Call<List<PostEntity>> call = service.getPosts();
        call.enqueue(new Callback<List<PostEntity>>() {
            @Override
            public void onResponse(Call<List<PostEntity>> call, Response<List<PostEntity>> response) {
                String s = "";
            }

            @Override
            public void onFailure(Call<List<PostEntity>> call, Throwable t) {
                String s = "";
            }
        });
    }
}