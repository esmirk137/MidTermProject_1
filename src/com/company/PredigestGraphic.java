package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PredigestGraphic {
    private JFrame frame;
    private ArrayList<JButton> firstPanelButton;
    private ArrayList<JButton> requestList;

    public PredigestGraphic() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        /* allocate fields: */{
            firstPanelButton=new ArrayList<>();
            requestList=new ArrayList<>();
        }
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        /* frame: */{
            frame = new JFrame("Predigest Designer");
            frame.setLocationRelativeTo(null);
            frame.setSize(900, 900);
            frame.setLayout(new GridLayout(0,3));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        /* frame menu bar: */{
            JMenuBar menuBar = new JMenuBar();
            JMenu application, edit, help, aboutUs;
            application = new JMenu("Application");
            edit = new JMenu("Edit");
            help = new JMenu("Help");
            aboutUs = new JMenu("AboutUs");
            menuBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            menuBar.add(application);
            menuBar.add(edit);
            menuBar.add(help);
            menuBar.add(aboutUs);
            frame.setJMenuBar(menuBar);
        }
        /* app menu bar (BorderLayout.NORTH) */{
            JPanel panel=new JPanel();
        }// no implement
        /* first panel: */{
            JPanel firstPanel = new JPanel();
            firstPanel.setLayout(new BorderLayout());
            firstPanel.setBackground(Color.gray);
            firstPanel.setBorder(BorderFactory.createLineBorder(Color.white));
            // north[
            JPanel northPanel=new JPanel();
            northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JTextField textField= new JTextField("Filter");
            Dimension textFieldDimension=textField.getPreferredSize();
            textFieldDimension.width=240;
            textField.setPreferredSize(textFieldDimension);
            JButton plusButton=new JButton(new ImageIcon("icons\\plus.PNG"));
            Dimension plusButtonDimension=plusButton.getPreferredSize();
            plusButtonDimension.width=40;
            plusButton.setPreferredSize(plusButtonDimension);
            northPanel.add(textField);
            northPanel.add(plusButton);
            firstPanel.add(northPanel, BorderLayout.NORTH);
            plusButton.addActionListener(new buttonActionListener());
            firstPanelButton.add(plusButton);
            // north\\create new one[

            // north\\create new one]
            // north]

            // center[

            // center]
            frame.add(firstPanel, BorderLayout.CENTER);

        }
        /* second panel: */{
            JPanel secondPanel = new JPanel();

        }
        /* third panel: */{
            JPanel thirdPanel = new JPanel();
        }


    }

    /**
     * This method show frame.
     */
    public void showFrame(){
        frame.setVisible(true);
    }

    private void plusButtonAction(){
        JPopupMenu popupMenu = new JPopupMenu("Edit");
        JMenuItem request = new JMenuItem("New Request");
        JMenuItem folder = new JMenuItem("New Folder");
        popupMenu.add(request); popupMenu.add(folder);
        popupMenu.show(frame , firstPanelButton.get(0).getX(), firstPanelButton.get(0).getY());
        request.addActionListener(e -> {
            //JFrame requestFrame=new JFrame();
            JFrame requestFrame = new JFrame("New Request");
            requestFrame.setLocationRelativeTo(null);
            requestFrame.setSize(650, 140);
            requestFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
            requestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel label=new JLabel("Name:");
            JPanel panel=new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JTextField textField=new JTextField("My Request");
            Dimension textFieldDimension=textField.getPreferredSize();
            textFieldDimension.width=530;
            textFieldDimension.height=40;
            textField.setPreferredSize(textFieldDimension);
            String[] requestType={"GET","Post","PUT","PATCH","DELETE","OPTIONS","HEAD"};
            JComboBox comboBox=new JComboBox(requestType);
            panel.add(textField);
            panel.add(comboBox);
            requestFrame.add(label);
            requestFrame.add(panel);
            requestFrame.setVisible(true);
        });

    }

    private class buttonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(actionEvent.getSource().equals(firstPanelButton.get(0))){
                plusButtonAction();
            }
        }
    }
}
