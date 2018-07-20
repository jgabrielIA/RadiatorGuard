package com.djg.radiatorguard;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    String[][] datos;
    int [] datosImg;

    // metodo constructor

    public Adaptador(Context conexto, String[][] datos, int[] imagenes){

        this.contexto = conexto;
        this.datos = datos;
        this.datosImg = imagenes;
        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);
        // referencia al layout donde esta cada item

        TextView marca = (TextView) vista.findViewById(R.id.lmarca);
        TextView referencia = (TextView) vista.findViewById(R.id.lref);
        TextView descripcion = (TextView) vista.findViewById(R.id.ldescrip);
        TextView costo = (TextView) vista.findViewById(R.id.lcosto);

        ImageView imagen = (ImageView)vista.findViewById(R.id.limagen);

        marca.setText("Marca: " + datos[i][0]);
        referencia.setText("Referencia: " + datos[i][1]);
        descripcion.setText("Descripción: " + datos[i][2]);
        costo.setText("Costo: " + datos[i][3]);

        imagen.setImageResource(datosImg[i]);

        // para dar clic a la imagen y se muetre en pantalla completa

        imagen.setTag(i);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // se declara transito de esta clase Adaptador del ListView
                // a una actividad nueva
               //** Intent visorImagen = new Intent(contexto, VisorImagen.class);

                // pero se guarda la informacion de la imagen como Extra
                // con la etiqueta IMG
                //**visorImagen.putExtra("IMG", datosImg[(Integer)v.getTag()]);

                // inicia actividad nueva
               //** contexto.startActivity(visorImagen);

                Intent visorImagen = new Intent(contexto, VisorImagen2.class);

                // enviar grupo de imagenes correspondientes al modelo de protector a
                // la actividad visor imagenes 2
                visorImagen.putExtra("DESCRIP", datos[(Integer)v.getTag()][2]);

                Log.i("ENTRADA1",datos[(Integer)v.getTag()][2]);


                contexto.startActivity(visorImagen);
            }
        });

        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
