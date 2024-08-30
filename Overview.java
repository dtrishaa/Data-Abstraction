package librarymanagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Overview extends JFrame {
    private static final long serialVersionUID = 1L;
    private LibraryManagementSystem library;
    
    public Overview(LibraryManagementSystem library) {
        this.library = library; 
        

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 883, 560);
        getContentPane().setLayout(null);
                
                
                        JLabel lblNewLabel = new JLabel("Overview");
                        lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 30));
                        lblNewLabel.setBounds(284, 12, 520, 43);
                        getContentPane().add(lblNewLabel);
        
        
                JTextField textField_1 = new JTextField();
                textField_1.setBackground(new Color(255, 248, 220));
                textField_1.setEditable(false);
                textField_1.setBorder(UIManager.getBorder("ToolBar.border"));
                textField_1.setBounds(0, 0, 867, 55);
                getContentPane().add(textField_1);
                textField_1.setColumns(10);


        String[] columnNames = {"Position", "Name", "Reference Number"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        

        int totalBooks = library.size();
        for (int i = 0; i < totalBooks; i++) {
            String position = String.valueOf(i);
            String name = library.getBook(i);
            String referenceNumber = library.getReferenceNumber(i);
            model.addRow(new Object[]{position, name, referenceNumber});
        }

        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 780, 313);
        getContentPane().add(scrollPane);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		main tr = new main(library);
            		tr.setVisible(true);
            		dispose();
        	}
        });
        btnBack.setFont(new Font("Century", Font.PLAIN, 16));
        btnBack.setBorder(UIManager.getBorder("ToolBar.border"));
        btnBack.setBackground(new Color(255, 255, 224));
        btnBack.setBounds(680, 439, 150, 30);
        getContentPane().add(btnBack);


        if (library.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No books in the library.", "Library Empty", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
