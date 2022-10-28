import java.awt.Image;
import javax.swing.ImageIcon; 
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class reception extends JFrame implements ActionListener,Runnable {
    JButton addcustomer,rooms,department,allemployee,customerinfo,managerinfo,checkout,ps,us,rs,pickup,sr;
    reception(){

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 550);
        setTitle("Reception Corner");
        setLayout(null);
        setLocation(300, 90);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, 70, 500, 400);
        add(image);

        // adding buttons
        addcustomer = new JButton("New Customer Form");
        addcustomer.setBounds(40,30,150,30);
        addcustomer.setBackground(Color.BLACK);
        addcustomer.setForeground(Color.WHITE);
        addcustomer.addActionListener(this);
        add(addcustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(40,70,150,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        rooms.setMargin(new Insets(0,0,0,70));
        add(rooms);

        department = new JButton("Department");
        department.setBounds(40,110,150,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        department.setMargin(new Insets(0,0,0,50));
        add(department);

        allemployee = new JButton("All Employee");
        allemployee.setBounds(40,150,150,30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        allemployee.addActionListener(this);
        allemployee.setMargin(new Insets(0,0,0,40));
        add(allemployee);

        customerinfo = new JButton("Customer info");
        customerinfo.setBounds(40,190,150,30);
        customerinfo.setBackground(Color.BLACK);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.addActionListener(this);
        customerinfo.setMargin(new Insets(0,0,0,37));
        add(customerinfo);

        managerinfo = new JButton("Manager info");
        managerinfo.setBounds(40,230,150,30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.setMargin(new Insets(0,0,0,37));
        managerinfo.addActionListener(this);
        add(managerinfo);

        checkout = new JButton("Checkout");
        checkout.setBounds(40,270,150,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setMargin(new Insets(0,0,0,55));
        checkout.addActionListener(this);
        add(checkout);

        ps = new JButton("Logout");
        ps.setBounds(40,470,150,30);
        ps.setBackground(Color.BLACK);
        ps.setForeground(Color.WHITE);
        ps.addActionListener(this);
        ps.setMargin(new Insets(0,0,0,25));
        add(ps);

        us = new JButton("Update Status");
        us.setBounds(40,310,150,30);
        us.setBackground(Color.BLACK);
        us.setForeground(Color.WHITE);
        us.addActionListener(this);
        us.setMargin(new Insets(0,0,0,30));
        add(us);

        rs = new JButton("Update Room Status");
        rs.setBounds(40,350,150,30);
        rs.setBackground(Color.BLACK);
        rs.setForeground(Color.WHITE);
        rs.addActionListener(this);
        rs.setMargin(new Insets(0,0,0,0));
        add(rs);

        pickup = new JButton("Pickup Service");
        pickup.setBounds(40,390,150,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        pickup.setMargin(new Insets(0,0,0,30));
        add(pickup);

        sr = new JButton("Search Room");
        sr.setBounds(40,430,150,30);
        sr.setBackground(Color.BLACK);
        sr.setForeground(Color.WHITE);
        sr.addActionListener(this);
        sr.setMargin(new Insets(0,0,0,37));
        add(sr);

        setVisible(true);
    }

    public static void main(String[] args) {
        new reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "New Customer Form"){
            // System.out.println("ncf");
            setVisible(false);
            new addcustomer();
        }else if(e.getActionCommand() == "Rooms"){
            // System.out.println("room");
            setVisible(false);
            new showroom();
        }
        else if(e.getActionCommand() == "Department"){
            // System.out.println("department");
            setVisible(false);
            new showdepartment();
        }
        else if(e.getActionCommand() == "All Employee"){
            // System.out.println("all employee");
            setVisible(false);
            new showemployee();
        }
        else if(e.getActionCommand() == "Customer info"){
            // System.out.println("ci");
            setVisible(false);
            new showcustomer();
        }
        else if(e.getActionCommand() == "Manager info"){
            // System.out.println("mi");
            setVisible(false);
            new showmanager();
        }
        else if(e.getActionCommand() == "Checkout"){
            // System.out.println("co");
            setVisible(false);
            new checkout();
        }
      
        else if(e.getActionCommand() == "Update Status"){
            // System.out.println("us");
            setVisible(false);
            new updatecheck();
        }
        else if(e.getActionCommand() == "Update Room Status"){
            // System.out.println("urs");
            setVisible(false);
            new updateroom();
        }
        else if(e.getActionCommand() == "Pickup Service"){
            // System.out.println("pservice");
            setVisible(false);
            new pickup();
        }
        else if(e.getActionCommand() == "Search Room"){
           // System.out.println("sr");
            setVisible(false);
            new searchroom();
        } else if(e.getActionCommand() == "Logout"){
            Thread t;
            // System.out.println("logout");
            t = new Thread(this);
            t.start();
        
            // exit is a static method which accepts status as an argument and method-body runs this method =>  Runtime.getRuntime().exit(status); 
        }
        
    }

    @Override
    public void run() {
        try {
            // because of external entity
            JOptionPane.showMessageDialog(null,"Wait System is closing");
            Thread.sleep(5000);
            JOptionPane.showMessageDialog(null,"Bye");
            System.exit(0);
        } catch (InterruptedException e) {
          
            e.printStackTrace();
        }
       
        
    }
}
