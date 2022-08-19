package com.example.appfumas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.appfumas.Classes.Usuario;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FormPessoal extends AppCompatActivity {
    AutoCompleteTextView actv1, actv2, actv3;
    EditText nome, email, senha;
    RadioButton f, m, nb, nulo;
    Button c;
    RadioGroup rg;
    String dataNasc, gen, mes, ano, dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pessoal);
        rg = findViewById(R.id.radioGroup);
        actv1 = findViewById(R.id.actvDia);
        actv2 = findViewById(R.id.actvMes);
        actv3 = findViewById(R.id.actvAno);
        nome = findViewById(R.id.campoNome);
        email = findViewById(R.id.campoEmail);
        senha = findViewById(R.id.campoSenha);
        f = findViewById(R.id.rFem);
        m = findViewById(R.id.rMasc);
        nb = findViewById(R.id.rNb);
        nulo = findViewById(R.id.rNull);
        c = findViewById(R.id.btnContinuar);

        // adaptadores
        String[] dias = getResources().getStringArray(R.array.dias);
        String[] meses = getResources().getStringArray(R.array.meses);
        String[] anos = getResources().getStringArray(R.array.anus);
        ArrayAdapter arrayAdapterD = new ArrayAdapter(this, R.layout.dropdown_menu, dias);
        ArrayAdapter arrayAdapterM = new ArrayAdapter(this, R.layout.dropdown_menu, meses);
        ArrayAdapter arrayAdapterA = new ArrayAdapter(this, R.layout.dropdown_menu, anos);
        actv1.setAdapter(arrayAdapterD);
        actv2.setAdapter(arrayAdapterM);
        actv3.setAdapter(arrayAdapterA);
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
    }

    public void cadastrar(View v) {
        if (f.isChecked()) {
            gen = "Feminino";
        } else if (m.isChecked()) {
            gen = "Masculino";
        } else if (nb.isChecked()) {
            gen = "Não-binário";
        } else if (nulo.isChecked()) {
            gen = "Prefere não dizer";
        }
        dataNasc = dia+"-"+mes+"-"+ano;
        String n = nome.getText().toString();
        String e = email.getText().toString();
        String s = senha.getText().toString();
        String[] split = e.split("@");
        String id = split[0];
        TelaFumante.id = id;
        TelaFumante.gen = gen;
        TelaFumante.dataNasc = dataNasc;
        if (n.trim().isEmpty() || e.trim().isEmpty() || s.trim().isEmpty() || rg.getCheckedRadioButtonId() == -1 || dia == null || mes == null || ano == null || e.contains("@") == false || e.contains(".com") == false)  { // verificar se e-mail é apenas um espaço branco
            Toast.makeText(this, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show();
        } else {
            Usuario user = new Usuario(id, n, e, s);
            Usuario info = new Usuario(id, dataNasc, gen, "desconhecido", "desconhecido");
            user.salvarDados();
            info.salvarInfo();
            avançarTela();
        }
    }

    public void avançarTela(){
        startActivity(new Intent(this, InfoUser.class));
    }
    //teste
}