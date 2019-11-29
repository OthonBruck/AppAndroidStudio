package com.example.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class JurosComposto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_composto);
        Button bt = (Button) findViewById(R.id.calculo);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        bt.setOnClickListener(calculoComposto);

    }
            private View.OnClickListener calculoComposto = new View.OnClickListener() {
                @Override
                public void onClick(View v) {

            EditText cap = (EditText) findViewById(R.id.Capital);
            String capital = cap.getText().toString();
            EditText tempo = (EditText) findViewById(R.id.Tempo);
            String temp = tempo.getText().toString();
            EditText taxa = (EditText) findViewById(R.id.Juros);
            String taxaJuros = taxa.getText().toString();

            DecimalFormat df = new DecimalFormat("#.00");


            TextView composto = (TextView) findViewById(R.id.txtComposto);
            composto.setText("");

            if (!capital.matches("") || !taxaJuros.matches("") || !temp.matches("")) {
                for (int i = 0; i <= Integer.parseInt(temp); i++) {

                    Double montante = Double.parseDouble(capital) * Math.pow((1+ Double.parseDouble(taxaJuros)/100), i);
                    Double montante2 = Double.parseDouble(capital) * Math.pow((1+ Double.parseDouble(taxaJuros)/100), i - 1);

                    if (i == 0){

                        composto.append(i+"º                         R$ 0,00                   R$"+df.format(montante)+"\n");

                    } else{

                        composto.append(i+"º                         R$ "+df.format(montante-montante2)+ "                 R$ "+ df.format(montante)+"\n");

                    }
                }
            } else {

                composto.setText("Insira os dados:)");
            }

        }
    };

}
