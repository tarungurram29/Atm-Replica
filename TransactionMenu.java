package Atm.Replica.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionMenu extends JFrame implements ActionListener {
    JButton balance1,deposit,withdraw,pinchange,exit;
    String mypin;
    String balance;
    public TransactionMenu(String mypin){
        this.mypin=mypin;

        JLabel pininfo = new JLabel("Pin Number :" + mypin);
        pininfo.setBounds(270,230,700,35);
        pininfo.setFont(new Font("Systems",Font.BOLD,16));
        pininfo.setForeground(Color.white);
        add(pininfo);

        JLabel heading = new JLabel("Transaction Menu");
        heading.setBounds(295,200,700,35);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Systems",Font.BOLD,16));
        add(heading);

        balance1 = new JButton("BALANCE");
        balance1.setBounds(200,300,150,30);
        balance1.addActionListener(this);
        add(balance1);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(360,300,150,30);
        deposit.addActionListener(this);
        add(deposit);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(200,350,150,30);
        withdraw.addActionListener(this);
        add(withdraw);

        pinchange = new JButton("PINCHANGE");
        pinchange.setBounds(360,350,150,30);
        pinchange.addActionListener(this);
        add(pinchange);

        exit = new JButton("EXIT");
        exit.setBounds(360,400,150,30);
        exit.addActionListener(this);
        add(exit);



        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image logo1 = logo.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon logo3 = new ImageIcon(logo1);
        JLabel logo4 = new JLabel(logo3);
        add(logo4);



        setSize(1000,800);
        setLocation(350,50);
//        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource()==balance1){
              setVisible(false);
              new Balance("").setVisible(true);
          } else if (e.getSource()==deposit) {
              setVisible(false);
              new Deposit("").setVisible(true);
          } else if (e.getSource()==withdraw) {
              setVisible(false);
              new Withdraww("").setVisible(true);
          }else if(e.getSource()==pinchange) {
              setVisible(false);
              new Pin("").setVisible(true);
          } else if(e.getSource()==exit){
                 new Main("");
          }
    }

    public static void main(String[] args) {
        new TransactionMenu("");
    }
}
