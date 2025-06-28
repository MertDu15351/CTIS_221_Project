package interfaceClasses;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import studentSub.Accomodation;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccomodationFrame extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldPlace;
	public JTextField textFieldRent;

	/**
	 * Create the frame.
	 */
	public AccomodationFrame(AddFrame add) {
		setTitle("Accomodation Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Place To Stay:");
		lblNewLabel.setBounds(53, 30, 82, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rent:");
		lblNewLabel_1.setBounds(53, 53, 82, 13);
		contentPane.add(lblNewLabel_1);
		
		textFieldPlace = new JTextField();
		textFieldPlace.setBounds(145, 27, 96, 19);
		contentPane.add(textFieldPlace);
		textFieldPlace.setColumns(10);
		
		textFieldRent = new JTextField();
		textFieldRent.setBounds(145, 50, 96, 19);
		contentPane.add(textFieldRent);
		textFieldRent.setColumns(10);
		
		JButton btnNewButton = new JButton("Set Accomodation Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add.a=new Accomodation(textFieldPlace.getText(),Double.parseDouble(textFieldRent.getText()));
				add.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(53, 91, 188, 21);
		contentPane.add(btnNewButton);
	}

}
