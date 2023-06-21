package travel.management.system;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JFrame;
public class passengertable extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public passengertable() {
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("id");
        model.addColumn("name");
        model.addColumn("address");
        model.addColumn("phone_no");
        model.addColumn("email");
        model.addColumn("gender");
        model.addColumn("DOB");
        try {
           Conn c=new Conn();
            PreparedStatement pstm = c.c.prepareStatement("SELECT * FROM Passenger");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
        
    }
    public static void main(String[] args) {
       
        JFrame frame = new passengertable();
        frame.setTitle("Passengers");
        frame.setBounds(200,100,500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
