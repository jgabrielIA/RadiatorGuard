package com.djg.radiatorguard;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {

    // Globales

    // objeto lista
    ListView listamodelos;



    // Datos segun marca para presentar en pantalla
    // KTM:
    //Las imagenes no deben pesar mas de 100KB
    //Las imagenes no deben superar un tamaño de 500*500 pixceles
    //http://compressjpeg.com/es/
    //https://www.iloveimg.com/es/

    String [][] datos  = {

            {"KTM","Duke200/390-1","Duke 200/390 Negro","$ 85.000"},
            {"KTM","Duke200/390-2","Duke 200/390 Naranja","$ 85.000"},
            {"KTM","Duke250/390-1","Duke 250/390 Negro","$ 85.000"},
            {"KTM","Duke250/390-1","Duke 250/390 Naranja","$ 85.000"},
            {"KTM","KTM RC 200-1","KTM RC 200 Negro","$ 85.000"},
            {"KTM","KTM RC 200-2","KTM RC 200 Naranja","$ 85.000"},
            {"KTM","Duke690-1","Duke 690 Negro","$ 90.000"},
            {"KTM","Duke690-2","Duke 690 Naranja","$ 90.000"},
            {"KTM","Duke990-1","Duke 990 Naranja","$ 90.000"}
    };

    int [] datosImg = {

            R.drawable.ktm200390negra,
            R.drawable.ktm200390naranja,
            R.drawable.ktm250390negra,
            R.drawable.ktm250390naranja,
            R.drawable.ic_ktm333,
            R.drawable.ic_ktm333,
            R.drawable.ic_ktm333,
            R.drawable.ktm690naranja,
            R.drawable.ktm990naranja
    };


    // Creacion:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // menu acerca de:
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Boton flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Snackbar.make(view, "Radiator Guard Info:", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                // abre actividad acerca de:
                Intent infoacerca = new Intent(PrincipalActivity.this, AcercaDe.class);
                startActivity(infoacerca);
            }
        });

        // menu desplegable
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // poder moverse en el menu desplegable
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Crea listview
        listamodelos = (ListView) findViewById(R.id.lista);
        // amarra el listview al adaptador
        listamodelos.setAdapter(new Adaptador(this, datos, datosImg));
    }



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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    // cuando le doy atras
    @Override
    public void onBackPressed() {


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START);
        } else {

            // Menu: ¿Desea salir de la aplicación?

            //super.onBackPressed();
            //PrincipalActivity.super.onBackPressed();
            // finish();

            // constructor del cuadro de dialogo
            AlertDialog.Builder cuadro = new AlertDialog.Builder(this);

            // configuracion de caracteristicas del cuadro de dialogo
            cuadro.setMessage("¿Desea salir de la aplicación?");
            cuadro.setTitle("Radiator Guard");
            cuadro.setIcon(R.drawable.logo_1);

            // boton si
            cuadro.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    // termina la app
                    finish();
                }
            });

            // boton no
            cuadro.setNegativeButton("Nooo!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    // cancela el cuadro de dialogo
                    dialog.cancel();
                }
            });

            AlertDialog dialog = cuadro.create();
            dialog.show();




        }
    }

    //genera menus superiores
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);

        // info contacto
        return true;
    }

    // menus en la esquina superior derecha
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            // ejecuta el info Aceca de:
            // se puede ver la introduccion o descripcion del negocio
            // y las redes sociales

            Intent infoacerca = new Intent(PrincipalActivity.this, AcercaDe.class);
            startActivity(infoacerca);

            // paso a ver actividad. acerca de


            }

        return super.onOptionsItemSelected(item);
    }

    // opciones del menu desplegable
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // ejecuta segun la opcion se leccionada

        if (id == R.id.KTM) {

            datos = new String[][]{

                    {"KTM", "Duke200/390-1", "Duke 200/390 Negro", "$ 85.000"},
                    {"KTM", "Duke200/390-2", "Duke 200/390 Naranja", "$ 85.000"},
                    {"KTM", "Duke250/390-1", "Duke 250/390 Negro", "$ 85.000"},
                    {"KTM", "Duke250/390-1", "Duke 250/390 Naranja", "$ 85.000"},
                    {"KTM", "KTM RC 200-1", "KTM RC 200 Negro", "$ 85.000"},
                    {"KTM", "KTM RC 200-2", "KTM RC 200 Naranja", "$ 85.000"},
                    {"KTM", "Duke690-1", "Duke 690 Negro", "$ 90.000"},
                    {"KTM", "Duke690-2", "Duke 690 Naranja", "$ 90.000"},
                    {"KTM", "Duke990-1", "Duke 990 Naranja", "$ 90.000"}
            };

            datosImg = new int[]{

                    R.drawable.ktm200390negra,
                    R.drawable.ktm200390naranja,
                    R.drawable.ktm250390negra,
                    R.drawable.ktm250390naranja,
                    R.drawable.ic_ktm333,
                    R.drawable.ic_ktm333,
                    R.drawable.ic_ktm333,
                    R.drawable.ktm690naranja,
                    R.drawable.ktm990naranja
            };

            listamodelos.setAdapter(new Adaptador(this, datos, datosImg));

        } else if (id == R.id.KAWASAKI) {

            datos = new String[][] {

                    {"KAWASAKI","Ninja250-1","Ninja 250 Negro","$ 85.000"},
                    {"KAWASAKI","Ninja300-1","Ninja 300 Negro","$ 85.000"},
                    {"KAWASAKI","Z250SL-1","Z250SL Negro","$ 85.000"},
                    {"KAWASAKI","Z250-1","Z250 Negro","$ 85.000"},
                    {"KAWASAKI","ER6NA-1","ER6N Antiguo Negro","$ 90.000"},
                    {"KAWASAKI","ER6NN-1","ER6N Nuevo Negro","$ 90.000"},
                    {"KAWASAKI","Versys650-1","Versys 650 Negro","$ 90.000"},
                    {"KAWASAKI","Z800-1","Z800 Negro","$ 90.000"},
                    {"KAWASAKI","Z1000-1","Z1000 Negro","$ 90.000"},
                    {"KAWASAKI","Versys1000-1","Versys 1000 Negro","$ 90.000"},
                    {"KAWASAKI","Z900-1","Z900 Negro","$ 95.000"},
                    {"KAWASAKI","NH2-1","Ninja H2 Negro","$ 120.000"}
            };

            datosImg = new int []{

                    R.drawable.kawaninja250,
                    R.drawable.kawaninja300,
                    R.drawable.kawaz250sl,
                    R.drawable.kawaz250,
                    R.drawable.kawa1,
                    R.drawable.kawaer6nn,
                    R.drawable.kawa1,
                    R.drawable.kawaz800,
                    R.drawable.kawaz1000,
                    R.drawable.kawa1,
                    R.drawable.kawaz900,
                    R.drawable.kawaninjah2
            };

            listamodelos.setAdapter(new Adaptador(this, datos, datosImg));

        } else if (id == R.id.YAMAHA) {

            datos = new String[][] {

                    {"YAMAHA","R15-1","R15 Negro","$ 65.000"},
                    {"YAMAHA","R15-2","R15 Azul","$ 65.000"},
                    {"YAMAHA","R15-3","R15 Rojo","$ 65.000"},
                    {"YAMAHA","R3-N","R3 Negro","$ 85.000"},
                    {"YAMAHA","R3-A","R3 Azul","$ 85.000"},
                    {"YAMAHA","R3-R","R3 Rojo","$ 85.000"},
                    {"YAMAHA","MT03-N","MT03 Negro","$ 85.000"},
                    {"YAMAHA","MT03-A","MT03 Azul","$ 85.000"},
                    {"YAMAHA","MT07-N","MT07 Negro","$ 90.000"},
                    {"YAMAHA","MT07-A","MT07 Azul","$ 90.000"},
                    {"YAMAHA","MT09-N","MT09 Negro","$ 95.000"},
                    {"YAMAHA","MT09-A","MT09 Azul","$ 95.000"},
                    {"YAMAHA","MT09-N- Nuevo","MT09 Nuevo Negro","$ 95.000"},
                    {"YAMAHA","FZ8-N","FZ8 Negro","$ 95.000"},
                    {"YAMAHA","FZ8-A","FZ8 Azul","$ 95.000"},
                    {"YAMAHA","FAZER8-N","Fazer8 Negro","$ 95.000"},
                    {"YAMAHA","FAZER8-A","Fazer8 Azul","$ 95.000"},
                    {"YAMAHA","XJ6 - N","XJ6 Negro","$ 90.000"},
                    {"YAMAHA","TRACER-N","TRACER Negro","$ 95.000"},
                    {"YAMAHA","R6S-N","R6S Negro","$ 100.000"}
            };

            datosImg = new int[]{

                    R.drawable.yamar15n,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamar3n,
                    R.drawable.yamar3a,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamamt3a,
                    R.drawable.yamamt07n,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamamt09nn,
                    R.drawable.yamafz8n,
                    R.drawable.yamaha1,
                    R.drawable.yamafazer8n,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1,
                    R.drawable.yamaha1
            };

            listamodelos.setAdapter(new Adaptador(this, datos, datosImg));

        } else if (id == R.id.BAJAJ) {

            datos = new String[][] {

                    {"BAJAJ","NS200-1","NS200 Negro","$ 65.000"},
                    {"BAJAJ","NS200-2","NS200 Naranja","$ 65.000"},
                    {"BAJAJ","NS200-3","NS200 Blanco","$ 65.000"},
                    {"BAJAJ","NS200-4","NS200 Azul","$ 65.000"},
                    {"BAJAJ","NS200-5","NS200 Rojo","$ 65.000"},
                    {"BAJAJ","D400-1","Dominar 400 Negro","$ 85.000"}
            };

            datosImg = new int[]{

                    R.drawable.ic_baja,
                    R.drawable.pulsarns200na,
                    R.drawable.pulsarns200b,
                    R.drawable.ic_baja,
                    R.drawable.ic_baja,
                    R.drawable.dom400n
            };

            listamodelos.setAdapter(new Adaptador(this, datos, datosImg));

        } else if (id == R.id.HONDA) {

            datos = new String[][] {

                    {"HONDA","CBR250-1","CBR 250 Negro","$ 80.000"},
                    {"HONDA","CB500-1","CB 500","$ 90.000"}
            };

            datosImg = new int[] {

                    R.drawable.honda1,
                    R.drawable.honda1
            };

            listamodelos.setAdapter(new Adaptador(this, datos, datosImg));

        } else if (id == R.id.SUZUKI) {

             datos = new String[][] {

                    {"SUZUKI","GSXs150-1","GSX-s 150 Negro","$ 65.000"},
                    {"SUZUKI","GSXr150-","GSX-r 150 Negro","$ 65.000"},
                    {"SUZUKI","GSR600-1","GSR600 Negro","$ 95.000"},
                    {"SUZUKI","VSTROMC-1","Vstrom Clásica Negro","$ 90.000"},
                    {"SUZUKI","GSR750-1","GSR 750 Negro","$ 95.000"},
                    {"SUZUKI","SV650-1","SV 650 Negro","$ 95.000"},
                    {"SUZUKI","GSX-R 600-1","GSX-R 600 Negro","$ 100.000"}
            };

            datosImg = new int[] {

                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu,
                    R.drawable.suzuvstromclan,
                    R.drawable.suzugsr750n,
                    R.drawable.ic_suzu,
                    R.drawable.ic_suzu
            };

            listamodelos.setAdapter(new Adaptador(this, datos, datosImg));

        } else if (id == R.id.DUCATI) {

            datos = new String[][] {

                    {"DUCATI","Panigale-1","Panigale 899 2 radiadores","$ 130.000"}
            };

            datosImg = new int[] {

                    R.drawable.ducati
            };

            listamodelos.setAdapter(new Adaptador(this, datos, datosImg));

        }else if (id == R.id.accesorios) {

            datos = new String[][] {

                    {"KTM","Duke200/390-1","Tapa lujo depósito líquido frenos\n" +
                            "delantero","$ 20.000"},
                    {"KTM","Duke200/390-2","Tapa lujo depósito líquido frenos\n" +
                            "trasero","$ 28.000"},
                    {"KTM","Duke200/390-3","Cúpula lujo KTM","$ 35.000"},
                    {"KTM","Duke200/390-4","Guardabarros Monoshock KTM","$ 45.000"},
                    {"KTM","Duke200/390-5","Porta Placa","$ 25.000"}
            };

            datosImg = new int[] {

                    R.drawable.ktmfrenodel200390,
                    R.drawable.ic_herra,
                    R.drawable.ktmcupula200390,
                    R.drawable.ktmguardamono200390,
                    R.drawable.ktmportaplaca200390
            };

            listamodelos.setAdapter(new Adaptador(this, datos, datosImg));

        }

        // cuando se elige alguna opcion del menu se cierra el menu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


    // metodos



}
