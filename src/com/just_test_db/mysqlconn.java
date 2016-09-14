package com.just_test_db;

import java.sql.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("mysqlconn")
class mysqlconn {

	
	public static void main(String[] args) {

		try {
			mysqlconn m = new mysqlconn();
			Customer c = null;
			c = m.getdata();
			c.print();
		}
		catch (Exception e) {
		}
  
	}
	@GET
	@Path("/customer")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getdata() {
		Customer c = new Customer();
		try {
			mysqlconn m = new mysqlconn();
			Connection con = Connect_db.getConnection();
			c = m.mysql_query(con);
			m.mysql_connection_close(con);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return c;
		
	}
	
	public Customer mysql_query(Connection con){
		Customer q = new Customer(3,"klbm","949494");
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select Customer_id, Customer_email, Customer_phone from Customers");
			if(rs.next()) {
				Customer c = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3));
				q = c;
			}
			return q;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return q;
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

	public int mysql_connection_close(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
}

