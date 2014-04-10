package ie.lyit.teamproject.tabs;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Roof extends JPanel {
	private JTextField txtLength;
	private JTextField txtWidth;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	float num1, num2, pitch;

	// Constructor
	public Roof() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
				
						JLabel lblTotalPrice = new JLabel("Total Price:");
						panel.add(lblTotalPrice);
						lblTotalPrice.setBounds(130, 260, 78, 14);
		
				textField_7 = new JTextField();
				panel.add(textField_7);
				textField_7.setBounds(225, 257, 86, 20);
				textField_7.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dimensions",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(10, 33, 198, 200);
		add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 46, 45, 58, 0 };
		gbl_panel_1.rowHeights = new int[] { 20, 20, 20, 23, 41, 23, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		txtLength = new JTextField();
		txtLength.setColumns(10);
		GridBagConstraints gbc_txtLength = new GridBagConstraints();
		gbc_txtLength.anchor = GridBagConstraints.NORTH;
		gbc_txtLength.insets = new Insets(0, 0, 5, 0);
		gbc_txtLength.gridwidth = 3;
		gbc_txtLength.gridx = 0;
		gbc_txtLength.gridy = 0;
		panel_1.add(txtLength, gbc_txtLength);

		JLabel lblLength = new JLabel("Length:");
		GridBagConstraints gbc_lblLength = new GridBagConstraints();
		gbc_lblLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblLength.gridx = 0;
		gbc_lblLength.gridy = 0;
		panel_1.add(lblLength, gbc_lblLength);

		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		GridBagConstraints gbc_txtWidth = new GridBagConstraints();
		gbc_txtWidth.anchor = GridBagConstraints.NORTH;
		gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
		gbc_txtWidth.gridwidth = 3;
		gbc_txtWidth.gridx = 0;
		gbc_txtWidth.gridy = 1;
		panel_1.add(txtWidth, gbc_txtWidth);

		JLabel lblWidth = new JLabel("Width:");
		GridBagConstraints gbc_lblWidth = new GridBagConstraints();
		gbc_lblWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidth.gridx = 0;
		gbc_lblWidth.gridy = 1;
		panel_1.add(lblWidth, gbc_lblWidth);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 2;
		panel_1.add(textField_2, gbc_textField_2);

		JLabel label_2 = new JLabel("Height:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panel_1.add(label_2, gbc_label_2);

		JLabel label_3 = new JLabel("Type:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 3;
		panel_1.add(label_3, gbc_label_3);

		JRadioButton radioButton_1 = new JRadioButton("Tile");
		radioButton_1.setSelected(true);
		GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
		gbc_radioButton_1.anchor = GridBagConstraints.NORTH;
		gbc_radioButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_radioButton_1.gridwidth = 3;
		gbc_radioButton_1.gridx = 0;
		gbc_radioButton_1.gridy = 3;
		panel_1.add(radioButton_1, gbc_radioButton_1);

		JRadioButton radioButton = new JRadioButton("Slate");
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.anchor = GridBagConstraints.NORTH;
		gbc_radioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_radioButton.insets = new Insets(0, 0, 5, 0);
		gbc_radioButton.gridx = 2;
		gbc_radioButton.gridy = 3;
		panel_1.add(radioButton, gbc_radioButton);

		JButton button = new JButton("Calculate");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTH;
		gbc_button.gridwidth = 3;
		gbc_button.gridx = 0;
		gbc_button.gridy = 5;
		panel_1.add(button, gbc_button);

		// Add Calculations
		// Add action listener to button
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				num1 = Float.parseFloat(txtLength.getText());
				num2 = Float.parseFloat(txtWidth.getText());
				pitch = num1 / num2;

			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Materials Required",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(225, 33, 206, 200);
		add(panel_2, BorderLayout.EAST);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 63, 86, 0 };
		gbl_panel_2.rowHeights = new int[] { 20, 20, 20, 20, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel label_4 = new JLabel("Slates/Tile:");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 0;
		panel_2.add(label_4, gbc_label_4);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 0;
		panel_2.add(textField_3, gbc_textField_3);

		JLabel label_5 = new JLabel("Lats:");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 1;
		panel_2.add(label_5, gbc_label_5);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 1;
		panel_2.add(textField_4, gbc_textField_4);

		JLabel label_6 = new JLabel("Rolls of Felt:");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 2;
		panel_2.add(label_6, gbc_label_6);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 2;
		panel_2.add(textField_5, gbc_textField_5);

		JLabel label_7 = new JLabel("Price:");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_7.insets = new Insets(0, 0, 0, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 3;
		panel_2.add(label_7, gbc_label_7);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 3;
		panel_2.add(textField_6, gbc_textField_6);

	}
}
