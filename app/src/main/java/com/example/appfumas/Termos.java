package com.example.appfumas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Termos extends AppCompatActivity {
    TextView termos;
    RadioButton c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termos);
        c = findViewById(R.id.btnConcorda);
        termos = findViewById(R.id.txtTermos);
        termos.setText(R.string.termos);
        getWindow().setStatusBarColor(getResources().getColor(R.color.whiteish));
    }

    public void concluirTermos(View v) {
        if(c.isChecked()){
            startActivity(new Intent(this, FormPessoal.class));
        }
    }
}