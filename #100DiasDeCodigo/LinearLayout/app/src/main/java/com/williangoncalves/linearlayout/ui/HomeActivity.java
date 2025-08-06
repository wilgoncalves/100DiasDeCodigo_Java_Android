package com.williangoncalves.linearlayout.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.williangoncalves.linearlayout.utils.AppConstants;
import com.williangoncalves.linearlayout.R;

public class HomeActivity extends AppCompatActivity {

    private final ViewHolder viewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewHolder.textViewEmail = findViewById(R.id.textview_email);

        getUserInformation();
    }

    private void getUserInformation() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String email = bundle.getString(AppConstants.EMAIL_KEY);
            viewHolder.textViewEmail.setText(email);
        }
    }

    private static class ViewHolder {
        TextView textViewEmail;
    }
}