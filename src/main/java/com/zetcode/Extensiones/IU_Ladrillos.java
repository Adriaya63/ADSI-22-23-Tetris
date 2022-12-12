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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;

public class IU_Ladrillos extends JFrame {
	private static IU_Ladrillos miLad;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	public static JButton bGuardar;
	public static JButton bVolver;
	private JPanel panel_1;
	public static JRadioButton rbDefault;
	public static JRadioButton rbClasic;
	public static JRadioButton rbBlack;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean estado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Ladrillos frame = new IU_Ladrillos();
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
	public static IU_Ladrillos getMiLad() {
		if(miLad==null){
			miLad = new IU_Ladrillos();
		}
		return miLad;
	}

	private IU_Ladrillos() {
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
			lblNewLabel = new JLabel("Personalizar Ladrillo");
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
			bVolver = new JButton("Vover");
			bVolver.addActionListener(Controlador.getControlador());
		}
		return bVolver;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(3, 0, 0, 0));
			panel_1.add(getRbDefault());
			panel_1.add(getRbBlack());
			panel_1.add(getRbClasic());
		}
		return panel_1;
	}
	private JRadioButton getRbDefault() {
		if (rbDefault == null) {
			rbDefault = new JRadioButton("Default");
			buttonGroup.add(rbDefault);
			rbDefault.setHorizontalAlignment(SwingConstants.CENTER);
			rbDefault.addActionListener(Controlador.getControlador());
		}
		return rbDefault;
	}
	private JRadioButton getRbClasic() {
		if (rbClasic == null) {
			rbClasic = new JRadioButton("Clasic");
			buttonGroup.add(rbClasic);
			rbClasic.setHorizontalAlignment(SwingConstants.CENTER);
			rbClasic.addActionListener(Controlador.getControlador());
		}
		return rbClasic;
	}
	private JRadioButton getRbBlack() {
		if (rbBlack == null) {
			rbBlack = new JRadioButton("Black");
			buttonGroup.add(rbBlack);
			rbBlack.setHorizontalAlignment(SwingConstants.CENTER);
			rbBlack.addActionListener(Controlador.getControlador());
		}
		return rbBlack;
	}
}