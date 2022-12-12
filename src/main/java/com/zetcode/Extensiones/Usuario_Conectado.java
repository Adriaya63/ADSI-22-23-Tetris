package com.zetcode.Extensiones;

import org.json.JSONObject;
import java.awt.Color;

import com.zetcode.Gestores.Gestor_Personalizacion;

public class Usuario_Conectado {
    private static Usuario_Conectado miUser;
    private String nombre;
    private int admin;
    private String pass;
    private String pFondo;
    private Color pLadrillos[];

    private Usuario_Conectado(){}

    public static Usuario_Conectado geyMiUser(){
        if(miUser==null){
            miUser = new Usuario_Conectado();
        }
        return miUser;
    }

    public boolean initUser(JSONObject data){
        if(data.length()>0){
        nombre = data.getString("NOMBRE");
        pass = data.getString("PSWD");
        admin =data.getInt("ADMIN");
        pFondo = Gestor_Personalizacion.getGestorPer().getNombreFondo(data.getInt("FONDO"));
        pLadrillos = Gestor_Personalizacion.getGestorPer().getColoresLad(data.getInt("LADRILLO"));
        return true;
        }
        return false;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getAdmin(){
        return this.admin;
    }
    public String getpFondo() {
        return pFondo;
    }
    public Color[] getpLadrillos() {
        return pLadrillos;
    }
    public void cambiarFondo(int n){
        pFondo = Gestor_Personalizacion.getGestorPer().cambiarFondo(n, nombre);
    }
    public void cambiarColores(int n) {
        pLadrillos = Gestor_Personalizacion.getGestorPer().cambiarColores(n, nombre);
    }
}