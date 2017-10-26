package com.dev.bollha.tcc_prototipo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.media.Image;

import com.dev.bollha.tcc_prototipo.model.RegistroAcidente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bollha on 25/10/17.
 */

public class RegistroAcidenteDao extends SQLiteOpenHelper {
//    private Long id;
//    private String zonaAcidente;
//    private String tipoAcidente;
//    private String tipoPavimento;
//    private String estadoLocal; //molhado, seco, lama
//    private String tipoPista; //Curva, encruzilhada, morro
//    private int maoPista;//0=Dupla, 1=única
//    private int velocidade; //0=20 1=40 2=60 3=80
//    private double latitude;
//    private double longitude;
//    private Date data;
//    private Image versaoFato;
    public static final String DATABASE_NAME = "registroAcidente.db";
    public static final String TABLE_NAME = "registroAcidentes";
    public static final String COL1 = "ID";
    public static final String COL2 = "zonaAcidente";
    public static final String COL3 = "tipoAcidente";
    public static final String COL4 = "tipoPavimento";
    public static final String COL5 = "estadoLocal";
    public static final String COL6 = "tipoPista";
    public static final String COL7 = "maoPista";
    public static final String COL8 = "velocidade";
    public static final String COL9 = "latitude";
    public static final String COL10 = "longitude";
    public static final String COL11 = "data";
    public static final String COL12 = "versaoFato";//img

