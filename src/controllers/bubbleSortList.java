package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static views.PanelPrincipal.options;

public class bubbleSortList implements ActionListener {
    String option;
    @Override
    public void actionPerformed(ActionEvent e) {
        option=options[0];
        if (option!=null){
            Algoritmos.animateSort(option);
        }

    }
}

