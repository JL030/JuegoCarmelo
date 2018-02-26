package com.example.javierlopezgirela.myapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class EnhorabuenaActivity extends AppCompatActivity {

    private GifImageView imagen, imagen1;

    private void init(){

        imagen = findViewById(R.id.imagen);
        imagen1 = findViewById(R.id.imagen1);

        try{
            InputStream in = getAssets().open("enhorabuenahomer.gif");
            InputStream in1 = getAssets().open("ganador.gif");
            byte[]bytes = IOUtils.toByteArray(in);
            byte[]bytes1 = IOUtils.toByteArray(in1);
            imagen.setBytes(bytes);
            imagen1.setBytes(bytes1);
            imagen.startAnimation();
            imagen1.startAnimation();

        }catch (IOException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                EnhorabuenaActivity.this.startActivity(new Intent(EnhorabuenaActivity.this, VistaPrincipal.class));
                EnhorabuenaActivity.this.finish();
            }
        },3000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enhorabuena);
        init();
    }
}
