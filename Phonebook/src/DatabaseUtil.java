import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

public class DatabaseUtil {

static Connection conn = null;
static PreparedStatement state = null;
	
	public static Connection getConnected() {
		
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/PhoneBook","sa","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return conn;
	} // End of getConnected method.
	
	public static DatabaseHelper getAllModel() {
		
		conn = getConnected();
		String sql = "SELECT FNAME, LNAME, MOBILE, HOME_PHONE, WORK_PHONE FROM MAIN_INFO;";
		ResultSet result = null;
		DatabaseHelper model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new DatabaseHelper(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
		
	} // End getAllModel method
	
    public static void removeComboItems(JComboBox comboBox) {
		comboBox.removeAllItems();
	}
	
    public static void addComboItems(ResultSet rs, JComboBox comboBox, String query) throws SQLException {
    	try {
			PreparedStatement stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		while(rs.next()){
			String s = rs.getString(1);
			comboBox.addItem(s);
			 }
    }
    
	public static void changeList(ResultSet rs, JComboBox comboBox) throws SQLException{
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT FNAME FROM MAIN_INFO");
			rs = stmt.executeQuery();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		while(rs.next()){
			String s = rs.getString(1);
			comboBox.addItem(s);
		}			 		
	}
	
} // End DatabaseUtil Class