package com.zetcode.Extensiones;
import javax.swing.border.EmptyBorder;

import com.zetcode.Controlador;


import javax.swing.*;
import java.awt.*;
public class RankingGlobal extends JFrame {
    private JPanel panelBotones= new JPanel();
    private JPanel ranking = new JPanel();
    public static JButton btnVolver;
    private boolean estado=false;
    boolean iniciado=false;
    private static RankingGlobal mRankingGlobal;

private RankingGlobal(){
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);		
        setLocationRelativeTo(null);		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));
        setTitle("Ranking Global");
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
        btnVolver= new JButton("Volver");
        btnVolver.addActionListener(Controlador.getControlador());
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
    }
public static RankingGlobal  getmRankigGlobal(){
    if(mRankingGlobal == null){
        mRankingGlobal  = new RankingGlobal();
    }
    return mRankingGlobal ;
}
public void alternar(){
    if(estado){
        setVisible(false);
        estado=false;
    }
    else{
        setVisible(true);
        estado=true;
    }
}
public static void main(String args[]) {
    RankingPersonal.getmRankigPersonal();
    }
}

