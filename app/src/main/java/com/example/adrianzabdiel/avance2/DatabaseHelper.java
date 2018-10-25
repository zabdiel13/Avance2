package com.example.adrianzabdiel.avance2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String dbname="curp db";
    private static  int DB_SCHEME_VERSION=1;

    public DatabaseHelper(Context context) {
        super(context, dbname, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DataBaseManagerUsuario.Crear_Tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS"+dbname);

        onCreate(db);

    }
}

