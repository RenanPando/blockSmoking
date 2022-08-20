package com.example.appfumas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appfumas.Classes.Registros;
import com.example.appfumas.Classes.Usuario;
import com.example.appfumas.Fragments.FragmentHome;
import com.example.appfumas.Fragments.FragmentRegistros;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    EditText email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.campoEmail);
        senha = findViewById(R.id.campoSenha);
    }

    public void logar(View v){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("User");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean logado = false;
                String e = email.getText().toString();
                String s = senha.getText().toString();
                String[] split = e.split("@");
                String id = split[0];
                Registros.id = id;
                for (DataSnapshot d : snapshot.getChildren()){
                    if (d.getValue(Usuario.class).getEmail().equals(e) && d.getValue(Usuario.class).getSenha().equals(s)) {
                        logado = true;
                        mudarTela();
                        break;
                    }
                }
                if (logado == false){
                    Toast.makeText(Login.this, "Credenciais inválidas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void mudarTela(){
        startActivity(new Intent(this, TelaPrincipal.class));
    }

    public void irCadastro(View v){
        startActivity(new Intent(this, TelaInformativo.class));
    }
}