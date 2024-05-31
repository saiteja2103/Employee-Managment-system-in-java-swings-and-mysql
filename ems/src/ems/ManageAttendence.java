package ems;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ManageAttendence extends JFrame implements ActionListener{

    JButton clear,back;
    JTable table;
    
    ManageAttendence(){
        
        clear = new JButton("Clear");
        clear.setBounds(500,500,100,30);
        clear.addActionListener(this);
        add(clear);
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from attendence");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(50,100,600,400);
        add(jp);
        
        back = new JButton("Back");
        back.setBounds(650,500,100,30);
        back.addActionListener(this);
        add(back);

        
        setLayout(null);
        setSize(1100, 600);
        setLocation(50, 100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == back){
                setVisible(false);
                new AdminMenu();
            }
            else{
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate("truncate attendence");
                    ResultSet rs = c.s.executeQuery("select * from attendence");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }
    
    public static void main(String[] args){
        new ManageAttendence();
    }
}
