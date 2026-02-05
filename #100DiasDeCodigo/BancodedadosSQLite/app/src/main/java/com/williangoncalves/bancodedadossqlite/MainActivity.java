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
            database.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");

            // Excluindo tabela:
            //database.execSQL("DROP TABLE pessoas");

            // Inserindo dados:
            //database.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Willian', 27)");
            //database.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Maria', 35)");
            //database.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Mariana', 18)");
            //database.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Pedro', 50)");
            //database.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Mario', 40)");

            // Atualizando dados:
            //database.execSQL("UPDATE pessoas SET idade = 19, nome = 'Mariana Silva' WHERE id = 3");

            // Excluindo dados:
            //database.execSQL("DELETE FROM pessoas WHERE id = 4");
            //database.execSQL("DELETE FROM pessoas");

            // Recuperar pessoas:
            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                    "WHERE nome = 'Willian' AND idade = 27"; */

            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                    "WHERE idade >= 35 OR idade = 18"; */

            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                    "WHERE nome IN('Maria','Willian')"; */

            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                    "WHERE idade BETWEEN 20 AND 35"; */

            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                    "WHERE nome LIKE 'mar%'"; */

            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                    "WHERE 1=1 ORDER BY idade ASC LIMIT 3"; */

            String consulta =
                    "SELECT * FROM pessoas";

            Cursor cursor = database.rawQuery(consulta, null);

            // Índices da tabela:
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null) {

                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO - id: ", id + " / nome: " + nome + " / idade: " + idade);
                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}