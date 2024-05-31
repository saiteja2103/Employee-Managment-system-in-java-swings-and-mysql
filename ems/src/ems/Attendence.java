package ems;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

public class Attendence extends JFrame implements ActionListener {
    String eid;
    JLabel ttime,tdate,tday;
    JButton checkin,back;
    
    Attendence(String eid){
        
        this.eid = eid;
        JLabel ltime =new JLabel("Time:");
        ltime.setBounds(100,50,50,30);
        add(ltime);
        
        Date d =new Date();
        String dd = ""+d;
        String[] date = dd.split(" ");
        
        ttime = new JLabel();
        ttime.setBounds(150,50,75,30);
        ttime.setText(date[3]);
        add(ttime);
        
        JLabel lday =new JLabel("Day:");
        lday.setBounds(250,50,50,30);
        add(lday);
        
        tday = new JLabel();
        tday.setBounds(300,50,75,30);
        tday.setText(date[0]);
        add(tday);
        
        JLabel ldate =new JLabel("Date:");
        ldate.setBounds(400,50,50,30);
        add(ldate);
        
        tdate = new JLabel();
        tdate.setBounds(450,50,75,30);
        String ddd = ""+LocalDate.now();
        tdate.setText(ddd);
        add(tdate);
        
        JLabel label = new JLabel("Mark Your Attendence:");
        label.setBounds(100,150,150,30);
        add(label);
        
        checkin = new JButton("Check In");
        checkin.setBounds(100,200,100,30);
        checkin.addActionListener(this);
        add(checkin);
        
        back = new JButton("Back");
        back.setBounds(300,200,100,30);
        back.addActionListener(this);
        add(back);
        
        setLayout(null);
        setSize(600, 400);
        setLocation(450, 200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back){
            setVisible(false);
            new EmpMenu(eid);
        }
        else if (ae.getSource() == checkin){
            String time = ttime.getText();
            String date = tdate.getText();
            
            String query = "insert into attendence values('"+eid+"','"+time+"','"+date+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                checkin.setText("Logged in");
                checkin.setEnabled(false);
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    
    public static void main(String[] args){
        new Attendence("");
    }
    
}
