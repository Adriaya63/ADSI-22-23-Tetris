package com.zetcode.Gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

import com.zetcode.Extensiones.Usuario_Conectado;




public class Gestor_Usuarios{
    private static Gestor_Usuarios miGestorUser;
    private Gestor_Usuarios(){}

    public static Gestor_Usuarios getMiGestorUser(){
        if(miGestorUser==null){
            miGestorUser = new Gestor_Usuarios();
        }
        return miGestorUser;
    }

    public boolean existeUser(String user) {
        if(user!=null){
            String consulta = String.format("SELECT FROM usuario WHERE user='%s'",user);
            ResultSet rs = BD.selectSql(consulta);
            try{
            if(rs.next()){
                return true;
            }
             
            }catch (Exception e) {
                System.out.println("Error en la conexión");
            }
        }
        return false;
    }

    public JSONObject buscarUser(String user, String pass){
        String consulta= String.format("SELECT * FROM usuario WHERE Nombre='%s' AND pswd='%s'", user,pass);
        JSONObject userData=new JSONObject();
        try {
                
                ResultSet rs = BD.selectSql(consulta);
                if(rs.next()){
                    int col = rs.getMetaData().getColumnCount();
                    for(int i=0;i<col;i++){
                        userData.put(rs.getMetaData().getColumnLabel(i+1),rs.getObject(i+1));
                    }
                }else{
                    System.out.println("El usuario y la contraseña no son correctos");
                }       
            } catch (SQLException sqle) {
                System.out.println("Error en la ejecución:" 
                + sqle.getErrorCode() + " " + sqle.getMessage());             }
        return userData;
    }

    public void insertarUsuario(String user, String password, String email){
        if(user!=null && password!=null && email!=null){
            String consulta = String.format("INSERT INTO usuario VALUES('%s', '%s', '%s',0,1,1)",user,email,password);
            
            BD.sqlvoid(consulta);
            System.out.println("registered");
        }
    }
    public void eliminarUsuario(String user){
        if(user!="admin" && user!=Usuario_Conectado.geyMiUser().getNombre()){
            String consulta= String.format("delete from usuario where nombre ='%s'", user);
            BD.sqlvoid(consulta);
            System.out.println("Jugador eliminado");
        }
        else{
            System.out.println("Este jugador no se puede eliminar"); 
        }
    }
  
    
    
}