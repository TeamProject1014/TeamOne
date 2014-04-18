package ie.lyit.teamproject.tabs;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class MortarCalculator extends JPanel {
	private JTextField txtPlasticiser;
	private JTextField txtSand;
	private JTextField txtCement;
	private JTextField txtPrice;
	private JTextField txtLength;
	private JTextField txtHeight;
	private JTextField txtTotalSize;
	private JTextField txtTotalPrice;
	double length, height, area, sand, cement;

	public MortarCalculator() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(

		EtchedBorder.LOWERED, null, null), "Materials Required",

		TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 26, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
								
										JLabel lblPlasticiser = new JLabel("Plasticiser:");
										GridBagConstraints gbc_lblPlasticiser = new GridBagConstraints();
										gbc_lblPlasticiser.anchor = GridBagConstraints.EAST;
										gbc_lblPlasticiser.insets = new Insets(0, 0, 5, 5);
										gbc_lblPlasticiser.gridx = 0;
										gbc_lblPlasticiser.gridy = 1;
										panel.add(lblPlasticiser, gbc_lblPlasticiser);
								
										txtPlasticiser = new JTextField();
										txtPlasticiser.setEditable(false);
										txtPlasticiser.setColumns(10);
										GridBagConstraints gbc_txtPlasticiser = new GridBagConstraints();
										gbc_txtPlasticiser.fill = GridBagConstraints.HORIZONTAL;
										gbc_txtPlasticiser.insets = new Insets(0, 0, 5, 0);
										gbc_txtPlasticiser.gridx = 1;
										gbc_txtPlasticiser.gridy = 1;
										panel.add(txtPlasticiser, gbc_txtPlasticiser);
						
								JLabel lblSandInKgs = new JLabel("Sand in Kg's:");
								GridBagConstraints gbc_lblSandInKgs = new GridBagConstraints();
								gbc_lblSandInKgs.anchor = GridBagConstraints.EAST;
								gbc_lblSandInKgs.insets = new Insets(0, 0, 5, 5);
								gbc_lblSandInKgs.gridx = 0;
								gbc_lblSandInKgs.gridy = 2;
								panel.add(lblSandInKgs, gbc_lblSandInKgs);
				
						txtSand = new JTextField();
						txtSand.setEditable(false);
						txtSand.setColumns(10);
						GridBagConstraints gbc_txtSand = new GridBagConstraints();
						gbc_txtSand.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtSand.insets = new Insets(0, 0, 5, 0);
						gbc_txtSand.gridx = 1;
						gbc_txtSand.gridy = 2;
						panel.add(txtSand, gbc_txtSand);
						
								JLabel label_2 = new JLabel("Cement in kg's:");
								GridBagConstraints gbc_label_2 = new GridBagConstraints();
								gbc_label_2.anchor = GridBagConstraints.NORTHEAST;
								gbc_label_2.insets = new Insets(0, 0, 5, 5);
								gbc_label_2.gridx = 0;
								gbc_label_2.gridy = 3;
								panel.add(label_2, gbc_label_2);
				
						txtCement = new JTextField();
						txtCement.setEditable(false);
						txtCement.setColumns(10);
						GridBagConstraints gbc_txtCement = new GridBagConstraints();
						gbc_txtCement.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtCement.insets = new Insets(0, 0, 5, 0);
						gbc_txtCement.gridx = 1;
						gbc_txtCement.gridy = 3;
						panel.add(txtCement, gbc_txtCement);
						
								JLabel lblPrice = new JLabel("Price:");
								GridBagConstraints gbc_lblPrice = new GridBagConstraints();
								gbc_lblPrice.anchor = GridBagConstraints.EAST;
								gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
								gbc_lblPrice.gridx = 0;
								gbc_lblPrice.gridy = 4;
								panel.add(lblPrice, gbc_lblPrice);
						
								txtPrice = new JTextField();
								txtPrice.setEditable(false);
								txtPrice.setColumns(10);
								GridBagConstraints gbc_txtPrice = new GridBagConstraints();
								gbc_txtPrice.fill = GridBagConstraints.HORIZONTAL;
								gbc_txtPrice.insets = new Insets(0, 0, 5, 0);
								gbc_txtPrice.gridx = 1;
								gbc_txtPrice.gridy = 4;
								panel.add(txtPrice, gbc_txtPrice);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(

		EtchedBorder.LOWERED, null, null), "Dimensions",

		TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 30, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);
												
														JLabel label_6 = new JLabel("Length:");
														GridBagConstraints gbc_label_6 = new GridBagConstraints();
														gbc_label_6.anchor = GridBagConstraints.EAST;
														gbc_label_6.insets = new Insets(0, 0, 5, 5);
														gbc_label_6.gridx = 0;
														gbc_label_6.gridy = 1;
														panel_1.add(label_6, gbc_label_6);
												
														txtLength = new JTextField();
														txtLength.setColumns(10);
														GridBagConstraints gbc_txtLength = new GridBagConstraints();
														gbc_txtLength.fill = GridBagConstraints.HORIZONTAL;
														gbc_txtLength.insets = new Insets(0, 0, 5, 0);
														gbc_txtLength.gridx = 1;
														gbc_txtLength.gridy = 1;
														panel_1.add(txtLength, gbc_txtLength);
										
												JLabel label_7 = new JLabel("Height:");
												GridBagConstraints gbc_label_7 = new GridBagConstraints();
												gbc_label_7.anchor = GridBagConstraints.EAST;
												gbc_label_7.insets = new Insets(0, 0, 5, 5);
												gbc_label_7.gridx = 0;
												gbc_label_7.gridy = 2;
												panel_1.add(label_7, gbc_label_7);
										
												txtHeight = new JTextField();
												txtHeight.setColumns(10);
												GridBagConstraints gbc_txtHeight = new GridBagConstraints();
												gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
												gbc_txtHeight.anchor = GridBagConstraints.NORTH;
												gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
												gbc_txtHeight.gridx = 1;
												gbc_txtHeight.gridy = 2;
												panel_1.add(txtHeight, gbc_txtHeight);
								
										JLabel label_8 = new JLabel("Total Size m2:");
										GridBagConstraints gbc_label_8 = new GridBagConstraints();
										gbc_label_8.anchor = GridBagConstraints.EAST;
										gbc_label_8.insets = new Insets(0, 0, 5, 5);
										gbc_label_8.gridx = 0;
										gbc_label_8.gridy = 3;
										panel_1.add(label_8, gbc_label_8);
								
										txtTotalSize = new JTextField();
										txtTotalSize.setEditable(false);
										txtTotalSize.setColumns(10);
										GridBagConstraints gbc_txtTotalSize = new GridBagConstraints();
										gbc_txtTotalSize.fill = GridBagConstraints.HORIZONTAL;
										gbc_txtTotalSize.anchor = GridBagConstraints.NORTH;
										gbc_txtTotalSize.insets = new Insets(0, 0, 5, 0);
										gbc_txtTotalSize.gridx = 1;
										gbc_txtTotalSize.gridy = 3;
										panel_1.add(txtTotalSize, gbc_txtTotalSize);
						
								JButton button = new JButton("Calculate");
								GridBagConstraints gbc_button = new GridBagConstraints();
								gbc_button.insets = new Insets(0, 0, 5, 0);
								gbc_button.anchor = GridBagConstraints.WEST;
								gbc_button.gridx = 1;
								gbc_button.gridy = 4;
								panel_1.add(button, gbc_button);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel label_9 = new JLabel("TotalPrice:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label_9);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setColumns(10);
		panel_2.add(txtTotalPrice);
		
		setPreferredSize(new Dimension(320, 200));

		JButton jbtCalculate = new JButton("Calculate");
		jbtCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					// get Total Area
					length = Double.parseDouble(txtLength.getText());
					height = Double.parseDouble(txtHeight.getText());
					area = (int) length * height;

					// Calculations
					cement = area * 15.5;
					sand = area * 54.5;

					// Set Texts
					txtTotalSize.setText(" " + area);
					txtSand.setText(" " + sand);
					txtCement.setText(" " + cement);
				}

				catch (NumberFormatException nfe) {

				}

			}
		});

	}

}
