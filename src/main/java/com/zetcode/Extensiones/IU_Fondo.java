package com.zetcode.Extensiones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zetcode.Gestores.Controlador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;

public class IU_Fondo extends JFrame {
	private static IU_Fondo miFondo;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	public static JButton bGuardar;
	public static JButton bVolver;
	private JPanel panel_1;
	public static JRadioButton rbFondo1;
	public static JRadioButton rbFondo2;
	public static JRadioButton rbFondo3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean estado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Fondo frame = new IU_Fondo();
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

	/**
	 * Create the frame.
	 */
	public static IU_Fondo getMiFondo() {
		if(miFondo==null){
			miFondo = new IU_Fondo();
		}
		return miFondo;
	}

	private IU_Fondo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getLblNewLabel(), BorderLayout.NORTH);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Personalizar Fondo");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBGuardar());
			panel.add(getBVolver());
		}
		return panel;
	}
	private JButton getBGuardar() {
		if (bGuardar == null) {
			bGuardar = new JButton("Guardar");
			bGuardar.addActionListener(Controlador.getControlador());
		}
		return bGuardar;
	}
	private JButton getBVolver() {
		if (bVolver == null) {
			bVolver = new JButton("Volver");
			bVolver.addActionListener(Controlador.getControlador());
		}
		return bVolver;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(3, 0, 0, 0));
			panel_1.add(getRbFondo2());
			panel_1.add(getRbFondo3());
			panel_1.add(getRbFondo1());
		}
		return panel_1;
	}
	private JRadioButton getRbFondo1() {
		if (rbFondo1 == null) {
			rbFondo1 = new JRadioButton("Fondo Negro");
			buttonGroup.add(rbFondo1);
			rbFondo1.setHorizontalAlignment(SwingConstants.CENTER);
			rbFondo1.addActionListener(Controlador.getControlador());
		}
		return rbFondo1;
	}
	private JRadioButton getRbFondo2() {
		if (rbFondo2 == null) {
			rbFondo2 = new JRadioButton("Fondo Madera");
			buttonGroup.add(rbFondo2);
			rbFondo2.setHorizontalAlignment(SwingConstants.CENTER);
			rbFondo2.addActionListener(Controlador.getControlador());
		}
		return rbFondo2;
	}
	private JRadioButton getRbFondo3() {
		if (rbFondo3 == null) {
			rbFondo3 = new JRadioButton("Fondo Blanco");
			buttonGroup.add(rbFondo3);
			rbFondo3.setHorizontalAlignment(SwingConstants.CENTER);
			rbFondo3.addActionListener(Controlador.getControlador());
		}
		return rbFondo3;
	}
}
