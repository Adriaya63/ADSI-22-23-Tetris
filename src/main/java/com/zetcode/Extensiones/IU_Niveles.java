package com.zetcode.Extensiones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.zetcode.Controlador;

import java.awt.*;

public class IU_Niveles extends JFrame {
    private static JRadioButton btn_facil;
    private static JRadioButton btn_medio;
    private static JRadioButton btn_dificil;
    private static ButtonGroup grupo=new ButtonGroup();
    private static JButton btn_volver;
    private static JButton btn_Seleccionar;
    private JLabel lbl_facil;
    private JLabel lbl_medio;
    private JLabel lbl_dificil;
    private JPanel panelmain = new JPanel();
    private static IU_Niveles minivel;
    
   public static IU_Niveles getNiveles(){
    if(minivel==null){
        minivel=new IU_Niveles();
    }
    return minivel;
   }
   
   public IU_Niveles(){

    }
    public void hacerVisible(){
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);		
        setLocationRelativeTo(null);		
        setSize(300,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setBounds(100, 100, 605, 397);
        panelmain = new JPanel();
        panelmain.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelmain);
        grupo.add(getBtn_facil());
        grupo.add(getBtn_medio());
        grupo.add(getBtn_dificil()); 
        panelmain.add(getLbl_facil()); 
        panelmain.add(getBtn_facil());
        panelmain.add(getLbl_medio());
        panelmain.add(getBtn_medio());     setSize(300,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 605, 397);
        panelmain = new JPanel();
        panelmain.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelmain);
        grupo.add(getBtn_facil());
        grupo.add(getBtn_medio());
        grupo.add(getBtn_dificil()); 
        panelmain.add(getLbl_facil()); 
        panelmain.add(getBtn_facil());
        panelmain.add(getLbl_medio());
        panelmain.add(getBtn_medio());
        panelmain.add(getLbl_dificil());
        panelmain.add(getBtn_dificil());
            
        panelmain.add(getBtn_volver());
        panelmain.add(getBtn_seleccionar());
        panelmain.add(getLbl_dificil());
        panelmain.add(getBtn_dificil());
            
        panelmain.add(getBtn_volver());
        panelmain.add(getBtn_seleccionar());
    }

    

    public static JRadioButton getBtn_facil() {
        if (btn_facil == null) {
            btn_facil = new JRadioButton("Facil");
            btn_facil.setEnabled(true);
            btn_facil.addActionListener(Controlador.getControlador());
        }
        return btn_facil;
    }

    public static JRadioButton getBtn_medio() {
        if (btn_medio == null) {
            btn_medio = new JRadioButton("Medio");
            btn_medio.setEnabled(true);
            btn_medio.addActionListener(Controlador.getControlador());
        }
        return btn_medio;
    }
    public static JRadioButton getBtn_dificil() {
        if (btn_dificil == null) {
            btn_dificil = new JRadioButton("Dificil");
            btn_dificil.setEnabled(true);
            btn_dificil.addActionListener(Controlador.getControlador());
        }
        return btn_dificil;
    }
    public static JButton getBtn_volver() {
        if (btn_volver == null) {
            btn_volver = new JButton("Volver");
            btn_volver.setEnabled(true);
            btn_volver.addActionListener(Controlador.getControlador());
        }
        return btn_volver;
    }
    public static JButton getBtn_seleccionar() {
        if (btn_Seleccionar == null) {
            btn_Seleccionar = new JButton("Seleccionar");
            btn_Seleccionar.setEnabled(false);
            btn_Seleccionar.addActionListener(Controlador.getControlador());
        }
        return btn_Seleccionar;
    }
    private JLabel getLbl_facil() {
		if (lbl_facil == null) {
			lbl_facil = new JLabel("Nivel facil");
		}
		return lbl_facil;
	}
    private JLabel getLbl_medio() {
		if (lbl_medio == null) {
			lbl_medio = new JLabel("Nivel normal");
		}
		return lbl_medio;
	}
    private JLabel getLbl_dificil() {
		if (lbl_dificil == null) {
			lbl_dificil = new JLabel("Nivel dificil");
		}
		return lbl_dificil;
	}
 
 
}
