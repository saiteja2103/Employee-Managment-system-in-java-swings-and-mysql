package ems;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ManageLeave extends JFrame implements ActionListener{
    
    JButton approve,reject,getdetails,back;
    JTable table;
    JTextField tcat;
    JTextArea tdesc;
    Choice tempid;
    
    
    ManageLeave(){
        
        
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from leaves");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(50,100,600,400);
        add(jp);
        
        tempid = new Choice();
        tempid.setBounds(800,100,100,30);
        add(tempid);
        
        getdetails = new JButton("Get");
        getdetails.setBounds(920,100,20,20);
        getdetails.addActionListener(this);
        add(getdetails);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from leaves where status ='pending'");
            while(rs.next()) {
                tempid.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lempid = new JLabel("Emp Id:");
        lempid.setBounds(700,100,100,30);
        add(lempid);
        
        
        
        JLabel lcat = new JLabel("Category:");
        lcat.setBounds(700,200,100,30);
        add(lcat);
        
        tcat = new JTextField();
        tcat.setBounds(800,200,100,30);
        add(tcat);
        
        JLabel ldesc = new JLabel("Description");
        ldesc.setBounds(700,300,100,30);
        add(ldesc);
        
        tdesc = new JTextArea();
        tdesc.setBounds(800,300,150,70);
        add(tdesc);
        
        
        
        
        approve = new JButton("Approve");
        approve.setBounds(700, 400, 100, 30);
        approve.addActionListener(this);
        add(approve);
        
        
        reject = new JButton("Reject");
        reject.setBounds(850, 400, 100, 30);
        reject.addActionListener(this);
        add(reject);
        
        back = new JButton("Back");
        back.setBounds(775,450,100,30);
        back.addActionListener(this);
        add(back);
        
        
        
        setLayout(null);
        setSize(1100, 600);
        setLocation(50, 100);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == getdetails){
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from leaves where empId ='"+tempid.getSelectedItem()+"'");
                while(rs.next()) {
                    tcat.setText(rs.getString("category"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from description where empId ='"+tempid.getSelectedItem()+"'");
                while(rs.next()) {
                    tdesc.setText(rs.getString("description"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        else if (ae.getSource() == approve){
            try {
                String query = "update leaves set status = 'approved' where empId = '"+tempid.getSelectedItem()+"' and status = 'pending'";
                Conn c = new Conn();
                c.s.executeUpdate(query);
                setVisible(false);
                new ManageLeave();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == reject){
            try {
                String query = "update leaves set status = 'rejected' where empId = '"+tempid.getSelectedItem()+"' and status = 'pending'";
                Conn c = new Conn();
                c.s.executeUpdate(query);
                setVisible(false);
                new ManageLeave();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new AdminMenu();
        }
    }
    
    
    public static void main(String[] args){
        new ManageLeave();
    }
}
