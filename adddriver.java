import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// import java.sql.ResultSet;
public class adddriver extends JFrame implements ActionListener {
    JLabel name,age,cc,cm,location;
    JTextField name1,age1,cc1,cm1,location1;
    JComboBox gender,available;
    JButton driver,cancel;
    adddriver(){
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 450);
        setTitle("Add Drivers");
        setLayout(null);
        setLocation(300, 120);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 280, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410, 70, 400, 280);
        add(image);

        JLabel heading  = new JLabel("Add Drivers");
        heading.setBounds(140,30 ,180 ,30 );
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Serif",Font.BOLD,24));
        add(heading);

        name = new JLabel("Name       :");
        name.setFont(new Font("Railway", Font.BOLD, 14));
        name.setBounds(30, 70, 150, 30);
        name.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(name);

        name1 = new JTextField();
        name1.setBounds(120, 70, 150, 30);
        add(name1);

        age = new JLabel("Age         :");
        age.setFont(new Font("Railway", Font.BOLD, 14));
        age.setBounds(30, 110, 150, 30);
        age.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(age);

        age1 = new JTextField();
        age1.setBounds(120, 110, 150, 30);
        add(age1);

        JLabel gen = new JLabel("Gender     :");
        gen.setFont(new Font("Railway", Font.BOLD, 14));
        gen.setBounds(30, 150, 190, 30);
        gen.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(gen);

        String str[] = {"Select","Male","Female"};
        gender = new JComboBox(str);
        gender.setBounds(120,150 ,150 ,30);
        gender.setBackground(Color.WHITE);
        add(gender);

        cc = new JLabel("Car Company :");
        // cc.setFont(new Font("Railway", Font.BOLD, 14));
        cc.setBounds(30, 190, 150, 30);
        cc.setFont(new Font("Tahoma",Font.PLAIN,12));
        add(cc);

        cc1 = new JTextField();
        cc1.setBounds(120, 190, 150, 30);
        add(cc1);

        cm = new JLabel("Car Model :");
        // cm.setFont(new Font("Railway", Font.BOLD, 14));
        cm.setBounds(30, 230, 150, 30);
        cm.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cm);

        cm1 = new JTextField();
        cm1.setBounds(120, 230, 150, 30);
        add(cm1);

        JLabel ava = new JLabel("Available   :");
        ava.setFont(new Font("Railway", Font.BOLD, 14));
        ava.setBounds(30, 270, 190, 30);
        ava.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(ava);

        String str1[] = {"Select","Available","Not-Available"};
        available = new JComboBox(str1);
        available.setBounds(120,270 ,150 ,30);
        available.setBackground(Color.WHITE);
        add(available);

        location = new JLabel("Location    :");
        // cm.setFont(new Font("Railway", Font.BOLD, 14));
        location.setBounds(30, 310, 150, 30);
        location.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(location);

        location1 = new JTextField();
        location1.setBounds(120, 310, 150, 30);
        add(location1);

        driver = new JButton("Add Driver");
        driver.setBounds(40,360,100,30);
        driver.setBackground(Color.BLACK);
        driver.setForeground(Color.WHITE);
        driver.addActionListener(this);
        add(driver);

        cancel = new JButton("Cancel");
        cancel.setBounds(170,360,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);



        
        setVisible(true);

    }

    public static void main(String[] args) {
        new adddriver();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = name1.getText();
        String  age= age1.getText();
        String cc = cc1.getText();
        String cm= cm1.getText();
        String location = location1.getText();
        String av = (String) available.getSelectedItem(); 
        String gen = (String) gender.getSelectedItem();
        
        if(e.getSource() == driver){
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Driver Name is required ");
    
            } else if (age.equals("")) {
                JOptionPane.showMessageDialog(null, "Driver Age is required ");
            }
            else if (cc.equals("")) {
                JOptionPane.showMessageDialog(null, "Car Company is required ");
            }
            else if (cm.equals("")) {
                JOptionPane.showMessageDialog(null, "Car Model is required ");
            }
            else if (location.equals("")) {
                JOptionPane.showMessageDialog(null, "Driver Location is required ");
            } else{
                try {
                    conn c = new conn();
                    String query = "insert into driver values('"+name+"','"+age+"','"+gen+"','"+cc+"','"+cm+"','"+av+"','"+location+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Driver Added Successfully");
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
