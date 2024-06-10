package Atm.Replica.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignUpTwo extends JFrame implements ActionListener {
    JTextField pan1,AC1;
    JButton back1,next1;
    JComboBox religion2,category2,income2,quali2;
    String formno;
    public SignUpTwo(String formno){

        setTitle("Signup Page");
        this.formno = formno;

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel pageno2 = new JLabel("Page 2: Additional Details");
        pageno2.setFont(new Font("Raleway", Font.BOLD, 22));
        pageno2.setBounds(300,40,600,60);
        add(pageno2);

        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(150,130,100,30);
        add(religion);
        String religion1[] ={"Hindu","Chritian","Muslim","Sikh","Others"};
        religion2 = new JComboBox<>(religion1);
        religion2.setBounds(270,130,400,30);
        religion2.setBackground(Color.white);
        add(religion2);

        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(150,190,100,30);
        add(category);
        String category1[] ={"OBC","ST","SC","SBC","GENERAL"};
        category2 = new JComboBox<>(category1);
        category2.setBounds(270,190,400,30);
        category2.setBackground(Color.white);
        add(category2);

        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(150,250,100,30);
        add(income);
        String income1[] ={"None","less than 2lakh","More than 2lakh","above 5lakh","above 10lakh"};
        income2 = new JComboBox<>(income1);
        income2.setBounds(270,250,400,30);
        income2.setBackground(Color.white);
        add(income2);

        JLabel quali = new JLabel("Qualification :");
        quali.setFont(new Font("Raleway",Font.BOLD,20));
        quali.setBounds(150,310,100,30);
        add(quali);
        String quali1[] ={"None","less than 5th","6th","7th","8th","9th","SSC","HSC","UG","PG","PHD"};
        quali2 = new JComboBox<>(quali1);
        quali2.setBounds(270,310,400,30);
        quali2.setBackground(Color.white);
        add(quali2);

        JLabel pan = new JLabel("Pancard :");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(150,360,100,30);
        add(pan);
        pan1 = new JTextField();
        pan1.setFont(new Font("Raleway",Font.BOLD,20));
        pan1.setBounds(270,360,400,30);
        add(pan1);

        JLabel AC = new JLabel("Adhaarcard:");
        AC.setFont(new Font("Raleway",Font.BOLD,20));
        AC.setBounds(150,420,150,30);
        add(AC);
        AC1 = new JTextField();
        AC1.setBounds(270,420,400,30);
        AC1.setFont(new Font("Raleway",Font.BOLD,20));
        add(AC1);

        back1 = new JButton("Back");
        back1.setBounds(240,500,100,30);
        back1.addActionListener(this);
        add(back1);

        next1 = new JButton("Next");
        next1.setBounds(500,500,100,30);
        next1.addActionListener(this);
        add(next1);






        setSize(850,600);
        setVisible(true);
        setLocation(400,50);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religion2.getSelectedItem();
        String category = (String) category2.getSelectedItem();
        String income = (String) income2.getSelectedItem();
        String qualification = (String) quali2.getSelectedItem();
        String pan = pan1.getText();
        String adhaar = AC1.getText();


            if(ae.getSource()==next1) {
                try{
                 Conn c = new Conn();
                 String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+qualification+"','"+pan+"','"+adhaar+"')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new SignUpThree(formno).setVisible(true);

                }catch(Exception e){
                    System.out.println(e);
                }
            }else if(ae.getSource()==back1){
                new SignUpOne();
            }

    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
