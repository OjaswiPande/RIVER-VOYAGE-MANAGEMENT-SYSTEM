
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    Choice c1,c2;
     JTextField t1;
     String username;
    JLabel labelusername,labelname,labelprice;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail;
    JRadioButton rmale,rfemale;
    JButton checkprice,bookpackage,back;
    
    AddCustomer(String username){
        this.username=username;
        
        setBounds(450,00,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid=new JLabel("Address");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(220,90,150,25);
        add(tfaddress);
    
        JLabel lblnumber=new JLabel("Phone");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);

        tfphone=new JTextField();
        tfphone.setBounds(220,130,150,25);
        add(tfphone);
        
        JLabel lblname=new JLabel("Email");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        tfemail=new JTextField();
        tfemail.setBounds(220,170,150,25);
        add(tfemail);
        
         JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        
        rmale = new JRadioButton("Male");
        rmale.setFont(new Font("Raleway", Font.BOLD, 14));
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(220, 210, 70, 25);
        add(rmale);
                
        rfemale = new JRadioButton("Female");
        rfemale.setFont(new Font("Raleway", Font.BOLD, 14));
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(300, 210, 100, 25);
        add(rfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel lblcountry=new JLabel("DOB");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        
        JLabel lblCruise = new JLabel("Select Cruise :");
	lblCruise.setBounds(30, 290, 200, 14);
	add(lblCruise);
                
        c2 = new Choice();
        c2.add("EUROPE OF THE GANGS");
        c2.add("TEMPLES, TIGERS & TREASURES OF EASTERN INDIA");
        c2.add("Secret of Sunderbans Jungle cruise");
        c2.setBounds(220, 290, 150, 30);
        add(c2);
        
        JLabel lblId = new JLabel("Select Package :");
	lblId.setBounds(30, 320, 200, 25);
	add(lblId);
                
        c1 = new Choice();
        c1.add("Basic Package");
        c1.add("Deluxe Package");
        c1.setBounds(220, 320, 150, 30);
        add(c1);
                
        
        JLabel lblpeople = new JLabel("Total person :");
	lblpeople.setBounds(30, 350, 200, 25);
	add(lblpeople);
        
         t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(220, 350, 150, 25);
        add(t1);
        t1.setColumns(10);
        
         JLabel lbltotal = new JLabel("Total price :");
	lbltotal.setBounds(30, 380, 150, 25);
	add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setBounds(250,380,150,25);
        add(labelprice);
     
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,420,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Pay");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,420,100,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(120,460,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,40,400,500);
        add(image);
        
        try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from account where name = '"+username+"'");
                    while(rs.next()){
                        labelusername.setText(rs.getString("name"));  
                    }
                }catch(Exception e){ }
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
            
            String phoneString = tfphone.getText(); // Get the phone number as a string
             String gender=null;
            if(rmale.isSelected()){
                gender="Male";
            }else{
                gender="Female";
            }
            
            try{
                Conn c=new Conn();
               String query = "INSERT INTO Passenger(Name, address, phone_no, email, Gender,DOB,Cruise_Name,Package_Name,Total_Person,Total_Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, tfaddress.getText());
                    pstmt.setString(3, phoneString);
                    pstmt.setString(4, tfemail.getText());
                    pstmt.setString(5, gender);
                    pstmt.setString(6, tfcountry.getText());
                    pstmt.setString(7,c2.getSelectedItem());
                    pstmt.setString(8,c1.getSelectedItem());
                    pstmt.setString(9,t1.getText());
                     pstmt.setString(10,labelprice.getText());
                    
                     new Payment();
                    int i = pstmt.executeUpdate();
                if (i > 0){
                   JOptionPane.showMessageDialog(null,"Booked Successfully");
                   
                }
                }
                catch (SQLException e) {
                    // Handle exception
                    System.out.print(e);
                }
                 this.setVisible(false);
                new Payment().setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
        }
          
    }
    public static void main(String[] args){
        new AddCustomer("");
    }

   
}
