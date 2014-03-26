package ie.lyit.teamproject;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class EditStatus extends JInternalFrame {
	private static JTextField jtfClientName;
	private static JTextArea jtaDescription;
	@SuppressWarnings("rawtypes")
	private static JComboBox jcboStatus;
	private static DBConnectionClass dbc;
	private static ResultSet rs;
	private static String[] statusArray = { "Open", "Pending", "Approved", "Rejected" };	
	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	protected static JobScreen jobScreen;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EditStatus(int jobId) {
		dbc = new DBConnectionClass();

		JPanel detailsPanel = new JPanel();
		detailsPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Job Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(detailsPanel, BorderLayout.NORTH);
		GridBagLayout gbl_detailsPanel = new GridBagLayout();
		gbl_detailsPanel.columnWidths = new int[] { 75, 150, 0 };
		gbl_detailsPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_detailsPanel.columnWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_detailsPanel.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		detailsPanel.setLayout(gbl_detailsPanel);

		JLabel lblNewLabel = new JLabel("Client Name:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		detailsPanel.add(lblNewLabel, gbc_lblNewLabel);

		jtfClientName = new JTextField();
		jtfClientName.setEditable(false);
		GridBagConstraints gbc_jtfClientName = new GridBagConstraints();
		gbc_jtfClientName.insets = new Insets(0, 0, 5, 0);
		gbc_jtfClientName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfClientName.gridx = 1;
		gbc_jtfClientName.gridy = 0;
		detailsPanel.add(jtfClientName, gbc_jtfClientName);
		jtfClientName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Job Description:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		detailsPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtaDescription = new JTextArea();
		jtaDescription.setLineWrap(true);
		jtaDescription.setWrapStyleWord(true);
		jtaDescription
				.setBackground(UIManager.getColor("Button.background"));
		jtaDescription.setEditable(false);
		jtaDescription.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_jtaDescription = new GridBagConstraints();
		gbc_jtaDescription.fill = GridBagConstraints.BOTH;
		gbc_jtaDescription.insets = new Insets(0, 0, 5, 0);
		gbc_jtaDescription.gridx = 1;
		gbc_jtaDescription.gridy = 1;
		detailsPanel.add(jtaDescription, gbc_jtaDescription);
		jtaDescription.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Select Status:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		detailsPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcboStatus = new JComboBox(statusArray);
		GridBagConstraints gbc_jcboStatus = new GridBagConstraints();
		gbc_jcboStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcboStatus.gridx = 1;
		gbc_jcboStatus.gridy = 2;
		detailsPanel.add(jcboStatus, gbc_jcboStatus);

		JPanel optionsPanel = new JPanel();
		optionsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(optionsPanel, BorderLayout.CENTER);

		JButton jbtOk = new JButton("OK");
		jbtOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int jobId = OpenProject.getProjectToOpen();
				String status = jcboStatus.getSelectedItem().toString();
				dbc.editJobStatus(jobId, status);
				JobScreen.jtfJobStatus.setText(status);
				setVisible(false);
			}
		});
		optionsPanel.add(jbtOk);

		JButton jbtCancel = new JButton("Cancel");
		jbtCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		optionsPanel.add(jbtCancel);
		
		int ownX = 350;
		int ownY = 220;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));

		this.setSize(ownX, ownY);
		this.setLocation(xPos, yPos);

		this.setTitle("Update Job Status");
		this.setVisible(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
	}

	public static void setJobDetails(int jobId) {
		try {
			rs = dbc.retrieveJobDetails(jobId);			

			while (rs.next()) {
				jtfClientName.setText(rs.getString(1));
				jtaDescription.setText(rs.getString(2));
				jcboStatus.setSelectedItem(rs.getString(3));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
