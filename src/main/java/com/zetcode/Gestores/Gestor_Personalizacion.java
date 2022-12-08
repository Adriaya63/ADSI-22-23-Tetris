package com.zetcode.Gestores;

import java.awt.Color;

public class Gestor_Personalizacion {
    private static Gestor_Personalizacion miPer;

    private Color colorsDefault[] = { new Color(0, 0, 0), new Color(204, 102, 102),
        new Color(102, 204, 102), new Color(102, 102, 204),
        new Color(204, 204, 102), new Color(204, 102, 204),
        new Color(102, 204, 204), new Color(218, 170, 0)
    };
    private Color colorsClasic[] = { new Color(0, 0, 0), new Color(255, 255, 255),
        new Color(255, 255, 255), new Color(255, 255, 255),
        new Color(255, 255, 255), new Color(255, 255, 255),
        new Color(255, 255, 255), new Color(255, 255, 255)
    };
    private Color colorsBlack[] = { new Color(0, 0, 0), new Color(10, 10, 10),
        new Color(10, 10, 10), new Color(10, 10, 10),
        new Color(10, 10, 10), new Color(10, 10, 10),
        new Color(10, 10, 10), new Color(10, 10, 10)
    }; 

    public Color colors[] = colorsDefault;
    public String imgName = "img/Fondo1.jpg";

    public static Gestor_Personalizacion getGestorPer() {
        if(miPer==null){
            miPer = new Gestor_Personalizacion();
        }
        return miPer;
    }

    public void cambiarColor(int n){
        if(n==1){colors=colorsDefault;}
        else if(n==2){colors=colorsClasic;}
        else if(n==3){colors=colorsBlack;}
    }

    public void cambiarImgFondo(int n){
        if(n==1){imgName="img/Fondo1.jpg";}
        else if(n==2){imgName="img/Fondo2.jpg";}
        else if(n==3){imgName="img/Fondo3.jpg";}
    }


}
