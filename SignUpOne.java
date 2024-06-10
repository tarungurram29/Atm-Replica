package Atm.Replica.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class SignUpOne extends JFrame implements ActionListener {
    JTextField name1,fname1,email1,addr1,city1,postalc1;
    JComboBox gender3,marital2;
    JButton next1;
    long random;
    public SignUpOne(){
        setTitle("Signup Page");
        getContentPane().setBackground(Color.white);
        setLayout(null);

        Random ran = new Random();
        random = Math.abs(ran.nextLong() & 9000l)+ 1000l;

        JLabel formno = new JLabel("Your Registeration Number " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(130,20,600,60);
        add(formno);

        JLabel pageno1 = new JLabel("Page 1: Personal Details");
        pageno1.setFont(new Font("Raleway", Font.BOLD, 22));
        pageno1.setBounds(300,100,600,30);
        add(pageno1);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,150,200,30);
        add(name);
        name1 = new JTextField();
        name1.setBounds(200,150,500,30);
        add(name1);

        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 200, 200, 30);
        add(fname);
        fname1 = new JTextField();
        fname1.setBounds(260, 200, 440, 30);
        add(fname1);

//        JLabel dob = new JLabel("Date of Birth :");
//        dob.setFont(new Font("Raleway",Font.BOLD,20));
//        dob.setBounds(100,250,200,30);
//        add(dob);

        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,300,200,30);
        add(gender);
        String gender1[] ={"Male","Female","Prefer Not To Say"};
        gender3 = new JComboBox<>(gender1);
        gender3.setBounds(200,300,500,30);
        add(gender3);

        JLabel email = new JLabel("Email :");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,350,200,30);
        add(email);
        email1 = new JTextField();
        email1.setBounds(200,350,500,30);
        add(email1);

        JLabel marital = new JLabel("Marital :");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,400,200,30);
        add(marital);
        String marital1[] = {"Married","Not Married",};
        marital2 = new JComboBox<>(marital1);
        marital2.setBounds(200,400,500,30);
        add(marital2);


        JLabel addr = new JLabel("Address :");
        addr.setFont(new Font("Raleway",Font.BOLD,20));
        addr.setBounds(100,450,200,30);
        add(addr);
        addr1 = new JTextField();
        addr1.setBounds(200,450,500,30);
        add(addr1);

        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,500,200,30);
        add(city);
        city1 = new JTextField();
        city1.setBounds(200,500,500,30);
        add(city1);

        JLabel postalc = new JLabel("Pincode :");
        postalc.setFont(new Font("Raleway",Font.BOLD,20));
        postalc.setBounds(100,550,200,30);
        add(postalc);
        postalc1 = new JTextField();
        postalc1.setBounds(200,550,500,30);
        add(postalc1);

        next1 = new JButton("Next");
        next1.addActionListener(this);
        next1.setBounds(380,640,100,30);
        add(next1);

        setSize(850,760);
        setVisible(true);
        setLocation(400,50);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = name1.getText();
        String fname = fname1.getText();
        String gender = (String) gender3.getSelectedItem();
        String email = email1.getText();
        String marital = (String) marital2.getSelectedItem();
        String addr = addr1.getText();
        String city = city1.getText();
        String postalc = postalc1.getText();

        if(ae.getSource()==next1) {
        try{
            Conn c = new Conn();
            String query = "insert into signupone values('"+formno+"','"+name+"','"+fname+"','"+gender+"','"+email+"','"+marital+"','"+addr+"','"+city+"','"+postalc+"')";
            c.s.executeUpdate(query);

        }catch(Exception ex){
            ex.printStackTrace();
        }
            new SignUpTwo(formno).setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}
