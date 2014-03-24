package ie.lyit.teamproject;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class Walls extends JPanel {
	private JTextField txtLength;
	private JTextField txtHeight;
	private JTextField txtTotal;
	private JTextField txtInner;
	private JTextField txtOuter;
	private JTextField txtCement;
	private JTextField txtSand;
	private JTextField txtWallTies;
	private JTextField textField_8;
	private JTextField textField_9;
	float num1, num2, total, convert, block, innerLeaf, outLeaf, ties, cement,
			sand;

	// Constructor
	public Walls() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Dimensions",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 54, 198, 183);
		add(panel);

		JButton button = new JButton("Calculate");
		button.setBounds(53, 149, 89, 23);
		panel.add(button);

		JLabel lblLength = new JLabel("Length:");
		lblLength.setBounds(10, 31, 46, 14);
		panel.add(lblLength);

		JLabel lblTotal = new JLabel("Total Size Meter Sq:");
		lblTotal.setBounds(10, 81, 110, 14);
		panel.add(lblTotal);

		txtLength = new JTextField();
		txtLength.setColumns(10);
		txtLength.setBounds(120, 28, 68, 20);
		panel.add(txtLength);

		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		txtHeight.setBounds(120, 53, 68, 20);
		panel.add(txtHeight);

		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(10, 56, 46, 14);
		panel.add(lblHeight);

		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(120, 78, 68, 20);
		panel.add(txtTotal);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Materials Required",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(234, 54, 206, 183);
		add(panel_1);

		JLabel lblInner = new JLabel("Blocks-Inner Leaf:");
		lblInner.setBounds(10, 30, 90, 14);
		panel_1.add(lblInner);

		JLabel label_4 = new JLabel("Blocks-Outer Leaf:");
		label_4.setBounds(10, 55, 90, 14);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("Cement in KG's:");
		label_5.setBounds(10, 80, 90, 14);
		panel_1.add(label_5);

		txtInner = new JTextField();
		txtInner.setEditable(false);
		txtInner.setColumns(10);
		txtInner.setBounds(110, 27, 86, 20);
		panel_1.add(txtInner);

		txtOuter = new JTextField();
		txtOuter.setEditable(false);
		txtOuter.setColumns(10);
		txtOuter.setBounds(110, 52, 86, 20);
		panel_1.add(txtOuter);

		txtCement = new JTextField();
		txtCement.setEditable(false);
		txtCement.setColumns(10);
		txtCement.setBounds(110, 77, 86, 20);
		panel_1.add(txtCement);

		JLabel label_6 = new JLabel("Sand in KG's:");
		label_6.setBounds(10, 105, 90, 14);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("Wall Ties:");
		label_7.setBounds(10, 130, 90, 14);
		panel_1.add(label_7);

		JLabel label_8 = new JLabel("Price:");
		label_8.setBounds(10, 155, 55, 14);
		panel_1.add(label_8);

		txtSand = new JTextField();
		txtSand.setEditable(false);
		txtSand.setColumns(10);
		txtSand.setBounds(110, 102, 86, 20);
		panel_1.add(txtSand);

		txtWallTies = new JTextField();
		txtWallTies.setEditable(false);
		txtWallTies.setColumns(10);
		txtWallTies.setBounds(110, 127, 86, 20);
		panel_1.add(txtWallTies);

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(110, 152, 86, 20);
		panel_1.add(textField_8);

		JLabel lblNewLabel = new JLabel("Total Price:");
		lblNewLabel.setBounds(154, 248, 54, 14);
		add(lblNewLabel);

		textField_9 = new JTextField();
		textField_9.setBounds(233, 245, 86, 20);
		add(textField_9);
		textField_9.setColumns(10);

		// Add Calculations
		// Add action listener to button
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				try {
					// Get total size of wall in square meters
					num1 = Float.parseFloat(txtLength.getText());
					num2 = Float.parseFloat(txtHeight.getText());
					total = (int) num1 * num2;

					// Convert square meter to square millimeters and divide the
					// square millimeter of a block into the size of the wall
					convert = total * 1000000;
					block = 99000;
					innerLeaf = convert / block;
					innerLeaf = (float) Math.round(innerLeaf);

					// Calculate number of wall ties required
					// Convert floats to double
					double tieConversion = (double) (total);
					double wallTies = (double) (ties);
					wallTies = tieConversion * 2.20;
					wallTies = (double) Math.round(wallTies);

					// Calculate cement in kgs needed
					double cementConversion = (double) (total);
					double cementKg = (double) (cement);
					cementKg = cementConversion * 11.7;
					cementKg = (double) Math.round(cementKg);

					// Calculate sand in kgs needed
					double sandConversion = (double) (total);
					double sandKg = (double) (sand);
					sandKg = sandConversion * 40.8;
					sandKg = (double) Math.round(sandKg);

					// Set texts
					txtTotal.setText(" " + total);
					txtInner.setText(" " + innerLeaf);
					txtOuter.setText(" " + innerLeaf);
					txtWallTies.setText(" " + wallTies);
					txtCement.setText(" " + cementKg);
					txtSand.setText(" " + sandKg);
				} catch (NumberFormatException nfe) {
					txtLength.setText("0");
					txtHeight.setText("0");
					txtTotal.setText("0");
				}

			}
		});

	}
}
