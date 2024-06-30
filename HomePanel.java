package library_management;

import java.awt.*;

import javax.swing.*;

class HomePanel extends JPanel {
    connection conn;
    JPanel content_display,sample,no_stu,no_book,no_borrow;
    
    public HomePanel(Home_page homePage, connection conn) {
    	this.setBackground(Color.white);
        this.conn = conn; // Initialize the conn object
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
        JLabel borrow_label = new JLabel("Number of Book issue");
        borrow_label.setFont(font);
        borrow_label.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        int issue_counter = conn.countissue("issue_book");
        String issue_count = String.valueOf(issue_counter); 
        JLabel borrow_area = new JLabel(issue_count);
        borrow_area.setFont(orignal);
        JSeparator separator2 = new JSeparator();
        separator2.setPreferredSize(new Dimension(10, 10)); 
        no_borrow.add(borrow_label);
        no_borrow.add(separator2);
        no_borrow.add(borrow_area);
        sample.add(no_borrow);
    }
}
