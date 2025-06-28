package interfaceClasses;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import studentSub.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GrantFrame extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldGrantAmount;
	public JTextField textFieldTransportationHelp;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GrantFrame(AddFrame add) {
		setTitle("Grant Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 309, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Grant Amount:");
		lblNewLabel.setBounds(72, 31, 104, 13);
		contentPane.add(lblNewLabel);
		
		textFieldGrantAmount = new JTextField();
		textFieldGrantAmount.setBounds(186, 28, 96, 19);
		contentPane.add(textFieldGrantAmount);
		textFieldGrantAmount.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Transportation Help Amount");
		lblNewLabel_1.setBounds(10, 54, 166, 13);
		contentPane.add(lblNewLabel_1);
		
		textFieldTransportationHelp = new JTextField();
		textFieldTransportationHelp.setBounds(186, 51, 96, 19);
		contentPane.add(textFieldTransportationHelp);
		textFieldTransportationHelp.setColumns(10);
		
		JButton btnSetGrant = new JButton("Set Grant");
		btnSetGrant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add.g=new Grant(true,Double.parseDouble(textFieldGrantAmount.getText()),Double.parseDouble(textFieldTransportationHelp.getText()));
				add.setVisible(true);
				dispose();
			}
		});
		btnSetGrant.setBounds(95, 97, 111, 21);
		contentPane.add(btnSetGrant);
	}
}
