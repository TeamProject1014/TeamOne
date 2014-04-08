package ie.lyit.teamproject;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AddCategory extends JInternalFrame {
	private DBConnectionClass dbc = new DBConnectionClass();
	private JTextField jtxtDesc;
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public AddCategory()
	{
		getContentPane().setLayout(null);
		
		JPanel txtPanel = new JPanel();
		txtPanel.setBounds(10, 11, 424, 76);
		getContentPane().add(txtPanel);
		txtPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Category Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_txtPanel = new GridBagLayout();
		gbl_txtPanel.columnWidths = new int[]{53, 101, 131, 0};
		gbl_txtPanel.rowHeights = new int[]{0, 25, 0, 0};
		gbl_txtPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_txtPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		txtPanel.setLayout(gbl_txtPanel);
		
		JLabel lblDescription = new JLabel("Description: ");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 1;
		txtPanel.add(lblDescription, gbc_lblDescription);
		
		jtxtDesc = new JTextField();
		GridBagConstraints gbc_jtxtDesc = new GridBagConstraints();
		gbc_jtxtDesc.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtDesc.anchor = GridBagConstraints.NORTH;
		gbc_jtxtDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtDesc.gridx = 2;
		gbc_jtxtDesc.gridy = 1;
		txtPanel.add(jtxtDesc, gbc_jtxtDesc);
		jtxtDesc.setColumns(10);
		
		JPanel options = new JPanel();
		options.setBounds(10, 98, 424, 76);
		getContentPane().add(options);
		options.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Options",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = dbc.retrieveCategory_id();//Get last ID from db
				
				String description = jtxtDesc.getText();  
				dbc.createCategory(id, description);
				setVisible(false);
			}
		});
		options.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		options.add(btnCancel);
		
		//spawn
		int ownX = 455;
		int ownY = 330;
		
		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int)((screenX / 2) - (ownX / 2)) ;
		int yPos = (int)((screenY / 2) - (ownY / 2));
		
		this.setSize(454, 213);
		this.setLocation(xPos, yPos);
		
		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
		
	}
}
