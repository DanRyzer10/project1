package views;

import controllers.bubbleSortList;

import javax.swing.*;

public class Menu extends JMenuBar {
    public Menu(){
        //menus
        JMenu archivo = new JMenu("Archivo");
        JMenu algoritmo = new JMenu("Algoritmo");
        JMenu rendimiento = new JMenu("Rendimiento");
        JMenu opciones = new JMenu("Opciones");
        JMenu ayuda = new JMenu("Ayuda");
        //items menu archivo
        //items menu algoritmo
        JMenuItem bubbleSort = new JMenuItem("ordenamiento burbuja");
        bubbleSort.addActionListener(new bubbleSortList());
        JMenuItem insertionSort = new JMenuItem("ordenamiento por inserción");
        JMenuItem selectionSort = new JMenuItem("ordenamiento por selección");
        JMenuItem mergeSort = new JMenuItem("ordenamiento por insercion");
        //items menu rendimiento
        //items menu opciones
        //items menu ayuda
        //agregar items a los menus
        algoritmo.add(bubbleSort);
        algoritmo.add(insertionSort);
        algoritmo.add(selectionSort);
        algoritmo.add(mergeSort);
        //agregar menus a la barra
        this.add(archivo);
        this.add(algoritmo);
        this.add(rendimiento);
        this.add(opciones);
        this.add(ayuda);

    }
}
