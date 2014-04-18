package ie.lyit.teamproject.tabs;

import ie.lyit.teamproject.DBConnectionClass;
import ie.lyit.teamproject.JobScreen;
import ie.lyit.teamproject.OpenProject;

import javax.swing.*;

import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlasteringQuantitiesCalc extends JPanel {
	private JTextField txtLength;
	private JTextField txtWidth;
	private JTextField txtTotalSize;
	private JTextField txtSand;
	private JTextField txtOpc;
	private JTextField txtLime;
	private JTextField txtBonding;
	private JTextField txtBrowning;
	private JTextField txtHardwall;
	private JTextField jtfPrice;
	private DBConnectionClass dbc;
	
	private double length, width, area, sand, opc, lime, browning, bonding, hardwall ;

	public PlasteringQuantitiesCalc() {
		setLayout(new BorderLayout(0, 0));
		
		dbc = new DBConnectionClass();

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(150, 200));
		panel.setBorder(new TitledBorder(new EtchedBorder(

		EtchedBorder.LOWERED, null, null), "Dimensions",

		TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 46, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel label = new JLabel("Length:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);

		txtLength = new JTextField();
		txtLength.setColumns(10);
		GridBagConstraints gbc_txtLength = new GridBagConstraints();
		gbc_txtLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLength.insets = new Insets(0, 0, 5, 0);
		gbc_txtLength.gridx = 1;
		gbc_txtLength.gridy = 1;
		panel.add(txtLength, gbc_txtLength);

		JLabel lblWidth = new JLabel("Width:");
		GridBagConstraints gbc_lblWidth = new GridBagConstraints();
		gbc_lblWidth.anchor = GridBagConstraints.EAST;
		gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidth.gridx = 0;
		gbc_lblWidth.gridy = 2;
		panel.add(lblWidth, gbc_lblWidth);

		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		GridBagConstraints gbc_txtWidth = new GridBagConstraints();
		gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWidth.anchor = GridBagConstraints.NORTH;
		gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
		gbc_txtWidth.gridx = 1;
		gbc_txtWidth.gridy = 2;
		panel.add(txtWidth, gbc_txtWidth);

		JLabel label_2 = new JLabel("Total Size m2:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		panel.add(label_2, gbc_label_2);

		txtTotalSize = new JTextField();
		txtTotalSize.setEditable(false);
		txtTotalSize.setColumns(10);
		GridBagConstraints gbc_txtTotalSize = new GridBagConstraints();
		gbc_txtTotalSize.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotalSize.anchor = GridBagConstraints.NORTH;
		gbc_txtTotalSize.insets = new Insets(0, 0, 5, 0);
		gbc_txtTotalSize.gridx = 1;
		gbc_txtTotalSize.gridy = 3;
		panel.add(txtTotalSize, gbc_txtTotalSize);

		JButton button = new JButton("Calculate");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtLength.getText().equals("")
						|| txtWidth.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please Fill in value for missing data fields ");
					txtLength.setText("0");
					txtWidth.setText("0");
				} else {

					// Execute when button is pressed
					try {
						// Get total size of wall in square meters
						length = Double.parseDouble(txtLength.getText());
						width = Double.parseDouble(txtWidth.getText());
						area = (int) length * width;

						// Get Materials required
						sand = area * 14;
						opc = area * 14;
						lime = area;
						bonding = area * 9;
						browning = area * 7;
						hardwall = area * 8;

						// set Texts
						txtTotalSize.setText(" " + area);
						txtSand.setText(" " + sand);
						txtOpc.setText(" " + opc);
						txtLime.setText(" " + lime);
						txtBonding.setText(" " + bonding);
						txtBrowning.setText(" " + browning);
						txtHardwall.setText(" " + hardwall);

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null,
								"Error, please enter numeric values! ");
						txtLength.setText("0");
						txtWidth.setText("0");
						txtTotalSize.setText("0");
					}
				}
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.gridx = 0;
		gbc_button.gridy = 4;
		panel.add(button, gbc_button);

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(150, 200));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(

		EtchedBorder.LOWERED, null, null), "Materials Required",

		TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblSand = new JLabel("Sand:");
		GridBagConstraints gbc_lblSand = new GridBagConstraints();
		gbc_lblSand.anchor = GridBagConstraints.EAST;
		gbc_lblSand.insets = new Insets(0, 0, 5, 5);
		gbc_lblSand.gridx = 0;
		gbc_lblSand.gridy = 0;
		panel_1.add(lblSand, gbc_lblSand);

		txtSand = new JTextField();
		txtSand.setEditable(false);
		txtSand.setColumns(10);
		GridBagConstraints gbc_txtSand = new GridBagConstraints();
		gbc_txtSand.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSand.insets = new Insets(0, 0, 5, 0);
		gbc_txtSand.gridx = 1;
		gbc_txtSand.gridy = 0;
		panel_1.add(txtSand, gbc_txtSand);

		JLabel lblOpc = new JLabel("Opc:");
		GridBagConstraints gbc_lblOpc = new GridBagConstraints();
		gbc_lblOpc.anchor = GridBagConstraints.EAST;
		gbc_lblOpc.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpc.gridx = 0;
		gbc_lblOpc.gridy = 1;
		panel_1.add(lblOpc, gbc_lblOpc);

		txtOpc = new JTextField();
		txtOpc.setEditable(false);
		txtOpc.setColumns(10);
		GridBagConstraints gbc_txtOpc = new GridBagConstraints();
		gbc_txtOpc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOpc.insets = new Insets(0, 0, 5, 0);
		gbc_txtOpc.gridx = 1;
		gbc_txtOpc.gridy = 1;
		panel_1.add(txtOpc, gbc_txtOpc);

		JLabel lblLime = new JLabel("Lime:");
		GridBagConstraints gbc_lblLime = new GridBagConstraints();
		gbc_lblLime.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblLime.insets = new Insets(0, 0, 5, 5);
		gbc_lblLime.gridx = 0;
		gbc_lblLime.gridy = 2;
		panel_1.add(lblLime, gbc_lblLime);

		txtLime = new JTextField();
		txtLime.setEditable(false);
		txtLime.setColumns(10);
		GridBagConstraints gbc_txtLime = new GridBagConstraints();
		gbc_txtLime.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLime.insets = new Insets(0, 0, 5, 0);
		gbc_txtLime.gridx = 1;
		gbc_txtLime.gridy = 2;
		panel_1.add(txtLime, gbc_txtLime);

		JLabel lblBonding = new JLabel("Bonding:");
		GridBagConstraints gbc_lblBonding = new GridBagConstraints();
		gbc_lblBonding.anchor = GridBagConstraints.EAST;
		gbc_lblBonding.insets = new Insets(0, 0, 5, 5);
		gbc_lblBonding.gridx = 0;
		gbc_lblBonding.gridy = 3;
		panel_1.add(lblBonding, gbc_lblBonding);

		txtBonding = new JTextField();
		txtBonding.setEditable(false);
		txtBonding.setColumns(10);
		GridBagConstraints gbc_txtBonding = new GridBagConstraints();
		gbc_txtBonding.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBonding.insets = new Insets(0, 0, 5, 0);
		gbc_txtBonding.gridx = 1;
		gbc_txtBonding.gridy = 3;
		panel_1.add(txtBonding, gbc_txtBonding);

		JLabel lblBrowning = new JLabel("Browning:");
		GridBagConstraints gbc_lblBrowning = new GridBagConstraints();
		gbc_lblBrowning.anchor = GridBagConstraints.EAST;
		gbc_lblBrowning.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrowning.gridx = 0;
		gbc_lblBrowning.gridy = 4;
		panel_1.add(lblBrowning, gbc_lblBrowning);

		txtBrowning = new JTextField();
		txtBrowning.setEditable(false);
		txtBrowning.setColumns(10);
		GridBagConstraints gbc_txtBrowning = new GridBagConstraints();
		gbc_txtBrowning.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBrowning.insets = new Insets(0, 0, 5, 0);
		gbc_txtBrowning.gridx = 1;
		gbc_txtBrowning.gridy = 4;
		panel_1.add(txtBrowning, gbc_txtBrowning);

		JLabel lblHardwall = new JLabel("Hardwall:");
		GridBagConstraints gbc_lblHardwall = new GridBagConstraints();
		gbc_lblHardwall.anchor = GridBagConstraints.EAST;
		gbc_lblHardwall.insets = new Insets(0, 0, 0, 5);
		gbc_lblHardwall.gridx = 0;
		gbc_lblHardwall.gridy = 5;
		panel_1.add(lblHardwall, gbc_lblHardwall);

		txtHardwall = new JTextField();
		txtHardwall.setEditable(false);
		txtHardwall.setColumns(10);
		GridBagConstraints gbc_txtHardwall = new GridBagConstraints();
		gbc_txtHardwall.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHardwall.gridx = 1;
		gbc_txtHardwall.gridy = 5;
		panel_1.add(txtHardwall, gbc_txtHardwall);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel lblEnterPrice = new JLabel("Enter Price:\u20AC");
		lblEnterPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblEnterPrice);

		jtfPrice = new JTextField();
		jtfPrice.setColumns(10);
		panel_2.add(jtfPrice);

		JButton jbtAdd = new JButton("Add");
		jbtAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = Double.parseDouble(jtfPrice.getText());
				double totalPrice = price * area;
				int job_id = OpenProject.getProjectToOpen();
				int quant = (int) area;

				int mat_id = dbc.retrieveMaterialByName("Plaster");
				dbc.addMaterialToJob(job_id, mat_id, quant, price, totalPrice);
				JobScreen.jobModel.data = JobScreen.updateJobTable(job_id);
				JobScreen.table.repaint();
				JobScreen.table.revalidate();
				JobScreen.setHeaderDetails(OpenProject.getProjectToOpen());
				txtBonding.setText("");
				txtBrowning.setText("");
				txtHardwall.setText("");
				txtLength.setText("");
				txtTotalSize.setText("");
				txtLime.setText("");
				txtOpc.setText("");
				txtSand.setText("");

				txtWidth.setText("");
				jtfPrice.setText("");
			}
		});
		panel_2.add(jbtAdd);

		setPreferredSize(new Dimension(320, 200));
	}

}
