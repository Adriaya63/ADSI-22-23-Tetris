package com.zetcode.Gestores;
import java.awt.event.*;

import org.apache.logging.log4j.core.pattern.TextRenderer;

import com.zetcode.Board;
import com.zetcode.FinPartida;
import com.zetcode.Niveles;
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
			Niveles.getNiveles().hacerVisible();;
			Menu.getMiMenuRanking().alternar();
			break;
		}

        if(e.getSource().equals(Niveles.getBtn_facil()))
		{
			System.out.println("BOTON FACIL SELECCIONADO\n");
			Niveles.getBtn_seleccionar().setEnabled(true);
			break;
		}
        if(e.getSource().equals(Niveles.getBtn_medio()))
        {
            System.out.println("BOTON MEDIO SELECCIONADO\n");
            Niveles.getBtn_seleccionar().setEnabled(true);
			break;
        }    
        if(e.getSource().equals(Niveles.getBtn_dificil()))
        {
            System.out.println("BOTON DIFICIL SELECCIONADO\n");
            Niveles.getBtn_seleccionar().setEnabled(true);
			break;
        }
        if(e.getSource().equals(Niveles.getBtn_volver()))
        {
            System.out.println("BOTON VOLVER SELECCIONADO\n");
            Menu.getMiMenuRanking().alternar();
			break;
            
        }
        if(e.getSource().equals(Niveles.getBtn_seleccionar()))
        {
            System.out.println("BOTON SELECCIONAR SELECCIONADO\n");
            if(Niveles.getBtn_dificil().isSelected()){
				Niveles.getNiveles().dispose();
                Tetris.jugar(150);
            }
			if(Niveles.getBtn_medio().isSelected()){
				Niveles.getNiveles().dispose();
                Tetris.jugar(300);
            }
            else if(Niveles.getBtn_facil().isSelected()){
				Niveles.getNiveles().dispose();
				Tetris.jugar(150);
            }
			break;
        } 
		else{
			break;
		}       
    }
       } 
	
		public void finalizarPartida(FinPartida f, String usuario, int puntuacion,String dif){
			f.dispose();
			Gestor_ranking.getmiGestorRanking().ingresarPuntuacion("Jose", puntuacion, dif);
			Menu.getMiMenuRanking().alternar();
		}
}
