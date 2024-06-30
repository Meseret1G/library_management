package library_management;

import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

class BorrowedPanel extends JFrame {
    public BorrowedPanel() {
        Font titleFont = new Font("Cambria", Font.BOLD, 30);
        Font inputFont = new Font("Cambria", Font.BOLD, 16);

        JPanel fullFrame = new JPanel(new GridLayout(1, 3, 0, 0));
        fullFrame.setBackground(Color.white);
        add(fullFrame);

        JPanel stu = new JPanel();
        stu.setLayout(new BoxLayout(stu, BoxLayout.Y_AXIS));
        stu.setBackground(Color.white);

        JPanel stuTitlePanel = new JPanel();
        JLabel stuTitle = new JLabel("Student Details");
        stuTitle.setFont(titleFont);
        stuTitlePanel.add(stuTitle);
        stuTitlePanel.setBackground(Color.white);
        stuTitlePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 0));
        stu.add(stuTitlePanel);

        JLabel stuId = new JLabel("Student Name");
        stuId.setFont(inputFont);
        JLabel stuName = new JLabel("Student Name");
        stuName.setFont(inputFont);
        JLabel stuDep = new JLabel("Student Department");
        stuDep.setFont(inputFont);
        JTextField stuidInput = new JTextField(20);
        stuidInput.setFont(inputFont);
        stuidInput.setBorder(null);
        JTextField stunameInput = new JTextField(20);
        stunameInput.setFont(inputFont);
        stunameInput.setBorder(null);
        JTextField studepInput = new JTextField(20);
        studepInput.setFont(inputFont);
        studepInput.setBorder(null);

        JPanel stuInputContainer = new JPanel();
        stuInputContainer.setLayout(new BoxLayout(stuInputContainer, BoxLayout.Y_AXIS));
        stuInputContainer.setBackground(Color.white);

        stuInputContainer.add(stuId);
        JSeparator separator1 = new JSeparator();
        separator1.setPreferredSize(new Dimension(10, 10));
        stuInputContainer.add(stuidInput);
        stuInputContainer.add(separator1);
        stuInputContainer.add(stuName);
        stuInputContainer.add(stunameInput);
        JSeparator separator2 = new JSeparator();
        separator2.setPreferredSize(new Dimension(10, 10));
        stuInputContainer.add(separator2);
        stuInputContainer.add(stuDep);
        stuInputContainer.add(studepInput);
        JSeparator separator3 = new JSeparator();
        separator3.setPreferredSize(new Dimension(10, 10));
        stuInputContainer.add(separator3);

        stuInputContainer.setBorder(BorderFactory.createEmptyBorder(50, 10, 90, 15));

        JPanel stucontainer = new JPanel();
        stuInputContainer.setPreferredSize(new Dimension(300, 450));
        stucontainer.setPreferredSize(new Dimension(300, 450));
        stucontainer.setBackground(Color.white);
        stucontainer.add(stuInputContainer);
        stu.add(stucontainer);

        JPanel book = new JPanel();
        book.setBackground(Color.LIGHT_GRAY);
        book.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JPanel bookTitlePanel = new JPanel();
        JLabel bookTitle = new JLabel("Book Details");
        bookTitle.setFont(titleFont);
        bookTitlePanel.add(bookTitle);
        bookTitlePanel.setBackground(Color.LIGHT_GRAY);
        book.add(bookTitlePanel);

        JLabel bookid = new JLabel("Book ID");
        bookid.setFont(inputFont);
        JLabel bookname = new JLabel("Book Name");
        bookname.setFont(inputFont);
        JLabel bookauthor = new JLabel("Book Author");
        bookauthor.setFont(inputFont);
        JLabel bookquantity = new JLabel("Book Quantity");
        bookquantity.setFont(inputFont);
        JTextField bookidinput = new JTextField(20);
        bookidinput.setFont(inputFont);
        bookidinput.setBorder(null);
        bookidinput.setBackground(Color.LIGHT_GRAY);
        JTextField booknameinput = new JTextField(20);
        booknameinput.setFont(inputFont);
        booknameinput.setBorder(null);
        booknameinput.setBackground(Color.LIGHT_GRAY);
        JTextField bookauthorinput = new JTextField(20);
        bookauthorinput.setFont(inputFont);
        bookauthorinput.setBorder(null);
        bookauthorinput.setBackground(Color.LIGHT_GRAY);
        JTextField bookquantityinput = new JTextField(20);
        bookquantityinput.setBorder(null);
        bookquantityinput.setBackground(Color.LIGHT_GRAY);
        bookquantityinput.setFont(inputFont);

        JPanel bookInputContainer = new JPanel();
        bookInputContainer.setLayout(new BoxLayout(bookInputContainer, BoxLayout.Y_AXIS));
        bookInputContainer.setBorder(BorderFactory.createEmptyBorder(20, 10, 100, 15));
        bookInputContainer.setBackground(Color.LIGHT_GRAY);
        bookInputContainer.setPreferredSize(new Dimension(300, 450));
