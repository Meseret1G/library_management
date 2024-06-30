package library_management;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import library_management.BookFrame.BookDAO;


public class MembersFrame extends JFrame{
	private DefaultTableModel tableModel;
    private JTable table;

	MembersFrame(){
		Font titleFont= new Font ("Cambria", Font.BOLD, 30);
		Font inputFont = new Font("Cambria",Font.BOLD,16);
		
		JPanel left= new JPanel();
		left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
		left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		left.setPreferredSize(new Dimension(400,500));
		left.setBackground(Color.white);
		JPanel leftTitlePanel= new JPanel();
		JLabel leftTitle= new JLabel("Student Details");
		leftTitle.setFont(titleFont);
		leftTitlePanel.setBackground(Color.white);
		leftTitlePanel.add(leftTitle);
		left.add(leftTitlePanel);
		
		JPanel issuedetails = new JPanel();
		issuedetails.setLayout(new BoxLayout(issuedetails,BoxLayout.Y_AXIS));
		JLabel stuid= new JLabel("Student ID");
		stuid.setFont(inputFont);
		JLabel stuname = new JLabel("Student Name");
		stuname.setFont(inputFont);
		JLabel studep= new JLabel("Student Department");
		studep.setFont(inputFont);
		JTextField stuidinput= new JTextField(20);
		stuidinput.setFont(inputFont);
		stuidinput.setBorder(null);
		JTextField stunameinput= new JTextField(20);
		stunameinput.setFont(inputFont);
		stunameinput.setBorder(null);
		JTextField studepinput= new JTextField(20);
		studepinput.setFont(inputFont);
		studepinput.setBorder(null);
		
		issuedetails.add(stuid);
		issuedetails.add(stuidinput);
		JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(10, 10));
    	issuedetails.add(separator);
		issuedetails.add(stuname);
		issuedetails.add(stunameinput);
		JSeparator separator1 = new JSeparator();
        separator1.setPreferredSize(new Dimension(10, 10));
    	issuedetails.add(separator1);
		issuedetails.add(studep);
		issuedetails.add(studepinput);
		JSeparator separator2 = new JSeparator();
        separator2.setPreferredSize(new Dimension(10, 10));
    	issuedetails.add(separator2);
    	issuedetails.setPreferredSize(new Dimension(400, 450));
    	issuedetails.setBorder(BorderFactory.createEmptyBorder(20, 10, 70, 10));
    	issuedetails.setBackground(Color.white);
    	JPanel issuedetailPanel= new JPanel();
    	issuedetailPanel.add(issuedetails);
    	issuedetailPanel.setBackground(Color.white);
    	issuedetailPanel.setPreferredSize(new Dimension(400, 450));
		left.add(issuedetailPanel);
		
		JPanel leftBottom = new JPanel();
        leftBottom.setLayout(new GridLayout(1, 3, 30, 0));
        leftBottom.setBackground(Color.white);
        left.add(leftBottom);
        
        stuDAO stuDAO = new stuDAO();
		
