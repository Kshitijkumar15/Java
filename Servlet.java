InsertData.java 

package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String studentName,rollNumber,section;
		int sub1,sub2,sub3,sub4,sub5,sub6,lab1,lab2;
		studentName=request.getParameter("name");
		rollNumber=request.getParameter("rollNumber");
		section=request.getParameter("section");
		sub1=Integer.valueOf(request.getParameter("sub1"));
		sub2=Integer.valueOf(request.getParameter("sub2"));
		sub3=Integer.valueOf(request.getParameter("sub3"));
		sub4=Integer.valueOf(request.getParameter("sub4"));
		sub5=Integer.valueOf(request.getParameter("sub5"));
		sub6=Integer.valueOf(request.getParameter("sub6"));
		lab1=Integer.valueOf(request.getParameter("lab1"));
		lab2=Integer.valueOf(request.getParameter("lab2"));
		//System.out.println(studentName+" "+rollNumber+" "+section+" "+sub1+" "+sub2+" "+sub3+" "+sub4+" "+sub5+" "+sub6+" "+lab1+" "+lab2);
		String url="jdbc:mysql;//root@localhost:3306/demo";
		String username="root";
		String password="740654sk";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			PreparedStatement insertStatement=connection.prepareStatement("insert into marks values(?,?,?,?,?,?,?,?,?,?,?,");
			insertStatement.setString(1, rollNumber);
			insertStatement.setString(2, studentName);
			insertStatement.setString(3, section);
			insertStatement.setInt(4, sub1);
			insertStatement.setInt(5, sub2);
			insertStatement.setInt(6, sub3);
			insertStatement.setInt(7, sub4);
			insertStatement.setInt(8, sub5);
			insertStatement.setInt(9, sub6);
			insertStatement.setInt(10, lab1);
			insertStatement.setInt(11, lab2);
			insertStatement.execute();
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print("<html>"+"<body>"+"<h1>you have inserted the data </h1>"+"</body>"+"</html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

}
**********************************************************************************************************
DisplayResult.java

