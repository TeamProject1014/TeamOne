package ie.lyit.teamproject;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class ProjectOverview extends JInternalFrame{
	
	private JLabel jlblCliName;
	private JLabel jlblDesc;
	private JLabel jlblArch;
	private JLabel jlblEng;
	private JLabel jlblBuild;
	//private JLabel jlblStatus;
	
	private JPanel jobPanel;	
	
	private JTextField jtfTotal;		
	private JTextField jtfCliName;	
	private JTextField jtfArch;
	private JTextField jtfEng;
	private JTextField jtfBuild;	
	private JTextArea jtaDesc;	
	public static JTable table;
	
	private DecimalFormat df;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private static Object[][] dbinfo;	
	private static Object[] columns = { "Material ID", "Description", "Price", "Quantity" };
	private static ResultSet rs;
	private DBConnectionClass dbc;
	//public static String pageTitle;
	
	private static DefaultTableModel dTableModel = new DefaultTableModel(dbinfo, columns){
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
	
	public ProjectOverview(int jobId) {
		
		getContentPane().setLayout(new BorderLayout());
		
		dbc = new DBConnectionClass();
		
		df = new DecimalFormat("###,###.00");
			
		setTitle("Project Overview");
		getContentPane().setLayout(null);
		
		jobPanel = new JPanel();
		jobPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Project Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jobPanel.setBounds(10, 11, 697, 99);
		getContentPane().add(jobPanel);
		jobPanel.setLayout(null);
		
		jlblCliName = new JLabel("Client Name:");
		jlblCliName.setBounds(10, 18, 86, 14);
		jobPanel.add(jlblCliName);
		
		jtfCliName = new JTextField();
		jtfCliName.setBounds(106, 15, 86, 20);
		jobPanel.add(jtfCliName);
		jtfCliName.setColumns(10);
		
		jlblArch = new JLabel("Architect:");
		jlblArch.setBounds(202, 18, 66, 14);
		jobPanel.add(jlblArch);
		
		jtfArch = new JTextField();
		jtfArch.setColumns(10);
		jtfArch.setBounds(259, 15, 105, 20);
		jobPanel.add(jtfArch);
		
		jlblEng = new JLabel("Engineer:");
		jlblEng.setBounds(538, 21, 53, 14);
		jobPanel.add(jlblEng);
		
		jtfEng = new JTextField();
		jtfEng.setColumns(10);
		jtfEng.setBounds(601, 18, 86, 20);
		jobPanel.add(jtfEng);
		
		jlblBuild = new JLabel("Builder:");
		jlblBuild.setBounds(374, 18, 58, 14);
		jobPanel.add(jlblBuild);
		
		jtfBuild = new JTextField();
		jtfBuild.setColumns(10);
		jtfBuild.setBounds(442, 15, 86, 20);
		jobPanel.add(jtfBuild);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(355, 43, 332, 44);
		jobPanel.add(panel_3);
		panel_3.setBorder(new TitledBorder(null, "Job Status", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_3.setLayout(null);
		
		JRadioButton rdbtnPending = new JRadioButton("Pending");
		rdbtnPending.setBounds(22, 14, 93, 23);
		panel_3.add(rdbtnPending);
		
		JRadioButton rdbtnApproved = new JRadioButton("Approved");
		rdbtnApproved.setBounds(117, 14, 106, 23);
		panel_3.add(rdbtnApproved);
		
		JRadioButton rdbtnDeclined = new JRadioButton("Declined");
		rdbtnDeclined.setBounds(225, 14, 101, 23);
		panel_3.add(rdbtnDeclined);
		
		jlblDesc = new JLabel("Job Description:");
		jlblDesc.setBounds(10, 43, 105, 14);
		jobPanel.add(jlblDesc);
		
		jtaDesc = new JTextArea();
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		jtaDesc.setBorder(BorderFactory.createCompoundBorder(border,
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		jtaDesc.setLineWrap(true);
		jtaDesc.setBounds(106, 46, 239, 44);
		jobPanel.add(jtaDesc);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Overview", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(10, 114, 697, 391);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		/**
		 * Retrieve all materials for the selected job from the ResultSet rs
		 * Create new array and add relevant information for each row to the array 
		 */
		try {
			//rs = dbc.retrieveAllJobDetails(client_id);
			rs = dbc.retrieveAllJobDetails(jobId);

			Object[] tempRow;
						
			while (rs.next()) {
				tempRow = new Object[] { rs.getInt(1), rs.getString(2),
						df.format(rs.getDouble(3)), rs.getInt(4) };
				dTableModel.addRow(tempRow);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		/**
		 * Create new JTable component and add the dTAbleModel to it
		 * 
		 */
		table = new JTable(dTableModel);				
		table.setAutoCreateRowSorter(true);		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBounds(10, 24, 677, 328);
		
		TableColumn col1 = table.getColumnModel().getColumn(1);
		col1.setPreferredWidth(400);
		
		CurrencyTableCellRenderer currencyRenderer = new CurrencyTableCellRenderer();
		
		TableColumn col2 = table.getColumnModel().getColumn(2); 
		col2.setCellRenderer(currencyRenderer);		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(15, 15, 672, 340);
		
		panel_1.add(scrollPane);
		
		JLabel lblSubtotal = new JLabel("Sub-Total:       €");
		lblSubtotal.setBounds(505, 363, 86, 14);
		panel_1.add(lblSubtotal);
		
		jtfTotal = new JTextField();
		jtfTotal.setBounds(601, 360, 86, 20);
		panel_1.add(jtfTotal);
		jtfTotal.setColumns(10);
		double total = dbc.retrieveJobTotal(jobId);
		jtfTotal.setText("" + df.format(total));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Options", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(10, 505, 697, 55);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(177, 21, 89, 23);
		panel_2.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(276, 21, 89, 23);
		panel_2.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(375, 21, 89, 23);
		panel_2.add(btnEdit);
		
		JButton jbtExit = new JButton("Exit");
		jbtExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		jbtExit.setBounds(474, 21, 89, 23);
		panel_2.add(jbtExit);
		
		int ownX = 750;
		int ownY = 600;
		
		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int)((screenX / 2) - (ownX / 2)) ;
		int yPos = (int)((screenY / 2) - (ownY / 2));
		
		this.setSize(ownX, ownY);
		this.setLocation(xPos, yPos);
		
		this.setSize(ownX, ownY);
		this.setTitle("Project Overview");
		this.setVisible(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
	}
}

@SuppressWarnings("serial")
class CurrencyTableCellRenderer extends DefaultTableCellRenderer {
	public CurrencyTableCellRenderer() {
		setHorizontalAlignment(JLabel.RIGHT);
	}
}
