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
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {


	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel_1;
	public static JTextField textFieldUser;
	private JLabel lblNewLabel_1_1;
	public static JTextField textFieldPass;
	public static JButton bLog;
	public static JButton bVolver;
	public static JButton bRegistro;
	private static Login miLogin;
	private boolean estado=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static Login getMiLogin()
    {
        if(miLogin == null)
        {
            miLogin = new Login();
        }
        return miLogin;
    }
	public  void alternar(){
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getLblNewLabel(), BorderLayout.NORTH);
		contentPane.add(getPanel_2(), BorderLayout.SOUTH);
		contentPane.add(getPanel_1_1(), BorderLayout.CENTER);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Login");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JPanel getPanel_2() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBLog());
			panel.add(getBVolver());
			panel.add(getBRegistro());
		}
		return panel;
	}
	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(4, 0, 0, 0));
			panel_1.add(getPanel_2_1());
			panel_1.add(getPanel_3());
			panel_1.add(getPanel_4());
			panel_1.add(getPanel_5());
		}
		return panel_1;
	}
	private JPanel getPanel_2_1() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getLblNewLabel_1_1());
			panel_3.add(getTextFieldPass());
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.add(getLblNewLabel_1());
			panel_4.add(getTextFieldUser());
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
		}
		return panel_5;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Usuario");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblNewLabel_1;
	}
	private JTextField getTextFieldUser() {
		if (textFieldUser == null) {
			textFieldUser = new JTextField();
			textFieldUser.setColumns(10);
		}
		return textFieldUser;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Contrase\u00F1a");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTextFieldPass() {
		if (textFieldPass == null) {
			textFieldPass = new JTextField();
			textFieldPass.setColumns(10);
		}
		return textFieldPass;
	}
	private JButton getBLog() {
		if (bLog == null) {
			bLog = new JButton("Login");
			bLog.addActionListener(Controlador.getControlador());
		}
		return bLog;
	}
	private JButton getBVolver() {
		if (bVolver == null) {
			bVolver = new JButton("Volver");
			bVolver.addActionListener(Controlador.getControlador());
		}
		return bVolver;
	}
	private JButton getBRegistro() {
		if (bRegistro == null) {
			bRegistro = new JButton("Registrarse");
			bRegistro.addActionListener(Controlador.getControlador());
		}
		return bRegistro;
	}

}