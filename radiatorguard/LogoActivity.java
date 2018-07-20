// Aplicacion diseñada para Radiator Guard
// paquete principal DJG

// Pantalla de inicio

package com.djg.radiatorguard;


// Librerias

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


// Codigo de Actividad logo (SplashScreen)

public class LogoActivity extends AppCompatActivity {

    // metodo basico: crea la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // crea, verifica instancias guardadas que se puedan requerir

        super.onCreate(savedInstanceState);

        // crea elementos de la interfaz grafica

        setContentView(R.layout.activity_logo);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Temporizador de 5 segundos donde se aprecia el logo principal
        // Luego pasa a la actividad principal

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // Se ejecuta al pasar los 5 segundos

                Intent Aprincipal = new Intent(LogoActivity.this, PrincipalActivity.class);
                startActivity(Aprincipal);
                finish();

            }
        }, 3000);
    }
    // Final del onCreate


    // opciones ciclo de vida de la app

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    // cuando le doy atras

    @Override
    public void onBackPressed() {

        finish();

    }
}
