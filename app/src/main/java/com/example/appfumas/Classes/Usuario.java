package com.example.appfumas.Classes;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Usuario {
    String id, nome, email, senha, meio, gênero, dataNasc, estadoUser;

    public Usuario(String id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String id, String dataNasc, String gênero, String meio, String estadoUser) {
        this.id = id;
        this.dataNasc = dataNasc;
        this.gênero = gênero;
        this.meio = meio;
        this.estadoUser = estadoUser;
    }

    public Usuario() {
    }

    public void salvarDados(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("User").child(id).setValue(this);
    }

    public void salvarInfo(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("User").child(id).child("Info").setValue(this);
    }

    public void realizarRegistro(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("User").child(id).child("Registros").setValue(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstadoUser() {
        return estadoUser;
    }

    public void setEstadoUser(String estado) {
        this.estadoUser = estadoUser;
    }

    public String getMeio() {
        return meio;
    }

    public void setMeio(String meio) {
        this.meio = meio;
    }

    public String getGênero() {
        return gênero;
    }

    public void setGênero(String gênero) {
        this.gênero = gênero;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
