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
				<div class="col-lg-12 col-md-pull-0">
					<div class="panel panel-default">
						<div class="panel-heading">Mes Promotions</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>Marque</th>
											<th>Categorie</th>
											<th>Description</th>
											<th>Date Début</th>
											<th>Date Fin</th>
											<th>Prix Original</th>
											<th>Prix Solde</th>
											<th>Pourcentage</th>
											<th>Image</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${promotion}" var="prod">
											<fmt:parseNumber var="intValue" integerOnly="true"
												type="number" value="${prod.getProcentage()*100}" />
												
												<fmt:parseDate pattern="yyyy-MM-dd" value="${prod.getDate_Fin_Promotion()}" var="parsedDateFin" />
												<fmt:formatDate value="${parsedDateFin}" pattern="yyyy-MM-dd" var="DateFin"/>
												<fmt:parseDate pattern="yyyy-MM-dd" value="${prod.getDate_debut_promotion()}" var="parsedDateD" />
												<fmt:formatDate value="${parsedDateD}" pattern="yyyy-MM-dd" var="DateD"/>
											<tr class="odd gradeX">
												<td>${prod.produits.getMarque()}</td>
												<td>${prod.produits.categorie.getDescription_categorie()}</td>
												<td>${prod.produits.getDescription()}</td>
												<td>${DateD}</td>
												<td>${DateFin}</td>
												<td>${prod.getPrix_original()} DH</td>
												<td>${prod.getPrix_Solde()} DH</td>
												<td>${intValue}%</td>
												<td class="center"><a
													href="photoProd?idProdt=${prod.produits.getId_Produit()}">
														<button class="btn btn-success btn-circle ">
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


	<jsp:include page="footer.jsp" />
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
                responsive: true
        });
    });
    </script>
</body>
</html>
