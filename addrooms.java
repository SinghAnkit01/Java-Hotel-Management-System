import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// import java.sql.ResultSet;
public class addrooms extends JFrame implements ActionListener {
    JLabel roomno,price;
    JTextField roomno1,price1;
    JComboBox available,status,bedtype;
    JButton rooms,cancel;
    addrooms(){
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 400);
        setTitle("Add Rooms");
        setLayout(null);
        setLocation(340, 170);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 280, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410, 30, 400, 280);
        add(image);
        
        roomno = new JLabel("Room Number     :");
        roomno.setFont(new Font("Railway", Font.BOLD, 14));
        roomno.setBounds(30, 30, 150, 30);
        roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(roomno);

        roomno1 = new JTextField();
        roomno1.setBounds(180, 30, 150, 30);
        add(roomno1);

        JLabel job = new JLabel("Room Availability :");
        job.setFont(new Font("Railway", Font.BOLD, 14));
        job.setBounds(30, 80, 190, 30);
        job.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(job);

        String str[] = {"Select","Available","Occupied"};
        available = new JComboBox(str);
        available.setBounds(180,80 ,150 ,30);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel job1 = new JLabel("Cleaning Status    :");
        job1.setFont(new Font("Railway", Font.BOLD, 14));
        job1.setBounds(30, 130, 180, 30);
        job1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(job1);

        String str1[] = {"Select","Cleaned","Dirty","Under-Maintenance"};
        status = new JComboBox(str1);
        status.setBounds(180,130 ,150 ,30);
        status.setBackground(Color.WHITE);
        add(status);

       JLabel price = new JLabel("Price                   :");
        price.setFont(new Font("Railway", Font.BOLD, 14));
        price.setBounds(30, 180, 150, 30);
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(price);

        price1 = new JTextField();
        price1.setBounds(180, 180, 150, 30);
        add(price1);

        JLabel job2 = new JLabel("Bed Type             :");
        job2.setFont(new Font("Railway", Font.BOLD, 14));
        job2.setBounds(30, 230, 180, 30);
        job2.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(job2);

        String str2[] = {"Select","Single-Bed","Double-Bed","Single-Bed + Deluxe","Sweet Room + Single-Bed","Sweet Room + Double-Bed"};
        bedtype = new JComboBox(str2);
        bedtype.setBounds(180,230 ,150 ,30);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);

        
        rooms = new JButton("Add Rooms");
        rooms.setBounds(50,290,100,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        cancel = new JButton("Cancel");
        cancel.setBounds(190,290,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);



        setVisible(true);
    }

    public static void main(String[] args) {
        new addrooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String number = roomno1.getText();
        String price = price1.getText();
        String av = (String) available.getSelectedItem(); 
        String cs = (String) status.getSelectedItem(); 
        String bt = (String) bedtype.getSelectedItem(); 


       if(e.getSource() == rooms){
        if (number.equals("")) {
            JOptionPane.showMessageDialog(null, "Room-No is required ");

        } else if (price.equals("")) {
            JOptionPane.showMessageDialog(null, "Price is required ");
        } else{
            try {
                conn c = new conn();
                String query = "insert into room values('"+number+"','"+av+"','"+cs+"','"+price+"','"+bt+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rooms Added Successfully");
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

       }else if(e.getSource() == cancel){
        setVisible(false);
       }
        
    }
}
