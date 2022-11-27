package com.zetcode.Extensiones;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;

import com.zetcode.Gestores.Controlador;
import com.zetcode.Gestores.Gestor_ranking;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Ranking extends JFrame {
    private JPanel panelBotones= new JPanel();
    private JPanel panelBotonestipos= new JPanel(new GridLayout(1,2));
    private JTable tabla;
    public static JButton btnVolver;
    private boolean estado=false;
    public static JButton btnVer;
    boolean iniciado=false;
    private static Ranking miRanking;
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
        btnVer = new JButton("Mostrar");
        btnVer.addActionListener(Controlador.getControlador());
        btnVolver= new JButton("Volver");
        btnVolver.addActionListener(Controlador.getControlador());
        btnVolver.setMaximumSize(new Dimension(300,30));
        panelBotones.add(btnVer);
        panelBotones.add(btnVolver);
        JPanel ranking =new JPanel(new GridLayout(1,2));
        add(ranking);
        tabla=this.generarRanking();
        ranking.add(tabla);
        ranking.add(new JScrollPane(tabla));
        

        
        
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
    String[] columnas = {"Puesto","Nombre","puntuación"};
    Object[][] filas= {{1,"Juan",30},{2,"María",20}};
    JTable tabla =new JTable(filas,columnas);
    return tabla;
}
private Object[][] ordenar(JSONArray json){
    
    for(Object a:json){

    }
}

}
