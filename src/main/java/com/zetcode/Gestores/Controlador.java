package com.zetcode.Gestores;

import java.awt.event.*;

import com.zetcode.Tetris;
import com.zetcode.Extensiones.Login;
import com.zetcode.Extensiones.Menu;
import com.zetcode.Extensiones.MenuRegistroInicio;
import com.zetcode.Extensiones.Ranking;
import com.zetcode.Extensiones.Registro;

public class Controlador implements ActionListener {
	private static Controlador controler = null;

	private int dir = 0;

	private Controlador() {
	};

	public static Controlador getControlador() {
		if (controler == null) {
			controler = new Controlador();
		}
		return controler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		while (true) {
			if (e.getSource().equals(Login.bVolver)) {
				Login.getMiLogin().alternar();
				// MenuRegistroInicio.get
				MenuRegistroInicio.getMiMenuRegistroInicio().alternar();
				break;
			}
			if(e.getSource().equals(Registro.bReg)){
				String user = Registro.textFieldUser.getText();
				if(!Gestor_Usuarios.getMiGestorUser().existeUser(user)){
					String pass = Registro.textFieldPass.getText();
					String email = Registro.textFieldEmail.getText();
					Gestor_Usuarios.getMiGestorUser().insertarUsuario(user, pass, email);
				}else{System.out.println("El usuario ya existe");}
				break;
			}
			if (e.getSource().equals(Registro.bVolver)) {
				Registro.getMiRegitro().alternar();
				MenuRegistroInicio.getMiMenuRegistroInicio().alternar();

				break;
			}
			if (e.getSource().equals(Registro.bLog)) {
				Registro.getMiRegitro().alternar();
				Login.getMiLogin().alternar();

				break;
			}
			if (e.getSource().equals(Login.bRegistro)) {
				Login.getMiLogin().alternar();
				Registro.getMiRegitro().alternar();
				// Registro.alternar
				break;
			}
			if (e.getSource().equals(Menu.btnRanking)) {
				Ranking.getmiRanking().alternar();

				Menu.getMiMenuRanking().alternar();
				break;
			}
			if (e.getSource().equals(Ranking.btnVer)) {
				String tipo = Ranking.getmiRanking().getTip();
				String dif = Ranking.getmiRanking().getdif();
				System.out.println(dif);
				Ranking.getmiRanking().Update(Gestor_ranking.getmiGestorRanking().generarRanking(dif, tipo));
				break;
			}
			if (e.getSource().equals(Ranking.btnVolver)) {
				Menu.getMiMenuRanking().alternar();

				Ranking.getmiRanking().alternar();
				break;
			}
			if (e.getSource().equals(Menu.btnJugar)) {

				Tetris t = new Tetris();
				t.jugar();
				Menu.getMiMenuRanking().alternar();
				break;
			}
			if (e.getSource().equals(MenuRegistroInicio.btnNewButton)) {
				MenuRegistroInicio.getMiMenuRegistroInicio().alternar();

				Login.getMiLogin().alternar();
				break;
			}
			if (e.getSource().equals(MenuRegistroInicio.btnNewButton_1)) {
				MenuRegistroInicio.getMiMenuRegistroInicio().alternar();

				Registro.getMiRegitro().alternar();
				break;
			}
		}

	}

	public void annadirPuntuacionAlRanking(int numLinesRemoved) {
		String dificultad = "medio";
		String usuario = "Fran";
		Gestor_ranking.getmiGestorRanking().ingresarPuntuacion(usuario, numLinesRemoved, dificultad);

	}
}
