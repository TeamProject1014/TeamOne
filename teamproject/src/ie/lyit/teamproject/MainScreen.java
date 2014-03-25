package ie.lyit.teamproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {

	static JDesktopPane desk;
	private JFrame frame;
	
	private JMenuBar menubar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu addMenu;
	private JMenu viewMenu;
	private JMenu helpMenu;
	
	private JMenuItem optionNew;
	
	private JMenuItem editUser;
	private JMenuItem editMaterial;
	private JMenuItem editCategory;
	
	private JMenuItem addUser;
	private JMenuItem addMaterial;
	private JMenuItem addCategory;
	
	private JMenuItem viewUser;
	private JMenuItem viewClient;
	private JMenuItem viewMaterial;
	private JMenuItem viewCategory;
	private JMenuItem viewArchitect;
	private JMenuItem viewEngineer;
	private JMenuItem viewBuilder;
	
	private JMenuItem about;
	
	private static String pageTitle;

	//protected static ProjectOverview projectOverview;
	protected static AddJob addJob;
	protected static OpenProject openProject;
	protected static AddClient addClient;
	protected static AddCharacter addCharacter;
	protected static EditCharacter editCharacter;
	
	public MainScreen() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame("JDeskopPane");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desk = new JDesktopPane();
		
		addJob = new AddJob();
		desk.add(addJob);
		addJob.setVisible(false);;
		
		openProject = new OpenProject();
		desk.add(openProject);
		openProject.setVisible(false);
		
		//projectOverview = new ProjectOverview(1);
//		projectOverview = new ProjectOverview(OpenProject.getProjectToOpen());
//		desk.add(projectOverview);
//		projectOverview.setVisible(false);
				
		addCharacter = new AddCharacter();
		desk.add(addCharacter);
		addCharacter.setVisible(false);
		
		editCharacter = new EditCharacter();
		desk.add(editCharacter);
		editCharacter.setVisible(false);
		
		Action newAction = new AbstractAction("New", new ImageIcon("Images/new.png")){
			public void actionPerformed(ActionEvent e){
				addJob.setVisible(true);
				addJob.toFront();
			}
		};
			
		Action openAction = new AbstractAction("Open", new ImageIcon("Images/open.png")){
			public void actionPerformed(ActionEvent e){
				openProject.setVisible(true);
				openProject.toFront();
			}
		};
		//openAction.putValue(Action.MNEMONIC_KEY,  new Integer(KeyEvent.VK_O));
		openAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control O"));
		openAction.putValue(Action.SHORT_DESCRIPTION,  "Open");
		
		Action addClientAction = new AbstractAction("Client", new ImageIcon("")){
			public void actionPerformed(ActionEvent e){
				MainScreen.setPageTitle("Client");
				AddCharacter.resetValues();
				
				addCharacter.setVisible(true);
				addCharacter.setTitle("Add " + pageTitle);
				addCharacter.toFront();
			}
		};
		
		Action addArchAction = new AbstractAction("Architect", new ImageIcon("")){
			public void actionPerformed(ActionEvent e){
				MainScreen.setPageTitle("Architect");
				AddCharacter.resetValues();
				
				addCharacter.setVisible(true);
				addCharacter.setTitle("Add " + pageTitle);
				addCharacter.toFront();
			}
		};
		
		Action addEngAction = new AbstractAction("Engineer", new ImageIcon("")){
			public void actionPerformed(ActionEvent e){
				MainScreen.setPageTitle("Engineer");
				AddCharacter.resetValues();
				
				addCharacter.setVisible(true);
				addCharacter.setTitle("Add " + pageTitle);
				addCharacter.toFront();
			}
		};
		
		Action addBuildAction = new AbstractAction("Builder", new ImageIcon("")){
			public void actionPerformed(ActionEvent e){
				MainScreen.setPageTitle("Builder");
				AddCharacter.resetValues();

				addCharacter.setVisible(true);
				addCharacter.setTitle("Add " + pageTitle);
				addCharacter.toFront();
			}
		};
		
		Action editClientAction = new AbstractAction("Client", new ImageIcon("")){
			public void actionPerformed(ActionEvent e){
				MainScreen.setPageTitle("Client");
				EditCharacter.resetValues();
				
				editCharacter.setVisible(true);
				editCharacter.setTitle("Edit " + pageTitle);
				editCharacter.toFront();
			}
		};	
		
		Action editArchAction = new AbstractAction("Architect", new ImageIcon("")){
			public void actionPerformed(ActionEvent e){
				MainScreen.setPageTitle("Architect");
				EditCharacter.resetValues();
				
				editCharacter.setVisible(true);
				editCharacter.setTitle("Edit " + pageTitle);
				editCharacter.toFront();
			}
		};	
		
		Action editEngAction = new AbstractAction("Engineer", new ImageIcon("")){
			public void actionPerformed(ActionEvent e){
				MainScreen.setPageTitle("Engineer");
				EditCharacter.resetValues();

				editCharacter.setVisible(true);
				editCharacter.setTitle("Edit " + pageTitle);
				editCharacter.toFront();
			}
		};	
		
		Action editBuildAction = new AbstractAction("Builder"){
			public void actionPerformed(ActionEvent e){
				MainScreen.setPageTitle("Builder");
				EditCharacter.resetValues();
				
				editCharacter.setVisible(true);
				editCharacter.setTitle("Edit " + pageTitle);
				editCharacter.toFront();
			}
		};	
		
		/**
		 * Exit action implemented. Will be added to menubar and toolbar.
		 * Mnemonic, tooltiptext and shortcuts added. 
		 */
		Action exitAction = new AbstractAction("Exit", new ImageIcon("Images/exit.png")){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		};
		exitAction.putValue(Action.MNEMONIC_KEY,  new Integer(KeyEvent.VK_X));
		exitAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
		exitAction.putValue(Action.SHORT_DESCRIPTION,  "Exit");
				
		menubar = new JMenuBar();
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		menubar.add(fileMenu);
		
		//fileMenu.add(optionNew=new JMenuItem("New"));
		fileMenu.add(newAction);
		fileMenu.add(openAction);
		fileMenu.addSeparator();
		fileMenu.add(exitAction);
		
		// Edit Menu
		editMenu = new JMenu("Edit");
		editMenu.setMnemonic('E');	
		menubar.add(fileMenu);
		menubar.add(editMenu);
		editUser = new JMenuItem("User");
		editMenu.add(editUser);		
		editMenu.add(editMaterial = new JMenuItem("Material"));
		editMenu.add(editCategory = new JMenuItem("Category"));
		editMenu.addSeparator();
		editMenu.add(editClientAction);
		editMenu.add(editArchAction);
		editMenu.add(editEngAction);
		editMenu.add(editBuildAction);
		
		// Add Menu
		addMenu = new JMenu("Add");
		addMenu.setMnemonic('A');
		menubar.add(addMenu);
		addMenu.add(addUser = new JMenuItem("User"));
		addMenu.add(addMaterial = new JMenuItem("Material"));
		addMenu.add(addCategory = new JMenuItem("Category"));
		addMenu.addSeparator();
		addMenu.add(addClientAction);
		addMenu.add(addArchAction);
		addMenu.add(addEngAction);
		addMenu.add(addBuildAction);
		
		// View Menu
		viewMenu = new JMenu("View");
		viewMenu.setMnemonic('V');
		menubar.add(viewMenu);
		viewMenu.add(viewUser = new JMenuItem("User"));
		viewMenu.add(viewMaterial = new JMenuItem("Material"));
		viewMenu.add(viewCategory = new JMenuItem("Category"));
		viewMenu.addSeparator();
		viewMenu.add(viewClient = new JMenuItem("Client"));
		viewMenu.add(viewArchitect = new JMenuItem("Architect"));
		viewMenu.add(viewEngineer = new JMenuItem("Engineer"));
		viewMenu.add(viewBuilder = new JMenuItem("Builder"));
		
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menubar.add(helpMenu);
		helpMenu.add(about=new JMenuItem("About"));
		
		frame.setJMenuBar(menubar);
		frame.add(desk);		
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBounds(0, 0, screenSize.width, screenSize.height);
	}
	
	protected static String getPageTitle() {
		return pageTitle;
	}

	public static void setPageTitle(String titleIn) {
		pageTitle = titleIn;
	}
		
	@SuppressWarnings("unused")
	public static void main(String[] args) {		
		MainScreen init = new MainScreen();
	}
}
