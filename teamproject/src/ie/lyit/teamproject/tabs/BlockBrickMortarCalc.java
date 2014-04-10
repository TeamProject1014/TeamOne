package ie.lyit.teamproject.tabs;

import javax.swing.*;

import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockBrickMortarCalc extends JPanel {
	private JTextField txtLength;
	private JTextField txtHeight;
	private JTextField txtTotalSize;
	private JTextField txtNrUnits;
	private JTextField txtMortar;
	private JTextField txtOPC;
	private JTextField txtSand;
	private JTextField txtPlasticiser;
	private JTextField txtPrice;
	private JTextField txtTotalPrice;
	double length, height, area, nrUnits, sand, opc, mortar, plasticiser;

	public BlockBrickMortarCalc() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(

		EtchedBorder.LOWERED, null, null), "Dimensions",

		TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
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
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);

		txtLength = new JTextField();
		txtLength.setColumns(10);
		GridBagConstraints gbc_txtLength = new GridBagConstraints();
		gbc_txtLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLength.insets = new Insets(0, 0, 5, 0);
		gbc_txtLength.gridx = 1;
		gbc_txtLength.gridy = 0;
		panel.add(txtLength, gbc_txtLength);

		JLabel label_1 = new JLabel("Height:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);

		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		GridBagConstraints gbc_txtHeight = new GridBagConstraints();
		gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHeight.anchor = GridBagConstraints.NORTH;
		gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
		gbc_txtHeight.gridx = 1;
		gbc_txtHeight.gridy = 1;
		panel.add(txtHeight, gbc_txtHeight);

		JLabel label_2 = new JLabel("Total Size m2:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panel.add(label_2, gbc_label_2);

		txtTotalSize = new JTextField();
		txtTotalSize.setEditable(false);
		txtTotalSize.setColumns(10);
		GridBagConstraints gbc_txtTotalSize = new GridBagConstraints();
		gbc_txtTotalSize.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotalSize.anchor = GridBagConstraints.NORTH;
		gbc_txtTotalSize.insets = new Insets(0, 0, 5, 0);
		gbc_txtTotalSize.gridx = 1;
		gbc_txtTotalSize.gridy = 2;
		panel.add(txtTotalSize, gbc_txtTotalSize);

		JButton button = new JButton("Calculate");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.gridx = 1;
		gbc_button.gridy = 6;
		panel.add(button, gbc_button);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(

		EtchedBorder.LOWERED, null, null), "Materials Required",

		TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNrUnits = new JLabel("Nr Units:");
		GridBagConstraints gbc_lblNrUnits = new GridBagConstraints();
		gbc_lblNrUnits.anchor = GridBagConstraints.EAST;
		gbc_lblNrUnits.insets = new Insets(0, 0, 5, 5);
		gbc_lblNrUnits.gridx = 0;
		gbc_lblNrUnits.gridy = 0;
		panel_1.add(lblNrUnits, gbc_lblNrUnits);

		txtNrUnits = new JTextField();
		txtNrUnits.setEditable(false);
		txtNrUnits.setColumns(10);
		GridBagConstraints gbc_txtNrUnits = new GridBagConstraints();
		gbc_txtNrUnits.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNrUnits.insets = new Insets(0, 0, 5, 0);
		gbc_txtNrUnits.gridx = 1;
		gbc_txtNrUnits.gridy = 0;
		panel_1.add(txtNrUnits, gbc_txtNrUnits);

		JLabel lblMortorM = new JLabel("Mortar m3:");
		GridBagConstraints gbc_lblMortorM = new GridBagConstraints();
		gbc_lblMortorM.anchor = GridBagConstraints.EAST;
		gbc_lblMortorM.insets = new Insets(0, 0, 5, 5);
		gbc_lblMortorM.gridx = 0;
		gbc_lblMortorM.gridy = 1;
		panel_1.add(lblMortorM, gbc_lblMortorM);

		txtMortar = new JTextField();
		txtMortar.setEditable(false);
		txtMortar.setColumns(10);
		GridBagConstraints gbc_txtMortar = new GridBagConstraints();
		gbc_txtMortar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMortar.insets = new Insets(0, 0, 5, 0);
		gbc_txtMortar.gridx = 1;
		gbc_txtMortar.gridy = 1;
		panel_1.add(txtMortar, gbc_txtMortar);

		JLabel lblOpc = new JLabel("OPC:");
		GridBagConstraints gbc_lblOpc = new GridBagConstraints();
		gbc_lblOpc.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblOpc.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpc.gridx = 0;
		gbc_lblOpc.gridy = 2;
		panel_1.add(lblOpc, gbc_lblOpc);

		txtOPC = new JTextField();
		txtOPC.setEditable(false);
		txtOPC.setColumns(10);
		GridBagConstraints gbc_txtOPC = new GridBagConstraints();
		gbc_txtOPC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOPC.insets = new Insets(0, 0, 5, 0);
		gbc_txtOPC.gridx = 1;
		gbc_txtOPC.gridy = 2;
		panel_1.add(txtOPC, gbc_txtOPC);

		JLabel label_6 = new JLabel("Sand in kg's:");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 3;
		panel_1.add(label_6, gbc_label_6);

		txtSand = new JTextField();
		txtSand.setEditable(false);
		txtSand.setColumns(10);
		GridBagConstraints gbc_txtSand = new GridBagConstraints();
		gbc_txtSand.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSand.insets = new Insets(0, 0, 5, 0);
		gbc_txtSand.gridx = 1;
		gbc_txtSand.gridy = 3;
		panel_1.add(txtSand, gbc_txtSand);

		JLabel lblPlasticiser = new JLabel("Plasticiser:");
		GridBagConstraints gbc_lblPlasticiser = new GridBagConstraints();
		gbc_lblPlasticiser.anchor = GridBagConstraints.EAST;
		gbc_lblPlasticiser.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlasticiser.gridx = 0;
		gbc_lblPlasticiser.gridy = 4;
		panel_1.add(lblPlasticiser, gbc_lblPlasticiser);

		txtPlasticiser = new JTextField();
		txtPlasticiser.setEditable(false);
		txtPlasticiser.setColumns(10);
		GridBagConstraints gbc_txtPlasticiser = new GridBagConstraints();
		gbc_txtPlasticiser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlasticiser.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlasticiser.gridx = 1;
		gbc_txtPlasticiser.gridy = 4;
		panel_1.add(txtPlasticiser, gbc_txtPlasticiser);

		JLabel label_8 = new JLabel("Price:");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.insets = new Insets(0, 0, 0, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 5;
		panel_1.add(label_8, gbc_label_8);

		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		GridBagConstraints gbc_txtPrice = new GridBagConstraints();
		gbc_txtPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrice.gridx = 1;
		gbc_txtPrice.gridy = 5;
		panel_1.add(txtPrice, gbc_txtPrice);

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

		JButton jbtCalculate = new JButton("Calculate");
		jbtCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					// get Total Area
					length = Double.parseDouble(txtLength.getText());
					height = Double.parseDouble(txtHeight.getText());
					area = (int) length * height;

					nrUnits = area * 10;
					sand = area * 31;
					opc = area * 9;
					plasticiser = area * 12;

					// set Texts
					txtTotalSize.setText(" " + area);
					txtNrUnits.setText(" " + nrUnits);
					txtSand.setText(" " + sand);
					txtOPC.setText(" " + opc);
					txtPlasticiser.setText(" " + plasticiser);
				}

				catch (NumberFormatException nfe) {

				}

			}
		});
	}

}
