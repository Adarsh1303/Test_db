package com.just_test_db;

import java.sql.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/mysqlconn")
class mysqlconn {

	
	/*public static void main(String[] args) {

		try {
			Connection con = Connect_db.getConnection();
			mysql_query(con);
			mysql_connection_close(con);
		}
		catch (Exception e) {
			System.out.println("Couldnt query");
		}

		System.out.println("Successful Connection");
  
	}*/
	@GET
	@Path("/Customer")
	@Produces(MediaType.APPLICATION_XML)
	public void getdata() {
		try {
			Connection con = Connect_db.getConnection();
			mysql_query(con);
			mysql_connection_close(con);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Customer mysql_query(Connection con) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select Customer_id, Customer_email, Customer_phone from Customers");
		Customer c = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3));
		return c;
		//html_gen(rs);
	}

	/*public void html_gen(ResultSet rs) {
		
		FileOutputStream out = null;
		out = new FileOutputStream("op.html");
		try {
			PrintWriter out = new PrintWriter("op.html");
			StringBuilder start = new StringBuilder("<html><body>");
			StringBuilder end = new StringBuilder("</body></html>");
			StringBuilder content = new StringBuilder();
			while(rs.next())  
			 	content.append(rs.getInt(1)).append(" ").append(rs.getString(2)).append(rs.getString(3)).append(" yolo<br>"); 

			start = start.append(content).append(end); 
			out.println(start.toString());
			out.close();
		}
		catch (Exception e) {
			System.out.println("Couldnt generate html");
			e.printStackTrace();
		}

	}*/

	public void mysql_connection_close(Connection con) throws Exception {
		con.close();
	}
}

