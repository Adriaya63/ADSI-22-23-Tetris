package com.zetcode.Extensiones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zetcode.Controlador;

import javax.swing.JLabel;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class IU_Personalizacion extends JFrame {

	private static IU_Personalizacion miPer;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	public static JButton bAceptar;
	public static JButton bVolver;
	private JPanel panel_1;
	public static JRadioButton rbSonido;
	public static JRadioButton rbFondo;
	public static JRadioButton rbLadrillos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean estado = false;

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

	public static IU_Personalizacion getMiPer(){
		if(miPer==null){
			miPer = new IU_Personalizacion();
		}
		return miPer;
	}

	/**
	 * Create the frame.
	 */
	private IU_Personalizacion() {
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
			panel.add(getBVolver());
		}
		return panel;
	}
	private JButton getBAceptar() {
		if (bAceptar == null) {
			bAceptar = new JButton("Aceptar");
			bAceptar.addActionListener(Controlador.getControlador());
		}
		return bAceptar;
	}
	private JButton getBVolver() {
		if (bVolver == null) {
			bVolver = new JButton("Volver");
			bVolver.addActionListener(Controlador.getControlador());
		}
		return bVolver;
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
			rbSonido.addActionListener(Controlador.getControlador());
		}
		return rbSonido;
	}
	private JRadioButton getRbFondo() {
		if (rbFondo == null) {
			rbFondo = new JRadioButton("Fondo");
			buttonGroup.add(rbFondo);
			rbFondo.setHorizontalAlignment(SwingConstants.CENTER);
			rbFondo.addActionListener(Controlador.getControlador());
		}
		return rbFondo;
	}
	private JRadioButton getRbLadrillos() {
		if (rbLadrillos == null) {
			rbLadrillos = new JRadioButton("Ladrillos");
			buttonGroup.add(rbLadrillos);
			rbLadrillos.setHorizontalAlignment(SwingConstants.CENTER);
			rbLadrillos.addActionListener(Controlador.getControlador());
		}
		return rbLadrillos;
	}
}