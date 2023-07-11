package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class InsertDataIntoDB {

	public static void main(String[] args) throws SQLException 
	{
		Connection conn=null;
		try
		{
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement=conn.createStatement();
			String Query="insert into project values('TY_PRO_4095','Sachin','Dinga','29/06/2023','Tyss','6')";
			int result=statement.executeUpdate(Query);
			if(result==1)
			{
				System.out.println("data is created");
			}
			else
			{
				System.out.println("data is not created");
			}
		}
		finally
		{
			conn.close();
		}
	}

}
