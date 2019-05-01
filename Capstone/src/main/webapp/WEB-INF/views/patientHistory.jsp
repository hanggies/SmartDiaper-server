<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<div class="container-wrapper">
	<div class="container">
		<h2>${patientName } 환자 History</h2>
		<p>History that patients received service</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-success">
					<th>사건 번호</th>
					<th>ID</th>
					<th>이름</th>
					<th>호실</th>
					<th>발생 시간</th>
					<th>사건 종류</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="history" items="${allHistory }">
					<tr>
						<td>${history.id }</td>
						<td>${history.sid }</td>
						<td>${history.name }</td>
						<td>${history.room }</td>
						<td>${history.time }</td>
						<td>${history.signal }</td>
						

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

