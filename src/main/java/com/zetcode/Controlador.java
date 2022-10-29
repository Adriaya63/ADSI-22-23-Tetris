package com.zetcode;
import java.awt.event.*;

import com.zetcode.Extensiones.MenuRanking;
import com.zetcode.Extensiones.RankingPersonal;
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
        System.out.println(" la source es " + e.getSource());
        if (e.getSource().equals(MenuRanking.btnPersonal)) {
            RankingPersonal.getmRankigPersonal();
        }
        if (e.getSource().equals(MenuRanking.btnGlobal)) {
            RankingPersonal.getmRankigPersonal();
        }
        
    }
    
}
