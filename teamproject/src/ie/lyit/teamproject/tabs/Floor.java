package ie.lyit.teamproject.tabs;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

// FastFoodMenu IS-A JPanel ==> Inheritance
public class Floor extends JPanel {
	private JTextField txtLength;
	// private JTextField txtMatWidth;
	private JTextField txtMatWidth;
	private JTextField txtMatNeeded;
	private JTextField txtwidth;
	private JTextField txtWidth1;
	private JTextField txtMatLength1;
	private JTextField txtMatRequired;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	float length, width, matLength, matWidth, total, matTotal, matNeeded;
	private JTextField txtMatWidth1;

	// Constructor
	public Floor() {
		setLayout(new BorderLayout(0, 0));

		// JPanel panel = new JPanel();
		// panel.setBounds(224, 5, 1, 1);
		// panel.setLayout(null);
		// panel.setBorder(new TitledBorder(null, "Dimensions",
		// TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		// add(panel);
		//
		// JButton button = new JButton("Calculate");
		// button.setBounds(52, 166, 89, 23);
		// panel.add(button);
		//
		// JLabel label = new JLabel("Length:");
		// label.setBounds(10, 31, 46, 14);
		// panel.add(label);
		//
		// JLabel label_1 = new JLabel("Width:");
		// label_1.setBounds(10, 56, 46, 14);
		// panel.add(label_1);
		//
		// txtLength = new JTextField();
		// txtLength.setColumns(10);
		// txtLength.setBounds(102, 28, 86, 20);
		// panel.add(txtLength);
		//
		// //txtWidth = new JTextField();
		// //txtWidth.setColumns(10);
		// //txtWidth.setBounds(102, 53, 86, 20);
		// //panel.add(txtWidth);
		//
		// JLabel label_2 = new JLabel("Length of Material:");
		// label_2.setBounds(10, 81, 98, 14);
		// panel.add(label_2);
		//
		// txtMatWidth = new JTextField();
		// txtMatWidth.setColumns(10);
		// txtMatWidth.setBounds(102, 78, 86, 20);
		// panel.add(txtMatWidth);
		//
		// JRadioButton radioButton = new JRadioButton("Tile");
		// radioButton.setBounds(105, 136, 58, 23);
		// panel.add(radioButton);
		//
		// JRadioButton radioButton_1 = new JRadioButton("Wood");
		// radioButton_1.setSelected(true);
		// radioButton_1.setBounds(52, 136, 68, 23);
		// panel.add(radioButton_1);
		//
		// JLabel label_3 = new JLabel("Type:");
		// label_3.setBounds(10, 141, 46, 14);
		// panel.add(label_3);
		//
		// JLabel label_4 = new JLabel("Width of Material:");
		// label_4.setBounds(10, 106, 98, 14);
		// panel.add(label_4);
		//
		// txtMatWidth = new JTextField();
		// txtMatWidth.setColumns(10);
		// txtMatWidth.setBounds(102, 103, 86, 20);
		// panel.add(txtMatWidth);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dimensions",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(10, 41, 198, 200);
		add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 46, 75, 0 };
		gbl_panel_1.rowHeights = new int[] { 20, 20, 20, 20, 23, 23, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel label_5 = new JLabel("Length:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 0;
		panel_1.add(label_5, gbc_label_5);
		
				txtMatNeeded = new JTextField();
				txtMatNeeded.setColumns(10);
				GridBagConstraints gbc_txtMatNeeded = new GridBagConstraints();
				gbc_txtMatNeeded.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtMatNeeded.anchor = GridBagConstraints.NORTH;
				gbc_txtMatNeeded.insets = new Insets(0, 0, 5, 0);
				gbc_txtMatNeeded.gridx = 1;
				gbc_txtMatNeeded.gridy = 0;
				panel_1.add(txtMatNeeded, gbc_txtMatNeeded);

		JLabel label_6 = new JLabel("Width:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 1;
		panel_1.add(label_6, gbc_label_6);
		
				txtwidth = new JTextField();
				txtwidth.setColumns(10);
				GridBagConstraints gbc_txtwidth = new GridBagConstraints();
				gbc_txtwidth.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtwidth.anchor = GridBagConstraints.NORTH;
				gbc_txtwidth.insets = new Insets(0, 0, 5, 0);
				gbc_txtwidth.gridx = 1;
				gbc_txtwidth.gridy = 1;
				panel_1.add(txtwidth, gbc_txtwidth);

		JLabel lblMaterialLength = new JLabel("Material Length:");
		lblMaterialLength.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblMaterialLength = new GridBagConstraints();
		gbc_lblMaterialLength.anchor = GridBagConstraints.WEST;
		gbc_lblMaterialLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaterialLength.gridx = 0;
		gbc_lblMaterialLength.gridy = 2;
		panel_1.add(lblMaterialLength, gbc_lblMaterialLength);
		
				txtWidth1 = new JTextField();
				txtWidth1.setColumns(10);
				GridBagConstraints gbc_txtWidth1 = new GridBagConstraints();
				gbc_txtWidth1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtWidth1.anchor = GridBagConstraints.NORTH;
				gbc_txtWidth1.insets = new Insets(0, 0, 5, 0);
				gbc_txtWidth1.gridx = 1;
				gbc_txtWidth1.gridy = 2;
				panel_1.add(txtWidth1, gbc_txtWidth1);

		JLabel lblMaterialWidth = new JLabel("Material Width:");
		lblMaterialWidth.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblMaterialWidth = new GridBagConstraints();
		gbc_lblMaterialWidth.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMaterialWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaterialWidth.gridx = 0;
		gbc_lblMaterialWidth.gridy = 3;
		panel_1.add(lblMaterialWidth, gbc_lblMaterialWidth);
		
				txtMatWidth1 = new JTextField();
				GridBagConstraints gbc_txtMatWidth1 = new GridBagConstraints();
				gbc_txtMatWidth1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtMatWidth1.anchor = GridBagConstraints.NORTH;
				gbc_txtMatWidth1.insets = new Insets(0, 0, 5, 0);
				gbc_txtMatWidth1.gridx = 1;
				gbc_txtMatWidth1.gridy = 3;
				panel_1.add(txtMatWidth1, gbc_txtMatWidth1);
				txtMatWidth1.setColumns(10);

		JRadioButton radioButton_3 = new JRadioButton("Wood");
		radioButton_3.setSelected(true);
		GridBagConstraints gbc_radioButton_3 = new GridBagConstraints();
		gbc_radioButton_3.anchor = GridBagConstraints.NORTH;
		gbc_radioButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_3.gridx = 0;
		gbc_radioButton_3.gridy = 4;
		panel_1.add(radioButton_3, gbc_radioButton_3);
		
				JRadioButton radioButton_2 = new JRadioButton("Tile");
				GridBagConstraints gbc_radioButton_2 = new GridBagConstraints();
				gbc_radioButton_2.anchor = GridBagConstraints.NORTH;
				gbc_radioButton_2.insets = new Insets(0, 0, 5, 0);
				gbc_radioButton_2.gridx = 1;
				gbc_radioButton_2.gridy = 4;
				panel_1.add(radioButton_2, gbc_radioButton_2);

		JButton btnCalculate = new JButton("Calculate");
		GridBagConstraints gbc_btnCalculate = new GridBagConstraints();
		gbc_btnCalculate.anchor = GridBagConstraints.NORTH;
		gbc_btnCalculate.gridwidth = 2;
		gbc_btnCalculate.gridx = 0;
		gbc_btnCalculate.gridy = 5;
		panel_1.add(btnCalculate, gbc_btnCalculate);

		// Add Calculations
		// Add action listener to button
		btnCalculate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					// Get total size of floor in square meters
					length = Float.parseFloat(txtMatNeeded.getText());
					width = Float.parseFloat(txtwidth.getText());
					total = (int) length * width;

					// Get total size of material
					matWidth = Float.parseFloat(txtWidth1.getText());
					matLength = Float.parseFloat(txtMatWidth1.getText());
					matTotal = (int) matLength * matWidth;

					// Calculate material needed
					matNeeded = total / matTotal;

					// set text
					txtMatRequired.setText(" " + matNeeded);

				}

				catch (NumberFormatException nfe) {
					txtLength.setText("0");
					txtwidth.setText("0");
					txtWidth1.setText("0");
					txtMatWidth.setText("0");
					txtMatWidth.setText("0");
					txtMatNeeded.setText("0");

				}

			}

		});

		// txtMatLength = new JTextField();
		// txtMatLength.setColumns(10);
		// txtMatLength.setBounds(102, 103, 86, 20);
		// panel_1.add(txtMatLength);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Materials Required",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(224, 41, 206, 200);
		add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 69, 45, 0 };
		gbl_panel_2.rowHeights = new int[] { 20, 20, 20, 20, 20, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblMaterialM = new JLabel("Material m2:");
		GridBagConstraints gbc_lblMaterialM = new GridBagConstraints();
		gbc_lblMaterialM.anchor = GridBagConstraints.EAST;
		gbc_lblMaterialM.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaterialM.gridx = 0;
		gbc_lblMaterialM.gridy = 0;
		panel_2.add(lblMaterialM, gbc_lblMaterialM);

		txtMatRequired = new JTextField();
		txtMatRequired.setEditable(false);
		txtMatRequired.setColumns(10);
		GridBagConstraints gbc_txtMatRequired = new GridBagConstraints();
		gbc_txtMatRequired.anchor = GridBagConstraints.NORTH;
		gbc_txtMatRequired.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMatRequired.insets = new Insets(0, 0, 5, 0);
		gbc_txtMatRequired.gridx = 1;
		gbc_txtMatRequired.gridy = 0;
		panel_2.add(txtMatRequired, gbc_txtMatRequired);

		JLabel lblUnderlay = new JLabel("Underlay:");
		GridBagConstraints gbc_lblUnderlay = new GridBagConstraints();
		gbc_lblUnderlay.anchor = GridBagConstraints.EAST;
		gbc_lblUnderlay.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnderlay.gridx = 0;
		gbc_lblUnderlay.gridy = 1;
		panel_2.add(lblUnderlay, gbc_lblUnderlay);

		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.anchor = GridBagConstraints.NORTH;
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 1;
		panel_2.add(textField_9, gbc_textField_9);

		JLabel label_11 = new JLabel("Grout:");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.anchor = GridBagConstraints.EAST;
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 2;
		panel_2.add(label_11, gbc_label_11);

		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.anchor = GridBagConstraints.NORTH;
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.insets = new Insets(0, 0, 5, 0);
		gbc_textField_10.gridx = 1;
		gbc_textField_10.gridy = 2;
		panel_2.add(textField_10, gbc_textField_10);

		JLabel label_13 = new JLabel("Adhesive:");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.anchor = GridBagConstraints.EAST;
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 0;
		gbc_label_13.gridy = 3;
		panel_2.add(label_13, gbc_label_13);

		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.anchor = GridBagConstraints.NORTH;
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.insets = new Insets(0, 0, 5, 0);
		gbc_textField_11.gridx = 1;
		gbc_textField_11.gridy = 3;
		panel_2.add(textField_11, gbc_textField_11);

		JLabel label_14 = new JLabel("Price:");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.anchor = GridBagConstraints.EAST;
		gbc_label_14.insets = new Insets(0, 0, 0, 5);
		gbc_label_14.gridx = 0;
		gbc_label_14.gridy = 4;
		panel_2.add(label_14, gbc_label_14);

		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.anchor = GridBagConstraints.NORTH;
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.gridx = 1;
		gbc_textField_12.gridy = 4;
		panel_2.add(textField_12, gbc_textField_12);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("Total Price:");
		panel.add(lblNewLabel);
		lblNewLabel.setBounds(136, 252, 72, 14);

		textField_13 = new JTextField();
		panel.add(textField_13);
		textField_13.setBounds(224, 249, 86, 20);
		textField_13.setColumns(10);

		setPreferredSize(new Dimension(320, 200));
	}
}
