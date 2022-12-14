package com.zetcode.Gestores;

import com.zetcode.Extensiones.Usuario_Conectado;

public class Gestor_niveles {
    private static Gestor_niveles miGestorNiveles;
    private Gestor_niveles(){}
    public static Gestor_niveles getMiGestorNiveles(){
        if(miGestorNiveles==null){
            miGestorNiveles= new Gestor_niveles();
        }
        return miGestorNiveles;
    }
    public void CambiarNivel(String nivel){
        Usuario_Conectado.modNivel(nivel);
    }
}
