package librarymanagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Remove_book extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private LibraryManagementSystem library;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LibraryManagementSystem library = new LibraryArrayADT(); 
                Remove_book frame = new Remove_book(library);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Remove_book(LibraryManagementSystem library) {
        this.library = library;

        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));


        tableModel = new DefaultTableModel(new Object[]{"Position", "Book Name"}, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);


        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        JButton btnRemoveBook = new JButton("Remove Book");
        btnRemoveBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    library.removeBook(selectedRow);
                    updateTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a book to remove.", "No Selection", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panel.add(btnRemoveBook);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		main mn = new main(library);
        		mn.setVisible(true);
        		dispose();
        	}
        });
        panel.add(btnBack);


        updateTable();
    }

    /**
     * Updates the table with the current list of books.
     */
    private void updateTable() {
        tableModel.setRowCount(0);
        int totalBooks = library.getTotalBooks();
        for (int i = 0; i < totalBooks; i++) {
            String bookName = library.getBook(i);
            tableModel.addRow(new Object[]{i, bookName});
        }
    }
}
