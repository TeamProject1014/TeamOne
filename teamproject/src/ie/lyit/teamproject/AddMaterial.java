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
		{
					
					JButton btnSave = new JButton("Add");
					btnSave.setBounds(27, 97, 65, 23);
					contentPanel.add(btnSave);
					
							
							jbtExit = new JButton("Cancel");
							jbtExit.setBounds(108, 97, 86, 23);
							contentPanel.add(jbtExit);
							
							jtfName = new JTextField();
							jtfName.setBounds(108, 49, 109, 20);
							contentPanel.add(jtfName);
							jtfName.setColumns(10);
							
							jlblName = new JLabel("Material: ");
							jlblName.setBounds(27, 52, 65, 14);
							contentPanel.add(jlblName);
							jlblName.setHorizontalAlignment(SwingConstants.RIGHT);
							
							JLabel lblCategory = new JLabel("Category:");
							lblCategory.setHorizontalAlignment(SwingConstants.RIGHT);
							lblCategory.setBounds(27, 21, 65, 14);
							contentPanel.add(lblCategory);
							
							comboBox = new JComboBox(categories);
							comboBox.setBounds(108, 18, 109, 20);
							contentPanel.add(comboBox);
							jbtExit.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									setVisible(false);
									
								}
							});
					btnSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String description = jtfName.getText();
							int cat_id = checkCombo();
							
							//Error handling
							if(dbc.checkMaterial(description) >= 1)
							{
								JOptionPane.showMessageDialog(new JFrame(), "Material already exists");
							}
							else if(description.equals("") || cat_id<=0)
							{
								JOptionPane.showConfirmDialog(null,
										"Incorrect details", "Incorrect details",
										JOptionPane.DEFAULT_OPTION,
										JOptionPane.WARNING_MESSAGE);
							}
							else
							{
								dbc.addMaterialToDB(cat_id, description);
								jtfName.setText("");
								
								//setVisible(false);
							}
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
		
		this.setSize(259, 188);
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
