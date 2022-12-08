package com.zetcode;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Gestor_Menumain implements ActionListener {
    private static Gestor_Menumain controler =null;

	private Gestor_Menumain() {};

    public static Gestor_Menumain getControlador()
	{
		if(controler==null)
		{
			controler = new Gestor_Menumain();
		}
		return controler;
	}

   
    @Override
	public void actionPerformed(ActionEvent e)
	{
        if(e.getSource().equals(Menumain.getBtn_niveles()))
		{
			System.out.println("BOTON main SELECCIONADO\n");
			Niveles.main(null);
		}
    }
}