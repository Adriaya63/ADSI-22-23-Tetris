package com.zetcode;
import java.awt.event.*;

import javax.swing.JOptionPane;


import com.zetcode.Extensiones.IU_Fondo;
import com.zetcode.Extensiones.IU_Ladrillos;
import com.zetcode.Extensiones.IU_Personalizacion;
import com.zetcode.Extensiones.IU_Sonido;
import com.zetcode.Extensiones.Login;
import com.zetcode.Extensiones.Menu;
import com.zetcode.Extensiones.MenuRegistroInicio;
import com.zetcode.Extensiones.Niveles;
import com.zetcode.Extensiones.Ranking;
import com.zetcode.Extensiones.Registro;
import com.zetcode.Extensiones.Usuario_Conectado;
import com.zetcode.Gestores.Gestor_Personalizacion;
import com.zetcode.Gestores.Gestor_Usuarios;
import com.zetcode.Gestores.Gestor_ranking;

public class Controlador implements ActionListener
{
	private static Controlador controler =null;

	private int seleccionPer=0;
	private int colorLad=0;
	private int fondo=0;

	private Controlador() {};
	
	public static Controlador getControlador()
	{
		if(controler==null)
		{
			controler = new Controlador();
		}
		return controler;
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        while(true){
			if(e.getSource().equals(Login.bLog)){
				String user = Login.textFieldUser.getText();
				String pass = Login.textFieldPass.getText();
				org.json.JSONObject userdata = Gestor_Usuarios.getMiGestorUser().buscarUser(user, pass);
				if(Usuario_Conectado.geyMiUser().initUser(userdata)){
					Menu.getMiMenu().alternar();
					Login.getMiLogin().alternar();
				}

				
			}
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
			
			Menu.getMiMenu().alternar();
			break;
        }
		if (e.getSource().equals(Ranking.btnVer)) {
			String tipo= Ranking.getmiRanking().getTip();
			String dif = Ranking.getmiRanking().getdif();
			System.out.println(dif);
			if(tipo=="Global"){
				Ranking.getmiRanking().Update(Gestor_ranking.getmiGestorRanking().generarRanking(dif,tipo));
			}
			else{
				Ranking.getmiRanking().Update(Gestor_ranking.getmiGestorRanking().generarRanking(dif,Usuario_Conectado.geyMiUser().getNombre()));
			}
			break;
        }
		if (e.getSource().equals(Ranking.btnVolver)) {
			Menu.getMiMenu().alternar();
			
			Ranking.getmiRanking().alternar();
			break;
        }
		if (e.getSource().equals(Menu.btnJugar)){
			Niveles.getNiveles().hacerVisible();;
			Menu.getMiMenu().alternar();
			break;
		}

        if(e.getSource().equals(Niveles.getBtn_facil()))
		{
			System.out.println("BOTON FACIL SELECCIONADO\n");
			Niveles.getBtn_seleccionar().setEnabled(true);
			break;
		}
        if(e.getSource().equals(Niveles.getBtn_medio()))
        {
            System.out.println("BOTON MEDIO SELECCIONADO\n");
            Niveles.getBtn_seleccionar().setEnabled(true);
			break;
        }    
        if(e.getSource().equals(Niveles.getBtn_dificil()))
        {
            System.out.println("BOTON DIFICIL SELECCIONADO\n");
            Niveles.getBtn_seleccionar().setEnabled(true);
			break;
        }
        if(e.getSource().equals(Niveles.getBtn_volver()))
        {
            System.out.println("BOTON VOLVER SELECCIONADO\n");
			Niveles.getNiveles().dispose();
            Menu.getMiMenu().alternar();
			break;
            
        }
        if(e.getSource().equals(Niveles.getBtn_seleccionar()))
        {
            System.out.println("BOTON SELECCIONAR SELECCIONADO\n");
            if(Niveles.getBtn_dificil().isSelected()){
				Niveles.getNiveles().dispose();
                Tetris.jugar(150);
            }
			if(Niveles.getBtn_medio().isSelected()){
				Niveles.getNiveles().dispose();
                Tetris.jugar(300);
            }
            else if(Niveles.getBtn_facil().isSelected()){
				Niveles.getNiveles().dispose();
				Tetris.jugar(500);
            }
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
		if (e.getSource().equals(Menu.btnEliminarUsuarios)) {
			String nombre = JOptionPane.showInputDialog("Ingresa tu nombre: ");
			Gestor_Usuarios.getMiGestorUser().eliminarUsuario(nombre);
			break;
		}
		if(e.getSource().equals(Menu.btnPersonalizar)){
			IU_Personalizacion.getMiPer().alternar();
			Menu.getMiMenu().alternar();
			break;
		}
		if(e.getSource().equals(IU_Personalizacion.bAceptar)){
			if(seleccionPer==1){
				IU_Fondo.getMiFondo().alternar();
				IU_Personalizacion.getMiPer().alternar();
			}else if(seleccionPer==2){
				IU_Ladrillos.getMiLad().alternar();
				IU_Personalizacion.getMiPer().alternar();
			}else if(seleccionPer==3){
				IU_Sonido.getMiSon().alternar();
				IU_Personalizacion.getMiPer().alternar();
			}
			break;
		}
		if(e.getSource().equals(IU_Personalizacion.bVolver)){
			IU_Personalizacion.getMiPer().alternar();
			Menu.getMiMenu().alternar();
			break;
		}
		if(e.getSource().equals(IU_Personalizacion.rbFondo)){
			seleccionPer=1;
			break;
		}
		if(e.getSource().equals(IU_Personalizacion.rbLadrillos)){
			seleccionPer=2;
			break;
		}
		if(e.getSource().equals(IU_Personalizacion.rbSonido)){
			seleccionPer=3;
			break;
		}
		if(e.getSource().equals(IU_Fondo.bGuardar)){
			Usuario_Conectado.geyMiUser().cambiarFondo(fondo);
			IU_Fondo.getMiFondo().alternar();
			Menu.getMiMenu().alternar();
			break;
		}
		if(e.getSource().equals(IU_Fondo.rbFondo1)){fondo=1; break;}
		if(e.getSource().equals(IU_Fondo.rbFondo2)){fondo=2; break;}
		if(e.getSource().equals(IU_Fondo.rbFondo3)){fondo=3; break;}
		if(e.getSource().equals(IU_Fondo.bVolver)){
			IU_Fondo.getMiFondo().alternar();
			IU_Personalizacion.getMiPer().alternar();
			break;
		}
		if(e.getSource().equals(IU_Ladrillos.bGuardar)){
			Usuario_Conectado.geyMiUser().cambiarColores(colorLad);
			IU_Ladrillos.getMiLad().alternar();
			Menu.getMiMenu().alternar();
			break;
		}
		if(e.getSource().equals(IU_Ladrillos.bVolver)){
			IU_Ladrillos.getMiLad().alternar();
			IU_Personalizacion.getMiPer().alternar();
			break;
		}
		if(e.getSource().equals(IU_Ladrillos.rbDefault)){colorLad=1; break;}
		if(e.getSource().equals(IU_Ladrillos.rbClasic)){colorLad=2; break;}
		if(e.getSource().equals(IU_Ladrillos.rbBlack)){colorLad=3; break;}
		if(e.getSource().equals(IU_Sonido.bGuardar)){
			break;
		}
		if(e.getSource().equals(IU_Sonido.bVolver)){
			IU_Sonido.getMiSon().alternar();
			IU_Personalizacion.getMiPer().alternar();
			break;
		}
		else{
			break;
		}       
    }
       } 
	
		public void finalizarPartida(FinPartida f, String usuario, int puntuacion,String dif){
			f.dispose();
			Gestor_ranking.getmiGestorRanking().ingresarPuntuacion(Usuario_Conectado.geyMiUser().getNombre(), puntuacion, dif);
			Menu.getMiMenu().alternar();
		}
}
