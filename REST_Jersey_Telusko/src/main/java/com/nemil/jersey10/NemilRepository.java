package com.nemil.jersey10;

import java.util.ArrayList;
import java.util.List;
//import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.mysql.cj.xdevapi.Statement;


public class NemilRepository 
{
	List<Nemil> nemils;
	
	Connection con =null;
	
	public NemilRepository()
	{
		 String driver =  "com.mysql.cj.jdbc.Driver";
		 String url = "jdbc:mysql://localhost:3306/restapi";
		 String username = "root";
		 String password = "Nem021496!";

		 
		 try 
		 {
			 Class.forName(driver); 
			 con = DriverManager.getConnection(url, username, password);
		 }
		 
		 catch (Exception e)
		 {
			System.out.println(e);
		 }
		 	
	}
	
	
	// Fetch all list of nemil
	public List<Nemil> getNemils()
	{ 
		List<Nemil> nemils = new ArrayList<>();
		
		String sql = "SELECT * FROM restapi.nemil";
		
		try {
			java.sql.Statement check =  con.createStatement();
		    ResultSet rs = check.executeQuery(sql);
		    
		    while (rs.next())
		    {
		    	Nemil n = new Nemil();
		    	
		    	n.setId( rs.getInt(1));
		    	n.setName(rs.getString(2));
		    	
		    	nemils.add(n);
		    	
		    }
			
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return nemils;
		
	}
	
	// Fetch a particular nemil.
	
	public Nemil getNemil(int id)
	{
		
		String sql = "SELECT * FROM restapi.nemil WHERE id =" + id;
		Nemil n = new Nemil();
		
		try {
			
			java.sql.Statement check =  con.createStatement();
		    ResultSet rs = check.executeQuery(sql);
		    
		    if (rs.next())
		    { 	
		    	n.setId( rs.getInt(1));
		    	n.setName(rs.getString(2));  	
		    }
			
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return n;
	}


	public void create(Nemil nem) {
		// TODO Auto-generated method stub
		
		String sql = "insert into restapi.nemil values (?, ?)"; // ? acts as placeholder which holds a value.
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, nem.getId());
			st.setString(2, nem.getName());	
			st.executeUpdate();			
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}	
	}


	public void update(Nemil nem) 
	{
		// TODO Auto-generated method stub
		
		String sql = "update restapi.nemil set name = ? where id = ?"; // ? acts as placeholder which holds a value.
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, nem.getName());	
			st.setInt(2, nem.getId());	
			st.executeUpdate();			
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}	
		
	}


	public void delete(int id) {
		// TODO Auto-generated method stub
		
		String sql = "delete from restapi.nemil where id = ?"; // ? acts as placeholder which holds a value.
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);	
			st.setInt(1, id);	
			st.executeUpdate();			
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}	
		
	}
	
}
