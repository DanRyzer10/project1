package views;

import javax.swing.*;
import java.util.Arrays;

public class VentanaPrincipal extends JFrame {
    public static PanelPrincipal panelPrincipal;
    public static int[] array;
    public VentanaPrincipal(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Ordenamiento de datos");
        array=obtenerCantidadElementos();
        panelPrincipal = new PanelPrincipal(array);
        this.add(panelPrincipal);
        Menu menu = new Menu();
        this.setJMenuBar(menu);
        this.setVisible(true);

    }
    private int[] obtenerCantidadElementos() {
        int length;
        String input = JOptionPane.showInputDialog(this, "Ingrese la cantidad de elementos del array(entre 10 y 400):");
        try {
            int lenght=Integer.parseInt(input);
            if(lenght<10 || lenght>400){
                JOptionPane.showMessageDialog(this, "Cantidad no permitida!!!.");
                return obtenerCantidadElementos();
            }
            return generarArrayAleatorio(lenght);
        } catch (NumberFormatException e) {
            // Manejar el caso en que la entrada no sea un número válido
            JOptionPane.showMessageDialog(this, "La cantidad de elementos debe ser un número válido.");
            return obtenerCantidadElementos(); // Volver a solicitar la cantidad de elementos
        }
    }
    private int[] generarArrayAleatorio(int n){
        //definir valores entre 10 y 150
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random()*140)+10;
        }
        System.out.println("Array generado: " + Arrays.toString(array));
        return array;
    }

}

