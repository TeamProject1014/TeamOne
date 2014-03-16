package ie.lyit.teamproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EditCharacter extends JInternalFrame {

	private final JPanel contentPanel = new JPanel();

	private DBConnectionClass dbc = new DBConnectionClass();
	private static ResultSet rs;
	int count = 0;
	public static int characterId = 0;

	private JLabel jlblName;
	private JLabel jlblAddr;
	private JLabel jlblAddr2;
	private JLabel jlblTown;
	private JLabel jlblCounty;
	private JLabel jlblPhone;
	private JLabel jlblEmail;
	private static JTextField jtfAddr;
	private static JTextField jtfAddr2;
	//private static JTextField jtfTown;
	private static JTextField jtfTown;
	private static JTextField jtfPhone;
	private static JTextField jtfEmail;

	@SuppressWarnings("rawtypes")
	private static JComboBox jcboCounty;
	@SuppressWarnings("rawtypes")
	private static JComboBox characterComboBox;

	private JButton jbtSave;
	private JButton jbtCancel;
	
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EditCharacter() {

		/**
		 * Retrieve all character details to be edited from the ResultSet rs.
		 * Create new array of sufficient size
		 * Add relevant information for each row to the array
		 */
		try {

			rs = dbc.retrieveEngineerDetails();
			while (rs.next()) {
				count++;
			}
			rs = dbc.retrieveEngineerDetails();
			String[] engNames = new String[count];

			count = 0;
			while (rs.next()) {
				String name = rs.getString(1);
				engNames[count] = name;
				count++;

			}
			characterComboBox = new JComboBox(engNames);
			characterComboBox.setBounds(120, 8, 164, 20);
			contentPanel.add(characterComboBox);
			characterComboBox.setSelectedItem(null);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		jlblName = new JLabel("Name:");
		jlblName.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblName.setBounds(10, 11, 100, 14);
		contentPanel.add(jlblName);

		jlblAddr = new JLabel("Address:");
		jlblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblAddr.setBounds(10, 41, 100, 14);
		contentPanel.add(jlblAddr);

		jtfAddr = new JTextField();
		jtfAddr.setColumns(10);
		jtfAddr.setBounds(124, 41, 160, 20);
		contentPanel.add(jtfAddr);

		jtfAddr2 = new JTextField();
		jtfAddr2.setColumns(10);
		jtfAddr2.setBounds(124, 71, 160, 20);
		contentPanel.add(jtfAddr2);

		jlblAddr2 = new JLabel("Address Line 2:");
		jlblAddr2.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblAddr2.setBounds(10, 71, 100, 14);
		contentPanel.add(jlblAddr2);

		jlblTown = new JLabel("Town:");
		jlblTown.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblTown.setBounds(10, 101, 100, 14);
		contentPanel.add(jlblTown);

		jtfTown = new JTextField();
		jtfTown.setColumns(10);
		jtfTown.setBounds(124, 101, 160, 20);
		contentPanel.add(jtfTown);

		String[] county = { "Antrim", "Armagh", "Carlow", "Cavan", "Clare",
				"Cork", "Derry", "Donegal", "Down", "Dublin", "Fermanagh",
				"Galway", "Kerry", "Kildare", "Kilkenny", "Laois", "Leitrim",
				"Limerick", "Longford", "Louth", "Mayo", "Meath", "Monaghan",
				"Offaly", "Roscommon", "Sligo", "Tipperary", "Tyrone",
				"Waterford", "Westmeath", "Wexford", "Wicklow" };

		jcboCounty = new JComboBox(county);
		jcboCounty.setSelectedItem("Donegal");
		jcboCounty.setBounds(124, 131, 160, 20);
		contentPanel.add(jcboCounty);

		jlblCounty = new JLabel("County:");
		jlblCounty.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblCounty.setBounds(10, 131, 100, 14);
		contentPanel.add(jlblCounty);

		jlblPhone = new JLabel("Phone Number:");
		jlblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblPhone.setBounds(10, 161, 100, 14);
		contentPanel.add(jlblPhone);

		jtfPhone = new JTextField();
		jtfPhone.setColumns(10);
		jtfPhone.setBounds(124, 161, 160, 20);
		contentPanel.add(jtfPhone);

		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		jtfEmail.setBounds(124, 191, 160, 20);
		contentPanel.add(jtfEmail);

		jlblEmail = new JLabel("Email:");
		jlblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblEmail.setBounds(10, 191, 100, 14);
		contentPanel.add(jlblEmail);

		jbtSave = new JButton("Update");
		jbtSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String address = jtfAddr.getText();
				String address2 = jtfAddr2.getText();
				String town = jtfTown.getText();
				String county = (String) jcboCounty.getSelectedItem();
				String phone = jtfPhone.getText();
//				int phone = (Integer.parseInt(jtfPhone.getText()));
				String email = jtfEmail.getText();
				setVisible(false);
				
				String characterString = MainScreen.getPageTitle();
				
				if (characterString == "Engineer") {
					dbc.editEngineer(address, address2, town, county, phone,
							email);					
				} /*else if (characterString == "Engineer") {
					dbc.editClient(address, address2, town, county, phone,
							email);
				} else if (characterString == "Architect") {
					dbc.editArchitect(address, address2, town, county, phone,
							email);
				} else if (characterString == "Builder") {
					dbc.editBuilder(address, address2, town, county, phone,
							email);
				}*/
			}
		});
		jbtSave.setBounds(108, 233, 85, 20);
		contentPanel.add(jbtSave);

		jbtCancel = new JButton("Cancel");
		jbtCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		jbtCancel.setBounds(199, 233, 85, 20);
		contentPanel.add(jbtCancel);
		
		int ownX = 340;
		int ownY = 315;
		
		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int)((screenX / 2) - (ownX / 2)) ;
		int yPos = (int)((screenY / 2) - (ownY / 2));
		
		this.setSize(ownX, ownY);
		this.setLocation(xPos, yPos);

		this.setClosable(true);
		setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
		setTitle("Edit " + ProjectOverview.pageTitle);
	}
	
	/**
	 * Clears existing content from all JTextboxes/JComboBoxes
	 */
	public static void resetValues() {
		characterComboBox.setSelectedItem(null);
		jtfAddr.setText("");
		jtfAddr2.setText("");
		jtfTown.setText("");
		jcboCounty.setSelectedItem("Donegal");
		jtfPhone.setText("");
		jtfEmail.setText("");
	}
}
