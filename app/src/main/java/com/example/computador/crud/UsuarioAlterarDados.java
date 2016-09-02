package com.example.computador.crud;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;

public class UsuarioAlterarDados extends AppCompatActivity {
    private static final String PREF_NAME = "LoginActivityPreference";
    EditText edEmail;
    EditText edNome;
    EditText edSobrenome;
    EditText edIdade;
    EditText edSenha;
    Button btAlterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_usuario_alterar_dados);

    }

    public void alterarUsuario(View view){
        edEmail =  (EditText) findViewById(R.id.editText7);
        edNome = (EditText)findViewById(R.id.editText8);
        edSobrenome = (EditText) findViewById(R.id.editText6);
        edIdade = (EditText) findViewById(R.id.editText12);
        edSenha = (EditText) findViewById(R.id.editText13);
        btAlterar = (Button) findViewById(R.id.btAlterar);
        int position = 0;
        Usuario usuario = new Usuario();
        usuario.setEmail(edEmail.getText().toString());
        usuario.setNome(edNome.getText().toString());
        usuario.setSobrenome(edSobrenome.getText().toString());
        usuario.setIdade(Integer.parseInt(edIdade.getText().toString()));
        usuario.setSenha(edSenha.getText().toString());


        DbHelper db = new DbHelper(this);

        db.atualizarUsuario(usuario, position);


        Intent intent = new Intent(this, MostraTodosUsuarios.class);
        startActivity(intent);

    }


}
