package com.example.diogo.alcoolvsgasolina;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.FloatRange;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText etGasolina;
    EditText etAlcool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular= (Button) findViewById(R.id.btnCalcular);
        etGasolina= (EditText) findViewById(R.id.precoGasolina);
        etAlcool= (EditText) findViewById(R.id.precoAlcool);


        btnCalcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                try{

                    float gasolina = Float.valueOf(etGasolina.getText().toString());
                    float alcool = Float.valueOf(etAlcool.getText().toString());

                    if(alcool/gasolina > 0.7){
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Resultado:");
                        alertDialog.setMessage("Abasteça com Gasolina!");

                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                    else{
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Resultado:");
                        alertDialog.setMessage("Abasteça com Álcool!");

                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }catch (Exception e){
                    Context contexto = getApplicationContext();
                    String txt = "Campo vazio";
                    int duracao = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(contexto,txt,duracao);
                    toast.show();
                }
            }
        });
    }
}
