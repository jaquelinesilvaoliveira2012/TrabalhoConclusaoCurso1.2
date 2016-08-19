package com.example.computador.crud;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by COMPUTADOR on 8/18/2016.
 */
public class MostraTodosUsuarios extends Activity {

    private ListView ListMostraUsuarios;
    Button BtMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_mostra_usuarios);

        Button BtMostrar = (Button) findViewById(R.id.button3);
        ListMostraUsuarios = (ListView)  findViewById(R.id.listView);

    }

    protected void onResume(){
        super.onResume();

        DbHelper DbH = new DbHelper(this);

        List<Usuario> ListaUsuario =  DbH.selectTodosUsuarios();

        ArrayAdapter<Usuario> adp = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, ListaUsuario);

        ListMostraUsuarios.setAdapter(adp);



    }

    public void voltar(View view){
        finish();
    }

}
