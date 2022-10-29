package com.zetcode.Extensiones;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;

public class MenuRanking extends JFrame
{
    private JPanel contentPane;
    private JButton btnPersonal;
    private JButton btnGlobal;
    private JButton btnVolver;
    private static MenuRanking miMenuRanking;
    

    private MenuRanking()
    {
        contentPane = new JPanel();
        btnGlobal = new JButton("Ver Ranking Global");
        btnPersonal = new JButton("Ver Ranking Personal");
        btnVolver = new JButton("Volver");
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
    public void configurar()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
        contentPane.add(Box.createRigidArea(new Dimension(0, 100)));
		JLabel titulo = new JLabel("Menu Ranking");
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.add(titulo);
		contentPane.add(Box.createRigidArea(new Dimension(0, 100)));
		JButton btnGlobal = new JButton("Ranking global");
		btnGlobal.setAlignmentX(CENTER_ALIGNMENT);
        btnGlobal.setMinimumSize(new Dimension(10,10));
        btnGlobal.setMaximumSize(new Dimension(300,30));
        btnGlobal.setPreferredSize(new Dimension(150,20));
		contentPane.add(btnGlobal);
		contentPane.add(Box.createRigidArea(new Dimension(0, 30)));
		JButton btnPersonal = new JButton("Ranking Personal");
		btnPersonal.setAlignmentX(CENTER_ALIGNMENT);
        btnPersonal.setMaximumSize(new Dimension(300,30));
		contentPane.add(btnPersonal);
		contentPane.add(Box.createRigidArea(new Dimension(0, 30)));
		JButton btnVolver = new JButton("Volver");
		btnVolver.setAlignmentX(CENTER_ALIGNMENT);
        btnVolver.setMaximumSize(new Dimension(300,30));
		contentPane.add(btnVolver);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String args[]) {
        MenuRanking.getMiMenuRanking();
        }
}
