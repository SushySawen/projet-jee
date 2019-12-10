<%@ page import="classes.Etudiant" %><%--
  Created by IntelliJ IDEA.
  User: sophie
  Date: 09/12/2019
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="etudiants" type="java.util.Collection<classes.Etudiant>" scope="request"/>
<jsp:useBean id="noteParEtu" type="java.util.HashMap<java.lang.Integer, java.lang.Integer>" scope="request"/>
<html>
<head>
    <title><%= application.getInitParameter("title")%></title>
</head>
<body>
<h1>Notes des étudiants</h1>
<table>
    <%
        for (Etudiant etudiant : etudiants){
            out.print("<tr>");
            out.print("<td>"+etudiant.getPrenom()+" "+etudiant.getNom()+"</td>");
            out.print("<td>"+noteParEtu.get(etudiant.getId())+"</td>");
            out.print("</tr>");
        }

    %>
</table>

</body>
</html>
