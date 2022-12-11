package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.h2.util.json.JSONArray;
import org.junit.Test;


import com.zetcode.Gestores.Gestor_ranking;

public class Gestor_rankingtest {

	private static final Logger logger = LogManager.getLogger(Gestor_rankingtest.class);
	
	@Test
	public void Gestor_rankingtest() {
        //Prueba de constructora de Gestor Ranking
		Gestor_ranking g= Gestor_ranking.getmiGestorRanking();
        assertNotNull(g);
	}
	@Test
	public void insertarNuevaPuntuacionTest() {
		//Comprobamos el numero de puntuaciones que hay en el ranking
        org.json.JSONArray json = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
        int n = json.length();
		//Generamos una nueva puntuacion
		Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Jose",99,"Fácil");
		org.json.JSONArray json2 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
		int n2 = json2.length();
		assertEquals(n+1, n2);
		//Insertar una puntuacion de un jugador que no existe
		org.json.JSONArray json3 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
        int n3 = json3.length();
		//Generamos una nueva puntuacion
		Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("JugadorNoExistente",99,"Medio");
		org.json.JSONArray json4 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
		int n4 = json4.length();
		assertEquals(n3, n4);
		//Insertar una puntuacion en una dificultad que no existe
		org.json.JSONArray json5 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
        int n5 = json5.length();
		//Generamos una nueva puntuacion
		Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("fran",99,"dif");
		org.json.JSONArray json6 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
		int n6 = json6.length();
		assertEquals(n5, n6);
	}

	@Test
	public void rankingsTest() {
		//Ranking Histórico y global
		org.json.JSONArray json = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "Global");
		assertNotNull(json);
		//Ranking Histórico y personal
		org.json.JSONArray json2 = Gestor_ranking.getmiGestorRanking().generarRanking("Absoluto", "fran");
		assertNotNull(json2);
		//Ranking facil y personal
		org.json.JSONArray json3 = Gestor_ranking.getmiGestorRanking().generarRanking("Fácil", "fran");
		assertNotNull(json3);
		//Ranking Medio y personal
		org.json.JSONArray json4 = Gestor_ranking.getmiGestorRanking().generarRanking("Medio", "fran");
		assertNotNull(json4);
		//Ranking Difícl y personal
		org.json.JSONArray json5 = Gestor_ranking.getmiGestorRanking().generarRanking("Difícil", "fran");
		assertNotNull(json5);
		//Ranking facil y Global
		org.json.JSONArray json6 = Gestor_ranking.getmiGestorRanking().generarRanking("Fácil", "Global");
		assertNotNull(json6);
		//Ranking Medio y Global
		org.json.JSONArray json7 = Gestor_ranking.getmiGestorRanking().generarRanking("Medio", "Global");
		assertNotNull(json7);
		//Ranking Difícl y Global
		org.json.JSONArray json8 = Gestor_ranking.getmiGestorRanking().generarRanking("Difícil", "Global");
		assertNotNull(json8);
	}
}