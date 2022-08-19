package com.example.appfumas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appfumas.Classes.Usuario;

public class InfoUser extends AppCompatActivity {
    Button c, v;
    static String meio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_user);
        c = findViewById(R.id.btnCigarro);
        v = findViewById(R.id.btnVape);
    }

    public void escolha(View view){
        if(c.isPressed()){
            TelaFumante.escolha = 1;
            meio = "cigarro";
        }
        else if(v.isPressed()){
            TelaFumante.escolha = 2;
            meio = "vape";
        }
        startActivity(new Intent(this, TelaFumante.class));
    }
}