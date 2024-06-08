package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JTextField balanceTF;
    JButton back;
    JLabel balance;
    String pinnum,cardnum;
    int amt;
   
    
   BalanceEnquiry(String pinnum,String cardnum){
       this.pinnum=pinnum;
       this.cardnum=cardnum;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,750,750);
       add(image);
       
       JLabel text= new JLabel("Your current balance is:");
        text.setBounds(150,240,450,30);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(text);
        
        balance=new JLabel();
        balance.setBounds(330,240,200,30);
        balance.setFont(new Font("Raleway",Font.BOLD,22));
        
        
        try{
            String query1="select amount from accounts where cardnumber = '"+cardnum+"' and pin = '"+pinnum+"'";
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery(query1);
            if(rs.next()){
            int amt = rs.getInt("amount");
            balance.setText(""+amt);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        balance.setForeground(Color.white);
        image.add(balance);
        
        
        
        
     
        
        back=new JButton("Back");
        back.setBounds(300,377,130,26);
        back.setBackground(Color.white);
        back.addActionListener(this);
        image.add(back);
        
       
       
       
       
       
       
       
       setSize(750,750);
       setLocation(300,0);
       setVisible(true);
   
   
   }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnum,cardnum).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("","");
    }
    
}
