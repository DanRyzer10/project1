package controllers;

import views.VentanaPrincipal;
import javax.swing.*;
import static views.Menu.isPaused;

import java.util.List;

public class SortingWorker extends SwingWorker<Void, Void>{
    private final SortingAlgorithm algorithm;
    public static int interval=200;
    private SortingAlgorithm currentAlgorithm;
    int [] data= VentanaPrincipal.panelPrincipal.getArray();
    public static long duration=0;
    public SortingWorker(SortingAlgorithm algorithm) {
        this.algorithm = algorithm;
        this.currentAlgorithm= algorithm;
    }
    public SortingAlgorithm getCurrentAlgorithm() {
        return currentAlgorithm;
    }
    @Override
    protected Void doInBackground() throws Exception {
        switch (algorithm) {
            case BUBBLE_SORT:
                long startTimeb = (int) System.currentTimeMillis();
                bubbleSort();
                long endTimeb = (int) System.currentTimeMillis();
                duration = endTimeb - startTimeb;
                break;
            case SELECTION_SORT:
                duration=0;
                long startTimes = (int) System.currentTimeMillis();
                selectionSort();
                long endTimes = (int) System.currentTimeMillis();
                duration = endTimes - startTimes;
                break;
            case INSERTION_SORT:
                duration=0;
                long startTimei = (int) System.currentTimeMillis();
                insertionSort();
                long endTimei = (int) System.currentTimeMillis();
                duration = endTimei - startTimei;
                break;
            case QUICK_SORT :
                duration=0;
                long startTimeq = (int) System.currentTimeMillis();
                quickSort( 0, data.length - 1);
                long endTimeq = (int) System.currentTimeMillis();
                duration = endTimeq - startTimeq;
                break;
        }
        return null;
    }

    @Override
    protected void process(List<Void> chunks) {
        VentanaPrincipal.panelPrincipal.repaint();
    }

    @Override
    protected void done() {
        VentanaPrincipal.panelPrincipal.repaint();
    }
    private void bubbleSort() {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(j, j + 1);
                    publish();
                    pause();
                }
            }
            if (isCancelled()) {
                currentAlgorithm = null;
                break;
            }
        }
    }

    private void selectionSort() {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
            publish();
            pause();
            if (isCancelled()) {
                currentAlgorithm = null;
                break;
            }
        }
    }

    private void insertionSort() {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
            publish();
            pause();
            if (isCancelled()) {
                currentAlgorithm = null;
                break;
            }
        }
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int partitionIndex = partition(low, high);
            quickSort(low, partitionIndex - 1);
            quickSort(partitionIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = data[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (data[j] < pivot) {
                i++;
                swap(i, j);
                publish();
                pause();
            }
            if (isCancelled()) {
                currentAlgorithm = null;
                break;
            }
        }
        swap(i + 1, high);
        publish();
        pause();
        return i + 1;
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void pause() {
        try {
            while (isPaused) {
                Thread.sleep(100);
            }
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public enum SortingAlgorithm {
        BUBBLE_SORT,
        SELECTION_SORT,
        INSERTION_SORT,
        QUICK_SORT
    }

}
