package com.acc.task2;

import java.sql.Connection;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.acc.task1.MysqlDBConnection;

public class TotalStudent {
int id; 
String name;
int age; 
int marks; 
	public static List<TotalStudent> displayAllStudents() {
		Connection con=null;
		con=MysqlDBConnection.myDBgetConnecnection();/* call method having create connection code */
		Statement stmt=null;
		ResultSet rs=null;  
		List<TotalStudent> stu=new ArrayList<TotalStudent>(); /* List referance stu points to Arraylist*/
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from Students");
		 	/*stores result of select query into ResultSet rs*/
			while(rs.next()) {
			stu.add(new TotalStudent(/*get the colunm record from ResultSet*/rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getInt("marks"))/*store values in object of type TotalStudent */); 
			/* add the objecet into ArrayList having reference stu*/
			}
		} catch (SQLException e) {  
			e.printStackTrace();
		}finally { 
			try {
				 if(rs!=null) {
	                     rs.close();
				  }else if(con!=null) { 
							con.close();
				   }
			   } catch (SQLException e) {
					e.printStackTrace();
					}
			}		
		return stu; /*return record of ArrayList*/
	}
	
	public static void main(String[] args) {
		
		List<TotalStudent> stu=new ArrayList<TotalStudent>();
		stu=TotalStudent.displayAllStudents();
		System.out.println();
		System.out.println("Total Students");
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("|  ID   |  NAME    |   AGE   |   MARKS   |");
		System.out.println("------------------------------------------");
		for(TotalStudent s1:stu) {
			System.out.println(s1);
			System.out.println("------------------------------------------");
			}
	} 
//parametrized constructor
	public TotalStudent(int id, String name, int age,int marks) {
		super();
		this.id = id;
		this.name = name;
		this.age = age; 
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "|   " + id + "   |" + name + "   |    " + age + "   |"+"   "+marks+"      |";
	}
}
