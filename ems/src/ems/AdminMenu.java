package ems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AdminMenu extends JFrame implements ActionListener{

    JButton view, add, update, remove, leave, attendence,logout;
    
    AdminMenu() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(480, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);
        
        add = new JButton("Add Employee");
        add.setBounds(480, 80, 200, 40);
        add.addActionListener(this);
        add.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/add.png")));
        image.add(add);
        
        view = new JButton("View Employees");
        view.setBounds(690, 80, 200, 40);
        view.addActionListener(this);
        view.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/view.png")));
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(480, 140, 200, 40);
        update.addActionListener(this);
        update.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/update.png")));
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(690, 140, 200, 40);
        remove.addActionListener(this);
        remove.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/remove.png")));
        image.add(remove);
        
        leave = new JButton("Manage Leave");
        leave.setBounds(480, 200, 200, 40);
        leave.addActionListener(this);
        leave.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/leave.png")));
        image.add(leave);
        
        attendence = new JButton("Manage attendence");
        attendence.setBounds(690, 200, 200, 40);
        attendence.addActionListener(this);
        attendence.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/attendence.png")));
        image.add(attendence);
        
        logout = new JButton("Log out");
        logout.setBounds(590,300,200,40);
        logout.addActionListener(this);
        logout.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/logout.png")));
        image.add(logout);
        
        setSize(1000, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee();
        } else if(ae.getSource() == leave) {
            setVisible(false);
            new ManageLeave();
        }else if(ae.getSource() == remove){
            setVisible(false);
            new RemoveEmployee();
        }
        
        else if(ae.getSource()== attendence){
            setVisible(false);
            new ManageAttendence();
        }
        else{
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AdminMenu();
    }

}
