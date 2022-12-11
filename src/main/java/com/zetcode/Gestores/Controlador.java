package com.zetcode.Gestores;
import java.awt.event.*;

import org.apache.logging.log4j.core.pattern.TextRenderer;

import com.zetcode.FinPartida;
import com.zetcode.Tetris;
import com.zetcode.Extensiones.Menu;
import com.zetcode.Extensiones.Ranking;

public class Controlador implements ActionListener
{
	private static Controlador controler =null;


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
			Tetris.jugar();
			Menu.getMiMenuRanking().alternar();
			break;
		}
		
       } 
	}
		public void finalizarPartida(FinPartida f, String usuario, int puntuacion){
			f.dispose();
			Gestor_ranking.getmiGestorRanking().ingresarPuntuacion(usuario, puntuacion,"Fácil");
			Menu.getMiMenuRanking().alternar();
		}
}
