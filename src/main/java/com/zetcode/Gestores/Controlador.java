package com.zetcode.Gestores;
import java.awt.event.*;

import com.zetcode.Tetris;
import com.zetcode.Extensiones.IU_Fondo;
import com.zetcode.Extensiones.IU_Ladrillos;
import com.zetcode.Extensiones.IU_Personalizacion;
import com.zetcode.Extensiones.IU_Sonido;
import com.zetcode.Extensiones.Menu;
import com.zetcode.Extensiones.Ranking;

public class Controlador implements ActionListener
{
	private static Controlador controler =null;

	private int dir=0;
	private int seleccionPer=0;
	private int colorLad=0;
	private int fondo=0;

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
		if(e.getSource().equals(Menu.btnPersonalizar)){
			IU_Personalizacion.getMiPer().alternar();
			Menu.getMiMenuRanking().alternar();
			break;
		}
		if(e.getSource().equals(IU_Personalizacion.bAceptar)){
			if(seleccionPer==1){
				IU_Fondo.getMiFondo().alternar();
				IU_Personalizacion.getMiPer().alternar();
			}else if(seleccionPer==2){
				IU_Ladrillos.getMiLad().alternar();
				IU_Personalizacion.getMiPer().alternar();
			}else if(seleccionPer==3){
				IU_Sonido.getMiSon().alternar();
				IU_Personalizacion.getMiPer().alternar();
			}
			break;
		}
		if(e.getSource().equals(IU_Personalizacion.bVolver)){
			IU_Personalizacion.getMiPer().alternar();
			Menu.getMiMenuRanking().alternar();
			break;
		}
		if(e.getSource().equals(IU_Personalizacion.rbFondo)){
			seleccionPer=1;
			break;
		}
		if(e.getSource().equals(IU_Personalizacion.rbLadrillos)){
			seleccionPer=2;
			break;
		}
		if(e.getSource().equals(IU_Personalizacion.rbSonido)){
			seleccionPer=3;
			break;
		}
		if(e.getSource().equals(IU_Fondo.bGuardar)){
			Gestor_Personalizacion.getGestorPer().cambiarImgFondo(fondo);
			break;
		}
		if(e.getSource().equals(IU_Fondo.rbFondo1)){fondo=1; break;}
		if(e.getSource().equals(IU_Fondo.rbFondo2)){fondo=2; break;}
		if(e.getSource().equals(IU_Fondo.rbFondo3)){fondo=3; break;}
		if(e.getSource().equals(IU_Fondo.bVolver)){
			IU_Fondo.getMiFondo().alternar();
			IU_Personalizacion.getMiPer().alternar();
			break;
		}
		if(e.getSource().equals(IU_Ladrillos.bGuardar)){
			Gestor_Personalizacion.getGestorPer().cambiarColor(colorLad);
			break;
		}
		if(e.getSource().equals(IU_Ladrillos.bVolver)){
			IU_Ladrillos.getMiLad().alternar();
			IU_Personalizacion.getMiPer().alternar();
			break;
		}
		if(e.getSource().equals(IU_Ladrillos.rbDefault)){colorLad=1; break;}
		if(e.getSource().equals(IU_Ladrillos.rbClasic)){colorLad=2; break;}
		if(e.getSource().equals(IU_Ladrillos.rbBlack)){colorLad=3; break;}
		if(e.getSource().equals(IU_Sonido.bGuardar)){
			break;
		}
		if(e.getSource().equals(IU_Sonido.bVolver)){
			IU_Sonido.getMiSon().alternar();
			IU_Personalizacion.getMiPer().alternar();
			break;
		}
		if (e.getSource().equals(Menu.btnJugar)){
			Menu.getMiMenuRanking().alternar();
			Tetris t = new Tetris();
			t.jugar();
			
			break;
		}
       } 

	}  
	public void annadirPuntuacionAlRanking(int numLinesRemoved){
		String dificultad="medio";
		String usuario="Fran";
		Gestor_ranking.getmiGestorRanking().ingresarPuntuacion(usuario, numLinesRemoved, dificultad);
		 
	}
}
