package ie.lyit.teamproject;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AddUser extends JInternalFrame {
	
	String username;
	String password;
	String confirmPass;
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JTextField jtxtUser;
	private JTextField jtxtPass;
	private DBConnectionClass dbc;
	private JTextField jtxtConfirm;
	public AddUser()
	{
		dbc = new DBConnectionClass();
		getContentPane().setLayout(null);
		
		JPanel textPanel = new JPanel();
		textPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "User Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textPanel.setBounds(10, 11, 388, 106);
		getContentPane().add(textPanel);
		GridBagLayout gbl_textPanel = new GridBagLayout();
		gbl_textPanel.columnWidths = new int[]{57, 109, 86, 0};
		gbl_textPanel.rowHeights = new int[]{20, 20, 20, 0};
		gbl_textPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_textPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		textPanel.setLayout(gbl_textPanel);
		
				
				JLabel lblUsername = new JLabel("Username:");
				GridBagConstraints gbc_lblUsername = new GridBagConstraints();
				gbc_lblUsername.anchor = GridBagConstraints.EAST;
				gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
				gbc_lblUsername.gridx = 1;
				gbc_lblUsername.gridy = 0;
				textPanel.add(lblUsername, gbc_lblUsername);
		
		jtxtUser = new JTextField();
		GridBagConstraints gbc_jtxtUser = new GridBagConstraints();
		gbc_jtxtUser.anchor = GridBagConstraints.NORTHWEST;
		gbc_jtxtUser.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtUser.gridx = 2;
		gbc_jtxtUser.gridy = 0;
		textPanel.add(jtxtUser, gbc_jtxtUser);
		jtxtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 1;
		textPanel.add(lblPassword, gbc_lblPassword);
		
		jtxtPass = new JTextField();
		GridBagConstraints gbc_jtxtPass = new GridBagConstraints();
		gbc_jtxtPass.anchor = GridBagConstraints.NORTHWEST;
		gbc_jtxtPass.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtPass.gridx = 2;
		gbc_jtxtPass.gridy = 1;
		textPanel.add(jtxtPass, gbc_jtxtPass);
		jtxtPass.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
		gbc_lblConfirmPassword.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblConfirmPassword.gridx = 1;
		gbc_lblConfirmPassword.gridy = 2;
		textPanel.add(lblConfirmPassword, gbc_lblConfirmPassword);
		
		jtxtConfirm = new JTextField();
		GridBagConstraints gbc_jtxtConfirm = new GridBagConstraints();
		gbc_jtxtConfirm.anchor = GridBagConstraints.NORTHWEST;
		gbc_jtxtConfirm.gridx = 2;
		gbc_jtxtConfirm.gridy = 2;
		textPanel.add(jtxtConfirm, gbc_jtxtConfirm);
		jtxtConfirm.setColumns(10);
		
		JPanel options = new JPanel();
		options.setBounds(10, 128, 388, 60);
		getContentPane().add(options);
		options.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Options",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = jtxtUser.getText();
				password = jtxtPass.getText();
				String confirm = jtxtConfirm.getText();
				
				if(password.equals(confirm))
				{
					dbc.createUser(username, password);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(new JPanel(), "Password must equals confirm password", "Info",
					        JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		options.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		options.add(btnCancel);
		
		//spawn
		int ownX = 455;
		int ownY = 330;
		
		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int)((screenX / 2) - (ownX / 2)) ;
		int yPos = (int)((screenY / 2) - (ownY / 2));
		this.setSize(417, 230);
		this.setLocation(xPos, yPos);
		
		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
	}
}
