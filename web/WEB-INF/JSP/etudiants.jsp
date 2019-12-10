<%@ page import="classes.Etudiant" %><%--
  Created by IntelliJ IDEA.
  User: sophie
  Date: 25/11/2019
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listeEtudiants" type="java.util.ArrayList<classes.Etudiant>" scope="request"/>

<html>
  <head>
    <title><%= application.getInitParameter("title")%></title>
  </head>
<%--  FAire ici la liste des étudiants
on peut le faire sous forme de table et mettre les <tr> dans le for--%>



  <body>
  <h1>Liste des étudiants</h1>
  <ul>
  <%

    for (Etudiant etudiant : listeEtudiants){ %>

    <a href="<%=application.getContextPath()%>/do/details?id=<%=etudiant.getId()%>"><%=etudiant.getNom() %>  <%=etudiant.getId() %></a>
    <p> </p>
    <%}%>

  </ul>




  </body>
</html>
