<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>hanggies</title>

<!-- Bootstrap core CSS -->

<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" crossorigin="anonymous">

<!--<link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">-->
<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>

	<div>
		<tiles:insertAttribute name="menu" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>

	<script src="<c:url value="/resources/css/bootstrap.min.css"/>"
		integrity="sha256-O+tIQpqELVwzC5tMwKUYZS4eyhYSH0C9wdTEHk/xoIw="
		crossorigin="anonymous"></script>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"
		integrity="sha256-XZfkOGd6FuhF88h5GgEmRIpXbm+hBkFo74yYDPY5rbw="
		crossorigin="anonymous"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->

</body>
</html>
