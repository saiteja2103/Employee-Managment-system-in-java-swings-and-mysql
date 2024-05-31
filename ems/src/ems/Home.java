package ems;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {
    
    JButton userBtn,empBtn;
    
    Home(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel title = new JLabel("Employee Management System");
        title.setBounds(150, 30, 1200, 70);
        title.setFont(new Font("serif", Font.PLAIN, 60));
        title.setForeground(Color.RED);
        image.add(title);
        
        userBtn = new JButton("Admin");
        empBtn = new JButton("Employee");
        userBtn.setBounds(400,200,100,50);
        empBtn.setBounds(400, 300, 100, 50);
        image.add(userBtn);
        image.add(empBtn);
        
        setSize(1000, 650);
        setLocation(200, 50);
        setTitle("FRONT PAGE");
        setVisible(true);
        userBtn.addActionListener(this);
        empBtn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == userBtn) {
            new AdminLogin();
            setVisible(false);
        }
        if(ae.getSource() == empBtn){
            new EmpLogin();
            setVisible(false);
        }
            
    }
    public static void main(String[] args){
        new Home();
    }
    
}
