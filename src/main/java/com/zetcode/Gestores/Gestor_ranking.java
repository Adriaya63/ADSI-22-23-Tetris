package com.zetcode.Gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Gestor_ranking {
    private static Gestor_ranking miGestorRanking;
    private Gestor_ranking(){

    }
    public static Gestor_ranking getmiGestorRanking(){
        if(miGestorRanking ==null){
            miGestorRanking =new Gestor_ranking();
        }
        return miGestorRanking;
    }
    
    public JSONArray generarRanking(String dificultad, String usuario){

        Connection con = null;
        String sURL = "jdbc:mariadb://localhost:3306/ADSI";
        JSONArray jsonArray = new JSONArray(); 
        if(usuario!="Global"){
        try {
          con = DriverManager.getConnection(sURL,"root","");
          try (
            PreparedStatement query = con.prepareStatement("SELECT user, puntuacion from info_ranking where dificultad = ? AND user = ? AND ORDER BY puntuacion DESC")) {
                query.setString(1, dificultad);   
                query.setString(2, usuario);
            // Ejecutamos Query
            ResultSet rs = query.executeQuery();
            
            // Recorremos el resultado
            while (rs.next()){
                int columns = rs.getMetaData().getColumnCount();
                JSONObject obj = new JSONObject();
         
                for (int i = 0; i < columns; i++)
                    obj.put(rs.getMetaData().getColumnLabel(i + 1).toLowerCase(), rs.getObject(i + 1));
         
                jsonArray.put(obj);
            }
              
            }catch (SQLException sqle) { 
              System.out.println("Error en la ejecución:" 
            + sqle.getErrorCode() + " " + sqle.getMessage());    
            }
        } catch (Exception e) { 
          System.out.println("Error en la conexión:" + e.toString() );
        } finally {
          try {
            // Cerramos posibles conexiones abiertas
            if (con!=null) con.close();    
          } catch (Exception e) {
            System.out.println("Error cerrando conexiones: "
              + e.toString());
          } 
        }
        return jsonArray;
    }
    else{
      try {
        con = DriverManager.getConnection(sURL,"root","");
        try (
          PreparedStatement query = con.prepareStatement("SELECT user, puntuacion from info_ranking where dificultad = ? ORDER BY puntuacion DESC")) {
              query.setString(1, dificultad);    
          // Ejecutamos Query
          ResultSet rs = query.executeQuery();
          
          // Recorremos el resultado
          while (rs.next()){
              int columns = rs.getMetaData().getColumnCount();
              JSONObject obj = new JSONObject();
       
              for (int i = 0; i < columns; i++)
                  obj.put(rs.getMetaData().getColumnLabel(i + 1).toLowerCase(), rs.getObject(i + 1));
       
              jsonArray.put(obj);
          }
            
          }catch (SQLException sqle) { 
            System.out.println("Error en la ejecución:" 
          + sqle.getErrorCode() + " " + sqle.getMessage());    
          }
      } catch (Exception e) { 
        System.out.println("Error en la conexión:" + e.toString() );
      } finally {
        try {
          // Cerramos posibles conexiones abiertas
          if (con!=null) con.close();    
        } catch (Exception e) {
          System.out.println("Error cerrando conexiones: "
            + e.toString());
        } 
      }
      return jsonArray;
  }
    }


    public void ingresarPuntuacion(String usuario, int numLinesRemoved, String dificultad){
      Connection con = null;
      String sURL = "jdbc:mariadb://localhost:3306/ADSI";
      try {
        con = DriverManager.getConnection(sURL,"root","");
        try (
          PreparedStatement query = con.prepareStatement("INSERT INTO info_ranking VALUES(?,?,?)")) {
              query.setString(1, usuario);   
              query.setString(2, dificultad);
              query.setInt(3, numLinesRemoved);
          // Ejecutamos Query
          query.executeQuery();
          }catch (SQLException sqle) { 
            System.out.println("Error en la ejecución:" 
          + sqle.getErrorCode() + " " + sqle.getMessage());    
          }
      } catch (Exception e) { 
        System.out.println("Error en la conexión:" + e.toString() );
      } finally {
        try {
          // Cerramos posibles conexiones abiertas
          if (con!=null) con.close();    
        } catch (Exception e) {
          System.out.println("Error cerrando conexiones: "
            + e.toString());
        } 
      }
      
  
    }
  }



