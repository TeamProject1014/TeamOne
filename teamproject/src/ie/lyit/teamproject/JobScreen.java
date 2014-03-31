package ie.lyit.teamproject;

import javax.swing.JInternalFrame;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.FlowLayout;

import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

import java.awt.CardLayout;

@SuppressWarnings("serial")
public class JobScreen extends JInternalFrame {
	private final JPanel tablePanel = new JPanel();
	private static JTable table;

	private static DecimalFormat df;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private static Object[][] dbinfo;
	private static Object[] columns = { "Description", "Price", "Quantity",
			"Total" };
	private static ResultSet rs;
	private static DBConnectionClass dbc;
	private WallsTab walls;
	public static WallCalc wallCalc;
	
	private ExternalTab externalTab;
	public static ExternalAdd externalAdd;
	private InternalTab internalTab;
	private RoofTab roofTab;
	//private ExternalTab externalTab;
	private Internal internal;
	private Roof roof;
	private EditStatus editStatus;
	private boolean instanceFlag = false;
	private JLabel jlblEditStatus;
	private static int categoryToOpen;

	private static DefaultTableModel dTableModel = new DefaultTableModel(
			dbinfo, columns) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int column) {
			Class returnValue;

			if ((column >= 0) && (column < getColumnCount())) {
				returnValue = getValueAt(0, column).getClass();
			} else {
				returnValue = Object.class;
			}
			return returnValue;
		}
	};

	private final JLabel jlblTotal = new JLabel("SubTotal: \u20AC");
	private final JPanel optionsPanel = new JPanel();
	private static JTextField jtfClientName;
	private static JTextField jtfTotal;
	private static JTextField jtfArchitect;
	private static JTextArea jtaJobDescription;
	private static JTextField jtfEngineer;
	protected static JTextField jtfJobStatus;
	private static JTextField jtfBuilder;
	/**
	 * Create the frame.
	 */
	public JobScreen(int jobId) {

		getContentPane().setLayout(new BorderLayout(0, 0));

		dbc = new DBConnectionClass();

		df = new DecimalFormat("###,###.00");

		JPanel entirePanel = new JPanel();
		getContentPane().add(entirePanel, BorderLayout.CENTER);
		entirePanel.setLayout(new BorderLayout(0, 0));
		entirePanel.add(optionsPanel, BorderLayout.SOUTH);

		optionsPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Options",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JButton jbtExit = new JButton("Exit");
		jbtExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		optionsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton jbtDelete = new JButton("Delete");
		jbtDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteFromTable();
			}
		});
		
		JButton jbtEdit = new JButton("Edit");
		optionsPanel.add(jbtEdit);
		optionsPanel.add(jbtDelete);
		optionsPanel.add(jbtExit);
		entirePanel.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Project Overview",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tablePanel.setLayout(new BorderLayout(0, 0));
		table = new JTable(dTableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBounds(10, 24, 677, 328);

		TableColumn col0 = table.getColumnModel().getColumn(0);
		TableColumn col1 = table.getColumnModel().getColumn(1);
		TableColumn col3 = table.getColumnModel().getColumn(3);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(15, 15, 672, 340);
		tablePanel.add(scrollPane, BorderLayout.NORTH);

		JPanel totalPanel = new JPanel();
		tablePanel.add(totalPanel, BorderLayout.CENTER);
		totalPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		totalPanel.add(jlblTotal);
		jlblTotal.setHorizontalAlignment(SwingConstants.RIGHT);

		jtfTotal = new JTextField();
		jtfTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfTotal.setEditable(false);
		totalPanel.add(jtfTotal);
		jtfTotal.setColumns(10);

		JPanel jobDescriptionPanel = new JPanel();
		entirePanel.add(jobDescriptionPanel, BorderLayout.NORTH);
		jobDescriptionPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Project Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_jobDescriptionPanel = new GridBagLayout();
		gbl_jobDescriptionPanel.columnWidths = new int[] { 100, 150, 75, 100,
				225 };
		gbl_jobDescriptionPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_jobDescriptionPanel.columnWeights = new double[] { 0.0, 0.0, 1.0,
				0.0, 1.0 };
		gbl_jobDescriptionPanel.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		jobDescriptionPanel.setLayout(gbl_jobDescriptionPanel);

		JLabel jlblCliDescr = new JLabel("Client Name:");
		GridBagConstraints gbc_jlblCliDescr = new GridBagConstraints();
		gbc_jlblCliDescr.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblCliDescr.insets = new Insets(0, 0, 5, 5);
		gbc_jlblCliDescr.gridx = 0;
		gbc_jlblCliDescr.gridy = 0;
		jobDescriptionPanel.add(jlblCliDescr, gbc_jlblCliDescr);
		jlblCliDescr.setHorizontalAlignment(SwingConstants.CENTER);

		jtfClientName = new JTextField("");
		jtfClientName.setEditable(false);
		GridBagConstraints gbc_jtfClientName = new GridBagConstraints();
		gbc_jtfClientName.gridwidth = 2;
		gbc_jtfClientName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfClientName.insets = new Insets(0, 0, 5, 5);
		gbc_jtfClientName.gridx = 1;
		gbc_jtfClientName.gridy = 0;
		jobDescriptionPanel.add(jtfClientName, gbc_jtfClientName);

		JLabel jlblArchDescr = new JLabel("Architect:");
		GridBagConstraints gbc_jlblArchDescr = new GridBagConstraints();
		gbc_jlblArchDescr.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblArchDescr.insets = new Insets(0, 0, 5, 5);
		gbc_jlblArchDescr.gridx = 3;
		gbc_jlblArchDescr.gridy = 0;
		jobDescriptionPanel.add(jlblArchDescr, gbc_jlblArchDescr);

		jtfArchitect = new JTextField("");
		jtfArchitect.setEditable(false);
		GridBagConstraints gbc_jtfArchitect = new GridBagConstraints();
		gbc_jtfArchitect.anchor = GridBagConstraints.NORTH;
		gbc_jtfArchitect.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfArchitect.insets = new Insets(0, 0, 5, 0);
		gbc_jtfArchitect.gridx = 4;
		gbc_jtfArchitect.gridy = 0;
		jobDescriptionPanel.add(jtfArchitect, gbc_jtfArchitect);

		JLabel jlblDescr = new JLabel("Job Description:");
		GridBagConstraints gbc_jlblDescr = new GridBagConstraints();
		gbc_jlblDescr.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblDescr.insets = new Insets(0, 0, 5, 5);
		gbc_jlblDescr.gridx = 0;
		gbc_jlblDescr.gridy = 1;
		jobDescriptionPanel.add(jlblDescr, gbc_jlblDescr);
		jlblDescr.setHorizontalAlignment(SwingConstants.TRAILING);

		jtaJobDescription = new JTextArea("");
		jtaJobDescription.setLineWrap(true);
		jtaJobDescription.setWrapStyleWord(true);
		jtaJobDescription
				.setBackground(UIManager.getColor("Button.background"));
		jtaJobDescription.setEditable(false);

		jtaJobDescription.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null));
		GridBagConstraints gbc_jtaJobDescription = new GridBagConstraints();
		gbc_jtaJobDescription.gridwidth = 2;
		gbc_jtaJobDescription.anchor = GridBagConstraints.SOUTH;
		gbc_jtaJobDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtaJobDescription.insets = new Insets(0, 0, 5, 5);
		gbc_jtaJobDescription.gridx = 1;
		gbc_jtaJobDescription.gridy = 1;
		jobDescriptionPanel.add(jtaJobDescription, gbc_jtaJobDescription);

		JLabel jlblEngDescr = new JLabel("Engineer:");
		GridBagConstraints gbc_jlblEngDescr = new GridBagConstraints();
		gbc_jlblEngDescr.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblEngDescr.insets = new Insets(0, 0, 5, 5);
		gbc_jlblEngDescr.gridx = 3;
		gbc_jlblEngDescr.gridy = 1;
		jobDescriptionPanel.add(jlblEngDescr, gbc_jlblEngDescr);

		jtfEngineer = new JTextField("");
		jtfEngineer.setEditable(false);
		GridBagConstraints gbc_jtfEngineer = new GridBagConstraints();
		gbc_jtfEngineer.anchor = GridBagConstraints.NORTH;
		gbc_jtfEngineer.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEngineer.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEngineer.gridx = 4;
		gbc_jtfEngineer.gridy = 1;
		jobDescriptionPanel.add(jtfEngineer, gbc_jtfEngineer);

		JLabel jlblStatusDescr = new JLabel("Job Status:");
		GridBagConstraints gbc_jlblStatusDescr = new GridBagConstraints();
		gbc_jlblStatusDescr.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblStatusDescr.insets = new Insets(0, 0, 0, 5);
		gbc_jlblStatusDescr.gridx = 0;
		gbc_jlblStatusDescr.gridy = 2;
		jobDescriptionPanel.add(jlblStatusDescr, gbc_jlblStatusDescr);

		jtfJobStatus = new JTextField("");
		jtfJobStatus.setEditable(false);
		GridBagConstraints gbc_jtfJobStatus = new GridBagConstraints();
		gbc_jtfJobStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfJobStatus.insets = new Insets(0, 0, 0, 5);
		gbc_jtfJobStatus.gridx = 1;
		gbc_jtfJobStatus.gridy = 2;
		jobDescriptionPanel.add(jtfJobStatus, gbc_jtfJobStatus);

		jlblEditStatus = new JLabel(new ImageIcon(
				"Images/edit.png"));
		jlblEditStatus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null));
		jlblEditStatus.setToolTipText("Ammend Job Status");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		jobDescriptionPanel.add(jlblEditStatus, gbc_btnNewButton);

		jlblEditStatus.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent me) {
				jlblEditStatus = (JLabel) me.getSource();
				int jobId = OpenProject.getProjectToOpen();

				// Singleton pattern to ensure that one and only one
				// editStatus Screen is launched
				if (!instanceFlag) {
					editStatus = new EditStatus(jobId);
					MainScreen.desk.add(editStatus);
					instanceFlag = true;
				}
				EditStatus.setJobDetails(jobId);
				editStatus.setVisible(true);
				editStatus.toFront();
			}
		});

		JLabel jlblBuildDescr = new JLabel("Builder:");
		GridBagConstraints gbc_jlblBuildDescr = new GridBagConstraints();
		gbc_jlblBuildDescr.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblBuildDescr.insets = new Insets(0, 0, 0, 5);
		gbc_jlblBuildDescr.gridx = 3;
		gbc_jlblBuildDescr.gridy = 2;
		jobDescriptionPanel.add(jlblBuildDescr, gbc_jlblBuildDescr);
		jlblBuildDescr.setHorizontalAlignment(SwingConstants.TRAILING);

		jtfBuilder = new JTextField("");
		jtfBuilder.setEditable(false);
		GridBagConstraints gbc_jtfBuilder = new GridBagConstraints();
		gbc_jtfBuilder.anchor = GridBagConstraints.NORTH;
		gbc_jtfBuilder.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBuilder.gridx = 4;
		gbc_jtfBuilder.gridy = 2;
		jobDescriptionPanel.add(jtfBuilder, gbc_jtfBuilder);

		JPanel calcPanel = new JPanel();
		getContentPane().add(calcPanel, BorderLayout.EAST);
		calcPanel.setLayout(new BorderLayout(0, 0));
		
