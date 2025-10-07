package com.devmasterteam.tasks.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.viewmodel.MainViewModel;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;

import com.devmasterteam.tasks.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TaskActivity.class));
            }
        });

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_all_tasks, R.id.nav_overdue, R.id.nav_next_tasks, R.id.nav_logout)
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController nav, @NonNull NavDestination destination, @Nullable Bundle b) {
                if (destination.getId() == R.id.nav_logout) {
                    handleLogout();
                }
            }
        });

        // Cria observadores
        loadObservers();

        // Carrega os dados salvos do usuário
        viewModel.loadUserData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            handleLogout();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void handleLogout() {
        viewModel.logout();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void loadObservers() {
        this.viewModel.userData.observe(this, new Observer<PersonModel>() {
            @Override
            public void onChanged(PersonModel personModel) {
                View headerView = binding.navView.getHeaderView(0);
                TextView textName = headerView.findViewById(R.id.text_name);
                TextView textEmail = headerView.findViewById(R.id.text_email);

                textName.setText(personModel.getName());
                textEmail.setText(personModel.getEmail());
            }
        });
    }
}