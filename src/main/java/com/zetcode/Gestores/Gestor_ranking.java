package com.zetcode.Gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String consulta="";
        Connection con = null;
        String sURL = "jdbc:h2:./test";
        JSONArray jsonArray = new JSONArray(); 
        if(dificultad=="Absoluto" && usuario!="Global"){
          consulta= "SELECT nombre, puntuacion from info_ranking where nombre ='"+ usuario +"' ORDER BY puntuacion DESC";
        }
        if(dificultad!="Absoluto" && usuario!="Global"){
          consulta= "SELECT nombre, puntuacion from info_ranking where dificultad = '"+ dificultad +"'AND nombre = '"+ usuario +"'ORDER BY puntuacion DESC";
        }
        if(dificultad!="Absoluto" && usuario=="Global"){
          consulta= "SELECT nombre, puntuacion from info_ranking where dificultad ='"+ dificultad +"'ORDER BY puntuacion DESC";
        }
        if(dificultad=="Absoluto" && usuario=="Global"){
          consulta= "SELECT nombre, puntuacion from info_ranking ORDER BY puntuacion DESC";
        }
        try {
          con = DriverManager.getConnection(sURL,"sa","1234");
            System.out.println(consulta);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            
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
        finally {
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
    


    public void ingresarPuntuacion(String usuario, int numLinesRemoved, String dificultad){
      Connection con = null;
      String sURL = "jdbc:h2:./test";
      try {
        con = DriverManager.getConnection(sURL,"sa","1234");
        try (
          PreparedStatement query = con.prepareStatement("INSERT INTO info_ranking VALUES(?,?,?)")) {
              query.setString(1, usuario);  
              query.setInt(2, numLinesRemoved); 
              query.setString(3, dificultad);
              
          // Ejecutamos Query
          query.execute();
          System.out.println("Se ha ingresado correctamente la puntuación en el ranking");
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



