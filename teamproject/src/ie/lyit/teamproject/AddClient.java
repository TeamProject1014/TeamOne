package ie.lyit.teamproject;

import java.awt.BorderLayout;
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

@SuppressWarnings("serial")
public class AddClient extends JInternalFrame{
private final JPanel contentPanel = new JPanel();
	
	private DBConnectionClass dbc = new DBConnectionClass();
	
	private JLabel jlblName;
	private JLabel jlblAddr;
	private JLabel jlblAddr2;
	private JLabel jlblTown;
	private JLabel jlblCounty;
	private JLabel jlblPhone;
	private JLabel jlblEmail;
	
	private JTextField jtfName;
	private JTextField jtfAddr;
	private JTextField jtfAddr2;
	private JTextField jtfTown;
	private JTextField jtfPhone;
	private JTextField jtfEmail;
	
	@SuppressWarnings("rawtypes")
	private JComboBox jcboCounty;
	
	private JButton jbtSave;
	private JButton jbtExit;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			AddClient dialog = new AddClient();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddClient() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		jtfName = new JTextField();
		jtfName.setColumns(10);
		jtfName.setBounds(124, 11, 160, 20);
		contentPanel.add(jtfName);
		
		jlblName = new JLabel("Name:");
		jlblName.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblName.setBounds(10, 11, 100, 14);
		contentPanel.add(jlblName);
		
		jlblAddr = new JLabel("Address:");
		jlblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblAddr.setBounds(10, 41, 100, 14);
		contentPanel.add(jlblAddr);
		
		jtfAddr = new JTextField();
		jtfAddr.setColumns(10);
		jtfAddr.setBounds(124, 41, 160, 20);
		contentPanel.add(jtfAddr);
		
		jtfAddr2 = new JTextField();
		jtfAddr2.setColumns(10);
		jtfAddr2.setBounds(124, 71, 160, 20);
		contentPanel.add(jtfAddr2);
		
		jlblAddr2 = new JLabel("Address Line 2:");
		jlblAddr2.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblAddr2.setBounds(10, 71, 100, 14);
		contentPanel.add(jlblAddr2);
		
		jlblTown = new JLabel("Town:");
		jlblTown.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblTown.setBounds(10, 101, 100, 14);
		contentPanel.add(jlblTown);
		
		jtfTown = new JTextField();
		jtfTown.setColumns(10);
		jtfTown.setBounds(124, 101, 160, 20);
		contentPanel.add(jtfTown);
		
		String[] county = {"Antrim", "Armagh", "Carlow", "Cavan", "Clare", "Cork", 
				"Derry", "Donegal", "Down", "Dublin", "Fermanagh", 
				"Galway", "Kerry", "Kildare", "Kilkenny", "Laois", "Leitrim", 
				"Limerick", "Longford", "Louth", "Mayo", "Meath",
				"Monaghan", "Offaly", "Roscommon", "Sligo", "Tipperary", 
				"Tyrone", "Waterford", "Westmeath", "Wexford", "Wicklow"};

		jcboCounty = new JComboBox(county);
		jcboCounty.setSelectedItem("Donegal");
		jcboCounty.setBounds(124, 131, 160, 20);
		contentPanel.add(jcboCounty);
		
		jlblCounty = new JLabel("County:");
		jlblCounty.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblCounty.setBounds(10, 131, 100, 14);
		contentPanel.add(jlblCounty);
		
		jlblPhone = new JLabel("Phone Number:");
		jlblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblPhone.setBounds(10, 161, 100, 14);
		contentPanel.add(jlblPhone);
		
		jtfPhone = new JTextField();
		jtfPhone.setColumns(10);
		jtfPhone.setBounds(124, 161, 160, 20);
		contentPanel.add(jtfPhone);
		
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		jtfEmail.setBounds(124, 191, 160, 20);
		contentPanel.add(jtfEmail);
		
		jlblEmail = new JLabel("Email:");
		jlblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblEmail.setBounds(10, 191, 100, 14);
		contentPanel.add(jlblEmail);

		jbtSave = new JButton("Save");
		jbtSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = jtfName.getText();
				String address = jtfAddr.getText();
				String address2 = jtfAddr2.getText();
				String town = jtfTown.getText();
				String county = (String)jcboCounty.getSelectedItem();
				int phone = (Integer.parseInt(jtfPhone.getText()));
				String email = jtfEmail.getText();
				dbc.createClient(name, address, address2, town, county, phone, email);
				setVisible(false);
			}
		});
		jbtSave.setBounds(108, 233, 85, 20);
		contentPanel.add(jbtSave);
		
		jbtExit = new JButton("Exit");
		jbtExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		jbtExit.setBounds(199, 233, 85, 20);
		contentPanel.add(jbtExit);
		
		setResizable(false);
		setTitle("Add Client");
		setBounds(100, 100, 340, 315);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
