package com.zetcode.Extensiones;



import javax.swing.border.EmptyBorder;

import com.zetcode.Gestores.Controlador;

import javax.swing.*;
import java.awt.*;

public class MenuRanking extends JFrame
{
    private JPanel contentPane;
    public static JButton btnPersonal;
    public static JButton btnGlobal;
    public static JButton btnVolver;
    private static MenuRanking miMenuRanking;
    private boolean estado=false;
    

    private MenuRanking()
    {
        contentPane = new JPanel();
        this.configurar();
    }
    public static MenuRanking getMiMenuRanking()
    {
        if(miMenuRanking == null)
        {
            miMenuRanking = new MenuRanking();
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
        System.out.println(pantalla);
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);		
        setLocationRelativeTo(null);		
        setTitle("Menú Ranking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
        contentPane.add(Box.createRigidArea(new Dimension(0, 100)));
		JLabel titulo = new JLabel("Menu Ranking");
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.add(titulo);
		contentPane.add(Box.createRigidArea(new Dimension(0, 100)));
		btnGlobal = new JButton("Ranking global");
        btnGlobal.addActionListener(Controlador.getControlador());
		btnGlobal.setAlignmentX(CENTER_ALIGNMENT);
        btnGlobal.setMinimumSize(new Dimension(10,10));
        btnGlobal.setMaximumSize(new Dimension(300,30));
        btnGlobal.setPreferredSize(new Dimension(150,20));
		contentPane.add(btnGlobal);
		contentPane.add(Box.createRigidArea(new Dimension(0, 30)));
		btnPersonal = new JButton("Ranking Personal");
		btnPersonal.setAlignmentX(CENTER_ALIGNMENT);
        btnPersonal.setMaximumSize(new Dimension(300,30));
        btnPersonal.addActionListener(Controlador.getControlador());
		contentPane.add(btnPersonal);
		contentPane.add(Box.createRigidArea(new Dimension(0, 30)));
		btnVolver = new JButton("Volver");
		btnVolver.setAlignmentX(CENTER_ALIGNMENT);
        btnVolver.setMaximumSize(new Dimension(300,30));
        btnVolver.addActionListener(Controlador.getControlador());
		contentPane.add(btnVolver);
        setResizable(true);
    }

    public static void main(String args[]) {
        MenuRanking.getMiMenuRanking().alternar();
        }


}
