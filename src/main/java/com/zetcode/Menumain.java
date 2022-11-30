package com.zetcode;

import javax.swing.*;

public class Menumain extends JFrame{
    private JButton seleccionarNivelButton;
    private JPanel este;

    public Menumain(String title){
        super(title);

    }
    public static void main(String[] arg){
        Menumain frame = new Menumain("Seleccionar Nivel");
        frame.setContentPane(frame.este);
       // frame.radioButton1.setVisible(true);
        frame.setSize(300,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
