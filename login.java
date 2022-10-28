
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener, Runnable {
    JButton log, log2;
    JTextField user1;
    JPasswordField pass1;
    JProgressBar bar;
    JLabel pass, user, wait;
    Thread t;

    login(){
        getContentPane().setBackground(Color.WHITE);
        setSize(600, 260);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("second(1).jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 0, 200, 200);
        add(image);

        user = new JLabel("Username:");
        // use to write anything on the frame
        user.setFont(new Font("Railway", Font.BOLD, 14));
        user.setBounds(300, 40, 100, 20);
        // setBounds() is with respect to frame
        add(user);

        pass = new JLabel("Password:");
        // use to write anything on the frame
        pass.setFont(new Font("Railway", Font.BOLD, 14));
        pass.setBounds(300, 80, 100, 20);
        // setBounds() is with respect to frame
        add(pass);

        user1 = new JTextField();
        user1.setBounds(400, 40, 160, 25);
        add(user1);

        pass1 = new JPasswordField();
        pass1.setBounds(400, 80, 160, 25);
        add(pass1);

        // button
        log = new JButton("Login");
        log.setBackground(Color.BLACK);
        log.setForeground(Color.WHITE);
        log.addActionListener(this);
        log.setBounds(310, 140, 100, 25);
        add(log);

        log2 = new JButton("Cancel");
        log2.setBackground(Color.BLACK);
        log2.setForeground(Color.WHITE);
        log2.setBounds(430, 140, 100, 25);
        log2.addActionListener(this);
        add(log2);

        bar = new JProgressBar();
        bar.setBounds(290, 80, 200, 35);
        bar.setStringPainted(true);
        bar.setVisible(false);
        add(bar);

        wait = new JLabel("Loading, please wait...");
        wait.setBounds(290, 120, 190, 30);
        wait.setFont(new Font("Railway", Font.BOLD, 14));
        wait.setForeground(Color.WHITE);
        // wait.setVisible(false);
        add(wait);

        setTitle("Login page");
        setLayout(null);
        setLocation(400, 200);
        setVisible(true);

        while (true) {
            // wait.setForeground(Color.BLACK);
            wait.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            // wait.setForeground(Color.BLACK);
            wait.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new login();
    }

    @Override
    public void run() {
        wait.setForeground(Color.BLACK);
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum();
                // indicates total max value 100
                int value = bar.getValue();
                // indicates current value
                // max=100
                // value of value variable will keep changing according to for loop
                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    // new class object
                    new dashboard();
                }
                Thread.sleep(70);
                // this indicates speed of loader
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    int clicks = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log) {
            String suser = user1.getText();
            String spass = pass1.getText();

            if (suser.equals("")) {
                JOptionPane.showMessageDialog(null, "Username is required ");

            } else if (spass.equals("")) {
                JOptionPane.showMessageDialog(null, "Password is required ");
            } else {
                clicks++;
                System.out.println("successfully loged in");
                System.out.println("No of clicks : " + clicks);
                // if (clicks > 2) {
                //     log.setEnabled(false);
                //     JOptionPane.showMessageDialog(null, " Multiple attempts login after 20 seconds");
                // }
                try {

                    conn c = new conn();
                    String query = "select * from login where username ='" + suser + "' and password ='" + spass + "' ";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        System.out.println("Login successfully.....");
                        // setVisible(false);
                        user1.setVisible(false);
                        pass1.setVisible(false);
                        log.setVisible(false);
                        log2.setVisible(false);
                        user.setVisible(false);
                        pass.setVisible(false);
                        t = new Thread(this);
                        t.start();
                        bar.setVisible(true);
                        // wait.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Login" + "\n" + "Check username and Password");
                        user1.setText("");
                        pass1.setText("");
                        if (clicks > 2) {
                            log.setEnabled(false);
                            JOptionPane.showMessageDialog(null, " Multiple attempts login after 20 seconds");
                        }

                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }

        } else {
            setVisible(false);
        }

    }
}
