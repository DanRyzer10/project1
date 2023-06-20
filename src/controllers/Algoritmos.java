package controllers;

import views.VentanaPrincipal;
import static views.VentanaPrincipal.panelPrincipal;

import javax.swing.*;
import java.util.Arrays;

public class Algoritmos {

    public static void desordenar(int[] array){
        for(int i=0;i<array.length;i++){
            int random = (int)(Math.random()*array.length);
            int temp = array[i];
            array[i]=array[random];
            array[random]=temp;
        }
        panelPrincipal.setArray(array);
        VentanaPrincipal.panelPrincipal.repaint();
    }
    //calculo de rendimiento O(n**2)
    public static double calcularRendimiento(int n) {
        long inicio = System.currentTimeMillis();
        int rendimiento = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rendimiento++;
            }
        }
        long fin = System.currentTimeMillis();
        return (fin - inicio) / 1000.0;
    }

    //calculo de rendimiento
}