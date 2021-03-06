package ie.lyit.teamproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * Reference class to store all SQL methods that are required for the entire
 * application
 * 
 * @author l00097721/liam.waugh
 * 
 * @version v1.0
 */
public class DBConnectionClass {
	static Connection con;
	static Statement stmt;
	static PreparedStatement updateUser;
	static PreparedStatement updateClient;
	static PreparedStatement updateArchitect;
	static PreparedStatement updateEngineer;
	static PreparedStatement updateBuilder;
	//static PreparedStatement editEngineer;
	static PreparedStatement editJobStatus;
	static PreparedStatement updateJob;
	static PreparedStatement updateJobClient;
	static PreparedStatement addMatToJob;
	static PreparedStatement addMaterial;
	static PreparedStatement addCategoryMaterial;
	static PreparedStatement deleteFromJob;
	static PreparedStatement updateCategory;
	static PreparedStatement updateTableItem;
	static PreparedStatement checkUser;
	
	static ResultSet rs;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public DBConnectionClass() {
		this.loadDriver();
		this.makeConnection();
	}

	/**
	 * Loads the MySQL driver
	 */
	public void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}

	}

	/**
	 * Makes a connection to the database
	 */
	public void makeConnection() {
		try {
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/quantities?"
							+ "user=root&password=password");
			stmt = con.createStatement();
		} catch (SQLException ex) {
			System.err.println("database connection: " + ex.getMessage());
		}

	}

		/**
	 * Checks if a user exits when creating a new one
	 * @param username
	 * @return
	 */
	public int checkUser(String username, String password)
	{
		boolean result = false;
		int count = 0;
		try {
			// String gdta = "select * from USER";
			String gdta = "Select name FROM user WHERE name = '"
					+ username + "' AND password = '"+ password + "'";
			rs = stmt.executeQuery(gdta);

			while (rs.next()) {
				++count;
				// Get data from the current row and use it
			}

		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
		}

		return count;
	}
	
	/**
	 * Checks if a user exits when creating a new one
	 * @param username
	 * @return
	 */
	public int checkUserifUserExists(String username)
	{
		boolean result = false;
		int count = 0;
		try {
			// String gdta = "select * from USER";
			String gdta = "Select name FROM user WHERE name = '"
					+ username + "'";
			rs = stmt.executeQuery(gdta);

			while (rs.next()) {
				++count;
				// Get data from the current row and use it
			}

		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
		}

		return count;
	}


	/**
	 * Checks if a category exists
	 * @param username
	 * @return
	 */
	public int checkCategory(String cat)
	{
		boolean result = false;
		int count = 0;
		try {
			// String gdta = "select * from USER";
			String gdta = "Select * FROM category WHERE description = '"
					+ cat + "'";
			rs = stmt.executeQuery(gdta); 

			while (rs.next()) {
				++count;
				// Get data from the current row and use it
			}

		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
		}

		return count;
	}
	
	/**
	 * 
	 * @param mat
	 * @return
	 */
	public int checkMaterial(String mat)
	{
		boolean result = false;
		int count = 0;
		try {
			// String gdta = "select * from USER";
			String gdta = "Select * FROM material WHERE description = '"
					+ mat + "'";
			rs = stmt.executeQuery(gdta);

			while (rs.next()) {
				++count;
				// Get data from the current row and use it
			}

		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
		}

		return count;
	}

	/**
	 * Retrieves relevant information from Client table
	 * 
	 * @return ResultSet The required information in a ResultSet
	 */
	public ResultSet retrieveClientDetails() {
		try {
			String cliData = "SELECT client_id, name, address, address2, town, county, phone, email FROM client";
			rs = stmt.executeQuery(cliData);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Error attempting to retrieve Client data: "
					+ ex.getMessage());
			return null;
		}
	}

	/**
	 * Retrieves relevant information from Architect table
	 * 
	 * @return ResultSet The required information in a ResultSet
	 */
	public ResultSet retrieveArchitectDetails() {
		try {
			String archData = "SELECT arch_id, name, address, address2, town, county, phone, email FROM architect";
			rs = stmt.executeQuery(archData);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Error attempting to retrieve Architect data: "
					+ ex.getMessage());
			return null;
		}
	}

	/**
	 * Retrieves relevant information from Engineer table
	 * 
	 * @return ResultSet The required information in a ResultSet
	 */
	public ResultSet retrieveEngineerDetails() {
		try {
			String engData = "SELECT eng_id, name, address, address2, town, county, phone, email FROM engineer";
			rs = stmt.executeQuery(engData);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Error attempting to retrieve Engineer data: "
					+ ex.getMessage());
			return null;
		}
	}

	/**
	 * Retrieves relevant information from Builder table
	 * 
	 * @return ResultSet The required information in a ResultSet
	 */
	public ResultSet retrieveBuilderDetails() {
		try {
			String buildData = "SELECT builder_id, name, address, address2, town, county, phone, email FROM builder";
			rs = stmt.executeQuery(buildData);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Error attempting to retrieve Builder data: "
					+ ex.getMessage());
			return null;
		}
	}

	/*	*//**
	 * Retrieves the client name from the client table
	 * 
	 * @return ResultSet The resultSet containing all the names in the client
	 *         table
	 */

	public ResultSet retrieveClientInfo() {
		try {
			String cliName = "SELECT client_id, name FROM client";
			rs = stmt.executeQuery(cliName);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Attempting to retrieve client name"
					+ ex.getMessage());
			return null;
		}
	}

	public ResultSet retrieveArchInfo() {
		try {
			String archName = "SELECT arch_id, name FROM architect";
			rs = stmt.executeQuery(archName);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Attempting to retrieve architect name"
					+ ex.getMessage());
			return null;
		}
	}

	public ResultSet retrieveEngInfo() {
		try {
			String engName = "SELECT eng_id, name FROM engineer";
			rs = stmt.executeQuery(engName);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Attempting to retrieve engineer name"
					+ ex.getMessage());
			return null;
		}
	}

	public ResultSet retrieveBuildInfo() {
		try {
			String buildName = "SELECT builder_id, name FROM builder";
			rs = stmt.executeQuery(buildName);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Attempting to retrieve builder name"
					+ ex.getMessage());
			return null;
		}
	}

	/**
	 * Retrieves all information contained in the user table Currently just
	 * displays user info to the console Needs to be properly implemented to
	 * return a ResultSet
	 */
	public int retrieveUserInfo(String username, String password) {
		boolean result = false;
		int userID = 0;
		try {
			// String gdta = "select * from USER";
			String gdta = "Select user_ID FROM user WHERE name = '"
					+ username + "' AND password = '" + password + "'";
			rs = stmt.executeQuery(gdta);

			while (rs.next()) {
				// Get data from the current row and use it
				userID = Integer.parseInt(rs.getString(1));
				//System.out.print("User ID: "+ userID);
			}

		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
		}

		return userID;
	}
	
	/**
	 * Gets material with the id
	 * @param mat_id
	 * @return
	 */
	public String getMaterial(int mat_id)
	{
		String mat="";
		
		try {
			// String gdta = "select * from USER";
			String gdta = "Select description FROM material WHERE Material_ID = '"
					+ mat_id + "'";
			rs = stmt.executeQuery(gdta);

			while (rs.next()) {
				// Get data from the current row and use it
				mat = rs.getString(1);
			}

		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
		}
		//System.out.print("Material : "+ mat);
		return mat;
	}

	/**
	 * Retrieves all materials that have been costed for a specified job Used to
	 * populate the table in the 'JobScreen'
	 * 
	 * @param job_No
	 *            The unique job_id of the job
	 * @return ResultSet The information relating to the job. The following
	 *         fields are contained within the ResultSet String - The
	 *         description of the material double - The price of a single
	 *         element of the material int - The number of units required for
	 *         this job double - The total price for a given item
	 */
	public ResultSet retrieveAllJobDetails(int job_No) {
		try {
			// String gdta =
			// "select material.description, job_material.price, job_material.quantity, job_material.TotalPrice "
			// + "from material "
//			String gdta = "select job_material.job_id, job_material.material_id, material.description, job_material.price, job_material.quantity, job_material.TotalPrice "
//					+ "from material "
//					+ "inner join job_material "
//					+ "on job_material.material_id = material.Material_ID "
//					+ "and job_material.job_id = " + job_No;
			String gdta = "select job_material.job_id, job_material.material_id, category.description, "
					+ "material.description, job_material.price, job_material.quantity, job_material.TotalPrice "
					+ "from material, category, category_material, job_material "
					+ "where job_material.job_id = " + job_No 									// All lines to the left can be commented 
					+ " and job_material.material_id = material.material_id "					// out and the code below uncommented  
					+ "and category_material.material_id = material.material_id "				// to revert back to the previous SQL 
					+ "and category_material.category_id = category.category_id ";				// statement that was definitely working correctly
//					+ "where job_material.material_id = material.material_id "
//					+ "and category_material.material_id = material.material_id "
//					+ "and category_material.category_id = category.category_id "
//					+ "and job_material.job_id = " + job_No;

			rs = stmt.executeQuery(gdta);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
			return null;
		}
	}
	
	public void deleteItemFromJob(int job_id, int mat_id) {
		try {
			String deleteItemFromJob = "delete from job_material where job_id = " + job_id + " and material_id = " + mat_id;
			deleteFromJob = con.prepareStatement(deleteItemFromJob);

			deleteFromJob.executeUpdate();
			
		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
		}
	}

	public void editItemFromJob(int job_id, int mat_id, double quantity, double price) {
		double total = quantity*price;
		try {
			String insertString = "UPDATE job_material SET quantity =" + quantity 
					+ ", price =" + price  + ", totalprice ="+total + 
					" WHERE job_id =" + job_id + " AND material_id = " + mat_id;
			updateTableItem = con.prepareStatement(insertString);
			updateTableItem.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("There was an error when editing Data: "
					+ ex.getMessage());
		}

	}
	// /**
	// * Retrieves the total cost of all materials that have been added to a job
	// *
	// * @param job_no
	// * The job_no that is to be displayed on the screen
	// * @return double The total cost of all materials added to this job
	// */
	// public double retrieveJobTotal(int job_no) {
	// try {
	// String costPerJob =
	// "SELECT sum(job_material.quantity * job_material.price) "
	// + "FROM job_material, material "
	// + "WHERE job_material.Material_ID = material.Material_ID "
	// + "AND job_material.job_ID = " + job_no;
	// rs = stmt.executeQuery(costPerJob);
	// rs.next();
	// double returnValue = rs.getDouble(1);
	// return returnValue;
	// } catch (SQLException ex) {
	// System.out.println("Error retrieving data" + ex.getMessage());
	// }
	//
	// return -1.0;
	// }

	/**
	 * Creates a user and adds it to the database
	 * 
	 * @param username
	 *            The username to be added to the database
	 * @param password
	 *            The users password to be added to the database
	 */
	public void createUser(String username, String password) {
		try {
			String insertString = "insert into user values (default, ?, ?)";
			updateUser = con.prepareStatement(insertString);
			updateUser.setString(1, username);
			updateUser.setString(2, password);

			updateUser.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("There was an error when inserting Data: "
					+ ex.getMessage());
		}
	}

	/**
	 * Creates a category and adds it to the database
	 * 
	 * @param description
	 *            Describes the category to be added to the database
	 */
	public void createCategory(String description) {
		try {
			String insertString = "insert into user values (default, ?)";
			updateUser = con.prepareStatement(insertString);
			updateUser.setString(1, description);

			updateUser.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("There was an error when inserting Data: "
					+ ex.getMessage());
		}
	}

	/**
	 * Creates a client based on parameters passed by the user
	 * 
	 * @param name
	 *            String The name of the client
	 * @param address
	 *            String The first line of the client address
	 * @param address2
	 *            String The second line of the client address
	 * @param town
	 *            String The town of the client address
	 * @param county
	 *            String The county of the client address
	 * @param phone
	 *            int The phone number of the client
	 * @param email
	 *            String The email address of the client
	 */
	public void createClient(String name, String address, String address2,
			String town, String county, int phone, String email) {
		try {
			String insertString = "insert into client values (default, ?, ?, ?, ?, ?, ?, ?)";
			updateClient = con.prepareStatement(insertString);
			updateClient.setString(1, name);
			updateClient.setString(2, address);
			updateClient.setString(3, address2);
			updateClient.setString(4, town);
			updateClient.setString(5, county);
			updateClient.setInt(6, phone);
			updateClient.setString(7, email);

			updateClient.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("There was an error when inserting Data: "
					+ ex.getMessage());
		}

	}

	/**
	 * Create an architect and add it to the architect table
	 * 
	 * @param name
	 *            String The name of the architect
	 * @param address
	 *            String The first line of the architect address
	 * @param address2
	 *            String The second line of the architect address
	 * @param town
	 *            String The town of the architect address
	 * @param county
	 *            String The county of the architect address
	 * @param phone
	 *            int The phone number of the architect
	 * @param email
	 *            String The email address of the architect
	 */
	public void createArchitect(String name, String address, String address2,
			String town, String county, int phone, String email) {
		try {
			String insertString = "INSERT INTO architect VALUES (default, ?, ?, ?, ?, ?, ?, ?)";
			updateArchitect = con.prepareStatement(insertString);
			updateArchitect.setString(1, name);
			updateArchitect.setString(2, address);
			updateArchitect.setString(3, address2);
			updateArchitect.setString(4, town);
			updateArchitect.setString(5, county);
			updateArchitect.setInt(6, phone);
			updateArchitect.setString(7, email);

			updateArchitect.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("There was an error when inserting Data: "
					+ ex.getMessage());
		}

	}

	/**
	 * Create a engineer and add it to the engineer table
	 * 
	 * @param name
	 *            String The name of the engineer
	 * @param address
	 *            String The first line of the engineers address
	 * @param address2
	 *            String The second line of the engineers address
	 * @param town
	 *            String The town of the engineers address
	 * @param county
	 *            String The county of the engineers address
	 * @param phone
	 *            int The phone number of the engineer
	 * @param email
	 *            String The email address of the engineers
	 */
	public void createEngineer(String name, String address, String address2,
			String town, String county, int phone, String email) {
		try {
			String insertString = "insert into engineer values (default, ?, ?, ?, ?, ?, ?, ?)";
			updateEngineer = con.prepareStatement(insertString);
			updateEngineer.setString(1, name);
			updateEngineer.setString(2, address);
			updateEngineer.setString(3, address2);
			updateEngineer.setString(4, town);
			updateEngineer.setString(5, county);
			updateEngineer.setInt(6, phone);
			updateEngineer.setString(7, email);

			updateEngineer.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("There was an error when inserting Data: "
					+ ex.getMessage());
		}

	}

	/**
	 * Create a builder and add it to the builder table
	 * 
	 * @param name
	 *            String The name of the builder
	 * @param address
	 *            String The first line of the builders address
	 * @param address2
	 *            String The second line of the builders address
	 * @param town
	 *            String The town of the builders address
	 * @param county
	 *            String The county of the builders address
	 * @param phone
	 *            int The phone number of the builder
	 * @param email
	 *            String The email address of the builder
	 */
	public void createBuilder(String name, String address, String address2,
			String town, String county, int phone, String email) {
		try {
			String insertString = "insert into builder values (default, ?, ?, ?, ?, ?, ?, ?)";
			updateBuilder = con.prepareStatement(insertString);
			updateBuilder.setString(1, name);
			updateBuilder.setString(2, address);
			updateBuilder.setString(3, address2);
			updateBuilder.setString(4, town);
			updateBuilder.setString(5, county);
			updateBuilder.setInt(6, phone);
			updateBuilder.setString(7, email);

			updateBuilder.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("There was an error when inserting Data: "
					+ ex.getMessage());
		}
	}

	public void createNewJob(int client_id, int arch_id, int eng_id,
			int build_id, String description) {
		try {
			String insertString = "INSERT INTO job (status, total_cost, arch_id, eng_id, build_id, description) "
					+ "VALUES ('Open', 0, "
					+ arch_id
					+ ", "
					+ eng_id
					+ ", "
					+ build_id + ", '" + description + "')";
			
			updateJob = con.prepareStatement(insertString);
			updateJob.executeUpdate();

			int tempJobId = retrieveJobID();
			String insertJobClientString = "INSERT INTO job_client VALUES ("
					+ tempJobId + ", " + client_id + ")";
			updateJobClient = con.prepareStatement(insertJobClientString);
			
			updateJobClient.executeUpdate();

		} catch (SQLException ex) {
			System.err
					.println("There was an error when inserting new job Data: "
							+ ex.getMessage());
		}
	}
	
	public int retrieveJobID() {
		int job_id = 0;
		try {
			String gdta = "SELECT MAX(job_id) FROM job";
			rs = stmt.executeQuery(gdta);
			while (rs.next()) {
				job_id = rs.getInt(1);
			}

			return job_id;

		} catch (SQLException ex) {
			System.err.println("Error attempting to retrieve job id : "
					+ ex.getMessage());
			return job_id;
		}
	}
	
	public void addMaterialToJob(int job_id, int mat_id, int quant, double price, double total) {
		try {
			String insertString = "INSERT INTO job_material "
					+ "VALUES ("
					+ job_id + ", "
					+ mat_id + ", "
					+ quant + ", " 
					+ price + ", "
					+ (quant*price) + ")";
			
			addMatToJob = con.prepareStatement(insertString);
			addMatToJob.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Item already added for this job." );
		}
	}
	
	public void addMaterial(String description, int cat_id) {
		try {
			String insertString = "INSERT INTO material VALUES ('" + description + "')";
			addMaterial = con.prepareStatement(insertString);
			addMaterial.executeUpdate();
			
			int mat_id = retrieveMaterial_id();
			
			String insertIntoCatMat = "INSERT INTO category_material VALUES (" + cat_id + ", " + mat_id + ")";
			addCategoryMaterial = con.prepareStatement(insertIntoCatMat);
			addCategoryMaterial.executeUpdate();
			
			
		} catch (SQLException ex) {
			System.err.println("There was an error when inserting new material data: " + ex.getMessage());
		}
	}
	
	public int retrieveMaterial_id() {
		int material_id = 0;
		try {
			String gdta = "SELECT MAX(material_id) FROM material";
			rs = stmt.executeQuery(gdta);
			while (rs.next()) {
				material_id = rs.getInt(1);
			}
			return material_id;
		} catch (SQLException ex) {
			System.err.println("Error attempting to retrieve material_id : "
					+ ex.getMessage());
			return material_id;
		}
	}	
	
	public int retrieveMaterialByName(String matName) {
		int material_id = 0;
		try {
			String gdta = "SELECT material_id FROM material WHERE description = '" + matName + "'";
			rs = stmt.executeQuery(gdta);
			while (rs.next()) {
				material_id = rs.getInt(1);
			}
			return material_id;
		} catch (SQLException ex) {
			System.err.println("Error attempting to retrieve material_id : "
					+ ex.getMessage());
			return material_id;
		}
	}	
	
	public int getLastJobCreated() {
		int job_id = 0;
		try {
			String gdta = "SELECT MAX(job_id) FROM job";
			rs = stmt.executeQuery(gdta);
			while (rs.next()) {
				job_id = rs.getInt(1);
			}
		} catch (SQLException ex) {
			System.err.println("Error attempting to retrieve job_id : "
					+ ex.getMessage());
		}
		return job_id;
	}

	/**
	 * Edit an Engineer entity based on parameters inputed by the user
	 * 
	 * @param address
	 *            First line of the Engineers address
	 * @param address2
	 *            Second line of the Engineers address
	 * @param town
	 *            The Engineers Town
	 * @param county
	 *            The Engineers County
	 * @param phone
	 *            The Engineers phone
	 * @param email
	 *            The Engineers email
	 */
