package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUPTwo extends JFrame implements ActionListener {
    JTextField anoTF,panTF,occTF,cateTF,reliTF;
    JButton next;
    JComboBox cb,inc;
    JRadioButton yes,no,yes1,no1;
    String formno;
    
    SignUPTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("New Application Form: Page 2");
        
    
        
        JLabel adddet=new JLabel("Page 2: Additional Details");
        adddet.setFont(new Font("Raleway",Font.BOLD,20));
        adddet.setBounds(200,40,400,40);
        add(adddet);
        
        JLabel Religion=new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(100,120,100,30);
        add(Religion);
        
        reliTF=new JTextField();
        reliTF.setFont(new Font("Raleway",Font.BOLD,20));
        reliTF.setBounds(350,120,300,30);
        add(reliTF);
        
        JLabel cate=new JLabel("Category:");
        cate.setFont(new Font("Raleway",Font.BOLD,20));
        cate.setBounds(100,170,200,30);
        add(cate);
        
        cateTF=new JTextField();
        cateTF.setFont(new Font("Raleway",Font.BOLD,20));
        cateTF.setBounds(350,170,300,30);
        add(cateTF);
        
        JLabel Income=new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        Income.setBounds(100,220,200,30);
        add(Income);
        
        String[] choices2 = {"0-1,00,000","1,00,001-5,00,000","5,00,001-10,00,000","Above 10,00,000" };
        inc = new JComboBox(choices2);
        inc.setBackground(Color.WHITE);
        inc.setBounds(350,220,300,30);
        add(inc);
        
         JLabel edu=new JLabel("Senior Citizen:");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,270,200,30);
        add(edu);
        
        yes=new JRadioButton("Yes");
        yes.setBounds(350,270,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no=new JRadioButton("No");
        no.setBounds(500,270,100,30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup nogrp=new ButtonGroup();
        nogrp.add(yes);
        nogrp.add(no);
        
        JLabel occ=new JLabel("Occupation:");
        occ.setFont(new Font("Raleway",Font.BOLD,20));
        occ.setBounds(100,320,200,30);
        add(occ);
        
        occTF=new JTextField();
        occTF.setFont(new Font("Raleway",Font.BOLD,20));
        occTF.setBounds(350,320,300,30);
        add(occTF);
        
         JLabel pan=new JLabel("Pan No.:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,370,200,30);
        add(pan);
        
        panTF=new JTextField();
        panTF.setFont(new Font("Raleway",Font.BOLD,20));
        panTF.setBounds(350,370,300,30);
        add(panTF);
        
         JLabel Ano=new JLabel("Aadhar No.:");
        Ano.setFont(new Font("Raleway",Font.BOLD,20));
        Ano.setBounds(100,420,200,30);
        add(Ano);
        
        anoTF=new JTextField();
        anoTF.setFont(new Font("Raleway",Font.BOLD,20));
        anoTF.setBounds(350,420,300,30);
        add(anoTF);
        
         JLabel State=new JLabel("Qualification:");
        State.setFont(new Font("Raleway",Font.BOLD,20));
        State.setBounds(100,470,200,30);
        add(State);
        
        String[] choices = {"Masters","Bachelors","Diploma","Higher-Secondary","Secondary" };
        cb = new JComboBox(choices);
        cb.setBackground(Color.WHITE);
        cb.setBounds(350,470,300,30);
        add(cb);
        
        JLabel EA=new JLabel("Existing Accounts:");
        EA.setFont(new Font("Raleway",Font.BOLD,20));
        EA.setBounds(100,520,200,30);
        add(EA);
        
        yes1=new JRadioButton("Yes");
        yes1.setBounds(350,520,100,30);
        yes1.setBackground(Color.WHITE);
        add(yes1);
        
        no1=new JRadioButton("No");
        no1.setBounds(500,520,100,30);
        no1.setBackground(Color.WHITE);
        add(no1);
        
        ButtonGroup yesgrp=new ButtonGroup();
        yesgrp.add(yes1);
        yesgrp.add(no1);
        
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setBounds(570,570,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(700,700);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String Religion=reliTF.getText();
        String category=cateTF.getText();
        String occupation=occTF.getText();
        
      String seniorciti="";
      if(yes.isSelected()){
          seniorciti="Yes";
      }else if(no.isSelected()){
          seniorciti="No";
      }
        String income = inc.getSelectedItem().toString();
        String pan=panTF.getText();
        String aadhar=anoTF.getText();
        String quali = cb.getSelectedItem().toString(); 
      String existing="";
      if(yes1.isSelected()){
          existing="Yes";
      }else if(no1.isSelected()){
          existing="No";
      } 
  
    try { 
        Conn c = new Conn();
        String q = "insert into signuptwo values('" +formno+ "', '" +Religion+ "', '" +category+ "', '" +occupation+ "', '" +seniorciti+ "', '" +income+ "', '" +pan+ "', '" +aadhar+ "', '" +quali+ "', '" +existing+ "')";
        c.s.executeUpdate(q);
        setVisible(false);
        new SignUPThree(formno).setVisible(true);
    } 
    catch(Exception e) {
    System.out.println(e);
}

      
    }
    public static void main(String args[]){
        new SignUPTwo("");
    }
}

