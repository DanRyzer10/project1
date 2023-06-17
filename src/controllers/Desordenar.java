package controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static views.PanelPrincipal.options;
import static views.VentanaPrincipal.panelPrincipal;

public class Desordenar implements ActionListener {
    int[] array=panelPrincipal.getArray();
    String option;
    @Override
    public void actionPerformed(ActionEvent e) {
        option = options[4];
        SwingWorker<Void, Void> worker= new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                if (option != null) {
                    Algoritmos.desordenar(array);
                }
                return null;
            }
        };
        worker.execute();
    }
}

