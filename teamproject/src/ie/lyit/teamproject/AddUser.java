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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddUser extends JInternalFrame {

	String username;
	String password;
	String confirm;
	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	private DBConnectionClass dbc;

	public JTextField jtxtUser;
	public JPasswordField jtxtConfirm;
	public JPasswordField jtxtPass;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;

	public AddUser() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				jtxtUser.requestFocus();
			}
		});
		dbc = new DBConnectionClass();
		setTitle("Add User");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel textPanel = new JPanel();
		textPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "User Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(textPanel, BorderLayout.CENTER);
		GridBagLayout gbl_textPanel = new GridBagLayout();
		gbl_textPanel.columnWidths = new int[] { 57, 109, 0 };
		gbl_textPanel.rowHeights = new int[] { 20, 20, 20, 0 };
		gbl_textPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_textPanel.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		textPanel.setLayout(gbl_textPanel);

		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		textPanel.add(lblUsername, gbc_lblUsername);

		jtxtUser = new JTextField();
		jtxtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtxtUser.selectAll();
			}
		});
		GridBagConstraints gbc_jtxtUser = new GridBagConstraints();
		gbc_jtxtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtUser.anchor = GridBagConstraints.NORTH;
		gbc_jtxtUser.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtUser.gridx = 1;
		gbc_jtxtUser.gridy = 0;
		textPanel.add(jtxtUser, gbc_jtxtUser);
		jtxtUser.setColumns(10);

		lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		textPanel.add(lblPassword, gbc_lblPassword);

		jtxtPass = new JPasswordField();
		jtxtPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtxtPass.selectAll();
			}
		});
		GridBagConstraints gbc_jtxtPass = new GridBagConstraints();
		gbc_jtxtPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtPass.anchor = GridBagConstraints.NORTH;
		gbc_jtxtPass.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtPass.gridx = 1;
		gbc_jtxtPass.gridy = 1;
		textPanel.add(jtxtPass, gbc_jtxtPass);
		jtxtPass.setColumns(10);

		lblConfirmPassword = new JLabel("Confirm Password:");
		GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
		gbc_lblConfirmPassword.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblConfirmPassword.gridx = 0;
		gbc_lblConfirmPassword.gridy = 2;
		textPanel.add(lblConfirmPassword, gbc_lblConfirmPassword);

		jtxtConfirm = new JPasswordField();
		jtxtConfirm.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtxtConfirm.selectAll();
			}
		});
		GridBagConstraints gbc_jtxtConfirm = new GridBagConstraints();
		gbc_jtxtConfirm.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtConfirm.anchor = GridBagConstraints.NORTH;
		gbc_jtxtConfirm.gridx = 1;
		gbc_jtxtConfirm.gridy = 2;
		textPanel.add(jtxtConfirm, gbc_jtxtConfirm);
		jtxtConfirm.setColumns(10);

		JPanel options = new JPanel();
		getContentPane().add(options, BorderLayout.SOUTH);
		options.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Options",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		options.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnConfirm = new JButton("Add");
		options.add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		options.add(btnCancel);

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				jtxtUser.setText("");
				jtxtPass.setText("");
				jtxtConfirm.setText("");
			}
		});

		//btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = jtxtUser.getText();
				password = new String(jtxtPass.getPassword());
				confirm = new String(jtxtConfirm.getPassword());

				if (dbc.checkUserifUserExists(username) >= 1) {
					JOptionPane.showMessageDialog(new JPanel(),
							"User already exists", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (password.equals(confirm) && (!password.equals(""))) {
					dbc.createUser(username, password);
					jtxtUser.setText("");
					jtxtPass.setText("");
					jtxtConfirm.setText("");
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(new JPanel(),
							"Password must equals confirm password", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
				// else
				// {
				// JOptionPane.showMessageDialog(new JPanel(),
				// "Password must equals confirm password", "Info",
				// JOptionPane.INFORMATION_MESSAGE);
				// }

			}
		});

		int ownX = 455;
		int ownY = 330;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));
		this.setSize(293, 205);
		this.setLocation(xPos, yPos);

		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
		getRootPane().setDefaultButton(btnConfirm);

	}
}
