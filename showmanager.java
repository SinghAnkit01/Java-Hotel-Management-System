import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class showmanager extends JFrame implements ActionListener {
    JTable table;
    JButton cancel;
    showmanager(){
        getContentPane().setBackground(Color.WHITE);
        setSize(1000, 780);
        setTitle("Check Manager");
        setLayout(null);
        setLocation(250, 50);

        table = new JTable();
        // table.setBounds(0,30 ,500 ,400 );
        // add(table);
        try {
            conn c = new conn();
            // String query = "select * from room";
            ResultSet rs1 = c.s.executeQuery("select * from employee where job ='Manager' ");
            table.setModel(DbUtils.resultSetToTableModel(rs1));
            // now we have to insert data into table
            // we can add data manually into table or import rs2xml.jar

        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(10, 10, 970, 580);
        add(js); 

        cancel = new JButton("Back");
        cancel.setBounds(400,615,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new showmanager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == cancel){
        setVisible(false);
            new reception();
      }
        
    }
}

