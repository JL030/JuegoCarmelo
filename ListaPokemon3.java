package com.example.javierlopezgirela.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListaPokemon3 extends AppCompatActivity {

    private Button menu, pag2;

    private void init(){

        menu = findViewById(R.id.menu);
        pag2 = findViewById(R.id.pag2);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaPokemon3.this, VistaPrincipal.class);
                startActivity(i);
            }
        });

        pag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaPokemon3.this, ListaPokemon2.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pokemon3);
        init();
    }
}
