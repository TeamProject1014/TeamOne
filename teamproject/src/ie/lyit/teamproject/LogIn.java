package ie.lyit.teamproject;

//import java.awt.CardLayout;
//import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
//import java.io.File;
//import java.io.IOException;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * LW - We should look at the following link to have some element of security on
 * this login screen
 * http://stackoverflow.com/questions/2860943/suggestions-for-library
 * -to-hash-passwords-in-java It's not critical for our application, but some
 * understanding of it will be useful in the future,
 */

public class LogIn extends JFrame {
	DBConnectionClass dbConn = new DBConnectionClass();

	private JPasswordField txtPassword;
	private JTextField jtxtUser;
	private JPasswordField passwordtxt;
	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();

	public LogIn() {

		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "User Details", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		panel.add(lblUsername, gbc_lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);

		jtxtUser = new JTextField();
		jtxtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				jtxtUser.selectAll();
			}
		});
		GridBagConstraints gbc_jtxtUser = new GridBagConstraints();
		gbc_jtxtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtUser.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtUser.gridx = 1;
		gbc_jtxtUser.gridy = 0;
		panel.add(jtxtUser, gbc_jtxtUser);
		jtxtUser.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		panel.add(lblPassword, gbc_lblPassword);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);

		passwordtxt = new JPasswordField();
		passwordtxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordtxt.selectAll();
			}
		});
		GridBagConstraints gbc_passwordtxt = new GridBagConstraints();
		gbc_passwordtxt.fill = GridBagConstraints.BOTH;
		gbc_passwordtxt.gridx = 1;
		gbc_passwordtxt.gridy = 1;
		panel.add(passwordtxt, gbc_passwordtxt);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Options",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnLogIn = new JButton("Log In");
		panel_1.add(btnLogIn);

		JButton btnCancel = new JButton("Cancel");
		panel_1.add(btnCancel);

		JLabel jlblLogo = new JLabel();
		jlblLogo.setIcon(new ImageIcon("Images/logo.jpg"));
		getContentPane().add(jlblLogo, BorderLayout.NORTH);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logInUser();
			}
		});
		int ownX = 275;
		int ownY = 350;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));
		this.setSize(ownX, ownY);
		this.setLocation(xPos, yPos);

		this.setTitle("LYIT Build Calc");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setIconImage(new ImageIcon("Images/measure.png").getImage());
		this.getRootPane().setDefaultButton(btnLogIn);
	}

	/**
	 * 
	 */
	public void logInUser() {
		String username = jtxtUser.getText();
		String password = new String(passwordtxt.getPassword());

		// Check if users exists
		int result = dbConn.checkUser(username, password);
		if (result >= 1) {
			// Get id of loggedIn user
			int userID = dbConn.retrieveUserInfo(username, password);
			MainScreen.setUserLoggedIn(userID);
			setVisible(false);

			MainScreen m = new MainScreen();
		} else if (jtxtUser.getText().equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(new JPanel(), "Missing field(s)",
					"Info", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(new JPanel(), "Incorrect Details",
					"Info", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public static void main(String[] args) {
		LogIn l = new LogIn();

	}
}