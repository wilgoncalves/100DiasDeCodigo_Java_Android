package com.williangoncalves.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
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

import com.williangoncalves.atmconsultoria.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enviarEmail();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail() {

        String celular = "tel:11996352894";
        String imagem = "https://i.pinimg.com/736x/64/ce/40/64ce408aaf1fd2a47469e0800a9648fd.jpg";
        String endereco = "https://www.google.com/maps/place/Parque+Dona+Lindu/@-8.1412917,-34.9041136,17z/data=!3m1!4b1!4m6!3m5!1s0x7ab1fbb126b6c8f:0x9428b8c3b9bb5afb!8m2!3d-8.1412917!4d-34.9041136!16s%2Fg%2F121wccjd?entry=ttu&g_ep=EgoyMDI2MDExMy4wIKXMDSoASAFQAw%3D%3D";

        // Abrir app de ligação:
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));

        // Abrindo imagem diretamente do Google:
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));

        // Abrindo endereço no Google Maps:
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));
        //startActivity(intent);

        // Envio de e-mail:
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo aplicativo");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática.");

        // Código para envio de email:
        intent.setType("message/rfc822");

        // Abre opções para apps de mensagens:
        //intent.setType("text/plain");

        // Abre apps de imagens:
        //intent.setType("image/*");

        // Abre app para PDF:
        //intent.setType("application/pdf");
;
        startActivity(Intent.createChooser(intent, "Compartilhar:"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}