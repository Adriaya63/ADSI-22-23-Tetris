package com.zetcode.Gestores;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.Query;

public class Gestor_Personalizacion {
    private static Gestor_Personalizacion miPer;

    private Color colorsDefault[] = { new Color(0, 0, 0), new Color(204, 102, 102),
        new Color(102, 204, 102), new Color(102, 102, 204),
        new Color(204, 204, 102), new Color(204, 102, 204),
        new Color(102, 204, 204), new Color(218, 170, 0)
    };
    private Color colorsClasic[] = { new Color(0, 0, 0), new Color(255, 0, 0),
        new Color(0, 0, 255), new Color(255, 255, 255),
        new Color(255, 255, 255), new Color(255, 255, 255),
        new Color(255, 0, 0), new Color(0, 0, 255)
    };
    private Color colorsBlack[] = { new Color(0, 0, 0), new Color(10, 10, 10),
        new Color(10, 10, 10), new Color(10, 10, 10),
        new Color(10, 10, 10), new Color(10, 10, 10),
        new Color(10, 10, 10), new Color(10, 10, 10)
    }; 

    public static Gestor_Personalizacion getGestorPer() {
        if(miPer==null){
            miPer = new Gestor_Personalizacion();
        }
        return miPer;
    }

    public String cambiarFondo(int n, String user){
        String rdo = "";
        if(n==1){rdo="img/Fondo1.jpg";}
        else if(n==2){rdo="img/Fondo2.jpg";}
        else if(n==3){rdo="img/Fondo3.jpg";}
        Connection con = null;
        String sURL = "jdbc:h2:./test";
        try {
            con = DriverManager.getConnection(sURL, "sa", "1234");
            try (PreparedStatement query = con.prepareStatement("UPDATE USUARIO SET FONDO=? WHERE NOMBRE=?")){
                query.setInt(1, n);
                query.setString(2, user);
                query.executeUpdate();
            } catch (SQLException sqle) {
                System.out.println("Error en la ejecución:" 
                + sqle.getErrorCode() + " " + sqle.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en la conexion: "+e.toString());
        }finally{
            try {
                if(con!=null){con.close();}
            } catch (Exception e) {
                System.out.println("Error cerrando la conexion: "+e.toString());
            }
        }
        return rdo;
    }

    public Color[] cambiarColores(int n, String user){
        Color rdo[] = null;
        if(n==1){rdo=colorsDefault;}
        else if(n==2){rdo=colorsClasic;}
        else if(n==3){rdo=colorsBlack;}
        Connection con = null;
        String sURL = "jdbc:h2:./test";
        try {
            con = DriverManager.getConnection(sURL, "sa", "1234");
            try (PreparedStatement query = con.prepareStatement("UPDATE USUARIO SET LADRILLO=? WHERE NOMBRE=?")){
                query.setInt(1, n);
                query.setString(2, user);
                query.executeUpdate();
            } catch (SQLException sqle) {
                System.out.println("Error en la ejecución:" 
                + sqle.getErrorCode() + " " + sqle.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en la conexion: "+e.toString());
        }finally{
            try {
                if(con!=null){con.close();}
            } catch (Exception e) {
                System.out.println("Error cerrando la conexion: "+e.toString());
            }
        }
        return rdo;
    }

    public String getNombreFondo(int n){
        String img = "";
        if(n==1){img = "img/Fondo1.jpg";}
        else if(n==2){img = "img/Fondo2.jpg";}
        else if(n==3){img = "img/Fondo3.jpg";}
        return img;
    }

    public Color[] getColoresLad(int n){
        Color colorLads[] = null;
        if(n==1){colorLads = colorsDefault;}
        else if(n==2){colorLads = colorsClasic;}
        else if(n==3){colorLads = colorsBlack;}
        return colorLads;
    }

    

}