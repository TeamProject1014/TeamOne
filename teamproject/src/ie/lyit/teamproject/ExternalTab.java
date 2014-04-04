package ie.lyit.teamproject;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class ExternalTab extends JPanel {

	public ExternalTab() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel externalPanel = new JPanel();
		externalPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "External Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(externalPanel, BorderLayout.WEST);
		GridBagLayout gbl_externalPanel = new GridBagLayout();
		gbl_externalPanel.columnWidths = new int[]{200, 100, 0};
		gbl_externalPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_externalPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_externalPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		externalPanel.setLayout(gbl_externalPanel);
		
		JLabel lblNewLabel_1 = new JLabel("Excavated Material");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		externalPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Select");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		externalPanel.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Sub Base");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		externalPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Select");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		externalPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Concrete Calculator");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		externalPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Select");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 2;
		externalPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Paving Bed Calculator");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		externalPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("Select");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 3;
		externalPanel.add(btnNewButton_3, gbc_btnNewButton_3);

	}
}
