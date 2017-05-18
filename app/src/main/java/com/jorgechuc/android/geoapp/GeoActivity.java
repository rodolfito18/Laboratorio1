package com.jorgechuc.android.geoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class GeoActivity extends AppCompatActivity {
    Button mBotonCierto;
    Button mBotonFalso;
    Button mBotonSiguiente;
    TextView mTextoPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        mBotonCierto = (Button) findViewById(R.id.boton_cierto);
        mBotonFalso = (Button) findViewById(R.id.boton_falso);
        mBotonSiguiente = (Button) findViewById(R.id.boton_siguiente);
        mTextoPregunta = (TextView) findViewById(R.id.texto_pregunta);

        mBotonCierto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verificarRespuesta(true);


                // Toast.makeText(GeoActivity.this,R.string.texto_correcto,Toast.LENGTH_SHORT).show();





            }
        });

        mBotonFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verificarRespuesta(false);
                //Toast.makeText(GeoActivity.this, R.string.texto_incorrecto,Toast.LENGTH_SHORT).show();






            }
        });

        mBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreuntaActual = mPreuntaActual + 1;
                if(mPreuntaActual ==mBancoDePreguntas.length){
                    mPreuntaActual = 0;
                }

                actualizarPregunta();


            }
        });


    }

    private Pregunta mBancoDePreguntas[] = {

            new Pregunta(R.string.texto_pregunta_1,false),
            new Pregunta(R.string.texto_pregunta_2,true),
            new Pregunta(R.string.texto_pregunta_3,true),
            new Pregunta(R.string.texto_pregunta_4,true),
            new Pregunta(R.string.texto_pregunta_5,false),
    };

    private int mPreuntaActual = 0;


    private void actualizarPregunta(){

        int preguntaActual = mBancoDePreguntas[mPreuntaActual].getMdIdResTexto();
        mTextoPregunta.setText(preguntaActual);
    }

    private void verificarRespuesta(boolean botonOprimido){

        boolean respuestaEsVerdadera = mBancoDePreguntas[mPreuntaActual].getMRespuestaVerdadera();
        if(botonOprimido == respuestaEsVerdadera) {
            Toast.makeText(GeoActivity.this, R.string.texto_correcto, Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(GeoActivity.this,R.string.texto_incorrecto, Toast.LENGTH_SHORT).show();

        }

    }

}
