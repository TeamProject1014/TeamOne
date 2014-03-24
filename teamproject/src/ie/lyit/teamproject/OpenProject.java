package ie.lyit.teamproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class OpenProject extends JInternalFrame {

	private JPanel contentPanel = new JPanel();

	private DBConnectionClass dbc;

	private ResultSet rs;
	private JLabel jlblClient;

	@SuppressWarnings("rawtypes")
	private JComboBox jcboClient;

	private JButton jbtOpen;
	private JButton jbtCancel;
	private JScrollPane scrollPane;
	private JTable table;
	private static Object[][] dbinfo;
	private static Object[] columns = { "Client Name", "Job Description" };
	protected static JobScreen jobScreen;
	private static int projectToOpen = -1;
	private int[] idArray;
	private String[] clientArray;
	private String[] descriptionArray;
	boolean instanceFlag = false;

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

	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();

	/**
	 * Create the JInternalFrame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public OpenProject() {

		dbc = new DBConnectionClass();
		int count = 0;

		try {
			count = 0;
			rs = dbc.retrieveClientJobs();
			while (rs.next()) {
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		idArray = new int[count];
		clientArray = new String[count];
		descriptionArray = new String[count];

		try {
			rs = dbc.retrieveClientJobs();

			Object[] tempRow;

			
			/**
			 * LW - fix/tidy this - multidimensional array????
			 */
			idArray = new int[count];
			clientArray = new String[count];
			descriptionArray = new String[count];
			count = 0;

			while (rs.next()) {
				int nextId = rs.getInt(1);
				String nextClient = rs.getString(2);
				String nextDescription = rs.getString(3);
				idArray[count] = nextId;
				clientArray[count] = nextClient;
				descriptionArray[count] = nextDescription;

				tempRow = new Object[] { nextClient, nextDescription };
				dTableModel.addRow(tempRow);
				count++;
			}

			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		table = new JTable(dTableModel);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBounds(10, 25, 500, 200);

		ListenerClass listener = new ListenerClass();

		table.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent me) {
				table = (JTable) me.getSource();
				Point p = me.getPoint();
				int rowSelected = table.rowAtPoint(p);
				if (me.getClickCount() == 2) {

					setVisible(false);
					setProjectToOpen(idArray[rowSelected]);

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

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(15, 15, 500, 175);

		contentPanel.add(scrollPane);

		jbtOpen = new JButton("Open");
		jbtOpen.setBounds(337, 214, 85, 20);
		jbtOpen.setToolTipText("Open Selected Job");
		jbtOpen.addActionListener(listener);
		contentPanel.add(jbtOpen);

		jbtCancel = new JButton("Cancel");
		jbtCancel.setBounds(428, 214, 85, 20);
		jbtCancel.setToolTipText("Cancel");
		jbtCancel.addActionListener(listener);
		contentPanel.add(jbtCancel);

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
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Open")) {
				int rowSelected = table.getSelectedRow();

				if (rowSelected == -1) {
					JOptionPane.showConfirmDialog(null,
							"Please Select a Job to Open", "No Job Selected",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE);
				} else {
					setVisible(false);
					setProjectToOpen(idArray[rowSelected]);

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
			}
			else if (e.getActionCommand().equals("Cancel")) {
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
