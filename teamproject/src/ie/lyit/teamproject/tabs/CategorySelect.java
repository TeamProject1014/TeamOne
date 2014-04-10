package ie.lyit.teamproject.tabs;

import ie.lyit.teamproject.AddCategory;
import ie.lyit.teamproject.DBConnectionClass;
import ie.lyit.teamproject.JobScreen;
import ie.lyit.teamproject.MainScreen;
import ie.lyit.teamproject.MaterialSelect;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Point;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.FlowLayout;

public class CategorySelect extends JPanel {

	private static DBConnectionClass dbc;
	private ResultSet rs;

	private JTable table;
	protected static JobScreen jobScreen;
	private static int projectToOpen = -1;
	private static int category_id;

	private static Object[][] categoryArray;
	private static Object[][] displayArray;
	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	private static CategoryTableModel categoryModel;

	public CategorySelect() {

		/**
		 * Instantiate variables
		 */
		dbc = new DBConnectionClass();
		//int count = 0;
		category_id = JobScreen.getCategoryToOpen();

		/**
		 * Retrieve the number of jobs that currently exist by iterating through
		 * jobs data and storing value in count variable
		 */
		JPanel entirePanel = new JPanel();
		entirePanel.setLayout(new BorderLayout(0, 0));

		setLayout(new BorderLayout());
		add(entirePanel, BorderLayout.CENTER);

		JPanel tablePanel = new JPanel();
		tablePanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Select Caetgory",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tablePanel.setLayout(new BorderLayout(0, 0));
		entirePanel.add(tablePanel, BorderLayout.CENTER);

		categoryModel = new CategoryTableModel();
		categoryModel.data = updateCategoryTable(2);
		table = new JTable(categoryModel);

		TableColumn col1 = table.getColumnModel().getColumn(0);
		col1.setMaxWidth(300);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(250, 150));
		tablePanel.add(scrollPane);
		
		table.addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent me) {
			table = (JTable) me.getSource();
			Point p = me.getPoint();
			int rowSelected = table.rowAtPoint(p);
			if (me.getClickCount() == 2) {
				rowSelected = table.getSelectedRow();
				MainScreen.setCategoryToDisplay((int) categoryArray[rowSelected][0]);
				MaterialSelect.clientModel.data = MaterialSelect.updateMaterialTable((int) categoryArray[rowSelected][0]);
				MaterialSelect.table.repaint();
				MaterialSelect.table.revalidate();
			}
			}
		});

		JPanel optionsPanel = new JPanel();
		optionsPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Options",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		entirePanel.add(optionsPanel, BorderLayout.SOUTH);
		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton jbtSelect = new JButton("Select");
		optionsPanel.add(jbtSelect);
		jbtSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowSelected = table.getSelectedRow();
				MainScreen.setCategoryToDisplay((int) categoryArray[rowSelected][0]);
				MaterialSelect.clientModel.data = MaterialSelect.updateMaterialTable((int) categoryArray[rowSelected][0]);
				MaterialSelect.table.repaint();
				MaterialSelect.table.revalidate();
			}
		});

		JButton jbtAdd = new JButton("Add");
		jbtAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!MainScreen.addCategoryInstanceFlag) {
					MainScreen.addCategory = new AddCategory();
					MainScreen.desk.add(MainScreen.addCategory);
					MainScreen.addCategoryInstanceFlag = true;
				}
				MainScreen.addCategory.setVisible(true);
				MainScreen.addCategory.toFront();
			}
		});
		optionsPanel.add(jbtAdd);

	}

	public static Object[][] updateCategoryTable(int cat_id) {
		int count = 0;
		ResultSet rs;

		try {
			count = 0;
			rs = dbc.retrieveCategory();
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
		categoryArray = new Object[count][2];
		try {
			rs = dbc.retrieveCategory();
			count = 0;

			while (rs.next()) {
				categoryArray[count][0] = rs.getInt(1);
				categoryArray[count][1] = displayArray[count][0] = rs
						.getString(2);
				count++;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return displayArray;
	}

	class CategoryTableModel extends AbstractTableModel {

		private String[] columnNames = { "Category Description" };

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