//	public void editEngineer(String address, String address2, String town,
//			String county, String phone, String email) {
//		try {
//			System.out.println(EditCharacter.characterId);
//			String insertString = "UPDATE engineer SET address = '" + address
//					+ "', address2 = '" + address2 + "', town = '" + town
//					+ "', county = '" + county + "', phone = '" + phone
//					+ "', email = '" + email + "' WHERE eng_id ="
//					+ EditCharacter.characterId;
//			editEngineer = con.prepareStatement(insertString);
//			// editEngineer.setString(1, address);
//			// editEngineer.setString(2, address2);
//			// editEngineer.setString(3, town);
//			// editEngineer.setString(4, county);
//			// editEngineer.setString(5, phone);
//			// editEngineer.setString(6, email);
//
//			editEngineer.executeUpdate();
//
//		} catch (SQLException ex) {
//			System.err.println("There was an error when inserting Data: "
//					+ ex.getMessage());
//		}
//
//	}
	//==============================================================//
	//																//
	// 		New Edit Screens received from Cathal 28/03/2014		//
	//																//
	//==============================================================//
	
	public void editEngineer(String address, String address2, String town,
			String county, String phone, String email) {
		try {
			String insertString = "UPDATE engineer SET address ='" + address 
					+ "', address2 ='" + address2 
					+ "', town = '" + town 
					+ "', county = '" + county 
					+ "', phone = '" + phone 
					+ "', email = '" + email 
					+ "' WHERE eng_id =" + EditCharacter.characterId;
			updateEngineer = con.prepareStatement(insertString);
			updateEngineer.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("There was an error when inserting Data: "
					+ ex.getMessage());
		}

	}
	
	public void editClient(String address, String address2, String town,
			String county, String phone, String email) {
		try {
			String insertString = "UPDATE client SET address ='" + address 
					+ "', address2 ='" + address2 
					+ "', town = '" + town 
					+ "', county = '" + county 
					+ "', phone = '" + phone 
					+ "', email = '" + email 
					+ "' WHERE client_id =" + EditCharacter.characterId;;
			updateClient = con.prepareStatement(insertString);
			updateClient.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("There was an error when inserting Data: "
					+ ex.getMessage());
		}

	}
	
	public void editArchitect(String address, String address2, String town,
			String county, String phone, String email) {
		try {
			String insertString = "UPDATE architect SET address ='" + address 
					+ "', address2 ='" + address2 
					+ "', town = '" + town 
					+ "', county = '" + county 
					+ "', phone = '" + phone 
					+ "', email = '" + email 
					+ "' WHERE arch_id =" + EditCharacter.characterId;;
			updateArchitect = con.prepareStatement(insertString);
			updateArchitect.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("There was an error when inserting Data: "
					+ ex.getMessage());
		}

	}
	
	public void editBuilder(String address, String address2, String town,
			String county, String phone, String email) {
		try {
			String insertString = "UPDATE builder SET address ='" + address 
					+ "', address2 ='" + address2 
					+ "', town = '" + town 
					+ "', county = '" + county 
					+ "', phone = '" + phone 
					+ "', email = '" + email 
					+ "' WHERE builder_id =" + EditCharacter.characterId;
			updateBuilder = con.prepareStatement(insertString);
			updateBuilder.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("There was an error when inserting Data: "
					+ ex.getMessage());
		}

	}

	/**
	 * Edit a jobs status
	 * 
	 * @param jobId
	 *            The unique Id of the job whose status is to be updated
	 * @param status
	 *            The status that will be assigned to the job
	 */
	public void editJobStatus(int jobId, String status) {
		try {
			String insertString = "UPDATE job SET status = '" + status
					+ "' WHERE job_id =" + jobId;
			editJobStatus = con.prepareStatement(insertString);

			editJobStatus.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("There was an error when inserting Data: "
					+ ex.getMessage());
		}
	}

	/**
	 * Retrieves all jobs associated with a specific client
	 * 
	 * @return The ResultSet containing all relevant information to populate the
	 *         table in the 'OpenProject' screen
	 */
	public ResultSet retrieveClientJobs() {
		try {
			String gdta = "SELECT job_client.job_id, client.name, job.description "
					+ "FROM client, job "
					+ "INNER JOIN job_client "
					+ "WHERE job.job_id = job_client.job_id "
					+ "AND client.client_id = job_client.client_id AND job.user_id = "+MainScreen.getUserLoggedIn();

			rs = stmt.executeQuery(gdta);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Retrieves all details from view 'job_view'
	 * 
	 * @param job_id
	 *            The job_id of the relevant job
	 * @return The ResultSet containing all relevant information required to
	 *         populate the header section of the 'JobScreen'
	 */
	public ResultSet retrieveJobDetails(int job_id) {
		try {
			String gdta = "SELECT c.name AS 'Client', j.description AS 'Description', j.status AS 'Status', "
					+ "j.Total_Cost AS 'Total', a.Name as 'Architect', e.name AS 'Engineer', b.name AS 'Builder' "
					+ "FROM CLIENT AS c, job AS j, architect AS a, engineer AS e, Builder AS b "
					+ "INNER JOIN job_client AS jc "
					+ "WHERE jc.job_id = j.job_id "
					+ "AND jc.client_id = c.client_id "
					+ "AND a.Arch_ID = j.Arch_ID "
					+ "AND e.Eng_ID = j.Eng_ID "
					+ "AND b.Builder_ID = j.Build_ID "
					+ "AND jc.job_id = " + job_id;
			rs = stmt.executeQuery(gdta);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
			return null;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int retrieveCategory_id() {
		int category_id = 0;
		try {
			String gdta = "SELECT MAX(category_id) FROM category";
			rs = stmt.executeQuery(gdta);
			while (rs.next()) {
				category_id = rs.getInt(1);
			}
			return category_id+1;
		} catch (SQLException ex) {
			System.err.println("Error attempting to retrieve material_id : "
					+ ex.getMessage());
			return category_id+1;
		}
	}
	
	public ResultSet retrieveCategory() {
		int category_id = 0;
		try {
			String gdta = "SELECT category_id, description FROM category";
			rs = stmt.executeQuery(gdta);

			return rs;
		} catch (SQLException ex) {
			System.err.println("Error attempting to retrieve material_id : "
					+ ex.getMessage());
			return rs;
		}
	}
	
	/**
	 * Creates a category and adds it to the database
	 * 
	 * @param description
	 *            Describes the category to be added to the database
	 */
	public void createCategory(int id, String description) {
		try {
				String insertString = "INSERT INTO category VALUES ("+id+", '" + description + "')";
				updateCategory = con.prepareStatement(insertString);
				updateCategory.executeUpdate();	
					
		} catch (SQLException ex) {
			System.err.println("There was an error when inserting new category data: " + ex.getMessage());
		}
	}

	public ResultSet retrieveCategoryMaterial(int category_id) {
		try {
			String gdta = "SELECT category_material.category_id, category_material.material_id, material.description "
					+ "FROM category_material, material, category "
					+ "WHERE category.category_id = category_material.category_id "
					+ "AND material.material_id = category_material.material_id "
					+ "AND category.category_id = " + category_id;
			rs = stmt.executeQuery(gdta);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
			return null;
		}
	}
	
	//=================//
	// Luke Code Begin //
	//=================//
	/**
	 * 
	 * @param category_id
	 * @return
	 */
	public ResultSet retrieveAllCategoryMaterial() {
		try {
			//String gdta = "SELECT category_material.category_id, category_material.material_id, material.description "
			//		+ "FROM category_material, material, category ";
					
			String gdta = "SELECT category_ID, Description  "
					+ "FROM category";
			rs = stmt.executeQuery(gdta);
			return rs;
		} catch (SQLException ex) {
			System.err.println("Retrieve Data: " + ex.getMessage());
			return null;
		}
	}
	
	/**
	 * 
	 * @param cat_id - Category ID based on combox box selection from AddMaterial Screen
	 * @param description - Description of material to be added
	 */
	public void addMaterialToDB(int cat_id, String description) {
		try {
			int mat_id = retrieveMaterial_id();
			String insertString = "INSERT INTO material VALUES ("+ (mat_id+1) + ", '" + description + "')";
			PreparedStatement addMaterial = con.prepareStatement(insertString);
			addMaterial.executeUpdate();

			String insertIntoCatMat = "INSERT INTO category_material VALUES (" + (cat_id) + ", " + (mat_id+1) + ")";
			PreparedStatement addCategoryMaterial = con.prepareStatement(insertIntoCatMat);
			addCategoryMaterial.executeUpdate();
			
			
		} catch (SQLException ex) {
			System.err.println("There was an error when inserting new material data: " + ex.getMessage());
		}
	}
	//===============//
	// End Luke Code //
	//===============//
	
	/**
	 * Close the connection class
	 */
	public void closeAll() {
		try {
			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("closeAll: " + ex.getMessage());
		}
	}
}
