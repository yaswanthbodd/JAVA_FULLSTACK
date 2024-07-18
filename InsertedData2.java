import java.sql.*;
import java.util.*;

class InsertedData2{
	public static void main(String args[]){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Class load Succesfully...");

			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","yash","yash");
			System.out.println("Connection Establishment Succesfull...");

			Statement stmt=con.createStatement();
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Student id number...");
			int sid=sc.nextInt();

			System.out.println("Enter Student name:.........");
			String sname=sc.next();
			
			System.out.println("Enter Student Address...");
			String saddr=sc.next();
		
			String qry="insert into studentInfo values("+sid+",'"+sname+"','"+saddr+"')";
			int n=stmt.executeUpdate(qry);
		
			if(n!=0)
				System.out.println("1 row inserted Successfully......");
			else
				System.out.println("Not inserted...");

			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}