package library_management;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home_page extends JFrame {
    connection conn;
    JPanel upper;
    JLabel label_on_upper;
    JPanel menuPanel, content_display;
    JPanel no_stu, no_book,no_borrow;
    private BookFrame bookFrame;
    private BorrowedPanel borrowedPanel;
    private ReturnedFrame returnedFrame;
    private MembersFrame membersFrame;

    Home_page() {
    	
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Library Management System");
        setSize(1500, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        conn = new connection();
        
        upper = new JPanel(new BorderLayout());
        upper.setPreferredSize(new Dimension(1000, 40));
        upper.setBackground(new Color(85, 82, 82));
        label_on_upper = new JLabel("Library Management System");
        Font font = new Font("Cambria", Font.BOLD, 18);
        label_on_upper.setFont(font);
        upper.add(label_on_upper, BorderLayout.WEST);
        add(upper, BorderLayout.NORTH);

        menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.setBackground(new Color(47, 46, 46));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 100, 0));

        JPanel menuItemsPanel = new JPanel();
        menuItemsPanel.setLayout(new BoxLayout(menuItemsPanel, BoxLayout.Y_AXIS));
        JMenuItem home = new JMenuItem("Home");
        home.setForeground(Color.white);
        home.setBackground(new Color(47, 46, 46));
        home.addMouseListener(new MenuMouseListener());
        JMenuItem book = new JMenuItem("Books");
        book.setForeground(Color.white);
        book.setBackground(new Color(47, 46, 46));
        book.addMouseListener(new MenuMouseListener());
        JMenuItem borrowed = new JMenuItem("Borrowed Books");
        borrowed.setForeground(Color.white);
        borrowed.setBackground(new Color(47, 46, 46));
        borrowed.addMouseListener(new MenuMouseListener());
        JMenuItem returned = new JMenuItem("Returned Books");
        returned.setForeground(Color.white);
        returned.setBackground(new Color(47, 46, 46));
        returned.addMouseListener(new MenuMouseListener());
        JMenuItem members = new JMenuItem("Members");
        members.setForeground(Color.white);
        members.setBackground(new Color(47, 46, 46));
        members.addMouseListener(new MenuMouseListener());
        JMenuItem setting = new JMenuItem("Settings");
        setting.setForeground(Color.white);
        setting.setBackground(new Color(47, 46, 46));
        setting.addMouseListener(new MenuMouseListener());
        JMenuItem logout = new JMenuItem("Logout");
        logout.setForeground(Color.white);
        logout.setBackground(new Color(85, 82, 82));
        logout.addMouseListener(new MenuMouseListener());

        Dimension itemSize = new Dimension(200, 30);
        home.setPreferredSize(itemSize);
        book.setPreferredSize(itemSize);
        borrowed.setPreferredSize(itemSize);
        returned.setPreferredSize(itemSize);
        members.setPreferredSize(itemSize);
        setting.setPreferredSize(itemSize);
        logout.setPreferredSize(itemSize);

        font = new Font("Cambria", Font.BOLD, 16);
        home.setFont(font);
        book.setFont(font);
        borrowed.setFont(font);
        returned.setFont(font);
        setting.setFont(font);
        members.setFont(font);
        logout.setFont(font);

        menuItemsPanel.add(home);
        menuItemsPanel.add(book);
        menuItemsPanel.add(borrowed);
        menuItemsPanel.add(returned);
        menuItemsPanel.add(members);
        menuItemsPanel.add(setting);
        menuItemsPanel.add(logout);

        menuItemsPanel.setBackground(new Color(47, 46, 46));
        menuPanel.add(menuItemsPanel, BorderLayout.CENTER);

        add(menuPanel, BorderLayout.WEST);
        CardLayout cardLayout = new CardLayout();
        content_display = new JPanel(cardLayout);
        add(content_display, BorderLayout.CENTER);

        JPanel homePanel = new HomePanel(this, conn);
        content_display.add(homePanel, "Home");

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(content_display, "Home");
            }
        });

        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bookFrame != null) {
                    bookFrame.dispose();
                }
                bookFrame = new BookFrame();
            }
        });

        borrowed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (borrowedPanel != null) {
                    borrowedPanel.dispose();
                }
                borrowedPanel = new BorrowedPanel();
            }
        });

        returned.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (returnedFrame != null) {
                    returnedFrame.dispose();
                }
                returnedFrame = new ReturnedFrame();
            }
        });

        members.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (membersFrame != null) {
                    membersFrame.dispose();
                }
                membersFrame = new MembersFrame();
            }
        });
    }

   /* public static void main(String[] args) {
        connection conn= new connection();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Home_page();
            }
        });
        conn.close();
    }*/
}

