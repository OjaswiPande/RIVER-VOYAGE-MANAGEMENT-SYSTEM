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

public class deletePorts extends JFrame implements ActionListener {
	
	JComboBox comboid;
    JTextField tfid,tfpid;
    JButton delete,back;
    
    deletePorts(){
        
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
        
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("stock-vector-happy-family-vacation-cartoon-characters-vacation-together-family-fun-travel-joy-outdoors-430287304.jpg"));
//        Image i2=i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(400,40,400,500);
//        add(image);
        
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
            String port_id_s = tfpid.getText(); // Get the phone number as a string
            int port_id = Integer.parseInt(port_id_s);
            
           
            
            
            try{
                Conn c=new Conn();
                String query = "delete from ports where cruise_id = ? AND port_id =?";
                try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
                    pstmt.setInt(1, cruise_id);
                    pstmt.setInt(2, port_id);
                   
                    
                    int i = pstmt.executeUpdate();
                if (i > 0){
                   JOptionPane.showMessageDialog(null,"Port Details deleted Successfully");
                }
                } catch (SQLException e) {
                    // Handle exception
                	JOptionPane.showMessageDialog(null,"Enter valid port details");
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
		new deletePorts();
	}

}
