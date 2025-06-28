package interfaceClasses;

import studentSub.*;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErasmusTracking extends JFrame {

	private JPanel contentPane;
	private AddFrame af = new AddFrame(this);
	private JTextField textField;
	static JButton  btnSort;
	static JButton btnSearch;
	static JButton btnRemove;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErasmusTracking frame = new ErasmusTracking();
					btnSort.setEnabled(false);
					btnSearch.setEnabled(false);
					btnRemove.setEnabled(false);
					
						
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
	public ErasmusTracking() {
		setTitle("Erasmus Tracking\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 251, 547, 176);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(StudentSys.getStudentApplied()!=0) {
					textArea.setText(StudentSys.displayAll());
				}
				else
					textArea.setText("There are NO students to apply Erasmus!");
			}
		});
		scrollPane.setViewportView(textArea);
		
		File imageFile1 = new File("image/eye-solid.png");
		ImageIcon iconDisp;

		if (imageFile1.exists()) {
		    // Load the original image
		    ImageIcon originalIcon = new ImageIcon(imageFile1.getAbsolutePath());
		    
		    // Define the desired width and height
		    int width = 16;  // You can adjust these values
		    int height = 16; // to match your requirements
		    
		    // Resize the image
		    Image originalImage = originalIcon.getImage();
		    Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		    
		    // Create a new ImageIcon with the resized image
		    iconDisp = new ImageIcon(resizedImage);
		    
		} else {
		    System.out.println("Warning: Icon file not found at: " + imageFile1.getAbsolutePath());
		    // Create empty icon as fallback
		    iconDisp = new ImageIcon();
		}
		JButton btnDisplay = new JButton("Display", iconDisp);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StudentSys.getStudentApplied()!=0) {
					textArea.setText(StudentSys.displayAll());
				}
				else
					textArea.setText("There are NO students to apply Erasmus!");
			}
		});
		btnDisplay.setBounds(65, 151, 96, 23);
		contentPane.add(btnDisplay);
		File imageFile2 = new File("image/user-plus-solid.png");
		ImageIcon iconAdd;

		if (imageFile2.exists()) {
		    // Load the original image
		    ImageIcon originalIcon = new ImageIcon(imageFile2.getAbsolutePath());
		    
		    // Define the desired width and height
		    int width = 16;  // You can adjust these values
		    int height = 16; // to match your requirements
		    
		    // Resize the image
		    Image originalImage = originalIcon.getImage();
		    Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		    
		    // Create a new ImageIcon with the resized image
		    iconAdd = new ImageIcon(resizedImage);
		    
		} else {
		    System.out.println("Warning: Icon file not found at: " + imageFile2.getAbsolutePath());
		    // Create empty icon as fallback
		    iconAdd = new ImageIcon();
		}
		JButton btnAdd = new JButton("AddStudent",iconAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				af.setVisible(true);
				setVisible(false);
			}
		});
		btnAdd.setBounds(187, 151, 124, 23);
		contentPane.add(btnAdd);
		
		
		File imageFile3 = new File("image/magnifying-glass-solid.png");
		ImageIcon iconSearch;

		if (imageFile3.exists()) {
		    // Load the original image
		    ImageIcon originalIcon = new ImageIcon(imageFile3.getAbsolutePath());
		    
		    // Define the desired width and height
		    int width = 16;  // You can adjust these values
		    int height = 16; // to match your requirements
		    
		    // Resize the image
		    Image originalImage = originalIcon.getImage();
		    Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		    
		    // Create a new ImageIcon with the resized image
		    iconSearch = new ImageIcon(resizedImage);
		    
		} else {
		    System.out.println("Warning: Icon file not found at: " + imageFile3.getAbsolutePath());
		    // Create empty icon as fallback
		    iconSearch = new ImageIcon();
		}
		btnSearch = new JButton("Search Student",iconSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student search;
				String id=textField.getText();
				search=StudentSys.searchStu(id);
				if(search!=null)
					textArea.setText(search.display());
				else
					textArea.setText("The student can not be found!");
			}
		});
		btnSearch.setBounds(334, 151, 158, 23);
		contentPane.add(btnSearch);
		File imageFile4 = new File("image/user-minus-solid.png");
		ImageIcon iconRemove;

		if (imageFile4.exists()) {
		    // Load the original image
		    ImageIcon originalIcon = new ImageIcon(imageFile4.getAbsolutePath());
		    
		    // Define the desired width and height
		    int width = 16;  // You can adjust these values
		    int height = 16; // to match your requirements
		    
		    // Resize the image
		    Image originalImage = originalIcon.getImage();
		    Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		    
		    // Create a new ImageIcon with the resized image
		    iconRemove = new ImageIcon(resizedImage);
		    
		} else {
		    System.out.println("Warning: Icon file not found at: " + imageFile4.getAbsolutePath());
		    // Create empty icon as fallback
		    iconRemove = new ImageIcon();
		}
		btnRemove = new JButton("Remove Student",iconRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				if(StudentSys.deleteStu(id))
					textArea.setText("The Student is deleted from the system!!");
				else
					textArea.setText("There is no such a student!!");
				
				if(StudentSys.getStudentApplied()<2) {
					btnSort.setEnabled(false);
					btnSearch.setEnabled(false);
				}
				if(StudentSys.getStudentApplied()<1) {
					btnRemove.setEnabled(false);
					
				}
			}
		});
		btnRemove.setBounds(502, 151, 150, 23);
		contentPane.add(btnRemove);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(334, 196, 318, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("StudentID:");
		lblNewLabel.setBounds(14, 11, 68, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 8, 129, 20);
		panel.add(textField);
		textField.setColumns(10);
		File imageFile5 = new File("image/sort.png");
		ImageIcon iconSort;

		if (imageFile5.exists()) {
		    // Load the original image
		    ImageIcon originalIcon = new ImageIcon(imageFile5.getAbsolutePath());
		    
		    // Define the desired width and height
		    int width = 16;  // You can adjust these values
		    int height = 16; // to match your requirements
		    
		    // Resize the image
		    Image originalImage = originalIcon.getImage();
		    Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		    
		    // Create a new ImageIcon with the resized image
		    iconSort = new ImageIcon(resizedImage);
		    
		} else {
		    System.out.println("Warning: Icon file not found at: " + imageFile5.getAbsolutePath());
		    // Create empty icon as fallback
		    iconSort = new ImageIcon();
		}
		btnSort = new JButton("Sort Students",iconSort);
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Students are sorted!\n"+StudentSys.sortStu());
			}
		});
		btnSort.setBounds(65, 204, 246, 23);
		contentPane.add(btnSort);
		
	
		
		
		
		JLabel lblNewLabel_1 = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/erasmus.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(181, 11, 351, 129);
		contentPane.add(lblNewLabel_1);
	}
}
