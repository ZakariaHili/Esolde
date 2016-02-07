<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<%
// open the database connection and get the ResultSet
// according to your itemname
 // take example 
// ResultSet rs=select pname from product where itemname='"+request.getParameter(itemname)+"' ;
%>
 <select  name="pname">
<%   while(rs.next())
   { %>
    <option value="<%=rs.getString(1)%>">"<%=rs.getString(1)%>"</option>
   
 <%  } %>
 </select>
 
 
     
%>
</body>
</html>