
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class ForgetPassword extends JFrame implements ActionListener{
    JButton search,retrieve,back;
    JTextField tfname,tfusername,tfanswer,tfquestion,tfpassword;
    
    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(40,20,100,25);
        p1.add(lblusername);
        
        tfusername=new JTextField();
        tfusername.setBounds(220,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search=new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Tahoma",Font.BOLD,14));
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        
        JLabel lblquestion=new JLabel("Security Question");
        lblquestion.setFont(new Font("Tahoma",Font.BOLD,14));
        lblquestion.setBounds(40,100,150,25);
        p1.add(lblquestion);
        
        tfquestion=new JTextField();
        tfquestion.setBounds(220,100,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel lblanswer=new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lblanswer.setBounds(40,140,150,25);
        p1.add(lblanswer);
        
        tfanswer=new JTextField();
        tfanswer.setBounds(220,140,150,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrieve=new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setFont(new Font("Tahoma",Font.BOLD,14));
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpassword.setBounds(50,180,125,25);
        p1.add(lblpassword);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(220,180,150,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back=new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            if(ae.getSource() == search){
                String sql = "select * from account where name=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, tfusername.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    tfquestion.setText(rs.getString("security"));
                }

            }
           else if(ae.getSource() == retrieve){
                String sql = "select * from account where answer=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, tfanswer.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    tfpassword.setText(rs.getString("password"));
                }

            }
            else{
                this.setVisible(false);
                new Login().setVisible(true);

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new ForgetPassword();
    }
}

