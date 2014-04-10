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
import java.lang.reflect.Array;
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
import javax.swing.JPasswordField;

public class AddUser extends JInternalFrame {
	
	String username;
	String password;
	String confirm;
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private DBConnectionClass dbc;
	private JPasswordField jtxtConfirm;
	private JPasswordField jtxtPass;
	private JTextField jtxtUser;
	public AddUser()
	{
		dbc = new DBConnectionClass();
		getContentPane().setLayout(null);
		setTitle("Add User");
	
		
		JButton btnConfirm = new JButton("Add");
		btnConfirm.setBounds(33, 123, 67, 23);
		getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(138, 123, 83, 23);
		getContentPane().add(btnCancel);
		
		jtxtConfirm = new JPasswordField();
		jtxtConfirm.setBounds(147, 74, 93, 20);
		getContentPane().add(jtxtConfirm);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmPassword.setBounds(10, 77, 127, 14);
		getContentPane().add(lblConfirmPassword);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(48, 46, 89, 14);
		getContentPane().add(lblPassword);
		
		jtxtPass = new JPasswordField();
		jtxtPass.setBounds(147, 43, 93, 20);
		getContentPane().add(jtxtPass);
		
				
				JLabel lblUsername = new JLabel("Username:");
				lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
				lblUsername.setBounds(33, 16, 104, 12);
				getContentPane().add(lblUsername);
				
				jtxtUser = new JTextField();
				jtxtUser.setBounds(147, 12, 93, 20);
				getContentPane().add(jtxtUser);
				jtxtUser.setColumns(10);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = jtxtUser.getText();
				password = new String(jtxtPass.getPassword());
				confirm = new String(jtxtConfirm.getPassword());
				
				if(dbc.checkUser(username) >= 1)
				{
					JOptionPane.showMessageDialog(new JPanel(), "User already exists", "Info",
					        JOptionPane.INFORMATION_MESSAGE);
				}
				else if(password.equals(confirm))
				{
					dbc.createUser(username, password);
					jtxtUser.setText("");
					jtxtPass.setText("");
					jtxtConfirm.setText("");
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(new JPanel(), "Password must equals confirm password", "Info",
					        JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		//spawn
		int ownX = 455;
		int ownY = 330;
		
		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int)((screenX / 2) - (ownX / 2)) ;
		int yPos = (int)((screenY / 2) - (ownY / 2));
		this.setSize(293, 205);
		this.setLocation(xPos, yPos);
		
		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
		
	}
}
