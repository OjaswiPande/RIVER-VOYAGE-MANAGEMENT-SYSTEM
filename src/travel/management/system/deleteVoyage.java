package travel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class deleteVoyage extends JFrame implements ActionListener {
	
	JComboBox comboid;
    JTextField tfid,tfvid;
    JButton delete,back;
    
    deleteVoyage(){
        
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
     
        
        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(70,430,100,25);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);
        

        
        try{
                    Conn c = new Conn();
//                    ResultSet rs = c.s.executeQuery("select * from Voyage where name = '"+username+"'");
//                    while(rs.next()){
//                        labelusername.setText(rs.getString("name"));  
//                                }
                }catch(Exception e){ }
        setVisible(true);
    }
    
	public void actionPerformed(ActionEvent arg0){
        if(arg0.getSource() == delete){
            
            String cruise_id_s= tfid.getText(); // Get the phone number as a string
            int cruise_id = Integer.parseInt(cruise_id_s); // Convert the phone number string into an integer
            String Voyage_id_s = tfvid.getText(); // Get the phone number as a string
            int Voyage_id = Integer.parseInt(Voyage_id_s);
            
           
            
            
            try{
                Conn c=new Conn();
                String query = "delete from Voyage where cruise_id = ? AND Voyage_id =?";
                try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
                    pstmt.setInt(1, cruise_id);
                    pstmt.setInt(2, Voyage_id);
                   
                    
                    int i = pstmt.executeUpdate();
                if (i > 0){
                   JOptionPane.showMessageDialog(null,"Voyage Details deleted Successfully");
                }
                } catch (SQLException e) {
                    // Handle exception
                	JOptionPane.showMessageDialog(null,"Enter valid Voyage details");
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
		new deleteVoyage();
	}

}
