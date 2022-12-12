package com.zetcode.Extensiones;

import org.json.JSONObject;

public class Usuario_Conectado {
    private static Usuario_Conectado miUser;
    private String nombre;
    private int admin;
    private String pass;
    private String pFondo;
    private String pLadrillos;

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
}