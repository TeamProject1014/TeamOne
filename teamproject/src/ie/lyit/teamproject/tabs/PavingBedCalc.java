package ie.lyit.teamproject.tabs;

import ie.lyit.teamproject.DBConnectionClass;

import javax.swing.*;

import java.awt.GridLayout;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PavingBedCalc extends JPanel {
	private JTextField txtLength;
	private JTextField txtWidth;
	private JTextField txtTotalArea;
	private JTextField txtSand;
	private JTextField txtCement;
	private JTextField txtPrice;
	private JTextField txtTotalPrice;
	private DBConnectionClass dbc;

	private double length, height, area;
	private int cement, sand;

	public PavingBedCalc() {
		// getRootPane().setLayout(new GridLayout(1, 0, 0, 0));

		setLayout(new BorderLayout(0, 0));
		dbc = new DBConnectionClass();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		add(panel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(150, 200));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(

		EtchedBorder.LOWERED, null, null), "Dimensions",

		TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 59, 49, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);
						
								JLabel label = new JLabel("Length:");
								GridBagConstraints gbc_label = new GridBagConstraints();
								gbc_label.anchor = GridBagConstraints.EAST;
								gbc_label.insets = new Insets(0, 0, 5, 5);
								gbc_label.gridx = 0;
								gbc_label.gridy = 1;
								panel_1.add(label, gbc_label);
						
								txtLength = new JTextField();
								txtLength.setColumns(10);
								GridBagConstraints gbc_txtLength = new GridBagConstraints();
								gbc_txtLength.fill = GridBagConstraints.HORIZONTAL;
								gbc_txtLength.insets = new Insets(0, 0, 5, 0);
								gbc_txtLength.gridx = 1;
								gbc_txtLength.gridy = 1;
								panel_1.add(txtLength, gbc_txtLength);
				
						JLabel lblWidth = new JLabel("Width:");
						GridBagConstraints gbc_lblWidth = new GridBagConstraints();
						gbc_lblWidth.anchor = GridBagConstraints.EAST;
						gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
						gbc_lblWidth.gridx = 0;
						gbc_lblWidth.gridy = 2;
						panel_1.add(lblWidth, gbc_lblWidth);
				
						txtWidth = new JTextField();
						txtWidth.setColumns(10);
						GridBagConstraints gbc_txtWidth = new GridBagConstraints();
						gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtWidth.anchor = GridBagConstraints.NORTH;
						gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
						gbc_txtWidth.gridx = 1;
						gbc_txtWidth.gridy = 2;
						panel_1.add(txtWidth, gbc_txtWidth);
		
				JLabel label_2 = new JLabel("Total Size m2:");
				GridBagConstraints gbc_label_2 = new GridBagConstraints();
				gbc_label_2.anchor = GridBagConstraints.EAST;
				gbc_label_2.insets = new Insets(0, 0, 5, 5);
				gbc_label_2.gridx = 0;
				gbc_label_2.gridy = 3;
				panel_1.add(label_2, gbc_label_2);
		
				txtTotalArea = new JTextField();
				txtTotalArea.setEditable(false);
				txtTotalArea.setColumns(10);
				GridBagConstraints gbc_txtTotalArea = new GridBagConstraints();
				gbc_txtTotalArea.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTotalArea.anchor = GridBagConstraints.NORTH;
				gbc_txtTotalArea.insets = new Insets(0, 0, 5, 0);
				gbc_txtTotalArea.gridx = 1;
				gbc_txtTotalArea.gridy = 3;
				panel_1.add(txtTotalArea, gbc_txtTotalArea);
				
						JButton button = new JButton("Calculate");
						GridBagConstraints gbc_button = new GridBagConstraints();
						gbc_button.insets = new Insets(0, 0, 5, 5);
						gbc_button.anchor = GridBagConstraints.WEST;
						gbc_button.gridx = 0;
						gbc_button.gridy = 4;
						panel_1.add(button, gbc_button);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(150, 200));
		panel_2.setBorder(new TitledBorder(new EtchedBorder(

		EtchedBorder.LOWERED, null, null), "Materials Required",

		TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);
		
				JLabel lblSandInKgs = new JLabel("Sand in Kg's:");
				GridBagConstraints gbc_lblSandInKgs = new GridBagConstraints();
				gbc_lblSandInKgs.anchor = GridBagConstraints.EAST;
				gbc_lblSandInKgs.insets = new Insets(0, 0, 5, 5);
				gbc_lblSandInKgs.gridx = 0;
				gbc_lblSandInKgs.gridy = 1;
				panel_2.add(lblSandInKgs, gbc_lblSandInKgs);
		
				txtSand = new JTextField();
				txtSand.setEditable(false);
				txtSand.setColumns(10);
				GridBagConstraints gbc_txtSand = new GridBagConstraints();
				gbc_txtSand.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtSand.insets = new Insets(0, 0, 5, 0);
				gbc_txtSand.gridx = 1;
				gbc_txtSand.gridy = 1;
				panel_2.add(txtSand, gbc_txtSand);

		JLabel label_5 = new JLabel("Cement in kg's:");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.NORTHEAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 2;
		panel_2.add(label_5, gbc_label_5);

		txtCement = new JTextField();
		txtCement.setEditable(false);
		txtCement.setColumns(10);
		GridBagConstraints gbc_txtCement = new GridBagConstraints();
		gbc_txtCement.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCement.insets = new Insets(0, 0, 5, 0);
		gbc_txtCement.gridx = 1;
		gbc_txtCement.gridy = 2;
		panel_2.add(txtCement, gbc_txtCement);

		JLabel label_8 = new JLabel("Price:");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 3;
		panel_2.add(label_8, gbc_label_8);

		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		GridBagConstraints gbc_txtPrice = new GridBagConstraints();
		gbc_txtPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrice.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrice.gridx = 1;
		gbc_txtPrice.gridy = 3;
		panel_2.add(txtPrice, gbc_txtPrice);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel lblEnterPrice = new JLabel("Enter Price: \u20AC");
		lblEnterPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblEnterPrice);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setColumns(10);
		panel_3.add(txtTotalPrice);
		
		JButton btnAdd = new JButton("Add");
		panel_3.add(btnAdd);
		
		setPreferredSize(new Dimension(320, 200));

		JButton jbtCalculate = new JButton("Calculate");
		jbtCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Execute when button is pressed
				try {
					// Get total size of wall in square meters
					length = Double.parseDouble(txtLength.getText());
					height = Double.parseDouble(txtWidth.getText());
					area = (int) length * height;

					sand = (int) (area * 100);
					cement = (int) (area * 8);

					// set Texts
					txtTotalArea.setText(" " + area);
					txtSand.setText(" " + sand);
					txtCement.setText(" " + cement);

				} catch (NumberFormatException nfe) {
					txtLength.setText("0");
					txtWidth.setText("0");
					txtTotalArea.setText("0");
				}
			}
		});
	}

}
