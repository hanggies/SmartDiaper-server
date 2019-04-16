<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<META HTTP-EQUIV="refresh" CONTENT="5">
<!-- 
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600'
	rel='stylesheet' type='text/css' /> -->

<link href="<c:url value="/resources/css/patients.css"/>" rel="stylesheet">
	

<div class="container-wrapper">

	<div class="container marketing">
		<c:if test="${not empty roomNumber}">
			<h2>${roomNumber}호</h2>
		</c:if>
		<c:if test="${empty roomNumber}">
			<h2>
				Patients <a class="btn btn-secondary"
					href="${pageContext.request.contextPath}/addPatient" role="button"
					fill="#777">환자 추가 &raquo;</a>
			</h2>
		</c:if>

		<div class="row">
			<c:forEach var="patient" items="${patients }">
				<div class="col-sm-4">
					<div class=".box">
						<c:choose>
							<c:when test="${patient.needChange eq '0' }">
								<br>
								<br>
									<c:if test="${not empty roomNumber}">
										<div class="box blue">
										<h3 class="title">${patient.name }</h3>
										<c:if test="${empty roomNumber}"> <br>
											<p>병실 : ${patient.room}호</p> 
										</c:if>
										<p>기저귀 : 정상</p>
										<p></p>
										</div>
									</c:if>
								<c:if test="${empty roomNumber}">
									<a
										href="${pageContext.request.contextPath}/updatePatient/${patient.sid }"
										class="box blue">
										<h3 class="title">${patient.name }</h3> <c:if
											test="${empty roomNumber}"> <br>
											<p>병실 : ${patient.room}호</p>
										</c:if>
										<p>기저귀 : 정상</p>
										<p></p>
									</a>
								</c:if>
							</c:when>

							<c:when test="${patient.needChange eq '1' }">
								<br>
								<br>
								
									<c:if test="${not empty roomNumber}">
										<div class="box red">
											<h3 class="title">${patient.name }</h3>
											<c:if test="${empty roomNumber}">
												<p>병실 : ${patient.room}호</p>
											</c:if>
											<p>기저귀 : 교체요망</p>
											<p>
												시간 :
												<!-- 측정된 시간 넣어야 한다-->
												${currentTime}
											</p>
										</div>	
									</c:if>
								<c:if test="${empty roomNumber}">
									<a
										href="${pageContext.request.contextPath}/updatePatient/${patient.sid }"
										class="box red">
										<h3 class="title">${patient.name }</h3> <c:if
											test="${empty roomNumber}">
											<p>병실 : ${patient.room}호</p>
										</c:if>
										<p>기저귀 : 교체요망</p>
										<p>
											시간 :
											<!-- 측정된 시간 넣어야 한다-->
											${currentTime}
										</p>
									</a>
								</c:if>
							</c:when>
						</c:choose>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
	<!-- <div class="col-sm-4">
        <a href="http://www.ubh.com" class="tile purple">
          <h3 class="title">Purple Tile</h3>
          <p>Short, sweet data point goes here.</p>
        </a>
    </div> -->

	<!-- <svg class="bd-placeholder-img rounded-circle" width="140"
			height="140" xmlns="http://www.w3.org/2000/svg"
			preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
			aria-label="Placeholder: 140x140">
			<rect width="100%" height="100%" fill="#0000ff" />
        </svg> -->




</div>

