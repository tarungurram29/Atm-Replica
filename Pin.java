package Atm.Replica.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;

public class Pin extends JFrame implements ActionListener {
    JPasswordField pininput,pininput1;
    JButton change,menu;
    String mypin;
    public Pin(String mypin){
        this.mypin=mypin;

        JLabel title = new JLabel("Enter Pinnumber:");
        title.setBounds(230, 260, 700, 35);
        title.setFont(new Font("Systems", Font.BOLD, 16));
        title.setForeground(Color.white);
        add(title);
        pininput = new JPasswordField();
        pininput.setFont(new Font("Systems", Font.BOLD, 14));
        pininput.setBounds(370, 260, 140, 30);
        add(pininput);

        JLabel title1 = new JLabel("Re-enter Pinnumber:");
        title1.setBounds(200, 290, 700, 35);
        title1.setFont(new Font("Systems", Font.BOLD, 16));
        title1.setForeground(Color.white);
        add(title1);
        pininput1 = new JPasswordField();
        pininput1.setFont(new Font("Systems", Font.BOLD, 14));
        pininput1.setBounds(370, 292, 140, 30);
        add(pininput1);

        change = new JButton("CHANGE");
        change.setBounds(310, 400, 100, 30);
        change.addActionListener(this);
        add(change);
        menu = new JButton("MENU");
        menu.setBounds(310, 450, 100, 30);
        menu.addActionListener(this);
        add(menu);

        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image logo1 = logo.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon logo3 = new ImageIcon(logo1);
        JLabel logo4 = new JLabel(logo3);
        add(logo4);

        setSize(1000,800);
        setLocation(350,50);
        // setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        String pinput1 = pininput.getText();
//        String pinput2 = pininput1.getText();
//        if(!pinput1.equals(pinput2)){
//            JOptionPane.showMessageDialog(null,"Pin didnt matched to previous pin!");
//            return;
//        }
//            if(e.getSource()==change) {
//                if (pininput.getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Enter new pin");
//                }if (pininput1.getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Re-enter pin");
//                }try {
//                    Conn c = new Conn();
//                    String q1 = "update bank set pinnumber='" + pinput2 + "' where pinnumber = '" + mypin + "'";
//                    String q2 = "update login set pinnumber='" + pinput2 + "' where pinnumber = '" + mypin + "'";
//                    String q3 = "update signupthree set pinnumber='" + pinput2 + "' where pinnumber = '" + mypin + "'";
//
//                    c.s.executeUpdate(q1);
//                    c.s.executeUpdate(q2);
//                    c.s.executeUpdate(q3);
//
//                    JOptionPane.showMessageDialog(null,"Pin changed succesfully");
//                    setVisible(false);
//                    new TransactionMenu("").setVisible(true);
//                }catch(Exception ex){
//                    ex.printStackTrace();
//                }
//
//            }
//            else if(e.getSource()==menu){
//                setVisible(false);
//                new TransactionMenu("").setVisible(true);
//            }
            String pinput1 = pininput.getText();
            String pinput2 = pininput1.getText();
            if(!pinput1.equals(pinput2)){
                JOptionPane.showMessageDialog(null,"Pin didnt matched");
                return;
            }
        if(e.getSource()==change){
            if (pininput.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Enter pin its empty");
            }
            if(pininput1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Re-Enter pin its empty");
            }
                try{
                    Conn c = new Conn();
                    String query1 = "update bank set pinnumber = '"+pinput2+"' where pinnumber='"+mypin+"'";
                    String query2 = "update login set pinnumber = '"+pinput2+"' where pinnumber='"+mypin+"'";
                    String query3 = "update signupthree set pinnumber = '"+pinput2+"' where pinnumber='"+mypin+"'";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            JOptionPane.showMessageDialog(null,"Pin changed succesfully");
                    setVisible(false);
                    new TransactionMenu("").setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
