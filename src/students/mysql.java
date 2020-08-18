package students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class mysql {

	// INSERT COLUMN
	public static void add(students detail, Connection con) throws Exception {

		Statement stmt = (Statement) con.createStatement();

		stmt.execute("insert into students(id,name,age,tamil,english,maths,science,social)"
				+ "values"
				+ "("
				+ detail.id
				+ ","
				+ "'"
				+ detail.name
				+ "'"
				+ ","
				+ detail.age
				+ ","
				+ detail.tamil
				+ ","
				+ detail.english
				+ ","
				+ detail.maths
				+ ","
				+ detail.science
				+ ","
				+ detail.social + ")");

	}

	// GET RESULT BASED ON THE ID
	public static void result(Connection con, int newid) throws Exception {
         
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from students where id ="
				+ newid);
        
		System.out.println();
		

		System.out.println();
		if(rs.next() == false){
			System.out.println("ENTER VALID ID");
			System.out.println();
		}else{
		while (rs.next()) {

			System.out.println("               " + "Students detail"
					+ "                        ");
			// GET STUDENT DETAILS FROM DATABASE
			System.out.println("STUDENT ID :" + rs.getInt(1)
					+ "\nSTUDENT NAME :" + rs.getString(2) + "\nSTUDENT AGE :"
					+ rs.getInt(3) + "\nSTUDENT TAMIL MARK :" + rs.getInt(4)
					+ "\nSTUDENT ENGLISH MARK :" + rs.getInt(5)
					+ "\nSTUDENT MATHS MARK :" + rs.getInt(6)
					+ "\nSTUDENT SCIENCE MARK :" + rs.getInt(7)
					+ "\nSTUDENT SOCIAL MARK :" + rs.getInt(8));

			// GET STUDENT DETAIL FROM DATABASE AND CALCULATE TOTAL MARK
			int total = rs.getInt(4) + rs.getInt(5) + rs.getInt(6)
					+ rs.getInt(7) + rs.getInt(8);

			// STUDENT AVG MARK CALCULation
			int avg = total / 5;

			System.out.println("student total is  :" + total);

			System.out.println("student avg is  :" + avg);

			// GET STUDENT DETAIL FROM DATABASE AND GET RESULT STUDENT PASS OR
			// NOT
			if (rs.getInt(4) < 40 || rs.getInt(5) < 40 || rs.getInt(6) < 40
					|| rs.getInt(7) < 40 || rs.getInt(8) < 40) {
				System.out.println("student is fail");
			} else {
				System.out.println("Student is pass");
			}
			
		}
		}
	}

	// GET RESULT BASED ON THE NAME
	public static void result(Connection con, String newname) throws Exception {

		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from students where name ="
				+ "'" + newname + "'");

		System.out.println();
		

		System.out.println();
		if(rs.next() == false){
			System.out.println("ENTER VALID NAME");
			System.out.println();
		}else{
		while (rs.next()) {
			System.out.println("               " + "Students detail"
					+ "                        ");
			// STUDENT DETAILS
			System.out.println("STUDENT ID :" + rs.getInt(1)
					+ "\nSTUDENT NAME :" + rs.getString(2) + "\nSTUDENT AGE :"
					+ rs.getInt(3) + "\nSTUDENT TAMIL MARK :" + rs.getInt(4)
					+ "\nSTUDENT ENGLISH MARK :" + rs.getInt(5)
					+ "\nSTUDENT MATHS MARK :" + rs.getInt(6)
					+ "\nSTUDENT SCIENCE MARK :" + rs.getInt(7)
					+ "\nSTUDENT SOCIAL MARK :" + rs.getInt(8));

			// STUDENT TOTAL MARK
			int total = rs.getInt(4) + rs.getInt(5) + rs.getInt(6)
					+ rs.getInt(7) + rs.getInt(8);

			// STUDENT AVG MARK
			int avg = total / 5;

			System.out.println("student total is  :" + total);

			System.out.println("student avg is  :" + avg);

			// STUDENT PASS OR NOT
			if (rs.getInt(4) < 40 || rs.getInt(5) < 40 || rs.getInt(6) < 40
					|| rs.getInt(7) < 40 || rs.getInt(8) < 40) {
				System.out.println("student is fail");
			} else {
				System.out.println("Student is pass");
			}
		}
		}
	}

	// GET CONNECTION

	public Connection getconnection(Connection con)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/students", "root", "");
		return con;
	}

	// TABLE CREATION
	public void createtable(Connection con) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt = (Statement) con.createStatement();
		try {
			stmt.execute("create table students(id int,name varchar(30),age int,tamil int,english int,maths int,science int,social int)");
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
			System.out.println("already table is created");
		}
	}

}
