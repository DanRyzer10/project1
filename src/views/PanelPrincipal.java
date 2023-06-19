package views;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

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

    //get array
    public int[] getArray(){
        return array;
    }
}


