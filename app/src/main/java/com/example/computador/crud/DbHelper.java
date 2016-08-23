package com.example.computador.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by COMPUTADOR on 8/18/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String NOME_BASE = "CadastroUsuario";
    private static final int VERSAO_BASE = 3;
    private SQLiteDatabase db;

    public DbHelper(Context context) {
        super(context, NOME_BASE, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //inserindo no banco
        String sqlCreateTabelaUsuario = "CREATE TABLE Usuario("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome TEXT,"
                + "idade INTEGER,"
                + "senha INTEGER"
                + ")";

        db.execSQL(sqlCreateTabelaUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //excluindo tabelas
        String sqlDropTableUsuario = "DROP TABLE Usuario";
        db.execSQL(sqlDropTableUsuario);


        //criando novamente
        onCreate(db);

    }

    public void insertUsuario(Usuario usu) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();


        cv.put("nome", usu.getPessoa());
        cv.put("idade", usu.getIdade());
        cv.put("senha", usu.getSenha());

        db.insert("Usuario", null, cv);
        db.close();
    }

    public void atualizarUsuario(Usuario usu) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("nome", usu.getPessoa());
        cv.put("idade", usu.getIdade());

        db.update("Usuario", cv, "_id = ?", new String[]{"" + usu.getId()});
        db.close();
    }

    public void deletarUsuario(Usuario usu) {

        db.delete("Usuario", " id = " + usu.getId(), null);

    }

    public List<Usuario> selectTodosUsuarios() {

        List<Usuario> ListUsuarios = new ArrayList<Usuario>();

        SQLiteDatabase db = getReadableDatabase();
        String sqlSelectTodosUsuarios = "SELECT * FROM Usuario";

        Cursor c = db.rawQuery(sqlSelectTodosUsuarios, null);

        if (c.moveToFirst()) {
            do {
                Usuario usu = new Usuario();
                usu.setId(c.getInt(0));
                usu.setPessoa(c.getString(1));
                usu.setIdade(c.getInt(2));
                usu.setSenha(c.getInt(3));
                ListUsuarios.add(usu);
            } while (c.moveToNext());
        }
        db.close();
        return ListUsuarios;
    }

    public boolean logar (String nome, String senha) {

        SQLiteDatabase db = getReadableDatabase();
        String[] campos =  {nome, senha};
        Cursor cursor = db.query("Usuario", null, "nome= ? and senha= ?", campos, null, null, null,null);
        if(cursor.moveToFirst()){
            return true;
        }
            return false;


    }
}
