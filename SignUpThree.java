package Atm.Replica.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JRadioButton c1,c2,c3,c4,c5,c6;
    JButton back,submit;
    String formno;
    String cardnumber;
    String pinnumber;
    public SignUpThree(String formno){
        setTitle("Signup Page");
        getContentPane().setBackground(Color.white);
        setLayout(null);
        this.formno=formno;

        JLabel acctype = new JLabel("Account Type :");
        acctype.setFont(new Font("Raleway",Font.BOLD,18));
        acctype.setBounds(60,60,200,60);
        add(acctype);
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,10));
        r1.setBounds(100,100,200,60);
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,10));
        r2.setBounds(300,100,200,60);
        r2.setBackground(Color.white);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,10));
        r3.setBounds(100,140,200,60);
        r3.setBackground(Color.white);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,10));
        r4.setBounds(300,140,200,60);
        r4.setBackground(Color.white);
        add(r4);

        JLabel pageno3 = new JLabel("Page 3: Account Details");
        pageno3.setFont(new Font("Raleway", Font.BOLD, 22));
        pageno3.setBounds(200,10,600,60);
        add(pageno3);

        JLabel card = new JLabel("Card Number : xxxx-xxxx-xxxx-7890");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(60,200,1000,60);
        add(card);
        JLabel cardinfo = new JLabel("Card of 16-DIGITS");
        cardinfo.setBounds(60,230,100,60);
        add(cardinfo);

        JLabel pin = new JLabel("Pin : xxxx");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(60,270,400,60);
        add(pin);

        JLabel pininfo = new JLabel("Pin of 4-DIGITS");
        pininfo.setBounds(60,300,400,30);
        add(pininfo);

        JLabel service = new JLabel("Services Required :");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(60,320,600,60);

        c1 = new JRadioButton("Atm Card");
        c1.setBounds(90,340,100,20);
        c1.setBackground(Color.white);
        add(c1);

        c2 = new JRadioButton("Cheque Book");
        c2.setBounds(300,340,100,20);
        c2.setBackground(Color.white);
        add(c2);

        c3 = new JRadioButton("Internet Banking");
        c3.setBounds(90,370,150,20);
        c3.setBackground(Color.white);
        add(c3);

        c4 = new JRadioButton("Mobile Banking");
        c4.setBounds(300,370,150,20);
        c4.setBackground(Color.white);
        add(c4);

        c5 = new JRadioButton("Email And SMS Alerts");
        c5.setBounds(90,400,150,20);
        c5.setBackground(Color.white);
        add(c5);

        c6 = new JRadioButton("Credit Card");
        c6.setBounds(300,400,100,20);
        c6.setBackground(Color.white);
        add(c6);

        back = new JButton("Back");
        back.setBounds(300,500,100,30);
        back.addActionListener(this);
        add(back);

        submit = new JButton("Submit");
        submit.setBounds(450,500,100,30);
        submit.addActionListener(this);
        add(submit);


        setVisible(true);
        setSize(650,600);
        setLocation(500,100);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            String accounttype = null;
            if(r1.isSelected()){
                accounttype = "Saving Account";
            } else if (r2.isSelected()) {
                accounttype = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accounttype = "Current Account";
            } else if (r4.isSelected()){
                accounttype = "Recurring Deposit Account";
            }

            String servicess = null;
            if(c1.isSelected()){
                servicess = "Atm Card";
            } else if(c2.isSelected()) {
                servicess = "Cheque Book";
            } else if(c3.isSelected()) {
                servicess = "Internet Banking";
            } else if(c4.isSelected()) {
                servicess = "Mobile Banking";
            } else if(c5.isSelected()) {
                servicess = "Email And SMS Alerts";
            } else if(c6.isSelected()) {
                servicess = "Credit Card";
            } else{
                servicess = "null";
            }

            Random random = new Random();
            cardnumber = "" + Math.abs((random.nextLong() % 90000L)) + 50900L;

            pinnumber = "" + Math.abs(random.nextLong() & 9000L)+ 1000L;


            if(ae.getSource()==submit) {
            try{
                Conn c = new Conn();
                String query = "insert into signupthree values('"+formno+"','"+cardnumber+"','"+pinnumber+"','"+accounttype+"','"+servicess+"')";
                String query1 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);

            }catch(Exception e){
                System.out.println(e);
            }
                JOptionPane.showMessageDialog(null,"Cardnumber:"+cardnumber+"\n pinnumber:"+pinnumber);
                setVisible(false);
                new Main("");
            }else if(ae.getSource()==back) {
                setVisible(false);
                new SignUpTwo("").setVisible(true);
            }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
