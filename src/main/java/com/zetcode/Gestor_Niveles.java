package com.zetcode;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Gestor_Niveles implements ActionListener {
    private static Gestor_Niveles controler =null;

	private Gestor_Niveles() {};

    public static Gestor_Niveles getControlador()
	{
		if(controler==null)
		{
			controler = new Gestor_Niveles();
		}
		return controler;
	}

   
    @Override
	public void actionPerformed(ActionEvent e)
	{
        if(e.getSource().equals(Menumain.getBtn_niveles()))
		{
			System.out.println("BOTON main SELECCIONADO\n");
			//Metodo para seleccionar el main
		}
        if(e.getSource().equals(Niveles.getBtn_facil()))
		{
			System.out.println("BOTON FACIL SELECCIONADO\n");
			Niveles.getBtn_seleccionar().setEnabled(true);
		}
        if(e.getSource().equals(Niveles.getBtn_medio()))
        {
            System.out.println("BOTON MEDIO SELECCIONADO\n");
            Niveles.getBtn_seleccionar().setEnabled(true);
        }    
        if(e.getSource().equals(Niveles.getBtn_dificil()))
        {
            System.out.println("BOTON DIFICIL SELECCIONADO\n");
            Niveles.getBtn_seleccionar().setEnabled(true);
        }
        if(e.getSource().equals(Niveles.getBtn_volver()))
        {
            System.out.println("BOTON VOLVER SELECCIONADO\n");
            Menumain.main(null);
            
        }
        if(e.getSource().equals(Niveles.getBtn_seleccionar()))
        {
            System.out.println("BOTON SELECCIONAR SELECCIONADO\n");
            if(Niveles.getBtn_dificil().isSelected()){
                Board.modificarTiempo(150);
            }
            else if(Niveles.getBtn_facil().isSelected()){
                Board.modificarTiempo(500);
            }
            Tetris.main(null);
                       
        }        
    }
}