//		walls = new WallsTab();
//		//tabbedPane.add(walls, "Walls");
//		calculatePanel.add(walls);
		
		//externalTab = new ExternalTab();
		//calculatePanel.add(externalTab);
		
		JPanel calcTopPanel = new JPanel();
		calcPanel.add(calcTopPanel, BorderLayout.CENTER);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		calcTopPanel.add(tabbedPane);

		externalTab = new ExternalTab();
		tabbedPane.add(externalTab, "External");

		internalTab = new InternalTab();
		tabbedPane.add(internalTab, "Internal");
		
		walls = new WallsTab();
		tabbedPane.add(walls, "Walls");
		
		roofTab = new RoofTab();
		tabbedPane.add(roofTab, "Roof");
		
		JPanel calcLowerPanel = new JPanel();
		calcPanel.add(calcLowerPanel, BorderLayout.SOUTH);
		calcLowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		externalAdd = new ExternalAdd();
		calcLowerPanel.add(externalAdd);
		externalAdd.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		externalAdd.setVisible(false);
		
		wallCalc = new WallCalc();
		calcLowerPanel.add(wallCalc);
		wallCalc.setVisible(false);

		/**
		 * Create new JTable component and add the dTableModel to it
		 * 
		 */
		col0.setPreferredWidth(325);

		CurrencyTableCellRenderer currencyRenderer = new CurrencyTableCellRenderer();
		col1.setCellRenderer(currencyRenderer);
		col3.setCellRenderer(currencyRenderer);

		int ownX = 1250;
		int ownY = 800;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));

		this.setSize(ownX, ownY);
		this.setLocation(xPos, yPos);

		this.setSize(ownX, ownY);
		this.setTitle("Project Overview");
		this.setVisible(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
		
//		JFileChooser chooser = new JFileChooser();
//	    //FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
//	    //chooser.setFileFilter(filter);
//	    int returnVal = chooser.showSaveDialog(init);
//	    if(returnVal == JFileChooser.APPROVE_OPTION) {
//	       System.out.println("You chose to open this file: " +
//	            chooser.getSelectedFile().getName());
//	    }
	}

	public static JTable updateTable() {

		int jobId = OpenProject.getProjectToOpen();

		/**
		 * If table already has contents, clear the table contents
		 */
		if (dTableModel.getRowCount() > 0) {
			dTableModel.setRowCount(0);
			// while (dTableModel.getRowCount() > 0) {
			// dTableModel.removeRow(dTableModel.getRowCount() - 1);
			// }
		}
		/**
		 * Retrieve all materials for the selected job from the ResultSet rs
		 * Create new array and add relevant information for each row to the
		 * array
		 */
		try {
			rs = dbc.retrieveAllJobDetails(jobId);

			Object[] tempRow;

			while (rs.next()) {
//				tempRow = new Object[] { rs.getString(1),
//						df.format(rs.getDouble(2)), rs.getInt(3),
//						df.format(rs.getDouble(4)) };
//				dTableModel.addRow(tempRow);
				tempRow = new Object[] { rs.getString(3),
						df.format(rs.getDouble(4)), rs.getInt(5),
						df.format(rs.getDouble(6)) };
				dTableModel.addRow(tempRow);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return table;
	}

	public void deleteFromTable() {
		//System.out.println(dTableModel.);//dTableModel.get
	}

	public static void setHeaderDetails(int jobId) {
		try {
			rs = dbc.retrieveJobDetails(jobId);

			while (rs.next()) {
				jtfClientName.setText(rs.getString(1));
				jtaJobDescription.setText(rs.getString(2));
				jtfJobStatus.setText(rs.getString(3));
				jtfTotal.setText("" + df.format(rs.getDouble(4)));
				jtfArchitect.setText(rs.getString(5));
				jtfEngineer.setText(rs.getString(6));
				jtfBuilder.setText(rs.getString(7));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static int getCategoryToOpen() {
		return categoryToOpen;
	}

	public static void setCategoryToOpen(int categoryToOpen) {
		categoryToOpen = categoryToOpen;
	}
	
	public static void resetLowerPanes() {
		externalAdd.setVisible(false);
		wallCalc.setVisible(false);
	}
}

@SuppressWarnings("serial")
class CurrencyTableCellRenderer extends DefaultTableCellRenderer {
	public CurrencyTableCellRenderer() {
		setHorizontalAlignment(JLabel.RIGHT);
	}
}
