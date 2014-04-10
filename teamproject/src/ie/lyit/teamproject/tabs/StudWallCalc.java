package ie.lyit.teamproject.tabs;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

public class StudWallCalc extends JPanel
{
	private JTextField txtLength;
	private JTextField txtHeight;
	private JTextField txtTotalSize;
	private JTextField txtStud;
	private JTextField txtPlasterBoard;
	private JTextField txtInsulation;
	private JTextField txtScrews;
	private JTextField txtCloth;
	private JTextField txtPrice;
	private JTextField textField_9;
	public StudWallCalc() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(
						EtchedBorder.LOWERED, null, null), "Dimensions",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblLinearMetersOf = new JLabel("Linear Meters of Stud:");
		GridBagConstraints gbc_lblLinearMetersOf = new GridBagConstraints();
		gbc_lblLinearMetersOf.anchor = GridBagConstraints.EAST;
		gbc_lblLinearMetersOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinearMetersOf.gridx = 0;
		gbc_lblLinearMetersOf.gridy = 0;
		panel_1.add(lblLinearMetersOf, gbc_lblLinearMetersOf);
		
		txtStud = new JTextField();
		txtStud.setEditable(false);
		txtStud.setColumns(10);
		GridBagConstraints gbc_txtStud = new GridBagConstraints();
		gbc_txtStud.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStud.insets = new Insets(0, 0, 5, 0);
		gbc_txtStud.gridx = 1;
		gbc_txtStud.gridy = 0;
		panel_1.add(txtStud, gbc_txtStud);
		
		JLabel lblSheetsOfPlasterboard = new JLabel("Sheets of plasterboard:");
		GridBagConstraints gbc_lblSheetsOfPlasterboard = new GridBagConstraints();
		gbc_lblSheetsOfPlasterboard.anchor = GridBagConstraints.EAST;
		gbc_lblSheetsOfPlasterboard.insets = new Insets(0, 0, 5, 5);
		gbc_lblSheetsOfPlasterboard.gridx = 0;
		gbc_lblSheetsOfPlasterboard.gridy = 1;
		panel_1.add(lblSheetsOfPlasterboard, gbc_lblSheetsOfPlasterboard);
		
		txtPlasterBoard = new JTextField();
		txtPlasterBoard.setEditable(false);
		txtPlasterBoard.setColumns(10);
		GridBagConstraints gbc_txtPlasterBoard = new GridBagConstraints();
		gbc_txtPlasterBoard.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlasterBoard.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlasterBoard.gridx = 1;
		gbc_txtPlasterBoard.gridy = 1;
		panel_1.add(txtPlasterBoard, gbc_txtPlasterBoard);
		
		JLabel lblLinearMetersOf_1 = new JLabel("Linear meters of Insulation:");
		GridBagConstraints gbc_lblLinearMetersOf_1 = new GridBagConstraints();
		gbc_lblLinearMetersOf_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblLinearMetersOf_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinearMetersOf_1.gridx = 0;
		gbc_lblLinearMetersOf_1.gridy = 2;
		panel_1.add(lblLinearMetersOf_1, gbc_lblLinearMetersOf_1);
		
		txtInsulation = new JTextField();
		txtInsulation.setEditable(false);
		txtInsulation.setColumns(10);
		GridBagConstraints gbc_txtInsulation = new GridBagConstraints();
		gbc_txtInsulation.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsulation.insets = new Insets(0, 0, 5, 0);
		gbc_txtInsulation.gridx = 1;
		gbc_txtInsulation.gridy = 2;
		panel_1.add(txtInsulation, gbc_txtInsulation);
		
		JLabel lblScrimClothTape = new JLabel("Drywall Screws:");
		GridBagConstraints gbc_lblScrimClothTape = new GridBagConstraints();
		gbc_lblScrimClothTape.anchor = GridBagConstraints.EAST;
		gbc_lblScrimClothTape.insets = new Insets(0, 0, 5, 5);
		gbc_lblScrimClothTape.gridx = 0;
		gbc_lblScrimClothTape.gridy = 3;
		panel_1.add(lblScrimClothTape, gbc_lblScrimClothTape);
		
		txtScrews = new JTextField();
		txtScrews.setEditable(false);
		txtScrews.setColumns(10);
		GridBagConstraints gbc_txtScrews = new GridBagConstraints();
		gbc_txtScrews.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtScrews.insets = new Insets(0, 0, 5, 0);
		gbc_txtScrews.gridx = 1;
		gbc_txtScrews.gridy = 3;
		panel_1.add(txtScrews, gbc_txtScrews);
		
		JLabel lblScrimClothTape_1 = new JLabel("Scrim Cloth tape:");
		GridBagConstraints gbc_lblScrimClothTape_1 = new GridBagConstraints();
		gbc_lblScrimClothTape_1.anchor = GridBagConstraints.EAST;
		gbc_lblScrimClothTape_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblScrimClothTape_1.gridx = 0;
		gbc_lblScrimClothTape_1.gridy = 4;
		panel_1.add(lblScrimClothTape_1, gbc_lblScrimClothTape_1);
		
		txtCloth = new JTextField();
		txtCloth.setEditable(false);
		txtCloth.setColumns(10);
		GridBagConstraints gbc_txtCloth = new GridBagConstraints();
		gbc_txtCloth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCloth.insets = new Insets(0, 0, 5, 0);
		gbc_txtCloth.gridx = 1;
		gbc_txtCloth.gridy = 4;
		panel_1.add(txtCloth, gbc_txtCloth);
		
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
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		panel_2.add(textField_9);
	}
	
}
