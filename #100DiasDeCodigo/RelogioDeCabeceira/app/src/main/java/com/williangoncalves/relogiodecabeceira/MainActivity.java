package com.williangoncalves.relogiodecabeceira;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.williangoncalves.relogiodecabeceira.databinding.ActivityMainBinding;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private final String TAG = "MainActivity";
    private final Handler handler = new Handler();
    private Runnable runnable;
    private final BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            binding.textviewBatteryLevel.setText(getString(R.string.battery_level, level));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        setFlags();
        setListeners();
        hideOptions();
        startBedsideClock();

        // Log:
        // v = verbose
        Log.v(TAG, "verbose example");
        // d = debug
        Log.d(TAG, "debug example");
        // i = information
        Log.i(TAG, "information example");
        // w = warning
        Log.w(TAG, "warning example");
        // e = error
        Log.e(TAG, "error example");
        // wtf = What a Terrible Failure wtf???
        Log.wtf(TAG, "wtf example");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(batteryReceiver);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.checkbox_battery_level) {
            toggleBatteryLevel();
        } else if (v.getId() == R.id.imageview_settings) {
            showOptions();
        } else if (v.getId() == R.id.imageview_close) {
            hideOptions();
        }
    }

    private void toggleBatteryLevel() {
        boolean isVisible = binding.textviewBatteryLevel.getVisibility() == View.VISIBLE;
        binding.textviewBatteryLevel.setVisibility(isVisible ? View.GONE : View.VISIBLE);
    }

    private void setFlags() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    private void setListeners() {
        binding.checkboxBatteryLevel.setOnClickListener(this);
        binding.imageviewSettings.setOnClickListener(this);
        binding.imageviewClose.setOnClickListener(this);
    }

    private void startBedsideClock() {
        runnable = new Runnable() {
            @Override
            public void run() {

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());

                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second = calendar.get(Calendar.SECOND);

                String hourMinuteFormat = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
                String secondFormat = String.format(Locale.getDefault(), "%02d", second);

                binding.textviewHourMinute.setText(hourMinuteFormat);
                binding.textviewSeconds.setText(secondFormat);

                long now = SystemClock.uptimeMillis();
                Log.d(TAG, "Now" + now);
                handler.postAtTime(runnable, now + (1000 - (now % 1000)));
                Log.d(TAG, "Now calculo" + (now + (1000 - (now % 1000))));
            }
        };
        runnable.run();
    }

    private void getLanguage() {
        Locale.getDefault().getLanguage();             // en
        Locale.getDefault().getISO3Language();         // eng
        Locale.getDefault().getCountry();              // US
        Locale.getDefault().getISO3Country();          // USA
        Locale.getDefault().getDisplayCountry();       // United States
        Locale.getDefault().getDisplayName();          // English (United States)
        Locale.getDefault();                           // en_US
        Locale.getDefault().getDisplayLanguage();      // English
        Locale.getDefault().toLanguageTag();           // en-US
    }

    private void hideOptions() {
        int duration = 400;

        binding.checkboxBatteryLevel.post(new Runnable() {
            @Override
            public void run() {
                int heightCheckbox = binding.checkboxBatteryLevel.getHeight();
                binding.checkboxBatteryLevel.animate().translationY(heightCheckbox).setDuration(duration);
            }
        });

        binding.imageviewClose.post(new Runnable() {
            @Override
            public void run() {
                int heightImageView = binding.imageviewClose.getHeight();
                binding.imageviewClose.animate().translationY(heightImageView).setDuration(duration);
            }
        });
    }

    private void showOptions() {
        int duration = 400;
        binding.checkboxBatteryLevel.animate().translationY(0).setDuration(duration);
        binding.imageviewClose.animate().translationY(0).setDuration(duration);
    }
}