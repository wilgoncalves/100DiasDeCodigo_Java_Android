package com.williangoncalves.bancodedadossqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        try {

            // Criando banco de dados:
            SQLiteDatabase database = openOrCreateDatabase("app", MODE_PRIVATE, null);
            // Criando tabela:
            database.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");
            // Inserindo dados:
            //database.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Willian', 27)");
            //database.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Maria', 35)");
            // Recuperar pessoas:
            Cursor cursor = database.rawQuery("SELECT nome, idade FROM pessoas", null);

            // Índices da tabela:
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("RESULTADO - nome: ", cursor.getString(indiceNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceIdade));
                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}