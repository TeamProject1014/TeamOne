package ie.lyit.teamproject;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JButton;

public class AddJob extends JInternalFrame {
	
	private DBConnectionClass dbc = new DBConnectionClass();
	private JTextField textField;
	private ButtonGroup status;	
	
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public AddJob()
	{
		setTitle("Add Job");
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Job Detail", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 425, 210);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblJobDescription = new JLabel("Job Description:");
		lblJobDescription.setBounds(26, 76, 77, 14);
		panel.add(lblJobDescription);
		
		JLabel lblArchitect = new JLabel("Architect:");
		lblArchitect.setBounds(231, 15, 61, 14);
		panel.add(lblArchitect);
		
		JLabel lblClientName = new JLabel("Client Name:");
		lblClientName.setBounds(26, 15, 61, 14);
		panel.add(lblClientName);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(302, 11, 103, 22);
		panel.add(comboBox_1);
		
		JLabel lblBuilder = new JLabel("Builder:");
		lblBuilder.setBounds(26, 40, 61, 14);
		panel.add(lblBuilder);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(118, 36, 103, 22);
		panel.add(comboBox_2);
		
		JLabel lblEngineer = new JLabel("Engineer:");
		lblEngineer.setBounds(231, 40, 61, 14);
		panel.add(lblEngineer);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(302, 36, 103, 22);
		panel.add(comboBox_3);
		
		JTextArea jtaDescription = new JTextArea();
		jtaDescription.setBounds(117, 71, 288, 66);
		panel.add(jtaDescription);
		jtaDescription.setLineWrap(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Job Status", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(26, 148, 379, 50);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Declined");
		rdbtnNewRadioButton.setBounds(250, 20, 109, 23);
		panel_2.add(rdbtnNewRadioButton);
		//status.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnPending = new JRadioButton("Pending");
		rdbtnPending.setBounds(28, 20, 109, 23);
		panel_2.add(rdbtnPending);
		//status.add(rdbtnPending);
		
		JRadioButton rdbtnApproved = new JRadioButton("Approved");
		rdbtnApproved.setBounds(139, 20, 109, 23);
		panel_2.add(rdbtnApproved);
		//status.add(rdbtnApproved);
		
		textField = new JTextField();
		textField.setBounds(118, 12, 103, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Options", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(10, 235, 426, 51);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(78, 17, 89, 23);
		panel_1.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(248, 17, 89, 23);
		panel_1.add(btnCancel);	
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValues();
				setVisible(false);
			}
		});
		
		int ownX = 455;
		int ownY = 330;
		
		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int)((screenX / 2) - (ownX / 2)) ;
		int yPos = (int)((screenY / 2) - (ownY / 2));
		
		this.setSize(455, 330);
		this.setLocation(xPos, yPos);
		
		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
		
	}
	
	/**
	 * Method to reset all values when screen closed (hidden)
	 */
	public static void resetValues() {
		// Implement me!!
	}
}
