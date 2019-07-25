package com;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DataBaseOperations {
		//private static final String url = "jdbc:mysql://localdb.cfpbwrqb6fx5.us-east-1.rds.amazonaws.com:3306/localdb"; 
		private static final String url = "jdbc:mysql://localhost:3306/localdb"; 
	
		private static final String user = "root"; // "hive"; 
		private static final String password = "root"; // hivehive";

    public static void main(String[] args)  {

        //getData();
    }

	public String getData() {
		String data = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection connection = DriverManager.getConnection(url, user, password);	
			Statement stmt = connection.createStatement();

			String selectSql = "SELECT eno, fname, lname from emp";
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while(resultSet.next()){
            	int eno = resultSet.getInt("eno");
            	String fname = resultSet.getString("fname");
            	String lname = resultSet.getString("lname");
            	data = eno + " - " + fname + " - " + lname;
            	System.out.println("---in class file " + data);
            }
		} catch(ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return data;
	} 
	
	public ArrayList getInvoiceData() {
		ArrayList list = new ArrayList();
		Invoice invoice=null;
		String data = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection connection = DriverManager.getConnection(url, user, password);	
			Statement stmt = connection.createStatement();

			String selectSql = "SELECT companyid, vendorid, amt from invoice";
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while(resultSet.next()){
            	invoice = new Invoice();
            	invoice.setCompanyId(resultSet.getInt("companyid"));
            	invoice.setVendorId(resultSet.getInt("vendorid"));
            	invoice.setAmt(resultSet.getInt("amt"));
            	list.add(invoice);
            }
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		return list;
	}
}