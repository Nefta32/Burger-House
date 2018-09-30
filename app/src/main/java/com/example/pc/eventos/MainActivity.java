package com.example.pc.eventos;

import android.Manifest;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.annotation.RawRes;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

   /*   PRIMER PROGRAMA DEL DIA
   ListView LVAlumnos;
   String [] ListaAlumnos = {"Edgar",
           "Alexis",
           "Ernesto",
           "Oscar",
           "Gustavo",
           "Eduardo",
           "Carlos",
           "Abby",
           "Miguel",
           "Juan",
           "Jose Luis"
        };*/

    // VARIABLES GLOBALES
    ImageView IVPasta, IVMalteada, IVPapas, IVPizza, IVChela, IVHamb;
    TextView textView2, TVPas, TVMal, TVPap, TVPiz, TVChe, TVHam;
    EditText editTextPedido;
    Button Envia;
    RatingBar ratingBar;
    SmsManager sms = SmsManager.getDefault();
    int Mese=1, Pasta, Malteada, Papas, Pizza, Chela, Hamb;
    float Estrellas=0;
    String Mesero="Neftali González Durán \nLa orden es:", a="", b="", c="", d="", e="", f="", Pedido="";

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DECLARACION DE ELEMENTOS Y ENLAZAMIENTO DE ID

        ratingBar = (RatingBar)findViewById(R.id.ratingBar);

        IVPasta=(ImageView)findViewById(R.id.IVPasta);
        IVMalteada=(ImageView)findViewById(R.id.IVMalteada);
        IVPapas=(ImageView)findViewById(R.id.IVPapas);
        IVPizza=(ImageView)findViewById(R.id.IVPizza);
        IVChela=(ImageView)findViewById(R.id.IVChela);
        IVHamb=(ImageView)findViewById(R.id.IVHamb);
        textView2=(TextView)findViewById(R.id.textView2);
        TVPas=(TextView)findViewById(R.id.TVPas);
        TVMal=(TextView)findViewById(R.id.TVMal);
        TVPap=(TextView)findViewById(R.id.TVPap);
        TVPiz=(TextView)findViewById(R.id.TVPiz);
        TVChe=(TextView)findViewById(R.id.TVChe);
        TVHam=(TextView)findViewById(R.id.TVHam);
        editTextPedido=(EditText)findViewById(R.id.editTextPedido);
        Envia=(Button)findViewById(R.id.Envia);

        //CREACCIÓN DE METODO setOnClickListener
        IVPasta.setOnClickListener(this);
        IVMalteada.setOnClickListener(this);
        IVPapas.setOnClickListener(this);
        IVPizza.setOnClickListener(this);
        IVChela.setOnClickListener(this);
        IVHamb.setOnClickListener(this);

        //CREACIÓN DE METODO setOnLongClickListener
        IVPasta.setOnLongClickListener(this);
        IVMalteada.setOnLongClickListener(this);
        IVPapas.setOnLongClickListener(this);
        IVPizza.setOnLongClickListener(this);
        IVChela.setOnLongClickListener(this);
        IVHamb.setOnLongClickListener(this);

        //RECUPERACION DE LA VARIABLE FLOTANTE QUE CONTIENE EL NUMERO DE ESTRELLAS DADAS
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float vi, boolean b) {
                Estrellas = vi;
            }
        });

        //REACCIÓN A LA ACCIÓN DE OPRIMIR EL BOTON ENVIAR
        Envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( Pedido.length() > 2) //SI LA LONGITUD DE LA CADENA "Pedido" REPRESENTA QUE CONTIENE ALGO
                {
                    Toast.makeText(getBaseContext(), "Generando nuevo pedido :3", Toast.LENGTH_SHORT).show(); //AVISA A USUARIO DE NUEVO PEDIDO

                    //REGRESA TODAS LAS VARIABLES A SU VALOR INICIAL "0"
                    Pasta=0;
                    Malteada=0;
                    Papas=0;
                    Pizza=0;
                    Chela=0;
                    Hamb=0;

                    //"ESCONDE" LOS TextView
                    TVPas.setVisibility(View.GONE);
                    TVMal.setVisibility(View.GONE);
                    TVPap.setVisibility(View.GONE);
                    TVPiz.setVisibility(View.GONE);
                    TVChe.setVisibility(View.GONE);
                    TVHam.setVisibility(View.GONE);

                    //SE INTENTA DEVOLVER A VALORES RANDOM
                    textView2.setText("Usted pide:");
                    editTextPedido.setText("Esperando...");

                    Pedido=""; //"ELIMINAMOS" LO GUARDADO EN EL STRIN Pedido

                }

                if ( Estrellas > 0 && (Pedido.isEmpty()) && ( Pasta>0 || Malteada>0 || Papas>0 || Pizza>0 || Chela>0 || Hamb>0))
                //SI SE LE DIO UNA CALIFICACION A LA APLICACION "Y" EL STRING DE LOS PEDIDOS ESTA VACIO "Y" ALGUNA DE LAS VARIABLES
                    //QUE RESGUARDAN LAS CANTIDADES A PEDIR ES POSITIVA
                {
                    //PROCEDEMOS A CONCATENAR CADA UNO DE LOS STRING REPRESENTANTES DE CADA ALIMENTO
                    if ( Pasta > 0 )
                    {
                        Pedido = Pedido.concat("\n"+a);
                    }
                    if ( Malteada > 0 )
                    {
                        Pedido = Pedido.concat("\n"+b);
                    }
                    if ( Papas > 0 )
                    {
                        Pedido = Pedido.concat("\n"+c);
                    }
                    if ( Pizza > 0 )
                    {
                        Pedido = Pedido.concat("\n"+d);
                    }
                    if ( Chela > 0 )
                    {
                        Pedido = Pedido.concat("\n"+e);
                    }
                    if ( Hamb > 0 )
                    {
                        Pedido = Pedido.concat("\n"+f);
                    }
                    if (Estrellas >= 1) //SI TENEMOS ALGUNA ESTRELLA CONCATENALA AL STRING Pedido
                    {
                        Pedido = Pedido.concat("\nCalificación: "+String.valueOf(Estrellas)+"\n");
                    }

                    //ENVIO DE LOS MENSAJES DE QUIEN LO HIZO Y LA ORDEN FINAL CON LA CALIFICACIÓN DE LA APLICACION
                    sms.sendTextMessage("5513894675", null,""+Mesero+"", null, null );

                    sms.sendTextMessage("5513894675", null,""+Pedido+"", null, null );

                    //SALUDO DE CORTESIA
                    Toast.makeText(getBaseContext(), "Gracias, disfrute la comida. :3", Toast.LENGTH_SHORT).show();
                }

                if ( Estrellas <= 0)//SI NO SE LE HA DADO CALIFICACIÓN A LA APLICACION SE LE PIDE CORDIALMENTE AL USUARIO LO HAGA
                {
                    Toast.makeText(getBaseContext(), "Olvidas calificarnos, gracias por tu compra. :3", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*  PRIMER PROGRAMA DEL DÍA
        LVAlumnos=(ListView)findViewById(R.id.LVAlumnos);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                ListaAlumnos);

        LVAlumnos.setAdapter(adaptador);

        LVAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Seleccionaste "+parent.getItemAtPosition(position),
                        Toast.LENGTH_SHORT).show();
            }
        });*/


    }

    @Override
    public void onClick(View v) { //METODO DE ASIGNACION DE VALORES CON CLICK NORMAL
        if ( v == IVPasta ) //SI SE PRESIONO EL IMAGEVIEW DE PASTA
        {
            Pasta=Pasta+1; //AL CONTADOR DE PASTA SUMALE UNO
            textView2.setText("Pasta"); //MUESTRA EN EL TEXTVIEW SECUNDARIO EL NOMBRE DEL ALIMENTO SELECCIONADO
            editTextPedido.setText(" "+Pasta+" "); //MUESTRA EN EL EDITTEXT LA CANTIDAD DE ALIMENTOS QUE LLEVAN EN LA CUENTA
            a = "Pasta:"+Pasta; //CREAMOS EL STRING REPRESENTANTE DEL ALIMENTO
            TVPas.setText(a); //LO MOSTRAMOS EN TEXTVIEW AUXILIAR DEL ALIMENTO PARA LA COMODIDAD DE VISUALIZACIÓN DEL USUARIO
            TVPas.setVisibility(View.VISIBLE);  //HACEMOS VISIBLE EL TEXTVIEW <---"YA QUE EN UN PRINCIPIO LO TENEMOS OCULTO"

            //PRACTICAMENTE ES LO MISMO PARA TODOS LOS DEMAS XD
        }
        else if ( v == IVMalteada )
        {
            Malteada=Malteada+1;
            textView2.setText("Malteada");
            editTextPedido.setText(""+Malteada+"");
            b = "Malteada:"+Malteada;
            TVMal.setText(b);
            TVMal.setVisibility(View.VISIBLE);
        }
        else if ( v == IVPapas )
        {
            Papas=Papas+1;
            textView2.setText("Papas");
            editTextPedido.setText(""+Papas+"");
            c = "Papas:"+Papas;
            TVPap.setText(c);
            TVPap.setVisibility(View.VISIBLE);
        }
        else if ( v == IVPizza )
        {
            Pizza=Pizza+1;
            textView2.setText("Pizza");
            editTextPedido.setText(""+Pizza+"");
            d = "Pizza:"+Pizza;
            TVPiz.setText(d);
            TVPiz.setVisibility(View.VISIBLE);
        }
        else if ( v == IVChela )
        {
            Chela=Chela+1;
            textView2.setText("Cerveza");
            editTextPedido.setText(""+Chela+"");
            e = "Cerveza:"+Chela;
            TVChe.setText(e);
            TVChe.setVisibility(View.VISIBLE);
        }
        else if ( v == IVHamb)
        {
            Hamb=Hamb+1;
            textView2.setText("Hamburguesa");
            editTextPedido.setText(""+Hamb+"");
            f = "Burger:"+Hamb;
            TVHam.setText(f);
            TVHam.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onLongClick(View v) { //METODO DE RESTA DE VALORES CON CLICK LARGO

        if ( v == IVPasta ) //SI SE MANTIENE PRESIONADA LA IMAGEVIEW DE PASTA
        {
            Pasta=Pasta-1; //AL CONTADOR DE PASTA RESTA UNO
            textView2.setText("Pasta"); //MUESTRA EN EL TEXTVIEW SECUNDARIO EL NOMBRE DEL ALIMENTO SELECCIONADO
            editTextPedido.setText(""+Pasta+""); //MUESTRA EN EL EDITTEXT LA CANTIDAD DE ALIMENTOS QUE LLEVAN EN LA CUENTA
            a = "Pasta:"+Pasta; //ACTUALIZA EL STRING
            TVPas.setText(a);  //LO MOSTRAMOS EN TEXTVIEW AUXILIAR DEL ALIMENTO PARA LA COMODIDAD DE VISUALIZACIÓN DEL USUARIO
            if ( Pasta <= 0)  //PREGUNTA SI LA CANTIDAD DE ALIMENTO ES IGUAL O MENOR A 0 PARA DECIDIR SI MUESTRA O NO, EL TEXTVIEW AUXILIAR
            {
                TVPas.setVisibility(View.GONE);
            }
            else
            {
                TVPas.setVisibility(View.VISIBLE);
            }

            //PRACTICAMENTE ES LO MISMO PARA TODOS LOS DEMAS XD
        }
        else if ( v == IVMalteada )
        {
            Malteada=Malteada-1;
            textView2.setText("Malteada");
            editTextPedido.setText(""+Malteada+"");
            b = "Malteada:"+Malteada;
            TVMal.setText(b);
            if ( Malteada <= 0)
            {
                TVMal.setVisibility(View.GONE);
            }
            else
            {
                TVMal.setVisibility(View.VISIBLE);
            }
        }
        else if ( v == IVPapas )
        {
            Papas=Papas-1;
            textView2.setText("Papas");
            editTextPedido.setText(""+Papas+"");
            c = "Papas:"+Papas;
            TVPap.setText(c);
            if ( Papas <= 0)
            {
                TVPap.setVisibility(View.GONE);
            }
            else
            {
                TVPap.setVisibility(View.VISIBLE);
            }
        }
        else if ( v == IVPizza )
        {
            Pizza=Pizza-1;
            textView2.setText("Pizza");
            editTextPedido.setText(""+Pizza+"");
            d = "Pizza:"+Pizza;
            TVPiz.setText(d);
            if ( Pizza <= 0)
            {
                TVPiz.setVisibility(View.GONE);
            }
            else
            {
                TVPiz.setVisibility(View.VISIBLE);
            }
        }
        else if ( v == IVChela )
        {
            Chela=Chela-1;
            textView2.setText("Cerveza");
            editTextPedido.setText(""+Chela+"");
            e = "Cerveza:"+Chela;
            TVChe.setText(e);
            if ( Chela <= 0)
            {
                TVChe.setVisibility(View.GONE);
            }
            else
            {
                TVChe.setVisibility(View.VISIBLE);
            }
        }
        else if ( v == IVHamb )
        {
            Hamb=Hamb-1;
            textView2.setText("Hamburguesa");
            editTextPedido.setText(""+Hamb+"");
            f = "Burger:"+Hamb;
            TVHam.setText(f);
            if ( Hamb <= 0 )
            {
                TVHam.setVisibility(View.GONE);
            }
            else
            {
                TVHam.setVisibility(View.VISIBLE);
            }
        }

        return true; //ES NECESARIO DE LOS CLICK´S LARGOS REGRESAR UN VERDADERO
    }
}
