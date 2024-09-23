package librarymanagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBook extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtPosition;
    private JTextField txtBookName;
    private JTextField txtReferenceNumber;
    private DefaultTableModel tableModel;
    private LibraryManagementSystem library;  
 
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    LibraryManagementSystem library = new LibraryArrayADT(); 

                    AddBook frame = new AddBook(library);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AddBook(LibraryManagementSystem library) {
        if (library == null) {
            throw new IllegalArgumentException("LibraryManagementSystem cannot be null");
        }

        this.library = library; 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	    contentPane.setLayout(null);
	     
	    JButton btnManageBook = new JButton("Add");
	    btnManageBook.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String referenceNumber = txtReferenceNumber.getText().trim();
	            String bookName = txtBookName.getText().trim();
	            String positionText = txtPosition.getText().trim();

	            if (referenceNumber.isEmpty() || bookName.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Reference Number and Book Name must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
	            } else if (!positionText.isEmpty() && !isNumeric(positionText)) {
	                JOptionPane.showMessageDialog(null, "Invalid position. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
	            } else {
	                if (positionText.isEmpty()) {
	                    library.addBook(referenceNumber, bookName);
	                    JOptionPane.showMessageDialog(null, "Book '" + bookName + "' with Reference Number '" + referenceNumber + "' added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    int position = Integer.parseInt(positionText);
	                    if (position < 0 || position > library.getTotalBooks()) {
	                        JOptionPane.showMessageDialog(null, "Position out of bounds. Please enter a valid index.", "Error", JOptionPane.ERROR_MESSAGE);
	                    } else {
	                        library.insertBook(position, referenceNumber, bookName);
	                        JOptionPane.showMessageDialog(null, "Book '" + bookName + "' with Reference Number '" + referenceNumber + "' inserted at position " + position + ".", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    }
	                }
	                txtReferenceNumber.setText("");
	                txtBookName.setText("");
	                txtPosition.setText("");
	                updateTable();
	            }
	        }
	    });
	    
	    JButton btnPushBook = new JButton("Push Book");
	    btnPushBook.setBorder(UIManager.getBorder("ToolBar.border"));
	    btnPushBook.setBackground(new Color(222, 184, 135));
	    btnPushBook.setFont(new Font("Century", Font.PLAIN, 16));
        btnPushBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String referenceNumber = txtReferenceNumber.getText().trim();
                String bookName = txtBookName.getText().trim();
                if (!referenceNumber.isEmpty() && !bookName.isEmpty()) {
                    library.addBook(referenceNumber, bookName);
                    JOptionPane.showMessageDialog(null, "Book pushed onto the stack!");
                    updateTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Both fields must be filled!");
                }
            }
        });
        btnPushBook.setBounds(605, 107, 120, 33);
        contentPane.add(btnPushBook);

        JButton btnPopBook = new JButton("Pop Book");
        btnPopBook.setBorder(UIManager.getBorder("ToolBar.border"));
        btnPopBook.setBackground(new Color(222, 184, 135));
        btnPopBook.setFont(new Font("Century", Font.PLAIN, 16));
        btnPopBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 Books poppedBook = library.popBook();
                 if (poppedBook != null) {
                     JOptionPane.showMessageDialog(null, "Book '" + poppedBook.getName() + "' with Reference Number '" + poppedBook.getReferenceNumber() + "' has been popped from the stack.", "Success", JOptionPane.INFORMATION_MESSAGE);
                     updateTable();  
                 }
             }
         });
        btnPopBook.setBounds(605, 151, 120, 33);
        contentPane.add(btnPopBook);
	    JButton btnBubbleSort = new JButton("Bubble Sort");
	    btnBubbleSort.setToolTipText("Click to sort the books alphabetically by name");
	    btnBubbleSort.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            bubbleSortBooks();
	        }
	    });
	    btnBubbleSort.setFont(new Font("Century", Font.PLAIN, 16));
	    btnBubbleSort.setBorder(UIManager.getBorder("ToolBar.border"));
	    btnBubbleSort.setBackground(new Color(222, 184, 135));
	    btnBubbleSort.setBounds(458, 151, 124, 33); 
	    contentPane.add(btnBubbleSort); 
	    
	    String[] columnNames = {"Position", "Name", "Reference Number"};
	    tableModel = new DefaultTableModel(columnNames, 0);
	    JTable table = new JTable(tableModel);
	     
	    table.setFont(new Font("Arial", Font.PLAIN, 16));
	    table.setRowHeight(30);
	    table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
	     
	    JButton btnManageBook_1 = new JButton("Back");
	    btnManageBook_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Screen mn = new Screen(library);
	            mn.setVisible(true);
	            dispose();
	        }
	    });
	    btnManageBook_1.setFont(new Font("Century", Font.PLAIN, 16));
	    btnManageBook_1.setBorder(UIManager.getBorder("ToolBar.border"));
	    btnManageBook_1.setBackground(new Color(222, 184, 135));
	    btnManageBook_1.setBounds(725, 487, 124, 33);
	    contentPane.add(btnManageBook_1);
	     
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBackground(new Color(255, 255, 240));
	    scrollPane.setBorder(UIManager.getBorder("ToolBar.border"));
	    scrollPane.setBounds(20, 209, 829, 267);
	    getContentPane().add(scrollPane);
	    
	    btnManageBook.setBackground(new Color(222, 184, 135));
	    btnManageBook.setFont(new Font("Century", Font.PLAIN, 16));
	    btnManageBook.setBorder(UIManager.getBorder("ToolBar.border"));
	    btnManageBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnManageBook.setBounds(458, 107, 124, 33);
	    contentPane.add(btnManageBook);
	     
	    txtBookName = new JTextField();
	    txtBookName.setColumns(10);
	    txtBookName.setBounds(217, 129, 165, 28);
	    contentPane.add(txtBookName);
	     
	    txtReferenceNumber = new JTextField();
	    txtReferenceNumber.setColumns(10);
	    txtReferenceNumber.setBounds(217, 90, 165, 28);
	    contentPane.add(txtReferenceNumber);
	     
	    txtPosition = new JTextField();
	    txtPosition.setBounds(217, 173, 165, 28);
	    contentPane.add(txtPosition);
	    txtPosition.setColumns(10);
	     
	    JLabel lblBookName = new JLabel("Book Name:");
	    lblBookName.setFont(new Font("Century", Font.PLAIN, 16));
	    lblBookName.setBounds(20, 125, 99, 33);
	    contentPane.add(lblBookName);
	     
	    JLabel lblPositionoptional = new JLabel("Position (Optional):");
	    lblPositionoptional.setFont(new Font("Century", Font.PLAIN, 16));
	    lblPositionoptional.setBounds(20, 169, 144, 33);
	    contentPane.add(lblPositionoptional);
	     
	    JLabel lblNewLabel = new JLabel("Reference Number:");
	    lblNewLabel.setFont(new Font("Century", Font.PLAIN, 16));
	    lblNewLabel.setBounds(20, 91, 144, 23);
	    contentPane.add(lblNewLabel);
	     
	    JLabel lblTitle = new JLabel("Library Management");
	    lblTitle.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 30));
	    lblTitle.setBounds(274, 11, 520, 43);
	    getContentPane().add(lblTitle);
	    
	    JTextField textField = new JTextField();
	    textField.setEnabled(false);
	    textField.setEditable(false);
	    textField.setForeground(new Color(255, 255, 255));
	    textField.setBorder(UIManager.getBorder("ToolBar.border"));
	    textField.setBackground(new Color(255, 255, 224));
	    textField.setBounds(0, -2, 900, 533);
	    getContentPane().add(textField);
	    textField.setColumns(10);

	    updateTable();
    }

    private void updateTable() {
        tableModel.setRowCount(0); 
        int totalBooks = library.getTotalBooks();
        for (int i = 0; i < totalBooks; i++) {
            String name = library.getBook(i);
            String referenceNumber = library.getReferenceNumber(i);
            tableModel.addRow(new Object[]{i, name, referenceNumber});
        }
    }

    private boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }

    private void bubbleSortBooks() {
        int totalBooks = library.getTotalBooks();
        if (totalBooks <= 1) return; 
        
        String[] bookNames = new String[totalBooks];
        String[] referenceNumbers = new String[totalBooks];

        for (int i = 0; i < totalBooks; i++) {
            bookNames[i] = library.getBook(i);
            referenceNumbers[i] = library.getReferenceNumber(i);
        }

        for (int i = 0; i < totalBooks - 1; i++) {
            for (int j = 0; j < totalBooks - i - 1; j++) {
                if (referenceNumbers[j].compareTo(referenceNumbers[j + 1]) > 0) {
                    String tempRef = referenceNumbers[j];
                    referenceNumbers[j] = referenceNumbers[j + 1];
                    referenceNumbers[j + 1] = tempRef;

                    String tempName = bookNames[j];
                    bookNames[j] = bookNames[j + 1];
                    bookNames[j + 1] = tempName;
                }
            }
        }

        library.clearBooks(); 

       
        // Re-adding sorted books to the library
        for (int i = 0; i < totalBooks; i++) {
            library.addBook(referenceNumbers[i], bookNames[i]);
        }

        // Update the table with the newly sorted books
        updateTable();

        // Reset input fields after sorting
        txtReferenceNumber.setText("");
        txtBookName.setText("");
        txtPosition.setText("");

        // Notify the user that the books are sorted
        JOptionPane.showMessageDialog(null, "Books sorted by reference number.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
