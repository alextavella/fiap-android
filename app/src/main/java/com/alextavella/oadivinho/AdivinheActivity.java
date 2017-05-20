package com.alextavella.oadivinho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class AdivinheActivity extends AppCompatActivity {

    private EditText etChuteJogador;
    private TextView tvUltimoChute;

    private int chuteJogador;
    private int numeroAleatorio;
    private Random geradorNumero;
    private String textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivinhe);

        this.generateNumber();
        this.init();
    }

    public void go(View view) {
        if (TextUtils.isEmpty(
                etChuteJogador
                        .getText()
                        .toString())) {

            Toast.makeText(this, "Informe seu chute", Toast.LENGTH_LONG)
                    .show();

        } else {

            chuteJogador = Integer.parseInt(etChuteJogador.getText().toString());
            tvUltimoChute.requestFocus();

            boolean valid = valid(chuteJogador, numeroAleatorio);
            Toast.makeText(this, getMessage(valid), Toast.LENGTH_SHORT).show();

            if (valid) {
                tvUltimoChute.setText("");
                this.generateNumber();
            } else {
                tvUltimoChute.setText(String.valueOf(numeroAleatorio));
            }
        }
    }

    private void init() {
        etChuteJogador = (EditText) findViewById(R.id.etChuteJogador);
        tvUltimoChute = (TextView) findViewById(R.id.tvUltimoChute);
    }

    private Number generateNumber() {
        return numeroAleatorio = new Random().nextInt(11);
    }

    private Boolean valid(int value1, int value2) {
        return value1 == value2;
    }

    private String getMessage(boolean valid) {
        return valid ? "ACERTOU!!!" : "ERROOU!!!";
    }
}
