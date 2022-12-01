package com.zetcode.Extensiones;



import javax.swing.border.EmptyBorder;

import com.zetcode.Gestores.Controlador;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame
{
    public static JButton btnRanking;
    public static JButton btnJugar;
    public static JButton btnNivel;
    public static JButton btnPersonalizar;
    private static Menu miMenuRanking;
    private boolean estado=false;
    

    private Menu()
    {
        this.configurar();
    }
    public static Menu getMiMenuRanking()
    {
        if(miMenuRanking == null)
        {
            miMenuRanking = new Menu();
        }
        return miMenuRanking;
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
    public void configurar()
    {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("tetris.png"));
        Image imagen = icono.getImage();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);		
        setLocationRelativeTo(null);		
        setTitle("Menú ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));
        JPanel paneltexto=new JPanel(new GridLayout(1,1));
        JPanel panelbotones=new JPanel(new GridLayout(4,1));
        add(paneltexto);
        add(panelbotones);
        this.btnJugar= new JButton("Jugar");
        this.btnNivel= new JButton("Seleccionar Nivel");
        this.btnPersonalizar= new JButton("Personalizar Apariencia");
        this.btnRanking= new JButton("Ranking");
        panelbotones.add(btnJugar);
        panelbotones.add(btnNivel);
        panelbotones.add(btnPersonalizar);
        panelbotones.add(btnRanking);
        btnJugar.addActionListener(Controlador.getControlador());
        btnRanking.addActionListener(Controlador.getControlador());
        JTextArea texto= new JTextArea();
        texto.append("Programa realizado para la asignatura de ADSI");
        ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(500,500,Image.SCALE_SMOOTH));
        JLabel jLabel1 = new JLabel();
        jLabel1.setIcon(iconoEscalado);
        paneltexto.add(jLabel1);

    }

    public static void main(String args[]) {
        Menu.getMiMenuRanking().alternar();
        }


}
