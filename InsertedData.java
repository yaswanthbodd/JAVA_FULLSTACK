import java.sql.*; // Step - 1
class InsertedData{
	public static void main(String args[]){
		try{
			// oracle.jdbc.driver.OracleDriver od=new oracle.jdbc.driver.OracleDriver();
			// DriverManager.registerDriver(od);
			// System.out.println("Driver class Registered Successfully....");

			// Step - 2 load or register the Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Load succesfully..");

			//Step - 3 Connect to the Database 
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="yash";
			String pass="yash";
			Connection con=DriverManager.getConnection(url,user,pass);	
			System.out.println("Connection Succesfully...");
			
			//Step - 4 Creating Statement
			Statement stmt=con.createStatement();
			String query="insert into studentInfo values(591,'Naveen','trv')";
			int n = stmt.executeUpdate(query);
			if(n!=0)
			   System.out.println("1 row inserted Successfully.....");
			else
			   System.out.println("not inserted....");
				
		}catch(Exception e){
			System.out.println(e);
		}
	}
}