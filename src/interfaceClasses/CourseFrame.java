package interfaceClasses;

import studentSub.*;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
public class CourseFrame extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldCourseName;
	public JTextField textFieldCourseCredit;
	public JTextArea tACourse;
	
	/**
	 * Create the frame.
	 */
	public CourseFrame(AddFrame add) {
		
		setTitle("Course Frame\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Name:");
		lblNewLabel.setBounds(30, 35, 96, 14);
		contentPane.add(lblNewLabel);
		
		textFieldCourseName = new JTextField();
		textFieldCourseName.setBounds(191, 32, 115, 20);
		contentPane.add(textFieldCourseName);
		textFieldCourseName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Course Credit:");
		lblNewLabel_1.setBounds(30, 73, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldCourseCredit = new JTextField();
		textFieldCourseCredit.setBounds(191, 70, 115, 20);
		contentPane.add(textFieldCourseCredit);
		textFieldCourseCredit.setColumns(10);
		
		tACourse = new JTextArea();
		tACourse.setBounds(30, 112, 277, 34);
		contentPane.add(tACourse);
		
		File imageFile1 = new File("image/back.png");
		ImageIcon iconReturn;

		
		    // Load the original image
		    ImageIcon originalIcon = new ImageIcon(imageFile1.getAbsolutePath());
		    
		    // Define the desired width and height
		    int width = 16;  // You can adjust these values
		    int height = 16; // to match your requirements
		    
		    // Resize the image
		    Image originalImage = originalIcon.getImage();
		    Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		    
		    // Create a new ImageIcon with the resized image
		    iconReturn = new ImageIcon(resizedImage);
		
		JButton btnNewButton_1 = new JButton(iconReturn);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(191, 157, 129, 23);
		contentPane.add(btnNewButton_1);
		
		File imageFile2 = new File("image/course.png");
		ImageIcon iconCourse;

	
		    // Load the original image
		    originalIcon = new ImageIcon(imageFile2.getAbsolutePath());
		    
		    // Define the desired width and height
		     width = 16;  // You can adjust these values
		     height = 16; // to match your requirements
		    
		    // Resize the image
		     originalImage = originalIcon.getImage();
		     resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		    
		    // Create a new ImageIcon with the resized image
		    iconCourse = new ImageIcon(resizedImage);  
		
		JButton btnNewButton = new JButton("Add Course",iconCourse);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseName;
				double courseCredit,totalCredit;
				courseName=textFieldCourseName.getText();
				courseCredit=Double.parseDouble(textFieldCourseCredit.getText());
				Course c = new Course(courseName,courseCredit);
				add.coursesToTake.add(c);
				totalCredit=Course.getTotalCredits();
				if(totalCredit<30)
					tACourse.setText("You have "+totalCredit+" credit.You have to add more course!!");
				else {
					tACourse.setText("You have "+totalCredit+" credit.You have enough credit.\nIf you want you can add more courses.");
					btnNewButton_1.setEnabled(true);
				}
			}
		});
		btnNewButton.setBounds(30, 157, 132, 23);
		contentPane.add(btnNewButton);
		
		
		if(Course.getTotalCredits()<30)
			btnNewButton_1.setEnabled(false);
			
	
	}
}
