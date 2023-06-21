package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class addVoyage extends JFrame implements ActionListener{

	    JComboBox comboid;
	    JTextField tfid,tfvid,tfsdate,tfedate,tfstatus;
	    JButton add,back;
	    
	    addVoyage(){
	        
	        setBounds(450,100,850,550);
	        setLayout(null);
	        getContentPane().setBackground(Color.WHITE);
	        
	        JLabel lblid=new JLabel("cruise_id");
	        lblid.setBounds(30,50,150,25);
	        add(lblid);

	        tfid=new JTextField();
	        tfid.setBounds(220,50,150,25);
	        add(tfid);
	        
	        JLabel lblvid=new JLabel("Voyage_id");
	        lblvid.setBounds(30,90,150,25);
	        add(lblvid);

	        tfvid=new JTextField();
	        tfvid.setBounds(220,90,150,25);
	        add(tfvid);
	        
	        JLabel sdate=new JLabel("start_date");
	        sdate.setBounds(30,130,150,25);
	        add(sdate);
	        
	        tfsdate=new JTextField();
	        tfsdate.setBounds(220,130,150,25);
	        add(tfsdate);
	        
	        JLabel edate=new JLabel("end_date");
	        edate.setBounds(30,170,150,25);
	        add(edate);
	        
	        tfedate=new JTextField();
	        tfedate.setBounds(220,170,150,25);
	        add(tfedate);
	        
	        JLabel status=new JLabel("status");
	        status.setBounds(30,210,150,25);
	        add(status);
	        
	        tfstatus=new JTextField();
	        tfstatus.setBounds(220,210,150,25);
	        add(tfstatus);
	        
	     
	        add = new JButton("Add");
	        add.setBackground(Color.BLACK);
	        add.setForeground(Color.WHITE);
	        add.setBounds(70,430,100,25);
	        add.addActionListener(this);
	        add(add);
	        
	        back = new JButton("Back");
	        back.setBackground(Color.BLACK);
	        back.setForeground(Color.WHITE);
	        back.setBounds(220,430,100,25);
	        back.addActionListener(this);
	        add(back);
	        
//	        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("stock-vector-happy-family-vacation-cartoon-characters-vacation-together-family-fun-travel-joy-outdoors-430287304.jpg"));
//	        Image i2=i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
//	        ImageIcon i3=new ImageIcon(i2);
//	        JLabel image=new JLabel(i3);
//	        image.setBounds(400,40,400,500);
//	        add(image);
	        
	        try{
	                    Conn c = new Conn();
//	                    ResultSet rs = c.s.executeQuery("select * from Voyage where name = '"+username+"'");
//	                    while(rs.next()){
//	                        labelusername.setText(rs.getString("name"));  
//	                                }
	                }catch(Exception e){ }
	        setVisible(true);
	    }
	    
		public void actionPerformed(ActionEvent arg0){
	        if(arg0.getSource() == add){
	            
	            String cruise_id_s= tfid.getText(); // Get the phone number as a string
	            int cruise_id = Integer.parseInt(cruise_id_s); // Convert the phone number string into an integer
	            String Voyage_id_s = tfvid.getText(); // Get the phone number as a string
	            int Voyage_id = Integer.parseInt(Voyage_id_s);
	            String start_date = tfsdate.getText();
	            String end_date = tfedate.getText();
	            String status = tfstatus.getText();
	           
	           
	            
	            
	            try{
	                Conn c=new Conn();
	                String query = "INSERT INTO Voyage (cruise_id, Voyage_id, start_date , end_date,status) VALUES (?, ?, ?, ?, ?)";

	                try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
	                    pstmt.setInt(1, cruise_id);
	                    pstmt.setInt(2, Voyage_id);
	                    pstmt.setString(3, start_date);
	                    pstmt.setString(4, end_date);
	                    pstmt.setString(5, status);
	                    
	                    int i = pstmt.executeUpdate();
	                if (i > 0){
	                   JOptionPane.showMessageDialog(null,"Voyage Details added Successfully");
	                }
	                } catch (SQLException e) {
	                    // Handle exception
	                }

	                
	                
	                setVisible(false);
	            }catch(Exception e){
	                System.out.println(e);
	            }
	        }else{
	            setVisible(false);
	        }
	    }
	    
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new addVoyage();
	}



}
