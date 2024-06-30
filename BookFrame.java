package library_management;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;

public class BookFrame extends JFrame {

    private JTextField idinput, nameinput, authorinput, quantityinput;
    private DefaultTableModel tableModel;
    private JTable table;
    private BookDAO bookDAO;

    public BookFrame() {
        Font font = new Font("Cambria", Font.BOLD, 14);
        JPanel titlePanel = new JPanel();
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
        titlePanel.setLayout(new BorderLayout());
        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(400, 40));

        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(600, 40));
        content.add(left);
        content.add(right);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Book ID");
        tableModel.addColumn("Book Name");
        tableModel.addColumn("Author Name");
        tableModel.addColumn("Quantity");

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM book");

            while (rs.next()) {
                int column1 = rs.getInt("id");
                String column2 = rs.getString("book_name");
                String column3 = rs.getString("author_name");
                String column4 = rs.getString("quantity");
                tableModel.addRow(new Object[]{column1, column2, column3, column4});
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        table = new JTable(tableModel);
        table.setBackground(Color.lightGray);
        table.setFont(font);
        table.setRowHeight(30);
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new CustomTableHeaderRenderer());
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        header.setFont(font);
        header.setBackground(Color.DARK_GRAY);
        header.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(Color.DARK_GRAY);

        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBackground(Color.LIGHT_GRAY);
        JPanel rightBottom = new JPanel();
        rightBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        rightBottom.setBackground(Color.LIGHT_GRAY);
        JButton closeButton = new JButton("Close");
        closeButton.setBorderPainted(false);
        closeButton.setFont(font);
        closeButton.setBackground(new Color(47, 46, 46));
        closeButton.setForeground(Color.white);
        closeButton.setMargin(new Insets(5, 20, 5, 20));

        closeButton.addActionListener(e -> {
            dispose();
        });

        JPanel rightUpper = new JPanel();
        rightUpper.setLayout(new BoxLayout(rightUpper, BoxLayout.Y_AXIS));
        rightUpper.setPreferredSize(new Dimension(600, 450));
        rightUpper.add(scrollPane);
        scrollPane.setBackground(Color.DARK_GRAY);
        rightUpper.setBorder(BorderFactory.createEmptyBorder(50, 30, 50, 30));
        rightUpper.setBackground(Color.LIGHT_GRAY);
        rightBottom.add(closeButton);
        right.add(rightUpper);
        right.add(rightBottom);

        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(Color.white);
        JPanel leftBottom = new JPanel();
        leftBottom.setLayout(new GridLayout(1, 3, 30, 0));
        leftBottom.setBackground(Color.white);

        bookDAO = new BookDAO();

        JButton addButton = new JButton("Add");
        addButton.setBorderPainted(false);
        addButton.setFont(font);
        addButton.setBackground(new Color(47, 46, 46));
        addButton.setForeground(Color.white);
        addButton.setMargin(new Insets(5, 20, 5, 20));
        addButton.addActionListener(e -> {
            String name = nameinput.getText().trim();
            String author = authorinput.getText().trim();
            int quantity = Integer.parseInt(quantityinput.getText().trim());
            bookDAO.addBook(name, author, quantity);
            
            refreshTable();
        });
        leftBottom.add(addButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBorderPainted(false);
        updateButton.setFont(font);
        updateButton.setBackground(new Color(47, 46, 46));
        updateButton.setForeground(Color.white);
        updateButton.setMargin(new Insets(5, 20, 5, 20));
        updateButton.addActionListener(e -> {
            int id = Integer.parseInt(idinput.getText().trim());
            String name = nameinput.getText().trim();
            String author = authorinput.getText().trim();
            int quantity = Integer.parseInt(quantityinput.getText().trim());
            bookDAO.updateBook(id, name, author, quantity);
            refreshTable();
        });
        leftBottom.add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBorderPainted(false);
        deleteButton.setFont(font);
        deleteButton.setBackground(new Color(47, 46, 46));
        deleteButton.setForeground(Color.white);
        deleteButton.setMargin(new Insets(5, 20, 5, 20));
        deleteButton.addActionListener(e -> {
            int id = Integer.parseInt(idinput.getText().trim());
            bookDAO.deleteBook(id);
            refreshTable();
        });
        leftBottom.add(deleteButton);
        leftBottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        JPanel leftUpper = new JPanel();
        leftUpper.setPreferredSize(new Dimension(400, 450));
        leftUpper.setBackground(Color.white);

        idinput = new JTextField(20);
        idinput.setBorder(null);
        idinput.setFont(font);
        JSeparator separator1 = new JSeparator();
        separator1.setPreferredSize(new Dimension(10, 10));
        nameinput = new JTextField(20);
        nameinput.setBorder(null);
        nameinput.setFont(font);
        JSeparator separator2 = new JSeparator();
        separator2.setPreferredSize(new Dimension(10, 10));
        authorinput = new JTextField(20);
        authorinput.setBorder(null);
        authorinput.setFont(font);
        JSeparator separator3 = new JSeparator();
        separator3.setPreferredSize(new Dimension(10, 10));
        quantityinput = new JTextField(20);
        quantityinput.setBorder(null);
        quantityinput.setFont(font);
        JSeparator separator4 = new JSeparator();
        separator4.setPreferredSize(new Dimension(10, 10));
        JLabel idLabel = new JLabel("Book ID");
        idLabel.setFont(font);
        JLabel nameLabel = new JLabel("Book Name");
        nameLabel.setFont(font);
        JLabel authorLabel = new JLabel("Author Name");
        authorLabel.setFont(font);
        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setFont(font);

        JPanel inputContent = new JPanel();
        inputContent.setBackground(Color.white);
        inputContent.setBorder(BorderFactory.createEmptyBorder(50, 30, 30, 50));
        inputContent.setLayout(new BoxLayout(inputContent, BoxLayout.Y_AXIS));
        inputContent.setPreferredSize(new Dimension(400, 450));
        inputContent.add(idLabel);
        inputContent.add(idinput);
        inputContent.add(separator1);
        inputContent.add(nameLabel);
        inputContent.add(nameinput);
        inputContent.add(separator2);
        inputContent.add(authorLabel);
        inputContent.add(authorinput);
        inputContent.add(separator3);
        inputContent.add(quantityLabel);
        inputContent.add(quantityinput);
        inputContent.add(separator4);
        leftUpper.add(inputContent);

        left.add(leftUpper);
        left.add(leftBottom);

        titlePanel.add(content);

        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(titlePanel);
        setBackground(Color.white);
        setVisible(true);
        setSize(1000, 500);
        setLocationRelativeTo(null);

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    idinput.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    nameinput.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    authorinput.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    quantityinput.setText(tableModel.getValueAt(selectedRow, 3).toString());
                }
            }
        });
    }

    private void refreshTable() {
        // Clear table
        tableModel.setRowCount(0);

        // Reload data from database
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM book");

            while (rs.next()) {
                int column1 = rs.getInt("id");
                String column2 = rs.getString("book_name");
                String column3 = rs.getString("author_name");
                String column4 = rs.getString("quantity");
                tableModel.addRow(new Object[]{column1, column2, column3, column4});
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public class BookDAO {

        private Connection conn;

        public BookDAO() {
            try {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void addBook(String name, String author, int quantity) {
            String sql = "INSERT INTO book (book_name, author_name, quantity) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, name);
                stmt.setString(2, author);
                stmt.setInt(3, quantity);
                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateBook(int id, String name, String author, int quantity) {
            String query = "UPDATE book SET book_name = ?, author_name = ?, quantity = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, name);
                pstmt.setString(2, author);
                pstmt.setInt(3, quantity); 
                pstmt.setInt(4, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public void deleteBook(int id) {
            String sql = "DELETE FROM book WHERE id=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
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
 
