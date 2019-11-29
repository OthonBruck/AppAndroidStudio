package com.example.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import java.text.DecimalFormat;

public class JurosSimples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_simples);
        Button bt = (Button) findViewById(R.id.calculo);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        bt.setOnClickListener(calculosimples);

    }

        private OnClickListener calculosimples = new OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText cap = (EditText) findViewById(R.id.Capital);
                String txcap = cap.getText().toString();
                EditText tempo = (EditText) findViewById(R.id.Tempo);
                String txtempo = tempo.getText().toString();
                EditText taxa = (EditText) findViewById(R.id.Juros);
                String txtaxa = taxa.getText().toString();

                DecimalFormat df = new DecimalFormat("#.00");

                TextView juros = (TextView) findViewById(R.id.JurosMês);
                TextView total = (TextView) findViewById(R.id.JurosTotal);

                if (!txcap.matches("") || !txtaxa.matches("") || !txtempo.matches("")) {

                    Double jurosSimples = Double.parseDouble(txcap) * (Double.parseDouble(txtaxa) / 100) * Double.parseDouble(txtempo);
                    total.setText("R$ " + String.valueOf(df.format(jurosSimples)));

                    Double jurosMes = jurosSimples / Double.parseDouble(txtempo);
                    juros.setText("R$ " + String.valueOf(df.format(jurosMes)));

                } else {

                    total.setText("Insira os dados");

                }

            }
        };
    }
