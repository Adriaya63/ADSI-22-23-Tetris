package com.zetcode;
import java.awt.event.*;

import javax.swing.JOptionPane;


import com.zetcode.Extensiones.IU_Fondo;
import com.zetcode.Extensiones.IU_Ladrillos;
import com.zetcode.Extensiones.IU_Personalizacion;
import com.zetcode.Extensiones.IU_Sonido;
import com.zetcode.Extensiones.IU_Login;
import com.zetcode.Extensiones.IU_Menu;
import com.zetcode.Extensiones.IU_MenuRegistroInicio;
import com.zetcode.Extensiones.IU_Niveles;
import com.zetcode.Extensiones.IU_Ranking;
import com.zetcode.Extensiones.IU_Registro;
import com.zetcode.Extensiones.Usuario_Conectado;
import com.zetcode.Gestores.Gestor_Personalizacion;
import com.zetcode.Gestores.Gestor_Usuarios;
import com.zetcode.Gestores.Gestor_niveles;
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
			if(e.getSource().equals(IU_Menu.btncloseSession)){
				Usuario_Conectado.cerrarSesion();
				IU_Menu.getMiMenu().alternar();
				
				IU_MenuRegistroInicio.getMiMenuRegistroInicio().alternar();
			}
			if(e.getSource().equals(IU_Menu.btnPswd)){
				String pswd = JOptionPane.showInputDialog("Ingresa tu la nueva contraseña ");
				Gestor_Usuarios.getMiGestorUser().changepassword(pswd);
						
						}
			if(e.getSource().equals(IU_Login.bLog)){
				String user = IU_Login.textFieldUser.getText();
				String pass = IU_Login.textFieldPass.getText();
				org.json.JSONObject userdata = Gestor_Usuarios.getMiGestorUser().buscarUser(user, pass);
				if(Usuario_Conectado.geyMiUser().initUser(userdata)){
					IU_Menu.getMiMenu().alternar();
					IU_Login.getMiLogin().cerrar();
				}

				
			}
			if (e.getSource().equals(IU_Login.bVolver)) {
				IU_Login.getMiLogin().alternar();
				// MenuRegistroInicio.get
				IU_MenuRegistroInicio.getMiMenuRegistroInicio().alternar();
				break;
			}
			if(e.getSource().equals(IU_Registro.bReg)){
				String user = IU_Registro.textFieldUser.getText();
				if(!Gestor_Usuarios.getMiGestorUser().existeUser(user)){
					String pass = IU_Registro.textFieldPass.getText();
					String email = IU_Registro.textFieldEmail.getText();
					Gestor_Usuarios.getMiGestorUser().insertarUsuario(user, pass, email);
				}else{System.out.println("El usuario ya existe");}
				break;
			}
			if (e.getSource().equals(IU_Registro.bVolver)) {
				IU_Registro.getMiRegitro().alternar();
				IU_MenuRegistroInicio.getMiMenuRegistroInicio().alternar();

				break;
			}
			if (e.getSource().equals(IU_Registro.bLog)) {
				IU_Registro.getMiRegitro().alternar();
				IU_Login.getMiLogin().alternar();

				break;
			}
			if (e.getSource().equals(IU_Login.bRegistro)) {
				IU_Login.getMiLogin().alternar();
				IU_Registro.getMiRegitro().alternar();
				// Registro.alternar
				break;
			}
        if (e.getSource().equals(IU_Menu.btnRanking)) {
			IU_Ranking.getmiRanking().alternar();
			IU_Menu.getMiMenu().alternar();
			break;
        }
		if (e.getSource().equals(IU_Ranking.btnVer)) {
			String tipo= IU_Ranking.getmiRanking().getTip();
			String dif = IU_Ranking.getmiRanking().getdif();
			System.out.println(dif);
			if(tipo=="Global"){
				IU_Ranking.getmiRanking().Update(Gestor_ranking.getmiGestorRanking().generarRanking(dif,tipo));
			}
			else{
				IU_Ranking.getmiRanking().Update(Gestor_ranking.getmiGestorRanking().generarRanking(dif,Usuario_Conectado.geyMiUser().getNombre()));
			}
			break;
        }
		if (e.getSource().equals(IU_Ranking.btnVolver)) {
			IU_Menu.getMiMenu().alternar();
			
			IU_Ranking.getmiRanking().alternar();
			break;
        }
		if (e.getSource().equals(IU_Menu.btnJugar)){
			IU_Menu.getMiMenu().alternar();
			Tetris.jugar();
			break;
		}

        if(e.getSource().equals(IU_Niveles.getBtn_facil()))
		{
			System.out.println("BOTON FACIL SELECCIONADO\n");
			IU_Niveles.getBtn_seleccionar().setEnabled(true);
			break;
		}
        if(e.getSource().equals(IU_Niveles.getBtn_medio()))
        {
            System.out.println("BOTON MEDIO SELECCIONADO\n");
            IU_Niveles.getBtn_seleccionar().setEnabled(true);
			break;
        }    
        if(e.getSource().equals(IU_Niveles.getBtn_dificil()))
        {
            System.out.println("BOTON DIFICIL SELECCIONADO\n");
            IU_Niveles.getBtn_seleccionar().setEnabled(true);
			break;
        }
        if(e.getSource().equals(IU_Niveles.getBtn_volver()))
        {
            System.out.println("BOTON VOLVER SELECCIONADO\n");
			IU_Niveles.getNiveles().dispose();
            IU_Menu.getMiMenu().alternar();
			break;
            
        }
        if(e.getSource().equals(IU_Niveles.getBtn_seleccionar()))
        {
            System.out.println("BOTON SELECCIONAR SELECCIONADO\n");
            if(IU_Niveles.getBtn_dificil().isSelected()){
				IU_Niveles.getNiveles().dispose();
                Gestor_niveles.getMiGestorNiveles().CambiarNivel("Difícil");
				IU_Menu.getMiMenu().alternar();
            }
			if(IU_Niveles.getBtn_medio().isSelected()){
				IU_Niveles.getNiveles().dispose();
                Gestor_niveles.getMiGestorNiveles().CambiarNivel("Medio");
				IU_Menu.getMiMenu().alternar();
            }
            else if(IU_Niveles.getBtn_facil().isSelected()){
				IU_Niveles.getNiveles().dispose();
				Gestor_niveles.getMiGestorNiveles().CambiarNivel("Fácil");
				IU_Menu.getMiMenu().alternar();
            }
			break;
        }
		if (e.getSource().equals(IU_MenuRegistroInicio.btnNewButton)) {
			IU_MenuRegistroInicio.getMiMenuRegistroInicio().alternar();

			IU_Login.getMiLogin().alternar();
			break;
		}
		if (e.getSource().equals(IU_Login.getMiLogin().btnRecuperarPassword)) {
			String nombre = JOptionPane.showInputDialog("Ingresa el usuario asociado: ");
			Gestor_Usuarios.getMiGestorUser().recuperarPswd(nombre);
		}
		if (e.getSource().equals(IU_MenuRegistroInicio.btnNewButton_1)) {
			IU_MenuRegistroInicio.getMiMenuRegistroInicio().alternar();

			IU_Registro.getMiRegitro().alternar();
			break;
		}
		if (e.getSource().equals(IU_Menu.btnEliminarUsuarios)) {
			String nombre = JOptionPane.showInputDialog("Ingresa tu nombre: ");
			Gestor_Usuarios.getMiGestorUser().eliminarUsuario(nombre);
			break;
		}
		if (e.getSource().equals(IU_Menu.btnNivel)) {
			IU_Niveles.getNiveles().hacerVisible();
			IU_Menu.getMiMenu().alternar();
			break;
		}
		if(e.getSource().equals(IU_Menu.btnPersonalizar)){
			IU_Personalizacion.getMiPer().alternar();
			IU_Menu.getMiMenu().alternar();
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
			IU_Menu.getMiMenu().alternar();
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
			IU_Menu.getMiMenu().alternar();
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
			IU_Menu.getMiMenu().alternar();
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
			IU_Menu.getMiMenu().alternar();
		}
}
