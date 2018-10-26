package com.example.adrianzabdiel.avance2;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

    public String nombres;
    public String apellidos;
    public String nacimiento;
    public String mes;
    public String year;
    public String sexo;
    public String state;

    public Usuario(String nombres, String apellidos, String nacimiento, String mes, String year, String sexo, String state) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.mes = mes;
        this.year = year;
        this.sexo = sexo;
        this.state = state;
    }

    public String getNombres() {return nombres; }
    public String getApellidos() {return apellidos; }
    public String getNacimiento() {return nacimiento; }
    public String getMes() {return mes; }
    public String getYear() {return year; }
    public String getSexo() {return sexo; }
    public String getState() {return state; }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Usuario(){
        this.nombres = "";
        this.apellidos = "";
        this.nacimiento = "";
        this.mes = "";
        this.year = "";
        this.sexo = "";
        this.state = "";
    }

    protected Usuario(Parcel in) {
        nombres = in.readString();
        apellidos = in.readString();
        nacimiento = in.readString();
        mes = in.readString();
        year = in.readString();
        sexo = in.readString();
        state = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombres);
        dest.writeString(apellidos);
        dest.writeString(nacimiento);
        dest.writeString(mes);
        dest.writeString(year);
        dest.writeString(sexo);
        dest.writeString(state);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {

        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getUsuario(){
        String curp= "";
        curp += (this.apellidos.toUpperCase().toCharArray())[0];
        curp += (this.apellidos.toUpperCase().toCharArray())[1];
        curp += (this.nombres.toUpperCase().toCharArray())[0];
        curp += (this.year.toUpperCase().toCharArray())[2];
        curp += (this.year.toUpperCase().toCharArray())[3];
        curp += (this.mes.toUpperCase().toCharArray())[0];
        curp += (this.mes.toUpperCase().toCharArray())[1];
        curp += (this.nacimiento.toUpperCase().toCharArray())[0];
        curp += (this.nacimiento.toUpperCase().toCharArray())[1];
        return curp;
    }

}
