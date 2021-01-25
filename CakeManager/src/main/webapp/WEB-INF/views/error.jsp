<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>


<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="Description" content="Allocation Information." />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="Distribution" content="internal" />
<meta name="Author" content="Sanjay" />

<link rel="stylesheet" href="css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap/bootstrap-responsive.css">
<link rel="stylesheet" href="css/bootstrap/bootstrap-responsive.min.css">
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">

<script src="js/jquery/jquery-3.3.1.slim.min.js"></script>
<script src="js/popper/popper.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/bootstrap/bootstrap.js"></script>

<title>Error Page</title>
</head>
<body>
<br></br>
<div class="container">
<div class="page-header">
		<h1>
			<center>Error <small> - Something was wrong!!</small></center>
		</h1>
	</div>
	<br></br>
<a href="${pageContext.request.contextPath}/" style="font-size:x-large;color:red;"><b>Click to get back to the previous page</b></a>
<br></br>
	
<center>
 <table>
        <tr>
            <td>Date</td>
            <td>${timestamp}</td>
        </tr>
        <tr>
            <td>Error</td>
            <td>${error}</td>
        </tr>
        <tr>
            <td>Status</td>
            <td>${status}</td>
        </tr>
        <tr>
            <td>Message</td>
            <td>${message}</td>
        </tr>
        <tr>
            <td>Cause</td>
            <td>${trace}</td>
        </tr>
       <!--   <tr>
            <td>Trace</td>
            <td>
                <pre>${trace}</pre>
            </td>
        </tr>-->
    </table>

  
</div>
</body>
</html>