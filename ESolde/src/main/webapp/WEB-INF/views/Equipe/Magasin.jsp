<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="head.jsp"%>
<!-- DataTables CSS -->
<link
	href="<c:url value='/resources/Dashboard/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css' />"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<c:url value='/resources/Dashboard/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet' />">



</head>

<body bgcolor="#ffffff" text="#000000" link="#0000ff" vlink="#800080"
	alink="#ff0000" onload="fillCategory();">

	<div id="wrapper">

		<!-- Navigation -->
		<jsp:include page="header.jsp" />
		<!-- Navigation -->

		<div id="page-wrapper">


			<div class="row">
				<div class="col-lg-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-heading"> Magasins</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>Slogan</th>
											<th>Direction</th>
											<th>Frome juridique</th>
											<th>Chiffre affaire</th>
											<th>Date creation</th>
											<th>Nombre de filiales</th>
											<th>Logo</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${magasin}" var="cat">
											<fmt:parseDate pattern="yyyy-MM-dd"
												value="${cat.getDate_creation()}" var="parsedDateD" />
											<fmt:formatDate value="${parsedDateD}" pattern="yyyy-MM-dd"
												var="DateD" />
											<tr class="odd gradeX">
												<td>${cat.getSlogan()}</td>
												<td>${cat.getDirection()}</td>
												<td>${cat.getFrome_juridique()}</td>
												<td>${cat.getChiffre_affaire()}</td>
												<td>${DateD}</td>
												<td>${cat.filialecount()}</td>
												<td><a href="photoMag?idMag=${cat.getId_Magasin()}">
														<button class="btn btn-success btn-circle">
															<i class="glyphicon glyphicon-picture"></i>
														</button>
												</a></td>

											</tr>

										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->

						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->

					<!-- /.panel -->

					<!-- /.panel -->
				</div>

			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<%@include file="footer.jsp"%>
	<!-- DataTables JavaScript -->
	<script
		src="<c:url value='/resources/Dashboard/bower_components/jquery/dist/jquery.min.js' />"></script>

	<script
		src="<c:url value='/resources/Dashboard/bower_components/datatables/media/js/jquery.dataTables.min.js' />"></script>
	<script
		src="<c:url value='/resources/Dashboard/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js' />"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
</body>
</html>
