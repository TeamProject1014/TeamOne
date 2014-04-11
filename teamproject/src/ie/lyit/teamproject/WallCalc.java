package ie.lyit.teamproject;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WallCalc extends JPanel {
	private JTextField jtfLength;
	private JTextField jtfHeight;
	private JTextField jtfSqM;
	private JTextField jtfBlocksInner;
	private JTextField jtfBlocksOuter;
	private JTextField jtfCement;
	private JTextField jtfSand;
	private JTextField jtfWallTies;
	private JTextField jtfTotal;

	@SuppressWarnings("unused")
	private int innerLeaf, outerleaf, ties, cement, sand;
	private double length, height, area;
	private final double BLOCK = 0.10125;
	private final double TIES_PER_SQ_M = 2.2;
	private final double SAND_PER_SQ_M = 40.8;
	private final double CEMENT_PER_SQ_M = 11.7;

	/**
	 * Create the panel.
	 */
	public WallCalc() {
		setLayout(new BorderLayout(0, 0));

		JPanel dimensionPanel = new JPanel();
		dimensionPanel.setPreferredSize(new Dimension(148, 100));
		dimensionPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Dimensions",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(dimensionPanel, BorderLayout.WEST);
		GridBagLayout gbl_dimensionPanel = new GridBagLayout();
		gbl_dimensionPanel.columnWidths = new int[] { 0, 46, 0 };
		gbl_dimensionPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_dimensionPanel.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_dimensionPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		dimensionPanel.setLayout(gbl_dimensionPanel);

		JLabel jlblLength = new JLabel("Length:");
		GridBagConstraints gbc_jlblLength = new GridBagConstraints();
		gbc_jlblLength.anchor = GridBagConstraints.EAST;
		gbc_jlblLength.insets = new Insets(0, 0, 5, 5);
		gbc_jlblLength.gridx = 0;
		gbc_jlblLength.gridy = 1;
		dimensionPanel.add(jlblLength, gbc_jlblLength);

		jtfLength = new JTextField();
		GridBagConstraints gbc_jtfLength = new GridBagConstraints();
		gbc_jtfLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLength.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLength.gridx = 1;
		gbc_jtfLength.gridy = 1;
		dimensionPanel.add(jtfLength, gbc_jtfLength);
		jtfLength.setColumns(10);

		JLabel jlblHeight = new JLabel("Height:");
		GridBagConstraints gbc_jlblHeight = new GridBagConstraints();
		gbc_jlblHeight.insets = new Insets(0, 0, 5, 5);
		gbc_jlblHeight.anchor = GridBagConstraints.EAST;
		gbc_jlblHeight.gridx = 0;
		gbc_jlblHeight.gridy = 2;
		dimensionPanel.add(jlblHeight, gbc_jlblHeight);

		jtfHeight = new JTextField();
		GridBagConstraints gbc_jtfHeight = new GridBagConstraints();
		gbc_jtfHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfHeight.anchor = GridBagConstraints.NORTH;
		gbc_jtfHeight.insets = new Insets(0, 0, 5, 0);
		gbc_jtfHeight.gridx = 1;
		gbc_jtfHeight.gridy = 2;
		dimensionPanel.add(jtfHeight, gbc_jtfHeight);
		jtfHeight.setColumns(10);

		JLabel jlblTotSize = new JLabel("Total Size m2:");
		GridBagConstraints gbc_jlblTotSize = new GridBagConstraints();
		gbc_jlblTotSize.insets = new Insets(0, 0, 5, 5);
		gbc_jlblTotSize.anchor = GridBagConstraints.EAST;
		gbc_jlblTotSize.gridx = 0;
		gbc_jlblTotSize.gridy = 3;
		dimensionPanel.add(jlblTotSize, gbc_jlblTotSize);

		jtfSqM = new JTextField();
		jtfSqM.setEditable(false);
		GridBagConstraints gbc_jtfSqM = new GridBagConstraints();
		gbc_jtfSqM.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSqM.anchor = GridBagConstraints.NORTH;
		gbc_jtfSqM.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSqM.gridx = 1;
		gbc_jtfSqM.gridy = 3;
		dimensionPanel.add(jtfSqM, gbc_jtfSqM);
		jtfSqM.setColumns(10);

		JButton jbtCalculate = new JButton("Calculate");
		jbtCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Execute when button is pressed
				try {
					// Get total size of wall in square meters
					length = Double.parseDouble(jtfLength.getText());
					height = Double.parseDouble(jtfHeight.getText());
					area = (int) length * height;

					// Divide area of a block into area of the wall
					innerLeaf = outerleaf = (int) Math.round(area / BLOCK);

					// Calculate number of wall ties required
					ties = (int) Math.round(area * TIES_PER_SQ_M);

					// Calculate cement required in kgs
					cement = (int) Math.round(area * CEMENT_PER_SQ_M);

					// Calculate sand required in kgs
					sand = (int) Math.round(area * SAND_PER_SQ_M);

					// Set textfields
					jtfSqM.setText(" " + area);
					jtfBlocksInner.setText(" " + innerLeaf);
					jtfBlocksOuter.setText(" " + innerLeaf);
					jtfWallTies.setText(" " + ties);
					jtfCement.setText(" " + cement);
					jtfSand.setText(" " + sand);
				} catch (NumberFormatException nfe) {
					jtfLength.setText("0");
					jtfHeight.setText("0");
					jtfTotal.setText("0");
				}
			}
		});

		GridBagConstraints gbc_jbtCalculate = new GridBagConstraints();
		gbc_jbtCalculate.insets = new Insets(0, 0, 5, 5);
		gbc_jbtCalculate.fill = GridBagConstraints.HORIZONTAL;
		gbc_jbtCalculate.gridx = 0;
		gbc_jbtCalculate.gridy = 4;
		dimensionPanel.add(jbtCalculate, gbc_jbtCalculate);

		JPanel materialRqdPanel = new JPanel();
		materialRqdPanel.setPreferredSize(new Dimension(170, 100));
		materialRqdPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Materials Required",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(materialRqdPanel, BorderLayout.EAST);
		GridBagLayout gbl_materialRqdPanel = new GridBagLayout();
		gbl_materialRqdPanel.columnWidths = new int[] { 59, 48, 0 };
		gbl_materialRqdPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_materialRqdPanel.columnWeights = new double[] { 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_materialRqdPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		materialRqdPanel.setLayout(gbl_materialRqdPanel);

		JLabel jlblInner = new JLabel("Blocks - Inner Leaf:");
		GridBagConstraints gbc_jlblInner = new GridBagConstraints();
		gbc_jlblInner.insets = new Insets(0, 0, 5, 5);
		gbc_jlblInner.anchor = GridBagConstraints.EAST;
		gbc_jlblInner.gridx = 0;
		gbc_jlblInner.gridy = 0;
		materialRqdPanel.add(jlblInner, gbc_jlblInner);

		jtfBlocksInner = new JTextField();
		jtfBlocksInner.setEditable(false);
		GridBagConstraints gbc_jtfBlocksInner = new GridBagConstraints();
		gbc_jtfBlocksInner.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBlocksInner.insets = new Insets(0, 0, 5, 0);
		gbc_jtfBlocksInner.gridx = 1;
		gbc_jtfBlocksInner.gridy = 0;
		materialRqdPanel.add(jtfBlocksInner, gbc_jtfBlocksInner);
		jtfBlocksInner.setColumns(6);

		JLabel jlblOuter = new JLabel("Blocks - Outer Leaf:");
		GridBagConstraints gbc_jlblOuter = new GridBagConstraints();
		gbc_jlblOuter.anchor = GridBagConstraints.EAST;
		gbc_jlblOuter.insets = new Insets(0, 0, 5, 5);
		gbc_jlblOuter.gridx = 0;
		gbc_jlblOuter.gridy = 1;
		materialRqdPanel.add(jlblOuter, gbc_jlblOuter);

		jtfBlocksOuter = new JTextField();
		jtfBlocksOuter.setEditable(false);
		GridBagConstraints gbc_jtfBlocksOuter = new GridBagConstraints();
		gbc_jtfBlocksOuter.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBlocksOuter.insets = new Insets(0, 0, 5, 0);
		gbc_jtfBlocksOuter.gridx = 1;
		gbc_jtfBlocksOuter.gridy = 1;
		materialRqdPanel.add(jtfBlocksOuter, gbc_jtfBlocksOuter);
		jtfBlocksOuter.setColumns(6);

		JLabel lblNewLabel_2 = new JLabel("Cement in kg's:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		materialRqdPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfCement = new JTextField();
		jtfCement.setEditable(false);
		GridBagConstraints gbc_jtfCement = new GridBagConstraints();
		gbc_jtfCement.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCement.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCement.gridx = 1;
		gbc_jtfCement.gridy = 2;
		materialRqdPanel.add(jtfCement, gbc_jtfCement);
		jtfCement.setColumns(6);

		JLabel jlblSand = new JLabel("Sand in kg's:");
		GridBagConstraints gbc_jlblSand = new GridBagConstraints();
		gbc_jlblSand.anchor = GridBagConstraints.EAST;
		gbc_jlblSand.insets = new Insets(0, 0, 5, 5);
		gbc_jlblSand.gridx = 0;
		gbc_jlblSand.gridy = 3;
		materialRqdPanel.add(jlblSand, gbc_jlblSand);

		jtfSand = new JTextField();
		jtfSand.setEditable(false);
		GridBagConstraints gbc_jtfSand = new GridBagConstraints();
		gbc_jtfSand.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSand.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSand.gridx = 1;
		gbc_jtfSand.gridy = 3;
		materialRqdPanel.add(jtfSand, gbc_jtfSand);
		jtfSand.setColumns(6);

		JLabel jlblWallTies = new JLabel("Wall Ties:");
		GridBagConstraints gbc_jlblWallTies = new GridBagConstraints();
		gbc_jlblWallTies.anchor = GridBagConstraints.EAST;
		gbc_jlblWallTies.insets = new Insets(0, 0, 5, 5);
		gbc_jlblWallTies.gridx = 0;
		gbc_jlblWallTies.gridy = 4;
		materialRqdPanel.add(jlblWallTies, gbc_jlblWallTies);

		jtfWallTies = new JTextField();
		jtfWallTies.setEditable(false);
		GridBagConstraints gbc_jtfWallTies = new GridBagConstraints();
		gbc_jtfWallTies.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfWallTies.insets = new Insets(0, 0, 5, 0);
		gbc_jtfWallTies.gridx = 1;
		gbc_jtfWallTies.gridy = 4;
		materialRqdPanel.add(jtfWallTies, gbc_jtfWallTies);
		jtfWallTies.setColumns(6);

		JPanel totalPanel = new JPanel();
		add(totalPanel, BorderLayout.SOUTH);
		totalPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel jlblTotalPrice = new JLabel("TotalPrice:");
		jlblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPanel.add(jlblTotalPrice);

		jtfTotal = new JTextField();
		jtfTotal.setEditable(false);
		totalPanel.add(jtfTotal);
		jtfTotal.setColumns(10);
		
		setPreferredSize(new Dimension(317, 200));
	}
}
