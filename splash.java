import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class splash extends JFrame implements ActionListener,Runnable {
    JButton next;
    splash(){

        setSize(1100,450);
        setLocation(190,130);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        setUndecorated(true);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,400 ,600 ,40 );
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,30));
        image.add(text);

         next = new JButton("Next");
        next.setBounds(900,400 ,120 ,30 );
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.setFont(new Font("serif",Font.PLAIN,24));
        next.addActionListener(this);
        image.add(next);

        
        setVisible(true);


        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
               e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }

       


    }

    public static void main(String[] args) {
        new splash();
    }

    @Override
    public void run() {
     
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == next){
            setVisible(false);
            new login();

        }
    }
}
