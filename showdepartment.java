import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class showdepartment extends JFrame implements ActionListener {
    JTable table;
    JButton cancel;
    showdepartment(){
        getContentPane().setBackground(Color.WHITE);
        setSize(500, 600);
        setTitle("Check Department");
        setLayout(null);
        setLocation(500, 80);

        table = new JTable();
        // table.setBounds(0,30 ,500 ,400 );
        // add(table);
        try {
            conn c = new conn();
            // String query = "select * from room";
            ResultSet rs1 = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs1));
            // now we have to insert data into table
            // we can add data manually into table or import rs2xml.jar

        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(10, 10, 450, 500);
        add(js); 

        cancel = new JButton("Back");
        cancel.setBounds(170,525,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new showdepartment();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == cancel){
        setVisible(false);
            new reception();
      }
        
    }
}
