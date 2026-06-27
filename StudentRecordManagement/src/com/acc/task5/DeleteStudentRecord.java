package com.acc.task5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.acc.task1.MysqlDBConnection;

public class DeleteStudentRecord {

	public static void stuInfoDeletion() {
		System.out.println("Enter Student id for deleting Student record");
		Scanner sc=new Scanner(System.in);
		int id =sc.nextInt();
		Connection con=null; 
		con=MysqlDBConnection.myDBgetConnecnection();
		PreparedStatement psmt=null;
		try {
			psmt=con.prepareStatement("Delete from students where id=?");
			psmt.setInt(1, id);
			psmt.executeUpdate();
			} catch (SQLException e) { 
			e.printStackTrace();
		}  finally {	
			try {
				if(con!=null)
				{
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Student Details Deleteded Successfully");		
	}
	public static void main(String[] args) {
		
		DeleteStudentRecord.stuInfoDeletion();

	}

}
