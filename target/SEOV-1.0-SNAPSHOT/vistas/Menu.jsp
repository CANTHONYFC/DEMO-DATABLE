<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="es-PE">
	<head>

		<%
			//Billy Larru
			response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
			response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
			response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
			response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
		%>
		<%
			HttpSession session_actual = request.getSession();

			if (session_actual.getAttribute("dni") != null) {

			} else {
				response.sendRedirect("../vistas/index.jsp");
			}

		%>	
		<%@include file="templates/header.jsp" %>
		<style>
			.resaltar{background-color:#FF0;}
		</style> 
	</head>
	<body>
		<%@include file="templates/header-body.jsp" %>




		<%@include file="templates/footer-body.jsp"%>
		
		<script src="../js/pages/general.js" type="text/javascript"></script>
	</body>
</html>
