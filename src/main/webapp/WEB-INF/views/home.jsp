<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	Your Must-dos are:
	<ol>
		<c:forEach items="${items_1}" var="item">
			<li>${item.itemName}<a href="/delete-item.do?item=${item}">Delete</a></li>
		</c:forEach>
	</ol>	
	Your Wantto-dos are:
	<ol>
		<c:forEach items="${items_2}" var="item">
			<li>${item.itemName}<a href="/delete-item.do?item=${item}">Delete</a></li>
		</c:forEach>
	</ol>
	
	<a href="/add-item.do">Add new Item</a>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>