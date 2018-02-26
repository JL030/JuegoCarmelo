package com.example.javierlopezgirela.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class jugar extends AppCompatActivity {

    private String[] nombrePokemon = {"bulbasaur", "charmander", "groudon", "kyogre", "pikachu", "rayquaza", "salamence", "snorlax", "squirtle"};
    private String[] sombraPokemon = {"bulbasaurnegro", "charmandernegro", "groudonnegro", "kyogrenegro", "pikachunegro", "rayquazanegro",
            "salamencenegro", "snorlaxnegro", "squirtlenegro"};
    private ArrayList<Integer> numGenerados = new ArrayList<>();
    private int intentos = 3;
    private Button aceptar, salir;
    private int angulo;
    private TextView numeroIntentos, score;
    private int numGenerado = 0, scored = 0;
    private EditText pokemonInsertado;
    private ImageView pokemon;
    private TextView cuentaNuevoPokemon;

    private void init(){
        aceptar =findViewById(R.id.aceptar);
        salir = findViewById(R.id.salir);
        numeroIntentos = findViewById(R.id.intentos);
        cuentaNuevoPokemon = findViewById(R.id.cuenta);
        score = findViewById(R.id.score);
        pokemonInsertado = findViewById(R.id.insertaNombre);
        pokemon = findViewById(R.id.imagenPokemon);
        numeroIntentos.setText("Nº INTENTOS -> " + intentos);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (scored == 8){
            Intent i = new Intent(jugar.this, EnhorabuenaActivity.class);
            startActivity(i);
        }
        numGenerado = generaNumero(numGenerados);
        sombraPokemon(numGenerado);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreInsertado = pokemonInsertado.getText().toString().toLowerCase().trim();
                if (nombreInsertado.equalsIgnoreCase(nombrePokemon[numGenerado])){
                    scored+=1;
                    if (scored > 1 || scored == 0){
                        score.setText(scored + " ACIERTOS");

                    }else{
                        score.setText(scored + " ACIERTO");

                    }
                    rotarImagen();
                    imagenPokemon(numGenerado);
                    esperarNuevoPokemon();
                }else if(nombreInsertado.isEmpty() || nombreInsertado.equalsIgnoreCase("")) {
                    Toast.makeText(jugar.this, "Inserte un pokemon", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(jugar.this, "No es ese pokemon", Toast.LENGTH_SHORT).show();
                    intentos-=1;
                    if (intentos <= 0){
                        Intent i  = new Intent(jugar.this, SplashPerdedor.class);
                        startActivity(i);
                    }
                    numeroIntentos.setText("Nº INTENTOS -> " + intentos);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        init();
    }

    private void esperarNuevoPokemon(){
        new CountDownTimer(3000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                numeroIntentos.setText("Generando en " + (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                pokemonInsertado.setText("");
                pokemonInsertado.setHint("Nombre del Pokemon");
                init();
            }
        }.start();
    }

    private void sombraPokemon(int numero){
        int resId = getResources().getIdentifier(sombraPokemon[numero], "drawable", getPackageName());
        pokemon.setImageResource(resId);
    }

    private void imagenPokemon(int numero){
        int resId = getResources().getIdentifier(nombrePokemon[numero], "drawable", getPackageName());
        pokemon.setImageResource(resId);
    }

    private int generaNumero(ArrayList<Integer> numGenerados){
        int numero = (int) (Math.random()* nombrePokemon.length);
        if (numGenerados.contains(numero)){
            numero = (int) (Math.random()* nombrePokemon.length);
            if (numGenerados.contains(numero)){
                numero = (int) (Math.random()* nombrePokemon.length);
            }else{
                numGenerados.add(numero);
            }
        }else{
            numGenerados.add(numero);
        }
        Log.v("xyxy", "Pokemon " + nombrePokemon[numero]);
        Log.v("xyxy", "numero -> " + numero);
        return numero;
    }

    private void rotarImagen(){
        angulo*=360;
        RotateAnimation rotate = new RotateAnimation(angulo, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setFillAfter(true);
        rotate.setDuration(400);
        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
        pokemon.startAnimation(rotate);
    }
}
