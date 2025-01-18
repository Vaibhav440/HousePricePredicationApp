package org.TechHub.repository;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
public class DBConfig
{

		protected static Connection conn;
		protected static  PreparedStatement stmt;
		protected static ResultSet rs;
		protected static CallableStatement cstmt;
		protected static DBConfig db;
		private DBConfig()
		{
			try
			{
			    
				Class.forName("com.mysql.cj.jdbc.Driver");
				File f=new File("");
				String path=f.getAbsolutePath();
				FileInputStream inputStream=new FileInputStream(path+"\\src\\main\\resources\\dbconfig.properties");
				Properties p=new Properties();
				p.load(inputStream);
				String driverClassName=p.getProperty("driver");
				String username=p.getProperty("username");
				String password=p.getProperty("password");
				String url=p.getProperty("url");
				conn=DriverManager.getConnection(url,username,password);
				
				
			} catch (Exception e) {
				System.out.println("Error is"+e); //here infuture logger will be used 
			}
		}
		public static DBConfig getInstance()
		{
			if(db==null)
			{
				db=new DBConfig();
			}
			return db;
		}
		public static Connection getConn()
		{
		   return conn;	
		}
		public static PreparedStatement getStatement()
		{
			return stmt;
		}
		public static ResultSet getResultSet()
		{
			return rs;
		}
		public static CallableStatement getCallStatement()
		{
			return cstmt;
		}
		
}
