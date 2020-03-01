package com.sevillaInc.sweattime.model;

public class Personas {

    public String uid;
    public String nombre;
    public String usuario;
    public String pass;
    public String cumple;
    public String estatura;
    public String peso;

    public String getUid() {
        return uid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }

    public String getCumple() {
        return cumple;
    }

    public String getEstatura() {
        return estatura;
    }

    public String getPeso() {
        return peso;
    }

    public Personas(){

    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}
