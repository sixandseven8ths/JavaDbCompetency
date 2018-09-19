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
 * @author ARMSTROD
 */
public class Customer {

    // class variables (global)
    private String strCustomerID = "";
    private String strCompanyName = "";
    private String strContactName = "";
    private String strContactTitle = "";
    private String strAddress = "";
    private String strCity = "";
    private String strState = "";
    private String strZip = "";
    private String strPhone = "";

    Connection conn;
    Statement st;
    ResultSet rs;

    // constructor - customer id as parameter
    public Customer(String c)
    {
        // load private variable
        strCustomerID = c;

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
        getCustomerInfo(c);
    }

    private void getCustomerInfo(String cust)
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
            rs = st.executeQuery("SELECT * FROM Customers WHERE CustomerID = '" + cust + "'");

            //loop to load class variables from result set
            while(rs.next())
            {
                strCompanyName = rs.getString("CompanyName");
                strContactName = rs.getString("ContactName");
                strContactTitle = rs.getString("ContactTitle");
                strAddress = rs.getString("Address");
                strCity = rs.getString("City");
                strState = rs.getString("Region");
                strZip = rs.getString("PostalCode");
                strPhone = rs.getString("Phone");
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

    public String getCompanyName()
    {
        return strCompanyName;
    }
    public void setCompanyName(String cn)
    {
        strCompanyName = cn;
    }

    public String getContactName()
    {
        return strContactName;
    }
    public void setContactName(String cn)
    {
        strContactName = cn;
    }

    public String getContactTitle()
    {
        return strContactTitle;
    }
    public void setContactTitle(String ct)
    {
        strContactTitle = ct;
    }

    public String getAddress()
    {
        return strAddress;
    }
    public void setAddress(String a)
    {
        strAddress = a;
    }

    public String getCity()
    {
        return strCity;
    }
    public void setCity(String c)
    {
        strCity = c;
    }

    public String getState()
    {
        return strState;
    }
    public void setState(String s)
    {
        strState = s;
    }

    public String getZip()
    {
        return strZip;
    }
    public void setZip(String z)
    {
        strZip = z;
    }

    public String getPhone()
    {
        return strPhone;
    }
    public void setPhone(String p)
    {
        strPhone = p;
    }
   
}
