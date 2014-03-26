package ie.lyit.teamproject;

import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
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
	private static Object[][] dbinfo;
	private static Object[] columns = { "Client Name", "Job Description" };
	protected static JobScreen jobScreen;
	private static int projectToOpen = -1;
	private Object[][] jobArray;
	private boolean instanceFlag = false;
	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();

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
	
	public OpenProject() {

		// Instantiate variables
		contentPanel = new JPanel();
		dbc = new DBConnectionClass();
		int count = 0;

		// Retrieve the number of jobs that currently exist by iterating through
		// jobs data and storing value in count variable
		try {
			count = 0;
			rs = dbc.retrieveClientJobs();
			while (rs.next()) {
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// Instantiate multidimensional jobArray with correct number of rows
		jobArray = new Object[count][3];
		try {
			rs = dbc.retrieveClientJobs();

			Object[] tempRow;

			count = 0;

			while (rs.next()) {
				jobArray[count][0] = rs.getInt(1);
				jobArray[count][1] = rs.getString(2);
				jobArray[count][2] = rs.getString(3);

				tempRow = new Object[] { jobArray[count][1], jobArray[count][2] };
				dTableModel.addRow(tempRow);
				count++;
			}

			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Current Projects", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			getContentPane().add(contentPanel, BorderLayout.CENTER);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		table = new JTable(dTableModel);
		table.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//table.setBounds(10, 25, 200, 200);

		table.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent me) {
				table = (JTable) me.getSource();
				Point p = me.getPoint();
				int rowSelected = table.rowAtPoint(p);
				if (me.getClickCount() == 2) {
					setVisible(false);
					setProjectToOpen((int) jobArray[rowSelected][0]);

					// Singleton pattern to ensure that one and only one
					// JobScreen is launched
					if (!instanceFlag) {
						jobScreen = new JobScreen(OpenProject
								.getProjectToOpen());
						MainScreen.desk.add(jobScreen);
						instanceFlag = true;
					}
					JobScreen.updateTable();
					JobScreen.setHeaderDetails(OpenProject.getProjectToOpen());
					jobScreen.setVisible(true);
					jobScreen.toFront();
				}
			}
		});

		TableColumn col1 = table.getColumnModel().getColumn(0);
		col1.setPreferredWidth(150);

		TableColumn col2 = table.getColumnModel().getColumn(1);
		col2.setPreferredWidth(340);
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

					// Singleton pattern to ensure that one and only one
					// JobScreen is launched
					if (!instanceFlag) {
						jobScreen = new JobScreen(
								OpenProject.getProjectToOpen());
						MainScreen.desk.add(jobScreen);
						instanceFlag = true;
					}
					JobScreen.updateTable();
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
