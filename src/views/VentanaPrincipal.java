package views;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    public static PanelPrincipal panelPrincipal;
    public static int[] array={78,98,34,67,28,90,100,71,38,55,88,99,45,37,88,33,78,99,100,99,87,78,77,63,78,33,12};
    public VentanaPrincipal(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Ordenamiento de datos");
        panelPrincipal = new PanelPrincipal(array);
        this.add(panelPrincipal);
        Menu menu = new Menu();
        this.setJMenuBar(menu);
        this.setVisible(true);

    }
}

