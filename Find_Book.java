package librarymanagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Find_Book extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtPosition;
    private LibraryManagementSystem library;
    private DefaultTableModel tableModel;

    public Find_Book(LibraryManagementSystem library) {
        this.library = library; 
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 883, 560);
        getContentPane().setLayout(null);
        

        String[] columnNames = {"Position", "Name", "Reference Number"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.setFont(new Font("Century", Font.PLAIN, 16));
        btnBack_1.setBorder(UIManager.getBorder("ToolBar.border"));
        btnBack_1.setBackground(new Color(255, 255, 224));
        btnBack_1.setBounds(395, 404, 150, 30);
        getContentPane().add(btnBack_1);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(UIManager.getBorder("ToolBar.border"));
        scrollPane.setBounds(123, 175, 579, 177);
        getContentPane().add(scrollPane);


        btnBack_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main tr = new main(library);
                tr.setVisible(true);
                dispose();
            }
        });

        JLabel lblNewLabel = new JLabel("Find Book");
        lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 30));
        lblNewLabel.setBounds(337, -1, 520, 43);
        getContentPane().add(lblNewLabel);

        JLabel lblPosition = new JLabel("Position:");
        lblPosition.setFont(new Font("Century", Font.PLAIN, 20));
        lblPosition.setBounds(113, 113, 100, 25);
        getContentPane().add(lblPosition);

        txtPosition = new JTextField();
        txtPosition.setBounds(265, 117, 300, 25);
        getContentPane().add(txtPosition);
        txtPosition.setColumns(10);

        JButton btnFindBook = new JButton("Find Book");
        btnFindBook.setBackground(new Color(255, 255, 224));
        btnFindBook.setBorder(UIManager.getBorder("ToolBar.border"));
        btnFindBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnFindBook.setFont(new Font("Century", Font.PLAIN, 16));
        btnFindBook.setBounds(569, 404, 150, 30);
        getContentPane().add(btnFindBook);


        btnFindBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String positionText = txtPosition.getText().trim();

                if (positionText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a position.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isNumeric(positionText)) {
                    JOptionPane.showMessageDialog(null, "Invalid position. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int position = Integer.parseInt(positionText);

                    if (position < 0 || position >= library.getTotalBooks()) {
                        JOptionPane.showMessageDialog(null, "Position out of bounds. Please enter a valid index.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String foundBook = library.getBook(position); 
                        String referenceNumber = library.getReferenceNumber(position);
                        

                        tableModel.setRowCount(0); 
                        tableModel.addRow(new Object[]{position, foundBook, referenceNumber});
                        
                       
                        txtPosition.setText("");  
                    }
                }
            }
        });

        JTextField textField = new JTextField();
        textField.setBorder(UIManager.getBorder("ToolBar.border"));
        textField.setEditable(false);
        textField.setBackground(new Color(255, 255, 255));
        textField.setBounds(96, 95, 638, 358);
        getContentPane().add(textField);
        textField.setColumns(10);

        JTextField textField_1 = new JTextField();
        textField_1.setBackground(new Color(255, 248, 220));
        textField_1.setEditable(false);
        textField_1.setBorder(UIManager.getBorder("ToolBar.border"));
        textField_1.setBounds(0, 0, 867, 55);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);
    }

    private boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }
}