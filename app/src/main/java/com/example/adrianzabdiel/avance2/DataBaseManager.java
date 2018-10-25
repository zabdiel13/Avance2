package com.example.adrianzabdiel.avance2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class DataBaseManager {
    private DatabaseHelper helper;
    private SQLiteDatabase db;


    public DataBaseManager(Context ctx) {
        helper= new DatabaseHelper(ctx);
        db=helper.getWritableDatabase();
    }


    public void cerrar(){
        db.close();
    }

    abstract void insertar(String nombres, String apellidos, String nacimiento, String mes, String year, String sexo, String state,String curp);
    abstract void actualizar(String nombres, String apellidos, String nacimiento, String mes, String year, String sexo, String state, String curp);


    abstract public void eliminar(String curp);
    abstract public void eliminarTodo();
    abstract public Usuario CargarUsuario();
    abstract Boolean compruebaRegistro(String curp);


    public DatabaseHelper getHelper() {
        return helper;
    }

    public void setHelper(DatabaseHelper helper) {
        this.helper = helper;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }
}
