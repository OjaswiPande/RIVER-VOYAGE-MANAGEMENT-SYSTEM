
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{

    JButton FI1,FI2,PS1,PS2,PS3,EI,MP,FE,RE,viewbookedHotels,Destinations,payments,Calculators,notepad,about;
    Dashboard( ){
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        JFrame frame=new JFrame();
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(5,0,70,70);
        p1.add(image);
        
        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,280,900);
        add(p2);
        
        FI1=new JButton("Financial Institution");
        FI1.setBounds(0,0,300,50);
        FI1.setBackground(new Color(0,0,102));
        FI1.setForeground(Color.WHITE);
        FI1.setFont(new Font("Tahoma",Font.PLAIN,20));
        FI1.setMargin(new Insets(0,0,0,60));
        FI1.addActionListener(this);
        p2.add(FI1);
        
         FI2=new JButton("");
        FI2.setBounds(0,50,300,50);
        FI2.setBackground(new Color(0,0,102));
        FI2.setForeground(Color.WHITE);
        FI2.setFont(new Font("Tahoma",Font.PLAIN,20));
        FI2.setMargin(new Insets(0,0,0,30));
        FI2.addActionListener(this);
        p2.add(FI2);
        
        PS1=new JButton("Payment system");
        PS1.setBounds(0,100,300,50);
        PS1.setBackground(new Color(0,0,102));
        PS1.setForeground(Color.WHITE);
        PS1.setFont(new Font("Tahoma",Font.PLAIN,20));
        PS1.setMargin(new Insets(0,0,0,130));
        PS1.addActionListener(this);
        p2.add(PS1);
        
         PS2=new JButton("");
        PS2.setBounds(0,150,300,50);
        PS2.setBackground(new Color(0,0,102));
        PS2.setForeground(Color.WHITE);
        PS2.setFont(new Font("Tahoma",Font.PLAIN,20));
        PS2.setMargin(new Insets(0,0,0,40));
        p2.add(PS2);
        
         PS3=new JButton("");
        PS3.setBounds(0,200,300,50);
        PS3.setBackground(new Color(0,0,102));
        PS3.setForeground(Color.WHITE);
        PS3.setFont(new Font("Tahoma",Font.PLAIN,20));
        PS3.setMargin(new Insets(0,0,0,110));
        PS3.addActionListener(this);
        p2.add(PS3);
        
         EI=new JButton("Economic Indicators");
        EI.setBounds(0,250,300,50);
        EI.setBackground(new Color(0,0,102));
        EI.setForeground(Color.WHITE);
        EI.setFont(new Font("Tahoma",Font.PLAIN,20));
        EI.setMargin(new Insets(0,0,0,120));
        p2.add(EI);
        
         MP=new JButton("Montary Policy");
        MP.setBounds(0,300,300,50);
        MP.setBackground(new Color(0,0,102));
        MP.setForeground(Color.WHITE);
        MP.setFont(new Font("Tahoma",Font.PLAIN,20));
        MP.setMargin(new Insets(0,0,0,120));
        p2.add(MP);
        
         FE=new JButton("Foreign Exchange");
        FE.setBounds(0,350,300,50);
        FE.setBackground(new Color(0,0,102));
        FE.setForeground(Color.WHITE);
        FE.setFont(new Font("Tahoma",Font.PLAIN,20));
        FE.setMargin(new Insets(0,0,0,130));
        p2.add(FE);
        
         RE=new JButton("Regulatory Framework");
        RE.setBounds(0,400,300,50);
        RE.setBackground(new Color(0,0,102));
        RE.setForeground(Color.WHITE);
        RE.setFont(new Font("Tahoma",Font.PLAIN,20));
        RE.setMargin(new Insets(0,0,0,140));
        p2.add(RE);
        
         viewbookedHotels=new JButton("View Booked Hotels");
        viewbookedHotels.setBounds(0,450,300,50);
        viewbookedHotels.setBackground(new Color(0,0,102));
        viewbookedHotels.setForeground(Color.WHITE);
        viewbookedHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookedHotels.setMargin(new Insets(0,0,0,70));
        p2.add(viewbookedHotels);
        
         Destinations=new JButton("Destinations");
        Destinations.setBounds(0,500,300,50);
        Destinations.setBackground(new Color(0,0,102));
        Destinations.setForeground(Color.WHITE);
        Destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        Destinations.setMargin(new Insets(0,0,0,125));
        p2.add(Destinations);
        
         payments=new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,155));
        p2.add(payments);
        
         Calculators=new JButton("Calculators");
        Calculators.setBounds(0,600,300,50);
        Calculators.setBackground(new Color(0,0,102));
        Calculators.setForeground(Color.WHITE);
        Calculators.setFont(new Font("Tahoma",Font.PLAIN,20));
        Calculators.setMargin(new Insets(0,0,0,145));
        p2.add(Calculators);
        
         notepad=new JButton("notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,155));
        p2.add(notepad);
        
         about=new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,175));
        p2.add(about);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/d1.png"));
        Image i5=i4.getImage().getScaledInstance(11100,100,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel i7=new JLabel(i4);
        i7.setBounds(0,0,2000,900);
        add(i7);
        
      
        // Create a JPanel object
        
        JLabel text=new JLabel("Travel and Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.RED);
        text.setFont(new Font("Raleway",Font.PLAIN,40));
        i7.add(text);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==FI1){
            new RBI_FI1();
        }
        
    }
     public static void main(String[] args){
        new Dashboard();
    }
}
