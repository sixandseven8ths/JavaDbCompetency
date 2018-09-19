/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cis290.competencies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jeffrey.Herold
 */
public class Categories {
    //class variables (global)
    private String strCategoryID = "";
    private String strCategoryName = "";
    private String strDescription = "";
    
    Connection conn;
    Statement st;
    ResultSet rs;
    
    //constructor - category id as parameter
        public Categories(String c)
    {
        // load private variable
        strCategoryID = c;

        // initialize database objects
        try
        {
            //initialize database driver
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

        // call method to get customer info from database
        // and load class variables
        getCategoryInfo(c);
    }
        
private void getCategoryInfo(String cat)
    {
        try
        {
            //create database connection
//            conn = DriverManager.getConnection(
//                    "jdbc:sqlserver://10.10.0.26;databaseName=Northwind;user=student;password=student");
//            Connection conn = DriverManager.getConnection("jdbc:odbc:Northwind", "Admin", "");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind2", "root", "");

            //create statement object
            st = conn.createStatement();

            //create result set (executes SQL)
            rs = st.executeQuery("SELECT * FROM Categories WHERE CategoryID = '" + cat + "'");

            //loop to load class variables from result set
            while(rs.next())
            {
                strCategoryName = rs.getString("CategoryName");
                strDescription = rs.getString("Description");
            }

            //close stuff
            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }

    public String getCategoryName()
    {
        return strCategoryName;
    }
    public void setCategoryName(String cn)
    {
        strCategoryName = cn;
    }

    public String getDescription()
    {
        return strDescription;
    }
    public void setDescription(String ds)
    {
        strDescription = ds;
    }  
}

