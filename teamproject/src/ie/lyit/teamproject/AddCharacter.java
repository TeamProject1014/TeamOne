package ie.lyit.teamproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class AddCharacter extends JInternalFrame {

	private DBConnectionClass dbc = new DBConnectionClass();

	private final JPanel contentPanel = new JPanel();

	private JLabel jlblName;
	private JLabel jlblAddr;
	private JLabel jlblAddr2;
	private JLabel jlblTown;
	private JLabel jlblCounty;
	private JLabel jlblPhone;
	private JLabel jlblEmail;

	private static JTextField jtfName;
	private static JTextField jtfAddr;
	private static JTextField jtfAddr2;
	private static JTextField jtfTown;
	private static JTextField jtfPhone;
	private static JTextField jtfEmail;

	@SuppressWarnings("rawtypes")
	private static JComboBox jcboCounty;

	private JButton jbtSave;
	private JButton jbtCancel;

	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	private JPanel optionsPanel;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddCharacter() {

		String[] county = { "Antrim", "Armagh", "Carlow", "Cavan", "Clare",
				"Cork", "Derry", "Donegal", "Down", "Dublin", "Fermanagh",
				"Galway", "Kerry", "Kildare", "Kilkenny", "Laois", "Leitrim",
				"Limerick", "Longford", "Louth", "Mayo", "Meath", "Monaghan",
				"Offaly", "Roscommon", "Sligo", "Tipperary", "Tyrone",
				"Waterford", "Westmeath", "Wexford", "Wicklow" };

		getContentPane().setLayout(new BorderLayout());

		optionsPanel = new JPanel();
		optionsPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Options",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(optionsPanel, BorderLayout.SOUTH);

		jbtSave = new JButton("Add");
		optionsPanel.add(jbtSave);

		jbtCancel = new JButton("Cancel");
		optionsPanel.add(jbtCancel);
		jbtCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValues();
				setVisible(false);
			}
		});
		jbtSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//				String name = jtfName.getText();
//				String address = jtfAddr.getText();
//				String address2 = jtfAddr2.getText();
//				String town = jtfTown.getText();
//				String county = (String) jcboCounty.getSelectedItem();
				
				int phone = -1;
				
				//if (phone == -1) {
					try {
						String name = jtfName.getText();
						String address = jtfAddr.getText();
						String address2 = jtfAddr2.getText();
						String town = jtfTown.getText();
						String county = (String) jcboCounty.getSelectedItem();						
						phone = (Integer.parseInt(jtfPhone.getText()));
						
						
						
						String email = jtfEmail.getText();
						
						Pattern pattern;
						Matcher matcher;
						final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
								+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
						
						pattern = Pattern.compile(EMAIL_PATTERN);
						matcher = pattern.matcher(email);						

						String characterString = MainScreen.getPageTitle();
						
						//Try to retrieve phone number. If String - throw exception
						int phoneNumber = (Integer.parseInt(jtfPhone.getText()));
						
						String tempnumber = (jtfPhone.getText());
						//Check if number is greater than or equal to 6 digits

						if (matcher.matches()) {
							
							if (tempnumber.length() >= 6 && tempnumber.length() <= 15) {
								if (characterString == "Client") {
									dbc.createClient(name, address, address2,
											town, county, phone, email);
									NewJob.setClientComboContents();
									NewJob.jcboClient.setModel(NewJob
											.getClientComboModel());
								} else if (characterString == "Engineer") {
									dbc.createEngineer(name, address, address2,
											town, county, phone, email);
									NewJob.setEngComboContents();
									NewJob.jcboEng.setModel(NewJob
											.getEngComboModel());
								} else if (characterString == "Architect") {
									dbc.createArchitect(name, address,
											address2, town, county, phone,
											email);
									NewJob.setArchComboContents();
									NewJob.jcboArch.setModel(NewJob
											.getArchComboModel());
								} else if (characterString == "Builder") {
									dbc.createBuilder(name, address, address2,
											town, county, phone, email);
									NewJob.setBuildComboContents();
									NewJob.jcboBuild.setModel(NewJob
											.getBuildComboModel());
								}
								setVisible(false);
								resetValues();
							} else {
								JOptionPane.showMessageDialog(new JPanel(), "Phone number must be greater than or equal to 6 digits", "Information",
										JOptionPane.INFORMATION_MESSAGE);
							}
							
							
						} else {
							JOptionPane.showMessageDialog(new JPanel(), "Not a valid email address \n - Must have an @ symbol \n - Must have a valid domain e.g @lyit.ie", "Information",
							        JOptionPane.INFORMATION_MESSAGE);
						}
						
					} catch (NumberFormatException e) {
						//e.printStackTrace();
						JOptionPane.showMessageDialog(new JInternalFrame(),
								"Please Enter a Phone Number");
						jtfPhone.selectAll();
						phone = -1;
					}
				//}
				
