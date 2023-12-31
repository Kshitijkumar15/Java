index.jsp

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> <title>Login Page</title> </head>
<body>
<h1>LOGIN</h1>
<form action="UserControler" method="post">
<label>User Name:</label>
<input type="text" name="userName"><br>
 <label>Password:</label>
 <input type="password" name="password"><br> 
 <input type="submit">
</form> <%if(request.getAttribute("error")!=null)
{ 
%> <p><%=request.getAttribute("error") %></p> 
<%}
%>
</body>
</html>
******************************************************************************************
home.jsp

package controler;
import java.io.IOException;
import com.mysql.cj.Session;
import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import jakarta.servlet.http.HttpSession;
import model.User;
public class UserControler extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
String userName=request.getParameter("userName"); 
String password=request.getParameter("password");
User user=new User(); 
user.setUserName(userName);
user.setPassword(password);
if(user.isValid()) {
HttpSession session=request.getSession(); 
session.setAttribute("userName", userName); 
response.sendRedirect("home.jsp");
}
else
{ 
	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	request.setAttribute("error","Username or password is rd.forward(request, response");
	rd.forward(request, response);
}
}
}
******************************************************************************************
user.java

package mvc;


public class User {
String userName;
String Password;
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName; 
}
public String getPassword() {
return Password;
}
public void setPassword(String password) {
Password = password;
}
public boolean isValid() {
if(userName.equals("root")&&Password.equals("740654sk")) {

return true;
}
else
{
return false;
} 
}
}
******************************************************************************************
userControler.java
package controler;
import java.io.IOException;
import com.mysql.cj.Session;
import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import jakarta.servlet.http.HttpSession;
import model.User;
public class UserControler extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
String userName=request.getParameter("userName"); 
String password=request.getParameter("password");
User user=new User(); 
user.setUserName(userName);
user.setPassword(password);
if(user.isValid()) {
HttpSession session=request.getSession(); 
session.setAttribute("userName", userName); 
response.sendRedirect("home.jsp");
}
else
{ 
	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	request.setAttribute("error","Username or password is rd.forward(request, response");
	rd.forward(request, response);
}
}
}
******************************************************************************************
logout.java

package controler;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest; import jakarta.servlet.http.HttpServletResponse; import jakarta.servlet.http.HttpSession;
public class Logout extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession(); session.removeAttribute("userName"); response.sendRedirect("index.jsp");} }
******************************************************************************************
web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
<display-name>DemoMVC</display-name> <welcome-file-list>
<welcome-file>index.html</welcome-file> <welcome-file>index.jsp</welcome-file> <welcome-file>index.htm</welcome-file> <welcome-file>default.html</welcome-file>
<welcome-file>default.jsp</welcome-file>
<welcome-file>default.htm</welcome-file> </welcome-file-list>
<servlet>
<servlet-name>UserControler</servlet-name> <servlet-class>controler.UserControler</servlet-class> </servlet>
<servlet-mapping> <servlet-name>UserControler</servlet-name> <url-pattern>/UserControler</url-pattern> </servlet-mapping>
<servlet>
<servlet-name>Logout</servlet-name> <servlet-class>controler.Logout</servlet-class> </servlet>
<servlet-mapping> <servlet-name>Logout</servlet-name> <url-pattern>/Logout</url-pattern> </servlet-mapping>
</web-app>

******************************************************************************************
******************************************************************************************
everything in dynamic web project
