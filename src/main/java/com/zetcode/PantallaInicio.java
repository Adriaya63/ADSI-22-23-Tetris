package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class PantallaInicio extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtIntroduceTuEmail;
	private JLabel lblNewLabel_5;
	private JTextField textField_1;
	private JLabel lblNewLabel_6;
	private JTextField textField_2;
	private JLabel lblNewLabel_7;
	private JTextField textField_3;
	private JLabel lblNewLabel_8;
	private JTextField textField_4;
	private JLabel lblNewLabel_9;
	private JButton btnNewButton;
	private JLabel lblNewLabel_10;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio frame = new PantallaInicio();
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
	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 4, 0, 0));
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getTxtIntroduceTuEmail());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getTextField_1());
		contentPane.add(getLblNewLabel_6());
		contentPane.add(getTextField_2());
		contentPane.add(getLblNewLabel_7());
		contentPane.add(getTextField_3());
		contentPane.add(getLblNewLabel_8());
		contentPane.add(getTextField_4());
		contentPane.add(getLblNewLabel_9());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblNewLabel_10());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getLblNewLabel_11());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("REGISTRARSE");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("INICIAR SESI\u00D3N");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("EMAIL");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_4;
	}
	private JTextField getTxtIntroduceTuEmail() {
		if (txtIntroduceTuEmail == null) {
			txtIntroduceTuEmail = new JTextField();
			txtIntroduceTuEmail.setToolTipText("");
			txtIntroduceTuEmail.setBackground(new Color(255, 255, 255));
			txtIntroduceTuEmail.setColumns(10);
		}
		return txtIntroduceTuEmail;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("USUARIO");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_5;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("USUARIO");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_6;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("CONTRASE\u00D1A");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_7;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("CONTRASE\u00D1A");
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_8;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("");
		}
		return lblNewLabel_9;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Iniciar sesi\u00F3n");
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel("");
		}
		return lblNewLabel_10;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Registrase");
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("");
		}
		return lblNewLabel_11;
	}
}
