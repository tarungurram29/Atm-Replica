package Atm.Replica.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener {
    JButton menu;
    String mypin;
    public Balance(String mypin){
        this.mypin=mypin;

        menu = new JButton("MENU");
        menu.setBounds(315,440,100,30);
        menu.addActionListener(this);
        add(menu);

        int balance=0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '" + mypin + "' ");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel display = new JLabel("Total Balance:"+balance);
        display.setBounds(250,270,600,30);
        display.setForeground(Color.white);
        display.setFont(new Font("Systems",Font.BOLD,23));
        add(display);

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
        if(e.getSource()==menu){
            setVisible(false);
            new TransactionMenu("").setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Balance("");
    }
}