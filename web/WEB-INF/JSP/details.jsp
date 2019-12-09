<%@ page import="classes.Etudiant" %>
<%@ page import="classes.GestionFactory" %><%--
  Created by IntelliJ IDEA.
  User: sophie
  Date: 25/11/2019
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="etudiant" class="classes.Etudiant" scope="request"/>
<jsp:useBean id="absence" type="java.lang.Integer" scope="request"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
/*    //Récupération id
    int id = Integer.parseInt(request.getParameter("id"));
    //Récupération étudiant
    Etudiant etudiant = GestionFactory.getEtudiantById(id);*/

%>
<%-- Affichage des détails de l'étudiant--%>
<p>Détails de l'étudiant</p>
<p>ID de l'étudiant : <%= etudiant.getId()%></p>
<p>Nom de l'étudiant : <%= etudiant.getNom()%></p>
<p>Prénom de l'étudiant : <%= etudiant.getPrenom()%></p>
<p>Nombre d'absences de l'étudiant : <%= absence.intValue()%></p>



</body>
</html>
