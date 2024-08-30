package librarymanagementSystem;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private LibraryManagementSystem library;
	private JLabel lblNewLabel;  
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LibraryManagementSystem library = new LibraryArrayADT();  
                    main frame = new main(library);
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
    public main(LibraryManagementSystem library) {  
        this.library = library;
        setVisible(true);
        setResizable(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 883, 560);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
		Image img1 = new ImageIcon(this.getClass().getResource("/book.png")).getImage();
		
		
		
		lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 30));
		lblNewLabel.setBounds(190, 8, 520, 43);
		contentPane.add(lblNewLabel);
		
		JTextComponent textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setSelectedTextColor(new Color(127, 255, 212));
		textField_6.setBorder(UIManager.getBorder("ToolBar.border"));
		textField_6.setBackground(new Color(255, 248, 220));
		textField_6.setBounds(0, 0, 903, 63);
		contentPane.add(textField_6);
		((JTextField) textField_6).setColumns(10);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(549, 317, 129, 78);
		contentPane.add(lblNewLabel);
		
		Image img2 = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(249, 125, 129, 78);
		contentPane.add(lblNewLabel);
		
		
		Image img3 = new ImageIcon(this.getClass().getResource("/insert.png")).getImage();
		
		Image img4 = new ImageIcon(this.getClass().getResource("/remove.png")).getImage();
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(img4));
		lblNewLabel.setBounds(537, 125, 129, 78);
		contentPane.add(lblNewLabel);
		
		
		Image img5 = new ImageIcon(this.getClass().getResource("/find.png")).getImage();
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(img5));
		lblNewLabel.setBounds(249, 317, 129, 78);
		contentPane.add(lblNewLabel);
		
		JButton btnRemoveBook = new JButton("Remove Book");
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_book RB = new Remove_book(library);
				RB.setVisible(true);
				dispose();
			}
		});
		btnRemoveBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemoveBook.setBorder(UIManager.getBorder("ToolBar.border"));
		btnRemoveBook.setBackground(new Color(221, 160, 221));
		btnRemoveBook.setBounds(495, 205, 183, 31);
		contentPane.add(btnRemoveBook);
		
		JButton btnFindBook = new JButton("Find Book");
		btnFindBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Find_Book FB = new Find_Book(library);
				FB.setVisible(true);
				dispose();
			}
		});
		btnFindBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFindBook.setBorder(UIManager.getBorder("ToolBar.border"));
		btnFindBook.setBackground(new Color(144, 238, 144));
		btnFindBook.setBounds(195, 395, 183, 31);
		contentPane.add(btnFindBook);
		
		JButton btnLibraryOverview = new JButton("Library Overview");
		btnLibraryOverview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Overview OV = new Overview(library);
				OV.setVisible(true);
				dispose();
			}
		});
		btnLibraryOverview.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLibraryOverview.setBorder(UIManager.getBorder("ToolBar.border"));
		btnLibraryOverview.setBackground(new Color(233, 150, 122));
		btnLibraryOverview.setBounds(495, 395, 183, 31);
		contentPane.add(btnLibraryOverview);
		
		JButton btnNewButton = new JButton("Add New Book");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(UIManager.getBorder("ToolBar.border"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook ad = new AddBook(library);
				ad.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setBounds(190, 205, 183, 31);
		contentPane.add(btnNewButton);
		
		JTextComponent textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBorder(UIManager.getBorder("ToolBar.border"));
		((JTextField) textField_5).setColumns(10);
		textField_5.setBackground(new Color(255, 160, 122));
		textField_5.setBounds(495, 305, 183, 121);
		contentPane.add(textField_5);
		
		JTextComponent textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBorder(UIManager.getBorder("ToolBar.border"));
		((JTextField) textField_3).setColumns(10);
		textField_3.setBackground(new Color(216, 191, 216));
		textField_3.setBounds(495, 115, 183, 121);
		contentPane.add(textField_3);
		
		JTextField textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBorder(UIManager.getBorder("ToolBar.border"));
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(152, 251, 152));
		textField_4.setBounds(195, 305, 183, 121);
		contentPane.add(textField_4);
		
		JTextField textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBorder(UIManager.getBorder("ToolBar.border"));
		textField_1.setBackground(new Color(175, 238, 238));
		textField_1.setBounds(190, 115, 183, 121);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JTextField textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBorder(UIManager.getBorder("ToolBar.border"));
		textField_7.setBackground(new Color(255, 255, 255));
		textField_7.setBounds(42, 83, 787, 383);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		
		
        String[] columnNames = {"Position", "Name", "Reference Number"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
   
        int totalBooks = library.getTotalBooks();
        for (int i = 0; i < totalBooks; i++) {
            String position = String.valueOf(i);
            String name = library.getBook(i);
            String referenceNumber = library.getReferenceNumber(i);
            model.addRow(new Object[]{position, name, referenceNumber});
        }


	}
}
