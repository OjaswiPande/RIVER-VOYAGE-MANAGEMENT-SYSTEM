
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class BookPackage extends JFrame implements ActionListener{
    Choice c1,c2;
     JTextField t1,t2;
     String username;
     JLabel labelname,labelid,labelphone,labelemail,labelgender,labelprice;
     JButton checkprice,bookpackage,back;
    BookPackage(String username){
        this.username=username;
         setBounds(350,200,1100,500);
         setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         
        JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(30,50,150,25);
        add(lblid);
        
         labelid=new JLabel();
        labelid.setBounds(220,50,150,25);
        add(labelid);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,110,150,25);
        add(lblname);
        
           labelname=new JLabel();
        labelname.setBounds(220,110,150,25);
        add(labelname);
        
         JLabel lblId = new JLabel("Select Package :");
	lblId.setBounds(35, 170, 200, 14);
	add(lblId);
                
        c1 = new Choice();
        c1.add("Basic Package");
        c1.add("Deluxe Package");
        c1.setBounds(271, 170, 150, 30);
        add(c1);
                
        
        JLabel lblpeople = new JLabel("Total person :");
	lblpeople.setBounds(35, 220, 200, 14);
	add(lblpeople);
        
         t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(271, 220, 150, 20);
        add(t1);
        t1.setColumns(10);
        
        JLabel lblphone=new JLabel("phone");
        lblphone.setBounds(30,260,150,25);
        add(lblphone);
        
         labelphone=new JLabel();
        labelphone.setBounds(220,260,150,25);
        add(labelphone);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,300,150,25);
        add(lblgender);
        
         labelgender=new JLabel();
        labelgender.setBounds(220,300,150,25);
        add(labelgender); 
        
         JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(30,350,150,25);
        add(lblemail);
        
         labelemail=new JLabel();
        labelemail.setBounds(220,350,150,25);
        add(labelemail); 
        
         JLabel lbltotal = new JLabel("Total price :");
	lbltotal.setBounds(35, 390, 200, 14);
	add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setBounds(250,390,150,25);
        add(labelprice);
       
         try{
            Conn conn=new Conn();
            String query="select * from Passenger where name= '"+username+"'";
             PreparedStatement st = conn.c.prepareStatement(query);
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                 labelname.setText(rs.getString("name"));
  
            }
            
            
        }catch(Exception e){
            System.out.println(e);
        }
         checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,440,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,440,100,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,350,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,40,400,500);
        add(image);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String p = c1.getSelectedItem();
            int w=Integer.parseInt(t1.getText());
             int cost = 0;
            if(p.equals("Basic Package") && (w==1 || w==2)) {
                cost += 5000;
            }
            if(p.equals("Deluxe Package")&& (w==1 || w==2 || w==3)){
                cost += 15000;
            }
            if(p.equals("Basic Package")&& w>=3) {
                 JOptionPane.showMessageDialog(null,"Check the packages and write a person carefully.");
            }
            if(p.equals("Deluxe Package") && w>=4){
                JOptionPane.showMessageDialog(null,"Check the packages and write a person carefully.");
            }
            cost *= Integer.parseInt(t1.getText());
             labelprice.setText("Rs "+cost);
             
        }else if(ae.getSource()==bookpackage){
            String phoneString = labelphone.getText(); // Get the phone number as a string
            int phone = Integer.parseInt(phoneString);
            try{
                Conn c=new Conn();
               String query = "INSERT INTO Passenger(Name, package, phone_no, email, Gender,price) VALUES (?, ?, ?, ?, ?,?)";

                try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, c1.getSelectedItem());
                    pstmt.setInt(3, phone);
                    pstmt.setString(4, labelemail.getText());
                    pstmt.setString(5, labelgender.getText());
                   pstmt.setString(6, labelprice.getText());
                    int i = pstmt.executeUpdate();
                if (i > 0){
                   JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                   new Payment();
                }
                } catch (SQLException e) {
                    // Handle exception
                    System.out.print(e);
                }
                 setVisible(false);
            }catch(Exception e){
                System.out.print(e);
            }
        }else{
            setVisible(false);
        }
    }
     public static void main(String[] args){
        new BookPackage("kalash");
    }
}
