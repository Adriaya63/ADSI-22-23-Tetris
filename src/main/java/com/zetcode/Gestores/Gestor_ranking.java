package com.zetcode.Gestores;

import java.util.ArrayList;

public class Gestor_ranking {
    private static Gestor_ranking miGestorRanking;
    private Gestor_ranking(){}
    public static Gestor_ranking getmiGestorRanking(){
        if(miGestorRanking ==null){
            miGestorRanking =new Gestor_ranking();
        }
        return miGestorRanking;
    }
    public ArrayList<String> getlistaRanking(int tipo){

        
        ArrayList<String> lista = new ArrayList<>();
        if(tipo==1){
            for(int i=0;i<1000;i++){
            lista.add("Hola");
            }
        }
        else{
            for(int i=0;i<1000;i++){
                lista.add("ADios");
                }
        }
       
       return lista;
    }
}
