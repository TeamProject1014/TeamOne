package ie.lyit.teamproject;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class NewJob extends JInternalFrame {

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static DBConnectionClass dbc;
	private static ResultSet rs;
	private static Object[][] clientArray;
//	private static String[] clientName;
	private static Object[][] archArray;
//	private String[] archName;
	private static Object[][] engArray;
//	private String[] engName;
	private static Object[][] buildArray;
//	private String[] buildName;
	public OpenProject openProject;
	public static boolean tracker = false;

	@SuppressWarnings("rawtypes")
	public static JComboBox jcboBuild;
	@SuppressWarnings("rawtypes")
	public static JComboBox jcboClient;
	@SuppressWarnings("rawtypes")
	public static JComboBox jcboEng;
	@SuppressWarnings("rawtypes")
	public static JComboBox jcboArch;

	@SuppressWarnings("rawtypes")
	private static DefaultComboBoxModel clientComboModel;
	@SuppressWarnings("rawtypes")
	private static DefaultComboBoxModel archComboModel;
	@SuppressWarnings("rawtypes")
	private static DefaultComboBoxModel engComboModel;
	@SuppressWarnings("rawtypes")
	private static DefaultComboBoxModel buildComboModel;

	public static JTextArea txtAreaDescription;

	@SuppressWarnings("rawtypes")
	public NewJob() {

		getContentPane().setLayout(new BorderLayout(0, 0));

		dbc = new DBConnectionClass();

		JPanel detailPanel = new JPanel();
		detailPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Job Detail",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(detailPanel, BorderLayout.CENTER);
		detailPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Client:");
		lblNewLabel.setBounds(10, 16, 67, 20);
		detailPanel.add(lblNewLabel);

		jcboClient = new JComboBox();
		jcboClient.setBounds(87, 16, 146, 20);
		jcboClient.setSelectedItem(null);
		detailPanel.add(jcboClient);

		JLabel lblNewLabel_2 = new JLabel("Architect:");
		lblNewLabel_2.setBounds(278, 19, 57, 14);
		detailPanel.add(lblNewLabel_2);

		// /////////////ARCHITECT///////////////
		jcboArch = new JComboBox();
		jcboArch.setBounds(345, 16, 146, 20);
		jcboArch.setSelectedItem(null);
		detailPanel.add(jcboArch);

		JLabel lblNewLabel_1 = new JLabel("Engineer:");
		lblNewLabel_1.setBounds(10, 44, 67, 14);
		detailPanel.add(lblNewLabel_1);

		// /////////////ENGINEER///////////////
		jcboEng = new JComboBox();
		jcboEng.setBounds(87, 41, 146, 20);
		jcboEng.setSelectedItem(null);
		detailPanel.add(jcboEng);

		JLabel lblNewLabel_3 = new JLabel("Builder:");
		lblNewLabel_3.setBounds(289, 44, 46, 14);
		detailPanel.add(lblNewLabel_3);

		// /////////////BUILDER///////////////
		jcboBuild = new JComboBox();
		jcboBuild.setBounds(345, 41, 146, 20);
		jcboBuild.setSelectedItem(null);
		detailPanel.add(jcboBuild);

		JLabel lblNewLabel_4 = new JLabel("Description:");
		lblNewLabel_4.setBounds(10, 84, 77, 14);
		detailPanel.add(lblNewLabel_4);

		txtAreaDescription = new JTextArea();
		txtAreaDescription.setBounds(87, 66, 259, 51);
		txtAreaDescription.setLineWrap(true);
		txtAreaDescription.setWrapStyleWord(true);
		txtAreaDescription.setBackground(UIManager
				.getColor("Button.background"));

		txtAreaDescription.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null));
		detailPanel.add(txtAreaDescription);

		JButton btnAddArchitect = new JButton("");
		btnAddArchitect.setIcon(new ImageIcon("Images/addSymbol.jpg"));
		btnAddArchitect.setBounds(503, 16, 21, 21);
		detailPanel.add(btnAddArchitect);
		btnAddArchitect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MainScreen.setPageTitle("Architect");
				AddCharacter addCharacter = new AddCharacter();
				addCharacter.setBounds(670, 368, 340, 315);
				addCharacter.setTitle("Add Architect");
				MainScreen.desk.add(addCharacter);
				addCharacter.setVisible(true);
				tracker = true;

			}
		});

		JButton btnAddBuilder = new JButton("");
		btnAddBuilder.setIcon(new ImageIcon("Images/addSymbol.jpg"));
		btnAddBuilder.setBounds(503, 40, 21, 21);
		detailPanel.add(btnAddBuilder);
		btnAddBuilder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MainScreen.setPageTitle("Builder");
				AddCharacter addCharacter = new AddCharacter();
				addCharacter.setBounds(670, 368, 340, 315);
				addCharacter.setTitle("Add Builder");
				MainScreen.desk.add(addCharacter);
				addCharacter.setVisible(true);
				tracker = true;

			}
		});

		JButton btnAddEngineer = new JButton("");
		btnAddEngineer.setIcon(new ImageIcon("Images/addSymbol.jpg"));
		btnAddEngineer.setBounds(243, 41, 21, 21);
		detailPanel.add(btnAddEngineer);
		btnAddEngineer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MainScreen.setPageTitle("Engineer");
				AddCharacter addCharacter = new AddCharacter();
				addCharacter.setBounds(670, 368, 340, 315);
				addCharacter.setTitle("Add Engineer");
				MainScreen.desk.add(addCharacter);
				addCharacter.setVisible(true);
				tracker = true;

			}
		});

		JButton btnAddClient = new JButton("");
		btnAddClient.setIcon(new ImageIcon("Images/addSymbol.jpg"));
		btnAddClient.setBounds(243, 16, 21, 21);
		detailPanel.add(btnAddClient);
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MainScreen.setPageTitle("Client");
				AddCharacter addCharacter = new AddCharacter();
				addCharacter.setBounds(670, 368, 340, 315);
				addCharacter.setTitle("Add Client");
				MainScreen.desk.add(addCharacter);
				addCharacter.setVisible(true);
				tracker = true;

			}
		});

		JPanel optionsPanel = new JPanel();
		optionsPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Options",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(optionsPanel, BorderLayout.SOUTH);

		JButton jbtAdd = new JButton("Add");
		jbtAdd.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {

				dbc = new DBConnectionClass();

				int client_id = 0;
				for (int i = 0; i < clientComboModel.getSize(); i++)
					if (jcboClient.getSelectedItem().equals(clientComboModel.getElementAt(i)))
						client_id = (Integer) clientArray[i][0];

				int arch_id = 0;
				for (int i = 0; i < archComboModel.getSize(); i++)
					if (jcboArch.getSelectedItem().equals(archComboModel.getElementAt(i)))
						arch_id = (Integer) archArray[i][0];

				int eng_id = 0;
				for (int i = 0; i < engComboModel.getSize(); i++)
					if (jcboEng.getSelectedItem().equals(engComboModel.getElementAt(i)))
						eng_id = (Integer) engArray[i][0];

				int build_id = 0;
				for (int i = 0; i < buildComboModel.getSize(); i++)
					if (jcboBuild.getSelectedItem().equals(
							buildComboModel.getElementAt(i)))
						build_id = (Integer) buildArray[i][0];

				String description = txtAreaDescription.getText();
				dbc.createNewJob(client_id, arch_id, eng_id, build_id,
						description);
				resetValues();
				OpenProject.updateClientJobTable();
				setVisible(false);

				int getLastJobCreated = dbc.getLastJobCreated();

				OpenProject.setProjectToOpen(getLastJobCreated);

				if (!OpenProject.instanceFlag) {
					OpenProject.jobScreen = new JobScreen(OpenProject
							.getProjectToOpen());
					MainScreen.desk.add(OpenProject.jobScreen);
					OpenProject.instanceFlag = true;
				}

				JobScreen.setHeaderDetails(getLastJobCreated);

				JobScreen.jobModel.data = JobScreen.updateJobTable(OpenProject
						.getProjectToOpen());
				JobScreen.table.repaint();
				JobScreen.table.revalidate();

				openProject.clientModel.data = openProject
						.updateClientJobTable();
				openProject.updateClientJobTable();
				openProject.table.repaint();
				openProject.table.revalidate();
				OpenProject.jobScreen.setVisible(true);
				OpenProject.jobScreen.toFront();
			}
		});
		optionsPanel.add(jbtAdd);

		JButton jbtCancel = new JButton("Cancel");
		jbtCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		optionsPanel.add(jbtCancel);

		int ownX = 550;
		int ownY = 225;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));

		this.setLocation(xPos, yPos);

		this.setSize(ownX, ownY);
		this.setTitle("New Job");
		this.setVisible(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
	}

	public String getPageTitle() {
		return MainScreen.pageTitle;
	}

	public static void resetValues() {
		jcboEng.setSelectedItem(null);
		jcboArch.setSelectedItem(null);
		jcboClient.setSelectedItem(null);
		jcboBuild.setSelectedItem(null);
		txtAreaDescription.setText("");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setClientComboContents() {
		clientComboModel = new DefaultComboBoxModel();
		try {
			int count = 0;

			rs = dbc.retrieveClientInfo();
			while (rs.next()) {
				count++;
			}
			clientArray = new Object[count][2];
			rs = dbc.retrieveClientInfo();

			count = 0;
			while (rs.next()) {
				clientArray[count][0] = rs.getInt(1);
				clientArray[count][1] = rs.getString(2);

				clientComboModel.addElement(clientArray[count][1]);
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setArchComboContents() {
		archComboModel = new DefaultComboBoxModel();

		try {
			int count = 0;

			rs = dbc.retrieveArchitectDetails();
			while (rs.next()) {
				count++;
			}
			archArray = new Object[count][2];
			rs = dbc.retrieveArchitectDetails();

			count = 0;
			while (rs.next()) {
				archArray[count][0] = rs.getInt(1);
				archArray[count][1] = rs.getString(2);

				archComboModel.addElement(archArray[count][1]);
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setEngComboContents() {
		engComboModel = new DefaultComboBoxModel();

		try {
			int count = 0;

			rs = dbc.retrieveEngineerDetails();
			while (rs.next()) {
				count++;
			}
			engArray = new Object[count][2];
			rs = dbc.retrieveEngineerDetails();

			count = 0;
			while (rs.next()) {
				engArray[count][0] = rs.getInt(1);
				engArray[count][1] = rs.getString(2);

				engComboModel.addElement(engArray[count][1]);
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setBuildComboContents() {
		buildComboModel = new DefaultComboBoxModel();

		try {
			int count = 0;

			rs = dbc.retrieveBuilderDetails();
			while (rs.next()) {
				count++;
			}
			buildArray = new Object[count][2];
			rs = dbc.retrieveBuilderDetails();

			count = 0;
			while (rs.next()) {
				buildArray[count][0] = rs.getInt(1);
				buildArray[count][1] = rs.getString(2);

				buildComboModel.addElement(buildArray[count][1]);
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel getClientComboModel() {
		return clientComboModel;
	}

	@SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel getArchComboModel() {
		return archComboModel;
	}

	@SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel getEngComboModel() {
		return engComboModel;
	}

	@SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel getBuildComboModel() {
		return buildComboModel;
	}
}
