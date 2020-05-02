package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class PredigestGraphic {
    private JFrame frame;
    private JPanel centerPanelOfFirstPanel;
    private ArrayList<JButton> firstPanelButton;
    private JTabbedPane tabbedPaneOfSecondPanel;
    private ArrayList<Request> requestList;
    //JButton test=new JButton("test");

    public PredigestGraphic() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        /* allocate fields: */{
            firstPanelButton=new ArrayList<>();
            requestList=new ArrayList<>();
        }
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        /* frame: */{
            frame = new JFrame("Predigest Designer");
            frame.setLocationRelativeTo(null);
            frame.setSize(900, 700);
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
            // north]

            // center[
            centerPanelOfFirstPanel=new JPanel();
            centerPanelOfFirstPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            firstPanel.add(centerPanelOfFirstPanel);
            // center]
            frame.add(firstPanel);

        }
        /* second panel: */{
            JPanel secondPanel = new JPanel();
            secondPanel.setLayout(new BorderLayout());
            secondPanel.setBackground(Color.gray);
            secondPanel.setBorder(BorderFactory.createLineBorder(Color.white));
            // north[
            JPanel northPanelOfSecondPanel=new JPanel();
            northPanelOfSecondPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JComboBox comboBox=new JComboBox(new String[]{"GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD"});
            JTextField textFieldSecondPanel=new JTextField("https://...");
            Dimension textFieldSecondPanelDimension=textFieldSecondPanel.getPreferredSize();
            textFieldSecondPanelDimension.width=130;
            textFieldSecondPanel.setPreferredSize(textFieldSecondPanelDimension);
            JButton sendButton=new JButton("Send");
            northPanelOfSecondPanel.add(comboBox);
            northPanelOfSecondPanel.add(textFieldSecondPanel);
            northPanelOfSecondPanel.add(sendButton);
            secondPanel.add(northPanelOfSecondPanel,BorderLayout.NORTH);
            // north]
            // center[
            JPanel centerPanelOfSecondPanel=new JPanel();
            centerPanelOfSecondPanel.setLayout(new BorderLayout());// ????????????/
            tabbedPaneOfSecondPanel=new JTabbedPane();
            JComboBox body=new JComboBox(new String[]{"Multipart Form","Form URL Encoded", "GraphQL Query", "JSON", "NTLM", "XML", "YAML", "EDN", "Binary File", "No Body"});

            //JButton body=new JButton();
            /*
            body.addActionListener(bodyEvent->{
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
            });

             */
            //JButton auth=new JButton();
            /*
            auth.addActionListener(authEvent->{
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
                popupMenu.show(frame , 364, 120);
            });

             */
            JComboBox auth=new JComboBox(new String[]{"Basic Auth","Digest Auth", "OAuth 1.0", "OAuth 2.0", "Microsoft NTLM", "AWS IAM v4", "Bearer Token", "Hawk", "Atlassian ASAP", "Netrc File"});
            JButton query=new JButton();
            JButton header=new JButton();
            JButton docs=new JButton();
            tabbedPaneOfSecondPanel.add("Body v ",body);
            tabbedPaneOfSecondPanel.add("Auth v ",auth);
            tabbedPaneOfSecondPanel.add("query",query);
            tabbedPaneOfSecondPanel.add("header",header);
            tabbedPaneOfSecondPanel.add("docs",docs);
            //tabbedPaneOfSecondPanel.add("aaaa",jComboBox);
            Dimension dimension=new Dimension();
            dimension.height=60;
            tabbedPaneOfSecondPanel.setPreferredSize(dimension);
            //(new String[]{"No Aut","Digest Auth", "OAuth 1", "OAuth 2", "NTLM", "AWS", "Hawk", "ASAP", "Netrc", "Bearer"});
            centerPanelOfSecondPanel.add(tabbedPaneOfSecondPanel, BorderLayout.NORTH);
            secondPanel.add(centerPanelOfSecondPanel,BorderLayout.CENTER);
            // center]
            frame.add(secondPanel);

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
            });
            if(requestList.size()!=0)
                System.out.println(requestList.get(0).getButton().getText());


            // new request action]
        });


    }

    private class buttonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(tabbedPaneOfSecondPanel.getSelectedIndex()==0){

            }
            else if(tabbedPaneOfSecondPanel.getSelectedIndex()==1){

            }
            if(actionEvent.getSource().equals(firstPanelButton.get(0))){
                plusButtonAction();
            }
        }
    }
}
