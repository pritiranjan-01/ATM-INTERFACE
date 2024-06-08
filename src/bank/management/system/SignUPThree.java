
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUPThree extends JFrame implements ActionListener {
    JRadioButton sv,curr,fd,rd;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    Random rand=new Random();
    UUID uuid = UUID.randomUUID();
     String cardno = String.format("%019d", Math.abs(uuid.getMostSignificantBits()));
    String pinno = String.format("%04d", Math.abs(rand.nextInt(10000)));
    
    
    SignUPThree(String formno){
        this.formno=formno;
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3:Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,25));
        l1.setBounds(200,30,300,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,100,300,40);
        add(type);
    
        sv=new JRadioButton("Savings Account");
        sv.setFont(new Font("Raleway",Font.BOLD,16));
        sv.setBackground(Color.WHITE);
        sv.setBounds(100,155,180,20);
        add(sv);
    
         curr=new JRadioButton("Current Account");
        curr.setFont(new Font("Raleway",Font.BOLD,16));
        curr.setBackground(Color.WHITE);
        curr.setBounds(350,155,180,20);
        add(curr);
    
        fd=new JRadioButton("Fixed Deposit Account");
        fd.setFont(new Font("Raleway",Font.BOLD,16));
        fd.setBackground(Color.WHITE);
        fd.setBounds(100,195,250,20);
        add(fd);
        
        rd=new JRadioButton("Recurring Deposit Account");
        rd.setFont(new Font("Raleway",Font.BOLD,16));
        rd.setBackground(Color.WHITE);
        rd.setBounds(350,195,250,20);
        add(rd);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(sv);bg.add(rd);bg.add(curr);bg.add(fd);
    
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.ITALIC|Font.BOLD, 22));
        card.setBounds(100, 250, 150, 40);  // Adjusted Y-coordinate
        add(card);
        
        String last=cardno.substring(cardno.length() - 2);
        JLabel cno = new JLabel("XXXX-XXXX-XXXX-XXXX-X"+last);
        cno.setFont(new Font("Raleway", Font.ITALIC|Font.BOLD, 22));
        cno.setBounds(270,250,400,40);  // Adjusted Y-coordinate
        add(cno);
            
        JLabel pin = new JLabel("PIN Number:");
        pin.setFont(new Font("Raleway", Font.ITALIC|Font.BOLD, 22));
        pin.setBounds(100, 300, 150, 40);  // Adjusted Y-coordinate
        add(pin);
        
        JLabel pnum = new JLabel("XXXX");
        pnum.setFont(new Font("Raleway", Font.ITALIC|Font.BOLD, 22));
        pnum.setBounds(270, 300, 100, 40);  
        add(pnum);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 370, 200, 40);  
        add(services);
        
        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,420,200,30);
        add(c1);
        
         c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,420,200,30);
        add(c2);
        
         c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,470,200,30);
        add(c3);
        
         c4=new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,470,200,30);
        add(c4);
        
         c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,520,200,30);
        add(c5);
        
         c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,520,200,30);
        add(c6);
        
         c7=new JCheckBox("I Hereby declare that the above entered details are correct to the best of knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(70,560,600,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(520,600,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(640,600,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
        setSize(780,720);
        setLocation(350,30);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
           String accounttype=null;
           if(sv.isSelected()){
               accounttype=sv.getText();
           }
           else if(rd.isSelected()){
               accounttype=rd.getText();
           }
           else if(curr.isSelected()){
               accounttype=curr.getText();
           }
           else if(fd.isSelected()){
               accounttype=fd.getText();
           }
          
           
           
           
           
           String services="";
           if(c1.isSelected()){
               services=services+" "+c1.getText();
           }
           if(c2.isSelected()){
               services=services+" "+c2.getText();
           }
           if(c3.isSelected()){
               services=services+" "+c3.getText();
           }
           if(c4.isSelected()){
               services=services+" "+c4.getText();
           }
           if(c5.isSelected()){
               services=services+""+c5.getText();
           }
           if(c6.isSelected()){
               services=services+""+c6.getText();
           }
           try{
               if(accounttype.equals("")){
                   JOptionPane.showMessageDialog(null,"Account Type is required");
               }
               else if(c7.isSelected()==false){
                   JOptionPane.showMessageDialog(null, "Check the Declaration Box");
               }
               else{
               Conn c=new Conn();
               String query="insert into signupthree values('" +formno+ "', '" +accounttype+ "', '" +cardno+ "', '" +pinno+ "', '" +services+ "')";
               c.s.executeUpdate(query);
               String query1="insert into login values('" +formno+ "', '" +cardno+ "', '" +pinno+ "')";
               c.s.executeUpdate(query1);
               JOptionPane.showMessageDialog(null,"ACCOUNT CREATED SUCCESSFULLY!!!\nCard No-"+cardno+"\nPin No-"+pinno);
               int amount=0;
               String amt=""+amount;
               String query2="insert into accounts values('" +cardno+ "', '" +pinno+ "', '" +amt+ "')";
               c.s.executeUpdate(query2);
               setVisible(false);
               new Login().setVisible(true);
               
               }
               
               
           }catch(Exception e){
               System.out.println(e);
           }
           
        }
        if(ae.getSource()==cancel){
            
        }
    }
    
    
    
    public static void main(String args[]){
        new SignUPThree("");
    }
}

