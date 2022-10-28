import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.*;
public class checkout extends JFrame implements ActionListener {
    JButton checkout,cancel;
    JLabel room1,ci1,co1;
    Choice customer1;
    checkout(){
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 400);
        setTitle("Check-in/Check-out");
        setLayout(null);
        setLocation(310, 150);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 230, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 80, 400, 230);
        add(image);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("tick.png"));
        Image i12 = i11.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel image1 = new JLabel(i13);
        image1.setBounds(350, 80, 30, 30);
        add(image1);

        JLabel heading = new JLabel("Checkout");
        heading.setFont(new Font("Railway", Font.BOLD, 24));
        heading.setBounds(170, 30, 600, 30);
        add(heading);

        JLabel heading1 = new JLabel("Customer Id       : ");
        heading1.setFont(new Font("Railway", Font.BOLD, 14));
        heading1.setBounds(40, 80, 140, 30);
        add(heading1);

        customer1 = new Choice();
        customer1.setBounds(180, 85, 150, 30);
        add(customer1);

      
        

        JLabel heading2 = new JLabel("Room Number    : ");
        heading2.setFont(new Font("Railway", Font.BOLD, 14));
        heading2.setBounds(40, 130, 150, 30);
        add(heading2);

        room1 = new JLabel();
        room1.setBounds(180, 130, 150, 30);
        add(room1);

       
        JLabel heading4 = new JLabel("Checkin Time     :");
        heading4.setFont(new Font("Railway", Font.BOLD, 14));
        heading4.setBounds(40, 180, 600, 30);
        add(heading4);

        ci1 = new JLabel();
        ci1.setBounds(180, 180, 180, 30);
        add(ci1);

        Date d1 = new Date();

        JLabel heading5 = new JLabel("Checkout Time   :");
        heading5.setFont(new Font("Railway", Font.BOLD, 14));
        heading5.setBounds(40, 230, 600, 30);
        add(heading5);

        co1 = new JLabel( "" + d1);
        co1.setBounds(180, 230, 190, 30);
        add(co1);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer1.add(rs.getString("number"));
               }
        } catch (Exception e) {
            e.printStackTrace();
        }


        // after changing dropdownlist
          customer1.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where number='"+customer1.getSelectedItem()+"' ");
                    while (rs.next()) {
                        
                        room1.setText(rs.getString("room"));
                        ci1.setText(rs.getString("checkintime"));
        
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
        
                
            }
            
        });


        // as soon as frame gets loaded
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where number='"+customer1.getSelectedItem()+"' ");
            while (rs.next()) {
                
                room1.setText(rs.getString("room"));
                ci1.setText(rs.getString("checkintime"));

            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }



        

       




       

        checkout = new JButton("Checkout");
        checkout.setBounds(70,300,100,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        cancel = new JButton("Back");
        cancel.setBounds(210,300,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new checkout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   if(e.getSource() == checkout){
        // delete info of customer from customer table
        // set room occupancy to available in checkout button click
        
        String query = "delete from customer where number ='"+customer1.getSelectedItem()+"' ";
        String query1 = "update room set availability='Available' where roomnumber='"+room1.getText()+"' ";
        try {
            conn c = new conn();
            c.s.executeUpdate(query);
            c.s.executeUpdate(query1);

            JOptionPane.showMessageDialog(null,"Checkout Done");
            setVisible(false);
            new reception();
        } catch (SQLException e1) {
            
            e1.printStackTrace();
        }
      
       
       }else if(e.getSource() == cancel){
        setVisible(false);
        new reception();
       }
        
    }
}
