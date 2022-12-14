package com.zetcode.Extensiones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zetcode.Controlador;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.*;

public class IU_MenuRegistroInicio extends JFrame {

	private static IU_MenuRegistroInicio miMenuRegistroInicio;
	private JPanel contentPane;
	private JPanel panel;
	public static JButton btnNewButton;
	public static JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private boolean estado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		IU_MenuRegistroInicio.getMiMenuRegistroInicio().alternar();
	}

	public static IU_MenuRegistroInicio getMiMenuRegistroInicio() {
		if (miMenuRegistroInicio == null) {
			miMenuRegistroInicio = new IU_MenuRegistroInicio();
		}
		return miMenuRegistroInicio;
	}

	public void alternar() {
		if (estado) {
			setVisible(false);
			estado = false;
		} else {
			setVisible(true);
			estado = true;
		}
	}

	/**
	 * Create the frame.
	 */
	public IU_MenuRegistroInicio() {
		
		
        setSize(435, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			
			
			panel.setLayout(null);
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
			panel.add(getLblNewLabel());
		}
		return panel;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("INICIA SESI\u00D3N");
			btnNewButton.setBounds(10, 163, 193, 56);
			btnNewButton.addActionListener(Controlador.getControlador());
		}
		return btnNewButton;
	}

	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("REGISTRATE");
			btnNewButton_1.setBounds(213, 163, 203, 56);
			btnNewButton_1.addActionListener(Controlador.getControlador());

		}
		return btnNewButton_1;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("TETRIS");
			lblNewLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD | Font.ITALIC, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 51, 406, 75);
		}
		return lblNewLabel;
	}
}