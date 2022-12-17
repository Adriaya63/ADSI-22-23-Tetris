package com.zetcode.Gestores;


import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BD {
    static Statement consulta = null;
    static Connection conexion = null;
    static boolean inicializado = false;
    static String dir = "";
    static String USER = "sa";
    static String PASS = "1234";


    private static Connection getConnection() {
        if (!inicializado) {
            BD.inicializar(false);
        }

        try {
            return DriverManager.getConnection(dir, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void initTest() {
        if (inicializado) {
            dir = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
        } else {
            inicializar(true);
        }
    }

    private static void inicializar(Boolean t) {
        inicializado = true;
        String JDBC_DRIVER = "org.h2.Driver";
        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            System.err.println("Modulo de h2 no encontrado");
            System.exit(1);
        }

        try {
            //Data base en memoria para las pruebas unitarias
            if (t) {
                dir = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
            } else {
                //Guarda la database en test.mv.db
                dir = "jdbc:h2:" + new File("tetris").getCanonicalPath();
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        Boolean existe = false;
        Connection conn = null;
        Statement stat = null;
        //Comprobacion para saber si existe la bd
        try {
            conn = BD.getConnection();
            stat = conn.createStatement();
            ResultSet prueba = stat.executeQuery("SELECT * FROM Usuario");
            existe = true;
            prueba.next();
            String n = prueba.getString("nombre");
            conn.close();
            stat.close();
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stat != null) {
                    stat.close();
                }
            } catch (Exception ex) {
            }
        }

        if (!existe) {
            try {
                conn = BD.getConnection();
                ScriptRunner scriptR = new ScriptRunner(conn);
                Reader reader = new BufferedReader(new FileReader("tetrisBD.sql"));
                scriptR.runScript(reader);
                try {
                    conn.close();
                } catch (Exception e) {
                }
            } catch (FileNotFoundException e) {
                System.err.println(e);
            }
        }
    }

    public static void sqlvoid(String pConsulta) { //INSERT, UPDATE, DELETE
        try {
            if (conexion != null) {
                conexion.close();
            }
            if (consulta != null) {
                consulta.close();
            }
            conexion = BD.getConnection();
            consulta = conexion.createStatement();
            consulta.execute(pConsulta);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);
        }
    }

    public static ResultSet selectSql(String pC) { //SELECT
        ResultSet rs = null;
        try {
             if (conexion != null) {
                conexion.close();
            }
            if (consulta!= null) {
                consulta.close();
            } 
            conexion = BD.getConnection();
            consulta = conexion.createStatement();
            rs = consulta.executeQuery(pC);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);
        }
        return rs;
    }
}