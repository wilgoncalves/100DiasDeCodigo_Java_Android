package com.williangoncalves.navigationdrawer;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.williangoncalves.navigationdrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura barra de navegação:
        setSupportActionBar(binding.appBarMain.toolbar);

        // Cria referência para toda a área do NavigationDrawer:
        DrawerLayout drawer = binding.drawerLayout;

        // Cria referência para a área de navegação:
        NavigationView navigationView = binding.navView;

        // Define configurações do NavigationDrawer:
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();

        // Configura área que irá carregar os fragments:
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // Configura menu superior de navegação:
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        // Configura a navegação para o NavigationView:
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}