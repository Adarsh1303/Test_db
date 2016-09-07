import java.sql.*;

class mysqlconn {
	public static void main(String[] args) {

		Connection c;
		mysql_connect();	
		mysql_query(c);
		mysql_connection_close(c);

		System.out.println("Successful Connection");
  
	}

	public static Connection mysql_connect() throws Exception {
		String dbhost = "jdbc:mysql://localhost:3306/Test";
		String dbuser = "root";
		String dbpass = "";

		System.out.println("start");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbhost,dbuser,dbpass);
		}
		catch (Exception c) {
			System.out.println("Could not connect to the Database");
			c.printStackTrace();
		}

		return con;
	}

	public static void mysql_query(Connection con) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select Customer_id, Customer_name from Customers");

		while(rs.next())  
			System.out.println(rs.getInt(1)+" : C_ID\n"+rs.getString(2)+" : C_Name");  

	}

	public static void mysql_connection_close(Connection con) throws Exception {
		con.close();
	}
}