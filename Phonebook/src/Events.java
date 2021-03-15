
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class Events {
	static String[] Columns = {" FIRST NAME "," SUR NAME "," MOBILE NUM "," HOME NUM "," WORK NUM "," JOB TITLE ", " COMPANY "," ADDRESS "};

   // Check to see if the number is actually a number:
   static int validateNumber(JTextField textField){
	   int number;
	   if( !textField.getText().equals("") ){
		   try {
		        number = Integer.parseInt(textField.getText());
		        System.out.println(number);
		        return number;
			}catch(NumberFormatException ex) {
				textField.setText("Enter only numbers!");
				return 1;
			}	   
	   }
	   else {
		   System.out.println("The number fields are empty :/");
		   return 0;
	   }
	     
   }
	
	static private void addMainInfo(String query1, String fname, String lname, String mobileNum, String homeNum, String workNum){
		try {		
			DatabaseUtil.state = DatabaseUtil.conn.prepareStatement(query1);
			DatabaseUtil.state.setString(1, fname);
			DatabaseUtil.state.setString(2, lname);
			DatabaseUtil.state.setString(3, mobileNum);
			DatabaseUtil.state.setString(4, homeNum);
			DatabaseUtil.state.setString(5, workNum);

			DatabaseUtil.state.execute();
			GUI.table.setModel(DatabaseUtil.getAllModel());			
		} catch (SQLException error) {
			error.printStackTrace();
		}	
	} // End of addMainInfo method
	
	static private void addAdditionalInfo(String query2, String company, String address){
		try {		
			DatabaseUtil.state = DatabaseUtil.conn.prepareStatement(query2);
			DatabaseUtil.state.setString(1, company);
			DatabaseUtil.state.setString(2, address);

			DatabaseUtil.state.execute();
			GUI.table.setModel(DatabaseUtil.getAllModel());			
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
	} // End of addAdditionalInfo method
	
	static private void addJobTitleInfo(String query3, String jobTitle){
		try {		
			DatabaseUtil.state = DatabaseUtil.conn.prepareStatement(query3);
			DatabaseUtil.state.setString(1, jobTitle);

			DatabaseUtil.state.execute();
			GUI.table.setModel(DatabaseUtil.getAllModel());			
		} catch (SQLException error) {
			error.printStackTrace();
		}
    } // End of addJobTitleInfo method

	public static void addRecord(){
		String firstName = GUI.TFfirstName.getText();
		String surName = GUI.TFsurName.getText();
		String company = GUI.TFcompany.getText();
		String jobTitle = GUI.TFposition.getText();
		String address = GUI.TFaddress.getText();
		String insertMobile = "";
		String insertHomeNum = "";
		String insertWorkNum = "";
		String emptyMsg = "This field cannot be empty !";
		
		
		// Check if the entered mobile number is not empty and valid ( Is integer ).
		if( firstName.equals("") ) {
			GUI.TFfirstName.setText(emptyMsg);
			return;
		}
		else if( surName.equals("") ) {
			GUI.TFsurName.setText(emptyMsg);
			return;
		}
		else if( GUI.TFmobileNumber.getText().equals("") ) {
			GUI.TFmobileNumber.setText(emptyMsg);
			return;
		}
		else if( GUI.TFmobileNumber.getText().equals(emptyMsg)) {
			return;
		}
		
		// If everything is ok, validate the numbers:
		else{
		    int mobileResult = validateNumber(GUI.TFmobileNumber);
			int homeResult = validateNumber(GUI.TFhomeNumber);
			int workResult = validateNumber(GUI.TFworkNumber);
		
		// If the numbers has been parsed and validated -> Stringify them again and proceed to query.
		if( mobileResult != 2 && homeResult != 2 && workResult != 2) {
			
			insertMobile = Integer.toString(mobileResult);
			insertHomeNum = Integer.toString(homeResult);
			insertWorkNum = Integer.toString(workResult);
			
			DatabaseUtil.conn = DatabaseUtil.getConnected();
			if(DatabaseUtil.conn == null){
				return;
			}
			
			String sql1 = "INSERT INTO MAIN_INFO VALUES (null,?,?,?,?,?);";
		    String sql2 = "INSERT INTO ADDITIONAL_INFO VALUES (null,null,?,?);"; 
		    String sql3 = "INSERT INTO JOB_TITLE VALUES (null,?);";
		    
		    addMainInfo(sql1, firstName, surName, insertMobile, insertHomeNum, insertWorkNum);
		    addAdditionalInfo(sql2, company, address);
		    addJobTitleInfo(sql3, jobTitle);
		    System.out.println("New record added !");
		}
		else if( mobileResult == 1 || homeResult == 1 || workResult ==1 ) {
			return;
		}
		else {
			System.out.println("Invalid data !");
		  }
		
		}	
	} // End of addRecord method. 
	
	
	public static DatabaseHelper ViewByCriteria(String fname, String company, String jobTitle) throws Exception{
		DatabaseUtil.conn = DatabaseUtil.getConnected();
		ResultSet result = null;
		DatabaseHelper model = null;
		
		String criteriaNames = "SELECT FNAME, COMPANY, JOB_TITLE "
				+ "FROM MAIN_INFO, ADDITIONAL_INFO, JOB_TITLE "
				+ "WHERE FNAME = ? AND COMPANY = ? AND JOB_TITLE = ?";
		
		try {		
			DatabaseUtil.state = DatabaseUtil.conn.prepareStatement(criteriaNames);
			DatabaseUtil.state.setString(1, fname);
			DatabaseUtil.state.setString(2, company);
			DatabaseUtil.state.setString(3, jobTitle);
			result = DatabaseUtil.state.executeQuery();
			//DatabaseUtil.state.execute();
			//GUI.table.setModel(DatabaseUtil.getAllModel());
			model = new DatabaseHelper(result);		
		} catch (SQLException error) {
			error.printStackTrace();
		}	
		return model;
		
	}
	
	
    private static ResultSet getFirstNames(){
    	DatabaseUtil.conn = DatabaseUtil.getConnected();
		String sql = "SELECT FNAME FROM MAIN_INFO;";
		ResultSet result = null;
		
		try {
			PreparedStatement state = DatabaseUtil.conn.prepareStatement(sql);
			result = state.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    }
    
    public static void removeRecord(String comboValue){
    	//ResultSet getFnameResult = getFirstNames();
    	String removeQuery = "DELETE FROM MAIN_INFO WHERE FNAME = ? ";
    	try {		
			DatabaseUtil.state = DatabaseUtil.conn.prepareStatement(removeQuery);
			DatabaseUtil.state.setString(1, comboValue);
			DatabaseUtil.state.execute();		
		} catch (SQLException error) {
			error.printStackTrace();
		}	
    }
    
    public static void updateRecord(String comboValue, String tf1Value, String tf2Value){
    	String changeQuery = "UPDATE ? SET ? WHERE ID = ?";
    	try {		
			DatabaseUtil.state = DatabaseUtil.conn.prepareStatement(changeQuery);
			DatabaseUtil.state.setString(1, comboValue);
			DatabaseUtil.state.execute();		
		} catch (SQLException error) {
			error.printStackTrace();
		}	
    }
    
    
     
} // End of Events class
