package eus.ehu.lsi.adsi;
import com.zetcode.Extensiones.IU_Ranking;
import com.zetcode.Extensiones.Usuario_Conectado;
import com.zetcode.Gestores.BD;
import com.zetcode.Gestores.Gestor_Usuarios;
import com.zetcode.Gestores.Gestor_ranking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Gestor_rankingtest {

    private static final Logger logger = LogManager.getLogger(Gestor_rankingtest.class);

    @Test
    public void Gestor_rankingtest() {
        //Prueba de constructora de Gestor Ranking
        Gestor_ranking g = Gestor_ranking.getmiGestorRanking();
        assertNotNull(g);
    }

    @Test
    public void insertarNuevaPuntuacionTest() {
        //Iniciamos una BD temporal para los test
        BD.initTest();
        //Comprobamos el numero de puntuaciones que hay en el ranking
        org.json.JSONArray json = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
        int n = json.length();
        //Generamos una nueva puntuacion
        Gestor_Usuarios.getMiGestorUser().insertarUsuario("Jose", "1234", "jose@gmail.com");
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Jose", 99, "Fácil");
        org.json.JSONArray json2 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
        int n2 = json2.length();
        assertEquals(n + 1, n2);
        //Insertar una puntuacion de un jugador que no existe
        org.json.JSONArray json3 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
        int n3 = json3.length();
        //Generamos una nueva puntuacion
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("JugadorNoExistente", 99, "Medio");
        org.json.JSONArray json4 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
        int n4 = json4.length();
        assertEquals(n3, n4);
        //Insertar una puntuacion en una dificultad que no existe
        org.json.JSONArray json5 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
        int n5 = json5.length();
        //Generamos una nueva puntuacion
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("fran", 99, "dif");
        org.json.JSONArray json6 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
        int n6 = json6.length();
        assertEquals(n5, n6);
    }

    @Test
    public void rankingsTest() {

        //Pruebas programadas para que se muestren por pantalla los diferentes ranking
        //Ranking Histórico y global 
        //Iniciamos una BD temporal para los test
        BD.initTest();
        //Insertamos un usuario y una puntuación el la BD
        Gestor_Usuarios.getMiGestorUser().insertarUsuario("Jose", "1234", "jose@gmail.com");
        Gestor_Usuarios.getMiGestorUser().insertarUsuario("Mario", "1234", "Mario@gmail.com");
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Jose", 99, "Fácil");
        org.json.JSONArray json = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
        //Visualizamos el ranking seleccionado
        IU_Ranking.getmiRanking().updateT(json);
        IU_Ranking.getmiRanking().alternar();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        } 
        IU_Ranking.getmiRanking().alternar();
        //Ranking Histórico y personal 
        //Insertamos un jugador y logeamos con un usuario.
        Gestor_Usuarios.getMiGestorUser().insertarUsuario("Fran", "1234", "fragonzcuriel@gmail.com");
        org.json.JSONObject b = Gestor_Usuarios.getMiGestorUser().buscarUser("Fran", "1234");
        Usuario_Conectado.geyMiUser().initUser(b);
        //Puntuaciones
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Fran", 24, "Fácil");
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Fran", 27, "Medio");
        org.json.JSONArray json2 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", Usuario_Conectado.geyMiUser().getNombre());
        //Visualizamos el ranking seleccionado
        IU_Ranking.getmiRanking().updateT(json2);
        IU_Ranking.getmiRanking().alternar();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        } 
        IU_Ranking.getmiRanking().alternar();
        assertNotNull(json2);
        //Ranking facil y personal
         //Puntuaciones
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Fran", 23, "Fácil");
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Fran", 27, "Fácil");
        org.json.JSONArray json3 = Gestor_ranking.getmiGestorRanking().generarRanking("Fácil", Usuario_Conectado.geyMiUser().getNombre());
        //Visualizamos el ranking seleccionado
        IU_Ranking.getmiRanking().updateT(json3);
        IU_Ranking.getmiRanking().alternar();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        } 
        IU_Ranking.getmiRanking().alternar();
        assertNotNull(json3);
        //Ranking Medio y personal
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Fran", 23123, "Medio");
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Fran", 2712, "Medio");
        org.json.JSONArray json4 = Gestor_ranking.getmiGestorRanking().generarRanking("Medio", Usuario_Conectado.geyMiUser().getNombre());
        IU_Ranking.getmiRanking().updateT(json4);
        IU_Ranking.getmiRanking().alternar();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        } 
        IU_Ranking.getmiRanking().alternar();
        assertNotNull(json4);
        //Ranking Difícl y personal
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Fran", 2323, "Difícil");
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Fran", 2711232, "Difícil");
        org.json.JSONArray json5 = Gestor_ranking.getmiGestorRanking().generarRanking("Difícil",  Usuario_Conectado.geyMiUser().getNombre());
        IU_Ranking.getmiRanking().updateT(json5);
        IU_Ranking.getmiRanking().alternar();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        } 
        IU_Ranking.getmiRanking().alternar();
        assertNotNull(json5);
        //Ranking facil y Global
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Mario", 11, "Fácil");
        org.json.JSONArray json6 = Gestor_ranking.getmiGestorRanking().generarRanking("Fácil", "Global");
        IU_Ranking.getmiRanking().updateT(json6);
        IU_Ranking.getmiRanking().alternar();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        } 
        IU_Ranking.getmiRanking().alternar();
        //Ranking Medio y Global
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Jose", 99, "Medio");
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Mario", 15, "Medio");
        org.json.JSONArray json7 = Gestor_ranking.getmiGestorRanking().generarRanking("Medio", "Global");
        IU_Ranking.getmiRanking().updateT(json7);
        IU_Ranking.getmiRanking().alternar();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        } 
        IU_Ranking.getmiRanking().alternar();
        assertNotNull(json7);
        //Ranking Difícl y Global
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Jose", 99, "Difícil");
        Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Mario", 17, "Difícil");
        org.json.JSONArray json8 = Gestor_ranking.getmiGestorRanking().generarRanking("Difícil", "Global");
        IU_Ranking.getmiRanking().updateT(json8);
        IU_Ranking.getmiRanking().alternar();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        } 
        IU_Ranking.getmiRanking().alternar();
        assertNotNull(json8);
    

}
}