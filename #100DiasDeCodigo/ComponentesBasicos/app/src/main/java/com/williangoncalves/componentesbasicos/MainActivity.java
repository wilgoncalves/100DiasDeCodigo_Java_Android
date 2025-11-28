package com.williangoncalves.componentesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;
    private CheckBox checkVerde, checkBranco, checkVermelho;
    private RadioButton generoMasculino, generoFeminino;
    private RadioGroup opcaoGenero;

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

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        textoResultado = findViewById(R.id.textResultado);

        // Checkbox:
        checkVerde = findViewById(R.id.checkVerde);
        checkBranco = findViewById(R.id.checkBranco);
        checkVermelho = findViewById(R.id.checkVermelho);

        // RadioButton:
        generoMasculino = findViewById(R.id.radioButtonMasculino);
        generoFeminino = findViewById(R.id.radioButtonFeminino);
        opcaoGenero = findViewById(R.id.radioGroupGenero);

        radioButton();
    }

    public void radioButton() {

        opcaoGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {

                if (checkedId == R.id.radioButtonMasculino) {
                    textoResultado.setText("Masculino selecionado");
                } else {
                    textoResultado.setText("Feminino selecionado");
                }
            }
        });

        /*
        if (generoMasculino.isChecked()) {
            textoResultado.setText("Masculino selecionado");
        } else {
            textoResultado.setText("Feminino selecionado");
        }
         */
    }

    public void enviar(View view) {

        //radioButton();
        //checkbox();
        /*
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        textoResultado.setText(getString(R.string.resultado, nome, email));
         */
    }

    public void checkbox() {

        String texto = "";

        if (checkVerde.isChecked()) {
            //String corSelecionada = checkVerde.getText().toString();
            //texto = corSelecionada;
            texto = "Verde selecionado - ";
        }

        if (checkBranco.isChecked()) {
            texto += "Branco selecionado - ";
        }

        if (checkVermelho.isChecked()) {
            texto += "Vermelho selecionado - ";
        }

        textoResultado.setText(texto);
    }

    public void limpar(View view) {

        campoNome.setText("");
        campoEmail.setText("");
    }
}