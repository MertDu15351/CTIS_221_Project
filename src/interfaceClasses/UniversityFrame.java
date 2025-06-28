package interfaceClasses;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import studentSub.StudentSys;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class UniversityFrame extends JFrame {

	private JPanel contentPane;
	public JComboBox comboUni1;
	public JComboBox comboUni2;
	public JComboBox comboUni3;
	public JComboBox comboUni4;
	public JComboBox comboUni5;
	JButton btnNewButton;
	
	/**
	 * Create the frame.
	 */
	public void fillComboBox1() {
		comboUni1.setModel(new DefaultComboBoxModel(StudentSys.getPartner()));
	}
	public void fillComboBox2() {
		comboUni2.setModel(new DefaultComboBoxModel(StudentSys.getPartner()));
	}
	public void fillComboBox3() {
		comboUni3.setModel(new DefaultComboBoxModel(StudentSys.getPartner()));
	}
	public void fillComboBox4() {
		comboUni4.setModel(new DefaultComboBoxModel(StudentSys.getPartner()));
	}
	public void fillComboBox5() {
		comboUni5.setModel(new DefaultComboBoxModel(StudentSys.getPartner()));
	}
	
	public UniversityFrame(AddFrame add) {
		setTitle("University Frame\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblwarning = new JLabel("");
		lblwarning.setBounds(134, 294, 266, 13);
		contentPane.add(lblwarning);
		
		File imageFile1 = new File("image/back.png");
		ImageIcon iconReturn;

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
		    iconReturn = new ImageIcon(resizedImage);
		    
		} else {
		    System.out.println("Warning: Icon file not found at: " + imageFile1.getAbsolutePath());
		    // Create empty icon as fallback
		    iconReturn = new ImageIcon();
		}
		btnNewButton = new JButton(iconReturn);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				
				
				add.appliedPartners[0]=StudentSys.getPartnersList().get(comboUni1.getSelectedIndex());
				add.appliedPartners[1]=StudentSys.getPartnersList().get(comboUni2.getSelectedIndex());
				add.appliedPartners[2]=StudentSys.getPartnersList().get(comboUni3.getSelectedIndex());
				add.appliedPartners[3]=StudentSys.getPartnersList().get(comboUni4.getSelectedIndex());
				add.appliedPartners[4]=StudentSys.getPartnersList().get(comboUni5.getSelectedIndex());
				
				
				add.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(382, 326, 89, 23);
		contentPane.add(btnNewButton);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboUni1 = new JComboBox();
		comboUni1.setBounds(134, 33, 266, 22);
		contentPane.add(comboUni1);
		
		
		
		JLabel lblNewLabel = new JLabel("1.University");
		lblNewLabel.setBounds(39, 37, 85, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2.University");
		lblNewLabel_1.setBounds(39, 96, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("3.University");
		lblNewLabel_2.setBounds(39, 149, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("4.University");
		lblNewLabel_3.setBounds(39, 210, 69, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("5.University");
		lblNewLabel_4.setBounds(39, 266, 69, 14);
		contentPane.add(lblNewLabel_4);
		
		comboUni2 = new JComboBox();
		comboUni2.setBounds(134, 92, 266, 22);
		contentPane.add(comboUni2);
		
		comboUni3 = new JComboBox();
		comboUni3.setBounds(134, 145, 266, 22);
		contentPane.add(comboUni3);
		
		comboUni4 = new JComboBox();
		comboUni4.setBounds(134, 206, 266, 22);
		contentPane.add(comboUni4);
		
		comboUni5 = new JComboBox();
		comboUni5.setBounds(134, 262, 266, 22);
		contentPane.add(comboUni5);
		
	}
}
