import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class searchroom extends JFrame implements ActionListener {
    JTable table;
    JButton submit, cancel;
    JComboBox bedtype;
    JCheckBox available;

    searchroom() {
        getContentPane().setBackground(Color.WHITE);
        setSize(1000, 780);
        setTitle("Search Rooms");
        setLayout(null);
        setLocation(250, 0);

        JLabel heading = new JLabel("Search For Room");
        heading.setFont(new Font("Railway", Font.BOLD, 24));
        heading.setBounds(370, 10, 600, 30);
        add(heading);

        JLabel heading1 = new JLabel("Search For Room :");
        heading1.setFont(new Font("Railway", Font.PLAIN, 16));
        heading1.setBounds(30, 30, 150, 30);
        add(heading1);

        String str2[] = { "Single-Bed", "Double-Bed", "Single-Bed + Deluxe", "Sweet Room + Single-Bed",
                "Sweet Room + Double-Bed" };
        bedtype = new JComboBox(str2);
        bedtype.setBounds(180, 30, 150, 30);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);

        available = new JCheckBox("only display Available");
        available.setBounds(650, 30, 250, 30);
        available.setFont(new Font("Railway", Font.PLAIN, 16));
        available.setBackground(Color.WHITE);
        add(available);

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
        js.setBounds(10, 80, 970, 580);
        add(js);

        cancel = new JButton("Back");
        cancel.setBounds(500, 670, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(350, 670, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }

    public static void main(String[] args) {
        new searchroom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String searchroom = (String) bedtype.getSelectedItem();

        if (e.getSource() == cancel) {
            setVisible(false);
            new reception();
        } else if (e.getSource() == submit) {
            try {

                String query1 = "select * from room where availability='Available' and bed_type='" + searchroom + "'";
                String query2 = "select * from room where bed_type='" + searchroom + "'";

                conn c = new conn();
                ResultSet rs;
                if (available.isSelected()) {
                    // if available checkbox is selected run rs2
                    rs = c.s.executeQuery(query1);

                } else {
                    // run rs1
                    rs = c.s.executeQuery(query2);

                }
                // display data in the form of table uing dbUtils class
                table.setModel(DbUtils.resultSetToTableModel(rs));
                // if(table.contains(null)){
                //     JOptionPane.showMessageDialog(null, "empty");
                // }

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }
}
