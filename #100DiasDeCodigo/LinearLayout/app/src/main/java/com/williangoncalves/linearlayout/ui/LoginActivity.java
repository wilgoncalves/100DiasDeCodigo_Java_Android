package com.williangoncalves.linearlayout.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.williangoncalves.linearlayout.utils.AppConstants;
import com.williangoncalves.linearlayout.R;
import com.williangoncalves.linearlayout.business.UserBusiness;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final ViewHolder viewHolder = new ViewHolder();
    private UserBusiness userBusiness = new UserBusiness();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        viewHolder.linearLayoutLogin = findViewById(R.id.main);
        viewHolder.editTextEmail = findViewById(R.id.edittext_email);
        viewHolder.editTextPassword = findViewById(R.id.edittext_password);
        viewHolder.buttonLogin = findViewById(R.id.button_login);
        viewHolder.buttonRegister = findViewById(R.id.button_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left + viewHolder.linearLayoutLogin.getPaddingStart(),
                    systemBars.top,
                    systemBars.right + viewHolder.linearLayoutLogin.getPaddingEnd(),
                    systemBars.bottom);
            return insets;
        });

        viewHolder.buttonLogin.setOnClickListener(this);
        viewHolder.buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_login) {

            String email = viewHolder.editTextEmail.getText().toString();
            String password = viewHolder.editTextPassword.getText().toString();

            // regra de negócio:
            if (userBusiness.isValid(email, password)) {
                Bundle bundle = new Bundle();
                bundle.putString(AppConstants.EMAIL_KEY, email);

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
        LinearLayout linearLayoutLogin;
        EditText editTextEmail;
        EditText editTextPassword;
        Button buttonLogin;
        Button buttonRegister;
    }
}