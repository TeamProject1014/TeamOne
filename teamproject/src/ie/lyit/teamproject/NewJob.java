package ie.lyit.teamproject;

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
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;

@SuppressWarnings("serial")
public class NewJob extends JInternalFrame {

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private DBConnectionClass dbc;
	private ResultSet rs;
	private Object[][] clientArray;
	private String[] clientName;
	private Object[][] archArray;
	private String[] archName;
	private Object[][] engArray;
	private String[] engName;
	private Object[][] buildArray;
	private String[] buildName;
	public OpenProject openProject;
	//protected static JobScreen jobScreen;

	public NewJob() {

		getContentPane().setLayout(new BorderLayout(0, 0));

		dbc = new DBConnectionClass();

		int count = 0;

		JPanel detailPanel = new JPanel();
		detailPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Job Detail",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(detailPanel, BorderLayout.CENTER);
		GridBagLayout gbl_detailPanel = new GridBagLayout();
		gbl_detailPanel.columnWidths = new int[] { 46, 125, 0, 0, 125, 0, 0 };
		gbl_detailPanel.rowHeights = new int[] { 20, 0, 0, 0 };
		gbl_detailPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, Double.MIN_VALUE };
		gbl_detailPanel.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		detailPanel.setLayout(gbl_detailPanel);

		JLabel lblNewLabel = new JLabel("Client Name:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		detailPanel.add(lblNewLabel, gbc_lblNewLabel);
		// /////////////CLIENT///////////////
		try {
			count = 0;
			rs = dbc.retrieveClientInfo();

			while (rs.next()) {
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		clientArray = new Object[count][2];
		clientName = new String[count];

		try {
			rs = dbc.retrieveClientInfo();
			count = 0;

			while (rs.next()) {
				clientArray[count][0] = rs.getInt(1);
				clientArray[count][1] = clientName[count] = rs.getString(2);
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		final JComboBox jcboClient = new JComboBox(clientName);
		jcboClient.setSelectedItem(null);
		GridBagConstraints gbc_jcboClient = new GridBagConstraints();
		gbc_jcboClient.insets = new Insets(0, 0, 5, 5);
		gbc_jcboClient.fill = GridBagConstraints.BOTH;
		gbc_jcboClient.gridx = 1;
		gbc_jcboClient.gridy = 0;
		detailPanel.add(jcboClient, gbc_jcboClient);

		JLabel lblNewLabel_2 = new JLabel("Architect:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 0;
		detailPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		// /////////////ARCHITECT///////////////
		try {
			count = 0;
			rs = dbc.retrieveArchInfo();

			while (rs.next()) {
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		archArray = new Object[count][2];
		archName = new String[count];
		
		try {
			rs = dbc.retrieveArchInfo();
			count = 0;

			while (rs.next()) {
				archArray[count][0] = rs.getInt(1);
				archArray[count][1] = archName[count] = rs.getString(2);
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		final JComboBox jcboArch = new JComboBox(archName);
		jcboArch.setSelectedItem(null);
		GridBagConstraints gbc_jcboArch = new GridBagConstraints();
		gbc_jcboArch.insets = new Insets(0, 0, 5, 5);
		gbc_jcboArch.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcboArch.gridx = 4;
		gbc_jcboArch.gridy = 0;
		detailPanel.add(jcboArch, gbc_jcboArch);

		JLabel lblNewLabel_1 = new JLabel("Engineer:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		detailPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		// /////////////ENGINEER///////////////
		try {
			count = 0;
			rs = dbc.retrieveEngInfo();

			while (rs.next()) {
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		engArray = new Object[count][2];
		engName = new String[count];

		try {
			rs = dbc.retrieveEngInfo();
			count = 0;

			while (rs.next()) {
				engArray[count][0] = rs.getInt(1);
				engArray[count][1] = engName[count] = rs.getString(2);
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		final JComboBox jcboEng = new JComboBox(engName);
		jcboEng.setSelectedItem(null);
		GridBagConstraints gbc_jcboEng = new GridBagConstraints();
		gbc_jcboEng.insets = new Insets(0, 0, 5, 5);
		gbc_jcboEng.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcboEng.gridx = 1;
		gbc_jcboEng.gridy = 1;
		detailPanel.add(jcboEng, gbc_jcboEng);

		JLabel lblNewLabel_3 = new JLabel("Builder:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 1;
		detailPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		// /////////////BUILDER///////////////
		try {
			count = 0;
			rs = dbc.retrieveBuildInfo();

			while (rs.next()) {
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		buildArray = new Object[count][2];
		buildName = new String[count];

		try {
			rs = dbc.retrieveBuildInfo();
			count = 0;

			while (rs.next()) {
				buildArray[count][0] = rs.getInt(1);
				buildArray[count][1] = buildName[count] = rs.getString(2);
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		final JComboBox jcboBuild = new JComboBox(buildName);
		jcboBuild.setSelectedItem(null);
		GridBagConstraints gbc_jcboBuild = new GridBagConstraints();
		gbc_jcboBuild.insets = new Insets(0, 0, 5, 5);
		gbc_jcboBuild.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcboBuild.gridx = 4;
		gbc_jcboBuild.gridy = 1;
		detailPanel.add(jcboBuild, gbc_jcboBuild);

		JLabel lblNewLabel_4 = new JLabel("Description:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		detailPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(UIManager.getColor("Button.background"));

		textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.gridwidth = 4;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 2;
		detailPanel.add(textArea, gbc_textArea);

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
				for (int i = 0; i < clientName.length; i++)
					if (jcboClient.getSelectedItem().equals(clientName[i]))
						client_id = (Integer) clientArray[i][0];

				int arch_id = 0;
				for (int i = 0; i < archName.length; i++)
					if (jcboArch.getSelectedItem().equals(archName[i]))
						arch_id = (Integer) archArray[i][0];

				int eng_id = 0;
				for (int i = 0; i < engName.length; i++)
					if (jcboEng.getSelectedItem().equals(engName[i]))
						eng_id = (Integer) engArray[i][0];

				int build_id = 0;
				for (int i = 0; i < buildName.length; i++)
					if (jcboBuild.getSelectedItem().equals(buildName[i]))
						build_id = (Integer) buildArray[i][0];

				String description = textArea.getText();
				dbc.createNewJob(client_id, arch_id, eng_id, build_id,
						description);
				OpenProject.updateClientJobTable();
				setVisible(false);
				
				
				int getLastJobCreated = dbc.getLastJobCreated();
				
				OpenProject.setProjectToOpen(getLastJobCreated);
				
				if (!OpenProject.instanceFlag) {
					OpenProject.jobScreen = new JobScreen(OpenProject.getProjectToOpen());
					MainScreen.desk.add(OpenProject.jobScreen);
					OpenProject.instanceFlag = true;
				}
				
				JobScreen.setHeaderDetails(getLastJobCreated);
				
				JobScreen.jobModel.data = JobScreen.updateJobTable(OpenProject.getProjectToOpen());
				JobScreen.table.repaint();
				JobScreen.table.revalidate();
				
				openProject.clientModel.data = openProject.updateClientJobTable(); 
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

		int ownX = 450;
		int ownY = 225;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));

		this.setSize(ownX, ownY);
		this.setLocation(xPos, yPos);

		this.setSize(ownX, ownY);
		this.setTitle("New Job");
		this.setVisible(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
	}

}
