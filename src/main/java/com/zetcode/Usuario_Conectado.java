package com.zetcode;

import org.json.JSONObject;

public class Usuario_Conectado {
    private static Usuario_Conectado miUser;
    private String nombre;
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

    public void initUser(JSONObject data){
        nombre = data.getString("nombre");
        pass = data.getString("PSWD");
    }
}
