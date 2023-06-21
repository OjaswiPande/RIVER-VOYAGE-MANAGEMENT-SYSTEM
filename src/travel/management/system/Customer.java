
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class Customer extends JFrame implements ActionListener{
    JButton view,update;
    String username;
    Customer(String username){
        this.username=username;
        setBounds(350,200,700,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel lblusername=new JLabel("Choose what you want.");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(220,20,225,25);
        add(lblusername);
        
        view = new JButton("View ");
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.setBounds(100,50,100,25);
        view.addActionListener(this);
        add(view);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(300,50,100,25);
        update.addActionListener(this);
        add(update);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==view){
            new ViewCustomer(username).setVisible(true);
        }
        if(ae.getSource()==update){
            
            new UpdateCustomer(username).setVisible(true);
        }
    }
     public static void main(String[] args){
        new Customer("");
}    
}
