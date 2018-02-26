package com.example.javierlopezgirela.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Splash extends AppCompatActivity {

    private GifImageView imagen;

    private void init(){

        imagen =findViewById(R.id.imagengif);

        try{
            InputStream in = getAssets().open("ball.gif");
            byte[]bytes= IOUtils.toByteArray(in);
            imagen.setBytes(bytes);
            imagen.startAnimation();
        }catch (IOException e){
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, VistaPrincipal.class);
                startActivity(i);
            }
        },3000);

        new Intent(Splash.this,VistaPrincipal.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }
}
