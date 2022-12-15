package com.zetcode.Gestores;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Gestor_ranking {
    private static Gestor_ranking miGestorRanking;

    private Gestor_ranking() {

    }

    public static Gestor_ranking getmiGestorRanking() {
        if (miGestorRanking == null) {
            miGestorRanking = new Gestor_ranking();
        }
        return miGestorRanking;
    }

    public JSONArray generarRanking(String dificultad, String usuario) {
        String consulta = "";
        JSONArray jsonArray = new JSONArray();
        if (dificultad == "Absoluto" && usuario != "Global") {
            consulta = "SELECT nombre, puntuacion from info_ranking where nombre ='" + usuario + "' ORDER BY puntuacion DESC";
        }
        if (dificultad != "Absoluto" && usuario != "Global") {
            consulta = "SELECT nombre, puntuacion from info_ranking where dificultad = '" + dificultad + "'AND nombre = '" + usuario + "'ORDER BY puntuacion DESC";
        }
        if (dificultad != "Absoluto" && usuario == "Global") {
            consulta = "SELECT nombre, puntuacion from info_ranking where dificultad ='" + dificultad + "'ORDER BY puntuacion DESC";
        }
        if (dificultad == "Absoluto" && usuario == "Global") {
            consulta = "SELECT nombre, puntuacion from info_ranking ORDER BY puntuacion DESC";
        }
        try {

            ResultSet rs = BD.selectSql(consulta);
            // Recorremos el resultado
            while (rs.next()) {
                int columns = rs.getMetaData().getColumnCount();
                JSONObject obj = new JSONObject();

                for (int i = 0; i < columns; i++)
                    obj.put(rs.getMetaData().getColumnLabel(i + 1).toLowerCase(), rs.getObject(i + 1));

                jsonArray.put(obj);
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }

        return jsonArray;
    }


    public void ingresarPuntuacion(String usuario, int numLinesRemoved, String dificultad) {
        String consulta = String.format("INSERT INTO info_ranking VALUES('%s','%d','%s')", usuario, numLinesRemoved, dificultad);
        BD.sqlvoid(consulta);


    }
}



