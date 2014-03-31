package ie.lyit.teamproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {

	static JDesktopPane desk;
	private JFrame frame;

	private JToolBar toolbar;

	private JMenuBar menubar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu addMenu;
	private JMenu viewMenu;
	private JMenu helpMenu;

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
	static boolean instanceFlag;

	protected static NewJob newJob;
	protected static OpenProject openProject;
	protected static AddClient addClient;
	protected static AddCharacter addCharacter;
	protected static EditCharacter editCharacter;

	public MainScreen() {

		getContentPane().setLayout(new BorderLayout());

		final Dimension screenSize = Toolkit.getDefaultToolkit()
				.getScreenSize();

		frame = new JFrame("JDeskopPane");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("Images/measure.png").getImage());
		desk = new JDesktopPane() {

			ImageIcon icon = new ImageIcon("Images/building.png");
			Image image = icon.getImage();
			Image newimage = image.getScaledInstance(screenSize.width,
					screenSize.height, Image.SCALE_SMOOTH);

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(newimage, 0, 0, this);
			}
		};

		newJob = new NewJob();
		desk.add(newJob);
		newJob.setVisible(false);
		;

		openProject = new OpenProject();
		desk.add(openProject);
		openProject.setVisible(false);

		addCharacter = new AddCharacter();
		desk.add(addCharacter);
		addCharacter.setVisible(false);

		editCharacter = new EditCharacter();
		desk.add(editCharacter);
		editCharacter.setVisible(false);

		Action newAction = new AbstractAction("New", new ImageIcon(
				"Images/new.png")) {
			public void actionPerformed(ActionEvent e) {
				newJob.setVisible(true);
				newJob.toFront();
			}
		};
		newAction.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_N));
		newAction.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke("control N"));
		newAction.putValue(Action.SHORT_DESCRIPTION, "Create a New Job");

		Action openAction = new AbstractAction("Open", new ImageIcon(
				"Images/open.png")) {
			public void actionPerformed(ActionEvent e) {
				openProject.setVisible(true);
				openProject.toFront();
			}
		};
		openAction.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_O));
		openAction.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke("control O"));
		openAction.putValue(Action.SHORT_DESCRIPTION, "Open an Existing Job");

		Action addClientAction = new AbstractAction("Client", new ImageIcon(
				"Images/add.png")) {
			public void actionPerformed(ActionEvent e) {
				MainScreen.setPageTitle("Client");
				AddCharacter.resetValues();

				addCharacter.setVisible(true);
				addCharacter.setTitle("Add " + pageTitle);
				addCharacter.toFront();
			}
		};
		addClientAction.putValue(Action.SHORT_DESCRIPTION, "Enter a New Client to the System");

		Action addArchAction = new AbstractAction("Architect", new ImageIcon(
				"Images/add.png")) {
			public void actionPerformed(ActionEvent e) {
				MainScreen.setPageTitle("Architect");
				AddCharacter.resetValues();

				addCharacter.setVisible(true);
				addCharacter.setTitle("Add " + pageTitle);
				addCharacter.toFront();
			}
		};
		addArchAction.putValue(Action.SHORT_DESCRIPTION, "Enter a New Architect to the System");

		Action addEngAction = new AbstractAction("Engineer", new ImageIcon(
				"Images/add.png")) {
			public void actionPerformed(ActionEvent e) {
				MainScreen.setPageTitle("Engineer");
				AddCharacter.resetValues();

				addCharacter.setVisible(true);
				addCharacter.setTitle("Add " + pageTitle);
				addCharacter.toFront();
			}
		};
		addEngAction.putValue(Action.SHORT_DESCRIPTION, "Enter a New Engineer to the System");

		Action addBuildAction = new AbstractAction("Builder", new ImageIcon(
				"Images/add.png")) {
			public void actionPerformed(ActionEvent e) {
				MainScreen.setPageTitle("Builder");
				AddCharacter.resetValues();

				addCharacter.setVisible(true);
				addCharacter.setTitle("Add " + pageTitle);
				addCharacter.toFront();
			}
		};
		addBuildAction.putValue(Action.SHORT_DESCRIPTION, "Enter a New Builder to the System");

		Action editClientAction = new AbstractAction("Client", new ImageIcon(
				"Images/editUser.png")) {
			public void actionPerformed(ActionEvent e) {
				MainScreen.setPageTitle("Client");
				EditCharacter.resetValues();

				editCharacter.setVisible(true);
				editCharacter.setTitle("Edit " + pageTitle);
				editCharacter.toFront();
			}
		};
		editClientAction.putValue(Action.SHORT_DESCRIPTION, "Edit an Existing Client's Details");

		Action editArchAction = new AbstractAction("Architect", new ImageIcon(
				"Images/editUser.png")) {
			public void actionPerformed(ActionEvent e) {
				MainScreen.setPageTitle("Architect");
				EditCharacter.resetValues();

				editCharacter.setVisible(true);
				editCharacter.setTitle("Edit " + pageTitle);
				editCharacter.toFront();
			}
		};
		editArchAction.putValue(Action.SHORT_DESCRIPTION, "Edit an Existing Architect's Details");

		Action editEngAction = new AbstractAction("Engineer", new ImageIcon(
				"Images/editUser.png")) {
			public void actionPerformed(ActionEvent e) {
				MainScreen.setPageTitle("Engineer");
				EditCharacter.resetValues();

				editCharacter.setVisible(true);
				editCharacter.setTitle("Edit " + pageTitle);
				editCharacter.toFront();
			}
		};
		editEngAction.putValue(Action.SHORT_DESCRIPTION, "Edit an Existing Engineer's Details");

		Action editBuildAction = new AbstractAction("Builder", new ImageIcon(
				"Images/editUser.png")) {
			public void actionPerformed(ActionEvent e) {
				MainScreen.setPageTitle("Builder");
				EditCharacter.resetValues();

				editCharacter.setVisible(true);
				editCharacter.setTitle("Edit " + pageTitle);
				editCharacter.toFront();
			}
		};
		editBuildAction.putValue(Action.SHORT_DESCRIPTION, "Edit an Existing Builder's Details");

		/**
		 * Create exitAction
		 */
		Action exitAction = new AbstractAction("Exit", new ImageIcon(
				"Images/exit.png")) {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		exitAction.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_X));
		exitAction.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke("control X"));
		exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");

		menubar = new JMenuBar();
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		menubar.add(fileMenu);

		// File Menu
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
		helpMenu.add(about = new JMenuItem("About"));

		frame.setJMenuBar(menubar);
		frame.getContentPane().add(desk);

		toolbar = new JToolBar();
		toolbar.setBounds(0, 0, screenSize.width, 40);
		desk.add(toolbar);
		toolbar.setFloatable(false);
		toolbar.add(newAction);
		toolbar.add(openAction);
		toolbar.addSeparator();
		toolbar.add(addClientAction);
		toolbar.add(addArchAction);
		toolbar.add(addEngAction);
		toolbar.add(addBuildAction);
		toolbar.addSeparator();
		toolbar.add(editClientAction);
		toolbar.add(editArchAction);
		toolbar.add(editEngAction);
		toolbar.add(editBuildAction);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBounds((int)(screenSize.width * 0.2), (int)(screenSize.height * 0.2), (int)(screenSize.width * 0.6), (int)(screenSize.height * 0.75));
		frame.setTitle("Building Materials Calculator");
		frame.setExtendedState(MAXIMIZED_BOTH);
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
