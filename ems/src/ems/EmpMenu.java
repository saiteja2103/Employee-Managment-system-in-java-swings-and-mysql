package ems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class EmpMenu extends JFrame implements ActionListener{
    
    String eid;
    JPanel menu;
    JButton profile,attendence,leave,logout,changepass;
    
    JLabel tfname, tlname, dcdob, cbeducation, tfaddress, tfphone, tfaadhar,tempid, tfemail, tfsalary, tfdesignation;

    
    EmpMenu(String username){
        
        this.eid =username;
        
        
        menu = new JPanel();
        menu.setBounds(0 ,0,200,500);
        menu.setLayout(null);
        menu.setBackground(Color.GRAY);
        add(menu);
        
        profile = new JButton("Profile");
        profile.setBounds(0,100,200,20);
        profile.addActionListener(this);
        menu.add(profile);
        
        attendence = new JButton("Attendence");
        attendence.setBounds(0,120,200,20);
        attendence.addActionListener(this);
        menu.add(attendence);
        
        leave = new JButton("Apply Leave");
        leave.setBounds(0,140,200,20);
        leave.addActionListener(this);
        menu.add(leave);
        
        logout = new JButton("Logout");
        logout.setBounds(0,180,200,20);
        logout.addActionListener(this);
        menu.add(logout);
        
        changepass = new JButton("Change Password");
        changepass.setBounds(0,160,200,20);
        changepass.addActionListener(this);
        menu.add(changepass);
        
        JLabel labelname = new JLabel(" First Name");
        labelname.setBounds(250, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JLabel();
        tfname.setBounds(400, 150, 150, 30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Last Name");
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tlname = new JLabel();
        tlname.setBounds(800, 150, 150, 30);
        add(tlname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(250, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JLabel();
        dcdob.setBounds(400, 200, 150, 30);
        add(dcdob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(600, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JLabel();
        tfsalary.setBounds(800, 200, 150, 30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(250, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(400, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(600, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JLabel();
        tfphone.setBounds(800, 250, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(250, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JLabel();
        tfemail.setBounds(400, 300, 150, 30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Higest Education");
        labeleducation.setBounds(600, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        cbeducation = new JLabel();
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(800, 300, 150, 30);
        add(cbeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(250, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation = new JLabel();
        tfdesignation.setBounds(400, 350, 150, 30);
        add(tfdesignation);
        
        tfaadhar = new JLabel();
        tfaadhar.setBounds(800, 350, 150, 30);
        add(tfaadhar);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(600, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(250, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        tempid = new JLabel(username);
        tempid.setBounds(400, 400, 150, 30);
        tempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(tempid);
        
        String query = "select * from employee where empId="+eid;
             try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString(2));
                    tlname.setText(rs.getString(3));
                    dcdob.setText(rs.getString(4));
                    tfsalary.setText(rs.getString(5));
                    tfaddress.setText(rs.getString(6));
                    tfphone.setText(rs.getString(7));
                    tfemail.setText(rs.getString(8));
                    cbeducation.setText(rs.getString(9));
                    tfdesignation.setText(rs.getString(10));
                    tfaadhar.setText(rs.getString(11));
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        
        setLayout(null);
        setSize(1000, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == profile){
            String query = "select * from employee where empId="+eid;
             try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString(2));
                    tlname.setText(rs.getString(3));
                    dcdob.setText(rs.getString(4));
                    tfsalary.setText(rs.getString(5));
                    tfaddress.setText(rs.getString(6));
                    tfphone.setText(rs.getString(7));
                    tfemail.setText(rs.getString(8));
                    cbeducation.setText(rs.getString(9));
                    tfdesignation.setText(rs.getString(10));
                    tfaadhar.setText(rs.getString(11));
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == attendence){
                setVisible(false);
                new Attendence(eid);
        }
        else if(ae.getSource() == leave){
                setVisible(false);
                new Leave(eid);
        }
        else if(ae.getSource()== changepass){
            setVisible(false);
            new Password(eid);
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new EmpMenu("");
    }
    
}
