<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">
	<div class="container">
		<h1>${patient.name} 환자 정보 수정</h1>

		<sf:form
			action="${pageContext.request.contextPath}/updatePatient"
			method="post" modelAttribute="patient">

			<sf:hidden path="sid" />

			<div class="form-group">
				<label for="name">환자명</label>
				<sf:input path="name" id="name" class="form-control" />
			</div>

			<div class="form-group">
				<label for="room">병실</label>
				<sf:input path="room" id="room" class="form-control" />
			</div>

			<input type="submit" value="수정" class="btn btn-default">
			
			<a href="<c:url value="/allPatients" />"
				class="btn btn-default">취소하기</a>
				
			<a class="btn btn-secondary" href="${pageContext.request.contextPath}/deletePatient/${patient.sid}" 
						role="button" fill="#777">환자 삭제 &raquo;</a>
		</sf:form>
		<br />
	</div>
</div>
