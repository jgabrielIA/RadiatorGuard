package com.djg.radiatorguard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class VisorImagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);

        // crea imageview

        ImageView img = (ImageView)findViewById(R.id.ImagenCompleta);

        // se comunica con la clase Adaptador y trae la informacion de la imagen

        Intent intent = getIntent();

        // llamo info extra
        Bundle b = intent.getExtras();

        // si no esta vacio, publica lo que encontro con la etiqueta IMG
        if(b!= null){
           img.setImageResource(b.getInt("IMG"));
        }

    }
}
