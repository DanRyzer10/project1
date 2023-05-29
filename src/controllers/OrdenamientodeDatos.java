package controllers;

import java.util.Timer;

public class OrdenamientodeDatos{
    private final int[] array;

    public OrdenamientodeDatos(int[] array){
        this.array = array;

    }
    public void bubbleSort() {
        int aux;
        for(int i = 0; i < this.array.length; i++){
            for(int j = 0; j < this.array.length - 1; j++){
                if(array[j] > this.array[j+1]){
                    aux = this.array[j];
                    this.array[j] = this.array[j+1];
                    this.array[j+1] = aux;
                }
            }
        }
    }
    public void insertionSort() {
        int n = this.array.length;
        for (int i = 1; i < n; i++) {
            int key = this.array[i];
            int j = i - 1;
            while (j >= 0 && this.array[j] > key) {
                this.array[j + 1] = this.array[j];
                j--;
            }
            this.array[j + 1] = key;
        }


    }


    public void selectionSort() {
        int n = this.array.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++){
                if (this.array[j] < this.array[min_idx]){
                    min_idx = j;
                }
            }
            int temp = this.array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }

    }


    public void mergeSort() {
        if (array.length <= 1) {
            return; // La lista ya está ordenada
        }

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        // Copiar los elementos a las sublistas izquierda y derecha
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            rightArray[i - mid] = array[i];
        }

        // Ordenar recursivamente las sublistas
        mergeSort();
        mergeSort();

        // Combinar las sublistas ordenadas
        merge(leftArray, rightArray, array);

    }
    private static void merge(int[] leftArray, int[] rightArray, int[] resultArray) {
        int i = 0; // Índice para recorrer el subarreglo izquierdo
        int j = 0; // Índice para recorrer el subarreglo derecho
        int k = 0; // Índice para recorrer el arreglo resultante

        // Combinar los elementos en orden ascendente
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                resultArray[k] = leftArray[i];
                i++;
            } else {
                resultArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes del subarreglo izquierdo
        while (i < leftArray.length) {
            resultArray[k] = leftArray[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes del subarreglo derecho
        while (j < rightArray.length) {
            resultArray[k] = rightArray[j];
            j++;
            k++;
        }
    }



    public void quickSort() {
        quickSort(array, 0, array.length - 1);

    }
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Tomamos el último elemento como pivote
        int i = low - 1; // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1; // Retorna la posición del pivote después de la partición
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
