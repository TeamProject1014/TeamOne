package ie.lyit.teamproject;

import javax.swing.JPanel;

import java.awt.BorderLayout;
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

public class WallsTab extends JPanel {

	@SuppressWarnings("unused")
	private int innerLeaf, outerleaf, ties, cement, sand;
	private double length, height, area;
	private final double BLOCK = 0.10125;
	private final double TIES_PER_SQ_M = 2.2;
	private final double SAND_PER_SQ_M = 40.8;
	private final double CEMENT_PER_SQ_M = 11.7;

	public WallsTab() {
		setLayout(new BorderLayout(0, 0));

		JPanel wallPanel = new JPanel();
		wallPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Walls Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(wallPanel, BorderLayout.WEST);
		GridBagLayout gbl_wallPanel = new GridBagLayout();
		gbl_wallPanel.columnWidths = new int[] { 200, 100, 0 };
		gbl_wallPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_wallPanel.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_wallPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		wallPanel.setLayout(gbl_wallPanel);
		
		JLabel lblNewLabel = new JLabel("Mortar Calculator");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		wallPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("Select");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		wallPanel.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Brick, Block & Mortar Quantities");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		wallPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Select");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		wallPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cavity Wall Calculator");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		wallPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Select");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JobScreen.resetLowerPanes();
				JobScreen.wallCalc.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 3;
		wallPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JLabel lblRenderQuantities = new JLabel("Render Quantities");
		GridBagConstraints gbc_lblRenderQuantities = new GridBagConstraints();
		gbc_lblRenderQuantities.anchor = GridBagConstraints.WEST;
		gbc_lblRenderQuantities.insets = new Insets(0, 0, 5, 5);
		gbc_lblRenderQuantities.gridx = 0;
		gbc_lblRenderQuantities.gridy = 4;
		wallPanel.add(lblRenderQuantities, gbc_lblRenderQuantities);
		
		JButton btnNewButton_3 = new JButton("Select");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 4;
		wallPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JLabel lblNotLisetd = new JLabel("Not Listed");
		GridBagConstraints gbc_lblNotLisetd = new GridBagConstraints();
		gbc_lblNotLisetd.anchor = GridBagConstraints.WEST;
		gbc_lblNotLisetd.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotLisetd.gridx = 0;
		gbc_lblNotLisetd.gridy = 5;
		wallPanel.add(lblNotLisetd, gbc_lblNotLisetd);
		
		JButton btnNewButton_4 = new JButton("Select");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobScreen.resetLowerPanes();
				JobScreen.setCategoryToOpen(1);
				//ExternalAdd.updateTable();
				JobScreen.externalAdd.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 5;
		wallPanel.add(btnNewButton_4, gbc_btnNewButton_4);

	}
}
