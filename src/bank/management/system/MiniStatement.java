
package bank.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MiniStatement extends JFrame implements ActionListener {
    String pinno,cardno;
    JButton back;
    DefaultTableModel tableModel;
    JTable table;
    JLabel backgroundLabel;
    MiniStatement(String pinno,String cardno){
       this.pinno=pinno;
       this.cardno=cardno;
       setLayout(null);
       
       
       JLabel bank=new JLabel("INDIAN BANK");
       bank.setBounds(150,20,100,20);
       add(bank);
       
       JLabel card=new JLabel("CARD NUMBER:- "+cardno.substring(0,6)+"XXXXXXXX"+cardno.substring(14,19));
       card.setBounds(20,80,300,20);
       add(card);
       
       JLabel mini=new JLabel("<html>");
       mini.setBounds(20,140,400,200);
       
       try{
           
           String query1="select * from logs where cardnumber = '"+cardno+"' order by daate DESC limit 5";
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery(query1);
           while (rs.next()) {
            
                mini.setText(mini.getText() + rs.getString("daate") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("transaction")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                
            }
        }catch(Exception e){
           System.out.println(e);
       }
       
       mini.setText(mini.getText() + "</html>");
       mini.setBackground(Color.black);
       add(mini);
       
       
       back=new JButton("Back");
        back.setBounds(200,431,130,26);
        back.setBackground(Color.white);
        back.addActionListener(this);
        add(back);
        
       
       setSize(500,500);
       setLocation(20,20);
       getContentPane().setBackground(Color.white);
       setVisible(true);
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
    if(ae.getSource()==back){
        setVisible(false);
        new Transactions(pinno,cardno).setVisible(true);
    }
    }
    
    public static void main(String args[]){
      
        new MiniStatement("","");
    }
}
