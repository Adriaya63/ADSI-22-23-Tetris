package com.zetcode.Gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Gestor_Usuarios{
    private static Gestor_Usuarios miGestorUser;
    private Gestor_Usuarios(){}

    public static Gestor_Usuarios getMiGestorUser(){
        if(miGestorUser==null){
            miGestorUser = new Gestor_Usuarios();
        }
        return miGestorUser;
    }

    public boolean existeUser(String user){
        boolean enc = false;
        if(user!=null){
            Connection con = null;
            String sURL = "jdbc:mariadb://localhost:3306/ADSI";
            try {
                con = DriverManager.getConnection(sURL, "root", "");
                try (PreparedStatement query = con.prepareStatement("SELECT FROM usuario WHERE user=?")){
                    query.setString(1, user);
                    ResultSet rs = query.executeQuery();
                    enc = rs.next();
                }catch (SQLException sqle) { 
                    System.out.println("Error en la ejecución:" 
                  + sqle.getErrorCode() + " " + sqle.getMessage());    
                }   
            } catch (Exception e) {
               System.out.println("Error en la conexión:" + e.toString() ); 
            }finally{
                try {
                    // Cerramos posibles conexiones abiertas
                    if (con!=null) con.close();    
                  } catch (Exception e) {
                    System.out.println("Error cerrando conexiones: "
                      + e.toString());
                  }  
            }
        }
        return enc;
    }

    public void insertarUsuario(String user, String password, String email){
        if(user!=null && password!=null && email!=null){
            Connection con = null;
            String sURL = "jdbc:mariadb://localhost:3306/ADSI";
            try{
                con = DriverManager.getConnection(sURL, "root", "");
                try(PreparedStatement query = con.prepareStatement("INSERT INTO usuario VALUES(?,?,?)")){
                    query.setString(1, user);
                    query.setString(2, email);
                    query.setString(3, password);

                    query.executeQuery();
                    System.out.println("Usuario registrado;");
                }catch(SQLException sqle){
                    System.out.println("Error en la ejecución:" 
                + sqle.getErrorCode() + " " + sqle.getMessage());
                }
            }catch(Exception e){
                System.out.println("Error en la conexion: "+e.toString());
            }finally{
                try {
                    if(con!=null){con.close();}
                } catch (Exception e) {
                    System.out.println("Error cerrando la conexion: "+e.toString());
                }
            }
        }else{
            System.out.println("Credenciales ingresadas de forma erronea.");
        }
    }
}