<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1">
					<div class="table100-firstcol">
						<table>
							<thead>
								<tr class="row30 head">
									<th class="cell100 column1">사건번호</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var=history items="${allHistory}">
									<tr class="row100 body">
										<td class="cell30 column1">${history.id}</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>

					<div class="wrap-table100-nextcols js-pscroll">
						<div class="table100-nextcols">
							<table>
								<thead>
									<tr class="row30 head">
										<th class="cell100 column2">ID</th>
										<th class="cell100 column3">이름</th>
										<th class="cell100 column4">호실</th>
										<th class="cell100 column5">발생시간</th>
										<th class="cell100 column6">사건 종류</th>
										<th class="cell100 column7">상세보기</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var=history items="${allHistory}">
										<tr class="row30 body">
											<td class="cell100 column2">${ history.sid }</td>
											<td class="cell100 column3">${ history.name}</td>
											<td class="cell100 column4">${ history.room}</td>
											<td class="cell100 column5">${ history.time}</td>
											<td class="cell100 column6">${ history.signal}</td>
											<td class="cell100 column7"><a
												href="<c:url value="/history/${history.sid}" />"> <i
													class="fa fa-info-circle"></i>
											</a></td>
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


	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll')
				.each(
						function() {
							var ps = new PerfectScrollbar(this);

							$(window).on('resize', function() {
								ps.update();
							})

							$(this)
									.on(
											'ps-x-reach-start',
											function() {
												$(this)
														.parent()
														.find(
																'.table100-firstcol')
														.removeClass(
																'shadow-table100-firstcol');
											});

							$(this).on(
									'ps-scroll-x',
									function() {
										$(this).parent().find(
												'.table100-firstcol').addClass(
												'shadow-table100-firstcol');
									});

						});
	</script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>
