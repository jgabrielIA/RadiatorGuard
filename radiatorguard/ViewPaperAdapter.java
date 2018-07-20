package com.djg.radiatorguard;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class ViewPaperAdapter extends PagerAdapter{

    private Context context;
    private LayoutInflater layoutInflater;

    String descripcion;

    // Datos prueba ktm
    int [] images;


    //metodo constructor
    // se trae imformacion de la actividad visor imagen 2

    public ViewPaperAdapter(Context context, String descripcion) {

        this.context = context;
        this.descripcion = descripcion;

        //Log.i("parada", descripcion);
        //Log.i("medida descripcion", String.valueOf(descripcion.length()));

        ArregloImagenes(descripcion);

    }



    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    // publica imagenes en pantalla
    @Override
    public Object instantiateItem( ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.secuencia_imagenes,null);


        // instancia donde se va a publicar imagenes
        ImageView imageView = (ImageView) view.findViewById(R.id.secuencia);


        // publica imagenes de cada referencia de protector
        imageView.setImageResource(images[position]);

        // para hacer zoom:

        PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);
        photoView.update();

        //añade elemnto para ver:

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);

        return  view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }



    // metodos

    public  void ArregloImagenes( String descripcion){

        //Log.i("metodo", descripcion);


        if(descripcion == "Duke 200/390 Negro" || (descripcion != null && descripcion.equals("Duke 200/390 Negro"))){

            images = new int[]{
                    R.drawable.ktm200390negra,
                    R.drawable.ktm200390negra,
                    R.drawable.ktm200390negra,
                    R.drawable.ktm200390negra
            };

        }

        else if(descripcion == "Duke 200/390 Naranja" || (descripcion != null && descripcion.equals("Duke 200/390 Naranja"))){

            images = new int[]{
                    R.drawable.ktm200390naranja,
                    R.drawable.ktm200390naranja,
                    R.drawable.ktm200390naranja,
                    R.drawable.ktm200390naranja
            };

        }
        else if(descripcion == "Duke 250/390 Negro" || (descripcion != null && descripcion.equals("Duke 250/390 Negro"))){

            images = new int[]{
                    R.drawable.ktm250390negra,
                    R.drawable.ktm250390negra,
                    R.drawable.ktm250390negra,
                    R.drawable.ktm250390negra
            };

        }
        else if(descripcion == "Duke 250/390 Naranja" || (descripcion != null && descripcion.equals("Duke 250/390 Naranja"))){

            images = new int[]{
                    R.drawable.ktm250390naranja,
                    R.drawable.ktm250390naranja,
                    R.drawable.ktm250390naranja,
                    R.drawable.ktm250390naranja
            };

        }
        else if(descripcion == "KTM RC 200 Negro" || (descripcion != null && descripcion.equals("KTM RC 200 Negro"))){

            images = new int[]{
                    R.drawable.ic_ktm333,
                    R.drawable.ic_ktm333,
                    R.drawable.ic_ktm333,
                    R.drawable.ic_ktm333
            };

        }
        else if(descripcion == "KTM RC 200 Naranja" || (descripcion != null && descripcion.equals("KTM RC 200 Naranja"))){

            images = new int[]{
                    R.drawable.ic_ktm333,
                    R.drawable.ic_ktm333,
                    R.drawable.ic_ktm333,
                    R.drawable.ic_ktm333
            };

        }

        else if(descripcion == "Duke 690 Negro" || (descripcion != null && descripcion.equals("Duke 690 Negro"))){

            images = new int[]{
                    R.drawable.ic_ktm333,
                    R.drawable.ic_ktm333,
                    R.drawable.ic_ktm333,
                    R.drawable.ic_ktm333
            };

        }
        else if(descripcion == "Duke 690 Naranja" || (descripcion != null && descripcion.equals("Duke 690 Naranja"))){

            images = new int[]{
                    R.drawable.ktm690naranja,
                    R.drawable.ktm690naranja,
                    R.drawable.ktm690naranja,
                    R.drawable.ktm690naranja
            };

        }
        else if(descripcion == "Duke 990 Naranja" || (descripcion != null && descripcion.equals("Duke 990 Naranja"))){

            images = new int[]{
                    R.drawable.ktm990naranja,
                    R.drawable.ktm990naranja,
                    R.drawable.ktm990naranja,
                    R.drawable.ktm990naranja
            };

        }
        else if(descripcion == "Ninja 250 Negro" || (descripcion != null && descripcion.equals("Ninja 250 Negro"))){

            images = new int[]{
                    R.drawable.kawaninja250,
                    R.drawable.kawaninja250,
                    R.drawable.kawaninja250,
                    R.drawable.kawaninja250
            };

        }
        else if(descripcion == "Ninja 300 Negro" || (descripcion != null && descripcion.equals("Ninja 300 Negro"))){

            images = new int[]{
                    R.drawable.kawaninja300,
                    R.drawable.kawaninja300,
                    R.drawable.kawaninja300,
                    R.drawable.kawaninja300
            };

        }
        else if(descripcion == "Z250SL Negro" || (descripcion != null && descripcion.equals("Z250SL Negro"))){

            images = new int[]{
                    R.drawable.kawaz250sl,
                    R.drawable.kawaz250sl,
                    R.drawable.kawaz250sl,
                    R.drawable.kawaz250sl
            };

        }
        else if(descripcion == "Z250 Negro" || (descripcion != null && descripcion.equals("Z250 Negro"))){

            images = new int[]{
                    R.drawable.kawaz250,
                    R.drawable.kawaz250,
                    R.drawable.kawaz250,
                    R.drawable.kawaz250
            };

        }
        else if(descripcion == "ER6N Antiguo Negro" || (descripcion != null && descripcion.equals("ER6N Antiguo Negro"))){

            images = new int[]{
                    R.drawable.kawa1,
                    R.drawable.kawa1,
                    R.drawable.kawa1,
                    R.drawable.kawa1
            };

        }
        else if(descripcion == "ER6N Nuevo Negro" || (descripcion != null && descripcion.equals("ER6N Nuevo Negro"))){

            images = new int[]{
                    R.drawable.kawaer6nn,
                    R.drawable.kawaer6nn,
                    R.drawable.kawaer6nn,
                    R.drawable.kawaer6nn
            };

        }
        else if(descripcion == "Versys 650 Negro" || (descripcion != null && descripcion.equals("Versys 650 Negro"))){

            images = new int[]{
                    R.drawable.kawa1,
                    R.drawable.kawa1,
                    R.drawable.kawa1,
                    R.drawable.kawa1
            };

        }
        else if(descripcion == "Z800 Negro" || (descripcion != null && descripcion.equals("Z800 Negro"))){

            images = new int[]{
                    R.drawable.kawaz800,
                    R.drawable.kawaz800,
                    R.drawable.kawaz800,
                    R.drawable.kawaz800
            };

        }
        else if(descripcion == "Z1000 Negro" || (descripcion != null && descripcion.equals("Z1000 Negro"))){

            images = new int[]{
                    R.drawable.kawaz1000,
                    R.drawable.kawaz1000,
                    R.drawable.kawaz1000,
                    R.drawable.kawaz1000
            };

        }
        else if(descripcion == "Versys 1000 Negro" || (descripcion != null && descripcion.equals("Versys 1000 Negro"))){

            images = new int[]{
                    R.drawable.kawa1,
                    R.drawable.kawa1,
                    R.drawable.kawa1,
                    R.drawable.kawa1
            };

        }
        else if(descripcion == "Z900 Negro" || (descripcion != null && descripcion.equals("Z900 Negro"))){

            images = new int[]{
                    R.drawable.kawaz900,
                    R.drawable.kawaz900,
                    R.drawable.kawaz900,
                    R.drawable.kawaz900
            };

        }
        else if(descripcion == "Ninja H2 Negro" || (descripcion != null && descripcion.equals("Ninja H2 Negro"))){

            images = new int[]{
                    R.drawable.kawaninjah2,
                    R.drawable.kawaninjah2,
                    R.drawable.kawaninjah2,
                    R.drawable.kawaninjah2
            };

        }
        else if(descripcion == "R15 Negro" || (descripcion != null && descripcion.equals("R15 Negro"))){

            images = new int[]{
                    R.drawable.yamar15n,
                    R.drawable.yamar15n,
                    R.drawable.yamar15n,
                    R.drawable.yamar15n
            };

        }
        else if(descripcion == "R15 Azul" || (descripcion != null && descripcion.equals("R15 Azul"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "R15 Rojo" || (descripcion != null && descripcion.equals("R15 Rojo"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "R3 Negro" || (descripcion != null && descripcion.equals("R3 Negro"))){

            images = new int[]{
                    R.drawable.yamar3n,
                    R.drawable.yamar3n,
                    R.drawable.yamar3n,
                    R.drawable.yamar3n
            };

        }
        else if(descripcion == "R3 Azul" || (descripcion != null && descripcion.equals("R3 Azul"))){

            images = new int[]{
                    R.drawable.yamar3a,
                    R.drawable.yamar3a,
                    R.drawable.yamar3a,
                    R.drawable.yamar3a
            };

        }
        else if(descripcion == "R3 Rojo" || (descripcion != null && descripcion.equals("R3 Rojo"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "MT03 Negro" || (descripcion != null && descripcion.equals("MT03 Negro"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "MT03 Azul" || (descripcion != null && descripcion.equals("MT03 Azul"))){

            images = new int[]{
                    R.drawable.yamamt3a,
                    R.drawable.yamamt3a,
                    R.drawable.yamamt3a,
                    R.drawable.yamamt3a
            };

        }
        else if(descripcion == "MT07 Negro" || (descripcion != null && descripcion.equals("MT07 Negro"))){

            images = new int[]{
                    R.drawable.yamamt07n,
                    R.drawable.yamamt07n,
                    R.drawable.yamamt07n,
                    R.drawable.yamamt07n
            };

        }
        else if(descripcion == "MT07 Azul" || (descripcion != null && descripcion.equals("MT07 Azul"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "MT09 Negro" || (descripcion != null && descripcion.equals("MT09 Negro"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "MT09 Azul" || (descripcion != null && descripcion.equals("MT09 Azul"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "MT09 Nuevo Negro" || (descripcion != null && descripcion.equals("MT09 Nuevo Negro"))){

            images = new int[]{
                    R.drawable.yamamt09nn,
                    R.drawable.yamamt09nn,
                    R.drawable.yamamt09nn,
                    R.drawable.yamamt09nn
            };

        }
        else if(descripcion == "FZ8 Negro" || (descripcion != null && descripcion.equals("FZ8 Negro"))){

            images = new int[]{
                    R.drawable.yamafz8n,
                    R.drawable.yamafz8n,
                    R.drawable.yamafz8n,
                    R.drawable.yamafz8n
            };

        }
        else if(descripcion == "FZ8 Azul" || (descripcion != null && descripcion.equals("FZ8 Azul"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "Fazer8 Negro" || (descripcion != null && descripcion.equals("Fazer8 Negro"))){

            images = new int[]{
                    R.drawable.yamafazer8n,
                    R.drawable.yamafazer8n,
                    R.drawable.yamafazer8n,
                    R.drawable.yamafazer8n
            };

        }
        else if(descripcion == "Fazer8 Azul" || (descripcion != null && descripcion.equals("Fazer8 Azul"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "XJ6 Negro" || (descripcion != null && descripcion.equals("XJ6 Negro"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "TRACER Negro" || (descripcion != null && descripcion.equals("TRACER Negro"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "R6S Negro" || (descripcion != null && descripcion.equals("R6S Negro"))){

            images = new int[]{
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

        }
        else if(descripcion == "NS200 Negro" || (descripcion != null && descripcion.equals("NS200 Negro"))){

            images = new int[]{
                    R.drawable.ic_baja,
                    R.drawable.ic_baja,
                    R.drawable.ic_baja,
                    R.drawable.ic_baja
            };

        }
        else if(descripcion == "NS200 Naranja" || (descripcion != null && descripcion.equals("NS200 Naranja"))){

            images = new int[]{
                    R.drawable.pulsarns200na,
                    R.drawable.pulsarns200na,
                    R.drawable.pulsarns200na,
                    R.drawable.pulsarns200na
            };

        }
        else if(descripcion == "NS200 Blanco" || (descripcion != null && descripcion.equals("NS200 Blanco"))){

            images = new int[]{
                    R.drawable.pulsarns200b,
                    R.drawable.pulsarns200b,
                    R.drawable.pulsarns200b,
                    R.drawable.pulsarns200b
            };

        }
        else if(descripcion == "NS200 Azul" || (descripcion != null && descripcion.equals("NS200 Azul"))){

            images = new int[]{
                    R.drawable.ic_baja,
                    R.drawable.ic_baja,
                    R.drawable.ic_baja,
                    R.drawable.ic_baja
            };

        }
        else if(descripcion == "NS200 Rojo" || (descripcion != null && descripcion.equals("NS200 Rojo"))){

            images = new int[]{
                    R.drawable.ic_baja,
                    R.drawable.ic_baja,
                    R.drawable.ic_baja,
                    R.drawable.ic_baja
            };

        }
        else if(descripcion == "Dominar 400 Negro" || (descripcion != null && descripcion.equals("Dominar 400 Negro"))){

            images = new int[]{
                    R.drawable.dom400n,
                    R.drawable.dom400n,
                    R.drawable.dom400n,
                    R.drawable.dom400n
            };

        }
        else if(descripcion == "CBR 250 Negro" || (descripcion != null && descripcion.equals("CBR 250 Negro"))){

            images = new int[]{
                    R.drawable.honda1,
                    R.drawable.honda1,
                    R.drawable.honda1,
                    R.drawable.honda1
            };

        }
        else if(descripcion == "CB 500" || (descripcion != null && descripcion.equals("CB 500"))){

            images = new int[]{
                    R.drawable.honda1,
                    R.drawable.honda1,
                    R.drawable.honda1,
                    R.drawable.honda1
            };

        }
        else if(descripcion == "GSX-s 150 Negro" || (descripcion != null && descripcion.equals("GSX-s 150 Negro"))){

            images = new int[]{
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu
            };

        }
        else if(descripcion == "GSX-r 150 Negro" || (descripcion != null && descripcion.equals("GSX-r 150 Negro"))){

            images = new int[]{
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu
            };

        }
        else if(descripcion == "GSR600 Negro" || (descripcion != null && descripcion.equals("GSR600 Negro"))){

            images = new int[]{
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu
            };

        }
        else if(descripcion == "Vstrom Clásica Negro" || (descripcion != null && descripcion.equals("Vstrom Clásica Negro"))){

            images = new int[]{
                    R.drawable.suzuvstromclan,
                    R.drawable.suzuvstromclan,
                    R.drawable.suzuvstromclan,
                    R.drawable.suzuvstromclan
            };

        }
        else if(descripcion == "GSR 750 Negro" || (descripcion != null && descripcion.equals("GSR 750 Negro"))){

            images = new int[]{
                    R.drawable.suzugsr750n,
                    R.drawable.suzugsr750n,
                    R.drawable.suzugsr750n,
                    R.drawable.suzugsr750n
            };

        }
        else if(descripcion == "SV 650 Negro" || (descripcion != null && descripcion.equals("SV 650 Negro"))){

            images = new int[]{
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu
            };

        }
        else if(descripcion == "GSX-R 600 Negro" || (descripcion != null && descripcion.equals("GSX-R 600 Negro"))){

            images = new int[]{
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu
            };

        }
        else if(descripcion == "Panigale 899 2 radiadores" || (descripcion != null && descripcion.equals("Panigale 899 2 radiadores"))){

            images = new int[]{
                    R.drawable.ducati
            };

        }
        else if(descripcion == "Tapa lujo depósito líquido frenos\n" +
                "delantero" || (descripcion != null && descripcion.equals("Tapa lujo depósito líquido frenos\n" + "delantero"))){

            images = new int[]{
                    R.drawable.ktmfrenodel200390,
                    R.drawable.ktmfrenodel200390,
                    R.drawable.ktmfrenodel200390,
                    R.drawable.ktmfrenodel200390
            };

        }
        else if(descripcion == "Tapa lujo depósito líquido frenos\n" +
                "trasero" || (descripcion != null && descripcion.equals("Tapa lujo depósito líquido frenos\n" +
                "trasero"))){

            images = new int[]{
                    R.drawable.ic_herra,
                    R.drawable.ic_herra,
                    R.drawable.ic_herra,
                    R.drawable.ic_herra
            };

        }
        else if(descripcion == "Cúpula lujo KTM" || (descripcion != null && descripcion.equals("Cúpula lujo KTM"))){

            images = new int[]{
                    R.drawable.ktmcupula200390,
                    R.drawable.ktmcupula200390,
                    R.drawable.ktmcupula200390,
                    R.drawable.ktmcupula200390
            };

        }
        else if(descripcion == "Guardabarros Monoshock KTM" || (descripcion != null && descripcion.equals("Guardabarros Monoshock KTM"))){

            images = new int[]{
                    R.drawable.ktmguardamono200390,
                    R.drawable.ktmguardamono200390,
                    R.drawable.ktmguardamono200390,
                    R.drawable.ktmguardamono200390
            };

        }
        else if(descripcion == "Porta Placa" || (descripcion != null && descripcion.equals("Porta Placa"))){

            images = new int[]{
                    R.drawable.ktmportaplaca200390,
                    R.drawable.ktmportaplaca200390,
                    R.drawable.ktmportaplaca200390,
                    R.drawable.ktmportaplaca200390
            };

        }

        else{
            //Log.i("metodo2", descripcion);

            images = new int[]{
                    R.drawable.logo_1,
                    R.drawable.logo_1,
                    R.drawable.logo_1,
                    R.drawable.logo_1
            };
        }



    }

}
