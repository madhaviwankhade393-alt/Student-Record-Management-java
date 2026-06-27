package com.acc.task3;
import com.acc.task2.TotalStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.acc.task1.MysqlDBConnection;

public class InsertStudentRecord {
	int id; 
	String name;
	int age;
	int marks;
	public static void stuInfoInsertion() {
		Connection con=null; 
		con=MysqlDBConnection.myDBgetConnecnection();
		PreparedStatement psmt=null;
		InsertStudentRecord isr=new InsertStudentRecord();
		try { 
			psmt=con.prepareStatement("insert into Students(id,name,age,marks)values(?,?,?,?)");  
			psmt.setInt(1, isr.id);
		 	psmt.setString(2, isr.name);
			psmt.setInt(3, isr.age);
			psmt.setInt(4,isr.marks );
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
		System.out.println("Student Details Inserted Successfully");		
	}	
//	Main Method**********************************************************************
	public static void main(String[] args) { 
		
		InsertStudentRecord.stuInfoInsertion();		
	}
	//Constructor
	public InsertStudentRecord() {
		super();
		System.out.println("Insert Student Details"); 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student id");
		int id=sc.nextInt();
		this.id = id;
		System.out.println("Enter Student Name");
		String name=sc.next();
		this.name = name;
		System.out.println("Enter Student Age");
		int age=sc.nextInt();
		this.age = age;
		System.out.println("Enter Student  marks");
		int marks=sc.nextInt();
		this.marks=marks;
	} 
} 
