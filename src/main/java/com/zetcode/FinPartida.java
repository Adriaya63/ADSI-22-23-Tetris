package com.zetcode;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinPartida extends JFrame {
  private String userName;
  private int score;
  private Date date;
 
  
  public FinPartida(String userName, int score) {
    this.userName = userName;
    this.score = score;
    this.date = new Date();
  
    
    // Configuramos la ventana
    setTitle("Datos de la partida");
    setSize(new Dimension(300, 150));
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    // Creamos un panel para la información del usuario
    JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    // Creamos los componentes para mostrar la información
    JLabel userNameLabel = new JLabel("Nombre de usuario: " + userName);
    JLabel scoreLabel = new JLabel("Puntuación: " + score);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    JLabel dateLabel = new JLabel("Fecha: " + dateFormat.format(date));
    
    // Añadimos los componentes al panel
    userInfoPanel.add(userNameLabel);
    userInfoPanel.add(scoreLabel);
    userInfoPanel.add(dateLabel);
    
    // Creamos un panel para el botón de continuar
    JPanel buttonPanel = new JPanel();
    
    // Creamos el botón y lo configuramos
    JButton continueButton = new JButton("Continuar");
    continueButton.addActionListener(com.zetcode.Gestores.Controlador.getControlador());

    
    // Añadimos el botón al panel
    buttonPanel.add(continueButton);
    
    // Añadimos los paneles al marco
    add(userInfoPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
  }
  
  public static void main(String[] args) {
    FinPartida ui = new FinPartida("johndoe", 100);
    ui.setVisible(true);
  }
}
