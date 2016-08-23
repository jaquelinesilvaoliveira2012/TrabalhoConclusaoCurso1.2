package com.example.computador.crud;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Edlogin;
    EditText EdSenha;
    Button BtEntrar;
    private DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edlogin = (EditText) findViewById(R.id.editText);
        EdSenha = (EditText) findViewById(R.id.editText2);
        BtEntrar = (Button) findViewById(R.id.button);
        db = new DbHelper(this);
        }
    public void novaJanela(View view) {

        Intent intent = new Intent(this,TelaCadastro.class );
        startActivity(intent);
    }


    public void logar(View view){

        String nome = Edlogin.getText().toString();
        String senha = EdSenha.getText().toString();

       boolean validacao = true;

       if(nome == null || nome.equals("")){
            validacao = false;
            Edlogin.setError(getString(R.string.login_valUsuario));
        }

        if(senha == null || senha.equals("")){
            validacao = false;
            EdSenha.setError(getString(R.string.login_valSenha));
        }

       if(validacao){
           if(db.logar(nome,senha)==true){
            Intent intent = new Intent(this, teste.class);
           startActivity(intent);
       }
       }

        else {
           Toast.makeText(getApplicationContext(),"Usuario não cadastrado", Toast.LENGTH_SHORT).show();
       }

//
    }
}
