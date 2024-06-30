package library_management;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ReturnedFrame extends JFrame{

	ReturnedFrame(){
		Font titleFont = new Font("Cambria", Font.BOLD, 30);
		Font inputFont = new Font("Cambria", Font.BOLD, 16);
		
		JPanel total=new JPanel();
		total.setLayout(new BoxLayout(total,BoxLayout.X_AXIS));
		
		
		JPanel left= new JPanel();
		left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
		left.setPreferredSize(new Dimension(500,500));
		left.setBackground(Color.white);
		left.setBorder(BorderFactory.createEmptyBorder(50, 10, 0, 10));
		
		JPanel issuetitlepanel= new JPanel();
		issuetitlepanel.setBackground(Color.white);
		issuetitlepanel.setPreferredSize(new Dimension(500,50));
		JLabel issuetitle = new JLabel("Issue Book Details");
		issuetitle.setFont(titleFont);
		issuetitlepanel.add(issuetitle);
		
		JPanel issuedetailspanel= new JPanel();
		issuedetailspanel.setBackground(Color.white);
		issuedetailspanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		issuedetailspanel.setPreferredSize(new Dimension(500,400));
		issuedetailspanel.setLayout(new BoxLayout(issuedetailspanel,BoxLayout.Y_AXIS));
		
		JLabel bookid= new JLabel("Book ID");
		bookid.setFont(inputFont);
		JLabel bookname= new JLabel("Book Name");
		bookname.setFont(inputFont);
		JLabel stuname= new JLabel("Student Name");
		stuname.setFont(inputFont);
		JLabel issuedate= new JLabel("Issue Date");
		issuedate.setFont(inputFont);
		JLabel duedate= new JLabel("Due Date");
		duedate.setFont(inputFont);
		
		JTextField bookidinput= new JTextField(20);
		bookidinput.setFont(inputFont);
		bookidinput.setBorder(null);
		JTextField booknameinput= new JTextField(20);
		booknameinput.setFont(inputFont);
		booknameinput.setBorder(null);
		JTextField stunameinput= new JTextField(20);
		stunameinput.setFont(inputFont);
		stunameinput.setBorder(null);
		JTextField issuedateinput= new JTextField(20);
		issuedateinput.setFont(inputFont);
		issuedateinput.setBorder(null);
		JTextField duedateinput= new JTextField(20);
		duedateinput.setBorder(null);
		duedateinput.setFont(inputFont);
		
		issuedetailspanel.add(bookid);
		issuedetailspanel.add(bookidinput);
		JSeparator separator1= new JSeparator();
        separator1.setPreferredSize(new Dimension(10, 10));
        issuedetailspanel.add(separator1);
		issuedetailspanel.add(bookname);
		issuedetailspanel.add(booknameinput);
		JSeparator separator2= new JSeparator();
        separator2.setPreferredSize(new Dimension(10, 10));
        issuedetailspanel.add(separator2);
		issuedetailspanel.add(stuname);
		issuedetailspanel.add(stunameinput);
		JSeparator separator3= new JSeparator();
        separator3.setPreferredSize(new Dimension(10, 10));
        issuedetailspanel.add(separator3);
		issuedetailspanel.add(issuedate);
		issuedetailspanel.add(issuedateinput);
		JSeparator separator4= new JSeparator();
        separator4.setPreferredSize(new Dimension(10, 10));
        issuedetailspanel.add(separator4);
		issuedetailspanel.add(duedate);
		issuedetailspanel.add(duedateinput);
		JSeparator separator5= new JSeparator();
        separator5.setPreferredSize(new Dimension(10, 10));
        issuedetailspanel.add(separator5);
		
		JPanel issuepanel= new JPanel(new FlowLayout(FlowLayout.LEFT));
		issuepanel.setBackground(Color.white);
		
		issuepanel.setPreferredSize(new Dimension(500,400));
		issuepanel.add(issuedetailspanel);
		
		left.add(issuetitlepanel);
		left.add(issuepanel);
		
		

		
		JPanel right= new JPanel();
		right.setLayout(new BoxLayout(right,BoxLayout.Y_AXIS));
		right.setPreferredSize(new Dimension(500,500));
		
		JPanel closebtnpanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
		closebtnpanel.setBackground(Color.LIGHT_GRAY);
		closebtnpanel.setPreferredSize(new Dimension(500,50));
		JButton close = new JButton("CLose");
		close.setFont(inputFont);
		close.setBackground(new Color(46,45,45));
		close.setForeground(Color.white);
		closebtnpanel.add(close);
		close.addActionListener(e->{
			dispose();
		});
		
		
		right.add(closebtnpanel);
		
		JPanel returnedtitlepanel= new JPanel();
		returnedtitlepanel.setBackground(Color.LIGHT_GRAY);
		returnedtitlepanel.setPreferredSize(new Dimension(500,50));
		JLabel returnedtitle= new JLabel("Returned Book");
		returnedtitle.setFont(titleFont);
		returnedtitlepanel.add(returnedtitle);
		right.add(returnedtitlepanel);
		
		JPanel rightcontainer= new JPanel(new FlowLayout(FlowLayout.LEFT));
		rightcontainer.setBackground(Color.LIGHT_GRAY);
		rightcontainer.setPreferredSize(new Dimension(500,400));
		JPanel returndetailpanel= new JPanel();
		returndetailpanel.setBackground(Color.LIGHT_GRAY);
		returndetailpanel.setBorder(BorderFactory.createEmptyBorder(20,10,30,10));
		returndetailpanel.setPreferredSize(new Dimension(500,400));
		returndetailpanel.setLayout(new BoxLayout(returndetailpanel,BoxLayout.Y_AXIS));
		
		JLabel bookId= new JLabel("Book ID");
		bookId.setFont(inputFont);
		JLabel stuId = new JLabel("Student ID");
		stuId.setFont(inputFont);
		JTextField bookIdinput= new JTextField(20);
		bookIdinput.setFont(inputFont);
		bookIdinput.setBackground(Color.LIGHT_GRAY);
		bookIdinput.setBorder(null);
		JTextField stuIdinput= new JTextField(20);
		stuIdinput.setFont(inputFont);
		stuIdinput.setBackground(Color.LIGHT_GRAY);
		stuIdinput.setBorder(null);
		
		JButton findinfo= new JButton("Find Details");
		findinfo.setFont(inputFont);
		findinfo.setMargin(new Insets(8, 192, 8, 192));
		findinfo.setBackground(new Color(46,45,45));
		findinfo.setForeground(Color.white);
		JButton returned= new JButton("Return Book");
		returned.setFont(inputFont);
		returned.setMargin(new Insets(8, 190, 8, 190));
		returned.setBackground(new Color(46,45,45));
		returned.setForeground(Color.white);
		
		returndetailpanel.add(bookId);
		returndetailpanel.add(bookIdinput);
		JSeparator separator6= new JSeparator();
		separator6.setBackground(Color.BLACK);
        separator6.setPreferredSize(new Dimension(10, 10));
        returndetailpanel.add(separator6);
        returndetailpanel.add(stuId);
		returndetailpanel.add(stuIdinput);
		JSeparator separator7= new JSeparator();
		separator7.setBackground(Color.BLACK);
        separator7.setPreferredSize(new Dimension(10, 10));
        returndetailpanel.add(separator7);
        returndetailpanel.add(Box.createRigidArea(new Dimension(0,20)));
		returndetailpanel.add(findinfo);
		returndetailpanel.add(Box.createRigidArea(new Dimension(0,20)));
		returndetailpanel.add(returned);
		
		
		returned.addActionListener(e -> {
		    String input1 = bookIdinput.getText();
		    String input2 = stuIdinput.getText();
		    if (input1.isEmpty() && input2.isEmpty()) {
		        return;
		    }
		    int Input1 = Integer.parseInt(input1);
		    Connection conn = null;
		    try {
		        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
		        conn.setAutoCommit(false); // Start a transaction
		        
		        PreparedStatement stmt1 = conn.prepareStatement("SELECT quantity FROM book WHERE id=?;");
		        stmt1.setInt(1, Input1);
		        ResultSet rs = stmt1.executeQuery();
		        
		        if (rs.next()) {
		            int quantity = rs.getInt("quantity");
		            if (quantity > 0) {
		                PreparedStatement stmt2 = conn.prepareStatement("UPDATE issue_book\r\n"
		                		+ "SET status = 'returned'\r\n"
		                		+ "FROM book, student\r\n"
		                		+ "WHERE issue_book.book_id = book.id\r\n"
		                		+ "AND issue_book.stu_id = student.id\r\n"
		                		+ "AND book.id = ?\r\n"
		                		+ "AND student.id =?;\r\n"
		                		+ "");
		                stmt2.setInt(1, Input1);
		                stmt2.setString(2, input2);
		                int rowsAffected = stmt2.executeUpdate();
		                if (rowsAffected > 0) {
		                    PreparedStatement stmt3 = conn.prepareStatement("UPDATE book SET quantity =? WHERE id =?");
		                    stmt3.setInt(1, quantity + 1);
		                    stmt3.setInt(2, Input1);
		                    stmt3.executeUpdate();
		                    
		                    conn.commit(); 
		                    JOptionPane.showMessageDialog(this, "Book returned successfully");
		                } else {
		                    conn.rollback(); 
		                    JOptionPane.showMessageDialog(this, "Failed to return book");
		                }
		            } else {
		                JOptionPane.showMessageDialog(this, "Book is out of stock");
		            }
		        } else {
		            JOptionPane.showMessageDialog(this, "Book not found");
		        }
		    } catch (SQLException e1) {
		        try {
		            conn.rollback(); // Rollback the transaction
		        } catch (SQLException e2) {
		            // Handle the rollback exception
		        }
		        JOptionPane.showMessageDialog(this, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		    } finally {
		        try {
		            conn.close(); // Close the connection
		        } catch (SQLException e1) {
		            // Handle the close exception
		        }
		    }       
		});
		
		
		findinfo.addActionListener(e -> {
            String input1 = bookIdinput.getText();
            String input2 = stuIdinput.getText();
            if (input1.isEmpty() && input2.isEmpty()) {
                return;
            }
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select book_id,stu_name,book_name, issue_date, due_date \r\n"
                		+ "from issue_book\r\n"
                		+ "inner join book on issue_book.book_id= book.id\r\n"
                		+ "inner join student on issue_book.stu_id= student.id\r\n"
                		+ "where book.id='"+input1+"' and student.id='"+ input2+"' and status='issued';");
                if (rs.next()) {
                    bookidinput.setText(rs.getString("book_id"));
                    booknameinput.setText(rs.getString("book_name"));
                    stunameinput.setText(rs.getString("stu_name"));
                    issuedateinput.setText(rs.getString("issue_date"));
                    duedateinput.setText(rs.getString("due_date"));
                } else {
                    JOptionPane.showMessageDialog(this, "No data found with ID: " + input1+ " and "+input2, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(this, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
		
		
		
		
		rightcontainer.add(returndetailpanel);
		right.add(rightcontainer);
		
		total.add(left);
		total.add(right);
		
		
		add(total);
		setUndecorated(true);
	    setBackground(Color.white);
	    setVisible(true);
	    setSize(1000, 500);
	    setLocationRelativeTo(null);
	}
}
