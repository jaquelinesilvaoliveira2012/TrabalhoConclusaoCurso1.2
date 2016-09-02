package com.example.computador.crud;

import android.app.Activity;


public class Usuario extends Activity {


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", Sobrenome='" + Sobrenome + '\'' +
                ", idade=" + idade +
                ", senha='" + senha + '\'' +
                '}';
    }

    private int id, idade;
    private String email, nome , Sobrenome, senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }




    public Usuario(){}

    public Usuario(int id, String email, String nome, String Sobrenome, int idade, String senha){
        this.id = id;
        this.email = email;
        this.Sobrenome = Sobrenome;
        this.senha = senha;
        this.nome = nome;
        this.idade = idade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}