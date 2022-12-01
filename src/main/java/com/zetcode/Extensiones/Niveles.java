
package com.zetcode.Extensiones;

import javax.swing.*;

public class Niveles extends JFrame {
    private JButton Seleccionar;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JPanel panelmain;
    private JButton continuarButton;

    public Niveles(String title){
        super(title);

    }
    public static void main(String[] arg){
        Niveles frame = new Niveles("Seleccionad Nivel");
        frame.setContentPane(frame.panelmain);
        //frame.radioButton1.setVisible(true);
        frame.setSize(300,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}