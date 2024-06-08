package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener {
    JTextField oldpin, newpin, confpin;
    JButton back, submit;
    String pinnum, cardnum;

    PinChange(String pinnum, String cardnum) {
        this.pinnum = pinnum;
        this.cardnum = cardnum;
        
        // Setting up the frame layout and background image
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 790);
        add(image);

        // Old PIN text field
        oldpin = new JTextField("OLD PIN");
        oldpin.setBounds(170, 270, 100, 30);
        oldpin.setFont(new Font("Raleway", Font.BOLD, 12));
        addPlaceholder(oldpin, "OLD PIN");
        image.add(oldpin);

        // New PIN text field
        newpin = new JTextField("NEW PIN");
        newpin.setBounds(170, 320, 100, 30);
        newpin.setFont(new Font("Raleway", Font.BOLD, 12));
        addPlaceholder(newpin, "NEW PIN");
        image.add(newpin);

        // Confirm PIN text field
        confpin = new JTextField("CONFIRM PIN");
        confpin.setBounds(170, 370, 100, 30);
        confpin.setFont(new Font("Raleway", Font.BOLD, 12));
        addPlaceholder(confpin, "CONFIRM PIN");
        image.add(confpin);

        // Submit button
        submit = new JButton("Submit");
        submit.setBounds(300, 404, 130, 26);
        submit.setBackground(Color.white);
        submit.addActionListener(this);
        image.add(submit);

        // Back button
        back = new JButton("Back");
        back.setBounds(300, 431, 130, 26);
        back.setBackground(Color.white);
        back.addActionListener(this);
        image.add(back);

        // Frame settings
        setSize(750, 750);
        setLocation(300, 0);
        setVisible(true);
    }

    private void addPlaceholder(JTextField textField, String placeholder) {
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent event) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                }
            }

            public void focusLost(FocusEvent event) {
                if (textField.getText().equals("")) {
                    textField.setText(placeholder);
                }
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnum, cardnum).setVisible(true);
        } else if (ae.getSource() == submit) {
            String oldPinText = oldpin.getText();
            String newPinText = newpin.getText();
            String confPinText = confpin.getText();

            if (newPinText.equals("NEW PIN") || newPinText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NEW PIN can't be EMPTY");
            } else if (newPinText.equals(oldPinText)) {
                JOptionPane.showMessageDialog(null, "New PIN and old PIN can't be the same");
            } else if (confPinText.equals("CONFIRM PIN") || confPinText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ENTER NEW PIN AGAIN");
            } else if (!newPinText.equals(confPinText)) {
                JOptionPane.showMessageDialog(null, "New PIN and Confirm PIN don't match");
            } else if (newPinText.matches(".*[a-zA-Z].*")) {
                JOptionPane.showMessageDialog(null, "PIN number cannot contain alphabets");
            } else {
                try {
                    Conn c = new Conn();
                    // Validate old PIN
                    String query = "select pin from login where cardnumber = '" + cardnum + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        String storedPin = rs.getString("pin");
                        if (!storedPin.equals(oldPinText)) {
                            JOptionPane.showMessageDialog(null, "Old PIN is incorrect");
                            return;
                        }
                    }

                    // Update PIN in all relevant tables
                    String query1 = "update accounts set pin = '" + newPinText + "' where cardnumber = '" + cardnum + "'";
                    int count = c.s.executeUpdate(query1);

                    String query2 = "update login set pin = '" + newPinText + "' where cardnumber = '" + cardnum + "'";
                    count += c.s.executeUpdate(query2);

                    String query3 = "update signupthree set pinno = '" + newPinText + "' where cardnumber = '" + cardnum + "'";
                    count += c.s.executeUpdate(query3);

                    if (count == 3) {
                        JOptionPane.showMessageDialog(null, "PIN NUMBER has been updated");
                        setVisible(false);
                        new Transactions(newPinText, cardnum).setVisible(true);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new PinChange("", "");
    }
}
