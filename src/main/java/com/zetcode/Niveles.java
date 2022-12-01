package com.zetcode;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Niveles extends JFrame {
    private static JRadioButton btn_facil;
    private static JRadioButton btn_medio;
    private static JRadioButton btn_dificil;
    private static JButton btn_continuar;
    private static JButton btn_Seleccionar;
    private JLabel lbl_facil;
    private JLabel lbl_medio;
    private JLabel lbl_dificil;
    private JPanel panelmain = new JPanel();

    public Niveles(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 605, 397);
        panelmain = new JPanel();
        panelmain.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelmain);
        panelmain.add(getLbl_facil());
        panelmain.add(getBtn_facil());
        panelmain.add(getLbl_medio());
        panelmain.add(getBtn_medio());
        panelmain.add(getLbl_dificil());
        panelmain.add(getBtn_dificil());

        panelmain.add(getBtn_continuar());
        panelmain.add(getBtn_seleccionar());

    }

    public static void main(String[] arg){
        Niveles frame = new Niveles("Seleccionad Nivel");
        frame.setContentPane(frame.panelmain);
        frame.setSize(300,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JRadioButton getBtn_facil() {
        if (btn_facil == null) {
            btn_facil = new JRadioButton("Facil");
            btn_facil.setEnabled(true);
            // btn_facil.addActionListener(Controlador.getControlador());
        }
        return btn_facil;
    }

    public static JRadioButton getBtn_medio() {
        if (btn_medio == null) {
            btn_medio = new JRadioButton("Medio");
            btn_medio.setEnabled(true);
            //btn_medio.addActionListener(Controlador.getControlador());
        }
        return btn_medio;
    }
    public static JRadioButton getBtn_dificil() {
        if (btn_dificil == null) {
            btn_dificil = new JRadioButton("Dificil");
            btn_dificil.setEnabled(true);
            //btn_dificil.addActionListener(Controlador.getControlador());
        }
        return btn_dificil;
    }
    public static JButton getBtn_continuar() {
        if (btn_continuar == null) {
            btn_continuar = new JButton("Continuar");
            btn_continuar.setEnabled(true);
            //btn_medio.addActionListener(Controlador.getControlador());
        }
        return btn_continuar;
    }
    public static JButton getBtn_seleccionar() {
        if (btn_Seleccionar == null) {
            btn_Seleccionar = new JButton("Seleccionar");
            btn_Seleccionar.setEnabled(true);
            //btn_medio.addActionListener(Controlador.getControlador());
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
            lbl_medio = new JLabel("Nivel medio");
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

