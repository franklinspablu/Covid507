package com.example.covid507;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ValidatorActivity extends AppCompatActivity {
    TextView lblCedula, lblTemperatura, lblFecha, lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validator);

        IniciarControler();

        Intent i = getIntent();
        if (i != null) {
            PopularDatos(i);
        }

    }

    private void IniciarControler() {
        lblCedula = (TextView) findViewById(R.id.lblCedula);
        lblTemperatura = (TextView) findViewById(R.id.lblTemperatura);
        lblFecha = (TextView) findViewById(R.id.lblFecha);
        lblResultado = (TextView) findViewById(R.id.lblResultado);
    }

    private void PopularDatos(Intent i) {
        lblCedula.setText(i.getStringExtra("cedula"));
        Double temp = i.getDoubleExtra("temperatura", 0.0);
        lblTemperatura.setText(Double.toString(temp));
        lblFecha.setText(i.getStringExtra("fecha"));

        if (temp >= 36.5) {
            lblResultado.setText("Ya valio, tiene COVISH");
        } else {
            lblResultado.setText("Se salvó por ahora");
        }
    }
}