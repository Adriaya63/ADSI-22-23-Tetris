package com.zetcode.Extensiones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.zetcode.Gestores.Gestor;

import java.awt.*;

public class IU_Niveles extends JFrame {
    private static JRadioButton btn_facil;
    private static JRadioButton btn_medio;
    private static JRadioButton btn_dificil;
    private static ButtonGroup grupo = new ButtonGroup();
    private static JButton btn_volver;
    private static JButton btn_Seleccionar;
    private JPanel panelmain;
    private JPanel panel ;
    private JPanel panel2 ;
    private static IU_Niveles minivel;
    private JLabel titulo;

    public static IU_Niveles getNiveles() {
        if (minivel == null) {
            minivel = new IU_Niveles();
        }
        return minivel;
    }   

    public void hacerVisible() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);        
        setVisible(true);
        panelmain = new JPanel();
        panelmain.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelmain.setLayout(new BorderLayout(0, 0)); // 
        setContentPane(panelmain);
        grupo.add(getBtn_facil());
        grupo.add(getBtn_medio());
        grupo.add(getBtn_dificil());
        panelmain.add(getPanel1(), BorderLayout.SOUTH);
        panelmain.add(getPanel2(), BorderLayout.CENTER);
        panelmain.add(getLbltitulo(), BorderLayout.NORTH);
    }

    private JPanel getPanel1(){
        if (panel == null) {
            panel = new JPanel();
            panel.add(getBtn_volver());
            panel.add(getBtn_seleccionar());
            
        }
        return panel;
    }

    private JPanel getPanel2() {
        if (panel2 == null) {
            panel2 = new JPanel();
            panel2.setLayout(new GridLayout(3, 0, 0, 0));
            panel2.add(getBtn_facil());
            panel2.add(getBtn_medio());
            panel2.add(getBtn_dificil());
        }
        return panel2;
    }

    private JLabel getLbltitulo() {
        if (titulo == null) {
            titulo = new JLabel("Men\u00FA Niveles");
            titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
            titulo.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return titulo;
    }

    public static JRadioButton getBtn_facil() {
        if (btn_facil == null) {
            btn_facil = new JRadioButton("Facil");
            btn_facil.setEnabled(true);
            btn_facil.setHorizontalAlignment(SwingConstants.CENTER);
            btn_facil.addActionListener(Gestor.getGestor());
        }
        return btn_facil;
    }

    public static JRadioButton getBtn_medio() {
        if (btn_medio == null) {
            btn_medio = new JRadioButton("Medio");
            btn_medio.setEnabled(true);
            btn_medio.setHorizontalAlignment(SwingConstants.CENTER);
            btn_medio.addActionListener(Gestor.getGestor());
        }
        return btn_medio;
    }

    public static JRadioButton getBtn_dificil() {
        if (btn_dificil == null) {
            btn_dificil = new JRadioButton("Dificil");
            btn_dificil.setEnabled(true);
            btn_dificil.setHorizontalAlignment(SwingConstants.CENTER);
            btn_dificil.addActionListener(Gestor.getGestor());
        }
        return btn_dificil;
    }

    public static JButton getBtn_volver() {
        if (btn_volver == null) {
            btn_volver = new JButton("Volver");
            btn_volver.setEnabled(true);
            btn_volver.addActionListener(Gestor.getGestor());
        }
        return btn_volver;
    }

    public static JButton getBtn_seleccionar() {
        if (btn_Seleccionar == null) {
            btn_Seleccionar = new JButton("Seleccionar");
            btn_Seleccionar.setEnabled(false);
            btn_Seleccionar.addActionListener(Gestor.getGestor());
        }
        return btn_Seleccionar;
    }
}
