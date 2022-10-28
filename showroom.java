import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class showroom extends JFrame implements ActionListener {
    JTable table;
    JButton cancel;
    showroom() {
        getContentPane().setBackground(Color.WHITE);
        setSize(1050, 600);
        setTitle("Check Rooms");
        setLayout(null);
        setLocation(250, 80);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(540, 10, 500, 500);
        add(image);

        // displaying table using JTable
        // JTable takes two argument first is data and second is header
        // table will be invisible as soon as we entered data it will displays the data
        table = new JTable();
        // table.setBounds(0,30 ,500 ,400 );
        // add(table);
        try {
            conn c = new conn();
            // String query = "select * from room";
            ResultSet rs1 = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs1));
            // now we have to insert data into table
            // we can add data manually into table or import rs2xml.jar

        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(10, 10, 530, 500);
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
        new showroom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancel){
            setVisible(false);
            new reception();
        }
    }
}
