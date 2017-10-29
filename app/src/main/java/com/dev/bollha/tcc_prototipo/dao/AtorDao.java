package com.dev.bollha.tcc_prototipo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dev.bollha.tcc_prototipo.model.Ator;
import com.dev.bollha.tcc_prototipo.model.Objeto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bollha on 26/10/17.
 */

public class AtorDao extends SQLiteOpenHelper {
//    private Long id;
//    private int tipoAtor;
//    private int sexo; //0 = Masculino 1 = Mulher
//    private String nacionalidade;
//    private int idade;
//    private String nome;
//    private String documento;
//    private int gravidade;//0 = Normal, 1 = Parcial, 2 = Fatal
//    private Long idRegistro;
    public static final String DATABASE_NAME = "objeto.db";
    public static final String TABLE_NAME = "objetos";
    public static final String COL1 = "ID";
    public static final String COL2 = "tipoAtor";
    public static final String COL3 = "sexo";
    public static final String COL4 = "nacionalidade";//0=VM 1=GM 2=Fiat 3=Ford 4=Renault
    public static final String COL5 = "idade"; //0 = Gasolina, 1 = Etanol 2 = Flex
    public static final String COL6 = "nome";
    public static final String COL7 = "documento";
    public static final String COL8 = "gravidade";
    public static final String COL9 = "idRegistro";

    public AtorDao(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //    private Long id;
//    private int tipoAtor;
//    private int sexo; //0 = Masculino 1 = Mulher
//    private String nacionalidade;
//    private int idade;
//    private String nome;
//    private String documento;
//    private int gravidade;//0 = Normal, 1 = Parcial, 2 = Fatal
//    private Long idRegistro;
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + TABLE_NAME + " (");
        sb.append("ID INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append("tipoAtor INT,");
        sb.append("sexo INT,");
        sb.append("nacionalidade INT,");
        sb.append("idade INT,");
        sb.append("nome TEXT,");
        sb.append("documento TEXT,");
        sb.append("gravidade INT,");
        sb.append("idRegistro INT)");
        sqLiteDatabase.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    private boolean Insert(Ator obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(COL2, obj.getTipoAtor());
        contentValues.put(COL3, obj.getSexo());
        contentValues.put(COL4, obj.getNacionalidade());
        contentValues.put(COL5, obj.getIdade());
        contentValues.put(COL6, obj.getNome());
        contentValues.put(COL7, obj.getDocumento());
        contentValues.put(COL8, obj.getGravidade());
        contentValues.put(COL9, obj.getIdRegistro());

        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1) {
            //retorna -1 apenas se der error
            return false;
        } else {
            return true;
        }
    }

    private boolean Update(Ator obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, obj.getTipoAtor());
        contentValues.put(COL3, obj.getSexo());
        contentValues.put(COL4, obj.getNacionalidade());
        contentValues.put(COL5, obj.getIdade());
        contentValues.put(COL6, obj.getNome());
        contentValues.put(COL7, obj.getDocumento());
        contentValues.put(COL8, obj.getGravidade());
        contentValues.put(COL9, obj.getIdRegistro());

        long linhasAfetadas = db.update(
                TABLE_NAME,
                contentValues,
                COL1 + " = ?",
                new String[]{String.valueOf(obj.getId())});
        db.close();
        if (linhasAfetadas == -1) {
            //retorna -1 apenas se der error
            return false;
        } else {
            return true;
        }

    }

    public boolean Salvar(Ator obj) {
        if (obj.getId() != null) {
            return Update(obj);
        }
        return Insert(obj);
    }

    public boolean Excluir(Ator obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        int linhasAfetadas = db.delete(
                TABLE_NAME,
                COL1 + " = ?",
                new String[]{String.valueOf(obj.getId())});

        db.close();
        if (linhasAfetadas == -1) {
            //retorna -1 apenas se der error
            return false;
        } else {
            return true;
        }
    }

    public List<Ator> Get(String filter) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        String[] arguments = null;
        if (filter != "") {
            sql += " WHERE " + COL9 + " = ?";
            arguments = new String[]{filter};
        }
        sql += " ORDER BY " + COL1;
        Cursor data = db.rawQuery(sql, arguments);
        List<Ator> objs = new ArrayList<>();
        if (data != null && data.getCount() > 0) {
            while (data.moveToNext()) {

                Long id = data.getLong(data.getColumnIndex(COL1));
                int tipoAtor = data.getInt(data.getColumnIndex(COL2));
                int sexo = data.getInt(data.getColumnIndex(COL3));
                int nacionalidade = data.getInt(data.getColumnIndex(COL4));
                int idade = data.getInt(data.getColumnIndex(COL5));
                String nome = data.getString(data.getColumnIndex(COL6));
                String documento = data.getString(data.getColumnIndex(COL7));
                int gravidade = data.getInt(data.getColumnIndex(COL8));
                Long idRegistro = data.getLong(data.getColumnIndex(COL9));

                Ator obj = new Ator(id, tipoAtor, sexo, nacionalidade, idade, nome,
                        documento,gravidade,idRegistro);
                objs.add(obj);
            }
        }
        db.close();
        return objs;
    }

    public List<Ator> All() {
        return Get("");
    }

    public ArrayList<Ator> AllArrayList() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        String[] arguments = null;
        sql += " ORDER BY " + COL1;
        Cursor data = db.rawQuery(sql, arguments);
        ArrayList<Ator> objs = new ArrayList<>();
        if (data != null && data.getCount() > 0) {
            while (data.moveToNext()) {
                Long id = data.getLong(data.getColumnIndex(COL1));
                int tipoAtor = data.getInt(data.getColumnIndex(COL2));
                int sexo = data.getInt(data.getColumnIndex(COL3));
                int nacionalidade = data.getInt(data.getColumnIndex(COL4));
                int idade = data.getInt(data.getColumnIndex(COL5));
                String nome = data.getString(data.getColumnIndex(COL6));
                String documento = data.getString(data.getColumnIndex(COL7));
                int gravidade = data.getInt(data.getColumnIndex(COL8));
                Long idRegistro = data.getLong(data.getColumnIndex(COL9));

                Ator obj = new Ator(id, tipoAtor, sexo, nacionalidade, idade, nome,
                        documento,gravidade,idRegistro);
                objs.add(obj);
            }
        }
        db.close();
        return objs;
    }
}
