
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField amountTF;
    JButton back,depos;
    String pinnum,cardnum;
    LocalDateTime ldt = LocalDateTime.now();
   java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(ldt);
   Deposit(String pinnum,String cardnum){
       this.pinnum=pinnum;
       this.cardnum=cardnum;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,750,750);
       add(image);
       
       JLabel text= new JLabel("Enter the amount you want to deposit");
        text.setBounds(150,240,500,30);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(text);
        
        amountTF=new JTextField();
        amountTF.setBounds(170,290,200,30);
        amountTF.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(amountTF);
        
        depos=new JButton("Deposit");
        depos.setBounds(300,350,130,26);
        depos.setBackground(Color.white);
        depos.addActionListener(this);
        image.add(depos);
        
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
        if(ae.getSource()==depos){
            if(amountTF.equals("")){
                JOptionPane.showMessageDialog(null,"Enter the amount you want to deposit");
            }else{
                Conn c=new Conn();
                String amt=amountTF.getText();
                int amnt=Integer.parseInt(amt);
                String query1="select amount from accounts where cardnumber = '"+cardnum+"' and pin = '"+pinnum+"'";
                try{
                    ResultSet rs=c.s.executeQuery(query1);
                    if (rs.next()) {
                        int amount = rs.getInt("amount");
                        amount=amount+amnt;
                        String query2="update accounts set amount= '"+amount+"' where cardnumber = '"+cardnum+"' and pin = '"+pinnum+"'";
                        String query="insert into logs values('" +cardnum+ "',  '"+amt+"' ,  'desposit' , '" +timestamp+ "')";
                        int rep=c.s.executeUpdate(query2);
                        c.s.executeUpdate(query);
                  
                        if(rep>0){
                            JOptionPane.showMessageDialog(null,"Rs."+amnt+" deposited in your account");
                            setVisible(false);
                            new Transactions(pinnum,cardnum).setVisible(true);
                            }else{
                            JOptionPane.showMessageDialog(null,"Account not found");
                        }
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnum,cardnum).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Deposit("","");
    }
    
}
