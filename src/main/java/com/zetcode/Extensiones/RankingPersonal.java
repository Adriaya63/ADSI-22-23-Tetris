package com.zetcode.Extensiones;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
public class RankingPersonal extends JFrame {
    private JPanel panelBotones= new JPanel();
    private JPanel ranking = new JPanel();
    private static RankingPersonal mRankingPersonal;
private RankingPersonal(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    setSize(600,600);
    setLayout(new GridLayout(1,2));
    
    add(panelBotones);
    panelBotones.setLayout(new GridLayout(4,1));
    JRadioButton rbtn1=new JRadioButton("Fácil",true);
    JRadioButton rbtn2=new JRadioButton("Medio",false);
    JRadioButton rbtn3=new JRadioButton("Difícil",false);
    ButtonGroup grupo1 = new ButtonGroup();
    grupo1.add(rbtn1);
    grupo1.add(rbtn2);
    grupo1.add(rbtn3);
    panelBotones.add(rbtn1);
    panelBotones.add(rbtn2);
    panelBotones.add(rbtn3);
    JButton btnVolver= new JButton("Volver");
    btnVolver.setMaximumSize(new Dimension(300,30));
    panelBotones.add(btnVolver);
    add(ranking);
    JTextArea textarea1=new JTextArea();        
    JScrollPane scrollpane1=new JScrollPane(textarea1);    
    scrollpane1.setBounds(10,50,400,300);
    add(scrollpane1);
    String t="";
    for(int i=0; i<=1000;i++){
        t=t+"hola \n";
        
    }
    textarea1.append(t);
    setVisible(true);
    

}
public static RankingPersonal getmRankigPersonal(){
    if(mRankingPersonal == null){
        mRankingPersonal = new RankingPersonal();
    }
    return mRankingPersonal;
}

public static void main(String args[]) {
    RankingPersonal.getmRankigPersonal();
    }
}
