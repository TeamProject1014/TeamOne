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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * LW - We should look at the following link to have some element of security on
 * this login screen
 * http://stackoverflow.com/questions/2860943/suggestions-for-library
 * -to-hash-passwords-in-java It's not critical for our application, but some
 * understanding of it will be useful in the future,
 */

public class LogIn extends JInternalFrame {
	private JTextField txtUname;
	private JPanel main;
	DBConnectionClass dbConn = new DBConnectionClass();
	OpenProject openProject = new OpenProject();
	// Move to my desktopPane
	// CardLayout cardLayout = new CardLayout();
	private JPasswordField txtPassword;
	public static JTextField jtxtUser;
	private JPasswordField passwordtxt;

	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();

	public LogIn() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				jtxtUser.requestFocus();
			}
		});
		setTitle("Member - Log in");
		getContentPane().setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(10, 37, 86, 14);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(10, 78, 86, 14);
		getContentPane().add(lblPassword);

		jtxtUser = new JTextField();
		jtxtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				jtxtUser.selectAll();
			}
		});
		jtxtUser.setBounds(106, 34, 86, 20);
		getContentPane().add(jtxtUser);
		jtxtUser.setColumns(10);

		passwordtxt = new JPasswordField();
		passwordtxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordtxt.selectAll();
			}
		});
		passwordtxt.setBounds(106, 76, 89, 17);
		getContentPane().add(passwordtxt);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logInUser();
			}
		});
		btnLogIn.setBounds(73, 118, 89, 23);
		getContentPane().add(btnLogIn);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				jtxtUser.setText("");
				passwordtxt.setText("");
			}
		});
		btnCancel.setBounds(73, 152, 89, 23);
		getContentPane().add(btnCancel);
		
		// spawn
		int ownX = 455;
		int ownY = 330;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));

		this.setSize(247, 229);
		this.setLocation(xPos, yPos);

		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
		getRootPane().setDefaultButton(btnLogIn);

	}

	/**
	 * 
	 */
	public void logInUser() {
		String username = jtxtUser.getText();
		String password = new String(passwordtxt.getPassword());

		// Check if users exists
		int result = dbConn.checkUser(username);
		if (result >= 1) {
			// Get id of loggedIn user
			int userID = dbConn.retrieveUserInfo(username, password);
			MainScreen.setUserLoggedIn(userID);
			setVisible(false);

			if (!MainScreen.openProjectInstanceFlag) {
				MainScreen.openProject = new OpenProject();
				MainScreen.desk.add(MainScreen.openProject);
				MainScreen.openProjectInstanceFlag = true;
			}
			OpenProject.clientModel.data = OpenProject.updateClientJobTable();
			OpenProject.updateClientJobTable();
			OpenProject.table.repaint();
			OpenProject.table.revalidate();
			MainScreen.openProject.setVisible(true);
			MainScreen.openProject.toFront();

			jtxtUser.setText("");
			passwordtxt.setText("");
		} else {
			JOptionPane.showMessageDialog(new JPanel(), "Incorrect Details",
					"Info", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}