package com.williangoncalves.componentes;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.google.android.material.snackbar.Snackbar;
import com.williangoncalves.componentes.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.linear_root), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.loadSpinner();
        this.setListeners();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_toast) {
            Toast toast = Toast.makeText(this, "Toast", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
        } else if (id == R.id.button_snack) {
            Snackbar snackbar = Snackbar.make(this.binding.linearRoot, "Snack", Snackbar.LENGTH_SHORT);
            // Ações snackbar:
            snackbar.setAction("Desfazer", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(binding.linearRoot, "Desfeito", Snackbar.LENGTH_SHORT).show();
                }
            });

            snackbar.setBackgroundTint(Color.GREEN);
            snackbar.setActionTextColor(Color.BLACK);

            snackbar.show();
        } else if (id == R.id.button_get_spinner) {
            String selected = this.binding.spinnerDynamic.getSelectedItem().toString();
            int position = this.binding.spinnerDynamic.getSelectedItemPosition();
            long itemId = this.binding.spinnerDynamic.getSelectedItemId();

            String s = "";
        } else if (id == R.id.button_set_spinner) {

        }
    }

    private void loadSpinner() {
        // lista
        List<String> list = Arrays.asList("Dólar", "Euro", "Libra", "Real");

        // adapter
        SpinnerAdapter spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);

        // elemento - spinner
        this.binding.spinnerDynamic.setAdapter(spinnerAdapter);
    }

    private void setListeners() {
        this.binding.buttonToast.setOnClickListener(this);
        this.binding.buttonSnack.setOnClickListener(this);
        this.binding.buttonGetSpinner.setOnClickListener(this);
        this.binding.buttonSetSpinner.setOnClickListener(this);
    }

}