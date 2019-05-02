<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="<c:url value="/"/>">SmartDiaper</a>
		<!-- <button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button> -->
		<!-- <div class="collapse navbar-collapse" id="navbarCollapse"> -->
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="<c:url value="/"/>">Home<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/allPatients"/>">Patients</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/allHistory"/>">History</a></li>
			</ul>
		<!-- </div> -->
	</nav>
</header>