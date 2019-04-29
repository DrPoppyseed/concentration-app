<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form method="POST" action="/add-item.do">
		Name of item: &nbsp; <input type="text" name="item_name" /><br>
		Description of item: &nbsp; <input type="text" name="item_description" /><br>
		Category of item: &nbsp; <input type="text" name="item_category" /><br>
		<input name="Add" type="submit" />
	</form>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>