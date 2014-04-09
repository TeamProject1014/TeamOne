package ie.lyit.teamproject;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class ExternalAdd extends JPanel {

	private static DBConnectionClass dbc;
	private ResultSet rs;

	private JTable table;
	protected static JobScreen jobScreen;
	private static int projectToOpen = -1;
	private static int category_id;

	private static Object[][] catMatArray;
	private static Object[][] displayArray;
	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	private JTextField jtfQuantity;
	private JTextField jtfPrice;
	private static ClientJobTableModel clientModel;

	public ExternalAdd() {

		/**
		 * Instantiate variables
		 */
		dbc = new DBConnectionClass();
		int count = 0;
		category_id = JobScreen.getCategoryToOpen();
		System.out.println(category_id);

		/**
		 * Retrieve the number of jobs that currently exist by iterating through
		 * jobs data and storing value in count variable
		 */
		JPanel entirePanel = new JPanel();
		entirePanel.setLayout(new BorderLayout(0, 0));
	
		setLayout(new BorderLayout());
		add(entirePanel, BorderLayout.CENTER);

		JPanel tablePanel = new JPanel();
		tablePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Select Material", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tablePanel.setLayout(new BorderLayout(0, 0));
		entirePanel.add(tablePanel, BorderLayout.CENTER);

		clientModel = new ClientJobTableModel();
		clientModel.data = updateMaterialTable(2);
		table = new JTable(clientModel);
		
		TableColumn col1 = table.getColumnModel().getColumn(0);
		col1.setMaxWidth(300);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(250, 250));
		tablePanel.add(scrollPane);

		JPanel optionsPanel = new JPanel();
		optionsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		entirePanel.add(optionsPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_optionsPanel = new GridBagLayout();
		gbl_optionsPanel.columnWidths = new int[] { 0, 74, 0 };
		gbl_optionsPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_optionsPanel.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_optionsPanel.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		optionsPanel.setLayout(gbl_optionsPanel);

		JLabel lblNewLabel = new JLabel("Quantity:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		optionsPanel.add(lblNewLabel, gbc_lblNewLabel);

		jtfQuantity = new JTextField();
		GridBagConstraints gbc_jtfQuantity = new GridBagConstraints();
		gbc_jtfQuantity.insets = new Insets(0, 0, 5, 0);
		gbc_jtfQuantity.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfQuantity.gridx = 1;
		gbc_jtfQuantity.gridy = 0;
		optionsPanel.add(jtfQuantity, gbc_jtfQuantity);
		jtfQuantity.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Price:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		optionsPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfPrice = new JTextField();
		GridBagConstraints gbc_jtfPrice = new GridBagConstraints();
		gbc_jtfPrice.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrice.gridx = 1;
		gbc_jtfPrice.gridy = 1;
		optionsPanel.add(jtfPrice, gbc_jtfPrice);
		jtfPrice.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int job_id = OpenProject.getProjectToOpen();
				int mat_id = 0;
				String sel = (String)table.getValueAt(table.getSelectedRow(),  0);
				int quant = Integer.parseInt(jtfQuantity.getText());
				double price = Double.parseDouble(jtfPrice.getText());
				double total = (quant * price);
				
				for (int i = 0; i < displayArray.length; i++)
					if (catMatArray[i][2].equals(sel))
						mat_id = (int) catMatArray[i][1];
				
				dbc.addMaterialToJob(job_id, mat_id, quant, price, total);
				//JobScreen.updateTable();
				//JobScreen.jobModel.data.equals(null);
				JobScreen.jobModel.data = JobScreen.updateJobTable(job_id);
				JobScreen.table.repaint();
				JobScreen.table.revalidate();
				JobScreen.setHeaderDetails(OpenProject.getProjectToOpen());
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		optionsPanel.add(btnNewButton, gbc_btnNewButton);
		
	}

	public static Object[][] updateMaterialTable(int cat_id) {
		int count = 0;
		ResultSet rs;

		try {
			count = 0;
			rs = dbc.retrieveCategoryMaterial(cat_id);
			while (rs.next()) {
				count++;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		/**
		 * Instantiate multidimensional jobArray & displayArray with correct
		 * number of rows, obtained from count variable
		 */
		displayArray = new Object[count][1];
		catMatArray = new Object[count][3];
		try {
			rs = dbc.retrieveCategoryMaterial(cat_id);
			count = 0;

			while (rs.next()) {
				catMatArray[count][0] = rs.getInt(1);
				catMatArray[count][1] = rs.getInt(2);
				catMatArray[count][2] = displayArray[count][0] = rs
						.getString(3);
				count++;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return displayArray;
	}

	class ClientJobTableModel extends AbstractTableModel {

		private String[] columnNames = { "Material Description" };

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
		public boolean isCellEditable(int row, int col) {
			return false;
		}

		@Override
		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}

	public static int getCategory_id() {
		return category_id;
	}

	public static void setCategory_id(int cat_id) {
		category_id = cat_id;
	}
}
