import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
// import java.sql.*;
public class updatecheck extends JFrame implements ActionListener {
    JButton cancel,check,update;
    JTextField room1,name1,checkin1,amount1,pending1;
    Choice customer1;
    updatecheck(){
        getContentPane().setBackground(Color.WHITE);
        setSize(950, 500);
        setTitle("Check-in/Check-out");
        setLayout(null);
        setLocation(250, 120);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 280, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 80, 450, 280);
        add(image);

        JLabel heading = new JLabel("Update Status");
        heading.setFont(new Font("Railway", Font.BOLD, 24));
        heading.setBounds(150, 30, 600, 30);
        add(heading);

        JLabel heading1 = new JLabel("Customer Id       : ");
        heading1.setFont(new Font("Railway", Font.BOLD, 14));
        heading1.setBounds(40, 80, 140, 30);
        add(heading1);

        customer1 = new Choice();
        customer1.setBounds(180, 85, 150, 30);
        customer1.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                room1.setText("");
                name1.setText("");
                checkin1.setText("");
                amount1.setText("");
                pending1.setText("");
                
            }
            
        });
        add(customer1);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer1.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

        JLabel heading2 = new JLabel("Room Number    : ");
        heading2.setFont(new Font("Railway", Font.BOLD, 14));
        heading2.setBounds(40, 130, 150, 30);
        add(heading2);

        room1 = new JTextField();
        room1.setBounds(180, 130, 150, 30);
        add(room1);

        JLabel heading3 = new JLabel("Name                   :");
        heading3.setFont(new Font("Railway", Font.BOLD, 14));
        heading3.setBounds(40, 180, 600, 30);
        add(heading3);

        name1 = new JTextField();
        name1.setBounds(180, 180, 150, 30);
        add(name1);

        JLabel heading4 = new JLabel("Checkin Time      :");
        heading4.setFont(new Font("Railway", Font.BOLD, 14));
        heading4.setBounds(40, 230, 600, 30);
        add(heading4);

        checkin1 = new JTextField();
        checkin1.setBounds(180, 230, 150, 30);
        add(checkin1);

        JLabel heading5 = new JLabel("Amount Paid        :");
        heading5.setFont(new Font("Railway", Font.BOLD, 14));
        heading5.setBounds(40, 280, 600, 30);
        add(heading5);

        amount1 = new JTextField();
        amount1.setBounds(180, 280, 150, 30);
        add(amount1);

        JLabel heading6 = new JLabel("Pending Amount :");
        heading6.setFont(new Font("Railway", Font.BOLD, 14));
        heading6.setBounds(40, 330, 600, 30);
        add(heading6);

        pending1 = new JTextField();
        pending1.setBounds(180, 330, 150, 30);
        add(pending1);





        cancel = new JButton("Back");
        cancel.setBounds(280,400,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        check = new JButton("Check");
        check.setBounds(40,400,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(160,400,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        setVisible(true);
    }

    public static void main(String[] args) {
        new updatecheck();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   if(e.getSource() == check){
        String customer = customer1.getSelectedItem();
        String query = "select * from customer where number ='"+customer+"' ";
        try {
            conn c = new conn();
            ResultSet rs=c.s.executeQuery(query);
            while (rs.next()) {
                room1.setText(rs.getString("room"));
                name1.setText(rs.getString("name"));
                checkin1.setText(rs.getString("checkintime"));
                amount1.setText(rs.getString("deposit"));
                
            }
            
            String query1 = "select * from room where roomnumber = '" + room1.getText() +"' ";
            ResultSet rs1=c.s.executeQuery(query1);
            while (rs1.next()) {
                String pend  = rs1.getString("price");
                 // converting string to integer
                int pend1 = Integer.parseInt(pend) - Integer.parseInt(amount1.getText());
                 // converting integer into string
                pending1.setText( "" + pend1);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        }else if(e.getSource() == update){
        String customer = customer1.getSelectedItem();
        String room = room1.getText();
        String name = name1.getText();
        String checkin = checkin1.getText();
        String amount = amount1.getText();
        String pending = pending1.getText();
        try {
            conn c = new conn();
            // dml command
            String query1 = "update customer set room='"+room+"',name='"+name+"',checkintime='"+checkin+"',deposit='"+amount+"' where number='"+customer+"' ";
            c.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null,"Data Updated Successfully");
            setVisible(false);
            new reception();
        } catch (Exception e2) {
           e2.printStackTrace();
        }
       }else if(e.getSource() == cancel){
        setVisible(false);
        new reception();
       }
        
    }
}
