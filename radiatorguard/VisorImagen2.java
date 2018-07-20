package com.djg.radiatorguard;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class VisorImagen2 extends AppCompatActivity {

    // Globales

    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    String descripcion;



    // Creación:

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen2);

        Intent intent = getIntent();

        // llamo info extra
        Bundle b = intent.getExtras();



        if(b!= null){

            // recupera informacion que se enviodes de el adaptador de la lista
            // informacion de descripcion del producto
            descripcion = (b.getString("DESCRIP"));




            viewPager = (ViewPager) findViewById(R.id.deslizar);

            sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

            // envio a la clase viewpaperadapter la informacion del contexto, la descripcion
            ViewPaperAdapter viewPaperAdapter = new ViewPaperAdapter(this, descripcion);


            // imagenes se trabajan en el adaptador
            viewPager.setAdapter(viewPaperAdapter);


            // para los puntos


            dotscount = viewPaperAdapter.getCount();
            dots = new ImageView[dotscount];

            for(int i = 0; i < dotscount; i++){

                dots[i] = new ImageView(this);
                dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                params.setMargins(8, 0, 8, 0);

                sliderDotspanel.addView(dots[i], params);

            }

            dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                    for(int i = 0; i< dotscount; i++){
                        dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                    }

                    dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });


        }

    }
}
