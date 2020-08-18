package students;

import java.sql.Connection;
import java.util.Scanner;



public class users{

	public static void studentdetailadd(Scanner input ,Connection con) throws Exception {
		
		 System.out.println("ENTER STUDENT ID");
		 int id = input.nextInt();
		 
		 System.out.println("ENTER STUDENT NAME");
		 String name = input.next();
		 
         System.out.println("ENTER STUDENT AGE");
         int age = input.nextInt();
         
         System.out.println("ENTER STUDENT TAMIL MARK");
         int tamil = input.nextInt();
         
         System.out.println("ENTER STUDENT ENGLISH MARK");
         int english = input.nextInt();
         
         System.out.println("ENTER STUDENT MATHS MARK");
         int maths = input.nextInt();
         
         System.out.println("ENTER STUDENT SCIENCE MARK");
         int science = input.nextInt();
         
         System.out.println("ENTER STUDENT SOCIAL MARK");
         int social = input.nextInt();
         
         students object = new students(id,name,age,tamil,english,maths,science,social);
          
         mysql.add(object,con);
        
		
	}

}
