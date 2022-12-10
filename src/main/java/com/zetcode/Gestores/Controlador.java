package com.zetcode.Gestores;
import java.awt.event.*;

import org.apache.logging.log4j.core.pattern.TextRenderer;

import com.zetcode.Board;
import com.zetcode.FinPartida;
import com.zetcode.Tetris;
import com.zetcode.Extensiones.Menu;
import com.zetcode.Extensiones.Ranking;

public class Controlador implements ActionListener
{
	private static Controlador controler =null;

	private int dir=0;

	private Controlador() {};
	
	public static Controlador getControlador()
	{
		if(controler==null)
		{
			controler = new Controlador();
		}
		return controler;
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        while(true){
        if (e.getSource().equals(Menu.btnRanking)) {
			Ranking.getmiRanking().alternar();
			
			Menu.getMiMenuRanking().alternar();
			break;
        }
		if (e.getSource().equals(Ranking.btnVer)) {
			String tipo= Ranking.getmiRanking().getTip();
			String dif = Ranking.getmiRanking().getdif();
			System.out.println(dif);
			Ranking.getmiRanking().Update(Gestor_ranking.getmiGestorRanking().generarRanking(dif,tipo));
			break;
        }
		if (e.getSource().equals(Ranking.btnVolver)) {
			Menu.getMiMenuRanking().alternar();
			
			Ranking.getmiRanking().alternar();
			break;
        }
		if (e.getSource().equals(Menu.btnJugar)){
			
			Tetris t = new Tetris();
			t.jugar();
			Menu.getMiMenuRanking().alternar();
			break;
		}
       } 

	}  
	public void annadirPuntuacionAlRanking(int numLinesRemoved){
		//Gestor_ranking.getmiGestorRanking().ingresarPuntuacion(Gestor_Usuarios.getmiGestorRanking().nombreUsuarioAct(), numLinesRemoved, dificultad);
		 
	}
	public void cerrarPartida(){
		Menu.getMiMenuRanking().alternar();
		
	}
}
