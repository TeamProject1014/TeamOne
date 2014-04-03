package ie.lyit.teamproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class OpenProject extends JInternalFrame {

	private DBConnectionClass dbc;
	private ResultSet rs;
	private JPanel contentPanel;
	private JPanel optionsPanel;
	private JButton jbtOpen;
	private JButton jbtCancel;
	private JScrollPane scrollPane;
	private JTable table;
	protected static JobScreen jobScreen;
	private static int projectToOpen = -1;
	private Object[][] jobArray;
	private Object[][] displayArray;
	static boolean instanceFlag = false;
	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
		
	public OpenProject() {		
		
		/**
		 * Instantiate variables 
		 */
		dbc = new DBConnectionClass();
		int count = 0;

		/**
		 * Retrieve the number of jobs that currently exist by iterating through
		 * jobs data and storing value in count variable 
		 */
		try {
			count = 0;
			rs = dbc.retrieveClientJobs();
			while (rs.next()) {
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		/**
		 * Instantiate multidimensional jobArray & displayArray with correct number of rows, obtained from count variable
		 */
		displayArray = new Object[count][2];
		jobArray = new Object[count][3];
		try {
			rs = dbc.retrieveClientJobs();
			count = 0;

			while (rs.next()) {
				jobArray[count][0] = rs.getInt(1);
				jobArray[count][1] = displayArray[count][0] = rs.getString(2);
				jobArray[count][2] = displayArray[count][1] = rs.getString(3);
				count++;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Current Projects", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		ClientJobTableModel clientModel = new ClientJobTableModel();
		clientModel.data = updateClientJobTable();//displayArray;
		table = new JTable(clientModel);
		
		/**
		 * Set table column widths
		 */
		TableColumn col1 = table.getColumnModel().getColumn(0);
		col1.setPreferredWidth(150);

		TableColumn col2 = table.getColumnModel().getColumn(1);
		col2.setPreferredWidth(340);

		table.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent me) {
				table = (JTable) me.getSource();
				Point p = me.getPoint();
				int rowSelected = table.rowAtPoint(p);
				if (me.getClickCount() == 2) {
					setVisible(false);
					setProjectToOpen((int) jobArray[rowSelected][0]);

					/**
					 * Singleton pattern to ensure that one and only one
					 * JobScreen is launched 
					 */
					if (!instanceFlag) {
						jobScreen = new JobScreen(OpenProject.getProjectToOpen());
						MainScreen.desk.add(jobScreen);
						instanceFlag = true;
					}
					//JobScreen.updateTable();
					
//					JobScreen.jobModel.data = JobScreen.updateJobTable(OpenProject.getProjectToOpen());
//					JobScreen.table.repaint();
//					JobScreen.table.revalidate();
//					JobScreen.setHeaderDetails(OpenProject.getProjectToOpen());
										
					JobScreen.jobModel.data = JobScreen.updateJobTable(OpenProject.getProjectToOpen());
					JobScreen.table.repaint();
					JobScreen.table.revalidate();
					JobScreen.setHeaderDetails(OpenProject.getProjectToOpen());
					jobScreen.setVisible(true);
					jobScreen.toFront();
				}
			}
		});

		contentPanel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setSize(150, 150);

		contentPanel.add(scrollPane, BorderLayout.CENTER);

		optionsPanel = new JPanel();
		optionsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(optionsPanel, BorderLayout.SOUTH);
		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		jbtOpen = new JButton("Open");
		optionsPanel.add(jbtOpen);
		jbtOpen.setToolTipText("Open Selected Job");

		jbtCancel = new JButton("Cancel");
		optionsPanel.add(jbtCancel);
		jbtCancel.setToolTipText("Cancel");

		ListenerClass listener = new ListenerClass();

		jbtCancel.addActionListener(listener);
		jbtOpen.addActionListener(listener);

		int ownX = 550;
		int ownY = 275;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));

		this.setSize(ownX, ownY);
		this.setLocation(xPos, yPos);

		this.setTitle("Open Project");
		this.setVisible(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
	}
	
	public static Object[][] updateClientJobTable() {
		int count = 0;
		ResultSet rs;
		DBConnectionClass dbc = new DBConnectionClass();
		Object[][] displayArray;
		Object[][] jobArray;
		
		try {
			count = 0;
			rs = dbc.retrieveClientJobs();
			while (rs.next()) {
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		/**
		 * Instantiate multidimensional jobArray & displayArray with correct number of rows, obtained from count variable
		 */
		displayArray = new Object[count][2];
		jobArray = new Object[count][3];
		try {
			rs = dbc.retrieveClientJobs();
			count = 0;

			while (rs.next()) {
				jobArray[count][0] = rs.getInt(1);
				jobArray[count][1] = displayArray[count][0] = rs.getString(2);
				jobArray[count][2] = displayArray[count][1] = rs.getString(3);
				count++;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return displayArray;
	}
	
	class ClientJobTableModel extends AbstractTableModel {
			
		private String[] columnNames = { "Client Name", "Job Description" };

		private Object[][] data;
		
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
		public boolean isCellEditable (int row, int col) {
			return false;
		}
		
		@Override
		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}

	class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Open")) {
				int rowSelected = table.getSelectedRow();

				if (rowSelected == -1) {
					JOptionPane.showConfirmDialog(null,
							"Please Select a Job to Open", "No Job Selected",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.WARNING_MESSAGE);
				} else {
					setVisible(false);
					setProjectToOpen((int) jobArray[rowSelected][0]);

					/**
					 * Singleton pattern to ensure that one and only one
					 * JobScreen is launched 
					 */
					if (!instanceFlag) {
						jobScreen = new JobScreen(OpenProject.getProjectToOpen());
						MainScreen.desk.add(jobScreen);
						instanceFlag = true;
					}
					//JobScreen.updateTable();
					JobScreen.updateJobTable(OpenProject.getProjectToOpen());
					JobScreen.setHeaderDetails(OpenProject.getProjectToOpen());
					jobScreen.setVisible(true);
					jobScreen.toFront();
				}
			} else if (e.getActionCommand().equals("Cancel")) {
				setVisible(false);
			}
		}
	}

	public static int getProjectToOpen() {
		return projectToOpen;
	}

	public static void setProjectToOpen(int projectToOpen) {
		OpenProject.projectToOpen = projectToOpen;
	}
}
