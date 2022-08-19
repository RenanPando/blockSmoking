package com.example.appfumas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.appfumas.Classes.Usuario;

public class TelaFumante extends AppCompatActivity {
    RadioButton fuma, normal;
    static int escolha;
    static String id, dataNasc, gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_fumante);
        fuma = findViewById(R.id.rFuma);
        normal = findViewById(R.id.rNao);
    }

    public void fumanteCheck(View v){
        if(fuma.isChecked()){
            Usuario u = new Usuario(id, dataNasc, gen, InfoUser.meio, "fumante");
            u.salvarInfo();
            AindaFuma.escolha = this.escolha;
            startActivity(new Intent(this, AindaFuma.class));
        } else if(normal.isChecked()){
            Usuario u = new Usuario(id, dataNasc, gen, InfoUser.meio, "não fuma");
            u.salvarInfo();
            JaParou.escolha = this.escolha;
            startActivity(new Intent(this, JaParou.class));
        }
    }
}