<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/vendor/animate/animate.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/vendor/select2/select2.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/vendor/perfect-scrollbar/perfect-scrollbar.css"/>"
	rel="stylesheet">
<link 
	rel="stylesheet"
	href="<c:url value="/resources/css/util.css"/>" >


<div class="container-wrapper">
	<div class="container">
		<h2>${patientName } 환자 History</h2>
		<p>History that patients received service</p>
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1">
					<div class="table100-firstcol">
						<table>
							<thead>
								<tr class="row100 head" bgcolor="#e5e7e9">
									<th class="cell100 column1">이름</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="history" items="${allHistory}">
									<tr class="row100 body">
										<td class="cell30 column1">${history.name}</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>

					<div class="wrap-table100-nextcols js-pscroll">
						<div class="table100-nextcols">
							<table>
								<thead>
									<tr class="row30 head" bgcolor="#e5e7e9">
										<th class="cell100 column2">호실</th>
										<th class="cell100 column3">발생시간</th>
										<th class="cell100 column4">사건 종류</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="history" items="${allHistory}">
										<tr class="row30 body">
											<td class="cell30 column2">${history.room}</td>									
											<td class="cell100 column3">${ history.time}</td>
											<td class="cell100 column4">${ history.signal}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!--===============================================================================================-->
<script
	src="<c:url value="/resources/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
<!--===============================================================================================-->
<script src="<c:url value="/resources/vendor/bootstrap/js/popper.js"/>"></script>
<script
	src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
<!--===============================================================================================-->
<script src="<c:url value="/resources/vendor/select2/select2.min.js"/>"></script>
<!--===============================================================================================-->
<script
	src="<c:url value="/resources/vendor/perfect-scrollbar/perfect-scrollbar.min.js"/>"></script>
<script>
	$('.js-pscroll').each(
			function() {
				var ps = new PerfectScrollbar(this);

				$(window).on('resize', function() {
					ps.update();
				})

				$(this).on(
						'ps-x-reach-start',
						function() {
							$(this).parent().find('.table100-firstcol')
									.removeClass('shadow-table100-firstcol');
						});

				$(this).on(
						'ps-scroll-x',
						function() {
							$(this).parent().find('.table100-firstcol')
									.addClass('shadow-table100-firstcol');
						});

			});
</script>
<!--===============================================================================================-->
<script src="<c:url value="/resources/js/main.js"/>"></script>

</body>
