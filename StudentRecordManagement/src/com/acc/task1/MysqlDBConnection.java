package com.acc.task1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.loader.PropertyLoader;

public class MysqlDBConnection { /*Task 1 create Mysql connection*/

	public static Connection myDBgetConnecnection() {
		Connection con=null;
		try {
			Class.forName(PropertyLoader.DRIVER);
			try {
				con=DriverManager.getConnection(PropertyLoader.URL,PropertyLoader.USER,PropertyLoader.PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		return con;
	}
	public static void main(String[]args) {
		MysqlDBConnection.myDBgetConnecnection();
		System.out.println("Connection Successfull..!");
	}
}
