

package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton back,hud5,thous,thous2,thous5;
    String pinnum,cardnum;
    int amt;
  LocalDateTime ldt = LocalDateTime.now();
   java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(ldt);
   
    
   FastCash(String pinnum,String cardnum){
       this.pinnum=pinnum;
       this.cardnum=cardnum;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,750,750);
       add(image);
       
       JLabel text= new JLabel("Select the amount you want to withdraw:");
        text.setBounds(140,240,450,30);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(text);
        
        thous5=new JButton("5,000");
        thous5.setBounds(300,377,130,26);
        thous5.addActionListener(this);
        thous5.setBackground(Color.white);
        image.add(thous5);
        
        thous=new JButton("1,000");
        thous.setBounds(300,350,130,26);
        thous.addActionListener(this);
        thous.setBackground(Color.white);
        image.add(thous);
        
        thous2=new JButton("2,000");
        thous2.setBounds(130,377,130,26);
        thous2.addActionListener(this);
        thous2.setBackground(Color.white);
        image.add(thous2);
        
        hud5=new JButton("500");
        hud5.setBounds(130,350,130,26);
        hud5.addActionListener(this);
        hud5.setBackground(Color.white);
        image.add(hud5);
        
       
        
        
        
        
     
        
        back=new JButton("Back");
        back.setBounds(300,431,130,26);
        back.setBackground(Color.white);
        back.addActionListener(this);
        image.add(back);
        
       
       
       
       
       
       
       
       setSize(750,750);
       setLocation(300,0);
       setVisible(true);
   
   
   }
    
    public void actionPerformed(ActionEvent ae){
        Conn c = new Conn();
        int amount = 0,rep=0;
        
        try{
            String query1="select amount from accounts where cardnumber = '"+cardnum+"' and pin = '"+pinnum+"'";
            ResultSet rs=c.s.executeQuery(query1);
            if (rs.next()) {
            amount = rs.getInt("amount");}
        }catch(Exception e){
            System.out.println(e);
        }
            
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnum,cardnum).setVisible(true);
        }else if(ae.getSource()==hud5){
            if(amount<500){
                JOptionPane.showMessageDialog(null,"Low Balance");
            }else{
                amount=amount-500;
                String query2="update accounts set amount= '"+amount+"' where cardnumber = '"+cardnum+"' and pin = '"+pinnum+"'";
                String query="insert into logs values('" +cardnum+ "',  '500' ,  'withdraw' , '" +timestamp+ "')";
                        try{rep=c.s.executeUpdate(query2);c.s.executeUpdate(query);}catch(Exception e){System.out.println(e);}
                        if(rep>0){
                            JOptionPane.showMessageDialog(null,"Rs.500 withdrawn from your account");
                            setVisible(false);
                            new Transactions(pinnum,cardnum).setVisible(true);
                            }else{
                            JOptionPane.showMessageDialog(null,"Account not found");
                        }
            }
        }else if(ae.getSource()==thous){
            if(amount<1000){
                JOptionPane.showMessageDialog(null,"Low Balance");
            }else{
                amount=amount-1000;
                String query2="update accounts set amount= '"+amount+"' where cardnumber = '"+cardnum+"' and pin = '"+pinnum+"'";
                String query="insert into logs values('" +cardnum+ "',  '1000' ,  'withdraw' , '" +timestamp+ "')";
                        try{rep=c.s.executeUpdate(query2);c.s.executeUpdate(query);}catch(Exception e){System.out.println(e);}
                        if(rep>0){
                            JOptionPane.showMessageDialog(null,"Rs.1000 withdrawn from your account");
                            setVisible(false);
                            new Transactions(pinnum,cardnum).setVisible(true);
                            }else{
                            JOptionPane.showMessageDialog(null,"Account not found");
                        }
            }
        }else if(ae.getSource()==thous2){
            if(amount<2000){
                JOptionPane.showMessageDialog(null,"Low Balance");
            }else{
                amount=amount-2000;
                String query2="update accounts set amount= '"+amount+"' where cardnumber = '"+cardnum+"' and pin = '"+pinnum+"'";
                String query="insert into logs values('" +cardnum+ "',  '2000' ,  'withdraw' , '" +timestamp+ "')";
                        try{rep=c.s.executeUpdate(query2);c.s.executeUpdate(query);}catch(Exception e){System.out.println(e);}
                        if(rep>0){
                            JOptionPane.showMessageDialog(null,"Rs.2,000 withdrawn from your account");
                            setVisible(false);
                            new Transactions(pinnum,cardnum).setVisible(true);
                            }else{
                            JOptionPane.showMessageDialog(null,"Account not found");
                        }
            }
        }else if(ae.getSource()==thous5){
            if(amount<5000){
                JOptionPane.showMessageDialog(null,"Low Balance");
            }else{
                amount=amount-5000;
                String query2="update accounts set amount= '"+amount+"' where cardnumber = '"+cardnum+"' and pin = '"+pinnum+"'";
                String query="insert into logs values('" +cardnum+ "',  '5000' ,  'withdraw' , '" +timestamp+ "')";
                        try{rep=c.s.executeUpdate(query2);c.s.executeUpdate(query);}catch(Exception e){System.out.println(e);}
                        if(rep>0){
                            JOptionPane.showMessageDialog(null,"Rs.5000 withdrawn from your account");
                            setVisible(false);
                            new Transactions(pinnum,cardnum).setVisible(true);
                            }else{
                            JOptionPane.showMessageDialog(null,"Account not found");
                        }
            }
        }
    }
    
    public static void main(String args[]){
        new FastCash("","");
    }
    
}
