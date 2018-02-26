package com.example.javierlopezgirela.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class VistaPrincipal extends AppCompatActivity {

    private Button jugar, creditos, listaPokemon;
    private String score;
    private String fecha;

    private void init(){

        jugar = findViewById(R.id.jugar);
        listaPokemon = findViewById(R.id.listaPokemon);

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(VistaPrincipal.this, jugar.class);
                startActivity(i);
            }
        });

        listaPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VistaPrincipal.this, ListaPokemon.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_principal);
        init();
    }
}
