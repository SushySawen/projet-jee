<%@ page import="Classes.Etudiant" %>
<%@ page import="Classes.GestionFactory" %><%--
  Created by IntelliJ IDEA.
  User: sophie
  Date: 25/11/2019
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
<%--  FAire ici la liste des étudiants
on peut le faire sous forme de table et mettre les <tr> dans le for--%>



  <body>

  <ul>
  <%

    for (Etudiant etudiant : GestionFactory.getEtudiants()){ %>

    <a href="details.jsp?id=<% etudiant.getId();%>"><%=etudiant.getNom() %>  <%=etudiant.getId() %></a>
    <p> </p>
    <%}%>

  </ul>



  $END$
  </body>
</html>
