package com.example.adrianzabdiel.avance2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManagerUsuario extends DataBaseManager {

    private static final String nombre_tabla="Curps";
    private static final String Curp="curp";
    private static final String Nombre="nombres";
    private static final String Apellidos="apellidos";
    private static final String Nacimiento="dia";
    private static final String Mes="mes";
    private static final String Year="año";
    private static final String Sexo="sexo";
    private static final String State="estado";
    public static final String Crear_Tabla = "create table " + nombre_tabla + " ("
            + Curp + " text NULL," + Nombre + " text NOT NULL," +
             Apellidos + " text NOT NULL," +
            Nacimiento + " text NOT NULL,"+ Mes + " text NOT NULL," +
            Year + " text NOT NULL,"+  State + "text NOT NULL," +
            Sexo + " text NOT NULL" +");";

    public DataBaseManagerUsuario(Context contexto) {
        super(contexto);
    }


    @Override
    public void cerrar() {
        super.getDb().close();
    }

    @Override
    void insertar(String nombres, String apellidos, String nacimiento, String mes, String year, String sexo, String state, String curp) {

    }

    @Override
    void actualizar(String nombres, String apellidos, String nacimiento, String mes, String year, String sexo, String state, String curp) {

    }


    private ContentValues generarContentValues(String curp, String nombres, String apellidos, String nacimiento, String mes, String year, String sexo, String state) {
        ContentValues valores = new ContentValues();
        valores.put(Curp, curp);
        valores.put(Nombre, nombres);
        valores.put(Apellidos, apellidos);
        valores.put(Nacimiento, nacimiento);
        valores.put(Mes, mes);
        valores.put(Year, year);
        valores.put(Sexo, sexo);
        valores.put(State, state);

        return valores;
    }


    public void insertar_parametros(String curp, String nombres, String apellidos, String nacimiento, String mes, String year, String sexo, String state) {
        Log.d("insertar", super.getDb().insert(nombre_tabla, null, generarContentValues(curp, nombres, apellidos, nacimiento, mes, year, sexo, state)) + "");

    }

    public void actualizar_parametros(String curp, String nombres, String apellidos, String nacimiento, String mes, String year, String sexo, String state) {


        ContentValues valores = new ContentValues();
        valores.put(Curp, curp);
        valores.put(Nombre, nombres);
        valores.put(Apellidos, apellidos);
        valores.put(Nacimiento, nacimiento);
        valores.put(Mes, mes);
        valores.put(Year, year);
        valores.put(Sexo, sexo);
        valores.put(State, state);

        String [] args= new String[]{curp};
        Log.d("cursos_actualizar", super.getDb().update(nombre_tabla, valores, " curp=?", args)+"");
    }

    @Override
    public void eliminar(String curp_id) {

        super.getDb().delete(nombre_tabla, Curp + "=?", new String[]{curp_id});
    }

    @Override
    public void eliminarTodo() {

        super.getDb().execSQL("DELETE FROM "+ nombre_tabla+";");
        Log.d("Usuario_eliminar", "Datos borrados");

    }

    @Override
    public Cursor CargarUsuario() {
        String [] columnas= new String[]{"*"};


        return super.getDb().query(nombre_tabla,columnas,null,null,null,null,null );
    }

    public Cursor cargarCursor() {
        String [] columnas= new String[]{Curp, Nombre, Apellidos, Nacimiento, Mes, Year, Sexo, State};


        return super.getDb().query(nombre_tabla,columnas,null,null,null,null,null );
    }

    @Override
    Boolean compruebaRegistro(String curp_id) {

        boolean c=true;

        Cursor resultSet= super.getDb().rawQuery("Select * from " + nombre_tabla + " WHERE " + Curp + "=" + curp_id, null);

        if(resultSet.getCount()<=0)
            c=false;
        else
            c=true;
        return c;

    }

    public List<Usuario> getUsuarioList(){
        List<Usuario> list= new ArrayList();
        Cursor u= CargarUsuario();
        while (u.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setNombres(u.getString(1));
            usuario.setApellidos(u.getString(2));
            usuario.setNacimiento(u.getString(3));
            usuario.setMes(u.getString(4));
            usuario.setYear(u.getString(5));
            usuario.setSexo(u.getString(6));
            usuario.setState(u.getString(7));
            list.add(usuario);
        }
        return list;

    }

}

