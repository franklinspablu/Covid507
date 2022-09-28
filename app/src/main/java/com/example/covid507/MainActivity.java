package com.example.covid507;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText txtCedula, txtTemperatura;
     DatePicker dtpFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarControles();
    }

    private void IniciarControles(){
        txtCedula =(EditText)findViewById(R.id.txtCedula);
        txtTemperatura =(EditText)findViewById(R.id.txtTemperatura);

        dtpFecha = (DatePicker)findViewById((R.id.dtpFecha));
    }

    public void EnviarDatosCovid(View view){
        try {
            String cedula = txtCedula.getText().toString();
            double temperatura = Double.parseDouble(txtTemperatura.getText().toString());

            String fecha = dtpFecha.getDayOfMonth() + "-" + (dtpFecha.getMonth()+1) + "-" + dtpFecha.getYear();

            Intent i = new Intent(this, ValidatorActivity.class);
            i.putExtra("cedula", cedula);
            i.putExtra("temperatura", temperatura);
            i.putExtra("fecha", fecha);
            startActivity(i);

        } catch (Exception e){
            Toast.makeText(this, "Errorcito => " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }


    }
