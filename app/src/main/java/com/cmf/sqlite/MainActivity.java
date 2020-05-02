package com.cmf.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText codigo;
    String programa;
    Button guardar;
    Button mostrar;
    RadioGroup progama;
    EditText smart;
    EditText internet;
    EditText computador;
    Button eliminar;
    Button actualizar;
    Enc enc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codigo = (EditText) findViewById(R.id.codigo);
        progama = (RadioGroup) findViewById(R.id.programaGroup);
        internet = (EditText) findViewById(R.id.siI);
        computador = (EditText) findViewById(R.id.cSi);
        smart = (EditText) findViewById(R.id.siS);
        guardar = (Button) findViewById(R.id.btnGuardar);
        mostrar = (Button) findViewById(R.id.btnMostrar);
        actualizar = (Button) findViewById(R.id.btnActualizar);
        eliminar = (Button) findViewById(R.id.btnEliminar);

        progama.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.sistemas :
                        programa = "Sistemas";
                        Toast.makeText(getApplicationContext(), programa, Toast.LENGTH_SHORT).show();
                        return;
                    case R.id.mecanica :
                        programa = "Mecánica";
                        Toast.makeText(getApplicationContext(), programa, Toast.LENGTH_SHORT).show();
                        return;
                    case R.id.industrial :
                        programa = "Industrial";
                        Toast.makeText(getApplicationContext(), programa, Toast.LENGTH_SHORT).show();
                        return;
                    case R.id.mecatronica :
                        programa = "Mecatrónica";
                        Toast.makeText(getApplicationContext(), programa, Toast.LENGTH_SHORT).show();
                        return;
                    default: programa = "Sistemas";
                };
            }
        });

        final BaseDatos baseDatos = new BaseDatos(getApplicationContext());

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(baseDatos.eliminar(codigo.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Eliminado con exito...", Toast.LENGTH_SHORT).show();
                }{
                    Toast.makeText(getApplicationContext(), "Algo va mal...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),List.class);
                startActivity(i);
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baseDatos.buscarEnc(codigo.getText().toString())){
                    if (baseDatos.actualizarEnc(codigo.getText().toString(), programa, computador.getText().toString(), internet.getText().toString(), smart.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Actualizado correctamente", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "No encontrado en bd...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!baseDatos.buscarEnc(codigo.getText().toString())) {
                    enc = new Enc(codigo.getText().toString(), programa, computador.getText().toString(), internet.getText().toString(), smart.getText().toString());
                    baseDatos.agregarEnc(enc);
                    Toast.makeText(getApplicationContext(), "Agregado con exito!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Ocurrio un error...", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


}
