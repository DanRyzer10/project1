package views;

import controllers.*;
import controllers.SortingWorker.*;

import javax.swing.*;
import static controllers.SortingWorker.*;



public class Menu extends JMenuBar {
    private SortingWorker sortingWorker;
    public static boolean isPaused = false;
    public Menu() {
        //menus
        JMenu archivo = new JMenu("Archivo");
        JMenu algoritmo = new JMenu("Algoritmo");
        JMenu rendimiento = new JMenu("Rendimiento");
        JMenu opciones = new JMenu("Opciones");
        JMenu ayuda = new JMenu("Ayuda");

        //items menu archivo
        //items menu algoritmo
        JMenuItem desordenar = new JMenuItem("Desordenar");
        desordenar.addActionListener(
                e -> {
                    if (sortingWorker != null && !sortingWorker.isDone()) {
                        sortingWorker.cancel(true);
                    }
                    Algoritmos.desordenar(VentanaPrincipal.panelPrincipal.getArray());

                });
        JMenuItem bubbleSort = new JMenuItem("Ordenamiento burbuja");
        bubbleSort.addActionListener(e -> {
            startSorting(SortingAlgorithm.BUBBLE_SORT);

        } );
        JMenuItem insertionSort = new JMenuItem("Ordenamiento por inserción");
        insertionSort.addActionListener(e -> startSorting(SortingAlgorithm.INSERTION_SORT));
        JMenuItem selectionSort = new JMenuItem("Ordenamiento por selección");
        selectionSort.addActionListener(e -> startSorting(SortingAlgorithm.SELECTION_SORT));
        JMenuItem mergeSort = new JMenuItem("Ordenamiento rapido");
        mergeSort.addActionListener(e -> startSorting(SortingAlgorithm.QUICK_SORT));
        JMenuItem pauseItem = new JMenuItem("Pausar/Reanudar");
        pauseItem.addActionListener(e -> togglePause());
        opciones.add(pauseItem);
        //items de menu option

        JMenu pauseIntervalMenu = new JMenu("Velocidad");
        ButtonGroup pauseIntervalGroup = new ButtonGroup();

        JRadioButtonMenuItem slowItem = new JRadioButtonMenuItem("Lento",true);
        JRadioButtonMenuItem mediumItem = new JRadioButtonMenuItem("Medio");
        JRadioButtonMenuItem fastItem = new JRadioButtonMenuItem("Rápido");
        slowItem.addActionListener(e -> interval = 200);

        //items menu rendimiento
        JMenuItem rendimientoItem = new JMenuItem("Rendimiento");
        rendimientoItem.addActionListener(e -> {
            if(duration==0){
                JOptionPane.showMessageDialog(null,"No se ha ejecutado ningun algoritmo");

            }else{
                String result = "Rendimiento: " + duration + " milisegundos";
                JOptionPane.showMessageDialog(null, result);
            }

        });
        rendimiento.add(rendimientoItem);
        //items menu opciones
        //items menu ayuda
        //agregar items a los menus
        algoritmo.add(bubbleSort);
        algoritmo.add(insertionSort);
        algoritmo.add(selectionSort);
        algoritmo.add(mergeSort);
        opciones.add(desordenar);
        opciones.add(pauseIntervalMenu);
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



    //********************************************
    private void startSorting(SortingAlgorithm algorithm) {
        if (sortingWorker != null && !sortingWorker.isDone()) {
            sortingWorker.cancel(true);
        }
        sortingWorker = new SortingWorker(algorithm);
        sortingWorker.execute();
    }
    private void togglePause() {
        isPaused = !isPaused;
        if (!isPaused && sortingWorker != null && sortingWorker.isCancelled()) {
            sortingWorker = null;
            startSorting(sortingWorker.getCurrentAlgorithm());
        }
    }

}