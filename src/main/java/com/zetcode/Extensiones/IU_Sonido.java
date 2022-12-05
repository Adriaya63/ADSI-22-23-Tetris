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
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;

public class IU_Sonido extends JFrame {
	private static IU_Sonido miSon;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	public static JButton bGuardar;
	public static JButton bVolver;
	private JPanel panel_1;
	public static JRadioButton rdbtnNewRadioButton;
	public static JRadioButton rdbtnNewRadioButton_1;
	public static JRadioButton rdbtnNewRadioButton_2;
	private boolean estado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Sonido frame = new IU_Sonido();
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
	public static IU_Sonido getMiSon() {
		if(miSon==null){
			miSon = new IU_Sonido();
		}
		return miSon;
	}

	private IU_Sonido() {
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
			lblNewLabel = new JLabel("Personalizar Sonido");
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
			panel_1.add(getRdbtnNewRadioButton_1());
			panel_1.add(getRdbtnNewRadioButton_2());
			panel_1.add(getRdbtnNewRadioButton());
		}
		return panel_1;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("New radio button");
			rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
			rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return rdbtnNewRadioButton_1;
	}
	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
			rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return rdbtnNewRadioButton_2;
	}
}
