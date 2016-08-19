package com.example.computador.crud;

import android.app.Activity;

/**
 * Created by COMPUTADOR on 8/18/2016.
 */
public class Usuario extends Activity {

    private int id;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Pessoa='" + Pessoa + '\'' +
                ", idade=" + idade +
                ", senha=" + senha +
                '}';
    }

    private String Pessoa;
    private int idade;
    private int senha;


    public Usuario(){}

    public Usuario(int id, String Pessoa, int idade, int senha){
        this.id = id;
        this.senha = senha;
        this.Pessoa = Pessoa;
        this.idade = idade;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPessoa() {
        return Pessoa;
    }

    public void setPessoa(String pessoa) {
        Pessoa = pessoa;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}