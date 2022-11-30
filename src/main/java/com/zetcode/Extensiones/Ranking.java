package com.zetcode.Extensiones;


import org.json.JSONArray;

import org.json.JSONObject;

import com.zetcode.Gestores.Controlador;

import javax.swing.*;
import java.awt.*;

public class Ranking extends JFrame {
    private JPanel panelBotones= new JPanel();
    private JPanel panelBotonestipos= new JPanel(new GridLayout(1,2));
    private JTable tabla;
    public static JButton btnVolver;
    private JRadioButton rbtn1t;
    private JRadioButton rbtn2t;
    private JRadioButton rbtn1;
    private JRadioButton rbtn2;
    private JRadioButton rbtn3;
    private JRadioButton rbtn4;
    private boolean estado=false;
    public static JButton btnVer;
    private ButtonGroup grupo2 ;
    private ButtonGroup grupo1;
    private static Ranking miRanking;
    private JPanel ranking =new JPanel(new GridLayout(1,2));
    private String[] columnas = {"Nombre","puntuación"};

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
        panelBotones.setLayout(new GridLayout(7,1));
        panelBotones.add(this.panelBotonestipos);
        rbtn1t=new JRadioButton("Personal",true);
        rbtn1t.setActionCommand("Personal");
        rbtn2t=new JRadioButton("Global",true);
        rbtn2t.setActionCommand("Global");
        rbtn1=new JRadioButton("Fácil",true);
        rbtn1.setActionCommand("Fácil");
        rbtn2=new JRadioButton("Medio",false);
        rbtn2.setActionCommand("Medio");
        rbtn3=new JRadioButton("Difícil",false);
        rbtn3.setActionCommand("Dificil");
        rbtn4=new JRadioButton("Absoluto",false);
        rbtn4.setActionCommand("Absoluto");
        grupo2 = new ButtonGroup();
        grupo2.add(rbtn1t);
        grupo2.add(rbtn2t);
        panelBotonestipos.add(rbtn1t);
        panelBotonestipos.add(rbtn2t);
        grupo1 = new ButtonGroup();
        grupo1.add(rbtn1);
        grupo1.add(rbtn2);
        grupo1.add(rbtn3);
        grupo1.add(rbtn4);
        panelBotones.add(rbtn1);
        panelBotones.add(rbtn2);
        panelBotones.add(rbtn3);
        panelBotones.add(rbtn4);
        btnVer = new JButton("Mostrar");
        btnVer.addActionListener(Controlador.getControlador());
        btnVolver= new JButton("Volver");
        btnVolver.addActionListener(Controlador.getControlador());
        btnVolver.setMaximumSize(new Dimension(300,30));
        panelBotones.add(btnVer);
        panelBotones.add(btnVolver);
        add(ranking);

        
        
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
public JTable generarRanking(JSONArray json){
    Object[][] a= new Object[json.length()][2];
    JSONObject objeto ;
    String user;
    String puntuacion;
    String[] c;
    for(int i=0;i<=json.length()-1;i++){
        objeto = json.getJSONObject(i);
        user= objeto.getString("user");
        puntuacion= String.valueOf(objeto.getInt("puntuacion"));
        String[] f= {user,puntuacion};
        a[i]=f;
    }
    ranking.removeAll();
    JTable ntab= new JTable(a,columnas); 
    ranking.add(ntab);
    ranking.add(new JScrollPane(ntab));
    ranking.updateUI();
    return null;
}
public String getdif(){
    return grupo1.getSelection().getActionCommand();
}
public String getTip(){
    return grupo2.getSelection().getActionCommand();
}
}

