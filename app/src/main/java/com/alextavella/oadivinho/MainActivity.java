package com.alextavella.oadivinho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText etChuteJogador;
    private TextView tvUltimoChute;

    private int chuteJogador;
    private int numeroAleatorio;
    private Random geradorNumero;
    private String textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geradorNumero = new Random();
        numeroAleatorio = geradorNumero.nextInt(11);

        etChuteJogador = (EditText) findViewById(R.id.etChuteJogador);
        tvUltimoChute = (TextView) findViewById(R.id.tvUltimoChute);
    }

    public void go(View view) {
        if (TextUtils.isEmpty(
                etChuteJogador
                        .getText()
                        .toString())) {

            Toast.makeText(this, "Informe seu chute", Toast.LENGTH_LONG)
                    .show();

        } else {

            chuteJogador = Integer.parseInt(
                    etChuteJogador.getText().toString());
            tvUltimoChute.requestFocus();

            textResult = compare(chuteJogador, numeroAleatorio);
            Toast.makeText(this, textResult, Toast.LENGTH_SHORT).show();

            tvUltimoChute.setText(String.valueOf(numeroAleatorio));
        }
    }

    private String compare(int value1, int value2) {
        if (value1 > value2) return "ACERTOU!!!";
        else if (value1 < value2) return "ERROOU!!!";
        return "EMPATE";
    }
}
