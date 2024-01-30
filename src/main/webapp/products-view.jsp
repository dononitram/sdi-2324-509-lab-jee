<%@ page import="java.util.List" %>
<%@ page import="com.uniovi.sdi.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>Servlets</title>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"
            type="application/javascript"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            type="application/javascript"></script>
</head>
<body>

<!-- Contenido -->
<div class="container" id="main-container">
    <h2>Lista de productos</h2>
    <ul>
        <c:forEach var="item" items="${storeProducts}">
            <tr>
                <li> ${item.getName()} </li>
            </tr>
        </c:forEach>
    </ul>
    <a href="index.jsp">Volver</a>
</div>
</body>
</html>