
package bank.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
/**
 *
 * @author ajths
 */
public class SignUPOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTF,fnameTF,emailTF,cityTF,addrTF,pinTF;
    JButton next;
    JComboBox cb;
    JRadioButton male,female;
    JDateChooser dateChooser;
    SignUPOne(){
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()% 9000l)+ 1000L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO:"+ random);
        formno.setFont(new Font("Raleway",Font.BOLD,26));
        formno.setBounds(150,20,600,40);
        add(formno);
        
        JLabel persdet=new JLabel("Page 1: Personal Details");
        persdet.setFont(new Font("Raleway",Font.BOLD,20));
        persdet.setBounds(200,60,400,40);
        add(persdet);
        
        JLabel name=new JLabel("NAME:*");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,120,100,30);
        add(name);
        
        nameTF=new JTextField();
        nameTF.setFont(new Font("Raleway",Font.BOLD,20));
        nameTF.setBounds(350,120,300,30);
        add(nameTF);
        
        JLabel fname=new JLabel("FATHERS NAME:*");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,170,200,30);
        add(fname);
        
        fnameTF=new JTextField();
        fnameTF.setFont(new Font("Raleway",Font.BOLD,20));
        fnameTF.setBounds(350,170,300,30);
        add(fnameTF);
        
        JLabel DOB=new JLabel("DATE OF BIRTH:*");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(100,220,200,30);
        add(DOB);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(350,220,200,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
         JLabel gender=new JLabel("GENDER:*");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,270,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(350,270,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(450,270,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergrp=new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);
        
        JLabel email=new JLabel("EMAIL:*");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,320,200,30);
        add(email);
        
        emailTF=new JTextField();
        emailTF.setFont(new Font("Raleway",Font.BOLD,20));
        emailTF.setBounds(350,320,300,30);
        add(emailTF);
        
         JLabel addr=new JLabel("ADDRESS:*");
        addr.setFont(new Font("Raleway",Font.BOLD,20));
        addr.setBounds(100,370,200,30);
        add(addr);
        
        addrTF=new JTextField();
        addrTF.setFont(new Font("Raleway",Font.BOLD,20));
        addrTF.setBounds(350,370,300,30);
        add(addrTF);
        
         JLabel City=new JLabel("CITY:*");
        City.setFont(new Font("Raleway",Font.BOLD,20));
        City.setBounds(100,420,200,30);
        add(City);
        
        cityTF=new JTextField();
        cityTF.setFont(new Font("Raleway",Font.BOLD,20));
        cityTF.setBounds(350,420,300,30);
        add(cityTF);
        
         JLabel State=new JLabel("State:*");
        State.setFont(new Font("Raleway",Font.BOLD,20));
        State.setBounds(100,470,200,30);
        add(State);
        
        String[] choices = { "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};
        cb = new JComboBox(choices);
        cb.setBackground(Color.WHITE);
        cb.setBounds(350,470,100,30);
        add(cb);
        
        JLabel PIN=new JLabel("PIN CODE:*");
        PIN.setFont(new Font("Raleway",Font.BOLD,20));
        PIN.setBounds(100,520,200,30);
        add(PIN);
        
        pinTF=new JTextField();
        pinTF.setFont(new Font("Raleway",Font.BOLD,20));
        pinTF.setBounds(350,520,300,30);
        add(pinTF);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setBounds(570,570,80,30);
        next.addActionListener(this);
        add(next);
        
        JLabel imp=new JLabel("Fields mentioned with * mark are essential");
        imp.setFont(new Font("Raleway",Font.BOLD | Font.ITALIC,18));
        imp.setBounds(70,570,400,30);
        add(imp);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(700,700);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
      String formno=""+random;
      String name=nameTF.getText();
      String fname=fnameTF.getText();
      String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
      String gender="";
      if(male.isSelected()){
          gender="Male";
      }else if(female.isSelected()){
          gender = "Female";
      }
      String email=emailTF.getText();
      String address=addrTF.getText();
      String city=cityTF.getText();
      String state = cb.getSelectedItem().toString(); 
      String pin=pinTF.getText();
      
      
      try { 
          if(name.equals("")){
              JOptionPane.showMessageDialog(null,"Name is Required");
          }
          
          else if(fname.equals("")){
              JOptionPane.showMessageDialog(null,"Father's Name is Required");
          }
          else if(dob.equals("")){
              JOptionPane.showMessageDialog(null,"Date of Birth is Required");
          }
          else if(gender.equals("")){
              JOptionPane.showMessageDialog(null,"Select the Gender");
          }
          else if(email.equals("")){
              JOptionPane.showMessageDialog(null,"Email is Required");
          }
          else if(address.equals("")){
              JOptionPane.showMessageDialog(null,"Address is Required");
          }
          else if(city.equals("")){
              JOptionPane.showMessageDialog(null,"City is Required");
          }
          else if(state.equals("")){
              JOptionPane.showMessageDialog(null,"Select the State");
          }
          else if(pin.equals("")){
              JOptionPane.showMessageDialog(null,"PIN Code is Required");
          }
          else{
              Conn c =new Conn();
              String q="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
              c.s.executeUpdate(q);
              
              setVisible(false);
             new SignUPTwo(formno).setVisible(true);
            }
      }
    catch(Exception e){
        System.out.println(e);
    }
    }
    public static void main(String args[]){
        new SignUPOne();
    }
}
