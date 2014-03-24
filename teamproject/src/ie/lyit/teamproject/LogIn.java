package ie.lyit.teamproject;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LogIn extends JFrame{
	private JTextField txtUname;
	private JPanel main;

	//Move to my desktopPane
	CardLayout cardLayout = new CardLayout();
	private JPasswordField txtPassword;

	public LogIn() 
	{

		main = new JPanel();
		//
		//clPanel.add(main, "1");
		//clPanel.add(new MyDesktopPane(), "2");
		
		main.setLayout(null);
		//background
		BufferedImage img = null;
//		try {
////			img = ImageIO.read(new File("E:\\Team Project\\New\\teamproject\\teamproject\\images.PNG"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		txtUname = new JTextField();
		txtUname.setBounds(435, 200, 164, 37);
		main.add(txtUname);
		txtUname.setColumns(10);
		
		/*
		 * Login button
		 * User clicks, variables are taken from the username and password boxes
		 * These variables are checked against the details stored in the database
		 */
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUname.getText();
				String password = "";
				for (char x : txtPassword.getPassword()) {
				    password += x;
				}
				DBConnectionClass dbConn = new DBConnectionClass();
				int result = dbConn.retrieveUserInfo(username, password);
				
				if(result == 1)
				{
					System.out.print("User exists!");
					setVisible(false);
					MainScreen mainScreen = new MainScreen();
//					 CardLayout cl = (CardLayout)(clPanel.getLayout());
//					    cl.show(clPanel, "2");
				}
				else
				{
					System.out.print("User doesn't exist");
				}
		    }
				
			
		});
		btnLogIn.setBounds(451, 341, 124, 54);
		main.add(btnLogIn);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(477, 187, 72, 14);
		main.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(477, 248, 72, 14);
		main.add(lblPassword);
		
//		JLabel lblBg = new JLabel(new ImageIcon(img));
//		lblBg.setBounds(0, 0, 1920, 670);
//		main.add(lblBg);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(435, 273, 164, 37);
		main.add(txtPassword);
		
		getContentPane().add(main);
	}
	
	public static void main(String [] args)
	{
		LogIn logIn = new LogIn();
		logIn.setVisible(true);
		logIn.setSize(1080,720);
		logIn.setLocationRelativeTo(null);
		//logIn.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
