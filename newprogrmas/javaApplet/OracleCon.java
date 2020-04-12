import java.sql.*;
class OracleCon{
	public static void main(String args[]){
		try{
			//1. load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.create the connection object
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			
			//3.create the statement object
			Statement stmt=con.createStatement();
			
			//4.execute query
			ResultSet rs=stmt.executeQuery("Select * from company");
			
			while(rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			//5. close the connectino object
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}