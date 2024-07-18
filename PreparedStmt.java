import java.sql.*;
import java.util.*;
class PreparedStmt{
	public static void main(String args[]){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Load the class Successfull...");

			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","yash","yash");
			System.out.println("Connection Establishment Successfull...");

			String qry="insert into studentInfo values(?,?,?)";
			String qry1="select * from studentInfo";
			Scanner sc=new Scanner(System.in);

			PreparedStatement pstmt=con.prepareStatement(qry);
			PreparedStatement pstmt1=con.prepareStatement(qry1);

			System.out.println("Enter Student ID: ");
			int sid=sc.nextInt();
			
			System.out.println("Enter Student name: ");
			String sname=sc.next();
			
			System.out.println("Enter Student Address: ");
			String saddr=sc.next();

			pstmt.setInt(1,sid);
			pstmt.setString(2,sname);
			pstmt.setString(3,saddr);
		
			int n=pstmt.executeUpdate();
			if(n!=0){
				System.out.println("1 row inserted Successfull...");
				ResultSet rs=pstmt1.executeQuery();
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}
			}else{
				System.out.println("Not inserted..");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}