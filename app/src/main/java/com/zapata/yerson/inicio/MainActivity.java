package com.zapata.yerson.inicio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences dato;
    SharedPreferences.Editor editor;
    TextView tDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences dato = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        //dato = getPreferences(MODE_PRIVATE);
        editor = dato.edit();

        tDato = (TextView) findViewById(R.id.tNombre);

        String val_Nombre= String.valueOf(dato.getString("var_nombre","no habia nada"));
        tDato.setText("Bienvenido "+val_Nombre+"Su nombre ya se ha guardado ");


    }

    public void borrar(View v){ //luego borrar la funcion
        editor.clear();
        editor.commit();
        Intent i = new Intent(this, loginActivity.class );
        startActivity(i);
    }

    @Override
    public void onBackPressed() {//evita que vuelva a la actividad de login;
        moveTaskToBack(true);
    }
}
