package ie.lyit.teamproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
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
	private JButton jbtExit;
	private JScrollPane scrollPane;
	private JTable table;
	private static Object[][] dbinfo;
	private static Object[] columns = { "Client Name", "Job Description" };
	protected static ProjectOverview projectOverview;
	private static int projectToOpen = -1;
	private int[] idArray;
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

		try {
			int count = 0;
			rs = dbc.retrieveClientJobs();
			while (rs.next()) {
				count++;
			}
			rs = dbc.retrieveClientJobs();

			Object[] tempRow;

			idArray = new int[count];

			count = 0;
			while (rs.next()) {
				int nextId = rs.getInt(1);
				idArray[count] = nextId;
				count++;

				tempRow = new Object[] { rs.getString(2), rs.getString(3) };
				dTableModel.addRow(tempRow);
			}
			// System.out.println(idArray[0] + ", " + idArray[1]);

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

		TableColumn col1 = table.getColumnModel().getColumn(0);
		col1.setPreferredWidth(150);

		TableColumn col2 = table.getColumnModel().getColumn(1);
		col2.setPreferredWidth(340);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(15, 15, 500, 175);

		contentPanel.add(scrollPane);

		jbtOpen = new JButton("Open");
		jbtOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				int temp = table.getSelectedRow();
				setProjectToOpen(idArray[temp]);

				/**
				 * Liam - current edit
				 * Still need to revalidate and repaint table properly if different job is chosen
				 */
				if (!instanceFlag) {
					projectOverview = new ProjectOverview(OpenProject
							.getProjectToOpen());
					MainScreen.desk.add(projectOverview);
					instanceFlag = true;
				}
				ProjectOverview.table.revalidate();
				ProjectOverview.table.repaint();
				projectOverview.setVisible(true);

			}
		});
		jbtOpen.setBounds(337, 214, 85, 20);
		contentPanel.add(jbtOpen);

		jbtExit = new JButton("Exit");
		jbtExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		jbtExit.setBounds(428, 214, 85, 20);
		contentPanel.add(jbtExit);

		int ownX = 340;
		int ownY = 150;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));

		this.setSize(550, 275);
		this.setLocation(xPos, yPos);

		this.setTitle("Open Project");
		this.setVisible(true);
		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
	}

	public static int getProjectToOpen() {
		return projectToOpen;
	}

	public static void setProjectToOpen(int projectToOpen) {
		OpenProject.projectToOpen = projectToOpen;
	}
}
