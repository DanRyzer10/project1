package views;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    public static PanelPrincipal panelPrincipal;
    public static int[] array={78,98,34,67,28,90,100};
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
