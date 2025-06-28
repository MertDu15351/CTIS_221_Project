package interfaceClasses;
import java.awt.EventQueue;
import java.awt.Image;

import partners.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import studentSub.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class AddFrame extends JFrame {

	private JPanel contentPane;
	private UniversityFrame uf = new UniversityFrame(this);
	private CourseFrame cf = new CourseFrame(this);
	private GrantFrame gf = new GrantFrame(this);
	private AccomodationFrame af=new AccomodationFrame(this);
	private JTextField textFieldId;
	private JTextField textFieldNameSur;
	private JTextField textFieldCGPA;
	private JTextField textFieldNatId;
	private JTextField textFieldPhone;
	private JTextField textFieldMail;

	Erasmus[]  appliedPartners = new Erasmus[Student.getApplylimit()];
	ArrayList<Course> coursesToTake = new ArrayList<>();
	Grant g=new Grant(false,0,0);
	Accomodation a;
	private JTextField textFieldCurrentSemester;
	//studentın objeleri yapılacak bu kadar
	/**
	 * Create the frame.
	 */
	public AddFrame(ErasmusTracking erasmus) {
		setTitle("Student Info\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("StudentID:");
		lblNewLabel.setBounds(15, 59, 70, 14);
		contentPane.add(lblNewLabel);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(230, 57, 199, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student NameSurname:");
		lblNewLabel_1.setBounds(15, 101, 147, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldNameSur = new JTextField();
		textFieldNameSur.setBounds(230, 99, 199, 20);
		contentPane.add(textFieldNameSur);
		textFieldNameSur.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Student CGPA:");
		lblNewLabel_2.setBounds(15, 140, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldCGPA = new JTextField();
		textFieldCGPA.setBounds(230, 138, 199, 20);
		contentPane.add(textFieldCGPA);
		textFieldCGPA.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Student ENG101 Grade:");
		lblNewLabel_3.setBounds(15, 179, 138, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBoxENG101 = new JComboBox();
		comboBoxENG101.setModel(new DefaultComboBoxModel(new String[] {"", "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F", "W"}));
		comboBoxENG101.setBounds(230, 175, 199, 22);
		contentPane.add(comboBoxENG101);
		
		JLabel lblNewLabel_4 = new JLabel("Student ENG102 Grade:");
		lblNewLabel_4.setBounds(15, 215, 144, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBoxENG102 = new JComboBox();
		comboBoxENG102.setModel(new DefaultComboBoxModel(new String[] {"", "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F", "W"}));
		comboBoxENG102.setBounds(230, 211, 199, 22);
		contentPane.add(comboBoxENG102);
		
		JLabel lblNewLabel_5 = new JLabel("Student National ID:");
		lblNewLabel_5.setBounds(473, 140, 127, 14);
		contentPane.add(lblNewLabel_5);
		
		textFieldNatId = new JTextField();
		textFieldNatId.setBounds(621, 138, 146, 20);
		contentPane.add(textFieldNatId);
		textFieldNatId.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Semester To Go:");
		lblNewLabel_6.setBounds(473, 179, 99, 14);
		contentPane.add(lblNewLabel_6);
		
		JComboBox comboBoxSemester = new JComboBox();
		comboBoxSemester.setModel(new DefaultComboBoxModel(new String[] {"", "Spring", "Fall"}));
		comboBoxSemester.setBounds(621, 175, 146, 22);
		contentPane.add(comboBoxSemester);
		
		JLabel lblNewLabel_7 = new JLabel("University To Go:");
		lblNewLabel_7.setBounds(473, 215, 127, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Student Phone:");
		lblNewLabel_8.setBounds(473, 59, 99, 14);
		contentPane.add(lblNewLabel_8);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(621, 57, 146, 20);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Student Mail Address:");
		lblNewLabel_9.setBounds(473, 101, 138, 14);
		contentPane.add(lblNewLabel_9);
		
		textFieldMail = new JTextField();
		textFieldMail.setBounds(621, 99, 146, 20);
		contentPane.add(textFieldMail);
		textFieldMail.setColumns(10);
		
		JLabel lblNewLabelWarning = new JLabel("");
		lblNewLabelWarning.setBounds(230, 333, 342, 13);
		contentPane.add(lblNewLabelWarning);
		
		textFieldCurrentSemester = new JTextField();
		textFieldCurrentSemester.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER) {
					String id,nameSur,eng101,eng102,phone,mail,semester,nationalID,university,accomodation;
					double cgpa,grant;
					if(textFieldId.getText().isBlank()||textFieldNameSur.getText().isBlank()||textFieldCGPA.getText().isBlank()||
							textFieldPhone.getText().isBlank()||textFieldMail.getText().isBlank()||textFieldNatId.getText().isBlank()
							||textFieldCurrentSemester.getText().isBlank()||comboBoxENG101.getSelectedIndex()==0||
							comboBoxENG102.getSelectedIndex()==0||comboBoxSemester.getSelectedIndex()==0||coursesToTake==null
							||a==null ||appliedPartners==null) {
						lblNewLabelWarning.setText("Please give all informations, do not leave any blank field!");
					}
					else {
						id=textFieldId.getText();
						nameSur=textFieldNameSur.getText();
						cgpa=Double.parseDouble(textFieldCGPA.getText());
						eng101=(String) comboBoxENG101.getSelectedItem();
						eng102= (String) comboBoxENG102.getSelectedItem();
						phone=textFieldPhone.getText();
						mail=textFieldMail.getText();
						nationalID=textFieldNatId.getText();
						semester=(String) comboBoxSemester.getSelectedItem();
						int current=Integer.parseInt(textFieldCurrentSemester.getText()); 
						Student stu = new Student(id,nameSur,cgpa,eng101,eng102,semester,nationalID,current,phone,mail,coursesToTake,g,a,appliedPartners);
						stu.calculateErasmusScores();
						if(StudentSys.addStudent(stu)) {
							if(StudentSys.getStudentApplied()>1) {
								erasmus.btnSort.setEnabled(true);
								erasmus.btnSearch.setEnabled(true);
							}
							if(StudentSys.getStudentApplied()>=1)
								erasmus.btnRemove.setEnabled(true);
							lblNewLabelWarning.setText("Student added succesfully!");
						}
						else {
							lblNewLabelWarning.setText("Student with same email is already exists in System!");							
						}
					}
				}
			}
		});
		textFieldCurrentSemester.setBounds(230, 291, 199, 19);
		contentPane.add(textFieldCurrentSemester);
		textFieldCurrentSemester.setColumns(10);
		
		File imageFile2 = new File("image/user-plus-solid.png");
		ImageIcon iconAdd;

	
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
		    
		 
		JButton btnNewButton = new JButton("Add Student",iconAdd);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,nameSur,eng101,eng102,phone,mail,semester,nationalID,university,accomodation;
				double cgpa,grant;
				if(textFieldId.getText().isBlank()||textFieldNameSur.getText().isBlank()||textFieldCGPA.getText().isBlank()||
						textFieldPhone.getText().isBlank()||textFieldMail.getText().isBlank()||textFieldNatId.getText().isBlank()
						||textFieldCurrentSemester.getText().isBlank()||comboBoxENG101.getSelectedIndex()==0||
						comboBoxENG102.getSelectedIndex()==0||comboBoxSemester.getSelectedIndex()==0||coursesToTake==null
						||a==null ||appliedPartners==null) {
					lblNewLabelWarning.setText("Please give all informations, do not leave any blank field!");
				}
				else {
					id=textFieldId.getText();
					nameSur=textFieldNameSur.getText();
					cgpa=Double.parseDouble(textFieldCGPA.getText());
					eng101=(String) comboBoxENG101.getSelectedItem();
					eng102= (String) comboBoxENG102.getSelectedItem();
					phone=textFieldPhone.getText();
					mail=textFieldMail.getText();
					nationalID=textFieldNatId.getText();
					semester=(String) comboBoxSemester.getSelectedItem();
					int current=Integer.parseInt(textFieldCurrentSemester.getText()); 
					Student stu = new Student(id,nameSur,cgpa,eng101,eng102,semester,nationalID,current,phone,mail,coursesToTake,g,a,appliedPartners);
					stu.calculateErasmusScores();
					if(StudentSys.addStudent(stu)) {
						if(StudentSys.getEligibleStudents()>1)
							erasmus.btnSort.setEnabled(true);
						if(StudentSys.getStudentApplied()>1) {
							erasmus.btnSearch.setEnabled(true);
						}
						if(StudentSys.getStudentApplied()>=1)
							erasmus.btnRemove.setEnabled(true);
						lblNewLabelWarning.setText("Student added succesfully!");
					}
					else {
						lblNewLabelWarning.setText("Student with same email is already exists in System!");							
					}
				}
			}
		});
		btnNewButton.setBounds(159, 367, 127, 23);
		contentPane.add(btnNewButton);
		File imageFile6 = new File("image/home.png");
		ImageIcon iconHome;

	
		    // Load the original image
		     originalIcon = new ImageIcon(imageFile6.getAbsolutePath());
		    
		    // Define the desired width and height
		     width = 16;  // You can adjust these values
		     height = 16; // to match your requirements
		    
		    // Resize the image
		     originalImage = originalIcon.getImage();
		     resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		    
		    // Create a new ImageIcon with the resized image
		    iconHome = new ImageIcon(resizedImage);
		    
		
		JButton btnNewButton_1 = new JButton(iconHome);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				erasmus.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(518, 367, 104, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("Accomodation:");
		lblNewLabel_10.setBounds(15, 258, 90, 14);
		contentPane.add(lblNewLabel_10);
		
	
		
		JLabel lblNewLabel_11 = new JLabel("Grant:");
		lblNewLabel_11.setBounds(473, 293, 61, 14);
		contentPane.add(lblNewLabel_11);
		File imageFile1 = new File("image/eraser.png");
		ImageIcon iconEraser;

		
		    // Load the original image
		     originalIcon = new ImageIcon(imageFile1.getAbsolutePath());
		    
		    // Define the desired width and height
		    width = 16;  // You can adjust these values
		    height = 16; // to match your requirements
		    
		    // Resize the image
		    originalImage = originalIcon.getImage();
		    resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		    
		    // Create a new ImageIcon with the resized image
		    iconEraser = new ImageIcon(resizedImage);
		    
		
		JButton btnNewButton_2 = new JButton("Clean",iconEraser);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldId.setText(" ");
				textFieldNameSur.setText(" ");
				textFieldCGPA.setText(" ");
				textFieldNatId.setText(" ");
				textFieldPhone.setText(" ");
				textFieldMail.setText(" ");
				comboBoxENG101.setSelectedIndex(0);
				comboBoxENG102.setSelectedIndex(0);
				comboBoxSemester.setSelectedIndex(0);
				g=new Grant(false,0,0);
				coursesToTake=new ArrayList<>();//course sıfırlamaya bak
				a=null;//to reset courses, accomodation and grant info
				//dispose kullan
				gf.textFieldGrantAmount.setText(" ");
				gf.textFieldTransportationHelp.setText(" ");
				af.textFieldPlace.setText(" ");
				af.textFieldRent.setText(" ");
				cf.textFieldCourseCredit.setText(" ");
				cf.textFieldCourseName.setText(" ");
				cf.tACourse.setText(" ");
				uf.comboUni1.setSelectedIndex(0);
				uf.comboUni2.setSelectedIndex(0);
				uf.comboUni3.setSelectedIndex(0);
				uf.comboUni4.setSelectedIndex(0);
				uf.comboUni5.setSelectedIndex(0);
			}
		});
		btnNewButton_2.setBounds(353, 367, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Choose University");
		btnNewButton_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				try {
					StudentSys.initializePartners();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				uf.fillComboBox1();
				uf.fillComboBox2();
				uf.fillComboBox3();
				uf.fillComboBox4();
				uf.fillComboBox5();
				uf.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_3.setBounds(621, 211, 146, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_12 = new JLabel("Courses:");
		lblNewLabel_12.setBounds(473, 258, 70, 14);
		contentPane.add(lblNewLabel_12);
		
		JButton btnNewButton_4 = new JButton("Choose Courses");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(620, 254, 147, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_13 = new JLabel("Current Semester of Student:");
		lblNewLabel_13.setBounds(15, 297, 205, 13);
		contentPane.add(lblNewLabel_13);
		
		JButton btnNewButton_5 = new JButton("Enter Grant Info");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gf.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_5.setBounds(621, 289, 146, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton(" Enter Accomodation Info ");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				af.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_6.setBounds(230, 254, 199, 23);
		contentPane.add(btnNewButton_6);
		
		
	}
}
