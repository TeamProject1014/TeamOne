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
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AddCategory extends JInternalFrame {
	private DBConnectionClass dbc = new DBConnectionClass();
	private JTextField jtxtDesc;
	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();

	public AddCategory() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				jtxtDesc.requestFocus();
			}
		});
		getContentPane().setLayout(null);
		setTitle("Add Category");

		JButton btnConfirm = new JButton("Add");
		btnConfirm.setBounds(35, 76, 71, 20);
		getContentPane().add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(116, 76, 79, 20);
		getContentPane().add(btnCancel);

		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(10, 29, 97, 14);
		getContentPane().add(lblDescription);

		jtxtDesc = new JTextField();
		jtxtDesc.setBounds(116, 26, 101, 20);
		getContentPane().add(jtxtDesc);
		jtxtDesc.setColumns(10);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				jtxtDesc.setText("");
			}
		});
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = dbc.retrieveCategory_id();// Get last ID from db
				String description = jtxtDesc.getText();

				if (dbc.checkCategory(description) >= 1) {
					JOptionPane.showMessageDialog(new JFrame(),
							"Category already exists");
				} else if (description.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(),
							"Enter a description");
				} else {
					dbc.createCategory(id, description);
					// setVisible(false);
					jtxtDesc.setText("");
				}

			}
		});

		// spawn
		int ownX = 455;
		int ownY = 330;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));

		this.setSize(251, 156);
		this.setLocation(xPos, yPos);

		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
		getRootPane().setDefaultButton(btnConfirm);

	}
}
