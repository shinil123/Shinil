package sms.genericutility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class DatabaseUtility 
{
	Driver driver;
	 Connection connection;
	 ResultSet result;
   FileUtility flib = new FileUtility();
   String URL;
   String USERNAME;
   String PASSWORD;
   
public DatabaseUtility()
{
	String file_path;
	try {
		file_path = flib.getDataFromProperties("database");
	URL = flib.getDataFromProperties(file_path, "url");
	USERNAME = flib.getDataFromProperties(file_path, "username");
	PASSWORD = flib.getDataFromProperties(file_path, "password");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	 // This method will perform the mysql database connection 
	public void connectDB() throws SQLException {
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// This method will close the mysql database
	public void closeDB() throws SQLException {
		try {
		  connection.close();
		}catch (Exception e) {
		}


	}
	
	//This method will execute the query
	public ResultSet execyteQuery(String query) throws Throwable {	
			result = connection.createStatement().executeQuery(query);
			return result;		
	}
	
	
	 //This method will execute the query
	public int execyteUpdate(String query) throws Throwable {
		
			int result = connection.createStatement().executeUpdate(query);
	
		return result;

	}
	
	// This method will execute query based on query and it will verify the data. 
	public boolean executeQuerryAndVerify(String querry,int cloumnIndex,String expectedData) throws Throwable {
		boolean flag=false;
		result=connection.createStatement().executeQuery(querry);
		while(result.next()) {
			if(result.getString(cloumnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData+"==>Data is verified in the data base table");
			return flag;
		}else {
			System.out.println(expectedData+"==>data is not verified in the database");
			return flag;
		}
        
	}
}
