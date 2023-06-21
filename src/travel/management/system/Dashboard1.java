
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard1 extends JFrame implements ActionListener{
    String name;
    JButton Cruises,Packages,PersonalDetails,bookpackage,Destination;
    Dashboard1(String name ){
        this.name=name;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,128,128));
        p1.setBounds(0,0,1600,100);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(5,0,70,70);
        p1.add(image);
        
        JLabel heading=new JLabel("Ganga Vilas");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        
        Cruises=new JButton("Cruises");
        Cruises.setBounds(290,20,150,50);
        Cruises.setBackground(new Color(0,128,128));
        Cruises.setForeground(Color.WHITE);
        Cruises.addActionListener(this);
        p1.add(Cruises);
        
         Packages=new JButton("Packages");
        Packages.setBounds(450,20,150,50);
        Packages.setBackground(new Color(0,128,128));
        Packages.setForeground(Color.WHITE);
        Packages.addActionListener(this);
        p1.add(Packages);
        
        Destination=new JButton("Destination");
        Destination.setBounds(610,20,150,50);
        Destination.setBackground(new Color(0,128,128));
        Destination.setForeground(Color.WHITE);
        Destination.addActionListener(this);
        p1.add(Destination);
        
        bookpackage = new JButton("Book Now");
        bookpackage.setBackground(Color.RED);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(1430,5,100,50);
        bookpackage.addActionListener(this);
        p1.add(bookpackage);
        
        PersonalDetails=new JButton("Personal Details");
        PersonalDetails.setBounds(1260,20,150,50);
        PersonalDetails.setBackground(new Color(0,128,128));
        PersonalDetails.setForeground(Color.WHITE);
        PersonalDetails.addActionListener(this);
        p1.add(PersonalDetails);
       
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/d1.png"));
        Image i5=i4.getImage().getScaledInstance(1600,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image1=new JLabel(i6);
        image1.setBounds(0,100,1600,1000);
        add(image1);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==Cruises){
            new CheckCruises().setVisible(true);
        }else if(ae.getSource()==bookpackage){
            new AddCustomer(name); 
        }else if(ae.getSource()==Destination){
            new Destination().setVisible(true);
        }else if(ae.getSource()==PersonalDetails){
            new Customer(name).setVisible(true);
        }else if(ae.getSource()==Packages){
            new CheckPackage().setVisible(true);
        }
        
    }
     public static void main(String[] args){
        new Dashboard1("");
    }
}
