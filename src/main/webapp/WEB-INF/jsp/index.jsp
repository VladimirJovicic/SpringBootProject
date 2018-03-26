<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vladimir Jovicic</title>
<script>
$(document).ready(
		function() {
			$.ajax({
				url : "http://localhost:1234/api/index/getMeals"
			}).then(
					function(data) {
						alert("asd");
						for (i = 0; i < data.length; i++) {
							newRow = 
								"<tr>"
									+ "<td>" + data[i].date + "</td>"
									+ "<td>" + data[i].time + "</td>"
									+ "<td>" + data[i].description + "</td>"
									+ "<td>" + data[i].calories + "</td>"
								+ "</tr>"
							$("#dataTable").append(newRow)
							
						}
					});
});
</script>
</head>
<body>
<table id="dataTable">
<tr>
	<th>Date</th>
	<th>Time</th>
	<th>Description</th>
	<th>Calories</th>
</tr>
</table>


<table>
	<tr>
		<td>
			Select date:
		</td>
		<td>
			<input type = "text">
		</td>
	</tr>
	<tr>
		<td>
			Select time:
		</td>
		<td>
			<input type = "text">
		</td>
	</tr>
	
	<tr>
		<td>
			Insert description:
		</td>
		<td>
			<textarea ></textarea>
		</td>
		
		<td>
			<input type ="checkbox"> Disable<br>
		</td>
	</tr>
	
	<tr>
		<td>
			Insert calories:
		</td>
	<td>
			<input type = "text">
		</td>
	</tr>
	
	<tr>	
		<td colspan="2" align="center">
			<input type = "submit" value = "Add meal">
		</td>
	</tr>
</table>
</body>
</html>