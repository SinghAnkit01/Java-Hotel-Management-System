import java.awt.*;

import javax.print.DocFlavor.STRING;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.ResultSet;

public class addcustomer extends JFrame implements ActionListener {
    JComboBox id1;
    JTextField name1,country1,deposit1,number1;
    JRadioButton male,female;
    Choice room;
    JLabel ct;
    JButton customer,cancel;
    JLabel price1;
    addcustomer(){
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 540);
        setTitle("Add Customer");
        setLayout(null);
        setLocation(310, 120);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 20, 450, 480);
        add(image);

        JLabel id = new JLabel("Id            :");
        id.setFont(new Font("Railway", Font.BOLD, 14));
        id.setBounds(60, 30, 100, 30);
        // id.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(id);

        String str[] = {"Select","Passport","Aadhar","Driving-Liscence","Voter-id","Others"};
        id1 = new JComboBox(str);
        id1.setBounds(150,30 ,150 ,30);
        id1.setBackground(Color.WHITE);
        add(id1);

       JLabel number = new JLabel("Number    :");
        number.setFont(new Font("Railway", Font.BOLD, 14));
        number.setBounds(60, 80, 120, 30);
        // number.setFont(new Font("Tahoma",Font.BOLD,16));
        add(number);

        number1 = new JTextField();
        number1.setBounds(150, 80, 150, 30);
        add(number1);

       JLabel name = new JLabel("Name       :");
        name.setFont(new Font("Railway", Font.BOLD, 14));
        name.setBounds(60, 130, 120, 30);
        // name.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(name);

        name1 = new JTextField();
        name1.setBounds(150, 130, 150, 30);
        add(name1);

       JLabel gender = new JLabel("Gender    :");
        gender.setFont(new Font("Railway", Font.BOLD, 14));
        gender.setBounds(60, 180, 120, 30);
        // gender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(gender);

        // gender1 = new JTextField();
        // gender1.setBounds(160, 130, 150, 30);
        // add(gender1);

         male = new JRadioButton("Male");
        male.setBounds(160,180 ,70 ,30 );
        male.setFont(new Font("Tahoma",Font.PLAIN,16));
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(230,180 ,90 ,30 );
        female.setFont(new Font("Tahoma",Font.PLAIN,16));
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gender1 = new ButtonGroup();
        gender1.add(male);
        gender1.add(female);

         JLabel country = new JLabel("Country    :");
        country.setFont(new Font("Railway", Font.BOLD, 14));
        country.setBounds(60, 230, 120, 30);
        // country.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(country);

        country1 = new JTextField();
        country1.setBounds(150, 230, 150, 30);
        add(country1);

        JLabel arm = new JLabel("Allocated  :");
        arm.setFont(new Font("Railway", Font.BOLD, 14));
        arm.setBounds(60, 280, 90, 30);
        // country.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(arm);

        JLabel arm1 = new JLabel(" (Room Number) ");
        arm1.setFont(new Font("Railway", Font.BOLD, 12));
        arm1.setBounds(50, 303 ,110, 30);
        // country.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(arm1);

        // setting available room number dynamically from database

        room = new Choice();
        room.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c = new conn();
                    String query = "select * from room where roomnumber='"+room.getSelectedItem()+"' ";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        price1.setText(rs.getString("price"));
                       }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            
         });

        try {
            conn c = new conn();
            String query = "select * from room where availability='Available' ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                room.add(rs.getString("roomnumber"));
                // use while istead of else because we want to fetch multiple values from database
                // use else via login 
                // price1.setText(rs.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

         room.setBounds(150, 280, 150, 30);
        add(room);

        JLabel ctime = new JLabel("Checkin time :");
        ctime.setFont(new Font("Railway", Font.BOLD, 14));
        ctime.setBounds(50, 330, 120, 30);
        add(ctime);

        Date date = new Date();
        // comes under util package
        ct = new JLabel( "" + date);
        // converting object into string because jlabel accepts string to be stored
        ct.setFont(new Font("Railway", Font.BOLD, 14));
        ct.setBounds(150, 330, 200, 30);
        add(ct);

        // System.out.println(1+2+3+4+5+"Ankit singh"+1+2+3+4+5);x`

        JLabel depo = new JLabel("Deposit   :");
        depo.setFont(new Font("Railway", Font.BOLD, 14));
        depo.setBounds(60, 380, 120, 30);
        // country.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(depo);

        deposit1 = new JTextField();
        deposit1.setBounds(150, 380, 150, 30);
        add(deposit1);

        customer = new JButton("Add");
        customer.setBounds(60,440,100,30);
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.WHITE);
        customer.addActionListener(this);
        add(customer);

        cancel = new JButton("Back");
        cancel.setBounds(200,440,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        JLabel price = new JLabel(" TotalPrice =");
        price.setBounds(160,303 ,100 ,30 );
        price.setFont(new Font("Railway", Font.BOLD, 14));
        add(price);

        
        price1 = new JLabel();
        price1.setBounds(255,303 ,100 ,30 );
        price1.setFont(new Font("Railway", Font.BOLD, 14));
        try {
            conn c = new conn();
            String query = "select * from room where roomnumber='"+room.getSelectedItem()+"'  ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                price1.setText(rs.getString("price"));
               }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add(price1);

        // int dep = Integer.parseInt(deposit1.getText());
        // // String dep = deposit1.getText();
        // int pri = Integer.parseInt(price1.getText());
        // // // String pri = price1.getText();
        // if(dep < pri){

        // }else{
        //     JOptionPane.showMessageDialog(null, "Deposit is greater than room price");
        // }

      
        setVisible(true);
    }

    public static void main(String[] args) {
        new addcustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id= (String) id1.getSelectedItem();
        String snumber = number1.getText();
        String sname = name1.getText();
        String scountry = country1.getText();
        String sdeposit = deposit1.getText();
        String sgender=null;
        if(male.isSelected()){
            sgender = "Male";
        }else if(female.isSelected()){
            sgender = "Female";
        }
        String allocate = room.getSelectedItem();
        String time = ct.getText();

      
       if(e.getSource() == customer){
        if (snumber.equals("")) {
            JOptionPane.showMessageDialog(null, "number is required ");

        } else if (sname.equals("")) {
            JOptionPane.showMessageDialog(null, "name is required ");
        }else if (scountry.equals("")) {
            JOptionPane.showMessageDialog(null, "country is required ");
        }else if (sdeposit.equals("")) {
            JOptionPane.showMessageDialog(null, "deposit is required ");
        }
        else{
            int dep = Integer.parseInt(deposit1.getText());
            // String dep = deposit1.getText();
            int pri = Integer.parseInt(price1.getText());
            // // String pri = price1.getText();
            if(dep < pri){
                try {
                    conn c = new conn();
                    String query = "insert into customer values('"+id+"','"+snumber+"','"+sname+"','"+sgender+"','"+scountry+"','"+allocate+"','"+time+"','"+sdeposit+"')";
                    String query2 = "update room set availability ='Occupied' where roomnumber='"+allocate+"' ";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Customer Added Successfully");
                    setVisible(false);
                    new reception();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Deposit is greater than room price");
            }
    
          
        }
       }else if(e.getSource() == cancel){
      
        setVisible(false);
        new reception();
       }
        
    }
}
