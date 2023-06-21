package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminDashboard extends JFrame implements ActionListener{
	
    JButton Cruises, Voyage,voyaged,Passenger,ports;
    AdminDashboard( ){
       
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
        
        
        
        Voyage =new JButton("Voyage");
        Voyage.setBounds(450,20,150,50);
        Voyage.setBackground(new Color(0,128,128));
        Voyage.setForeground(Color.WHITE);
        Voyage.addActionListener(this);
        p1.add(Voyage);
        
        
        
        Passenger=new JButton("Passenger");
        Passenger.setBounds(610,20,150,50);
        Passenger.setBackground(new Color(0,128,128));
        Passenger.setForeground(Color.WHITE);
        Passenger.addActionListener(this);
        p1.add(Passenger);
        
        ports=new JButton("ports");
        ports.setBounds(770,20,150,50);
        ports.setBackground(new Color(0,128,128));
        ports.setForeground(Color.WHITE);
        ports.addActionListener(this);
        p1.add(ports);
        
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
            JFrame frame = new table();
        frame.setTitle("Cruises");
        frame.setBounds(200,100,500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
            
        }
         else if(ae.getSource()==Passenger){
               JFrame frame = new passengertable();
        frame.setTitle("Passengers");
        frame.setBounds(200,100,500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
             
         }
         else if(ae.getSource()==Voyage){
            new Voyage();
        }
        else if(ae.getSource()==ports){
             new ports();
         }
       
     }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AdminDashboard();
	}

}
