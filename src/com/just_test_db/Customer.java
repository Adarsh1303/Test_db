package com.just_test_db;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Customer")
class Customer {
	int CustomerID;
	String Customer_email;
	String Customer_phone;
	
	public Customer() {}
	public Customer(int c, String e, String p) {
		this.CustomerID = c;
		this.Customer_email = e;
		this.Customer_phone = p;
	}
	/**
	 * @return the customerID
	 */
	public int getCustomerID() {
		return CustomerID;
	}
	/**
	 * @param customerID the customerID to set
	 */
	@XmlElement
	public void setCustomerID(int customerID) {
		this.CustomerID = customerID;
	}
	/**
	 * @return the customer_email
	 */
	public String getCustomer_email() {
		return Customer_email;
	}
	/**
	 * @param customer_email the customer_email to set
	 */
	@XmlElement
	public void setCustomer_email(String customer_email) {
		this.Customer_email = customer_email;
	}
	/**
	 * @return the customer_phone
	 */
	public String getCustomer_phone() {
		return Customer_phone;
	}
	/**
	 * @param customer_phone the customer_phone to set
	 */
	@XmlElement
	public void setCustomer_phone(String customer_phone) {
		this.Customer_phone = customer_phone;
	}
	
}