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

public class SubBase extends JPanel {
	private JTextField txtLength;
	private JTextField txtWidth;
	private JTextField txtTotalSize;
	private JTextField txtDepth;
	private JTextField txtCruserRun;
	private JTextField txtPrice;
	private JTextField textField;

	private double length, width, area;

	public SubBase() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(

		EtchedBorder.LOWERED, null, null), "Dimensions",

		TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
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

		JLabel label_1 = new JLabel("Width:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);

		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		GridBagConstraints gbc_txtWidth = new GridBagConstraints();
		gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWidth.anchor = GridBagConstraints.NORTH;
		gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
		gbc_txtWidth.gridx = 1;
		gbc_txtWidth.gridy = 1;
		panel.add(txtWidth, gbc_txtWidth);

		JLabel lblDepth = new JLabel("Depth:");
		GridBagConstraints gbc_lblDepth = new GridBagConstraints();
		gbc_lblDepth.anchor = GridBagConstraints.EAST;
		gbc_lblDepth.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepth.gridx = 0;
		gbc_lblDepth.gridy = 2;
		panel.add(lblDepth, gbc_lblDepth);

		txtDepth = new JTextField();
		GridBagConstraints gbc_txtDepth = new GridBagConstraints();
		gbc_txtDepth.insets = new Insets(0, 0, 5, 0);
		gbc_txtDepth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDepth.gridx = 1;
		gbc_txtDepth.gridy = 2;
		panel.add(txtDepth, gbc_txtDepth);
		txtDepth.setColumns(10);

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

		JLabel lblCrusherRun = new JLabel("Crusher Run:");
		GridBagConstraints gbc_lblCrusherRun = new GridBagConstraints();
		gbc_lblCrusherRun.anchor = GridBagConstraints.EAST;
		gbc_lblCrusherRun.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrusherRun.gridx = 0;
		gbc_lblCrusherRun.gridy = 0;
		panel_1.add(lblCrusherRun, gbc_lblCrusherRun);

		txtCruserRun = new JTextField();
		txtCruserRun.setEditable(false);
		txtCruserRun.setColumns(10);
		GridBagConstraints gbc_txtCruserRun = new GridBagConstraints();
		gbc_txtCruserRun.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCruserRun.insets = new Insets(0, 0, 5, 0);
		gbc_txtCruserRun.gridx = 1;
		gbc_txtCruserRun.gridy = 0;
		panel_1.add(txtCruserRun, gbc_txtCruserRun);

		JLabel label_5 = new JLabel("Price:");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 2;
		panel_1.add(label_5, gbc_label_5);

		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		GridBagConstraints gbc_txtPrice = new GridBagConstraints();
		gbc_txtPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrice.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrice.gridx = 1;
		gbc_txtPrice.gridy = 2;
		panel_1.add(txtPrice, gbc_txtPrice);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel label_3 = new JLabel("TotalPrice:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label_3);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		panel_2.add(textField);

		JButton jbtCalculate = new JButton("Calculate");
		jbtCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Execute when button is pressed
				try {
					// Get total size of wall in square meters
					length = Double.parseDouble(txtLength.getText());
					width = Double.parseDouble(txtWidth.getText());
					area = (int) length * width;

					// set Texts
					txtTotalSize.setText(" " + area);

				} catch (NumberFormatException nfe) {
					txtLength.setText("0");
					txtWidth.setText("0");
					txtTotalSize.setText("0");
				}
			}
		});

	}

}
