CREATE TABLE EMPLOYEE (ENO  INT, NAME VARCHAR(45) , GENDER VARCHAR(1), DEPARTMENT VARCHAR(45) DEFAULT NULL, SALARY INT,PRIMARY KEY (`ENO`))  

**********************************************************
 
index.html

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Insert title here</title> 
</head> 
<body> 
<form action="insertData.jsp" method="get"> 
<label>Employee Number:</label> 
<input type="text" name="eno"><br> 
<label>Employee Name:</label> 
<input type="text" name="ename"><br> 
<label>Employee Gender:</label> 
<input type="text" name="egender"><br> 
<label>Employee Department:</label> 
<input type="text" name="edept"><br> 
<label>Employee salary:</label> 
<input type="text" name="esalary"><br> 
<input type="submit"> 
</form> 
</body> 
</html> 
 *********************************************************
Step 3: Add external jar to classpath ( servlet-api.jar, mysql-connector-j-8.0.32.jar) 

*********************************************************
insertData.jsp
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html> 
<%@ page import = "java.io.*,java.util.*,java.sql.*"%> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Insert title here</title> 
</head> 
<body> 
<% 
int uq=0; 
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Password"); 
PreparedStatement pstatement = con.prepareStatement("INSERT INTO employee VALUES(?, ?, ?, ?, ?)"); 
pstatement.setInt(1, Integer.valueOf(request.getParameter("eno"))); 
pstatement.setString(2, request.getParameter("ename")); 
pstatement.setString(3, request.getParameter("egender")); 
pstatement.setString(4, request.getParameter("edept")); 
pstatement.setFloat(5, Integer.valueOf(request.getParameter("esalary"))); 
uq=pstatement.executeUpdate(); 
pstatement.close(); 
 
if(uq!=0) 
{ 
out.print("<h1>Data inserted sucessfully </h1>"); 
} 
Statement st = con.createStatement(); 
ResultSet rs = st.executeQuery("select * from employee"); 
%> 
<table> 
<tr> 
<th>ENO</th> 
<th>ENAME</th> 
<th>GENDER</th> 
<th>DEPARTMENT</th> 
<th>SALARY</th> 
</tr> 
<% 
while(rs.next()) 
{ 
%> 
<tr> 
<td><%=rs.getInt(1) %></td> 
<td><%=rs.getString(2)%></td> 
<td><%=rs.getString(3)%></td> 
<td><%=rs.getString(4)%></td> 
<td><%=rs.getInt(5) %></td> 
</tr> 
<% 
} 
%> 
</table> 
</body> 
</html> 
*********************************************************
*********************************************************
do everything in dyamic web project.
