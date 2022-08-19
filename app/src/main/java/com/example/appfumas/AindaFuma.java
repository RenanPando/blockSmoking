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

public class AindaFuma extends AppCompatActivity {
    AutoCompleteTextView actv1, actv2;
    TextView txt1, txt2;
    String usos, qtduso;
    static int escolha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ainda_fuma);
        actv1 = findViewById(R.id.actv1);
        actv2 = findViewById(R.id.actv2);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        String[] qtd = getResources().getStringArray(R.array.qtd);
        String[] nico = getResources().getStringArray(R.array.nico);
        String[] uso = getResources().getStringArray(R.array.uso);
        ArrayAdapter adapterUso = new ArrayAdapter(this, R.layout.dropdown_menu, uso);
        actv1.setAdapter(adapterUso);
        if(escolha == 1){
            ArrayAdapter adapterQtd = new ArrayAdapter(this, R.layout.dropdown_menu, qtd);
            actv2.setAdapter(adapterQtd);
        }
        else if(escolha == 2){
            ArrayAdapter adapterNicotina = new ArrayAdapter(this, R.layout.dropdown_menu, nico);
            actv2.setAdapter(adapterNicotina);
            txt1.setText("Quantas vezes você usa vape por dia?");
            txt2.setText("Quanta nicotina tem no pod/vape?");
        }

        actv1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                usos = parent.getItemAtPosition(position).toString();
            }
        });

        actv2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                qtduso = parent.getItemAtPosition(position).toString();
            }
        });

    }

    public void mudarTela(View v){
        if (usos == null || qtduso == null){
            Toast.makeText(this, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(this, TelaPrincipal.class));
        }
    }

}