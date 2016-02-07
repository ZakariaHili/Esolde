<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="head.jsp"%>


</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<jsp:include page="header.jsp" />
		<!-- Navigation -->

		<div id="page-wrapper">


			<div class="row">
				<div class="col-lg-8 col-sm-offset-2">
					<div class="panel panel-default ">
						<div class="panel-heading">Mon Compte</div>
						<!-- /.panel-heading -->
						<div class="">


							<div class="container">
								<div class="col-sm-12 col-md-pull-1">

									<f:form class="form-horizontal" role="form" action="SaveCompte"
										enctype="multipart/form-data">
										<div class="col-sm-offset-3 ">
											<f:errors path="Login"></f:errors>
											<f:errors path="Date_Naissance"></f:errors>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-3" for="text">Nom:</label>
											<div class="input-group col-md-3">
												<input type="text" class="form-control col-sm-3" id="text"
													name="Nom" placeholder="${Representant.getNom() }"
													disabled="disabled">
											</div>
										</div>
										<div class="form-group">

											<label class="control-label col-sm-3" for="text">Prenom:</label>
											<div class="input-group col-md-3">
												<input type="text" class="form-control col-sm-3" id="text"
													name="Prenom" placeholder="${Representant.getPrenom() }"
													disabled="disabled">
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-3" for="text">Login:</label>
											<div class="input-group col-md-3">
												<input type="text" class="form-control col-sm-3" id="text"
													name="Login" placeholder="${Representant.getLogin() }" >
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-3" for="text">Password:</label>
											<div class="input-group col-md-3">
												<input type="Password" class="form-control col-sm-3" id="Password"
													name="Password"
													placeholder="********">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-3" for="text">Email:</label>
											<div class="input-group col-md-3">
												<input type="Email" class="form-control col-sm-3" id="Email"
													name="Email"
													placeholder="${Representant.getEmail() }">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-3" for="text">Date de Naissance:</label>
											<div class="input-group col-md-3">
												<input type="date" class="form-control col-sm-3" id="date"
													name="Date_Naissance"
													placeholder="${Representant.getDate_Naissance() }">
											</div>
										</div>


										<div class="form-group">
											<div class="col-sm-offset-3 ">
												<button type="submit" class="btn btn-default">Enregistrer</button>
											</div>
										</div>
									</f:form>
								</div>
							</div>
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
</body>
</html>
