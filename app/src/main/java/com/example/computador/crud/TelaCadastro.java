package com.example.computador.crud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by COMPUTADOR on 8/18/2016.
 */


public class TelaCadastro extends Activity {

        EditText EdUsuario;
        EditText EdIdade;
        EditText EdSenha;
        Button BtCadastrar;
        Button BtExcluir;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrarctivity);
        BtExcluir = (Button) findViewById(R.id.button5);

    }

    public void cadastrarUsuario(View view){

        EdUsuario = (EditText) findViewById(R.id.editText3);
        EdIdade = (EditText) findViewById(R.id.editText4);
        EdSenha = (EditText) findViewById(R.id.editText5);
        BtCadastrar = (Button) findViewById(R.id.btCadastrar);


        Usuario usu = new Usuario();
        usu.setPessoa(EdUsuario.getText().toString());
        usu.setIdade(Integer.parseInt(EdIdade.getText().toString()));
        usu.setSenha(Integer.parseInt(EdSenha.getText().toString()));

        DbHelper dbH = new DbHelper(this);
        dbH.insertUsuario(usu);
        finish();

    }
    public void voltarJanela(View view){
        finish();
    }

    public void mostrarUsuarios (View view){
        Intent intent = new Intent(this, MostraTodosUsuarios.class);
        startActivity(intent);
    }

}
