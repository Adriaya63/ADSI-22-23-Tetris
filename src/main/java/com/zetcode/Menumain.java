package com.zetcode;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Menumain extends JFrame{
    private static JButton btn_niveles;
    private JPanel panelmain = new JPanel();

    public Menumain(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 397);
		panelmain = new JPanel();
		panelmain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelmain);
        panelmain.add(getBtn_niveles());
    }
    public static void main(String[] arg){
        Menumain frame = new Menumain("Seleccionar Nivel");
        frame.setContentPane(frame.panelmain);
        frame.setSize(300,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JButton getBtn_niveles() {
        if (btn_niveles == null) {
            btn_niveles = new JButton("Modificar Niveles");
            btn_niveles.setEnabled(true);
            btn_niveles.addActionListener(Gestor_Menumain.getControlador());
        }
        return btn_niveles;
    }
}
