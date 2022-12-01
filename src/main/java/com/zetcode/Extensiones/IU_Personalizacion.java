package com.zetcode.Extensiones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class IU_Personalizacion extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JButton bAceptar;
	private JPanel panel_1;
	private JRadioButton rbSonido;
	private JRadioButton rbFondo;
	private JRadioButton rbLadrillos;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Personalizacion frame = new IU_Personalizacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IU_Personalizacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getLblNewLabel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getPanel_1_1(), BorderLayout.CENTER);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Menu Personalizaci\u00F3n");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBAceptar());
		}
		return panel;
	}
	private JButton getBAceptar() {
		if (bAceptar == null) {
			bAceptar = new JButton("Aceptar");
		}
		return bAceptar;
	}
	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(3, 0, 0, 0));
			panel_1.add(getRbFondo());
			panel_1.add(getRbLadrillos());
			panel_1.add(getRbSonido());
		}
		return panel_1;
	}
	private JRadioButton getRbSonido() {
		if (rbSonido == null) {
			rbSonido = new JRadioButton("Sonido");
			buttonGroup.add(rbSonido);
			rbSonido.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return rbSonido;
	}
	private JRadioButton getRbFondo() {
		if (rbFondo == null) {
			rbFondo = new JRadioButton("Fondo");
			buttonGroup.add(rbFondo);
			rbFondo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return rbFondo;
	}
	private JRadioButton getRbLadrillos() {
		if (rbLadrillos == null) {
			rbLadrillos = new JRadioButton("Ladrillos");
			buttonGroup.add(rbLadrillos);
			rbLadrillos.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return rbLadrillos;
	}
}