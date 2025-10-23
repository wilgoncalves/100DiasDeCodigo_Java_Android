package com.williangoncalves.componentes;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener,
        CompoundButton.OnCheckedChangeListener {

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
            this.binding.spinnerDynamic.setSelection(0);
        } else if (id == R.id.button_set_seek) {
            this.binding.seekbar.setProgress(12);
        } else if (id == R.id.button_get_seek) {
            this.binding.seekbar.getProgress();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String s = adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.binding.textSeekbarValue.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        toast("Start tracking");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        toast("Stop tracking");
    }

    private void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton.getId() == R.id.switch_on_off) {
            this.binding.switchOnOff.isChecked();
            this.binding.switchOnOff.setChecked(false);
        } else if (compoundButton.getId() == R.id.check_on_off) {
            this.binding.checkOnOff.isChecked();
            this.binding.checkOnOff.setChecked(false);
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
        this.binding.buttonGetSeek.setOnClickListener(this);
        this.binding.buttonSetSeek.setOnClickListener(this);

        this.binding.spinnerDynamic.setOnItemSelectedListener(this);

        this.binding.seekbar.setOnSeekBarChangeListener(this);

        this.binding.switchOnOff.setOnCheckedChangeListener(this);
        this.binding.checkOnOff.setOnCheckedChangeListener(this);
    }
}