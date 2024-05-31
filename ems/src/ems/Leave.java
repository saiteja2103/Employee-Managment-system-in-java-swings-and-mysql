package ems;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Leave extends JFrame implements ActionListener{
    
    String eid;
    JDateChooser dfrom,dto;
    JButton apply,back;
    JComboBox cbleaves;
    JTextArea tdecp;
    
    Leave(String eid){
        this.eid = eid;
        
        JLabel leid =new JLabel("Emp Id: "+eid);
        leid.setBounds(50,50,100,30);
        add(leid);
        
        JLabel lfrom = new JLabel("From: ");
        lfrom.setBounds(50,100,50,30);
        add(lfrom);
        
        dfrom = new JDateChooser();
        dfrom.setBounds(100, 100, 150, 30);
        add(dfrom);
        
        JLabel lto = new JLabel("To: ");
        lto.setBounds(300,100,50,30);
        add(lto);
        
        dto = new JDateChooser();
        dto.setBounds(350, 100, 150, 30);
        add(dto);
        
        JLabel lselect = new JLabel("Select Category:");
        lselect.setBounds(50, 150, 100, 30);
        add(lselect);
        
        String leaves[] = {"Medical Leave","Casual Leave","Maternity Leave","Other"};
        cbleaves = new JComboBox(leaves);
        cbleaves.setBackground(Color.WHITE);
        cbleaves.setBounds(175, 150, 150, 30);
        add(cbleaves);
        
        JLabel decp = new JLabel("Description:");
        decp.setBounds(50,200,100,30);
        add(decp);
        
        tdecp = new JTextArea();
        tdecp.setBounds(175,200,250,150);
        add(tdecp);
        
        apply = new JButton("Apply");
        apply.setBounds(200,400,100,30);
        apply.addActionListener(this);
        add(apply);
        
        back = new JButton("Back");
        back.setBounds(350,400,100,30);
        back.addActionListener(this);
        add(back);
        
        
        setLayout(null);
        setSize(600, 600);
        setLocation(450, 200);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == apply){
            String from = ((JTextField) dfrom.getDateEditor().getUiComponent()).getText();
            String to = ((JTextField) dto.getDateEditor().getUiComponent()).getText();
            String category = (String) cbleaves.getSelectedItem();
            String desc = tdecp.getText();
            
            String query = "insert into leaves values('"+eid+"', '"+from+"', '"+to+"', '"+category+"', 'pending')";
            try{
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate("insert into description values('"+eid+"','"+desc+"')");
                JOptionPane.showMessageDialog(null, "Leave Applied successfully");
                setVisible(false);
                new EmpMenu(eid);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new EmpMenu(eid);
        }

    }
    
    public static void main(String[] args){
        new Leave("");
    }
    
}
