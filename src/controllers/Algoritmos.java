package controllers;

import views.VentanaPrincipal;
import static views.VentanaPrincipal.panelPrincipal;

import javax.swing.*;
import java.util.Arrays;

public class Algoritmos {
    public static void bubbleSort(int[] array){
        int n = array.length;
        int temp = 0;
        for(int i=0;i<n;i++){
            for(int j=1;j<(n-i);j++){
                if(array[j-1]>array[j]){
                    temp = array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
        panelPrincipal.setArray(array);
    }
    public static void insertionSort(int[] array){
        int n = array.length;
        for(int i=1;i<n;i++){
            int key = array[i];
            int j = i-1;
            while(j>=0 && array[j]>key){
                array[j+1]=array[j];
                j=j-1;
            }
            array[j+1]=key;
        }
        System.out.println(Arrays.toString(array));
        panelPrincipal.setArray(array);
    }
    public static void selectionSort(int[] array){
        int n = array.length;
        for(int i=0;i<n-1;i++){
            int min_idx = i;
            for(int j=i+1;j<n;j++){
                if(array[j]<array[min_idx]){
                    min_idx=j;
                }
            }
            int temp = array[min_idx];
            array[min_idx]=array[i];
            array[i]=temp;
        }
        panelPrincipal.setArray(array);

    }
    public static void quickSort(int[] array, int low, int high){
        if(low<high){
            int pi = partition(array,low,high);
            quickSort(array,low,pi-1);
            quickSort(array,pi+1,high);
        }
        panelPrincipal.setArray(array);
    }
    public static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i = (low-1);
        for(int j=low;j<high;j++){
            if(array[j]<pivot){
                i++;
                int temp = array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        int temp = array[i+1];
        array[i+1]=array[high];
        array[high]=temp;
        return i+1;
    }
    public static void animateSort(String Option){
        Timer timer = new Timer(1000, e->{
            switch (Option) {
                case "Bubble Sort" -> {
                    bubbleSort(VentanaPrincipal.panelPrincipal.getArray());
                    ((Timer) e.getSource()).stop();
                    VentanaPrincipal.panelPrincipal.repaint();
                }
                case "Insertion Sort" -> {
                    insertionSort(VentanaPrincipal.panelPrincipal.getArray());
                    ((Timer) e.getSource()).stop();
                    VentanaPrincipal.panelPrincipal.repaint();
                }
                case "Selection Sort" -> {
                    selectionSort(VentanaPrincipal.panelPrincipal.getArray());
                    ((Timer) e.getSource()).stop();
                    VentanaPrincipal.panelPrincipal.repaint();
                }
                case "Quick Sort" -> {
                    quickSort(VentanaPrincipal.panelPrincipal.getArray(), 0, VentanaPrincipal.panelPrincipal.getArray().length - 1);
                    ((Timer) e.getSource()).stop();
                    VentanaPrincipal.panelPrincipal.repaint();
                }
                case "desordenar" -> {
                    desordenar(VentanaPrincipal.panelPrincipal.getArray());
                    ((Timer) e.getSource()).stop();

                }
            }


        });
        timer.start();
    }
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
}