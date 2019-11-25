<%@ page import="Classes.Etudiant" %>
<%@ page import="Classes.GestionFactory" %><%--
  Created by IntelliJ IDEA.
  User: sophie
  Date: 25/11/2019
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% int id = Integer.parseInt(request.getParameter("id"));
    Etudiant etudiant = GestionFactory.getEtudiantById(id);

%>

<p>Nom de l'étudiant : <% etudiant.getNom(); %></p>



</body>
</html>
    