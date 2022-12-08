package com.zetcode.Gestores;

import com.zetcode.Extensiones.Menu;

public class Gestor_Usuarios {
    private static Gestor_Usuarios miGestor_Usuarios;

public Gestor_Usuarios(){}
public static Gestor_Usuarios getmiGestorRanking(){
    if( miGestor_Usuarios ==null){
        miGestor_Usuarios =new Gestor_Usuarios();
    }
    return  miGestor_Usuarios;
}
public void addUser(String nombre, String email, String password) {
    
  }


public boolean authenticate(String username, String password) {
    
    return true;//user != null && user.getPassword().equals(password);
}
private String buscarPasswordUsuario(){
    return "";
}

}
