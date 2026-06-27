package com.acc.task4;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.acc.task1.MysqlDBConnection;

public class UpdateStudentRecord {
	public static void stuInfoupdation() {
		System.out.println("Enter Student id for Updating Student record");
		Scanner sc=new Scanner(System.in);
		int id =sc.nextInt();
		
		System.out.println("Enter updated Marks");
		int marks=sc.nextInt();
		Connection con=null;
		con=MysqlDBConnection.myDBgetConnecnection();
		PreparedStatement psmt=null;
		try {
			psmt=con.prepareStatement("Update Students set marks=? where id=?");
			psmt.setInt(1, marks);
			psmt.setInt(2, id);
			psmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {	
			try {
				if(con!=null)
				{
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		System.out.println("Student Details Updated Successfully");	
	}
//	main method****************************************************
	public static void main(String[] args) {
		UpdateStudentRecord.stuInfoupdation();
	}

}
