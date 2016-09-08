import java.sql.*;

class mysqlconn {
	public static void main(String[] args) {

		String dbhost = "jdbc:mysql://localhost:3306/Test";
		String dbuser = "root";
		String dbpass = "";

		System.out.println("start");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbhost,dbuser,dbpass);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select Customer_id, Customer_name from Customers");

			while(rs.next())  
				System.out.println(rs.getInt(1)+" : C_ID\n"+rs.getString(2)+" : C_Name");  

			con.close();
		}
		catch (Exception c) {
			System.out.println("caught mysql exception");
			c.printStackTrace();
		}
		System.out.println("Successful Connection");
  
	}
}