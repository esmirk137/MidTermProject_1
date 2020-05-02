package com.company;
import javax.swing.*;
import java.awt.event.*;

public class Main{

        Main(){
        final JFrame f= new JFrame("PopupMenu Example");
        final JPopupMenu popupmenu = new JPopupMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        popupmenu.add(cut); popupmenu.add(copy); popupmenu.add(paste);
        f.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                popupmenu.show(f , e.getX(), e.getY());
            }
        });
        f.add(popupmenu);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }
        public static void main(String[] args)
        {
            new Main();
        }

}
/*
        EventQueue.invokeLater(() -> {
            JComboBox<String> comboBox = new JComboBox<>(new String[]{"Item1", "Item2"});
            final String browse = "<<BROWSE>>";
            comboBox.addItem( browse );
            comboBox.addItemListener(e -> {
                if ( e.getStateChange() == ItemEvent.SELECTED &&
                        browse.equals( e.getItem() ) ){
                    System.out.println("Show filechooser");
                }
            });
        });
 */