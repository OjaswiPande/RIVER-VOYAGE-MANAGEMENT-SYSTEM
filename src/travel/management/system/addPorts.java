package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class addPorts extends JFrame implements ActionListener{

	    JComboBox comboid;
	    JTextField tfid,tfpid, tfname,tfnum,tftype;
	    JButton add,back;
	    
	    addPorts(){
	        
	        setBounds(450,100,850,550);
	        setLayout(null);
	        getContentPane().setBackground(Color.WHITE);
	        
	        JLabel lblid=new JLabel("cruise_id");
	        lblid.setBounds(30,50,150,25);
	        add(lblid);

	        tfid=new JTextField();
	        tfid.setBounds(220,50,150,25);
	        add(tfid);
	        
	        JLabel lblpid=new JLabel("port_id");
	        lblpid.setBounds(30,90,150,25);
	        add(lblpid);

	        tfpid=new JTextField();
	        tfpid.setBounds(220,90,150,25);
	        add(tfpid);
	        
	        JLabel lblname=new JLabel("place name");
	        lblname.setBounds(30,130,150,25);
	        add(lblname);
	        
	        tfname=new JTextField();
	        tfname.setBounds(220,130,150,25);
	        add( tfname);
	        
	        JLabel lblnum=new JLabel("stop number");
	        lblnum.setBounds(30,170,150,25);
	        add(lblnum);
	        
	        tfnum=new JTextField();
	        tfnum.setBounds(220,170,150,25);
	        add(tfnum);
	        
	        JLabel lbltype=new JLabel("lable type");
	        lbltype.setBounds(30,210,150,25);
	        add(lbltype);
	        
	        tftype=new JTextField();
	        tftype.setBounds(220,210,150,25);
	        add(tftype);
	        
	     
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
	        setVisible(true);
	        
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
	            String port_id_s = tfpid.getText(); // Get the phone number as a string
	            int port_id = Integer.parseInt(port_id_s);
	            String place_name = tfname.getText();
	            String stop_number_s = tfpid.getText(); // Get the phone number as a string
	            int stop_number = Integer.parseInt(stop_number_s);
	            String stop_type = tftype.getText();
	           
	           
	            
	            
	            try{
	                Conn c=new Conn();
	                String query = "INSERT INTO ports (cruise_id, port_id, place_name , stop_number,stop_type) VALUES (?, ?, ?, ?, ?)";

	                try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
	                    pstmt.setInt(1, cruise_id);
	                    pstmt.setInt(2, port_id);
	                    pstmt.setString(3, place_name);
	                    pstmt.setInt(4, stop_number);
	                    pstmt.setString(5, stop_type);
	                    
	                    int i = pstmt.executeUpdate();
	                if (i > 0){
	                   JOptionPane.showMessageDialog(null,"Port Details added Successfully");
	                }
	                } catch (SQLException e) {
	                    // Handle exception
	                	System.out.println("Invalid");
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
		new addPorts();
	}



}