//				String email = jtfEmail.getText();
//				setVisible(false);
//
//				String characterString = MainScreen.getPageTitle();
//
//				if (characterString == "Client") {
//					dbc.createClient(name, address, address2, town, county,
//							phone, email);
//				} else if (characterString == "Engineer") {
//					dbc.createEngineer(name, address, address2, town, county,
//							phone, email);
//				} else if (characterString == "Architect") {
//					dbc.createArchitect(name, address, address2, town, county,
//							phone, email);
//				} else if (characterString == "Builder") {
//					dbc.createBuilder(name, address, address2, town, county,
//							phone, email);
//				}
//				resetValues();
			}
		});
		contentPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Add", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 100, 69, 85, 0 };
		gbl_contentPanel.rowHeights = new int[] { 20, 20, 20, 20, 20, 20, 20,
				20, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		jlblName = new JLabel("Name:");
		jlblName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_jlblName = new GridBagConstraints();
		gbc_jlblName.anchor = GridBagConstraints.NORTH;
		gbc_jlblName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblName.gridx = 0;
		gbc_jlblName.gridy = 0;
		contentPanel.add(jlblName, gbc_jlblName);

		jtfName = new JTextField();
		jtfName.setColumns(10);
		GridBagConstraints gbc_jtfName = new GridBagConstraints();
		gbc_jtfName.anchor = GridBagConstraints.NORTH;
		gbc_jtfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfName.insets = new Insets(0, 0, 5, 0);
		gbc_jtfName.gridwidth = 2;
		gbc_jtfName.gridx = 1;
		gbc_jtfName.gridy = 0;
		contentPanel.add(jtfName, gbc_jtfName);

		jlblAddr = new JLabel("Address:");
		jlblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_jlblAddr = new GridBagConstraints();
		gbc_jlblAddr.anchor = GridBagConstraints.NORTH;
		gbc_jlblAddr.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblAddr.insets = new Insets(0, 0, 5, 5);
		gbc_jlblAddr.gridx = 0;
		gbc_jlblAddr.gridy = 1;
		contentPanel.add(jlblAddr, gbc_jlblAddr);

		jtfAddr = new JTextField();
		jtfAddr.setColumns(10);
		GridBagConstraints gbc_jtfAddr = new GridBagConstraints();
		gbc_jtfAddr.anchor = GridBagConstraints.NORTH;
		gbc_jtfAddr.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAddr.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAddr.gridwidth = 2;
		gbc_jtfAddr.gridx = 1;
		gbc_jtfAddr.gridy = 1;
		contentPanel.add(jtfAddr, gbc_jtfAddr);

		jlblAddr2 = new JLabel("Address Line 2:");
		jlblAddr2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_jlblAddr2 = new GridBagConstraints();
		gbc_jlblAddr2.anchor = GridBagConstraints.NORTH;
		gbc_jlblAddr2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblAddr2.insets = new Insets(0, 0, 5, 5);
		gbc_jlblAddr2.gridx = 0;
		gbc_jlblAddr2.gridy = 2;
		contentPanel.add(jlblAddr2, gbc_jlblAddr2);

		jtfAddr2 = new JTextField();
		jtfAddr2.setColumns(10);
		GridBagConstraints gbc_jtfAddr2 = new GridBagConstraints();
		gbc_jtfAddr2.anchor = GridBagConstraints.NORTH;
		gbc_jtfAddr2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAddr2.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAddr2.gridwidth = 2;
		gbc_jtfAddr2.gridx = 1;
		gbc_jtfAddr2.gridy = 2;
		contentPanel.add(jtfAddr2, gbc_jtfAddr2);

		jlblTown = new JLabel("Town:");
		jlblTown.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_jlblTown = new GridBagConstraints();
		gbc_jlblTown.anchor = GridBagConstraints.NORTH;
		gbc_jlblTown.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblTown.insets = new Insets(0, 0, 5, 5);
		gbc_jlblTown.gridx = 0;
		gbc_jlblTown.gridy = 3;
		contentPanel.add(jlblTown, gbc_jlblTown);

		jtfTown = new JTextField();
		jtfTown.setColumns(10);
		GridBagConstraints gbc_jtfTown = new GridBagConstraints();
		gbc_jtfTown.anchor = GridBagConstraints.NORTH;
		gbc_jtfTown.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTown.insets = new Insets(0, 0, 5, 0);
		gbc_jtfTown.gridwidth = 2;
		gbc_jtfTown.gridx = 1;
		gbc_jtfTown.gridy = 3;
		contentPanel.add(jtfTown, gbc_jtfTown);

		jlblCounty = new JLabel("County:");
		jlblCounty.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_jlblCounty = new GridBagConstraints();
		gbc_jlblCounty.anchor = GridBagConstraints.NORTH;
		gbc_jlblCounty.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblCounty.insets = new Insets(0, 0, 5, 5);
		gbc_jlblCounty.gridx = 0;
		gbc_jlblCounty.gridy = 4;
		contentPanel.add(jlblCounty, gbc_jlblCounty);

		jcboCounty = new JComboBox(county);
		jcboCounty.setSelectedItem("Donegal");
		GridBagConstraints gbc_jcboCounty = new GridBagConstraints();
		gbc_jcboCounty.anchor = GridBagConstraints.NORTH;
		gbc_jcboCounty.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcboCounty.insets = new Insets(0, 0, 5, 0);
		gbc_jcboCounty.gridwidth = 2;
		gbc_jcboCounty.gridx = 1;
		gbc_jcboCounty.gridy = 4;
		contentPanel.add(jcboCounty, gbc_jcboCounty);

		jlblPhone = new JLabel("Phone Number:");
		jlblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_jlblPhone = new GridBagConstraints();
		gbc_jlblPhone.anchor = GridBagConstraints.NORTH;
		gbc_jlblPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_jlblPhone.gridx = 0;
		gbc_jlblPhone.gridy = 5;
		contentPanel.add(jlblPhone, gbc_jlblPhone);

		jtfPhone = new JTextField();
		jtfPhone.setColumns(10);
		GridBagConstraints gbc_jtfPhone = new GridBagConstraints();
		gbc_jtfPhone.anchor = GridBagConstraints.NORTH;
		gbc_jtfPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPhone.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPhone.gridwidth = 2;
		gbc_jtfPhone.gridx = 1;
		gbc_jtfPhone.gridy = 5;
		contentPanel.add(jtfPhone, gbc_jtfPhone);

		jlblEmail = new JLabel("Email:");
		jlblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_jlblEmail = new GridBagConstraints();
		gbc_jlblEmail.anchor = GridBagConstraints.NORTH;
		gbc_jlblEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jlblEmail.gridx = 0;
		gbc_jlblEmail.gridy = 6;
		contentPanel.add(jlblEmail, gbc_jlblEmail);

		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.anchor = GridBagConstraints.NORTH;
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.gridwidth = 2;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		contentPanel.add(jtfEmail, gbc_jtfEmail);

		int ownX = 340;
		int ownY = 315;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));

		this.setSize(ownX, ownY);
		this.setLocation(xPos, yPos);

		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
		getRootPane().setDefaultButton(jbtSave);
	}

	/**
	 * Clears existing content out of all textboxes
	 */
	public static void resetValues() {
		jtfName.setText("");
		jtfAddr.setText("");
		jtfAddr2.setText("");
		jtfTown.setText("");
		jcboCounty.setSelectedItem("Donegal");
		jtfPhone.setText("");
		jtfEmail.setText("");
	}

}
