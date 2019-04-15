<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">
	<div class="container">
		<h1>환자 추가</h1>
		<p class="lead">입원 환자 정보 입력</p>

		<sf:form action="${pageContext.request.contextPath}/addPatient" method="post"
			modelAttribute="patient">

			<sf:hidden path="sid" />

			<div class="form-group">
				<label for="sid">환자 번호</label>
				<sf:input path="sid" id="sid" class="form-control" />
				<sf:errors path="sid" cssStyle="color:#ff0000;"></sf:errors>
			</div>

			<div class="form-group">
				<label for="name">환자명</label>
				<sf:input path="name" id="name" class="form-control" />
			</div>

			<div class="form-group">
				<label for="room">병실</label>
				<sf:input path="room" id="room" class="form-control" />
			</div>

			

			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="/admin/patientInventory" />"
				class="btn btn-default">Cancel</a>
		</sf:form>
		<br />
	</div>
</div>
