package travel.management.system;

import java.awt.*;

import java.awt.event.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Admin_login extends JFrame implements ActionListener{
	
	String username;
	JButton password,signup,login;
    JTextField tfname,tfquestion,tfpassword;
    Admin_login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
      JPanel p1=new JPanel();
      p1.setBackground(new Color(131,193,233));
     p1.setBounds(0,0,400,400);
     p1.setLayout(null);
      add(p1);
      
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
      Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(100,120,200,200);
      p1.add(image);
      
      JPanel p2=new JPanel();
      p2.setLayout(null);
      p2.setBounds(400,30,450,300);
      add(p2);
      
      JLabel lblname=new JLabel("Name");
      lblname.setBounds(60,20,100,25);
      lblname.setFont(new Font("SAN SERIF",Font.PLAIN,20));
      p2.add(lblname);
      
       tfname=new JTextField();
      tfname.setBounds(60,60,300,30);
      tfname.setBorder(BorderFactory.createEmptyBorder());
      p2.add(tfname);
      
      JLabel lblpassword=new JLabel("Password");
      lblpassword.setBounds(60,110,100,25);
      lblpassword.setFont(new Font("SAN SERIF",Font.PLAIN,20));
      p2.add(lblpassword);
      
      tfpassword=new JTextField();
      tfpassword.setBounds(60,150,300,30);
      tfpassword.setBorder(BorderFactory.createEmptyBorder());
      p2.add(tfpassword);
      
      login=new JButton("Login");
      login.setBounds(100,200,130,30);
      login.setBackground(new Color(133,193,233));
      login.setForeground(Color.WHITE);
      login.setBorder(new LineBorder(new Color(133,193,233)));
      login.addActionListener(this);
      
      p2.add(login);
      setVisible(true);
      
      
      JLabel text=  new JLabel("Trouble in login...");
      text.setBounds(300,250,150,20);
      text.setForeground(Color.RED); 
      p2.add(text);
      setVisible(true);
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Admin_login();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == login){tfname.getText();
            try {
                Conn con = new Conn();
                String sql = "select * from admin where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, tfname.getText());
                st.setString(2, tfpassword.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new AdminDashboard().setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid Login or Password!");

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
       
        else{
            setVisible(false);
        }
	}

}
