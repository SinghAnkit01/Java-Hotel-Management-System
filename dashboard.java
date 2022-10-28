import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
// import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
// import javax.swing.JOptionPane;
// import javax.swing.KeyStroke;
import java.awt.event.*;
import java.awt.*;

public class dashboard extends JFrame implements ActionListener {
    JMenuItem ae, ar, ad;

    dashboard() {
        setBounds(0, 0, 1360, 700);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // JOptionPane.showMessageDialog(null, "Welcome-Admin " + suser);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1360, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1360, 700);
        add(image);
        // setUndecorated(true);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("serif", Font.PLAIN, 40));
        text.setForeground(Color.WHITE);
        image.add(text);

        // setting menubar
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        // adding menu
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setFont(new Font("Railway", Font.BOLD, 14));
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenu admin = new JMenu("ADMIN");
        admin.setFont(new Font("Railway", Font.BOLD, 14));
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        // adding menuitems for hotel
        JMenuItem cb = new JMenuItem("RECEPTION");
        cb.setFont(new Font("Railway", Font.PLAIN, 16));
        cb.addActionListener(this);
        hotel.add(cb);

        // adding menuitems for admin

        ae = new JMenuItem("ADD EMPLOYEE");
        ae.setFont(new Font("Railway", Font.PLAIN, 16));
        ae.addActionListener(this);
        admin.add(ae);

        ar = new JMenuItem("ADD ROOMS");
        ar.setFont(new Font("Railway", Font.PLAIN, 16));
        ar.addActionListener(this);
        admin.add(ar);

        ad = new JMenuItem("ADD DRIVERS");
        ad.setFont(new Font("Railway", Font.PLAIN, 16));
        ad.addActionListener(this);
        admin.add(ad);

        setVisible(true);
    }

    public static void main(String[] args) {
        new dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // treat as a button or else
        // if(e.getSource() == ae){
        // new addemployee().setVisible(true);
        // }else if(e.getSource() == ar){
        // new addrooms().setVisible(true);
        // }

        // or
        // treat as a JMenuItem
        if (e.getActionCommand().equals("ADD EMPLOYEE")) {
            new addemployee();
        } else if (e.getActionCommand().equals("ADD ROOMS")) {
            new addrooms();
        } else if (e.getActionCommand().equals("ADD DRIVERS")) {
            new adddriver();
        }else if (e.getActionCommand().equals("RECEPTION")) {
            new reception();
        }
    }
}
