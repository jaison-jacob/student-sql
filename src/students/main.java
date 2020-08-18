package students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

public class main {
	public static void main(String[] arg) throws Exception, Exception,
			Exception {

		mysql data = new mysql();
		Scanner input = new Scanner(System.in);

		// connect database
		Connection con = null;
		con = data.getconnection(con);

		// create table
		data.createtable(con);

		boolean execution = true;
		while (execution == true) {
			System.out
					.println(" STUDENTS UPDATE\n 1.ADD STUDENT DETAILS\n2.SEARCH STUDENT RESULT\n3.EXIT  ");

			int add = input.nextInt();

			if (add == 1) {
				users.studentdetailadd(input, con);
			} else if (add == 2) {
				boolean search = true;
				do {
					System.out
							.println("do you want search result based on \n 1.id \n 2.name \n 3.search exit");
					int result = input.nextInt();
					if (result == 1) {
						System.out.println("ENTER STUDENT ID");
						int newid = input.nextInt();
						mysql.result(con, newid);
					} else if (result == 2) {
						System.out.println("ENTER STUDENT NAME");
						String newname = input.next();
						mysql.result(con, newname);
					} else if (result == 3) {
						search = false;
					}else if(result > 3){
						System.out.println("PLEASE ENTER VALID KEY");
					}
				} while (search == true);
			} else if (add == 3) {
				break;
			}else if(add > 3){
				System.out.println("PLEASE ENTER VALID KEY");
			}

		}
	}

}
