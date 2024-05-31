package ems;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JButton search,update,back;
    JLabel tfname,tlname,dcdob;
    Choice cemployeeId;
    JTextField  tfaddress, tfphone, tfemail, tfsalary, tfdesignation,cbeducation;
    UpdateEmployee(){
        JLabel uplabel = new JLabel("Update Employee");
        uplabel.setBounds(150, 30, 300, 30);
        uplabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(uplabel);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(450, 30, 100, 30);
        add(cemployeeId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()) {
                cemployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/search.png"));
        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        search = new JButton(i3);
        search.setBounds(555,30,30,30);
//        search.setBackground(Color.BLACK);
        search.addActionListener(this);
        add(search);
        
        JLabel labelname = new JLabel(" First Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JLabel();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Last Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tlname = new JLabel();
        tlname.setBounds(600, 150, 150, 30);
        add(tlname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JLabel();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Higest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        cbeducation = new JTextField();
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600, 300, 150, 30);
        add(cbeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        update = new JButton("Update");
        update.setBounds(350,400,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(500,400,100,30);
        back.addActionListener(this);
        add(back);
        
        
                
        setLayout(null);
        setSize(900, 600);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == search){  
                String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        tfname.setText(rs.getString(1));
                        tlname.setText(rs.getString(2));
                        dcdob.setText(rs.getString(3));
                        tfsalary.setText(rs.getString(4));
                        tfaddress.setText(rs.getString(5));
                        tfphone.setText(rs.getString(6));
                        tfemail.setText(rs.getString(7));
                        cbeducation.setText(rs.getString(8));
                        tfdesignation.setText(rs.getString(9));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
            else if(ae.getSource() == update){
                String salary = tfsalary.getText();
                String address = tfaddress.getText();
                String phone = tfphone.getText();
                String email = tfemail.getText();
                String education = cbeducation.getText();
                String designation = tfdesignation.getText();
                try {
                    Conn conn = new Conn();
                    String query = "update employee set salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+cemployeeId.getSelectedItem()+"'";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Details updated successfully");
                    setVisible(false);
                    new AdminMenu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                setVisible(false);
                new AdminMenu();
            }
        
    }
    
    public static void main(String[] args){
        new UpdateEmployee();
    }
}
