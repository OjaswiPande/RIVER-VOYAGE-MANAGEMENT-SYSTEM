
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class CheckCruises extends JFrame implements ActionListener{
    JButton viewPackage,back;
    CheckCruises(){
        setBounds(0,0,1750,1000);
        getContentPane().setBackground(Color.WHITE);
        
        String[] cruise1 = new String[]{"c1.png","","The colonial heritage of Bengal has inspired many a traveller to embark on a journey that","depicts the region’s history through the river Ganges. On the banks of the Lower Ganges,","the French, Dutch, Danish, Portuguese and English made settlements to trade, preach and ","farm while local rulers, saints, agriculturalists, musicians and writers created new ways of","living as they encountered European commerce, tastes and power. Experience true luxury ","and relax while witnessing this culture with the care and hospitality of the Ganges VoyagerⅡ ","and its crew.","1.png"};
        String[] cruise2 = new String[]{"c2.png","", "The land of many cultures and rich traditions, India is a visual delight for the visitors. Each ","of its diverse regions is the product of its deep-rooted past. Our luxurious abode will add ","more stars to your experience, leaving you with fond memories.","The epitome of elegance and luxury, Ganges Voyager offers travel experiences beyond a ","regular journey. This meticulously carved 8 day itinerary will take you through some of the ","most beautiful destinations from Do Banki. Offering more than a mere journey, we take you","on an experiential voyage into luxury, art, culture and numerous stories.","2.png"};
        String[] cruise3 = new String[]{"c3.png","", "The largest mangrove eco-system in the world, Sunderbans, a UNESCO World Heritage ","Site, is the hub of ‘Royal Bengal Tigers’. Embark on a 3 Night’s luxury cruise in the largest ","estuarine national park in the world.","The epitome of elegance and luxury, Ganges Voyager offers travel experiences beyond a ","regular journey. This meticulously carved 5 day itinerary will take you through some of the","most beautiful destinations from Namkhana. Offering more than a mere journey, we take ","you on an experiential voyage into luxury, art, culture and numerous stories.","3.png"};
        
        JTabbedPane tab=new JTabbedPane();
        
        JPanel p1=createPackage(cruise1);
         tab.addTab("Cruise 1",null,p1);
          JPanel p2=createPackage(cruise2);
         tab.addTab("Cruise 2",null,p2);
         JPanel p3=createPackage(cruise3);
         tab.addTab("Cruise 3 ",null,p3);
         add(tab);
        
        setVisible(true);
    }
    public JPanel createPackage(String[] pack){
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[0]));
        Image i3 = i1.getImage().getScaledInstance(650, 390,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(800,00,700,420);
        p1.add(l1);
        
         JLabel lblName = new JLabel(pack[1]);
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblName.setBounds(50, 5, 500, 53);
        p1.add(lblName);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[9]));
        Image i5 = i4.getImage().getScaledInstance(650, 700,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(20,-10,700,900);
        p1.add(image);
        
        JLabel l3 = new JLabel(pack[3]);
        l3.setForeground(Color.RED);
        l3.setFont(new Font("Yu Mincho", Font.BOLD, 14));
        l3.setBounds(820, 477, 700, 25);
        p1.add(l3);
        
         JLabel l4 = new JLabel(pack[2]);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Yu Mincho", Font.BOLD, 14));
        l4.setBounds(820, 450, 700, 25);
        p1.add(l4);
        
         JLabel l5 = new JLabel(pack[4]);
        l5.setForeground(Color.RED);
        l5.setFont(new Font("Yu Mincho", Font.BOLD, 14));
        l5.setBounds(820, 504, 700, 25);
        p1.add(l5);
        
         JLabel l6 = new JLabel(pack[5]);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Yu Mincho", Font.BOLD, 14));
        l6.setBounds(820, 531, 700, 25);
        p1.add(l6);
        
         JLabel l7 = new JLabel(pack[6]);
        l7.setForeground(Color.RED);
        l7.setFont(new Font("Yu Mincho", Font.BOLD, 14));
        l7.setBounds(820, 558, 700, 25);
        p1.add(l7);
        
         JLabel l8 = new JLabel(pack[7]);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("Yu Mincho", Font.BOLD, 14));
        l8.setBounds(820, 585, 700, 25);
        p1.add(l8);
        
         JLabel l9 = new JLabel(pack[8]);
        l9.setForeground(Color.RED);
        l9.setFont(new Font("Yu Mincho", Font.BOLD, 14));
        l9.setBounds(820, 612, 700, 25);
        p1.add(l9);
        
        
        return p1;
    }
    public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == back){
                this.setVisible(false);
            }
    }
    public static void main(String[] args){
        new CheckCruises();
    }
}
