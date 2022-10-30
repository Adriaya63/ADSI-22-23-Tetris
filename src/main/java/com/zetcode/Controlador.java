package com.zetcode;
import java.awt.event.*;

import com.zetcode.Extensiones.MenuRanking;
import com.zetcode.Extensiones.RankingGlobal;
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
        while(true){
        if (e.getSource().equals(MenuRanking.btnPersonal)) {
            RankingPersonal.getmRankigPersonal().alternar();;
			MenuRanking.getMiMenuRanking().alternar();
			break;
        }
        if (e.getSource().equals(MenuRanking.btnGlobal)) {
            RankingGlobal.getmRankigGlobal().alternar();
			MenuRanking.getMiMenuRanking().alternar();
			break;
        }
		if (e.getSource().equals(RankingPersonal.btnVolver)) {
			MenuRanking.getMiMenuRanking().alternar();
			RankingPersonal.getmRankigPersonal().alternar();
			break;
        }
		if (e.getSource().equals(RankingGlobal.btnVolver)) {
			MenuRanking.getMiMenuRanking().alternar();
			RankingGlobal.getmRankigGlobal().alternar();
			break;
        }
       } 
    
    
}
}
