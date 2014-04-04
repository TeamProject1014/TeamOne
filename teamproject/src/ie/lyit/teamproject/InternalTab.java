package ie.lyit.teamproject;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class InternalTab extends JPanel {

	/**
	 * Create the panel.
	 */
	public InternalTab() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel internalPanel = new JPanel();
		internalPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Internal Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(internalPanel, BorderLayout.WEST);
		GridBagLayout gbl_internalPanel = new GridBagLayout();
		gbl_internalPanel.columnWidths = new int[]{200, 100, 0};
		gbl_internalPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_internalPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_internalPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		internalPanel.setLayout(gbl_internalPanel);
		
		JLabel lblNewLabel = new JLabel("Screed Quantities");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		internalPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("Select");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		internalPanel.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Plaster Estimated Quantities");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		internalPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Select");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		internalPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stud Walls");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		internalPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Select");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 2;
		internalPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Floorboards");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		internalPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("Select");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 3;
		internalPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Wall & Floor Tiles");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		internalPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("Select");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 4;
		internalPanel.add(btnNewButton_4, gbc_btnNewButton_4);

	}

}
