package views;

import controllers.OrdenamientodeDatos;
import controllers.bubbleSortList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JPanel {
    private int[] array;
    private static int currentIndex;
    private final static int DELAY = 1000;
    public static Timer timer;

    public PanelPrincipal(int[] array){
       this.array = array;
       timer = new Timer(DELAY, e -> {
           while (currentIndex<array.length){
               if(currentIndex < array.length - 1){
                   if(array[currentIndex] > array[currentIndex + 1]){
                       swap(currentIndex, currentIndex + 1);
                   }

               }else{
                   timer.stop();
               }
               repaint();
               currentIndex++;
           }



       });
    }

    public void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public void setArray(int[] array){
        this.array = array;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        int barWidth = getWidth() / this.array.length;
        int barHeight = getHeight();
        for(int i=0;i<array.length;i++){
            int barHeigth = array[i]*3;
            int x = i * barWidth;
            int y = getHeight() - barHeigth;
            g.fillRect(x,y,barWidth,barHeigth);
            g.setColor(ramdonColor());
        }

    }
    public static void startAnimation(){
        currentIndex = 0;
        timer.start();
    }
    public Color ramdonColor(){
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        return new Color(r,g,b);
    }


}
