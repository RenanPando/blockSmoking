package com.example.appfumas.Classes;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Registros {
    public static String id;
    Calendar c = Calendar.getInstance();
    int qtdFumo, reaisGastos;
    String sentimento;
    String[] nomeMes = {"janeiro","fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro"};
    String data = nomeMes[c.get(Calendar.MONTH)]+"-"+c.get(Calendar.YEAR);
    String dia = String.valueOf(c.get(Calendar.DAY_OF_MONTH));

    public Registros(int qtdFumo, int reaisGastos, String sentimento) {
        this.qtdFumo = qtdFumo;
        this.reaisGastos = reaisGastos;
        this.sentimento = sentimento;
    }

    public Registros() {
    }

    public void realizarRegistro(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Registros").child(id).child(data).child(dia).setValue(this);
    }

    public int getQtdFumo() {
        return qtdFumo;
    }

    public void setQtdFumo(int qtdFumo) {
        this.qtdFumo = qtdFumo;
    }

    public int getReaisGastos() {
        return reaisGastos;
    }

    public void setReaisGastos(int reaisGastos) {
        this.reaisGastos = reaisGastos;
    }

    public String getSentimento() {
        return sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }
}
