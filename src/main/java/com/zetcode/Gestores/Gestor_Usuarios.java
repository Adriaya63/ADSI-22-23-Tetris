package com.zetcode.Gestores;


import com.zetcode.Extensiones.EmailSenderService;
import com.zetcode.Extensiones.Usuario_Conectado;
import org.json.JSONObject;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


public class Gestor_Usuarios {
    private static Gestor_Usuarios miGestorUser;

    private Gestor_Usuarios() {
    }

    public static Gestor_Usuarios getMiGestorUser() {
        if (miGestorUser == null) {
            miGestorUser = new Gestor_Usuarios();
        }
        return miGestorUser;
    }

    public void changepassword(String pPswd) {
        if (pPswd != "") {
            String consulta = String.format("Update usuario set pswd ='%s' where nombre ='%s'", pPswd, Usuario_Conectado.geyMiUser().getNombre());
            BD.sqlvoid(consulta);
            System.out.println("Contraseña actualizada");
        } else {
            System.out.println("Contraseña no válida");
        }
    }

    public boolean existeUser(String user) {
        if (user != null) {
            String consulta = String.format("SELECT FROM usuario WHERE user='%s'", user);
            ResultSet rs = BD.selectSql(consulta);
            try {
                if (rs.next()) {
                    return true;
                }

            } catch (Exception e) {
                System.out.println("Error en la conexión");
            }
        }
        return false;
    }

    public JSONObject buscarUser(String user, String pass) {
        String consulta = String.format("SELECT * FROM usuario WHERE Nombre='%s' AND pswd='%s'", user, pass);
        JSONObject userData = new JSONObject();
        try {

            ResultSet rs = BD.selectSql(consulta);
            if (rs.next()) {
                int col = rs.getMetaData().getColumnCount();
                for (int i = 0; i < col; i++) {
                    userData.put(rs.getMetaData().getColumnLabel(i + 1), rs.getObject(i + 1));
                }
            } else {
                System.out.println("El usuario y la contraseña no son correctos");
            }
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return userData;
    }

    public void insertarUsuario(String user, String password, String email) {
        if (user != null && password != null && email != null) {
            String consulta = String.format("INSERT INTO usuario VALUES('%s', '%s', '%s',0,1,1)", user, email, password);

            BD.sqlvoid(consulta);
            System.out.println("registered");
        }
    }

    public void eliminarUsuario(String user) {
        if (!user.equals("admin") && user!= Usuario_Conectado.geyMiUser().getNombre()) {
            String consulta = String.format("delete from usuario where nombre ='%s'", user);
            BD.sqlvoid(consulta);
            System.out.println("Jugador eliminado");
        } else {
            System.out.println("Este jugador no se puede eliminar");
        }
    }

    public void recuperarPswd(String usuario) {
        String email = "";
        if (usuario != "") {
            String consulta = String.format("Select email from usuario where nombre='%s'", usuario);
            try {
                ResultSet rs = BD.selectSql(consulta);
                rs.next();
                email = rs.getString("email");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Random random = new Random();

            // Crea una cadena vacía donde se almacenará la contraseña
            String codigo = "";

            // Genera 20 caracteres aleatorios y agrégalos a la contraseña
            for (int i = 0; i < 20; i++) {
                int character = random.nextInt(26); // Genera un número aleatorio entre 0 y 25
                codigo += (char) ('a' + character); // Convierte el número en un carácter y agrégalo a la contraseña
            }
            EmailSenderService.enviarConGMail(email, "Código para restablecer la contraseña", "Introduzca este código para cambiar la contraseña: " + codigo);
            System.out.print("Se ha enviado un mail a la persona asociada a la cuenta \n");
            String codigo2 = JOptionPane.showInputDialog("Ingrese el código que le ha llegado al email ");
            if (codigo.equals(codigo2)) {
                String npass = JOptionPane.showInputDialog("Ingrese la nueva contraseña ");
                String consulta2 = String.format("Update usuario set pswd ='%s' where nombre ='%s'", npass, usuario);
                BD.sqlvoid(consulta2);
                System.out.println("Contraseña actualizada");
            }


        }

    }


}