package com.example.computador.crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;

public class UsuarioAlterarDados extends AppCompatActivity {


    EditText edNome;
    EditText edIdade;
    EditText edSenha;
    Button btAlterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_usuario_alterar_dados);

    }

    public void alterarUsuario(View view){
        edNome = (EditText)findViewById(R.id.editText7);
        edIdade = (EditText) findViewById(R.id.editText8);
        edSenha = (EditText) findViewById(R.id.editText6);
        btAlterar = (Button) findViewById(R.id.btAlterar);

        Usuario usuario = new Usuario();

        usuario.setPessoa(edNome.getText().toString());
        usuario.setIdade(Integer.parseInt(edIdade.getText().toString()));
        usuario.setSenha(Integer.parseInt(edSenha.getText().toString()));

        DbHelper db = new DbHelper(this);
        db.atualizarUsuario(usuario);
        Intent intent = new Intent(this, MostraTodosUsuarios.class);
        startActivity(intent);

    }


}
