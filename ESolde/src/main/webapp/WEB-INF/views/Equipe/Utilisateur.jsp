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
						<div class="panel-heading">Les utilisateurs</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>Nom</th>
											<th>Prenom</th>
											<th>Login</th>
											<th>Email</th>
											<th>Tel</th>
											<th>Activation</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${utilisateur}" var="prod">
											<fmt:parseDate pattern="yyyy-MM-dd"
												value="${prod.getDate_Naissance()}" var="parsedDateD" />
											<fmt:formatDate value="${parsedDateD}" pattern="yyyy-MM-dd"
												var="DateD" />
											<tr class="odd gradeX">
												<td>${prod.getNom()}</td>
												<td>${prod.getPrenom()}</td>
												<td>${prod.getLogin()}</td>
												<td>${prod.getEmail()}</td>
												<td>${DateD}</td>
												<td>${prod.isActivated()}</td>
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