class MenuMouseListener extends MouseAdapter {
    private Color originalColor;
    private JMenuItem selectedItem = null;
    private Color originalSelectedItemColor;

    @Override
    public void mousePressed(MouseEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getComponent();
originalColor = menuItem.getForeground();
        originalSelectedItemColor = menuItem.getBackground();
        menuItem.setForeground(Color.BLACK);
        menuItem.setBackground(Color.WHITE);
        selectedItem = menuItem;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (selectedItem!= null) {
            selectedItem.setForeground(originalColor);
            selectedItem.setBackground(originalSelectedItemColor);
            selectedItem = null;
        }
    }
}

class HomePanel extends JPanel {
    connection conn;
    JPanel content_display,sample,no_stu,no_book,no_borrow;
    
    public HomePanel(Home_page homePage, connection conn) {
    	this.setBackground(Color.white);
        content_display= new JPanel();
        content_display.setBackground(Color.white);
        add(content_display);
        
        sample= new JPanel(new GridLayout(1,3,70,0));
        sample.setBackground(Color.white);
        sample.setPreferredSize(new Dimension(1000, 200));
        sample.setBorder(BorderFactory.createEmptyBorder(50,0,0, 0));
        content_display.add(sample);
        
        Font font = new Font("Cambria", Font.BOLD, 80);
        Font orignal=font;
        
        no_stu = new JPanel();
        no_stu.setLayout(new BoxLayout(no_stu, BoxLayout.Y_AXIS));
        no_stu.setBackground(Color.gray);
        font = new Font("Cambria", Font.BOLD, 20);
        JLabel stu_label = new JLabel("Number of Student");
        stu_label.setFont(font);
        stu_label.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        
        int stu_counter = conn.countstus("student");
        String stu_count = String.valueOf(stu_counter);
        JLabel stu_area = new JLabel(stu_count);
        
        font = new Font("Cambria", Font.BOLD, 80);
        stu_area.setFont(font);
        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(10, 10)); 
        no_stu.add(stu_label);
        no_stu.add(separator);
        no_stu.add(stu_area);
        sample.add(no_stu);
        
        
        no_book= new JPanel();
        no_book.setLayout(new BoxLayout(no_book, BoxLayout.Y_AXIS));
        no_book.setBackground(Color.gray);
        font = new Font("Cambria", Font.BOLD, 20);
        JLabel book_label = new JLabel("Number of Book");
        book_label.setFont(font);
        book_label.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        
        int book_counter = conn.countbooks("book");
        String book_count = String.valueOf(book_counter); 
        
        JLabel book_area = new JLabel(book_count);
        book_area.setFont(orignal);
        JSeparator separator1 = new JSeparator();
        separator1.setPreferredSize(new Dimension(10, 10)); 
        no_book.add(book_label);
        no_book.add(separator1);
        no_book.add(book_area);
        sample.add(no_book);
        
        
        no_borrow= new JPanel();
        no_borrow.setLayout(new BoxLayout(no_borrow, BoxLayout.Y_AXIS));
        no_borrow.setBackground(Color.gray);
        font = new Font("Cambria", Font.BOLD, 20);
        JLabel borrow_label = new JLabel("Number of Book");
        borrow_label.setFont(font);
        borrow_label.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        JLabel borrow_area = new JLabel("ni");
        borrow_area.setFont(orignal);
        JSeparator separator2 = new JSeparator();
        separator2.setPreferredSize(new Dimension(10, 10)); 
        no_borrow.add(borrow_label);
        no_borrow.add(separator2);
        no_borrow.add(borrow_area);
        sample.add(no_borrow);
    }
}


