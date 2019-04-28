<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<title>Concentration</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	Hello!
	<div>
		<form action="/login.do" method="post">
			Username: <input type="text" name="username"/><br>
			Password: <input type="password" name="password"><br>
			<input type="submit" value="Login"/>
		</form>
 	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>

</html>
