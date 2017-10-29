package com.dev.bollha.tcc_prototipo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dev.bollha.tcc_prototipo.model.Objeto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bollha on 26/10/17.
 */

public class ObjetoDao extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "objeto.db";
    public static final String TABLE_NAME = "objetos";
    public static final String COL1 = "ID";
    public static final String COL2 = "renavam";
    public static final String COL3 = "tipoVeiculo";
    public static final String COL4 = "segurado";//0=VM 1=GM 2=Fiat 3=Ford 4=Renault
    public static final String COL5 = "caracterizado"; //0 = Gasolina, 1 = Etanol 2 = Flex
    public static final String COL6 = "alugado";
    public static final String COL7 = "idCondutor";
    public static final String COL8 = "idRegistro";

    public ObjetoDao(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + TABLE_NAME + " (");
        sb.append("ID INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append("renavam TEXT,");
        sb.append("tipoVeiculo TEXT,");
        sb.append("segurado INT,");
        sb.append("caracterizado INT,");
        sb.append("alugado INT,");
        sb.append("idCondutor INT,");
        sb.append("idRegistro INT)");
        sqLiteDatabase.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    private boolean Insert(Objeto obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(COL2, obj.getRenavam());
        contentValues.put(COL3, obj.getTipoVeiculo());
        contentValues.put(COL4, obj.getSegurado());
        contentValues.put(COL5, obj.getCaracterizado());
        contentValues.put(COL6, obj.getAlugado());
        contentValues.put(COL7, obj.getIdCondutor());
        contentValues.put(COL8, obj.getIdRegistro());

        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1) {
            //retorna -1 apenas se der error
            return false;
        } else {
            return true;
        }
    }

    private boolean Update(Objeto obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, obj.getRenavam());
        contentValues.put(COL3, obj.getTipoVeiculo());
        contentValues.put(COL4, obj.getSegurado());
        contentValues.put(COL5, obj.getCaracterizado());
        contentValues.put(COL6, obj.getAlugado());
        contentValues.put(COL7, obj.getIdCondutor());
        contentValues.put(COL8, obj.getIdRegistro());

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

    public boolean Salvar(Objeto obj) {
        if (obj.getId() != null) {
            return Update(obj);
        }
        return Insert(obj);
    }

    public boolean Excluir(Objeto obj) {
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

    public List<Objeto> Get(String filter) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        String[] arguments = null;
        if (filter != "") {
            sql += " WHERE " + COL1 + " = ?";
            arguments = new String[]{filter};
        }
        sql += " ORDER BY " + COL1;
        Cursor data = db.rawQuery(sql, arguments);
        List<Objeto> objs = new ArrayList<>();
        if (data != null && data.getCount() > 0) {
            while (data.moveToNext()) {
                Long id = data.getLong(data.getColumnIndex(COL1));
                String renavam = data.getString(data.getColumnIndex(COL2));
                String tipoVeiculo = data.getString(data.getColumnIndex(COL3));
                int segurado = data.getInt(data.getColumnIndex(COL4));
                int caracterizado = data.getInt(data.getColumnIndex(COL5));
                int alugado = data.getInt(data.getColumnIndex(COL6));
                Long idCondutor = data.getLong(data.getColumnIndex(COL7));
                Long idRegistro = data.getLong(data.getColumnIndex(COL8));

                Objeto obj = new Objeto(id, renavam, tipoVeiculo, segurado, caracterizado, alugado,
                        idCondutor,idRegistro);
                objs.add(obj);
            }
        }
        db.close();
        return objs;
    }

    public List<Objeto> All() {
        return Get("");
    }

    public ArrayList<Objeto> AllArrayList() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        String[] arguments = null;
        sql += " ORDER BY " + COL1;
        Cursor data = db.rawQuery(sql, arguments);
        ArrayList<Objeto> objs = new ArrayList<>();
        if (data != null && data.getCount() > 0) {
            while (data.moveToNext()) {
                Long id = data.getLong(data.getColumnIndex(COL1));
                String renavam = data.getString(data.getColumnIndex(COL2));
                String tipoVeiculo = data.getString(data.getColumnIndex(COL3));
                int segurado = data.getInt(data.getColumnIndex(COL4));
                int caracterizado = data.getInt(data.getColumnIndex(COL5));
                int alugado = data.getInt(data.getColumnIndex(COL6));
                Long idCondutor = data.getLong(data.getColumnIndex(COL7));
                Long idRegistro = data.getLong(data.getColumnIndex(COL8));

                Objeto obj = new Objeto(id, renavam, tipoVeiculo, segurado, caracterizado, alugado,
                        idCondutor,idRegistro);
                objs.add(obj);
            }
        }
        db.close();
        return objs;
    }
}
