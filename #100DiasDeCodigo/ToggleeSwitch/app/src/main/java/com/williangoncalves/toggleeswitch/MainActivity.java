package com.williangoncalves.toggleeswitch;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleSenha;
    private Switch switchSenha;
    private TextView textViewSwitch;
    private CheckBox checkBoxSenha;
    private TextView textResultado;

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

        toggleSenha = findViewById(R.id.toggleSenha);
        switchSenha = findViewById(R.id.switchSenha);
        textViewSwitch = findViewById(R.id.textViewSwitch);
        checkBoxSenha = findViewById(R.id.checkBoxSenha);
        textResultado = findViewById(R.id.textResultado);

        adicionarListener();
    }

    public void adicionarListener() {

        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    textViewSwitch.setText("Switch ligado!");
                } else {
                    textViewSwitch.setText("Switch desligado!");
                }
            }
        });
    }

    public void enviar(View view) {

        if (checkBoxSenha.isChecked()) {
            textResultado.setText("CheckBox ligado!");
        } else {
            textResultado.setText("CheckBox desligado!");
        }
    }
}