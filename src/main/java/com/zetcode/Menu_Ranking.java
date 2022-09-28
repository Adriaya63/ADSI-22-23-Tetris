package com.zetcode;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class Menu_Ranking extends JFrame {
    private JButton rpersonal;
    private JButton rGlobal;
    private JButton volver;
    private final int width= 10;
    private final int height= 22;
    private JPanel contentPane;
    private static Menu_Ranking miMenuRanking=null;
public static Menu_Ranking getMiMenuRanking(){
    if(miMenuRanking==null){
        miMenuRanking=new Menu_Ranking();
    }
    return miMenuRanking;
}    
private Menu_Ranking(){
    this.iniciar();
}
private void iniciar(){
    contentPane.setLayout(new BorderLayout(0, 0));
    this.contentPane.add(this.rpersonal,BorderLayout.CENTER);
    this.contentPane.add(this.rGlobal,BorderLayout.NORTH);
    this.contentPane.add(this.rGlobal,BorderLayout.SOUTH);
    this.contentPane.setSize(width,height);
    setTitle("Ejemplo 16"); //Título del JFrame
    setSize(250,150); //Dimensiones del JFrame
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //C 
}

public static void main(String[] args) {
    Menu_Ranking m= Menu_Ranking.getMiMenuRanking();   
}
}