    public RegistroAcidenteDao(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        //    private Long id;
        //    private String zonaAcidente;
        //    private String tipoAcidente;
        //    private String tipoPavimento;
        //    private String estadoLocal; //molhado, seco, lama
        //    private String tipoPista; //Curva, encruzilhada, morro
        //    private int maoPista;//0=Dupla, 1=única
        //    private int velocidade; //0=20 1=40 2=60 3=80
        //    private double latitude;
        //    private double longitude;
        //    private Date data;
        //    private Image versaoFato;
        sb.append("CREATE TABLE " + TABLE_NAME + " (");
        sb.append("ID INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append("zonaAcidente TEXT,");
        sb.append("tipoAcidente TEXT,");
        sb.append("tipoPavimento TEXT,");
        sb.append("estadoLocal TEXT,");
        sb.append("tipoPista INT,");
        sb.append("maoPista INT,");//0=Dupla, 1=única
        sb.append("velocidade INT,");//0=20 1=40 2=60 3=80
        sb.append("latitude REAL,");
        sb.append("longitude REAL,");
        sb.append("data TEXT,");
        sb.append("versaoFato BLOOB)");
        sqLiteDatabase.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean Insert(RegistroAcidente obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //    private Long id;
        //    private String zonaAcidente;
        //    private String tipoAcidente;
        //    private String tipoPavimento;
        //    private String estadoLocal; //molhado, seco, lama
        //    private String tipoPista; //Curva, encruzilhada, morro
        //    private int maoPista;//0=Dupla, 1=única
        //    private int velocidade; //0=20 1=40 2=60 3=80
        //    private double latitude;
        //    private double longitude;
        //    private Date data;
        //    private Image versaoFato;

//        contentValues.put(COL2, obj.getZonaAcidente());
//        contentValues.put(COL3, obj.getTipoAcidente());
//        contentValues.put(COL4, obj.getTipoPavimento());
//        contentValues.put(COL5, obj.getEstadoLocal());
//        contentValues.put(COL6, obj.getTipoPista());
//        contentValues.put(COL7, obj.getMaoPista());
//        contentValues.put(COL8, obj.getVelocidade());
//        contentValues.put(COL9, obj.getLatitude());
//        contentValues.put(COL10, obj.getLongitude());
//        contentValues.put(COL11, "now"); //acompanhar isso
//        contentValues.put(COL12, obj.getVersaoFato());//ver com edgar
//
        contentValues.put(COL2, "NULL");
        contentValues.put(COL3, "NULL");
        contentValues.put(COL4, "NULL");
        contentValues.put(COL5, "NULL");
        contentValues.put(COL6, "NULL");
        contentValues.put(COL7, "NULL");
        contentValues.put(COL8, "NULL");
        contentValues.put(COL9, "NULL");
        contentValues.put(COL10, "NULL");
        contentValues.put(COL11, "now"); //acompanhar isso
        contentValues.put(COL12, "NULL");//ver com edgar


        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1) {
            //retorna -1 apenas se der error
            return false;
        } else {
            return true;
        }
    }


    private boolean Update(RegistroAcidente obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(COL2, obj.getZonaAcidente());
        contentValues.put(COL3, obj.getTipoAcidente());
        contentValues.put(COL4, obj.getTipoPavimento());
        contentValues.put(COL5, obj.getEstadoLocal());
        contentValues.put(COL6, obj.getTipoPista());
        contentValues.put(COL7, obj.getMaoPista());
        contentValues.put(COL8, obj.getVelocidade());
        contentValues.put(COL9, obj.getLatitude());
        contentValues.put(COL10, obj.getLongitude());
        contentValues.put(COL11, "now"); //acompanhar isso
        contentValues.put(COL12, obj.getVersaoFato());//ver com edgar
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

    public boolean Salvar(RegistroAcidente obj) {
        if (obj.getId() != null) {
            return Update(obj);
        }
        return Insert(obj);
    }

    public boolean Excluir(RegistroAcidente obj) {
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

    public List<RegistroAcidente> Get(String filter) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        String[] arguments = null;
        if (filter != "") {
            sql += " WHERE " + COL1 + " = ?";
            arguments = new String[]{filter};
        }
        sql += " ORDER BY " + COL1;
        Cursor data = db.rawQuery(sql, arguments);
        List<RegistroAcidente> objs = new ArrayList<>();
        if (data != null && data.getCount() > 0) {
            while (data.moveToNext()) {
                //    private Long id;
                //    private String zonaAcidente;
                //    private String tipoAcidente;
                //    private String tipoPavimento;
                //    private String estadoLocal; //molhado, seco, lama
                //    private String tipoPista; //Curva, encruzilhada, morro
                //    private int maoPista;//0=Dupla, 1=única
                //    private int velocidade; //0=20 1=40 2=60 3=80
                //    private double latitude;
                //    private double longitude;
                //    private Date data;
                //    private Image versaoFato;
                Long id = data.getLong(data.getColumnIndex(COL1));
                String zonaAcidente = data.getString(data.getColumnIndex(COL2));
                String tipoAcidente = data.getString(data.getColumnIndex(COL3));
                String tipoPavimento = data.getString(data.getColumnIndex(COL4));
                String estadoLocal = data.getString(data.getColumnIndex(COL5));
                String tipoPista = data.getString(data.getColumnIndex(COL6));
                int maoPista = data.getInt(data.getColumnIndex(COL7));
                int velocidade = data.getInt(data.getColumnIndex(COL8));
                Double latitude = data.getDouble(data.getColumnIndex(COL9));
                Double longitude = data.getDouble(data.getColumnIndex(COL10));
                String dataRegristro = data.getString(data.getColumnIndex(COL11));//trabalhar esse dado
                RegistroAcidente obj = new RegistroAcidente(id, zonaAcidente, tipoAcidente,
                        tipoPavimento, estadoLocal, tipoPista,
                        maoPista,velocidade,latitude,longitude );
                objs.add(obj);
            }
        }
        db.close();
        return objs;
    }

    public List<RegistroAcidente> All() {
        return Get("");
    }

    public Long GetIdOcorrencia() {
        Long id = null;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery( "SELECT * FROM " + TABLE_NAME + " WHERE ID = (SELECT MAX(ID) FROM "+TABLE_NAME+")",null);
        if (data != null && data.getCount() > 0) {
            while (data.moveToNext()) {
                id = data.getLong(data.getColumnIndex(COL1));

            }
        }
        db.close();
        return id;
    }
}
