package ems;

import javax.swing.*;
import java.awt.event.*;

public class Password extends JFrame implements ActionListener{
    
    String eid;
    JTextField tpswd,tcfrmpswd;
    JButton save,back;
    
    Password(String eid){
        
        this.eid = eid;
        
        JLabel lpswd = new JLabel("New Password");
        lpswd.setBounds(125,50,100,30);
        add(lpswd);
        
        tpswd = new JTextField();
        tpswd.setBounds(125,80,150,30);
        add(tpswd);
        
        JLabel lcfrmpswd = new JLabel("Confirm Password");
        lcfrmpswd.setBounds(125,150,150,30);
        add(lcfrmpswd);
        
        tcfrmpswd = new JTextField();
        tcfrmpswd.setBounds(125,180,150,30);
        add(tcfrmpswd);
        
        save = new JButton("Save");
        save.setBounds(75,250,100,30);
        save.addActionListener(this);
        add(save);
        
        back = new JButton("Back");
        back.setBounds(225,250,100,30);
        back.addActionListener(this);
        add(back);
        
        
        setLayout(null);
        setSize(400, 400);
        setLocation(450, 200);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== save){
        
            if(tpswd.getText().equals(tcfrmpswd.getText())){

                String query = "update emplogin set password = '"+tpswd.getText()+"' where empId ='"+eid+"'";
                try{
                    Conn conn = new Conn();
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Password Changed");
                    setVisible(false);
                    new EmpMenu(eid);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        else{
            setVisible(false);
            new EmpMenu(eid);
        }
    }
    
    public static void main(String[] args){
            new Password("");
    }
    
}
