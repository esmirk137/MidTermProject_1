package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class PredigestGraphic {
    private JFrame frame;
    private JPanel centerPanelOfFirstPanel;
    private ArrayList<JButton> firstPanelButton;
    //private JTabbedPane tabbedPaneOfSecondPanel;
    private ArrayList<Request> requestList;

    public PredigestGraphic() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        /* allocate fields: */{
            firstPanelButton=new ArrayList<>();
            requestList=new ArrayList<>();
        }
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //frame[
        frame = new JFrame("Predigest Designer");
        frame.setLocationRelativeTo(null);
        frame.setSize(900, 700);
        frame.setLayout(new GridLayout(0,3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame]
        // frame menu bar[
        JMenuBar menuBar = new JMenuBar();
        JMenu application, edit, view, help, option;
        JMenuItem exit, screen, slider, about, helpItem;
        JCheckBox followRedirect, exitType;
        JComboBox theme;
        application = new JMenu("Application");
        application.setMnemonic('p');
        option=new JMenu("Option");
        option.setMnemonic('O');
        followRedirect=new JCheckBox("Follow redirect");
        followRedirect.setMnemonic('F');
        exitType=new JCheckBox("Hide on system tray");
        exitType.setMnemonic('s');
        theme=new JComboBox(new String[]{"Dark theme", "Light theme"});
        option.add(followRedirect);
        option.add(exitType);
        option.add(theme);
        exit=new JMenuItem("Exit",'x');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
        application.add(option);
        application.add(exit);
        edit = new JMenu("Edit");
        edit.setMnemonic('d');
        view =new JMenu("View");
        view.setMnemonic('i');
        screen=new JMenuItem("Toggle Full Screen",'F');
        screen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK));
        slider=new JMenuItem("Toggle Slider",'S');
        screen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        view.add(screen);
        view.add(slider);
        help = new JMenu("Help");
        help.setMnemonic('e');
        about=new JMenuItem("About",'A');
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
        helpItem=new JMenuItem("Help",'H');
        helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));
        help.add(about);
        help.add(helpItem);
        menuBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        menuBar.add(application);
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(help);
        frame.setJMenuBar(menuBar);
        // frame menu bar]


        /* app menu bar (BorderLayout.NORTH) */{
            JPanel panel=new JPanel(); //????????????????????
        }// no implement

        // first panel[
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());
        firstPanel.setBackground(Color.gray);
        firstPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        // first panel -> north[
        JPanel northPanelOfFirstPanel=new JPanel();
        northPanelOfFirstPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextField textField= new JTextField("Filter");
        Dimension textFieldDimension=textField.getPreferredSize();
        textFieldDimension.width=240;
        textField.setPreferredSize(textFieldDimension);
        JButton plusButton=new JButton(new ImageIcon("icons\\plus.PNG"));
        Dimension plusButtonDimension=plusButton.getPreferredSize();
        plusButtonDimension.width=40;
        plusButton.setPreferredSize(plusButtonDimension);
        northPanelOfFirstPanel.add(textField);
        northPanelOfFirstPanel.add(plusButton);
        firstPanel.add(northPanelOfFirstPanel, BorderLayout.NORTH);
        plusButton.addActionListener(new buttonActionListener());
        firstPanelButton.add(plusButton);
        // first panel -> north]
        // first panel -> center[
        centerPanelOfFirstPanel=new JPanel();
        centerPanelOfFirstPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        firstPanel.add(centerPanelOfFirstPanel);
        // first panel -> center]
        frame.add(firstPanel);
        //second panel[
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());
        secondPanel.setBackground(Color.gray);
        secondPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        // second panel -> north[
        JPanel northPanelOfSecondPanel=new JPanel();
        northPanelOfSecondPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JComboBox typeComboBox=new JComboBox(new String[]{"GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD"});
        JTextField textFieldSecondPanel=new JTextField("https://...");
        Dimension textFieldSecondPanelDimension=textFieldSecondPanel.getPreferredSize();
        textFieldSecondPanelDimension.width=130;
        textFieldSecondPanel.setPreferredSize(textFieldSecondPanelDimension);
        JButton sendButton=new JButton("Send");
        northPanelOfSecondPanel.add(typeComboBox);
        northPanelOfSecondPanel.add(textFieldSecondPanel);
        northPanelOfSecondPanel.add(sendButton);
        secondPanel.add(northPanelOfSecondPanel,BorderLayout.NORTH);
        // second panel -> north]
        // second panel -> center[
        JPanel centerPanelOfSecondPanel=new JPanel();
        centerPanelOfSecondPanel.setLayout(new BorderLayout());
        //new String[]{"Multipart Form","Form URL Encoded", "GraphQL Query", "JSON", "NTLM", "XML", "YAML", "EDN", "Binary File", "No Body"});
        //new String[]{"Basic Auth","Digest Auth", "OAuth 1.0", "OAuth 2.0", "Microsoft NTLM", "AWS IAM v4", "Bearer Token", "Hawk", "Atlassian ASAP", "Netrc File"});
        JTabbedPane tabbedPaneOfSecondPanel=new JTabbedPane();
        JPanel body=new JPanel();
        JPanel auth=new JPanel();
        JPanel query=new JPanel();
        JPanel header=new JPanel();
        JPanel docs=new JPanel();
        tabbedPaneOfSecondPanel.add("Body v ",body);
        tabbedPaneOfSecondPanel.add("Auth v ",auth);
        tabbedPaneOfSecondPanel.add("query",query);
        tabbedPaneOfSecondPanel.add("header",header);
        tabbedPaneOfSecondPanel.add("docs",docs);
        centerPanelOfSecondPanel.add(tabbedPaneOfSecondPanel, BorderLayout.NORTH);
        secondPanel.add(centerPanelOfSecondPanel,BorderLayout.CENTER);
        tabbedPaneOfSecondPanel.addChangeListener(changeEvent -> {
            if(tabbedPaneOfSecondPanel.getSelectedIndex()==0){
                JPopupMenu popupMenu = new JPopupMenu();
                JMenuItem MultipartForm = new JMenuItem("Multipart Form");
                JMenuItem FormURLEncoded = new JMenuItem("Form URL Encoded");
                JMenuItem GraphQLQuery = new JMenuItem("GraphQL Query");
                JMenuItem JSON = new JMenuItem("JSON");
                JMenuItem XML = new JMenuItem("XML");
                JMenuItem YAML = new JMenuItem("YAML");
                JMenuItem EDN = new JMenuItem("EDN");
                JMenuItem BinaryFile = new JMenuItem("Binary File");
                JMenuItem noBody = new JMenuItem("No Body");
                popupMenu.add("# STRUCTURED ---------"); popupMenu.add(MultipartForm); popupMenu.add(FormURLEncoded); popupMenu.add(GraphQLQuery);
                popupMenu.add("# TEXT ----------------------"); popupMenu.add(JSON); popupMenu.add(XML); popupMenu.add(YAML); popupMenu.add(EDN);
                popupMenu.add("# OTHER -------------------"); popupMenu.add(BinaryFile); popupMenu.add(noBody);
                popupMenu.show(frame , 313, 120);
            }
            else if(tabbedPaneOfSecondPanel.getSelectedIndex()==1){
                JPopupMenu popupMenu = new JPopupMenu();
                JMenuItem basic = new JMenuItem("Basic Auth");
                JMenuItem digest = new JMenuItem("Digest Auth");
                JMenuItem OAuth1 = new JMenuItem("OAuth 1.0");
                JMenuItem OAuth2 = new JMenuItem("OAuth 2.0");
                JMenuItem NTLM = new JMenuItem("Microsoft NTLM");
                JMenuItem AWS = new JMenuItem("AWS IAM v4");
                JMenuItem bearer = new JMenuItem("Bearer Token");
                JMenuItem hawk = new JMenuItem("Hawk");
                JMenuItem ASAP = new JMenuItem("Atlassian ASAP");
                JMenuItem netrc = new JMenuItem("Netrc File");
                popupMenu.add(basic); popupMenu.add(digest); popupMenu.add(OAuth1); popupMenu.add(OAuth2); popupMenu.add(NTLM);
                popupMenu.add(AWS); popupMenu.add(bearer); popupMenu.add(hawk); popupMenu.add(ASAP);
                popupMenu.add(netrc);
                popupMenu.show(frame , 355, 120);
            }
            if(tabbedPaneOfSecondPanel.getSelectedIndex()==3){
                JTextField textFieldHeader=new JTextField("New Header");
                Dimension dimension1=textFieldHeader.getPreferredSize();
                dimension1.width=100;
                textFieldHeader.setPreferredSize(dimension1);
                JTextField textFieldValue=new JTextField("New Value");
                Dimension dimension2=textFieldValue.getPreferredSize();
                dimension2.width=100;
                textFieldValue.setPreferredSize(dimension2);
                JCheckBox checkBox=new JCheckBox();
                JButton button=new JButton(new ImageIcon("icons\\trash.PNG"));
                header.add(textFieldHeader);
                header.add(textFieldValue);
                header.add(checkBox);
                header.add(button);
            }
            });
            // second panel -> center[
            frame.add(secondPanel);
        //second panel]
        //third panel[
        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new BorderLayout());
        thirdPanel.setBackground(Color.gray);
        thirdPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        // third panel -> north[
        JPanel northPanelOfThirdPanel=new JPanel();
        northPanelOfThirdPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelStatusMassage=new JLabel("137 OK");
        JLabel labelTime=new JLabel("137 s");
        JLabel labelSize=new JLabel(" 137 KB");
        northPanelOfThirdPanel.add(labelStatusMassage); northPanelOfThirdPanel.add(labelTime); northPanelOfThirdPanel.add(labelSize);
        thirdPanel.add(northPanelOfThirdPanel,BorderLayout.NORTH);
        // third panel -> north]
        // third panel -> center[
        JPanel centerPanelOfThirdPanel=new JPanel();
        centerPanelOfThirdPanel.setLayout(new BorderLayout());
        JTabbedPane tabbedPaneOfThirdPanel=new JTabbedPane();
        JPanel raw=new JPanel();
        JPanel aHeader=new JPanel();
        aHeader.setLayout(new BorderLayout());

        JPanel cookie=new JPanel();
        JPanel timeLine=new JPanel();
        tabbedPaneOfThirdPanel.add("Raw",raw);
        tabbedPaneOfThirdPanel.add("Header",aHeader);
        tabbedPaneOfThirdPanel.addChangeListener(event->{
            if(tabbedPaneOfThirdPanel.getSelectedIndex()==0){
                JPopupMenu popupMenu = new JPopupMenu();
                JMenuItem rawItem = new JMenuItem("Raw");
                JMenuItem jsonItem = new JMenuItem("JSON");
                popupMenu.add(rawItem); popupMenu.add(jsonItem);
                popupMenu.show(frame , 608, 105);
            }
            if(tabbedPaneOfThirdPanel.getSelectedIndex()==1){
                JPanel centerHeader=new JPanel(new GridLayout(9,2));
                centerHeader.add(new JLabel(" NAME")); //10
                JLabel label1=new JLabel(" null");
                centerHeader.add(label1);

                centerHeader.add(new JLabel(" Server"));
                JLabel label2=new JLabel(" null");
                centerHeader.add(label2);

                centerHeader.add(new JLabel(" Date"));
                JLabel label3=new JLabel(" null");
                centerHeader.add(label3);

                centerHeader.add(new JLabel(" Content-Type"));
                JLabel label4=new JLabel(" null");
                centerHeader.add(label4);

                centerHeader.add(new JLabel(" Content-Length"));
                JLabel label5=new JLabel(" null");
                centerHeader.add(label5);

                centerHeader.add(new JLabel(" Connection"));
                JLabel label6=new JLabel(" null");
                centerHeader.add(label6);

                centerHeader.add(new JLabel(" Last-Modified"));
                JLabel label7=new JLabel(" null");
                centerHeader.add(label7);

                centerHeader.add(new JLabel(" ETag"));
                JLabel label8=new JLabel(" null");
                centerHeader.add(label8);

                centerHeader.add(new JLabel(" Accept-Ranges"));
                JLabel label9=new JLabel(" null");
                centerHeader.add(label9);

                aHeader.add(centerHeader, BorderLayout.CENTER);

                JButton copy=new JButton("Copy to clipboard");
                aHeader.add(copy, BorderLayout.SOUTH);
            }
        });
        tabbedPaneOfThirdPanel.add("Cookie",cookie);
        tabbedPaneOfThirdPanel.add("TimeLine",timeLine);
        centerPanelOfThirdPanel.add(tabbedPaneOfThirdPanel);
        thirdPanel.add(centerPanelOfThirdPanel,BorderLayout.CENTER);
        // third panel -> center]
        frame.add(thirdPanel);
        //third panel]
    }

    /**
     * This method show frame.
     */
    public void showFrame(){
        frame.setVisible(true);
    }

    private void plusButtonAction(){
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem newRequest = new JMenuItem("New Request");
        JMenuItem newFolder = new JMenuItem("New Folder");
        popupMenu.add(newRequest); popupMenu.add(newFolder);
        popupMenu.show(frame , firstPanelButton.get(0).getX(), firstPanelButton.get(0).getY());
        // new request action[
        newRequest.addActionListener(e -> {
            JFrame requestFrame = new JFrame("New Request");
            requestFrame.setLocationRelativeTo(null);
            requestFrame.setSize(650, 150);
            requestFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
            requestFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel label=new JLabel("Name");
            JPanel panel=new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JTextField textField=new JTextField("My Request");
            textField.setFont(new Font("Arial", Font.PLAIN, 13));
            Dimension textFieldDimension=textField.getPreferredSize();
            textFieldDimension.width=530;
            textFieldDimension.height=35;
            textField.setPreferredSize(textFieldDimension);
            JComboBox comboBox=new JComboBox(new String[]{"GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD"});
            panel.add(textField);
            panel.add(comboBox);
            JButton create=new JButton("create");
            requestFrame.add(label);
            requestFrame.add(panel);
            requestFrame.add(create);
            requestFrame.setVisible(true);
            create.addActionListener(event-> {
                JLabel jLabel=new JLabel(comboBox.getSelectedItem().toString());
                //System.out.println("name: "+textField.getText());
                JButton jButton=new JButton(textField.getText());
                //Request request=new Request()
                requestList.add(new Request(jLabel, jButton));
                centerPanelOfFirstPanel.add(requestList.get(requestList.size()-1).getLabel());
                centerPanelOfFirstPanel.add(requestList.get(requestList.size()-1).getButton());
                //centerPanelOfFirstPanel.add(test);
                requestFrame.dispatchEvent(new WindowEvent(requestFrame, WindowEvent.WINDOW_CLOSING));
                frame.repaint();
            });
            if(requestList.size()!=0)
                System.out.println(requestList.get(0).getButton().getText());


            // new request action]
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