bookInputContainer.add(bookid);
        bookInputContainer.add(bookidinput);
        JSeparator separator4 = new JSeparator();
        separator4.setPreferredSize(new Dimension(10, 10));
        separator4.setBackground(Color.BLACK);
        bookInputContainer.add(separator4);
        bookInputContainer.add(bookname);
        bookInputContainer.add(booknameinput);
        JSeparator separator5 = new JSeparator();
        separator5.setPreferredSize(new Dimension(10, 10));
        separator5.setBackground(Color.BLACK);
        bookInputContainer.add(separator5);
        bookInputContainer.add(bookauthor);
        bookInputContainer.add(bookauthorinput);
        JSeparator separator6 = new JSeparator();
        separator6.setPreferredSize(new Dimension(10, 10));
        separator6.setBackground(Color.BLACK);
        bookInputContainer.add(separator6);
        bookInputContainer.add(bookquantity);
        bookInputContainer.add(bookquantityinput);
        JSeparator separator7 = new JSeparator();
        separator7.setPreferredSize(new Dimension(10, 10));
        separator7.setBackground(Color.BLACK);
        bookInputContainer.add(separator7);

        JPanel bookcontainer = new JPanel();
        bookcontainer.setBackground(Color.LIGHT_GRAY);
        bookcontainer.setPreferredSize(new Dimension(300, 450));
        bookcontainer.add(bookInputContainer);
        book.add(bookcontainer);

        JPanel issue = new JPanel();
        issue.setBorder(BorderFactory.createEmptyBorder(-5, 0, 0, 0));
        JPanel allContainer = new JPanel();
        allContainer.setLayout(new BoxLayout(allContainer, BoxLayout.Y_AXIS));
        allContainer.setBackground(Color.gray);
        allContainer.setPreferredSize(new Dimension(350, 500));
        JPanel closePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        closePanel.setPreferredSize(new Dimension(350, 20));
        closePanel.setBackground(Color.gray);
        JButton close = new JButton("Close");
        Font btnFont = new Font("Cambria", Font.BOLD, 15);
        close.setFont(btnFont);
        close.setMargin(new Insets(0, 15, 10, 15));
        close.setBackground(new Color(45, 42, 42));
        close.setForeground(Color.white);
        closePanel.add(close);
        close.addActionListener(e -> {
            dispose();
            
        });
        allContainer.add(closePanel);

        JPanel issueTitlePanel = new JPanel();
        issueTitlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        JLabel issueTitle = new JLabel("Issue Book");
        issueTitle.setFont(titleFont);
        issueTitlePanel.add(issueTitle);
        issueTitlePanel.setBackground(Color.GRAY);
        allContainer.add(issueTitlePanel);

        JLabel stuid = new JLabel("Student ID");
        stuid.setFont(inputFont);
        JLabel bkid = new JLabel("Book ID");
        bkid.setFont(inputFont);
        JLabel issuedate = new JLabel("Issue Date");
        issuedate.setFont(inputFont);
        JLabel duedate = new JLabel("Due Date");
        duedate.setFont(inputFont);
        JTextField stuidinput = new JTextField(20);
        stuidinput.setFont(inputFont);
        stuidinput.setBackground(Color.gray);
        stuidinput.setBorder(null);
        JTextField bkidinput = new JTextField(20);
        bkidinput.setFont(inputFont);
        bkidinput.setBackground(Color.gray);
        bkidinput.setBorder(null);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
        datePicker.addActionListener(e -> {
            java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(selectedDate);
            datePicker.getJFormattedTextField().setText(formattedDate);
        });

        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, null);
        datePicker2.addActionListener(e -> {
            java.util.Date selectedDate2 = (java.util.Date) datePicker2.getModel().getValue();
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate2 = dateFormat2.format(selectedDate2);
            datePicker2.getJFormattedTextField().setText(formattedDate2);
        });

        JButton issuebtn = new JButton("Issue Book");
        issuebtn.setFont(inputFont);
        issuebtn.setMargin(new Insets(5, 92, 5, 92));
        issuebtn.setBackground(new Color(45, 42, 42));
        issuebtn.setForeground(Color.white);

        JPanel issueinputcontainer= new JPanel();
        issueinputcontainer.setPreferredSize(new Dimension(320,170));
        issueinputcontainer.setLayout(new BoxLayout(issueinputcontainer,BoxLayout.Y_AXIS));

        JPanel issueinputcontainer1= new JPanel();
        issueinputcontainer1.setBackground(Color.gray);
        issueinputcontainer1.setPreferredSize(new Dimension(300,170));
        issueinputcontainer1.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));
        issueinputcontainer1.setLayout(new FlowLayout(FlowLayout.LEFT));
        issueinputcontainer.add(stuid);
        issueinputcontainer.add(stuidinput);

        //stuidinput.

        JSeparator separator8 = new JSeparator();
        separator8.setPreferredSize(new Dimension(10, 10));
        separator8.setBackground(Color.BLACK);
        issueinputcontainer.add(separator8);

        JSeparator separator9 = new JSeparator();
        separator9.setPreferredSize(new Dimension(10, 10));
        separator9.setBackground(Color.BLACK);
        issueinputcontainer.setBackground(Color.gray);
        issueinputcontainer.add(bkid);
        issueinputcontainer.add(bkidinput);
        issueinputcontainer.add(separator9);
        issueinputcontainer1.add(issueinputcontainer);

        JPanel issueinputcontainer2= new JPanel();
        issueinputcontainer2.setLayout(new BoxLayout(issueinputcontainer2,BoxLayout.Y_AXIS));
        issueinputcontainer2.setPreferredSize(new Dimension(300,160));
        issueinputcontainer2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        JPanel issueinputcontainer3= new JPanel();
        issueinputcontainer3.setLayout(new FlowLayout(FlowLayout.LEFT));
        issueinputcontainer3.setPreferredSize(new Dimension(300,160));

        JSeparator separator10 = new JSeparator();
        separator10.setPreferredSize(new Dimension(10, 10));
        separator10.setBackground(Color.BLACK);
        JPanel issuepicker = new JPanel(new FlowLayout());
        issuepicker.setBackground(Color.gray);
        issuepicker.add(issuedate);
        issuepicker.add(datePicker);
        JPanel issuepicker2 = new JPanel(new FlowLayout());
        issuepicker2.setBackground(Color.gray);
        issueinputcontainer2.add(issuepicker2);
        issueinputcontainer2.add(issuepicker);
        issueinputcontainer2.add(separator10);
        issueinputcontainer2.setBackground(Color.gray);
        JSeparator separator11 = new JSeparator();
        separator11.setPreferredSize(new Dimension(10, 10));
        separator11.setBackground(Color.BLACK);
        JPanel duepicker = new JPanel(new FlowLayout());
        duepicker.setBackground(Color.gray);
        duepicker.add(duedate);
        duepicker.add(datePicker2);
        issueinputcontainer2.add(duepicker);
        JPanel duepicker2 = new JPanel(new FlowLayout());
        duepicker2.setBackground(Color.gray);
        issueinputcontainer2.add(duepicker2);
        issueinputcontainer2.add(separator11);
        issueinputcontainer3.setBackground(Color.gray);
        //issueinputcontainer.add(issuebtn);

        issueinputcontainer.setBackground(Color.gray);
        issueinputcontainer2.setBackground(Color.gray);
        issueinputcontainer3.add(issueinputcontainer2);

        JPanel issuecontainer= new JPanel();
        issuecontainer.setLayout(new BoxLayout(issuecontainer,BoxLayout.Y_AXIS));
        issuecontainer.add(issueinputcontainer1);
        issuecontainer.add(issueinputcontainer3);
        //issuecontainer.setBorder(BorderFactory.createEmptyBorder(5, 10, 20, 10));
        JPanel btn= new JPanel();
        btn.setPreferredSize(new Dimension(300,20));
        btn.setBackground(Color.gray);
        btn.add(issuebtn);
        issuecontainer.add(btn);
        issuecontainer.setBackground(Color.gray);
        issuecontainer.setPreferredSize(new Dimension(300,500));
        allContainer.add(issuecontainer);

        issue.add(allContainer);


        fullFrame.add(stu);
        fullFrame.add(book);
        fullFrame.add(issue);

        stuidinput.addActionListener(e -> {
            String input = stuidinput.getText();
            if (input.isEmpty()) {
                return;
            }
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE id = '" + input + "'");
                if (rs.next()) {
                    stuidInput.setText(rs.getString("id"));
                    stunameInput.setText(rs.getString("stu_name"));
                    studepInput.setText(rs.getString("dep"));
                } else {
                    JOptionPane.showMessageDialog(this, "No student found with ID: " + input, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(this, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        bkidinput.addActionListener(e -> {
        	String input = bkidinput.getText();
            if (input.isEmpty()) {
                return;
            }
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM book WHERE id = '" + input + "'");
                if (rs.next()) {
                    bookidinput.setText(rs.getString("id"));
                    booknameinput.setText(rs.getString("book_name"));
                    bookauthorinput.setText(rs.getString("author_name"));
                    bookquantityinput.setText(rs.getString("quantity"));
                } else {
                    JOptionPane.showMessageDialog(this, "No book found with ID: " + input, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(this, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        issuebtn.addActionListener(e->{
            int input = Integer.parseInt(bkidinput.getText());
            String input1 = stuidinput.getText();
            int input2 = Integer.parseInt(bkidinput.getText());
            String input3 = datePicker.getJFormattedTextField().getText();
            String input4 = datePicker2.getJFormattedTextField().getText();
            Connection conn=null;
            try {
            	conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
                conn.setAutoCommit(false); // Start a transaction
                
                PreparedStatement stmt1 = conn.prepareStatement("SELECT quantity FROM book WHERE id=?");
                stmt1.setInt(1, input);
                ResultSet rs = stmt1.executeQuery();
                
                if (rs.next()) {
                    int quantity = rs.getInt("quantity");
                    if (quantity > 0) {
                        java.sql.Date issueDate = java.sql.Date.valueOf(input3);
                        java.sql.Date dueDate = java.sql.Date.valueOf(input4);
                        
                        PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO issue_book (stu_id, book_id, issue_date, due_date, status) VALUES (?,?,?,?, 'issued')");
                        stmt2.setString(1, input1);
                        stmt2.setInt(2, input2);
                        stmt2.setDate(3, issueDate);
                        stmt2.setDate(4, dueDate);
                        int rowsAffected = stmt2.executeUpdate();
                        
                        if (rowsAffected > 0) {
                            PreparedStatement stmt3 = conn.prepareStatement("UPDATE book SET quantity =? WHERE id =?");
                            stmt3.setInt(1, quantity - 1);
                            stmt3.setInt(2, input2);
                            stmt3.executeUpdate();
                            
                            conn.commit(); 
                            JOptionPane.showMessageDialog(this, "Book issued successfully");
                        } else {
                            conn.rollback(); 
                            JOptionPane.showMessageDialog(this, "Failed to issue book");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Book is out of stock");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Book not found");
                }
            } catch (SQLException e1) {
                try {
                    conn.rollback(); 
                } catch (SQLException e2) {
                	JOptionPane.showMessageDialog(this, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(this, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    conn.close();
                } catch (SQLException e1) {
                	JOptionPane.showMessageDialog(this, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        }
        }