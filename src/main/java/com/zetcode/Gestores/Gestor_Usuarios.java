package com.zetcode.Gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;



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
            String sURL = "jdbc:h2:./test";
            try {
                con = DriverManager.getConnection(sURL, "sa", "1234");
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

    public JSONObject buscarUser(String user, String pass){
        Connection con = null;
        String sURL = "jdbc:h2:./test";
        JSONObject userData = new JSONObject(); 
        try {
            con = DriverManager.getConnection(sURL, "sa", "1234");
            try (PreparedStatement query = con.prepareStatement("SELECT * FROM usuario WHERE Nombre=? AND pswd=?")){
                query.setString(1, user);
                query.setString(2, pass);
                ResultSet rs = query.executeQuery();
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
        } catch (Exception e) {
            System.out.println("Error en la conexión:" + e.toString() );
        }finally{
            try {
                if (con!=null){con.close();}
            } catch (Exception e) {
                System.out.println("Error cerrando conexiones: "
                + e.toString());
            }
        }
        return userData;
    }

    public void insertarUsuario(String user, String password, String email){
        if(user!=null && password!=null && email!=null){
            Connection con = null;
            String sURL = "jdbc:h2:./test";
            try{
                con = DriverManager.getConnection(sURL, "sa", "1234");
                try(PreparedStatement query = con.prepareStatement("INSERT INTO usuario VALUES(?,?,?)")){
                    query.setString(1, user);
                    query.setString(2, email);
                    query.setString(3, password);
                    query.execute();
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
    public void eliminarUsuario(String user){
        if(user!=null){
            Connection con = null;
            String sURL = "jdbc:h2:./test";
            try{
                con = DriverManager.getConnection(sURL, "sa", "1234");
                try(PreparedStatement query = con.prepareStatement("Delete ")){
                    query.setString(1, user);
                    query.execute();
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
