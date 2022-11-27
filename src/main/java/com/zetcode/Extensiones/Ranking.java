package com.zetcode.Extensiones;
import javax.swing.border.EmptyBorder;

import com.zetcode.Gestores.Controlador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Ranking extends JFrame {
    private JPanel panelBotones= new JPanel();
    private JPanel panelBotonestipos= new JPanel(new GridLayout(1,2));
    private JPanel ranking = new JPanel();
    public static JButton btnVolver;
    private boolean estado=false;
    boolean iniciado=false;
    private static Ranking miRanking;
    private JTextArea textarea1;
private Ranking(){
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);		
        setLocationRelativeTo(null);		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));
        setTitle("Ranking");
        add(panelBotones);
        panelBotones.setLayout(new GridLayout(6,1));
        panelBotones.add(this.panelBotonestipos);
        JRadioButton rbtn1t=new JRadioButton("Personal",true);
        JRadioButton rbtn2t=new JRadioButton("Global",true);
        JRadioButton rbtn1=new JRadioButton("Fácil",true);
        JRadioButton rbtn2=new JRadioButton("Medio",false);
        JRadioButton rbtn3=new JRadioButton("Difícil",false);
        JRadioButton rbtn4=new JRadioButton("Histórico",false);
        ButtonGroup grupo2 = new ButtonGroup();
        grupo2.add(rbtn1t);
        grupo2.add(rbtn2t);
        panelBotonestipos.add(rbtn1t);
        panelBotonestipos.add(rbtn2t);
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(rbtn1);
        grupo1.add(rbtn2);
        grupo1.add(rbtn3);
        grupo1.add(rbtn4);
        panelBotones.add(rbtn1);
        panelBotones.add(rbtn2);
        panelBotones.add(rbtn3);
        panelBotones.add(rbtn4);
        btnVolver= new JButton("Volver");
        btnVolver.addActionListener(Controlador.getControlador());
        btnVolver.setMaximumSize(new Dimension(300,30));
        panelBotones.add(btnVolver);
        add(ranking);
        textarea1=new JTextArea();        
        JScrollPane scrollpane1=new JScrollPane(textarea1);    
        scrollpane1.setBounds(10,50,400,300);
        add(scrollpane1);
        
    }
public static Ranking  getmiRanking(){
    if(miRanking == null){
        miRanking= new Ranking();
    }
    return miRanking ;
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
public void annadirResultado(ArrayList<String>  lista){
    String texto="";
    for(String a:lista){
        texto=texto + a + "\n";
            }
    this.textarea1.append(texto);

    }
public void borrar(){
    textarea1=new JTextArea();
}
}
