package com.zetcode.Gestores;
import java.awt.event.*;

import com.zetcode.Extensiones.MenuRanking;
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
        if (e.getSource().equals(MenuRanking.btnRanking)) {
			Ranking.getmiRanking().alternar();
			
			MenuRanking.getMiMenuRanking().alternar();
			break;
        }
		if (e.getSource().equals(Ranking.btnVer)) {
			String tipo= Ranking.getmiRanking().getTip();
			String dif = Ranking.getmiRanking().getdif();
			System.out.println(dif);
			Ranking.getmiRanking().generarRanking(Gestor_ranking.getmiGestorRanking().generarRanking(dif));
			break;
        }
		if (e.getSource().equals(Ranking.btnVolver)) {
			MenuRanking.getMiMenuRanking().alternar();
			
			Ranking.getmiRanking().alternar();
			break;
        }
       } 
    
    
}
}
