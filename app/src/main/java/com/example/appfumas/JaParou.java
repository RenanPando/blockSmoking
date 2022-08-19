package com.example.appfumas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class JaParou extends AppCompatActivity {
    static int escolha;
    AutoCompleteTextView actv1, actv2, actv3, actv4, actv5;
    TextView txt1, txt2;
    String dia, mes, ano, usos, qtduso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ja_parou);
        actv1 = findViewById(R.id.actvDia);
        actv2 = findViewById(R.id.actvMes);
        actv3 = findViewById(R.id.actvAno);
        actv4 = findViewById(R.id.actvDiario);
        actv5 = findViewById(R.id.actvNico);
        txt1 = findViewById(R.id.txtVezes);
        txt2 = findViewById(R.id.txtQtd);
        String[] dias = getResources().getStringArray(R.array.dias);
        String[] meses = getResources().getStringArray(R.array.meses);
        String[] anos = getResources().getStringArray(R.array.anus);
        String[] qtdUso = getResources().getStringArray(R.array.uso);
        ArrayAdapter adapterD = new ArrayAdapter(this, R.layout.dropdown_menu, dias);
        ArrayAdapter adapterM = new ArrayAdapter(this, R.layout.dropdown_menu, meses);
        ArrayAdapter adapterA = new ArrayAdapter(this, R.layout.dropdown_menu, anos);
        ArrayAdapter adapterUso = new ArrayAdapter(this, R.layout.dropdown_menu, qtdUso);
        actv1.setAdapter(adapterD);
        actv2.setAdapter(adapterM);
        actv3.setAdapter(adapterA);
        actv4.setAdapter(adapterUso);
        if(escolha == 2){
            txt1.setText("Quantas vezes usava ao dia?");
            txt2.setText("Quanta nicotina tinha no pod/vape?");
            String[] nico = getResources().getStringArray(R.array.nico);
            ArrayAdapter adapterQtd = new ArrayAdapter(this, R.layout.dropdown_menu, nico);
            actv5.setAdapter(adapterQtd);
        } else {
            String[] cigQtd = getResources().getStringArray(R.array.qtd);
            ArrayAdapter adapterQtd = new ArrayAdapter(this, R.layout.dropdown_menu, cigQtd);
            actv5.setAdapter(adapterQtd);
        }

        actv1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                dia = parent.getItemAtPosition(position).toString();
            }
        });

        actv2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                mes = parent.getItemAtPosition(position).toString();
            }
        });

        actv3.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                ano = parent.getItemAtPosition(position).toString();
            }
        });

        actv4.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                usos = parent.getItemAtPosition(position).toString();
            }
        });

        actv5.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                qtduso = parent.getItemAtPosition(position).toString();
            }
        });
    }
    public void mudarTela(View v){
        if (dia == null || mes == null || ano == null || usos == null || qtduso == null){
            Toast.makeText(this, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(this, TelaPrincipal.class));
        }
    }
}