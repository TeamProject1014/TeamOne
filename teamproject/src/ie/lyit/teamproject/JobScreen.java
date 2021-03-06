package ie.lyit.teamproject;

import ie.lyit.teamproject.tabs.BlockBrickMortarCalc;
import ie.lyit.teamproject.tabs.CategorySelect;
import ie.lyit.teamproject.tabs.ExternalTab;
import ie.lyit.teamproject.tabs.Floor;
import ie.lyit.teamproject.tabs.InternalTab;
import ie.lyit.teamproject.tabs.MortarCalculator;
import ie.lyit.teamproject.tabs.PavingBedCalc;
import ie.lyit.teamproject.tabs.PlasteringQuantitiesCalc;
import ie.lyit.teamproject.tabs.Roof;
import ie.lyit.teamproject.tabs.StudWallCalc;
import ie.lyit.teamproject.tabs.SubBase;
import ie.lyit.teamproject.tabs.WallsTab;

import javax.swing.JInternalFrame;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.FlowLayout;

import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class JobScreen extends JInternalFrame {

	/**
	 * Declare Swing components
	 */
	private final JPanel tablePanel = new JPanel();
	private JPanel entirePanel;
	private JPanel totalPanel;
	private JPanel mainOptionsPanel;
	private JPanel jobDescriptionPanel;
	private JPanel calcPanel;
	private JPanel calcTopPanel;
	private JPanel calcLowerPanel;

	private JScrollPane scrollPane;
	public static JTable table;
	public static JobTableModel jobModel;

	private JTabbedPane tabbedPane;

	private final JLabel jlblTotal = new JLabel("SubTotal: \u20AC");
	private JLabel jlblEditStatus;
	private JLabel jlblCliDescr;
	private JLabel jlblArchDescr;
	private JLabel jlblDescr;
	private JLabel jlblEngDescr;
	private JLabel jlblStatusDescr;
	private JLabel jlblBuildDescr;

	private static JTextField jtfClientName;
	private static JTextField jtfTotal;
	private static JTextField jtfArchitect;
	private static JTextField jtfEngineer;
	protected static JTextField jtfJobStatus;
	private static JTextField jtfBuilder;
	private JTextField newMaterial;
	private JTextField newPrice;
	private JTextField newQuantity;
	private static JTextArea jtaJobDescription;
	private JButton jbtEdit;
	private JButton jbtDelete;
	private JButton jbtPDF;
	private JButton jbtExit;

	private static DecimalFormat df;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private static Object[][] jobArray;
	private static Object[][] displayArray;
	private static ResultSet rs;
	private static DBConnectionClass dbc;
	private WallsTab walls;
	public static WallCalc wallCalc;
	public static SubBase subBase;
	public static BlockBrickMortarCalc brickBlockMortar;
	public static MortarCalculator mortarCalc;
	public static Floor floorCalc;
	public static Roof roofCalc;
	public static StudWallCalc studWallCalc;
	public static PlasteringQuantitiesCalc plastQuantCalc;
	public static PavingBedCalc pavingBedCalc;

	private ExternalTab externalTab;
	public static MaterialSelect selectMaterial;
	private InternalTab internalTab;
	private RoofTab roofTab;
	private CategorySelect categoryTab;
	private EditStatus editStatus;
	private boolean instanceFlag = false;
	private static int categoryToOpen;

	/**
	 * Create the frame.
	 */
	public JobScreen(int jobId) {

		getContentPane().setLayout(new BorderLayout(0, 0));

		dbc = new DBConnectionClass();

		df = new DecimalFormat("###,###.00");

		entirePanel = new JPanel();
		getContentPane().add(entirePanel, BorderLayout.CENTER);
		entirePanel.setLayout(new BorderLayout(0, 0));

		jobModel = new JobTableModel();
		jobModel.data = updateJobTable(OpenProject.getProjectToOpen());

		tablePanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Project Costings",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		entirePanel.add(tablePanel, BorderLayout.CENTER);
		table = new JTable(jobModel);
		TableColumn col1 = table.getColumnModel().getColumn(0);
		TableColumn col2 = table.getColumnModel().getColumn(1);
		TableColumn col3 = table.getColumnModel().getColumn(2);
		TableColumn col4 = table.getColumnModel().getColumn(3);
		TableColumn col5 = table.getColumnModel().getColumn(4);
		col1.setPreferredWidth(150);
		col2.setPreferredWidth(250);
		col3.setPreferredWidth(85);
		col4.setPreferredWidth(85);
		col5.setPreferredWidth(85);

		tablePanel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane(table);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(630, 330));
		tablePanel.add(scrollPane, BorderLayout.CENTER);
		table.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent me) {
				table = (JTable) me.getSource();
				Point p = me.getPoint();
				int rowSelected = table.rowAtPoint(p);
				if (me.getClickCount() == 2) {
					runEdit();
				}
			}
		});

		totalPanel = new JPanel();
		totalPanel
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tablePanel.add(totalPanel, BorderLayout.SOUTH);
		totalPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		jbtEdit = new JButton("Edit");
		jbtEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (table.getSelectedRow() > -1) {
					runEdit();
				}
			}
		});
		totalPanel.add(jbtEdit);

		jbtDelete = new JButton("Delete");
		totalPanel.add(jbtDelete);
		jbtDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() > -1) {
					deleteFromTable();
				}
			}
		});
		totalPanel.add(jlblTotal);
		jlblTotal.setHorizontalAlignment(SwingConstants.RIGHT);

		jtfTotal = new JTextField();
		jtfTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfTotal.setEditable(false);
		totalPanel.add(jtfTotal);
		jtfTotal.setColumns(10);

		mainOptionsPanel = new JPanel();
		mainOptionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		mainOptionsPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Options",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		entirePanel.add(mainOptionsPanel, BorderLayout.SOUTH);

		jbtPDF = new JButton("PDF");
		jbtPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sendToPDF();
			}
		});
		mainOptionsPanel.add(jbtPDF);

		jbtExit = new JButton("Exit");
		mainOptionsPanel.add(jbtExit);
		jbtExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		jobDescriptionPanel = new JPanel();
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

		jlblCliDescr = new JLabel("Client Name:");
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

		jlblArchDescr = new JLabel("Architect:");
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

		jlblDescr = new JLabel("Job Description:");
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

		jlblEngDescr = new JLabel("Engineer:");
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

		jlblStatusDescr = new JLabel("Job Status:");
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

		jlblEditStatus = new JLabel(new ImageIcon("Images/edit.png"));
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

		jlblBuildDescr = new JLabel("Builder:");
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

		calcPanel = new JPanel();
		getContentPane().add(calcPanel, BorderLayout.EAST);
		calcPanel.setLayout(new BorderLayout(0, 0));

		calcTopPanel = new JPanel();
		calcPanel.add(calcTopPanel, BorderLayout.CENTER);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		calcTopPanel.add(tabbedPane);

		externalTab = new ExternalTab();
		tabbedPane.add(externalTab, "External");

		internalTab = new InternalTab();
		tabbedPane.add(internalTab, "Internal");

		walls = new WallsTab();
		tabbedPane.add(walls, "Walls");

		roofTab = new RoofTab();
		tabbedPane.add(roofTab, "Roof");

		categoryTab = new CategorySelect();
		tabbedPane.add(categoryTab, "Category");
		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				if (tabbedPane.getSelectedIndex() == 4) {
					JobScreen.resetLowerPanes();
					JobScreen.selectMaterial.setVisible(true);
				}
			}
		});

		calcLowerPanel = new JPanel();
		calcPanel.add(calcLowerPanel, BorderLayout.SOUTH);
		calcLowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		subBase = new SubBase();
		calcLowerPanel.add(subBase);
		subBase.setVisible(false);

		pavingBedCalc = new PavingBedCalc();
		calcLowerPanel.add(pavingBedCalc);
		pavingBedCalc.setVisible(false);

		selectMaterial = new MaterialSelect();
		calcLowerPanel.add(selectMaterial);
		selectMaterial.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		selectMaterial.setVisible(false);

		brickBlockMortar = new BlockBrickMortarCalc();
		calcLowerPanel.add(brickBlockMortar);
		brickBlockMortar.setVisible(false);

		wallCalc = new WallCalc();
		calcLowerPanel.add(wallCalc);
		wallCalc.setVisible(false);

		mortarCalc = new MortarCalculator();
		calcLowerPanel.add(mortarCalc);
		mortarCalc.setVisible(false);

		floorCalc = new Floor();
		calcLowerPanel.add(floorCalc);
		floorCalc.setVisible(false);

		roofCalc = new Roof();
		calcLowerPanel.add(roofCalc);
		roofCalc.setVisible(false);

		studWallCalc = new StudWallCalc();
		calcLowerPanel.add(studWallCalc);
		studWallCalc.setVisible(false);

		plastQuantCalc = new PlasteringQuantitiesCalc();
		calcLowerPanel.add(plastQuantCalc);
		plastQuantCalc.setVisible(false);

		/**
		 * Create new JTable component and add the dTableModel to it
		 * 
		 */

		int ownX = 1024;
		int ownY = 655;

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

	}

	public void sendToPDF() {
		try {

			String fileToSave = "";
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"PDF Files", "pdf");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showSaveDialog(chooser);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileToSave = chooser.getCurrentDirectory().getAbsolutePath()
						+ "/" + chooser.getSelectedFile().getName() + ".pdf";
				PDFWriter.setHeaderDetails(this.getHeaderDetails());
				PDFWriter.setTableContent(displayArray);
				PDFWriter.setFileNameToSave(fileToSave);
				PDFWriter.writeFile();
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}

	// Edit a table row
	public void runEdit() {
		// Create a dialog box to edit a selected row in the table
		JPanel main = new JPanel(new BorderLayout(5, 5));

		JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
		labels.add(new JLabel("Description", SwingConstants.RIGHT));
		labels.add(new JLabel("Price", SwingConstants.RIGHT));
		labels.add(new JLabel("Quantity", SwingConstants.RIGHT));
		main.add(labels, BorderLayout.WEST);

		// Get data from table
		// System.out.println(table.getSelectedRow());
		int mat_id = (int) jobArray[table.getSelectedRow()][1];
		int job_id = OpenProject.getProjectToOpen();
		// System.out.println("Editing entry with material_id: " + mat_id
		// + "\nFrom job no: " + job_id);

		// Get material
		String material = dbc.getMaterial(mat_id);

		// Show dialog
		JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
		controls.add(newMaterial = new JTextField());
		controls.add(newPrice = new JTextField());
		controls.add(newQuantity = new JTextField());
		main.add(controls, BorderLayout.CENTER);

		newMaterial.setEditable(false);
		newMaterial.setText(material);

		int option = JOptionPane.showConfirmDialog(new JFrame(), main,
				"Edit Material", JOptionPane.DEFAULT_OPTION);

		// If ok is pressed
		if (option == JOptionPane.OK_OPTION) {
			try {
				// Get user input
				double inputPrice = Double.parseDouble(newPrice.getText());
				double inputQuantity = Double
						.parseDouble(newQuantity.getText());

				// Edit row
				dbc.editItemFromJob(job_id, mat_id, inputQuantity, inputPrice);
				jobModel.data = JobScreen.updateJobTable(job_id);
				table.repaint();
				table.revalidate();
				setHeaderDetails(OpenProject.getProjectToOpen());
			} catch (NumberFormatException e) {
				e.getMessage();
				JOptionPane.showMessageDialog(new JFrame(),
						"Enter price AND quantity");
			}
		}
	}

	public static Object[][] updateJobTable(int job_id) {

		int count = 0;
		ResultSet rs;

		try {
			count = 0;
			rs = dbc.retrieveAllJobDetails(job_id);
			while (rs.next()) {
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		displayArray = new Object[count][5];
		jobArray = new Object[count][7]; // Also includes job_id and material_id
		try {
			rs = dbc.retrieveAllJobDetails(job_id);
			count = 0;

			boolean categorySet = false;

			while (rs.next()) {

				jobArray[count][0] = rs.getInt(1);
				jobArray[count][1] = rs.getInt(2);
				if (!categorySet) {
					jobArray[count][2] = displayArray[count][0] = rs
							.getString(3);
					categorySet = true;
				} else {
					jobArray[count][2] = rs.getString(3);
					if (jobArray[count][2].equals(jobArray[count - 1][2])) {
						displayArray[count][0] = "";
					} else {
						displayArray[count][0] = jobArray[count][2];
					}

				}
				jobArray[count][3] = displayArray[count][1] = rs.getString(4);
				jobArray[count][4] = displayArray[count][2] = rs.getDouble(5);
				jobArray[count][5] = displayArray[count][3] = rs.getInt(6);
				jobArray[count][6] = displayArray[count][4] = rs.getDouble(7);

				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return displayArray;
	}

	public void deleteFromTable() {
		// System.out.println(table.getSelectedRow());
		int mat_id = (int) jobArray[table.getSelectedRow()][1];
		int job_id = OpenProject.getProjectToOpen();
		// System.out.println("deleting material with material_id: " + mat_id
		// + "\nFrom job no: " + job_id);
		dbc.deleteItemFromJob(job_id, mat_id);
		jobModel.data = JobScreen.updateJobTable(job_id);
		setHeaderDetails(OpenProject.getProjectToOpen());
		table.repaint();
		table.revalidate();
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

	public String[] getHeaderDetails() {
		String[] headerArray = new String[6];
		headerArray[0] = jtfClientName.getText();
		headerArray[1] = jtaJobDescription.getText();
		headerArray[2] = jtfArchitect.getText();
		headerArray[3] = jtfEngineer.getText();
		headerArray[4] = jtfBuilder.getText();
		headerArray[5] = jtfTotal.getText();

		return headerArray;
	}

	public static int getCategoryToOpen() {
		return categoryToOpen;
	}

	public static void setCategoryToOpen(int catToOpen) {
		categoryToOpen = catToOpen;
	}

	public static void resetLowerPanes() {
		selectMaterial.setVisible(false);
		wallCalc.setVisible(false);
		subBase.setVisible(false);
		brickBlockMortar.setVisible(false);
		mortarCalc.setVisible(false);
		floorCalc.setVisible(false);
		roofCalc.setVisible(false);
		studWallCalc.setVisible(false);
		plastQuantCalc.setVisible(false);
		pavingBedCalc.setVisible(false);
	}

	/**
	 * see
	 * http://stackoverflow.com/questions/12348932/change-background-color-of
	 * -one-cell-in-jtable/12352838#12352838
	 * 
	 * 
	 */

	public class JobTableModel extends AbstractTableModel {

		private String[] columnNames = { "Category", "Description", "Price",
				"Quantity", "Total" };

		public Object[][] data;

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return data.length;
		}

		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
			/**
			 * The columns below were set to allow editing to be carried out
			 * within the table
			 */
			// if (col < 2 || col == 4)
			// return false;
			// else
			// return true;
		}

		@Override
		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}
}

// @SuppressWarnings("serial")
// class CurrencyTableCellRenderer extends DefaultTableCellRenderer {
// public CurrencyTableCellRenderer() {
// setHorizontalAlignment(JLabel.RIGHT);
// }
// }
