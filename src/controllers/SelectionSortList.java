package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static views.PanelPrincipal.options;
import static views.VentanaPrincipal.panelPrincipal;

public class SelectionSortList implements ActionListener {
    String option;
    @Override
    public void actionPerformed(ActionEvent e) {
        option=options[1];
        if (option!=null){
            Algoritmos.animateSort(option);
        }

    }
}
