
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class CheckPackage extends JFrame{
    CheckPackage(){
        setBounds(450,200,900,600);
       
      String[] package1 = new String[]{"package1.jpg","Basic PACKAGE", "Basic Rooms", "Entry to Dance and Music Sections only","Entry to Lower Deck (Upper deck excluded)", "Maximum occupancy: 2 per room ", "Welcome drinks on Arrival", "Entry to pool party not included", "Rs 5000 only"};
      String[] package2 = new String[]{"package2.jpg","Delux PACKAGE", "Deluxe Rooms", "Entry to Dance and Music Sections + Casino","Entry to lower and upper deck", "Maximum occupancy: 3 per room","Welcome drinks on Arrival+free drinks with dinner", "Entry to pool party included", "Rs 15000 only"};
        JTabbedPane tab=new JTabbedPane(); 
        JPanel p1=createPackage(package1);
       
         tab.addTab("Package 1",null,p1);
          JPanel p2=createPackage(package2);
         tab.addTab("Package 2",null,p2);
    
        add(tab);
        
        setVisible(true);
    }
    public JPanel createPackage(String[] pack){
         JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
           ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[0]));
        Image i3 = i1.getImage().getScaledInstance(550, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400,0,450,420);
        p1.add(l1);

        JLabel lblName = new JLabel(pack[1]);
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblName.setBounds(50, 5, 350, 53);
        p1.add(lblName);

        JLabel l3 = new JLabel(pack[2]);
        l3.setForeground(Color.RED);
        l3.setFont(new Font("Raleway", Font.BOLD, 14));
        l3.setBounds(35, 70, 200, 20);
        p1.add(l3);

        JLabel lblId = new JLabel(pack[3]);
        lblId.setForeground(Color.BLUE);
        lblId.setFont(new Font("Raleway", Font.BOLD, 14));
        lblId.setBounds(35, 110, 350, 20);
        p1.add(lblId);

        JLabel l2 = new JLabel(pack[4]);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Raleway", Font.BOLD, 14));
        l2.setBounds(35, 150, 350, 25);
        p1.add(l2);

        JLabel lblName_1 = new JLabel(pack[5]);
        lblName_1.setForeground(Color.BLUE);
        lblName_1.setFont(new Font("Raleway", Font.BOLD, 14));
        lblName_1.setBounds(35, 190, 300, 25);
        p1.add(lblName_1);

        JLabel lblGender = new JLabel(pack[6]);
        lblGender.setForeground(Color.RED);
        lblGender.setFont(new Font("Raleway", Font.BOLD, 14));
        lblGender.setBounds(35, 230, 390, 25);
        p1.add(lblGender);

        JLabel lblCountry = new JLabel(pack[7]);
        lblCountry.setForeground(Color.BLUE);
        lblCountry.setFont(new Font("Raleway", Font.BOLD, 14));
        lblCountry.setBounds(35, 270, 300, 25);
        p1.add(lblCountry);

        JLabel lblReserveRoomNumber = new JLabel(pack[8]);
        lblReserveRoomNumber.setForeground(Color.RED);
        lblReserveRoomNumber.setFont(new Font("Raleway", Font.BOLD, 14));
        lblReserveRoomNumber.setBounds(35, 310, 260, 25);
        p1.add(lblReserveRoomNumber);

        

        return p1;
    }
    public static void main(String[] args){
        new CheckPackage();
    }
}
