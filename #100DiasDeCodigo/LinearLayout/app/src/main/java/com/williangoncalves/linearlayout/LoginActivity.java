package com.williangoncalves.linearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewHolder.editTextEmail = findViewById(R.id.edittext_email);
        viewHolder.editTextPassword = findViewById(R.id.edittext_password);
        viewHolder.buttonLogin = findViewById(R.id.button_login);
        viewHolder.buttonRegister = findViewById(R.id.button_register);

        viewHolder.buttonLogin.setOnClickListener(this);
        viewHolder.buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_login) {

            String email = viewHolder.editTextEmail.getText().toString();
            String password = viewHolder.editTextPassword.getText().toString();

            if (!email.isEmpty() && !password.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putString("email", email);

                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            } else {
                Toast.makeText(this, getString(R.string.toast), Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.button_register) {
            // logica de registro
        }
    }

    private static class ViewHolder {
        EditText editTextEmail;
        EditText editTextPassword;
        Button buttonLogin;
        Button buttonRegister;
    }
}