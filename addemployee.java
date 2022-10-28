
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class addemployee extends JFrame implements ActionListener {
    JLabel name,age,gender,job,salary,phone,email,aadhar;
    JTextField name1,age1,gender1,salary1,phone1,email1,aadhar1;
    JRadioButton male,female;
    JComboBox job1;
    JButton submit;
    addemployee(){
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 540);
        setTitle("Add Employee");
        setLayout(null);
        setLocation(380, 80);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 60, 450, 380);
        add(image);
        
        name = new JLabel("NAME        :");
        name.setFont(new Font("Railway", Font.BOLD, 14));
        name.setBounds(60, 30, 120, 30);
        name.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(name);

        name1 = new JTextField();
        name1.setBounds(160, 30, 150, 30);
        add(name1);

        age = new JLabel("AGE          :");
        age.setFont(new Font("Railway", Font.BOLD, 14));
        age.setBounds(60, 80, 120, 30);
        age.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(age);

        age1 = new JTextField();
        age1.setBounds(160, 80, 150, 30);
        add(age1);

        gender = new JLabel("GENDER    :");
        gender.setFont(new Font("Railway", Font.BOLD, 14));
        gender.setBounds(60, 130, 120, 30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(gender);

        // gender1 = new JTextField();
        // gender1.setBounds(160, 130, 150, 30);
        // add(gender1);

         male = new JRadioButton("Male");
        male.setBounds(160,130 ,70 ,30 );
        male.setFont(new Font("Tahoma",Font.PLAIN,16));
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(230,130 ,90 ,30 );
        female.setFont(new Font("Tahoma",Font.PLAIN,16));
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        job = new JLabel("JOB          :");
        job.setFont(new Font("Railway", Font.BOLD, 14));
        job.setBounds(60, 180, 120, 30);
        job.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(job);

        String str[] = {"Select","Frond Desk Clerk","Porters","House Keeping","Kitchen Staff","Room Service","Waiter/Waiteress","Manager","Accountant"};
         job1 = new JComboBox(str);
        job1.setBounds(160,180 ,150 ,30);
        job1.setBackground(Color.WHITE);
        add(job1);

        salary = new JLabel("SALARY    :");
        salary.setFont(new Font("Railway", Font.BOLD, 14));
        salary.setBounds(60, 230, 120, 30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(salary);

        salary1 = new JTextField();
        salary1.setBounds(160, 230, 150, 30);
        add(salary1);

        phone = new JLabel("PHONE     :");
        phone.setFont(new Font("Railway", Font.BOLD, 14));
        phone.setBounds(60, 280, 120, 30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,16));
       
        add(phone);

        phone1 = new JTextField();
        phone1.setBounds(160, 280, 150, 30);
        phone1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String phone = phone1.getText();
                char[] chars = phone.toCharArray();
                for (char c : chars) {
                    if ((!Character.isDigit(c))) {
                        JOptionPane.showMessageDialog(null, "Only digits are allowed");
                        phone1.setText("");
                    }
                     // // int l = value.length();
                   

                }
                if (phone.length() > 9 ) {
                    JOptionPane.showMessageDialog(null, "Maximum 10 digits are allowed");
                    phone1.setText("");
                    
                }
            }
            });
        add(phone1);

        email = new JLabel("EMAIL      :");
        email.setFont(new Font("Railway", Font.BOLD, 14));
        email.setBounds(60, 330, 120, 30);
        email.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(email);

        email1 = new JTextField();
        email1.setBounds(160, 330, 150, 30);
        email1.addMouseListener(new MouseListener(){
            // String email = email1.getText();
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Enter valid emailaddress" + "\n" + "you will receive all your updates on this email-id");
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });
        email1.addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                String email = email1.getText();
                if (email.length() > 35) {
                    JOptionPane.showMessageDialog(null, "Maximum 35 characters are allowed");
                    email1.setText("");
                }
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                email1.setText(email1.getText().toLowerCase());
                
            }
        });
        add(email1);

        aadhar = new JLabel("AADHAR-NO   :");
        aadhar.setFont(new Font("Railway", Font.BOLD, 14));
        aadhar.setBounds(60, 380, 120, 30);
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
       
        add(aadhar);

        aadhar1 = new JTextField();
        aadhar1.setBounds(160, 380, 150, 30);
        aadhar1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               
               String ot = aadhar1.getText();
                char[] chars = ot.toCharArray();
                for (char c : chars) {
                    if ( (!Character.isWhitespace(c) && (!Character.isDigit(c)))) {
                        JOptionPane.showMessageDialog(null, "Only  Digit are allowed");
                        aadhar1.setText("");
                    }
                 
                    
                      }
                if (ot.length() > 11) {
                    JOptionPane.showMessageDialog(null, "AAdhar-No is 12 Digit");
                    aadhar1.setText("");
                    
                }
               
            }
      });
        add(aadhar1);

        submit = new JButton("SUBMIT");
        submit.setBounds(160,430,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);




        setVisible(true);

    }

    public static void main(String[] args) {
        new addemployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){

            String sname = name1.getText();
            String sage = age1.getText();
            String ssalary = salary1.getText();
            String sphone = phone1.getText();
            String semail = email1.getText();
            String saadhar = aadhar1.getText();

            String sgender=null;
            if(male.isSelected()){
                sgender = "Male";
            }else if(female.isSelected()){
                sgender = "Female";
            }
            String sjob = (String) job1.getSelectedItem(); 
            // for tacking values from jcombobox and getSelectedItem returns an object and we are storing it into 
            // a string so TypeCast it with (String)

            String c1 = ".com";
            String a1 = "@";
            if (sname.equals("")) {
                JOptionPane.showMessageDialog(null, "name is required ");

            } else if (sage.equals("")) {
                JOptionPane.showMessageDialog(null, "age is required ");
            } else if (ssalary.equals("")) {
                JOptionPane.showMessageDialog(null, "salary is required ");
            } else if (sphone.equals("")) {
                JOptionPane.showMessageDialog(null, "phone is required ");
            } else if (semail.equals("")) {
                JOptionPane.showMessageDialog(null, "email is required ");
            } else if (saadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "aadhar-no is required ");
            }
            else if(!semail.contains(c1)){
                JOptionPane.showMessageDialog(null, "Email-id should contain '.com' ");
            }
            else if(!semail.contains(a1)){
                JOptionPane.showMessageDialog(null, " Email-id should contain '@' ");
            }
            else if (sphone.length()<10) {
                JOptionPane.showMessageDialog(null, "Invalid Phone-No ");
            } else if (saadhar.length()<12) {
                JOptionPane.showMessageDialog(null, "Invalid Aadhar-No ");
            } 
            else{

                try {
                    conn c = new conn();
                    String query = "insert into employee values('"+sname+"','"+sage+"','"+sgender+"','"+sjob+"','"+ssalary+"','"+sphone+"','"+semail+"','"+saadhar+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Employee Added Successfully");
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        
    }
}
