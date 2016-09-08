import java.sql.*;
import java.io.*;

class mysqlconn {

	public static void main(String[] args) {

		try {
			Connection con = connect_db.getConnection();
			mysql_query(con);
			mysql_connection_close(con);
		}
		catch (Exception e) {
			System.out.println("Couldnt query");
		}

		System.out.println("Successful Connection");
  
	}

	public static void mysql_query(Connection con) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select Customer_id, Customer_name from Customers"); 
		html_gen(rs);
	}

	public static void html_gen(ResultSet rs) {
		
		/*FileOutputStream out = null;
		out = new FileOutputStream("op.html");*/
		try {
			PrintWriter out = new PrintWriter("op.html");
			StringBuilder start = new StringBuilder("<html><body>");
			StringBuilder end = new StringBuilder("</body></html>");
			StringBuilder content = new StringBuilder();
			while(rs.next())  
			 	content.append(rs.getInt(1)).append(" ").append(rs.getString(2)).append("<br>"); 

			start = start.append(content).append(end); 
			out.println(start.toString());
			out.close();
		}
		catch (Exception e) {
			System.out.println("Couldnt generate html");
			e.printStackTrace();
		}

	}

	public static void mysql_connection_close(Connection con) throws Exception {
		con.close();
	}
}

class connect_db {

	static Connection con = null;
	static String dbhost = "jdbc:mysql://localhost:3306/Test";
	static String dbuser = "root";
	static String dbpass = "";


	public static Connection getConnection() {
		if (con != null) return con;
		return getConnection(dbhost,dbuser,dbpass);
	}

	public static Connection getConnection(String dbhost, String dbuser, String dbpass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbhost,dbuser,dbpass);
			return con;
		}
		catch (Exception c) {
			System.out.println("Could not connect to the Database");
			c.printStackTrace();
		}

		return con;
	}
}