package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class DisplayResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String url="jdbc:mysql;//root@localhost:3306/demo";
		String username="root";
		String password="740654sk";
		String rollNumber=request.getParameter("rollNumber");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			PreparedStatement displayStatement=connection.prepareStatement("select * from marks where rollno=?");
			displayStatement.setString(1,  rollNumber); 
			ResultSet resultSet=displayStatement.executeQuery();
			out.print("<html><body>");
			while(resultSet.next())
			{
				out.print("<p>");
				out.print("Name"+resultSet.getString(2));
				out.print("</p>");
				out.print("<p>");
				out.print("Roll Number"+resultSet.getString(1));
				out.print("</p>");
				out.print("<p>");
				out.print("Section"+resultSet.getString(3));
				out.print("</p>");
				out.print("<p>");
				out.print("Subject 1"+resultSet.getInt(4));
				out.print("</p>");
				out.print("<p>");
				out.print("Subject 2"+resultSet.getInt(5));
				out.print("</p>");
				out.print("<p>");
				out.print("Subject 3"+resultSet.getInt(6));
				out.print("</p>");
				out.print("<p>");
				out.print("Subject 4"+resultSet.getInt(7));
				out.print("</p>");
				out.print("<p>");
				out.print("Subject 5"+resultSet.getInt(8));
				out.print("</p>");
				out.print("<p>");
				out.print("Subject 6"+resultSet.getInt(9));
				out.print("</p>");
				out.print("<p>");
				out.print("Lab 1"+resultSet.getInt(10));
				out.print("</p>");
				out.print("<p>");
				out.print("Lab 2"+resultSet.getInt(11));
				out.print("</p>");
				if(resultSet.getInt(4)>40 && resultSet.getInt(5)>40 && resultSet.getInt(6)>40 && resultSet.getInt(7)>40 && resultSet.getInt(8)>40
						&& resultSet.getInt(9)>40 && resultSet.getInt(10)>40 && resultSet.getInt(11)>40)
				{
					out.print("<h1>Pass</h1>");
				}
				else
				{
					out.print("<h1>Pass</h1>");
					connection.close();
				}
				
			}
			out.print("</html></body>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
**********************************************************************************************************
Web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <display-name>lab4</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.jsp</welcome-file>
    <welcome-file>default.htm</welcome-file>
  </welcome-file-list>
  <servlet>
  <servlet-name>InsertData</servlet-name>
  <servlet-class>myServlet.InsertData</servlet-class>
  </servlet>
  <servlet-mapping>
  <servlet-name>InsertData</servlet-name>
  <url-pattern>/InsertData</url-pattern>
  </servlet-mapping>
  <servlet>
  <servlet-name>DisplayResult</servlet-name>
  <servlet-class>myServlet.DisplayResult</servlet-class>
  </servlet>
  <servlet-mapping>
  <servlet-name>DisplayResult</servlet-name>
  <url-pattern>/DisplayResult</url-pattern>
  </servlet-mapping>
</web-app>
**********************************************************************************************************
Insert.html

<!DOCTYPE html> 
<html> 
<head> 
<title>Insert title here</title> 
</head> 
<body> 
<form action="InsetData" method="post"> 
<table>  
<tr><td>Enter Roll No:</td>  
<td><input type="text" name="rollNumber"/></td> 
</tr> 
<tr><td>Enter Name:</td>  
<td><input type="text" name="studentName"/></td> 
</tr> 
<tr><td>Enter Section:</td>  
<td><select name="section">  
<option>A</option>  
<option>B</option>  
<option>C</option>  
<option>D</option> 
</select>  
</td> 
</tr> 
<tr><td>Enter Subjet1 Mark:</td>  
<td><input type="text" name="sub1"/></td> 
</tr> 
<tr><td>Enter Subject2 Mark:</td>  
<td><input type="text" name="sub2"/></td> 
</tr> 
<tr><td>Enter Subjet3 Mark:</td>  
<td><input type="text" name="sub3"/></td> 
</tr>  
<tr><td>Enter Subject4 Mark:</td>  
<td><input type="text" name="sub4"/></td> 
</tr> 
<tr><td>Enter Subject5 Mark:</td>  
<td><input type="text" name="sub5"/></td> 
</tr> 
<tr><td>Enter Subject6 Mark:</td>  
<td><input type="text" name="sub6"/></td> 
</tr> 
<tr><td>Enter Lab1 Mark:</td>  
<td><input type="text" name="lab1"/></td> 
</tr> 
<tr><td>Enter Lab2 Mark:</td>  
<td><input type="text" name="lab2"/></td> 
</tr> 
<tr><td><input type="submit"/></td></tr> 
</table> 
</form> 

<br>

<form action="DisplayResult" method="post">
<label>Enter your roll number</label>
<input type="text" name="roll Number">
<input type="submit">
</form>
</body>
</html>
**********************************************************************************************************
**********************************************************************************************************
STEP 1: CREATE PACKAGE
STEP 2:NEW> HTML FILE(INSERT.HTML)
STEP 3:ADD SERVER FROM SERVER SECTION> SELECT TOMCAT 10.1 DO THE STEPS.
STEP 4:ADD SERVER AND MYSQL CONNECTOR JAR FILES (IN BUILD PATH).
STEP 5:CREATE SERVLET AND GIVE PACKAGE NAME AND CLASS NAME AS INSERTATA> SELECT ONLY DO POST METHOD
STEP 6:REPLACE JAVAX WITH JAKARTA
STEP 7:DO WEB.XML
STEP 8:OPEN MYSQL WORKBENCH >CREATE SCHEMA>TABLES EMP AND MARKS. IN MARKS CREATE SUBJEXTS AND LABS.EMP WITH EID AND ENAME.
STEP 9:CREATE DISPLAYRESULT.JAVA
STEP 10:ADD <servlet>
  <servlet-name>DisplayResult</servlet-name>
  <servlet-class>myServlet.DisplayResult</servlet-class>
  </servlet>
  <servlet-mapping>
  <servlet-name>DisplayResult</servlet-name>
  <url-pattern>/DisplayResult</url-pattern>
  </servlet-mapping>
STEP 11:IN INDEX.HTML ADD FORM ACTION=DISPLAYRESULT
