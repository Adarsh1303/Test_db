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
		}
		catch (Exception c) {
			System.out.println("caught mysql exception");
			c.printStackTrace();
		}
		System.out.println("Successful Connection");
	}
}