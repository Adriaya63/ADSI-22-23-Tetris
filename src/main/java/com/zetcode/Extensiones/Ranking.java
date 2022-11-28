package com.zetcode.Extensiones;
import javax.swing.border.EmptyBorder;
import javax.swing.text.TabSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zetcode.Gestores.Controlador;
import com.zetcode.Gestores.Gestor_ranking;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class Ranking extends JFrame {
    private JPanel panelBotones= new JPanel();
    private JPanel panelBotonestipos= new JPanel(new GridLayout(1,2));
    private JTable tabla;
    public static JButton btnVolver;
    private boolean estado=false;
    public static JButton btnVer;
    boolean iniciado=false;
    private static Ranking miRanking;
    private JPanel ranking =new JPanel(new GridLayout(1,2));
    private String[] columnas = {"Puesto","puntuación"};
    private String[][] filas= {{"Puesto","puntuación"},{"Puesto","puntuación"}};
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
        
        add(ranking);
        
        tabla=new JTable(filas,columnas);
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
    tabla= new JTable(a,columnas);
    ranking.remove(tabla);
    ranking.getGraphics();
    return null;
}

}

