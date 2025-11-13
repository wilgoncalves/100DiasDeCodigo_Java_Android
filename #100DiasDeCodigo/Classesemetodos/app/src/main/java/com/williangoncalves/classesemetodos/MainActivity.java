package com.williangoncalves.classesemetodos;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.williangoncalves.classesemetodos.classes.Conta;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*
        Casa minhaCasa = new Casa();
        minhaCasa.cor = "Azul";
        minhaCasa.abrirPorta();

        Casa minhaCasa2 = new Casa();
        minhaCasa2.cor = "Branca";

        System.out.println(minhaCasa.cor); */

        /*
        Funcionario funcionario = new Funcionario();
        funcionario.nome = "Willian";
        funcionario.salario = 10000;

        //double salarioRecuperado = funcionario.recuperarSalario();
        //System.out.println("O salário do " + funcionario.nome + " é " + salarioRecuperado);

        // Sobrecarga:
        double salarioComBonus = funcionario.recuperarSalario(150);
        System.out.println("O salário do " + funcionario.nome + " é " + salarioComBonus);
         */

        /*
        // Herança:
        Animal animal = new Animal();
        animal.correr();

        Cao cao = new Cao();
        cao.dormir();
        cao.latir();
        cao.correr();
        cao.setCor("Azul");
        System.out.println(cao.getCor());

        Passaro passaro = new Passaro();
        passaro.correr();
        passaro.voar();
         */

        // Modificadores de acesso:
        Conta conta = new Conta();
        conta.depositar(100);
        conta.sacar(50);
        System.out.println(conta.recuperarSaldo());
    }
}