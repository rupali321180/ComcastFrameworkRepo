package com.concast.com.genericdatabaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class Databaseutility {

	
	Connection conn;
	
	//this method can be invoked to any script to conn to database
	//and pass proper url,un,psw coll from the dev
	public void getdbconnection(String url, String username, String password) throws SQLException
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		conn= DriverManager.getConnection(url,username,password);	
		}catch(Exception e) {
			
		}
	}
	//not always pass as parameter
	public void getdbconnection1(String url, String username, String password) throws SQLException
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//through hardcoding pass the information inside
		conn= DriverManager.getConnection(url, username, password);	
		}catch(Exception e) {
			
		}
	}
	public void getdbconnection()
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3333/projects","root","root");
	}catch(Exception e) {
	}
	}
	
	public void closeconnection()
	{
		try {
		conn.close();
		}catch(Exception e) {
			
		}
	}
	public ResultSet executeselectquery(String query)
	{
		ResultSet result = null;
		try {
		Statement stat = conn.createStatement();
		result= stat.executeQuery(query); //jdbc api method`
		}catch(Exception e) {
			
		}
		return result;
		}
	
	public int executenonselectquery(String query)
	{
		int result=0;
		try {
			Statement stat = conn.createStatement();
			result= stat.executeUpdate(query);
		}catch(Exception e)
		{
			
		}
	return result;
		
	
	
	}
}
