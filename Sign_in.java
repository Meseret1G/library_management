package library_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sign_in extends JFrame {
    private JTextField usernameinput;
    private JPasswordField passwordinput;

    public Sign_in() {
    	Font titleFont = new Font("Cambria", Font.BOLD, 30);
        Font inputFont = new Font("Cambria", Font.BOLD, 16);
    	JPanel sign= new JPanel();
    	sign.setLayout(new BoxLayout(sign,BoxLayout.Y_AXIS));
    	sign.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    	sign.setPreferredSize(new Dimension(400,500));
    	sign.setBackground(Color.white);
    	
    	
    	JPanel close= new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	close.setPreferredSize(new Dimension(400,10));
    	close.setBackground(Color.white);
    	JButton closebtn= new JButton("X");
    	closebtn.setBackground(new Color(46,45,45));
    	closebtn.setForeground(Color.white);
    	closebtn.addActionListener(e->{
    		dispose();
    	});
    	close.add(closebtn);
    	sign.add(close);
    	
    	JPanel signtitlepanel= new JPanel();
    	signtitlepanel.setBackground(Color.white);
    	signtitlepanel.setPreferredSize(new Dimension(400,50));
    	JLabel signtitle= new JLabel("Sign UP");
    	signtitle.setBackground(Color.white);
    	signtitle.setFont(titleFont);
    	signtitlepanel.add(signtitle);
    	sign.add(signtitlepanel);
    	
    	JPanel usernamepanel= new JPanel(new FlowLayout(FlowLayout.LEFT));
    	usernamepanel.setBackground(Color.white);
    	JLabel username= new JLabel("User name");
    	username.setFont(inputFont);
    	usernameinput= new JTextField(20);
    	usernameinput.setBackground(Color.white);
    	usernameinput.setFont(inputFont);
    	usernamepanel.add(username);
    	usernamepanel.add(usernameinput);
    	sign.add(usernamepanel);
    	
    	JPanel passwordpanel= new JPanel(new FlowLayout(FlowLayout.LEFT));
    	passwordpanel.setBackground(Color.white);
    	JLabel password = new JLabel("Password ");
    	password.setFont(inputFont);
    	passwordinput= new JPasswordField(20);
    	passwordinput.setBackground(Color.white);
    	passwordinput.setFont(inputFont);
    	passwordpanel.add(password);
    	passwordpanel.add(passwordinput);
    	sign.add(passwordpanel);
    	
    	JPanel btnpanel= new JPanel();
    	btnpanel.setBackground(Color.white);
    	JButton signup=new JButton ("Sign UP");
    	signup.setBackground(new Color(46,45,45));
    	signup.setForeground(Color.white);
    	signup.setFont(inputFont);
    	signup.addActionListener(new SignInListener());
    	btnpanel.add(signup);
    	sign.add(btnpanel);
    	
    	
    	add(sign);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(400, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private class SignInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameinput.getText();
            String password = new String(passwordinput.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                return;
            }
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM sign WHERE username = '" + username + "' and password = '"+ password+"';");
                if (rs.next()) {
                    if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                        dispose();
                        new Home_page();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (SQLException e1) {
                JOptionPane.showInputDialog(this);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Sign_in();
            }
        });
    }
}