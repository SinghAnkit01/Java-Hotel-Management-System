import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class pickup extends JFrame implements ActionListener {
    JTable table;
    JButton submit, cancel,book,update;
    Choice cartype,driver;
    JCheckBox available;

    pickup() {
        getContentPane().setBackground(Color.WHITE);
        setSize(1000, 780);
        setTitle("Pickup Service");
        setLayout(null);
        setLocation(250, 0);

        JLabel heading = new JLabel("Pickup Service");
        heading.setFont(new Font("Railway", Font.BOLD, 24));
        heading.setBounds(370, 10, 600, 30);
        add(heading);

        JLabel heading1 = new JLabel("Location For Pickup :");
        heading1.setFont(new Font("Railway", Font.PLAIN, 16));
        heading1.setBounds(30, 60, 160, 30);
        add(heading1);

      
        // cartype = new JComboBox(str2);
        // cartype.setBounds(180, 30, 150, 30);
        // cartype.setBackground(Color.WHITE);
        // add(cartype);

        cartype = new Choice();
        cartype.setBounds(190, 65, 150, 30);
        add(cartype);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()) {
                // cartype.add("Select");
                cartype.add(rs.getString("location"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel heading2 = new JLabel("Check Driver :");
        heading2.setFont(new Font("Railway", Font.PLAIN, 16));
        heading2.setBounds(430, 60, 120, 30);
        add(heading2);

      
        // cartype = new JComboBox(str2);
        // cartype.setBounds(180, 30, 150, 30);
        // cartype.setBackground(Color.WHITE);
        // add(cartype);

        driver = new Choice();
        driver.setBounds(560, 65, 150, 30);
        // driver.add("Available");
        // // driver.add("Not-Available");
        add(driver);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()) {
                driver.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        update = new JButton("Update");
        update.setBounds(730, 60, 100, 30);
        // update.setBackground(Color.BLACK);
        // update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

       

        table = new JTable();
        // table.setBounds(0,30 ,500 ,400 );
        // add(table);
        try {
            conn c = new conn();
            // String query = "select * from room";
            ResultSet rs1 = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs1));
            // now we have to insert data into table
            // we can add data manually into table or import rs2xml.jar

        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(10, 110, 970, 540);
        add(js);

        cancel = new JButton("Back");
        cancel.setBounds(600, 670, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(450, 670, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        book = new JButton("Book");
        book.setBounds(300, 670, 100, 30);
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        book.addActionListener(this);
        add(book);

        setVisible(true);
    }

    public static void main(String[] args) {
        new pickup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String searchcar= (String) cartype.getSelectedItem();

        if (e.getSource() == cancel) {
            setVisible(false);
            new reception();
        } else if (e.getSource() == submit) {
            try {
                conn c = new conn();
                String query1 = "select * from driver where location='" + searchcar+ "'";
                ResultSet rs = c.s.executeQuery(query1);
                 // display data in the form of table uing dbUtils class
                table.setModel(DbUtils.resultSetToTableModel(rs));
                // if(table.contains(null)){
                //     JOptionPane.showMessageDialog(null, "empty");
                // }

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }else if(e.getSource() == book){
            String car = cartype.getSelectedItem();
            conn c = new conn();
            try {
                String query2 = "select * from driver where location ='"+car+"' ";
                ResultSet rs2=c.s.executeQuery(query2);
                if(rs2.next()) {
                   String location = rs2.getString("name");
                   String location1 = rs2.getString("available");
                   if(location1.equals("Not-Available")){
                    JOptionPane.showMessageDialog(null,"Driver is not-available" );
                   }else{
                    try {
                        String query1 = "update driver set available='Not-Available' where name='"+driver.getSelectedItem()+"'";
                        c.s.executeUpdate(query1);
                        JOptionPane.showMessageDialog(null,"Driver Booked Successfully");
                        setVisible(false);
                        new reception();
                    } catch (Exception e3) {
                       e3.printStackTrace();
                    }
                  
                   }
                    }
               
            } catch (Exception e1) {
               e1.printStackTrace();
            }
        }else if(e.getSource() == update){
            String up = driver.getSelectedItem();
            String ct = cartype.getSelectedItem();
            try {
                conn c = new conn();
                String query1 = "update driver set available='Available' where name='"+up+"' ";
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"Now Driver is available for location " + ct);
                setVisible(false);
                new reception();
            } catch (Exception e2) {
              e2.printStackTrace();
            }
        }

    }
}
