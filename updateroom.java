import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class updateroom extends JFrame implements ActionListener  {
    Choice customer1;
    JTextField room1,available1,cs1;
    JButton cancel,check,update;
    updateroom(){
        getContentPane().setBackground(Color.WHITE);
        setSize(950, 450);
        setTitle("Check-in/Check-out");
        setLayout(null);
        setLocation(250, 120);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 280, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 80, 450, 280);
        add(image);

        JLabel heading = new JLabel("Update Room Status");
        heading.setFont(new Font("Railway", Font.BOLD, 24));
        heading.setBounds(120, 30, 600, 30);
        add(heading);

        
        JLabel heading1 = new JLabel("Customer Id       : ");
        heading1.setFont(new Font("Railway", Font.BOLD, 16));
        heading1.setBounds(40, 80, 140, 30);
        add(heading1);

        customer1 = new Choice();
        customer1.setBounds(180, 85, 150, 30);
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

        JLabel heading2 = new JLabel("Room Number   : ");
        heading2.setFont(new Font("Railway", Font.BOLD, 16));
        heading2.setBounds(40, 140, 150, 30);
        add(heading2);

        room1 = new JTextField();
        room1.setBounds(180, 140, 150, 30);
        add(room1);

        JLabel heading3 = new JLabel("Availability          :");
        heading3.setFont(new Font("Railway", Font.BOLD, 16));
        heading3.setBounds(40, 200, 600, 30);
        add(heading3);

        available1 = new JTextField();
        available1.setBounds(180, 200, 150, 30);
        add(available1);

        JLabel heading4 = new JLabel("Cleaning Status :");
        heading4.setFont(new Font("Railway", Font.BOLD, 16));
        heading4.setBounds(40, 260, 600, 30);
        add(heading4);

        cs1 = new JTextField();
        cs1.setBounds(180, 260, 150, 30);
        add(cs1);

        cancel = new JButton("Back");
        cancel.setBounds(280,330,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        check = new JButton("Check");
        check.setBounds(40,330,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(160,330,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);



        setVisible(true);

    }

    public static void main(String[] args) {
        new updateroom();
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
                
             }
            String query1 = "select * from room where roomnumber = '" + room1.getText() +"' ";
            ResultSet rs1=c.s.executeQuery(query1);
            while (rs1.next()) {
                available1.setText(rs1.getString("availability"));
                cs1.setText(rs1.getString("cleaning_status"));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
      }else if(e.getSource() == update){
        String customer = customer1.getSelectedItem();
        String room = room1.getText();
        String available = available1.getText();
        String cleaning = cs1.getText();

        if (room.equals("")) {
            JOptionPane.showMessageDialog(null, "Room-No is required ");

        } else if (available.equals("")) {
            JOptionPane.showMessageDialog(null, "Availability of room is required ");
        }else if (cleaning.equals("")) {
            JOptionPane.showMessageDialog(null, "Cleaning-Status is required ");
        }else{
            try {
            conn c = new conn();
            // dml command
            String query1 = "update room set roomnumber='"+room+"',availability='"+available+"',cleaning_status='"+cleaning+"' where roomnumber='"+room+"' ";
            c.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null,"Data Updated Successfully");
            setVisible(false);
            new reception();
        } catch (Exception e2) {
           e2.printStackTrace();
        }
    }
      }else if(e.getSource() == cancel){
        setVisible(false);
        new reception();
      }
        
    }
}
