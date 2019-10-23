<%-- 
    Document   : close
    Created on : 02/12/2014, 10:25:52 AM
    Author     : evicente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true"%>

<%
HttpSession session_actual = request.getSession(true);
session_actual.invalidate();
response.sendRedirect("index.jsp");
%>
