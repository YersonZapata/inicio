package com.zapata.yerson.inicio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    SharedPreferences dato;
    SharedPreferences.Editor editor;

    TextView tDato;
    EditText eDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences dato = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

       // dato = getPreferences(MODE_PRIVATE);
        editor = dato.edit();

        eDato = (EditText) findViewById(R.id.eNombre);

        //actualizar preferencias
        String val_Nombre= String.valueOf(dato.getString("var_nombre","none"));
        if (val_Nombre.equals("")||val_Nombre=="none"){

        }else{
            Intent i = new Intent(this, MainActivity.class );
            startActivity(i);
        }

    }
    public void ingresar(View v) {
        String Nombre = eDato.getText().toString();
        if(Nombre!=null && !Nombre.isEmpty()){
            try{
                editor.putString("var_nombre",Nombre);
                editor.commit();
                Intent i = new Intent(this, MainActivity.class );
                startActivity(i);
            }catch (Exception e){
                Toast.makeText(loginActivity.this,"no se guardo",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(loginActivity.this,"Llene el campo con un nombre valido",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {//evita que vuelva a la actividad de login;
        moveTaskToBack(true);
    } //luego borrar esta funcion
}
