package com.example.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DescontoSimples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desconto_simples);
        Button bt = (Button) findViewById(R.id.calculo);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        bt.setOnClickListener(calculoDesconto);
    }

    private View.OnClickListener calculoDesconto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            EditText cap = (EditText) findViewById(R.id.Capital);
            String capital = cap.getText().toString();
            EditText tempo = (EditText) findViewById(R.id.Tempo);
            String temp = tempo.getText().toString();
            EditText taxa = (EditText) findViewById(R.id.Juros);
            String taxaJuros = taxa.getText().toString();

            DecimalFormat df = new DecimalFormat("#.00");

            TextView valor = (TextView) findViewById(R.id.valorTotal);
            TextView desconto = (TextView) findViewById(R.id.Desconto);

            if (!capital.matches("") || !taxaJuros.matches("") || !temp.matches("")) {

                Double descontos = Double.parseDouble(capital) * (Double.parseDouble(taxaJuros) / 100) * Double.parseDouble(temp);
                desconto.setText("R$ " + String.valueOf(df.format(descontos)));

                Double valorT = Double.parseDouble(capital) - descontos;
                valor.setText("R$ " + String.valueOf(df.format(valorT)));

            } else {

                valor.setText("Insira os dados");

            }

        }
    };
}
