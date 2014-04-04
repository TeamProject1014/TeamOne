package ie.lyit.teamproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class EditCharacter extends JInternalFrame {

	private final JPanel contentPanel;
	private JLabel jlblName;
	private JLabel jlblAddr;
	private JLabel jlblAddr2;
	private JLabel jlblTown;
	private JLabel jlblCounty;
	private JLabel jlblPhone;
	private JLabel jlblEmail;
	private JButton jbtUpdate;
	private JButton jbtCancel;
	private static JTextField jtfAddr;
	private static JTextField jtfAddr2;
	private static JTextField jtfTown;
	private static JTextField jtfPhone;
	private static JTextField jtfEmail;

	@SuppressWarnings("rawtypes")
	private static JComboBox jcboCounty;
	@SuppressWarnings("rawtypes")
	public static JComboBox characterComboBox;
	@SuppressWarnings("rawtypes")
	private static DefaultComboBoxModel comboModel;

	private static DBConnectionClass dbc = new DBConnectionClass();
	private static ResultSet rs;

	private static Object[][] charArray;
	public static int characterId = -1;

	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	private JPanel panel;


	/**
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EditCharacter() {
		contentPanel = new JPanel();
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 100, 73, 85, 0 };
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
		gbc_jlblName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblName.gridx = 0;
		gbc_jlblName.gridy = 0;
		contentPanel.add(jlblName, gbc_jlblName);

		jtfAddr = new JTextField();
		jtfAddr.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				jtfAddr.selectAll();
			}
		});

		characterComboBox = new JComboBox();
		GridBagConstraints gbc_characterComboBox = new GridBagConstraints();
		gbc_characterComboBox.anchor = GridBagConstraints.NORTH;
		gbc_characterComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_characterComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_characterComboBox.gridwidth = 2;
		gbc_characterComboBox.gridx = 1;
		gbc_characterComboBox.gridy = 0;
		contentPanel.add(characterComboBox, gbc_characterComboBox);
		characterComboBox.setSelectedItem(null);
		characterComboBox.addItemListener(new ItemChangeListener());

		jlblAddr = new JLabel("Address:");
		jlblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_jlblAddr = new GridBagConstraints();
		gbc_jlblAddr.anchor = GridBagConstraints.NORTH;
		gbc_jlblAddr.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblAddr.insets = new Insets(0, 0, 5, 5);
		gbc_jlblAddr.gridx = 0;
		gbc_jlblAddr.gridy = 1;
		contentPanel.add(jlblAddr, gbc_jlblAddr);
		jtfAddr.setColumns(10);
		GridBagConstraints gbc_jtfAddr = new GridBagConstraints();
		gbc_jtfAddr.anchor = GridBagConstraints.NORTH;
		gbc_jtfAddr.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAddr.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAddr.gridwidth = 2;
		gbc_jtfAddr.gridx = 1;
		gbc_jtfAddr.gridy = 1;
		contentPanel.add(jtfAddr, gbc_jtfAddr);

		jtfTown = new JTextField();
		jtfTown.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtfTown.selectAll();
			}
		});

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
		jtfAddr2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtfAddr2.selectAll();
			}
		});
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

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Edit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		String[] county = { "Antrim", "Armagh", "Carlow", "Cavan", "Clare",
				"Cork", "Derry", "Donegal", "Down", "Dublin", "Fermanagh",
				"Galway", "Kerry", "Kildare", "Kilkenny", "Laois", "Leitrim",
				"Limerick", "Longford", "Louth", "Mayo", "Meath", "Monaghan",
				"Offaly", "Roscommon", "Sligo", "Tipperary", "Tyrone",
				"Waterford", "Westmeath", "Wexford", "Wicklow" };

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
		jtfPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtfPhone.selectAll();
			}
		});
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

		//jbtUpdate = new JButton("Update");
//		jbtUpdate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				String address = jtfAddr.getText();
//				String address2 = jtfAddr2.getText();
//				String town = jtfTown.getText();
//				String county = (String) jcboCounty.getSelectedItem();
//				String phone = jtfPhone.getText();
//				String email = jtfEmail.getText();
//				setVisible(false);
//
//				String tempName = (String) characterComboBox.getSelectedItem();
//
//				/**
//				 * Set the characterId that will determine which entity is
//				 * updated by the SQL statement
//				 */
//				for (int i = 0; i < comboModel.getSize(); i++) {
//					if (charArray[i][1] == tempName) {
//						characterId = (int) charArray[i][0];
//					}
//				}
//
//				String characterString = MainScreen.getPageTitle();
//
//				if (characterString.equals("Engineer")) {
//					dbc.editEngineer(address, address2, town, county, phone,
//							email);
//				}
//
//				else if (characterString.equals("Architect")) {
//					dbc.editArchitect(address, address2, town, county, phone,
//							email);
//				}
//
//				else if (characterString.equals("Client")) {
//					dbc.editClient(address, address2, town, county, phone,
//							email);
//				}
//
//				else if (characterString.equals("Builder")) {
//					dbc.editBuilder(address, address2, town, county, phone,
//							email);
//				}
//			}
//		});

		jtfEmail = new JTextField();
		jtfEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtfEmail.selectAll();
			}
		});
		jtfEmail.setColumns(10);
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.anchor = GridBagConstraints.NORTH;
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.gridwidth = 2;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		contentPanel.add(jtfEmail, gbc_jtfEmail);
		GridBagConstraints gbc_jbtUpdate = new GridBagConstraints();
		gbc_jbtUpdate.anchor = GridBagConstraints.EAST;
		gbc_jbtUpdate.fill = GridBagConstraints.VERTICAL;
		gbc_jbtUpdate.insets = new Insets(0, 0, 0, 5);
		gbc_jbtUpdate.gridwidth = 2;
		gbc_jbtUpdate.gridx = 0;
		gbc_jbtUpdate.gridy = 7;
		

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "Options", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		getContentPane().add(panel, BorderLayout.SOUTH);

		jbtUpdate = new JButton("Update");
		jbtUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String address = jtfAddr.getText();
				String address2 = jtfAddr2.getText();
				String town = jtfTown.getText();
				String county = (String) jcboCounty.getSelectedItem();
				String phone = jtfPhone.getText();
				String email = jtfEmail.getText();
				setVisible(false);

				String tempName = (String) characterComboBox.getSelectedItem();

				/**
				 * Set the characterId that will determine which entity is
				 * updated by the SQL statement
				 */
				for (int i = 0; i < comboModel.getSize(); i++) {
					if (charArray[i][1] == tempName) {
						characterId = (int) charArray[i][0];
					}
				}

				String characterString = MainScreen.getPageTitle();

				if (characterString.equals("Engineer")) {
					dbc.editEngineer(address, address2, town, county, phone,
							email);
				}

				else if (characterString.equals("Architect")) {
					dbc.editArchitect(address, address2, town, county, phone,
							email);
				}

				else if (characterString.equals("Client")) {
					dbc.editClient(address, address2, town, county, phone,
							email);
				}

				else if (characterString.equals("Builder")) {
					dbc.editBuilder(address, address2, town, county, phone,
							email);
				}
			}
		});
		//contentPanel.add(jbtUpdate, gbc_jbtUpdate);
		panel.add(jbtUpdate);
		
		jbtCancel = new JButton("Cancel");
		jbtCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		panel.add(jbtCancel);

		int ownX = 340;
		int ownY = 315;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));

		this.setSize(ownX, ownY);
		this.setLocation(xPos, yPos);

		this.setClosable(true);
		setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setComboContents(String character) {
		comboModel = new DefaultComboBoxModel();
		try {
			int count = 0;
			if (character.equals("Client")) {
				rs = dbc.retrieveClientDetails();
				while (rs.next()) {
					count++;
				}
				charArray = new Object[count][8];
				rs = dbc.retrieveClientDetails();
			} else if (character.equals("Architect")) {
				rs = dbc.retrieveArchitectDetails();
				while (rs.next()) {
					count++;
				}
				charArray = new Object[count][8];
				rs = dbc.retrieveArchitectDetails();
			} else if (character.equals("Engineer")) {
				rs = dbc.retrieveEngineerDetails();
				while (rs.next()) {
					count++;
				}
				charArray = new Object[count][8];
				rs = dbc.retrieveEngineerDetails();
			} else if (character.equals("Builder")) {
				rs = dbc.retrieveBuilderDetails();
				while (rs.next()) {
					count++;
				}
				charArray = new Object[count][8];
				rs = dbc.retrieveBuilderDetails();
			}
			count = 0;
			while (rs.next()) {
				charArray[count][0] = rs.getInt(1);
				charArray[count][1] = rs.getString(2);
				charArray[count][2] = rs.getString(3);
				charArray[count][3] = rs.getString(4);
				charArray[count][4] = rs.getString(5);
				charArray[count][5] = rs.getString(6);
				charArray[count][6] = rs.getString(7);
				charArray[count][7] = rs.getString(8);

				comboModel.addElement(charArray[count][1]);

				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	class ItemChangeListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				Object item = event.getItem();
				for (int i = 0; i < comboModel.getSize(); i++) {
					if (charArray[i][1].equals(item)) {
						int idToPass = (int) charArray[i][0];
						populateFields(idToPass);
					}
				}
			}
		}
	}

	public static void populateFields(int id) {
		for (int i = 0; i < charArray.length; i++) {
			if ((int) charArray[i][0] == id) {
				jtfAddr.setText((String) charArray[i][2]);
				jtfAddr2.setText((String) charArray[i][3]);
				jtfTown.setText((String) charArray[i][4]);
				jcboCounty.setSelectedItem((String) charArray[i][5]);
				jtfPhone.setText((String) charArray[i][6]);
				jtfEmail.setText((String) charArray[i][7]);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel getComboModel() {
		return comboModel;
	}
}
