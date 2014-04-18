package ie.lyit.teamproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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

//import com.itextpdf.text.List;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class AddMaterial extends JInternalFrame {
	private final JPanel contentPanel = new JPanel();

	private DBConnectionClass dbc = new DBConnectionClass();

	private JLabel jlblName;

	public JTextField jtfName;
	private JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox jcboCategory;

	private JButton jbtCancel;
	private JButton jbtAdd;

	private ArrayList details;
	private String[] categories;
	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	private JPanel panel;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddMaterial() {

		// Populate combobox
		// ResultSet rs = dbc.retrieveAllCategoryMaterial();
		ResultSet rs = dbc.retrieveAllCategoryMaterial();
		details = new ArrayList();
		int count = 0;
		try {
			while (rs.next()) {
				details.add(rs.getString("description"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// Convert arraylist to String Array
		categories = (String[]) details.toArray(new String[details.size()]);

		getContentPane().setLayout(new BorderLayout());

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "Options", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		getContentPane().add(panel, BorderLayout.SOUTH);
		{

			jbtAdd = new JButton("Add");
			panel.add(jbtAdd);
			jbtAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String description = jtfName.getText();
					int cat_id = checkCombo();

					// Error checking
					if (dbc.checkMaterial(description) >= 1) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Material already exists");
					} else if (description.equals("") || cat_id <= 0) {
						JOptionPane.showConfirmDialog(null,
								"Incorrect details", "Incorrect details",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE);
					} else {
						dbc.addMaterialToDB(cat_id, description);
						jtfName.setText("");
						JOptionPane.showMessageDialog(new JPanel(),
								"Material added", "Confirmation",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
		getRootPane().setDefaultButton(jbtAdd);

		jbtCancel = new JButton("Cancel");
		panel.add(jbtCancel);

		jbtCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				jtfName.setText("");
			}
		});
		contentPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Material",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 65, 175, 0 };
		gbl_contentPanel.rowHeights = new int[] { 20, 20, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 0;
		contentPanel.add(lblCategory, gbc_lblCategory);

		comboBox = new JComboBox(categories);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		contentPanel.add(comboBox, gbc_comboBox);
		comboBox.setSelectedItem(null);

		jlblName = new JLabel("Material: ");
		GridBagConstraints gbc_jlblName = new GridBagConstraints();
		gbc_jlblName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblName.insets = new Insets(0, 0, 0, 5);
		gbc_jlblName.gridx = 0;
		gbc_jlblName.gridy = 2;
		contentPanel.add(jlblName, gbc_jlblName);
		jlblName.setHorizontalAlignment(SwingConstants.RIGHT);

		jtfName = new JTextField();
		GridBagConstraints gbc_jtfName = new GridBagConstraints();
		gbc_jtfName.anchor = GridBagConstraints.NORTH;
		gbc_jtfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfName.gridx = 1;
		gbc_jtfName.gridy = 2;
		contentPanel.add(jtfName, gbc_jtfName);
		jtfName.setColumns(10);

		setResizable(false);
		setTitle("Add Material");
		int ownX = 455;
		int ownY = 330;

		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int) ((screenX / 2) - (ownX / 2));
		int yPos = (int) ((screenY / 2) - (ownY / 2));

		this.setSize(303, 188);
		this.setLocation(xPos, yPos);

		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
	}

	private int checkCombo() {
		int cat_id = 0;
		int value = comboBox.getSelectedIndex();

		// check for 19 selections
		return value + 1;

	}
}
