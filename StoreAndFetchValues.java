import java.sql.*;
import java.util.*;

class StoreAndFetchValues{
	public static void main(String args[]){	
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Load the class Successfull..");
		
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","yash","yash");
		System.out.println("Connection Establishment Succesfully completed.....");

		Statement stmt=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Student Id: ");
		int sid=sc.nextInt();

		System.out.println("Enter Student Name: ");
		String sname=sc.next();

		System.out.println("Enter Student Address: ");
		String saddr=sc.next();

		String qry="insert into studentInfo values("+sid+",'"+sname+"','"+saddr+"')";
		int n=stmt.executeUpdate(qry);
		if(n!=0){
			System.out.println("1 row inserted Succesfull..");
			String qry1="select * from studentInfo";
			ResultSet rs=stmt.executeQuery(qry1);
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		}else{
			System.out.println("Not Inserted Succesfull...");
		}

		conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}