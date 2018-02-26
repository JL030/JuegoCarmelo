package com.example.javierlopezgirela.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by javierlopezgirela on 25/2/18.
 */

public class ListaPokemon2 extends AppCompatActivity {

    private Button menu, pag1, pag2;

    private void init(){
        menu = findViewById(R.id.menu);
        pag1 = findViewById(R.id.pag1);
        pag2 = findViewById(R.id.pag2);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaPokemon2.this, VistaPrincipal.class);
                startActivity(i);
            }
        });

        pag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaPokemon2.this, ListaPokemon.class);
                startActivity(i);
            }
        });

        pag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaPokemon2.this, ListaPokemon3.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_pokemon2);
        init();
    }
}
