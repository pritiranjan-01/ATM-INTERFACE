
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton dep,wd,fc,ms,pc,be,ex;
    String pinnum,cardnum;
    
    Transactions(String pinnum,String cardnum){
        this.pinnum=pinnum;
        this.cardnum=cardnum;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);
        
        JLabel text= new JLabel("Please Select Your Transaction");
        text.setBounds(170,240,500,30);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(text);
        
        dep=new JButton("Deposit");
        dep.setBounds(130,404,130,26);
        dep.addActionListener(this);
        image.add(dep);
        
        wd=new JButton("WithDraw");
        wd.setBounds(300,404,130,26);
        wd.addActionListener(this);
        image.add(wd);
        
        fc=new JButton("Fast Cash");
        fc.setBounds(130,431,130,26);
        fc.addActionListener(this);
        image.add(fc);
        
        ms=new JButton("Mini Statement");
        ms.setBounds(300,377,130,26);
        ms.addActionListener(this);
        image.add(ms);
        
        pc=new JButton("Pin Change");
        pc.setBounds(300,350,130,26);
        pc.addActionListener(this);
        image.add(pc);
        
        be=new JButton("Balance Enquiry");
        be.setBounds(130,377,130,26);
        be.addActionListener(this);
        image.add(be);
        
        ex=new JButton("Exit");
        ex.setBounds(300,431,130,26);
        ex.addActionListener(this);
        image.add(ex);
        
        setSize(750,690);
        setLocation(350,50);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==ex){
            System.exit(0);
        }
        else if(ae.getSource()==dep){
            setVisible(false);
            new Deposit(pinnum,cardnum).setVisible(true);
        }else if(ae.getSource()==wd){
            setVisible(false);
            new Withdraw(pinnum,cardnum).setVisible(true);
        }else if(ae.getSource()==be){
            setVisible(false);
            new BalanceEnquiry(pinnum,cardnum).setVisible(true);
        }else if(ae.getSource()==fc){
            setVisible(false);
            new FastCash(pinnum,cardnum).setVisible(true);
        }else if(ae.getSource()==pc){
            setVisible(false);
            new PinChange(pinnum,cardnum).setVisible(true);
        }else if(ae.getSource()==ms){
            setVisible(false);
            new MiniStatement(pinnum,cardnum).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("","");
    }
}
