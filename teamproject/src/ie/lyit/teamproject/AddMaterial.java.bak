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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
public class AddMaterial extends JInternalFrame{
private final JPanel contentPanel = new JPanel();
	
	private DBConnectionClass dbc = new DBConnectionClass();
	
	private JLabel jlblName;
	
	private JTextField jtfName;
	private JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox jcboCategory;
	
	private JButton jbtSave;
	private JButton jbtExit;
	
	private ArrayList details;
	private String[] categories;
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddMaterial() {
		
		//Populate combobox
//		ResultSet rs = dbc.retrieveAllCategoryMaterial();
		ResultSet rs = dbc.retrieveAllCategoryMaterial();
		details = new ArrayList();
		int count = 0;
		try{
			while(rs.next())
			{
				details.add(rs.getString("description"));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		//Convert arraylist to String Array
		categories = (String[]) details.toArray(new String[details.size()]);
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Material Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 314, 113);
		contentPanel.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{47, 0, 150, 0};
		gbl_panel.rowHeights = new int[]{22, 20, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		jlblName = new JLabel("Material: ");
		GridBagConstraints gbc_jlblName = new GridBagConstraints();
		gbc_jlblName.anchor = GridBagConstraints.EAST;
		gbc_jlblName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblName.gridx = 1;
		gbc_jlblName.gridy = 1;
		panel.add(jlblName, gbc_jlblName);
		jlblName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jtfName = new JTextField();
		GridBagConstraints gbc_jtfName = new GridBagConstraints();
		gbc_jtfName.insets = new Insets(0, 0, 5, 0);
		gbc_jtfName.anchor = GridBagConstraints.NORTHWEST;
		gbc_jtfName.gridx = 2;
		gbc_jtfName.gridy = 1;
		panel.add(jtfName, gbc_jtfName);
		jtfName.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category:");
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.anchor = GridBagConstraints.EAST;
		gbc_lblCategory.insets = new Insets(0, 0, 0, 5);
		gbc_lblCategory.gridx = 1;
		gbc_lblCategory.gridy = 2;
		panel.add(lblCategory, gbc_lblCategory);
		
		comboBox = new JComboBox(categories);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		panel.add(comboBox, gbc_comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 152, 314, 77);
			buttonPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(buttonPane);
					buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JButton btnSave = new JButton("Save");
			buttonPane.add(btnSave);
			
					
					jbtExit = new JButton("Exit");
					buttonPane.add(jbtExit);
					jbtExit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							setVisible(false);
						}
					});
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String description = jtfName.getText();
					int cat_id = checkCombo();
					dbc.addMaterialToDB(cat_id, description);
					setVisible(false);
				}
			});
		}
		
		setResizable(false);
		setTitle("Add Material");
		int ownX = 455;
		int ownY = 330;
		
		int screenX = screenSize.width;
		int screenY = screenSize.height;

		int xPos = (int)((screenX / 2) - (ownX / 2)) ;
		int yPos = (int)((screenY / 2) - (ownY / 2));
		
		this.setSize(346, 271);
		this.setLocation(xPos, yPos);
		
		this.setClosable(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		this.setFrameIcon(new ImageIcon("Images/measure.png"));
		
	}
	
	private int checkCombo()
	{
		int cat_id = 0;
		int value= comboBox.getSelectedIndex();
		
		//check for 19 selections
		return value+1;
		
	}
}
