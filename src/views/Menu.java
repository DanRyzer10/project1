package views;

import controllers.*;

import javax.swing.*;

public class Menu extends JMenuBar {
    private int interval = 50;
    public Menu(){

        //menus
        JMenu archivo = new JMenu("Archivo");
        JMenu algoritmo = new JMenu("Algoritmo");
        JMenu rendimiento = new JMenu("Rendimiento");
        JMenu opciones = new JMenu("Opciones");
        JMenu ayuda = new JMenu("Ayuda");
        //items menu archivo
        //items menu algoritmo
        JMenuItem bubbleSort = new JMenuItem("Ordenamiento burbuja");
        bubbleSort.addActionListener(new bubbleSortList());
        JMenuItem insertionSort = new JMenuItem("Ordenamiento por inserción");
        insertionSort.addActionListener(new InsertionSortList());
        JMenuItem selectionSort = new JMenuItem("Ordenamiento por selección");
        selectionSort.addActionListener(new SelectionSortList());
        JMenuItem mergeSort = new JMenuItem("Ordenamiento rapido");
        mergeSort.addActionListener(new QuickSortList());

        //items de menu option
        JMenuItem desordenar = new JMenuItem("Desordenar");
        JMenu pauseIntervalMenu = new JMenu("Intervalo de Pausa");
        ButtonGroup pauseIntervalGroup = new ButtonGroup();
        desordenar.addActionListener(new Desordenar());
        JRadioButtonMenuItem slowItem = new JRadioButtonMenuItem("Lento", true);
        JRadioButtonMenuItem mediumItem = new JRadioButtonMenuItem("Medio");
        JRadioButtonMenuItem fastItem = new JRadioButtonMenuItem("Rápido");
        slowItem.addActionListener(e -> interval = 200);

        //items menu rendimiento
        //items menu opciones
        //items menu ayuda
        //agregar items a los menus
        algoritmo.add(bubbleSort);
        algoritmo.add(insertionSort);
        algoritmo.add(selectionSort);
        algoritmo.add(mergeSort);
        opciones.add(desordenar);
        opciones.add(pauseIntervalMenu);
        slowItem.addActionListener(e -> interval = 200);
        pauseIntervalGroup.add(slowItem);
        pauseIntervalMenu.add(slowItem);
        mediumItem.addActionListener(e -> interval = 100);
        pauseIntervalGroup.add(mediumItem);
        pauseIntervalMenu.add(mediumItem);
        fastItem.addActionListener(e -> interval = 50);
        pauseIntervalGroup.add(fastItem);
        pauseIntervalMenu.add(fastItem);

        //agregar menus a la barra
        this.add(archivo);
        this.add(algoritmo);
        this.add(rendimiento);
        this.add(opciones);
        this.add(ayuda);

    }
}