package ie.lyit.teamproject;

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
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(225, 5, 0, 0);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Dimensions",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(10, 33, 198, 200);
		add(panel_1);

		JButton button = new JButton("Calculate");
		button.setBounds(52, 166, 89, 23);
		panel_1.add(button);

		JLabel lblLength = new JLabel("Length:");
		lblLength.setBounds(10, 31, 46, 14);
		panel_1.add(lblLength);

		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setBounds(10, 56, 46, 14);
		panel_1.add(lblWidth);

		txtLength = new JTextField();
		txtLength.setColumns(10);
		txtLength.setBounds(52, 28, 86, 20);
		panel_1.add(txtLength);

		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		txtWidth.setBounds(52, 53, 86, 20);
		panel_1.add(txtWidth);

		JLabel label_2 = new JLabel("Height:");
		label_2.setBounds(10, 81, 46, 14);
		panel_1.add(label_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(52, 78, 86, 20);
		panel_1.add(textField_2);

		JRadioButton radioButton = new JRadioButton("Slate");
		radioButton.setBounds(101, 102, 58, 23);
		panel_1.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("Tile");
		radioButton_1.setSelected(true);
		radioButton_1.setBounds(52, 102, 68, 23);
		panel_1.add(radioButton_1);

		JLabel label_3 = new JLabel("Type:");
		label_3.setBounds(10, 106, 46, 14);
		panel_1.add(label_3);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Materials Required",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(225, 33, 206, 200);
		add(panel_2);

		JLabel label_4 = new JLabel("Slates/Tile:");
		label_4.setBounds(10, 30, 63, 14);
		panel_2.add(label_4);

		JLabel label_5 = new JLabel("Lats:");
		label_5.setBounds(10, 55, 63, 14);
		panel_2.add(label_5);

		JLabel label_6 = new JLabel("Rolls of Felt:");
		label_6.setBounds(10, 83, 63, 14);
		panel_2.add(label_6);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(83, 27, 86, 20);
		panel_2.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(83, 52, 86, 20);
		panel_2.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(83, 80, 86, 20);
		panel_2.add(textField_5);

		JLabel label_7 = new JLabel("Price:");
		label_7.setBounds(10, 108, 52, 14);
		panel_2.add(label_7);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(83, 105, 86, 20);
		panel_2.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setBounds(225, 257, 86, 20);
		add(textField_7);
		textField_7.setColumns(10);

		JLabel lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setBounds(130, 260, 78, 14);
		add(lblTotalPrice);

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

	}
}
