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
    private LibraryManagementSystem library;  // Remove static keyword

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Initialize the library before passing it to the frame
                    LibraryManagementSystem library = new LibraryArrayADT(); // Or your implementation

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

        this.library = library;  // Assign the library instance to the class variable

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
	    	  
	    	  JButton btnRemoveBook = new JButton("Remove");
	    	  btnRemoveBook.addActionListener(new ActionListener() {
	    	      public void actionPerformed(ActionEvent e) {
	    	          String positionText = txtPosition.getText().trim();

	    	          if (positionText.isEmpty()) {
	    	              JOptionPane.showMessageDialog(null, "Please enter a valid position.", "Error", JOptionPane.ERROR_MESSAGE);
	    	          } else if (!isNumeric(positionText)) {
	    	              JOptionPane.showMessageDialog(null, "Invalid position. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
	    	          } else {
	    	              int position = Integer.parseInt(positionText);
	    	              if (position < 0 || position >= library.getTotalBooks()) {
	    	                  JOptionPane.showMessageDialog(null, "Position out of bounds. Please enter a valid index.", "Error", JOptionPane.ERROR_MESSAGE);
	    	              } else {
	    	                  library.removeBook(position);
	    	                  updateTable();
	    	                  JOptionPane.showMessageDialog(null, "Book at position " + position + " removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	    	                  txtPosition.setText("");
	    	              }
	    	          }
	    	      }
	    	  });
	    	  btnRemoveBook.setBackground(new Color(222, 184, 135));
	    	  btnRemoveBook.setFont(new Font("Century", Font.PLAIN, 16));
	    	  btnRemoveBook.setBorder(UIManager.getBorder("ToolBar.border"));
	    	  btnRemoveBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    	  btnRemoveBook.setBounds(458, 170, 124, 33);
	    	  contentPane.add(btnRemoveBook);
	    	  
	     String[] columnNames = {"Position", "Name", "Reference Number"};
	        tableModel = new DefaultTableModel(columnNames, 0);
	     JTable table = new JTable(tableModel);
	     
	     	        table.setFont(new Font("Arial", Font.PLAIN, 16));
	     	        table.setRowHeight(30);
	     	        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
	     	        
	     	        	        JScrollPane scrollPane = new JScrollPane(table);
	     	        	        scrollPane.setBackground(new Color(255, 255, 240));
	     	        	        scrollPane.setBorder(UIManager.getBorder("ToolBar.border"));
	     	        	        scrollPane.setBounds(34, 238, 829, 267);
	     	        	        getContentPane().add(scrollPane);
	     btnManageBook.setBackground(new Color(222, 184, 135));
	     btnManageBook.setFont(new Font("Century", Font.PLAIN, 16));
	     btnManageBook.setBorder(UIManager.getBorder("ToolBar.border"));
	     btnManageBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	     btnManageBook.setBounds(458, 125, 124, 33);
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
	     
	     JLabel lblBookNmae = new JLabel("Book Name:");
	     lblBookNmae.setFont(new Font("Century", Font.PLAIN, 16));
	     lblBookNmae.setBounds(20, 125, 99, 33);
	     contentPane.add(lblBookNmae);
	     
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
	            String position = String.valueOf(i);
	            String name = library.getBook(i);
	            String referenceNumber = library.getReferenceNumber(i);
	            tableModel.addRow(new Object[]{position, name, referenceNumber});
	        }
	        tableModel.fireTableDataChanged(); // Add this line to notify the table of changes
	    }

	    private boolean isNumeric(String str) {
	        return str != null && str.matches("\\d+");
	    }
	}
