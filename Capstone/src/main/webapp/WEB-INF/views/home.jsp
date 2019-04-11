<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container-wrapper">
	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<c:forEach var="roomNumber" items="${rooms }">
				<div class="col-lg-4">
					<svg class="bd-placeholder-img rounded-circle" width="140"
						height="140" xmlns="http://www.w3.org/2000/svg"
						preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
						aria-label="Placeholder: 140x140">
						<c:choose>
							<c:when test="${roomNumber.needChange eq '0' }">
								<rect width="100%" height="100%" fill="#0000ff" />
           					 	</svg>
							</c:when>
							<c:when test="${roomNumber.needChange eq '1' }">
								<rect width="100%" height="100%" fill="#ff0000" />
								</svg>
							</c:when>
					</c:choose>

					<h2>${roomNumber.roomNumber }호</h2>
					<p>
						<a class="btn btn-secondary" href="#" role="button" fill="#777">상세보기 &raquo;</a>
					</p>
				</div>
			</c:forEach>
		</div>
		<!-- /.row -->
	</div>
</div>