		JButton addButton = new JButton("Add");
        addButton.setBorderPainted(false);
        addButton.setFont(inputFont);
        addButton.setBackground(new Color(47, 46, 46));
        addButton.setForeground(Color.white);
        addButton.setMargin(new Insets(5, 20, 5, 20));
        addButton.addActionListener(e -> {
        	String id=stuidinput.getText().trim();
            String name = stunameinput.getText().trim();
            String dep = studepinput.getText().trim();
            stuDAO.addStu(id, name, dep);
            refreshTable();
        });
        leftBottom.add(addButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBorderPainted(false);
        updateButton.setFont(inputFont);
        updateButton.setBackground(new Color(47, 46, 46));
        updateButton.setForeground(Color.white);
        updateButton.setMargin(new Insets(5, 20, 5, 20));
        updateButton.addActionListener(e -> {
            String id = stuidinput.getText().trim();
            String name = stunameinput.getText().trim();
            String dep = studepinput.getText().trim();
            stuDAO.updateStu(id,name,dep);
            refreshTable();
        });
        leftBottom.add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBorderPainted(false);
        deleteButton.setFont(inputFont);
        deleteButton.setBackground(new Color(47, 46, 46));
        deleteButton.setForeground(Color.white);
        deleteButton.setMargin(new Insets(5, 20, 5, 20));
        deleteButton.addActionListener(e -> {
            String id = stuidinput.getText().trim();
            stuDAO.deleteStu(id);
            refreshTable();
        });
        leftBottom.add(deleteButton);
        leftBottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		
		JPanel right= new JPanel();
		right.setPreferredSize(new Dimension(600,500));
		right.setBackground(Color.LIGHT_GRAY);
		
		tableModel = new DefaultTableModel();
        tableModel.addColumn("Student ID");
        tableModel.addColumn("Student Name");
        tableModel.addColumn("Department");
		
		try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                String column1 = rs.getString("id");
                String column2 = rs.getString("stu_name");
                String column3 = rs.getString("dep");
                tableModel.addRow(new Object[]{column1, column2, column3});
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		table = new JTable(tableModel);
        table.setBackground(Color.lightGray);
        table.setFont(inputFont);
        table.setRowHeight(30);
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new CustomTableHeaderRenderer());
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        header.setFont(inputFont);
        header.setBackground(Color.DARK_GRAY);
        header.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(Color.DARK_GRAY);

        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        JPanel rightUpper = new JPanel();
        rightUpper.setLayout(new BoxLayout(rightUpper, BoxLayout.Y_AXIS));
        rightUpper.setPreferredSize(new Dimension(600, 450));
        rightUpper.add(scrollPane);
        scrollPane.setBackground(Color.DARK_GRAY);
        rightUpper.setBorder(BorderFactory.createEmptyBorder(50, 30, 50, 30));
        rightUpper.setBackground(Color.LIGHT_GRAY);
        right.add(rightUpper);
		
        
        JButton closeButton = new JButton("Close");
        closeButton.setBorderPainted(false);
        closeButton.setFont(inputFont);
        closeButton.setBackground(new Color(47, 46, 46));
        closeButton.setForeground(Color.white);
        closeButton.setMargin(new Insets(5, 20, 5, 20));

        closeButton.addActionListener(e -> {
            dispose();
        });
        
        JPanel rightLower= new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightLower.setBackground(Color.LIGHT_GRAY);
        rightLower.add(closeButton);
        right.add(rightLower);
		JPanel total = new JPanel();
		total.setLayout(new BoxLayout(total, BoxLayout.X_AXIS));
		total.setBackground(Color.white);
		total.add(left);
		total.add(right);
		add(total);
		
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    stuidinput.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    stunameinput.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    studepinput.setText(tableModel.getValueAt(selectedRow, 2).toString());
                }
            }
        });
	}
	private static class CustomTableCellRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            return cell;
        }
    }

    private static class CustomTableHeaderRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component header = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(JLabel.CENTER);
            setBackground(Color.GRAY);
            setForeground(Color.WHITE);
            setFont(header.getFont().deriveFont(Font.BOLD, 14));
            return header;
        }
    }
    private void refreshTable() {
        // Clear table
        tableModel.setRowCount(0);

        // Reload data from database
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
            	String column1 = rs.getString("id");
                String column2 = rs.getString("stu_name");
                String column3 = rs.getString("dep");
                tableModel.addRow(new Object[]{column1, column2, column3});
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public class stuDAO {

        private Connection conn;

        public stuDAO() {
            try {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void addStu(String id, String stu_name, String dep) {
            String sql = "INSERT INTO student (id, stu_name, dep) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, id);
                stmt.setString(2, stu_name);
                stmt.setString(3, dep);
                stmt.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateStu(String id, String name, String dep) {
            String query = "UPDATE student SET stu_name = ?, dep = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, name);
                pstmt.setString(2,dep );
                pstmt.setString(3, id);
                pstmt.executeUpdate();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void deleteStu(String id) {
            String sql = "DELETE FROM student WHERE id=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void close() {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


