package com.company;

import javax.swing.*;

public class Request {
    private String address;
    private JLabel label;
    private JButton button;


    public Request(JLabel label, JButton button){
        this.label=new JLabel();
        this.label=label;
        this.button=new JButton();
        this.button=button;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getButton() {
        return button;
    }


}
