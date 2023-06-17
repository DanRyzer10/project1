package views;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private int[] array;
    private Color[] colors;
    private final int barWidth;
    public static String[] options = {"Bubble Sort","Insertion Sort","Selection Sort","Quick Sort", "desordenar"};

    public PanelPrincipal(int[] array){
        this.array = array;
        this.colors = generateRamdonColor(array.length);
        this.barWidth=getWidth() / this.array.length;
    }

    public void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public void setArray(int[] array){
        this.array = array;
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        int barHeight = getHeight();
        for(int i=0;i<array.length;i++){
            int barWidth = getWidth() / array.length;
            Color barColor = colors[i];
            int barHeigth = array[i]*3;
            int x = i * barWidth;
            int y = getHeight() - barHeigth;
            g.setColor(barColor);
            g.fillRect(x,y,barWidth,barHeigth);
        }

    }

    public Color[] generateRamdonColor(int lenght){
        colors = new Color[lenght];
        for(int i=0;i<lenght;i++){
            colors[i] = ramdonColor();
        }
        return colors;
    }
    public Color ramdonColor(){
        return new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    }
    public void animateSort() {
        Timer timer = new Timer(1000, e -> {
            boolean swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    // Realizar intercambio de posiciones
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                // Si no se realizó ningún intercambio, el arreglo ya está ordenado
                ((Timer)e.getSource()).stop();
            }
            repaint();
            // Realizar un paso del algoritmo de ordenación (por ejemplo, Bubble Sort)
            // Actualizar el arreglo de barras
            // Llamar a repaint() para volver a dibujar las barras
        });
        timer.setDelay(100);
        timer.start();
        Timer animationTimer = new Timer(300, e -> {
            for (int i = 0; i < array.length; i++) {
                int x = i * barWidth; // Posición actual de la barra
                int y = getHeight() - array[i]; // Altura de la barra
                int targetX = i * barWidth; // Posición objetivo de la barra
                int targetY = getHeight() - array[i]; // Altura objetivo de la barra

                if (x != targetX || y != targetY) {
                    // Si la barra aún no ha llegado a su posición final, moverla gradualmente hacia allí
                    if (x < targetX) {
                        x++;
                    } else if (x > targetX) {
                        x--;
                    }

                    if (y < targetY) {
                        y++;
                    } else if (y > targetY) {
                        y--;
                    }

                    array[i] = getHeight() - y; // Actualizar la altura de la barra en el arreglo
                }
            }
            repaint();
        });

        animationTimer.setDelay(300); // Retraso entre cada movimiento de la barra
        animationTimer.start();
    }
    //get array
    public int[] getArray(){
        return array;
    }

}


