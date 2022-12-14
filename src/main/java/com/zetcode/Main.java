package com.zetcode;
import java.awt.EventQueue;
import com.zetcode.Extensiones.IU_MenuRegistroInicio;

public class Main {
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_MenuRegistroInicio.getMiMenuRegistroInicio().alternar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        }

        
}
