import java.sql.*;
class Connect{
	public static void main(String args[]){
		try{
			oracle.jdbc.driver.OracleDriver od=new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(od);
			System.out.println("Driver class Registered Successfully....");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}