package Atm.Replica.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Withdraww extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdrawbttn,menubttn;
    String mypin;
    public Withdraww(String mypin){
        this.mypin=mypin;


        JLabel pininfo = new JLabel("Pin Number :" + mypin);
        pininfo.setBounds(270,230,700,35);
        pininfo.setFont(new Font("Systems",Font.BOLD,16));
        pininfo.setForeground(Color.white);
        add(pininfo);


        JLabel title = new JLabel("Enter amount that you have to withdraw:");
        title.setBounds(220,290,700,35);
        title.setFont(new Font("Systems",Font.BOLD,16));
        title.setForeground(Color.white);
        add(title);
        amount = new JTextField();
        amount.setFont(new Font("Systems",Font.BOLD,14));
        amount.setBounds(310,350,100,30);
        add(amount);


        menubttn = new JButton("MENU");
        menubttn.setBounds(200,400,100,30);
        menubttn.addActionListener(this);
        add(menubttn);

        withdrawbttn = new JButton("WITHDRAW");
        withdrawbttn.setBounds(400,400,100,30);
        withdrawbttn.addActionListener(this);
        add(withdrawbttn);


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
            String number = amount.getText();
            Date date = new Date();
            int balance = 0;
        if(e.getSource()==withdrawbttn){
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount");
            }
                try {
                    Conn c = new Conn();
                    String query = "insert into bank values ('" + mypin + "','" + date + "','Withdraw','" + number + "')";
                    c.s.executeUpdate(query);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Rs." + number + "Withdraw");
                setVisible(false);
                new TransactionMenu("").setVisible(true);

            if(balance < Integer.parseInt(number)){
                JOptionPane.showMessageDialog(null,"Insufficient Balance!");
                setVisible(false);
                new TransactionMenu("").setVisible(true);
            }
        }
        if(e.getSource()==menubttn){
            setVisible(false);
            new TransactionMenu("").setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
