package Atm.Replica.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Main extends JFrame implements ActionListener{
    JTextField codeno;
    JPasswordField pinno;
    JButton signinbttn,signupbttn,clearbttn;
    public Main(String balance) {
        setTitle("ATM Machine");

        JLabel welcome = new JLabel("Welcome to Atm");
        welcome.setBounds(305, 230, 500, 16);
        welcome.setFont(new Font("Osward",Font.BOLD,16));
        welcome.setForeground(Color.white);
        add(welcome);


        JLabel code = new JLabel("Enter Code  no. ");
        code.setBounds(200, 280, 500, 16);
        code.setForeground(Color.white);
        add(code);
        codeno = new JTextField();
        codeno.setBounds(300, 280, 200, 20);
        add(codeno);

        JLabel pin = new JLabel("Enter pin ");
        pin.setBounds(200, 330, 400, 20);
        pin.setForeground(Color.white);
        add(pin);
        pinno = new JPasswordField();
        pinno.setBounds(300, 330, 200, 20);
        add(pinno);

        signinbttn = new JButton("SIGNIN");
        signinbttn.setBounds(220, 400, 100, 25);
        signinbttn.addActionListener(this);
        add(signinbttn);

        signupbttn = new JButton("SIGNUP");
        signupbttn.setBounds(320, 450, 100, 25);
        signupbttn.addActionListener(this);
        add(signupbttn);


        clearbttn = new JButton("CLEAR");
        clearbttn.setBounds(420, 400, 100, 25);
        clearbttn.addActionListener(this);
        add(clearbttn);


        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image logo1 = logo.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon logo3 = new ImageIcon(logo1);
        JLabel logo4 = new JLabel(logo3);
        add(logo4);


        setSize(1000,800);
        setLocation(350, 50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            String mycode = codeno.getText();
            String mypin = pinno.getText();
        if (e.getSource() == signinbttn) {
            try {
                Conn c = new Conn();
                String query = "select * from login where  cardnumber = '"+mycode+"' and pinnumber = '"+mypin+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new TransactionMenu(mypin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect cardnumber or pinnumber!!!");
                }
            } catch (SQLException ex) {
                 ex.printStackTrace();
            }

        } else if (e.getSource() == signupbttn){
            setVisible(false);
            new SignUpOne();
        } else if(e.getSource()==clearbttn){
            codeno.setText("");
            pinno.setText("");
        }
    }

    public static void main(String[] args){
         new Main("");
    }
}