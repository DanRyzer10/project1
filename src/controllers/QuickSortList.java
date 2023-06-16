package controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static views.PanelPrincipal.options;
public class QuickSortList implements ActionListener {
    String option;
    @Override
    public void actionPerformed(ActionEvent e) {
        option = options[3];
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                if (option != null) {
                    Algoritmos.animateSort(option);
                }
                return null;
            }
        };
        worker.execute();
    }
}
